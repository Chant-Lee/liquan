package com.skyjoo.skyper.biz.leave.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.leave.dao.LeaveDAO;
import com.skyjoo.skyper.biz.leave.domain.Leave;
import com.skyjoo.skyper.biz.leave.service.LeaveService;
  
 


/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */

@Service
public class LeaveServiceImpl implements LeaveService{
	@Autowired private LeaveDAO leaveDAO;
	
	public void setLeaveDAO(LeaveDAO leaveDAO) {
		this.leaveDAO = leaveDAO;
	}
	
	public LeaveDAO getLeaveDAO() {
		return this.leaveDAO;
	}
	@Override
	public Leave findById(Long id) {
		// TODO Auto-generated method stub
		return leaveDAO.selectByPrimaryKey(id);
	}

	@Override
	public void save(Leave item) {
		// TODO Auto-generated method stub
		leaveDAO.insert(item);
	}

	@Override
	public void update(Leave item) {
		// TODO Auto-generated method stub
		leaveDAO.updateByPrimaryKey(item);
	}
	@Override
	public void updateSelective(Leave item) {
		leaveDAO.updateByPrimaryKeySelective(item);
		
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		leaveDAO.deleteByPrimaryKey(id);
	}
	
	@Override
	public void deleteByWhere(String swhere) {
		// TODO Auto-generated method stub  
		leaveDAO.deleteByWhere(swhere);
	}

	@Override
	public List<Leave> execSql(String sql) {
		// TODO Auto-generated method stub
		return leaveDAO.execSql(sql);
	}

	@Override
	public List<Leave> selectByPage(int pageIndex, int pageSize,String strWhere, String strOrderBy) {
		String mainSql = "SELECT * FROM leave";
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
	//	mainSql="SELECT *    FROM (SELECT A.*, ROWNUM RN FROM (SELECT * FROM leave ORDER BY "+strOrderBy+") A WHERE "+strWhere  +" and ROWNUM <= "+pageSize+")WHERE RN >= "+min+"";
		mainSql+="  LIMIT "+min+","+pageSize;
		List<Leave> xList = this.execSql(mainSql);
		return xList;
	}

	@Override
	public int getRecordCount(String strWhere) {

	     String sql = "SELECT COUNT(*) FROM leave";
	     if(strWhere!=null && strWhere.trim().length()>0){
	         sql = sql + " WHERE " + strWhere;
	     }
	     Object obj =  leaveDAO.selectObject(sql);
	     if(obj!=null){
	         return Integer.valueOf( leaveDAO.selectObject(sql).toString());
	     }
	     return 0; 
	
	
	}

	@Override
	public Paginable<Leave> getPaginatedLeave(Paginable<Leave> page) {
		// TODO Auto-generated method stub
		return leaveDAO.getPaginatedLeave(page);
	}

	@Override
	public Paginable<Leave> getPaginatedLeaveByleader(Paginable<Leave> page) {
		// TODO Auto-generated method stub
		return leaveDAO.getPaginatedLeaveByleader(page);
	}
	

}
