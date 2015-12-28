package com.skyjoo.skyper.biz.staff.dao;

import java.util.*;
  
 


/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */


import java.util.List; 

import org.springframework.stereotype.Repository;

import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.staff.domain.Staff;


public interface StaffDAO {
	
	 
   public  void insert(Staff record);
 
   public int updateByPrimaryKey(Staff record);
    
   public int updateByPrimaryKeySelective(Staff record);
 
   public Staff selectByPrimaryKey(Long id);
 
   public int deleteByPrimaryKey(Long id);
    
   public List<Staff> execSql(String sql);
    
   public int deleteByWhere(String swhere);
    
    public Object selectObject(String sql);

    public int count(String strWhere);

	public Paginable<Staff> getPaginatedStaff(Paginable<Staff> page);

	public Paginable<Staff> getPaginatedStaffBir(Paginable<Staff> page);

	public Paginable<Staff> getPaginatedStaffBirM(Paginable<Staff> page);



}
