package com.tim.spring.security.exception;

import org.springframework.security.core.AuthenticationException;


public class SMSErrorAuthenticationexception extends AuthenticationException
{

	public SMSErrorAuthenticationexception(String msg)
	{
		super(msg);
	}

}
