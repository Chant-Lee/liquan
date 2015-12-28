package com.skyjoo.skyper.biz.staff.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.staff.dao.StaffDAO;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.staff.service.StaffService;

/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffDAO staffDAO;	
	
	public Staff findById(Long id) {
		// TODO Auto-generated method stub
		return staffDAO.selectByPrimaryKey(id);
	}


	public void save(Staff item) {
		// TODO Auto-generated method stub
		staffDAO.insert(item);
	}


	public void update(Staff item) {
		// TODO Auto-generated method stub
		staffDAO.updateByPrimaryKey(item);
	}

	public void updateSelective(Staff item) {
		staffDAO.updateByPrimaryKeySelective(item);
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		staffDAO.deleteByPrimaryKey(id);
	}
	

	public void deleteByWhere(String swhere) {
		// TODO Auto-generated method stub  
		staffDAO.deleteByWhere(swhere);
	}


	public List<Staff> execSql(String sql) {
		// TODO Auto-generated method stub
		return staffDAO.execSql(sql);
	}


	public List<Staff> selectByPage(int pageIndex, int pageSize,String strWhere, String strOrderBy) {
		String mainSql = "SELECT * FROM staff";
		
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
		String sqlString="select * from (select a.*,rownum rn from staff a where rownum <= "+pageSize+") where rn > "+min+"";
		if (strWhere != null && strWhere.trim().length() > 0) {
			sqlString = sqlString + " WHERE " + strWhere;
		}
		if (strOrderBy != null && strOrderBy.trim().length() > 0) {
			sqlString = sqlString + " ORDER BY " + strOrderBy;
		}
		List<Staff> xList = this.execSql(sqlString);
		return xList;
	}

	public int getRecordCount(String strWhere) {

	     String sql = "SELECT COUNT(*) FROM staff";
	     if(strWhere!=null && strWhere.trim().length()>0){
	         sql = sql + " WHERE " + strWhere;
	     }
	     Object obj =  staffDAO.selectObject(sql);
	     if(obj!=null){
	         return Integer.valueOf( staffDAO.selectObject(sql).toString());
	     }
	     return 0; 
	
	
	}


	@Override
	public Paginable<Staff> getPaginatedStaff(Paginable<Staff> page) {
		// TODO Auto-generated method stub
		return staffDAO.getPaginatedStaff(page);
	}


	@Override
	public Paginable<Staff> getPaginatedStaffBir(Paginable<Staff> page) {
		// TODO Auto-generated method stub
		return staffDAO.getPaginatedStaffBir(page);
	}


	@Override
	public Paginable<Staff> getPaginatedStaffBirM(Paginable<Staff> page) {
		// TODO Auto-generated method stub
		return staffDAO.getPaginatedStaffBirM(page);
	}



	

}
