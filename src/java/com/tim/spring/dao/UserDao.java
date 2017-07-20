package com.tim.spring.dao;

import java.util.List;

import com.tim.spring.data.Pagination;
import com.tim.spring.data.SearchResult;
import com.tim.spring.model.UserModel;


public interface UserDao
{
	void save(UserModel user);

	List<UserModel> findAll();

	SearchResult<UserModel> findUserByPage(Pagination page);

	void saveUsers(List<UserModel> list);
}
