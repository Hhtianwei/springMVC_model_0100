package com.tim.spring.dao.impl;

import java.util.List;

import com.tim.spring.common.dao.CommonDAO;
import com.tim.spring.dao.UserDao;
import com.tim.spring.data.Pagination;
import com.tim.spring.data.SearchResult;
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

	public SearchResult<UserModel> findUserByPage(Pagination page)
	{
		String sql = "SELECT * FROM users";
		return commonDAO.search(sql, page, UserModel.class);
	}

	public void saveUsers(List<UserModel> list)
	{
		this.commonDAO.saveOrUpdateAllEntity(list);
	}

}
