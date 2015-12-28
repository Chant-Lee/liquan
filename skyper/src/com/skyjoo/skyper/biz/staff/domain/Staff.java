package com.skyjoo.skyper.biz.staff.domain;

import java.io.File;
import java.util.Date;

import com.skyjoo.skyper.biz.common.page.Pagination;
import com.skyjoo.skyper.biz.leave.domain.Leave;

public class Staff  extends Pagination<Staff>{
	/**
	 * 员工ID
	 */
	private Long id;
	/**
	 * 员工名
	 */
	private String staffName;
	private String password;
	private String  annualLeave;
	/**
	 * 身份证
	 */
	private Long cardId;
	/**
	 * 性别
	 */
	private String gender;
	private String email;
	private Long cellphone;


	private Long bankCard;
	private String photo;
	private Date birthday;

	/**
	 * 入职时间
	 */
	private Date entryTime;
	private int isAdmin;
	private String currentAddress;
	/**
	 * 户籍地址
	 */
	private String gensusRegisterAdd;
	/**
	 * 在职状态
	 */
	private String inServiceState;
	/**
	 * 户口类型
	 */

	private String accountType;
	private Date participateInTheWorkYear;
	/**
	 * 档案
	 */
	private String archives;
	private Long   workYears;
	/**
	 * 公积金账号
	 */
	private Long providentFundAccount;

	private String other;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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



	public String getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(String annualLeave) {
		this.annualLeave = annualLeave;
	}

	public void setGensusRegisterAdd(String gensusRegisterAdd) {
		this.gensusRegisterAdd = gensusRegisterAdd;
	}

	public void setWorkYears(Long workYears) {
		this.workYears = workYears;
	}

	

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
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

	public Long getBankCard() {
		return bankCard;
	}

	public void setBankCard(Long bankCard) {
		this.bankCard = bankCard;
	}



	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public void setGensusRegisterAddress(String gensusRegisterAdd) {
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

	public void setWordYears(Long workYears) {
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

}
