package com.tim.spring.oauth2;

import java.util.Map;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;


public class MyDefaultOAuth2RequestFactory extends DefaultOAuth2RequestFactory
{

	public MyDefaultOAuth2RequestFactory(ClientDetailsService clientDetailsService)
	{
		super(clientDetailsService);
	}

	@Override
	public AuthorizationRequest createAuthorizationRequest(Map authorizationParameters)
	{
		AuthorizationRequest request = super.createAuthorizationRequest(authorizationParameters);
		return request;
	}
}
