package com.devsuperior.dscommerce.projection;

public interface UserDetailsProjection {

	String getEmail();
	String getPassword();
	Long getRoleId();
	String getAuthority();
}
