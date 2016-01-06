package com.skyjoo.skyper.biz.user.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.common.base.BaseManager;
import com.skyjoo.skyper.biz.user.dao.UserDao;
import com.skyjoo.skyper.biz.user.domain.User;
@Service
public class UserManager extends BaseManager{
	@Autowired
	
	private UserDao  userDao;
	  public User login(String name) {
	
		  User user=userDao.login(name);
	        return user;
	    }
}
