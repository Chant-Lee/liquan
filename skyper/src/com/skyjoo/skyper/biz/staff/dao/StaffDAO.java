package com.skyjoo.skyper.biz.staff.dao;

  
 


import java.util.List; 


import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.staff.domain.Staff;


public interface StaffDAO {
	
	 
   public  void insert(Staff record);
 
   public int updateByPrimaryKey(Staff record);
    
   public int updateByPrimaryKeySelective(Staff record);
 
   public Staff selectByPrimaryKey(String id);
 
   public int deleteByPrimaryKey(String id);
    
   public List<Staff> execSql(String sql);
    
   public int deleteByWhere(String swhere);
    
    public Object selectObject(String sql);

    public int count(String strWhere);

	public Paginable<Staff> getPaginatedStaff(Paginable<Staff> page);

	public Paginable<Staff> getPaginatedStaffBir(Paginable<Staff> page);

	public Paginable<Staff> getPaginatedStaffBirM(Paginable<Staff> page);



}
