package com.tim.spring.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.tim.spring.dao.UserDao;
import com.tim.spring.model.UserModel;
import com.tim.spring.service.UserService;


public class UserServiceImpl implements UserService
{
	private UserDao userDao;

	public void save(UserModel user)
	{
		System.out.println("save user");
	}

	public List<UserModel> findAllUser()
	{
		List<UserModel> list = userDao.findAll();
		if (CollectionUtils.isEmpty(list))
		{
			return null;
		}
		for (UserModel user : list)
		{
			System.out.println(user.getId() + "," + user.getName() + "," + user.getBirthday());
		}
		return list;
	}

	public UserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

}
