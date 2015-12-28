package com.skyjoo.skyper.biz.leave.service;

import java.util.List;
import org.springframework.stereotype.Service;


import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.leave.domain.Leave;



import java.util.*;
  



/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */

@Service
public interface  LeaveService{ 

	public Leave findById(Long id);
	
	public void save(Leave item);
	
	public void update(Leave item);
	
	public void updateSelective(Leave item);
	
	public void delete(Long id);
	public Paginable<Leave> getPaginatedLeave(Paginable<Leave> page);
    public void deleteByWhere(String swhere);
	
	List<Leave> execSql(String sql);
	
	public List<Leave> selectByPage(int pageIndex, int pageSize, String strWhere, String strOrderBy);
	
	public int getRecordCount(String strWhere);
	
}
