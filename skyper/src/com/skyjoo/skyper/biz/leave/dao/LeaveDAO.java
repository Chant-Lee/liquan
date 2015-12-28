package com.skyjoo.skyper.biz.leave.dao;

import java.util.*;
  
 


/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */


import java.util.List; 

import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.leave.domain.Leave;


public interface LeaveDAO {
	 
   public  void insert(Leave record);
 
   public int updateByPrimaryKey(Leave record);
    
   public int updateByPrimaryKeySelective(Leave record);
 
   public  Leave selectByPrimaryKey(Long id);
 
   public int deleteByPrimaryKey(Long id);
    
    public List<Leave> execSql(String sql);
    
    public int deleteByWhere(String swhere);
    
    public Object selectObject(String sql);

    public int count(String strWhere);

	public Paginable<Leave> getPaginatedLeave(Paginable<Leave> page);

}
