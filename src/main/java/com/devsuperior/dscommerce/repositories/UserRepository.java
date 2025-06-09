package com.devsuperior.dscommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projection.UserDetailsProjection;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query(nativeQuery = true, value = "SELECT u.email AS usermail, u.password, role.id AS RoleId, role.authority "
			+ "FROM tb_user u "
			+ "INNER JOIN tb_user_role user_role ON u.id = user_role.user_id "
			+ "INNER JOIN tb_role role ON user_role.role_id = role.id "
			+ "WHERE u.email = :username")
	List<UserDetailsProjection> searchByEmail(String username);
	
	Optional<User> findByEmail(String email);
}
	