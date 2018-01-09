package com.tim.spring.oauth2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;


public class MyOAuth2AuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint
{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException
	{
		System.out.println("=====================MyOAuth2AuthenticationEntryPoint========commence==================");
		doHandle(request, response, authException);
	}

	@Override
	protected ResponseEntity enhanceResponse(ResponseEntity response, Exception exception)
	{
		System.out.println("---------------------MyOAuth2AuthenticationEntryPoint-----------ResponseEntity---------------------");
		ResponseEntity result = super.enhanceResponse(response, exception);
		return result;
	}
}
