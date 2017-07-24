package com.tim.spring.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.tim.spring.dao.UserDao;
import com.tim.spring.data.Pagination;
import com.tim.spring.data.SearchResult;
import com.tim.spring.model.UserModel;
import com.tim.spring.service.UserService;
import com.tim.spring.util.MD5Util;


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

	public SearchResult<UserModel> findUserByPagination(Pagination page)
	{
		SearchResult<UserModel> result = userDao.findUserByPage(page);
		return result;
	}

	public void addUsers(int count)
	{
		List<UserModel> list = new ArrayList<UserModel>();
		for (int i = 0; i < count; i++)
		{
			UserModel userModel = new UserModel();
			double r = Math.random() * (30 - 20 + 1) + 20;
			userModel.setAge((int) (r));
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userModel.setBirthday(new Date());
			String mobile = createMobile();
			userModel.setMobile(mobile);
			userModel.setName("tim-" + i);
			String saltValue = MD5Util.MD5("tim-" + i);
			userModel.setPassword(MD5Util.MD5(1 + "{" + saltValue + "}"));
			userModel.setSaltValue(saltValue);
			list.add(userModel);
		}
		userDao.saveUsers(list);
	}



	private String createMobile()
	{
		StringBuilder sb = new StringBuilder();
		while (sb.length() < 11)
		{
			if (sb.length() < 3)
			{
				sb.append("187");
			}
			sb.append((int) (Math.random() * 9) + 1);
		}
		return sb.toString();
	}


	public static void main(String[] args)
	{
		//[10-20]
		int i = 1000;
		while (i > 900)
		{
			double r = Math.random() * (20 - 10 + 1) + 10;
			//System.out.println((int) r);
			i--;
		}
		String s = MD5Util.MD5("1{E4774CDDA0793F86414E8B9140BB6DB4}");
	}
}
