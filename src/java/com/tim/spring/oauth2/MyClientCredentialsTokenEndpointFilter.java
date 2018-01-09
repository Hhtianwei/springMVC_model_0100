package com.tim.spring.oauth2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;


public class MyClientCredentialsTokenEndpointFilter extends ClientCredentialsTokenEndpointFilter
{
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException
	{
		System.out.println("========start11111111111---------------==========");
		Authentication result = super.attemptAuthentication(request, response);
		System.out.println("========" + result + "==========");
		return result;
	}
}
