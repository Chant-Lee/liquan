package com.skyjoo.skyper.biz.user.dao;


import com.skyjoo.skyper.biz.user.domain.User;



public interface UserDao{
	public User login(String name);
}
