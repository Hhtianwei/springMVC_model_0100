package com.tim.spring.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class MyUser extends User
{
	private String saltValue;

	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String saltValue)
	{
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.saltValue = saltValue;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 8136538469654187150L;

	public String getSaltValue()
	{
		return saltValue;
	}

	public void setSaltValue(String saltValue)
	{
		this.saltValue = saltValue;
	}

}
