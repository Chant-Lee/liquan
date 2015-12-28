package com.skyjoo.skyper.biz.leave.dao.ibatis;

import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.skyjoo.skyper.biz.common.base.BaseDaoiBatis;
import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.leave.dao.LeaveDAO;
import com.skyjoo.skyper.biz.leave.domain.Leave;

 

@SuppressWarnings("deprecation")
@Repository
public class LeaveDAOImpl extends BaseDaoiBatis implements LeaveDAO  {
	private static String SQLMAP_SPACE = "Leave.";
		public LeaveDAOImpl() {
			super();
		}
		
		public void insert(Leave record){
			 getSqlMapClientTemplate().insert("Leave.insert", record);
		 }
	 
		public int updateByPrimaryKey(Leave record){
	    	  int rows = getSqlMapClientTemplate().update("Leave.updateByPrimaryKey", record);
	          return rows;
	    }
		
		public int updateByPrimaryKeySelective(Leave record) {
			// TODO Auto-generated method stub
		 int rows = getSqlMapClientTemplate().update("Leave.updateByPrimaryKeySelective", record);
	        return rows;
		}
		
		public Leave selectByPrimaryKey(Long id){
	    	Leave key = new Leave();
	         key.setId(id);
	         Leave record = (Leave) getSqlMapClientTemplate().queryForObject("Leave.selectByPrimaryKey", key);
	         return record;
	    }
	 
		public int deleteByPrimaryKey(Long id){
	    	 Leave key = new Leave();
	         key.setId(id);
	         int rows = getSqlMapClientTemplate().delete("Leave.deleteByPrimaryKey", key);
	         return rows;
	    }
		
		public int deleteByWhere(String swhere){
	         int rows = getSqlMapClientTemplate().delete("Leave.deleteByWhere", swhere);
	         return rows;
	    }
		
	    public List<Leave> execSql(String sql){
	    	return (List<Leave>) getSqlMapClientTemplate().queryForList(
					"Leave.execSql", sql);
	    }

	    public Object selectObject(String sql){
		     if(sql!=null && sql.trim().length()>0){
		         return getSqlMapClientTemplate().queryForObject("Leave.execSqlObject",sql);
		     }
		     return null;
		
	    }
	    public int count(String strWhere){
			String sql = "SELECT COUNT(*) FROM leave";
		     if(strWhere!=null && strWhere.trim().length()>0){
		         sql = sql + " WHERE " + strWhere;
		     }
		     Object obj =  this.selectObject(sql);
		     if(obj!=null){
		         return Integer.valueOf( this.selectObject(sql).toString());
		     }
		     return 0; 
	    }
		@Override
		public Paginable<Leave> getPaginatedLeave(Paginable<Leave> page) {
			 try
		        {
		            super.paginate(page, SQLMAP_SPACE +"getLeaveCount",
		            			SQLMAP_SPACE +"getPaginatedLeave");
		            return page;
		        }catch(Exception e)
		        {
		           log.error(e.getStackTrace());
		        }
		        return null;
		}

}
