package com.skyjoo.skyper.biz.user.dao.ibatis;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.common.base.BaseDaoiBatis;
import com.skyjoo.skyper.biz.user.dao.UserDao;
import com.skyjoo.skyper.biz.user.domain.User;


@Repository


public class UserDaoImpl extends BaseDaoiBatis implements UserDao{


	@SuppressWarnings("deprecation")
	public User login(String account) {
		
		System.out.println("aa");
		   return (User) this.getSqlMapClientTemplate().queryForObject("USER.getUser",account);
		
	}

}
