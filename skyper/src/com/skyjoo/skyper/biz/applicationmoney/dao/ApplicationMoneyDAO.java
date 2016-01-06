package com.skyjoo.skyper.biz.applicationmoney.dao;

import java.util.*;

import com.skyjoo.skyper.biz.applicationmoney.domain.ApplicationMoney;
import com.skyjoo.skyper.biz.common.page.Paginable;


/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */


import java.util.List; 


public interface ApplicationMoneyDAO {
	 
   public void insert(ApplicationMoney record);
 
   public int updateByPrimaryKey(ApplicationMoney record);
    
   public int updateByPrimaryKeySelective(ApplicationMoney record);
 
   public  ApplicationMoney selectByPrimaryKey(Long id);
 
   public int deleteByPrimaryKey(Long id);
    
    public List<ApplicationMoney> execSql(String sql);
    
    public int deleteByWhere(String swhere);
    
    public Object selectObject(String sql);

    public int count(String strWhere);

	public Paginable<ApplicationMoney> getPaginatedApplicationMoney(
			Paginable<ApplicationMoney> page);

}
