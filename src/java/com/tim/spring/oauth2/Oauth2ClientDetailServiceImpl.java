package com.tim.spring.oauth2;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;


public class Oauth2ClientDetailServiceImpl implements ClientDetailsService
{

	@Override
	public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException
	{
		System.out.println("ssssssssssssssssssssssssssss:" + s);
		return null;
	}

}
