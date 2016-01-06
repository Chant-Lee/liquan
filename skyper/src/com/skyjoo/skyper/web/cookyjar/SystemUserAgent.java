package com.skyjoo.skyper.web.cookyjar;


import com.eyeieye.melos.web.cookyjar.SelfDependence;
import com.eyeieye.melos.web.cookyjar.util.SelfUtil;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.user.domain.User;

public class SystemUserAgent implements SelfDependence {
	
	private String id;
	private String loginName;
	private String isAdmin;//是否是管理员
	
	public SystemUserAgent() {}
	
	public SystemUserAgent(Staff user) {
	      this.id=user.getId();
	      this.loginName=user.getStaffName();
	      this.isAdmin=String.valueOf(user.getIsAdmin());
	}



   public String getId() {
		return id;
	}

   public String getIsAdmin()
   {
	   return isAdmin;
   }
	public String getLoginName() {
		return loginName;
	}



/**
    * 存储在cookie中
    */
	@Override
	public String lieDown() {
		return SelfUtil.format(String.valueOf(this.id), this.loginName,String.valueOf(this.isAdmin));

	}
    /**
     * 获取cookie中的值
     */
	@Override
	public SelfDependence riseUp(String value) {
		String[] values = SelfUtil.recover(value);
		this.id = values[0];
		
		this.loginName = values[1];
		this.isAdmin = values[2];
		return this;
	}
	
}
