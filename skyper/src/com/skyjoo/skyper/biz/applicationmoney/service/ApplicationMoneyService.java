package com.skyjoo.skyper.biz.applicationmoney.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.applicationmoney.domain.ApplicationMoney;
import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.common.page.Paginable;



import java.util.*;
  

/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */

@Service
public interface  ApplicationMoneyService{ 

	public ApplicationMoney findById(Long id);
	
	public void save(ApplicationMoney item);
	
	public void update(ApplicationMoney item);
	
	public void updateSelective(ApplicationMoney item);
	
	public void delete(Long id);
	
    public void deleteByWhere(String swhere);
	
	List<ApplicationMoney> execSql(String sql);
	
	public List<ApplicationMoney> selectByPage(int pageIndex, int pageSize, String strWhere, String strOrderBy);
	
	public int getRecordCount(String strWhere);
	public Paginable<ApplicationMoney> getPaginatedApplicationMoney(Paginable<ApplicationMoney> page);
}
