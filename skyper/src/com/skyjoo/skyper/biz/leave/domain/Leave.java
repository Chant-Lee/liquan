package com.skyjoo.skyper.biz.leave.domain;

import java.util.Date;

import com.skyjoo.skyper.biz.common.page.Pagination;

@SuppressWarnings("serial")
public class Leave  extends Pagination<Leave> {
	/**
	 *   ID
	 */
	private   Long     id;
	/**
	 *   Ա����
	 */
	private   Long     staffId;
	private   String   staffName;
	/**
	 * �������
	 */
	private   String   leaveContent;
	/**
	 * �������
	 */
	private   String   leaveType;
	/**
	 * ���ʱ��
	 */
	private   Date     leaveTime;
	/**
	 * ���Ŀ������
	 */
	private   Date     leaveTargetTime;

	public int getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(int isAccept) {
		this.isAccept = isAccept;
	}

	/**
	 * �ύ����
	 */
	private   Date     dateSubmission;
	
private int isAccept;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLeaveContent() {
		return leaveContent;
	}

	public void setLeaveContent(String leaveContent) {
		this.leaveContent = leaveContent;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Date getLeaveTargetTime() {
		return leaveTargetTime;
	}

	public void setLeaveTargetTime(Date leaveTargetTime) {
		this.leaveTargetTime = leaveTargetTime;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffID) {
		this.staffId = staffID;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Date getDateSubmission() {
		return dateSubmission;
	}

	public void setDateSubmission(Date dateSubmission) {
		this.dateSubmission = dateSubmission;
	}

}
