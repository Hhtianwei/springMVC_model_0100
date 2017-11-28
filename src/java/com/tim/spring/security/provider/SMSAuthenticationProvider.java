package com.tim.spring.security.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.tim.spring.common.filter.SMSCodeAuthenticationToken;


public class SMSAuthenticationProvider implements AuthenticationProvider
{
	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		SMSCodeAuthenticationToken smsAuthentication = (SMSCodeAuthenticationToken) authentication;
		UserDetails user = userDetailsService.loadUserByUsername(smsAuthentication.getPrincipal().toString());
		SMSCodeAuthenticationToken authenticationResult = new SMSCodeAuthenticationToken(user, user.getAuthorities());
		return authenticationResult;
	}

	@Override
	public boolean supports(Class<?> class1)
	{
		return SMSCodeAuthenticationToken.class.isAssignableFrom(class1);
	}

	public UserDetailsService getUserDetailsService()
	{
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService)
	{
		this.userDetailsService = userDetailsService;
	}

}
