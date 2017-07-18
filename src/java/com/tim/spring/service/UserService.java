package com.tim.spring.service;

import java.util.List;

import com.tim.spring.model.UserModel;


public interface UserService
{
	void save(UserModel user);

	List<UserModel> findAllUser();

}
