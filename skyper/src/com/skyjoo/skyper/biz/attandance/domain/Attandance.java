package com.skyjoo.skyper.biz.attandance.domain;

import java.util.Date;

import com.skyjoo.skyper.biz.common.page.Pagination;



public class Attandance   extends Pagination<Attandance>{
	 
	
		private Long id;
		private String staffId;
		private String staffName;
		private String type;
		private Date datetime;
		private String remark;
		public Long getId() {
			return id;
		}
		public void setId(java.lang.Long id) {
			this.id = id;
		}
	
		public String getStaffId() {
			return staffId;
		}
		public void setStaffId(String staffId) {
			this.staffId = staffId;
		}
		public java.lang.String getStaffName() {
			return staffName;
		}
		public void setStaffName(java.lang.String staffName) {
			this.staffName = staffName;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public java.lang.String getType() {
			return type;
		}
		public void setType(java.lang.String type) {
			this.type = type;
		}
		public Date getDatetime() {
			return datetime;
		}
		public void setDatetime(Date datetime) {
			this.datetime = datetime;
		}

	

}	 

