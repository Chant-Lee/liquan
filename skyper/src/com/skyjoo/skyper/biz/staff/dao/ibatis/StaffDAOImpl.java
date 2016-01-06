package com.skyjoo.skyper.biz.staff.dao.ibatis;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.skyper.biz.common.base.BaseDaoiBatis;
import com.skyjoo.skyper.biz.common.page.Paginable;
import com.skyjoo.skyper.biz.staff.dao.StaffDAO;
import com.skyjoo.skyper.biz.staff.domain.Staff;


@SuppressWarnings("deprecation")
@Repository
public class StaffDAOImpl extends BaseDaoiBatis implements StaffDAO  {
	//private static String SQLMAP_SPACE = "SYSTEM_USER.";
	private static String SQLMAP_SPACE = "Staff.";
		public void insert(Staff record){
			 getSqlMapClientTemplate().insert("Staff.insert", record);
		 }
	 
		public int updateByPrimaryKey(Staff record){
	    	  int rows = getSqlMapClientTemplate().update("Staff.updateByPrimaryKey", record);
	          return rows;
	    }
		
		public int updateByPrimaryKeySelective(Staff record) {
			// TODO Auto-generated method stub
		 int rows = getSqlMapClientTemplate().update("Staff.updateByPrimaryKeySelective", record);
	        return rows;
		}
		
		public Staff selectByPrimaryKey(String id){
			 Staff key = new Staff();
	         key.setId(id);
			Staff record = (Staff) getSqlMapClientTemplate().queryForObject("Staff.selectByPrimaryKey", key);
	         return record;
	    }
	 
		public int deleteByPrimaryKey(String id){
	    	 Staff key = new Staff();
	         key.setId(id);
	         int rows = getSqlMapClientTemplate().delete("Staff.deleteByPrimaryKey", key);
	         return rows;
	    }
		
		public int deleteByWhere(String swhere){
	         int rows = getSqlMapClientTemplate().delete("Staff.deleteByWhere", swhere);
	         return rows;
	    }
		
	    @SuppressWarnings("unchecked")
		public List<Staff> execSql(String sql){
	    	return (List<Staff>) getSqlMapClientTemplate().queryForList(
					"Staff.execSql", sql);
	    }

	    public Object selectObject(String sql){
		     if(sql!=null && sql.trim().length()>0){
		         return getSqlMapClientTemplate().queryForObject("Staff.execSqlObject",sql);
		     }
		     return null;
		
	    }

	    public int count(String strWhere){
			String sql = "SELECT COUNT(*) FROM staff";
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
		public Paginable<Staff> getPaginatedStaff(Paginable<Staff> page) {
			// TODO Auto-generated method stub
			 try
		        {
		            super.paginate(page, SQLMAP_SPACE +"getStaffCount",
		            			SQLMAP_SPACE +"getPaginatedStaff");
		            return page;
		        }catch(Exception e)
		        {
		           log.error(e.getStackTrace());
		        }
		        return null;
		
		}

		@Override
		public Paginable<Staff> getPaginatedStaffBir(Paginable<Staff> page) {
			// TODO Auto-generated method stub
			try
	        {
	            super.paginate(page, SQLMAP_SPACE +"getStaffCountBir",
	            			SQLMAP_SPACE +"getPaginatedStaffBir");
	            return page;
	        }catch(Exception e)
	        {
	           log.error(e.getStackTrace());
	        }
	        return null;
		}

		@Override
		public Paginable<Staff> getPaginatedStaffBirM(Paginable<Staff> page) {
			// TODO Auto-generated method stub
			try
	        {
	            super.paginate(page, SQLMAP_SPACE +"getStaffCountBirM",
	            			SQLMAP_SPACE +"getPaginatedStaffBirM");
	            return page;
	        }catch(Exception e)
	        {
	           log.error(e.getStackTrace());
	        }
	        return null;
		}


}
