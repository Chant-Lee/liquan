package com.skyjoo.skyper.biz.attandance.dao;

import java.util.*;
  

import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.common.page.Paginable;

/**
 * @author xlb
 * @version 1.0
 * @since 1.0
 */


import java.util.List; 


public interface AttandanceDAO {
	 
    void insert(Attandance record);
 
    int updateByPrimaryKey(Attandance record);
    
    int updateByPrimaryKeySelective(Attandance record);
 
     Attandance selectByPrimaryKey(Long id);
 
    int deleteByPrimaryKey(Long id);
    
    public List<Attandance> execSql(String sql);
    
    public int deleteByWhere(String swhere);
    
    public Object selectObject(String sql);

    public int count(String strWhere);

	Paginable<Attandance> getPaginatedAttandance(Paginable<Attandance> page);

}
