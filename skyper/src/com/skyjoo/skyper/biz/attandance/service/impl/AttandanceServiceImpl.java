package com.skyjoo.skyper.biz.attandance.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.attandance.dao.AttandanceDAO;
import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.attandance.service.AttandanceService;
import com.skyjoo.skyper.biz.common.page.Paginable;
  
 


/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */
@Service

public class AttandanceServiceImpl implements AttandanceService{
@Autowired	private AttandanceDAO attandanceDAO;
	
	public void setAttandanceDAO(AttandanceDAO attandanceDAO) {
		this.attandanceDAO = attandanceDAO;
	}
	
	public AttandanceDAO getAttandanceDAO() {
		return this.attandanceDAO;
	}
	@Override
	public Attandance findById(Long id) {
		// TODO Auto-generated method stub
		return attandanceDAO.selectByPrimaryKey(id);
	}

	@Override
	public void save(Attandance item) {
		// TODO Auto-generated method stub
		attandanceDAO.insert(item);
	}

	@Override
	public void update(Attandance item) {
		// TODO Auto-generated method stub
		attandanceDAO.updateByPrimaryKey(item);
	}
	@Override
	public void updateSelective(Attandance item) {
		attandanceDAO.updateByPrimaryKeySelective(item);
		
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		attandanceDAO.deleteByPrimaryKey(id);
	}
	
	@Override
	public void deleteByWhere(String swhere) {
		// TODO Auto-generated method stub  
		attandanceDAO.deleteByWhere(swhere);
	}

	@Override
	public List<Attandance> execSql(String sql) {
		// TODO Auto-generated method stub
		return attandanceDAO.execSql(sql);
	}

	@Override
	public List<Attandance> selectByPage(int pageIndex, int pageSize,String strWhere, String strOrderBy) {
		String mainSql = "SELECT * FROM attandance";
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
		List<Attandance> xList = this.execSql(mainSql);
		return xList;
	}

	@Override
	public int getRecordCount(String strWhere) {

	     String sql = "SELECT COUNT(*) FROM attandance";
	     if(strWhere!=null && strWhere.trim().length()>0){
	         sql = sql + " WHERE " + strWhere;
	     }
	     Object obj =  attandanceDAO.selectObject(sql);
	     if(obj!=null){
	         return Integer.valueOf( attandanceDAO.selectObject(sql).toString());
	     }
	     return 0; 
	
	
	}

	@Override
	public Paginable<Attandance> getPaginatedAttandance(
			Paginable<Attandance> page) {
		// TODO Auto-generated method stub
		return attandanceDAO.getPaginatedAttandance(page);
	}
	

}
