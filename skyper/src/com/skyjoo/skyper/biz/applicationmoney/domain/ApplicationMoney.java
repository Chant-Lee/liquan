package com.skyjoo.skyper.biz.applicationmoney.domain;

import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.common.page.Pagination;


public class ApplicationMoney  extends Pagination<ApplicationMoney>{
	 
	   /**
	    * ID
	    */
	private   Long     id;
	   /*
	    * 用款用途
	    */
	private   String   moneyUse;
	   /*
	    * 申请人
	    */
	private   String   applicant;
	   /*
	    * 用款方式
	    */
	private   String   inParagraph;
	   /*
	    * 货币币种
	    */
	private   String   currency;
	   /*
	    * 用款金额（大写）
	    */
	private   String   ammountOfMoneyC;
	   /*
	    * 用款金额（小写）
	    */
	private   Long     ammountOfMoneyL;
	   /*
	    * 收款单位全称
	    */
	private   String   collectionUnitName;
	   /*
	    * 部门负责人
	    */
	private   String   departmentHead;
	   /*
	    *财务签批 
	    */
	private   String   financialSigned;
	   /*
	    * 账号
	    */
	private   Long     account;
	   /*
	    * 开户银行
	    */
	private   String   bankAccount;
	   /*
	    * 主管签批
	    */
	private   String   supervisorSigned;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMoneyUse() {
		return moneyUse;
	}

	public void setMoneyUse(String moneyUse) {
		this.moneyUse = moneyUse;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getInParagraph() {
		return inParagraph;
	}

	public void setInParagraph(String inParagraph) {
		this.inParagraph = inParagraph;
	}

	public String getAmmountOfMoneyC() {
		return ammountOfMoneyC;
	}

	public void setAmmountOfMoneyC(String ammountOfMoneyC) {
		this.ammountOfMoneyC = ammountOfMoneyC;
	}

	public Long getAmmountOfMoneyL() {
		return ammountOfMoneyL;
	}

	public void setAmmountOfMoneyL(Long ammountOfMoneyL) {
		this.ammountOfMoneyL = ammountOfMoneyL;
	}

	public String getCollectionUnitName() {
		return collectionUnitName;
	}

	public void setCollectionUnitName(String collectionUnitName) {
		this.collectionUnitName = collectionUnitName;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public String getFinancialSigned() {
		return financialSigned;
	}

	public void setFinancialSigned(String financialSigned) {
		this.financialSigned = financialSigned;
	}

	public Long getAccount() {
		return account;
	}

	public void setAccount(Long account) {
		this.account = account;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getSupervisorSigned() {
		return supervisorSigned;
	}

	public void setSupervisorSigned(String supervisorSigned) {
		this.supervisorSigned = supervisorSigned;
	}
}	 

