package com.tim.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tim.spring.service.SMSCodeService;


@Controller
@RequestMapping("/createSMScode")
public class SMScodeGeneratorController
{

	private static final String SMSCODE = "smsCode";

	@Autowired
	private SMSCodeService smsCodeService;

	@RequestMapping
	@ResponseBody
	public void displayProperties(HttpSession session)
	{
		String smsCode = smsCodeService.generatorNum();
		session.setAttribute(SMSCODE, smsCode);
		System.out.println("smsCode:" + smsCode);
	}
}
