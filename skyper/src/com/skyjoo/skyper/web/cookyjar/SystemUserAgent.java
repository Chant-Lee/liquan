package com.skyjoo.skyper.web.cookyjar;


import com.eyeieye.melos.web.cookyjar.SelfDependence;
import com.eyeieye.melos.web.cookyjar.util.SelfUtil;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.user.domain.User;

public class SystemUserAgent implements SelfDependence {
	
	private Long id;
	private String loginName;
  
	
	public SystemUserAgent() {}
	
	public SystemUserAgent(Staff user) {
	      this.id=user.getId();
	      this.loginName=user.getStaffName();
	}



   public Long getId() {
		return id;
	}


	public String getLoginName() {
		return loginName;
	}



/**
    * 存储在cookie中
    */
	@Override
	public String lieDown() {
		return SelfUtil.format(String.valueOf(this.id), this.loginName);

	}
    /**
     * 获取cookie中的值
     */
	@Override
	public SelfDependence riseUp(String value) {
		String[] values = SelfUtil.recover(value);
		this.id = Long.valueOf(values[0]);
		
		this.loginName = values[1];
		return this;
	}
	
}
