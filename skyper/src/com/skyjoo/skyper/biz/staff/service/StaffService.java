package com.skyjoo.skyper.biz.staff.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.leave.domain.Leave;
import com.skyjoo.skyper.biz.staff.domain.Staff;




import java.util.*;
/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */


public interface  StaffService{ 

	public Staff findById(Long id);
	
	public void save(Staff item);
	
	public void update(Staff item);
	
	public void updateSelective(Staff item);
	
	public void delete(Long id);
	
    public void deleteByWhere(String swhere);
	
	public List<Staff> execSql(String sql);
	
	public List<Staff> selectByPage(int pageIndex, int pageSize, String strWhere, String strOrderBy);
	
	public int getRecordCount(String strWhere);
	public Paginable<Staff> getPaginatedStaff(Paginable<Staff> page);

	public Paginable<Staff> getPaginatedStaffBir(Paginable<Staff> page);

	public Paginable<Staff> getPaginatedStaffBirM(Paginable<Staff> page);

	
}
