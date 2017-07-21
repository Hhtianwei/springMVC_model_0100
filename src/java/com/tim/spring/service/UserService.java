package com.tim.spring.service;

import java.util.List;

import com.tim.spring.data.Pagination;
import com.tim.spring.data.SearchResult;
import com.tim.spring.model.UserModel;


public interface UserService
{
	void save(UserModel user);

	List<UserModel> findAllUser();

	SearchResult<UserModel> findUserByPagination(Pagination page);

	void addUsers(int parseInt);
}
