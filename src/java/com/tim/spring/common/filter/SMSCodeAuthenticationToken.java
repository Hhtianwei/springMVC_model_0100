package com.tim.spring.common.filter;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;


public class SMSCodeAuthenticationToken extends AbstractAuthenticationToken
{

	private final Object principal;

	public SMSCodeAuthenticationToken(String mobile)
	{
		super(null);
		this.principal = mobile;
		setAuthenticated(false);
	}


	public SMSCodeAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities)
	{
		super(authorities);
		this.principal = principal;
		super.setAuthenticated(true);
	}

	public Object getPrincipal()
	{
		return principal;
	}

	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException
	{
		if (isAuthenticated)
		{
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		}
		else
		{
			super.setAuthenticated(false);
			return;
		}
	}

	public void eraseCredentials()
	{
		super.eraseCredentials();
	}

	@Override
	public Object getCredentials()
	{
		return null;
	}


}
