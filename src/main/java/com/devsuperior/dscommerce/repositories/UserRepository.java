package com.devsuperior.dscommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projection.UserDetailsProjection;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query(nativeQuery = true, value = "user.email AS username, user.password, tb_role.id, tb_role.authority "
			+ "FROM tb_user user "
			+ "INNER JOIN tb_user_role user_role ON user.id = user_role.id "
			+ "INNER JOIN tb_role role ON user_role.id = role.id "
			+ "WHERE user.email = :username")
	List<UserDetailsProjection> searchByEmail(String username);
}
