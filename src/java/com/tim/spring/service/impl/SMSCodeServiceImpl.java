package com.tim.spring.service.impl;

import org.apache.commons.lang.RandomStringUtils;

import com.tim.spring.service.SMSCodeService;


public class SMSCodeServiceImpl implements SMSCodeService
{

	private static final char[] CHARS =
	{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	private int codeLength = 4;


	@Override
	public String generatorNum()
	{
		String randomString = RandomStringUtils.randomNumeric(this.getCodeLength());
		return randomString;
	}

	@Override
	public String generatorNum(int count)
	{
		String randomString = RandomStringUtils.randomNumeric(count);
		return randomString;
	}

	@Override
	public String generatorString()
	{
		String randomString = RandomStringUtils.random(this.getCodeLength(), CHARS);
		System.out.println("randomString:" + randomString);
		return randomString;
	}

	@Override
	public String generatorString(int count)
	{
		String randomString = RandomStringUtils.random(count, CHARS);
		return randomString;
	}

	public static void main(String[] args)
	{
		SMSCodeServiceImpl impl = new SMSCodeServiceImpl();

		System.out.println(impl.generatorString(7));
	}

	public int getCodeLength()
	{
		return codeLength;
	}

	public void setCodeLength(int codeLength)
	{
		this.codeLength = codeLength;
	}


}
