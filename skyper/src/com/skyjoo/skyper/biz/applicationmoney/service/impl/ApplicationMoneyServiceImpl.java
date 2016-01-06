package com.skyjoo.skyper.biz.applicationmoney.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.applicationmoney.dao.ApplicationMoneyDAO;
import com.skyjoo.skyper.biz.applicationmoney.domain.ApplicationMoney;
import com.skyjoo.skyper.biz.applicationmoney.service.ApplicationMoneyService;
import com.skyjoo.skyper.biz.common.page.Paginable;
  

/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */
@Service

public class ApplicationMoneyServiceImpl implements ApplicationMoneyService{
	@Autowired private ApplicationMoneyDAO applicationMoneyDAO;
	
	public void setApplicationMoneyDAO(ApplicationMoneyDAO applicationMoneyDAO) {
		this.applicationMoneyDAO = applicationMoneyDAO;
	}
	
	public ApplicationMoneyDAO getApplicationMoneyDAO() {
		return this.applicationMoneyDAO;
	}
	@Override
	public ApplicationMoney findById(Long id) {
		// TODO Auto-generated method stub
		return applicationMoneyDAO.selectByPrimaryKey(id);
	}

	@Override
	public void save(ApplicationMoney item) {
		// TODO Auto-generated method stub
		applicationMoneyDAO.insert(item);
	}

	@Override
	public void update(ApplicationMoney item) {
		// TODO Auto-generated method stub
		applicationMoneyDAO.updateByPrimaryKey(item);
	}
	@Override
	public void updateSelective(ApplicationMoney item) {
		applicationMoneyDAO.updateByPrimaryKeySelective(item);
		
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		applicationMoneyDAO.deleteByPrimaryKey(id);
	}
	
	@Override
	public void deleteByWhere(String swhere) {
		// TODO Auto-generated method stub  
		applicationMoneyDAO.deleteByWhere(swhere);
	}

	@Override
	public List<ApplicationMoney> execSql(String sql) {
		// TODO Auto-generated method stub
		return applicationMoneyDAO.execSql(sql);
	}

	@Override
	public List<ApplicationMoney> selectByPage(int pageIndex, int pageSize,String strWhere, String strOrderBy) {
		String mainSql = "SELECT * FROM application_money";
		if (strWhere != null && strWhere.trim().length() > 0) {
			mainSql = mainSql + " WHERE " + strWhere;
		}
		if (strOrderBy != null && strOrderBy.trim().length() > 0) {
			mainSql = mainSql + " ORDER BY " + strOrderBy;
		}
		int size =(int)this.getRecordCount(strWhere);
		int totalsize = (size % pageSize == 0) ? (size / pageSize) : (size / pageSize + 1);
		int max = pageIndex > totalsize ? totalsize * pageSize : pageIndex * pageSize;
		int min = pageIndex == 1 ? 0 : pageIndex  * pageSize;
		if (max <= min) {
			min = min - pageSize;
			pageIndex -= 1;
		}
		min=min>0?min:0;
		mainSql+="  LIMIT "+min+","+pageSize;
		List<ApplicationMoney> xList = this.execSql(mainSql);
		return xList;
	}

	@Override
	public int getRecordCount(String strWhere) {

	     String sql = "SELECT COUNT(*) FROM application_money";
	     if(strWhere!=null && strWhere.trim().length()>0){
	         sql = sql + " WHERE " + strWhere;
	     }
	     Object obj =  applicationMoneyDAO.selectObject(sql);
	     if(obj!=null){
	         return Integer.valueOf( applicationMoneyDAO.selectObject(sql).toString());
	     }
	     return 0; 
	
	
	}

	@Override
	public Paginable<ApplicationMoney> getPaginatedApplicationMoney(
			Paginable<ApplicationMoney> page) {
		return applicationMoneyDAO.getPaginatedApplicationMoney(page);// TODO Auto-generated method stub
		
	}
	

}
