package com.tim.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class UserModel
{
	private int id;
	private String name;
	private int age;
	private String mobile;
	private Date birthday;
	private String saltValue;
	private String password;

	public void setId(int id)
	{
		this.id = id;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId()
	{
		return id;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8136538469654187150L;

	@Column(name = "saltValue", unique = false, nullable = false)
	public String getSaltValue()
	{
		return saltValue;
	}

	public void setSaltValue(String saltValue)
	{
		this.saltValue = saltValue;
	}

	@Column(name = "age", unique = false, nullable = true)
	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Column(name = "mobile", unique = false, nullable = true)
	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	@Column(name = "birthday", unique = false, nullable = true)
	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	@Column(name = "username", unique = false, nullable = false)
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "password", unique = false, nullable = true)
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
