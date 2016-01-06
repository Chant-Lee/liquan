package com.skyjoo.skyper.biz.attandance.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.leave.domain.Leave;



import java.util.*;
  


/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */

@Service
public interface  AttandanceService{ 

	public Attandance findById(Long id);
	
	public void save(Attandance item);
	
	public void update(Attandance item);
	
	public void updateSelective(Attandance item);
	
	public void delete(Long id);
	
    public void deleteByWhere(String swhere);
	
	List<Attandance> execSql(String sql);
	
	public List<Attandance> selectByPage(int pageIndex, int pageSize, String strWhere, String strOrderBy);
	
	public int getRecordCount(String strWhere);
	public Paginable<Attandance> getPaginatedAttandance(Paginable<Attandance> page);
}
