package com.skyjoo.skyper.biz.staff.domain;

import java.util.Date;

import com.skyjoo.skyper.biz.common.page.Pagination;

@SuppressWarnings("serial")
public class Staff  extends Pagination<Staff>{
	/**
	 * Ա��ID
	 */
	private String id;
	/**
	 * Ա����
	 */
	private String staffName;
	private String password;
	private double  annualLeave;
	/**
	 * �Ա�
	 */
	private String gender;
	private String email;
	private Long cellphone;
	private String photo;
	private Date birthday;
	/**
	 * ��ְʱ��
	 */
	private Date entryTime;
	private int isAdmin;
	private String currentAddress;
	/**
	 * ������ַ
	 */
	private String gensusRegisterAdd;
	/**
	 * ��ְ״̬
	 */
	private String inServiceState;
	/**
	 * ��������
	 */
	private String accountType;
	private Date participateInTheWorkYear;
	/**
	 * ����
	 */
	private String archives;
	private Long   workYears;
	/**
	 * �������˺�
	 */
	private Long providentFundAccount;
	private String other;
	/**
	 * ��λ���
	 */
	private String jobCategories;
	/**
	 * �쵼
	 */
	private String leaderName;
	/**
	 * ��ͬ����
	 */
	private Date jobDeadLine;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public double getAnnualLeave() {
		return annualLeave;
	}
	public void setAnnualLeave(double annualLeave) {
		this.annualLeave = annualLeave;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCellphone() {
		return cellphone;
	}
	public void setCellphone(Long cellphone) {
		this.cellphone = cellphone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getGensusRegisterAdd() {
		return gensusRegisterAdd;
	}
	public void setGensusRegisterAdd(String gensusRegisterAdd) {
		this.gensusRegisterAdd = gensusRegisterAdd;
	}
	public String getInServiceState() {
		return inServiceState;
	}
	public void setInServiceState(String inServiceState) {
		this.inServiceState = inServiceState;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Date getParticipateInTheWorkYear() {
		return participateInTheWorkYear;
	}
	public void setParticipateInTheWorkYear(Date participateInTheWorkYear) {
		this.participateInTheWorkYear = participateInTheWorkYear;
	}
	public String getArchives() {
		return archives;
	}
	public void setArchives(String archives) {
		this.archives = archives;
	}
	public Long getWorkYears() {
		return workYears;
	}
	public void setWorkYears(Long workYears) {
		this.workYears = workYears;
	}
	public Long getProvidentFundAccount() {
		return providentFundAccount;
	}
	public void setProvidentFundAccount(Long providentFundAccount) {
		this.providentFundAccount = providentFundAccount;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getJobCategories() {
		return jobCategories;
	}
	public void setJobCategories(String jobCategories) {
		this.jobCategories = jobCategories;
	}

	public Date getJobDeadLine() {
		return jobDeadLine;
	}
	public void setJobDeadLine(Date jobDeadLine) {
		this.jobDeadLine = jobDeadLine;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;		
	}

}
