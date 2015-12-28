package com.skyjoo.skyper.biz.applicationmoney.dao.ibatis;

import java.util.*;

import com.skyjoo.skyper.biz.applicationmoney.dao.ApplicationMoneyDAO;
import com.skyjoo.skyper.biz.applicationmoney.domain.ApplicationMoney;
import com.skyjoo.skyper.biz.common.base.BaseDaoiBatis;
import com.skyjoo.skyper.biz.common.page.Paginable;


/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */



import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

 

@SuppressWarnings("deprecation")
@Repository
public class ApplicationMoneyDAOImpl extends BaseDaoiBatis implements ApplicationMoneyDAO  {
	private static String SQLMAP_SPACE = "ApplicationMoney.";
		public ApplicationMoneyDAOImpl() {
			super();
		}
		
		public void insert(ApplicationMoney record){
			 getSqlMapClientTemplate().insert("ApplicationMoney.insert", record);
		 }
	 
		public int updateByPrimaryKey(ApplicationMoney record){
	    	  int rows = getSqlMapClientTemplate().update("ApplicationMoney.updateByPrimaryKey", record);
	          return rows;
	    }
		
		public int updateByPrimaryKeySelective(ApplicationMoney record) {
			// TODO Auto-generated method stub
		 int rows = getSqlMapClientTemplate().update("ApplicationMoney.updateByPrimaryKeySelective", record);
	        return rows;
		}
		
		public ApplicationMoney selectByPrimaryKey(Long id){
	    	ApplicationMoney key = new ApplicationMoney();
	         key.setId(id);
	         ApplicationMoney record = (ApplicationMoney) getSqlMapClientTemplate().queryForObject("ApplicationMoney.selectByPrimaryKey", key);
	         return record;
	    }
	 
		public int deleteByPrimaryKey(Long id){
	    	 ApplicationMoney key = new ApplicationMoney();
	         key.setId(id);
	         int rows = getSqlMapClientTemplate().delete("ApplicationMoney.deleteByPrimaryKey", key);
	         return rows;
	    }
		
		public int deleteByWhere(String swhere){
	         int rows = getSqlMapClientTemplate().delete("ApplicationMoney.deleteByWhere", swhere);
	         return rows;
	    }
		
	    public List<ApplicationMoney> execSql(String sql){
	    	return (List<ApplicationMoney>) getSqlMapClientTemplate().queryForList(
					"ApplicationMoney.execSql", sql);
	    }

	    public Object selectObject(String sql){
		     if(sql!=null && sql.trim().length()>0){
		         return getSqlMapClientTemplate().queryForObject("ApplicationMoney.execSqlObject",sql);
		     }
		     return null;
		
	    }

	    public int count(String strWhere){
			String sql = "SELECT COUNT(*) FROM application_money";
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
		public Paginable<ApplicationMoney> getPaginatedApplicationMoney(
				Paginable<ApplicationMoney> page) {
			// TODO Auto-generated method stub
			 try
		        {
		            super.paginate(page, SQLMAP_SPACE +"getApplicationMoneyCount",
		            			SQLMAP_SPACE +"getPaginatedApplicationMoney");
		            return page;
		        }catch(Exception e)
		        {
		           log.error(e.getStackTrace());
		        }
		        return null;
		}

}
