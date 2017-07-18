package com.tim.spring.dao.impl;

import java.util.List;

import com.tim.spring.common.dao.CommonDAO;
import com.tim.spring.dao.UserDao;
import com.tim.spring.model.UserModel;


public class UserDaoImpl implements UserDao
{
	private CommonDAO commonDAO;

	public void save(UserModel user)
	{
		System.out.println("save user at dao");
	}

	public List<UserModel> findAll()
	{
		return commonDAO.loadAllEntities(UserModel.class);
	}

	public CommonDAO getCommonDAO()
	{
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO)
	{
		this.commonDAO = commonDAO;
	}

}
