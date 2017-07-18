package com.tim.spring.dao;

import java.util.List;

import com.tim.spring.model.UserModel;


public interface UserDao
{
	void save(UserModel user);

	List<UserModel> findAll();
}
