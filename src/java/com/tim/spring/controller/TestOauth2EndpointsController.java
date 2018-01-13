package com.tim.spring.controller;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestOauth2EndpointsController
{

	private final Logger LOG = Logger.getLogger(getClass());

	//没有被过滤
	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable String id)
	{
		//for debug
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		LOG.info("product authentication is :" + ReflectionToStringBuilder.toString(authentication));
		return "product id : " + id;
	}

	//需要权限
	@GetMapping("/order/{id}")
	public String getOrder(@PathVariable String id)
	{
		//for debug
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		LOG.info("getOrder authentication is :" + ReflectionToStringBuilder.toString(authentication));
		return "order id : " + id;
	}

}
