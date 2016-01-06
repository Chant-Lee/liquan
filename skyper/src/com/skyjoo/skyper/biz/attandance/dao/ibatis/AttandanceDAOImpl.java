package com.skyjoo.skyper.biz.attandance.dao.ibatis;

import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.skyjoo.skyper.biz.attandance.dao.AttandanceDAO;
import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.common.base.BaseDaoiBatis;
import com.skyjoo.skyper.biz.common.page.Paginable;

 
@SuppressWarnings("deprecation")
@Repository
 
public class AttandanceDAOImpl extends BaseDaoiBatis implements AttandanceDAO  {
	private static String SQLMAP_SPACE = "Attandance.";
		public AttandanceDAOImpl() {
			super();
		}
		
		public void insert(Attandance record){
			 getSqlMapClientTemplate().insert("Attandance.insert", record);
		 }
	 
		public int updateByPrimaryKey(Attandance record){
	    	  int rows = getSqlMapClientTemplate().update("Attandance.updateByPrimaryKey", record);
	          return rows;
	    }
		
		public int updateByPrimaryKeySelective(Attandance record) {
			// TODO Auto-generated method stub
		 int rows = getSqlMapClientTemplate().update("Attandance.updateByPrimaryKeySelective", record);
	        return rows;
		}
		
		public Attandance selectByPrimaryKey(Long id){
	    	Attandance key = new Attandance();
	         key.setId(id);
	         Attandance record = (Attandance) getSqlMapClientTemplate().queryForObject("Attandance.selectByPrimaryKey", key);
	         return record;
	    }
	 
		public int deleteByPrimaryKey(Long id){
	    	 Attandance key = new Attandance();
	         key.setId(id);
	         int rows = getSqlMapClientTemplate().delete("Attandance.deleteByPrimaryKey", key);
	         return rows;
	    }
		
		public int deleteByWhere(String swhere){
	         int rows = getSqlMapClientTemplate().delete("Attandance.deleteByWhere", swhere);
	         return rows;
	    }
		
	    public List<Attandance> execSql(String sql){
	    	return (List<Attandance>) getSqlMapClientTemplate().queryForList(
					"Attandance.execSql", sql);
	    }

	    public Object selectObject(String sql){
		     if(sql!=null && sql.trim().length()>0){
		         return getSqlMapClientTemplate().queryForObject("Attandance.execSqlObject",sql);
		     }
		     return null;
		
	    }

	    public int count(String strWhere){
			String sql = "SELECT COUNT(*) FROM attandance";
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
		public Paginable<Attandance> getPaginatedAttandance(
				Paginable<Attandance> page) {
			 try
		        {
		            super.paginate(page, SQLMAP_SPACE +"getAttandanceCount",
		            			SQLMAP_SPACE +"getPaginatedAttandance");
		            return page;
		        }catch(Exception e)
		        {
		           log.error(e.getStackTrace());
		        }
		        return null;
		
		}

}
