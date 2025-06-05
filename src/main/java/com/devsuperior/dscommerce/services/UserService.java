package com.devsuperior.dscommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.UserDTO;
import com.devsuperior.dscommerce.entities.Role;
import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projection.UserDetailsProjection;
import com.devsuperior.dscommerce.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserDetailsProjection> userProjection = repository.searchByEmail(username);
		
		if(userProjection.size() == 0) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		User user = new User();
		user.setEmail(username);
		user.setPassword(userProjection.get(0).getPassword());
		
		for(UserDetailsProjection obj : userProjection) {
			user.getAuthorities().add(new Role(obj.getRoleId(), obj.getAuthority()));
		}
		
		return user;
	}
	
	@Transactional(readOnly = true)
	public UserDTO getMe() {
		User user = authenticated();
		return new UserDTO(user);
	}

	protected User authenticated() {
		try {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		Jwt jwtPrincipal = (Jwt) authentication.getPrincipal(); 
		String username = jwtPrincipal.getClaim("username");

		return repository.findByEmail(username).get();
		} catch(Exception e) {
			throw new UsernameNotFoundException("Email não encontrado");
		}
	}
}
