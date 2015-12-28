package com.skyjoo.skyper.biz.common.mail;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eyeieye.melos.web.url.StampURLBroker;
import com.eyeieye.melos.web.url.URLBroker;
import com.skyjoo.skyper.biz.staff.domain.Staff;

@Repository
public class MailSendServiceImpl implements MailSendService {
	private VelocityTemplateMailMessage mailVerifyMail;
	private VelocityTemplateMailMessage sendResetPasswordMail;
	
	
	@Resource(name="sendBirthdayWishes")
	private VelocityTemplateMailMessage sendBirthdayWishes;
	@Autowired
	private StampURLBroker mailImageServerBroker;
	@Autowired
	private URLBroker mailAppServerBroker;
	
	
	
	
	
	
	
	@Override
	public boolean sendProcessMailVerify(String loginId, String key) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("imageServer", mailImageServerBroker.toString());
		data.put("appServer", mailAppServerBroker.toString());
		data.put("key", key);
		mailVerifyMail.setModel(data);
		mailVerifyMail.setToEmail(loginId);
		return mailVerifyMail.send();
	}
	@Override
	public boolean sendBirthdayWishes(Staff staff) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("fullName", staff.getStaffName());
		data.put("email", staff.getEmail());
		data.put("password", staff.getPassword());
		data.put("imageServer", mailImageServerBroker.toString());
		data.put("appServer", mailAppServerBroker.toString());
		sendBirthdayWishes.setModel(data);
		sendBirthdayWishes.setToEmail(staff.getEmail());
		return sendBirthdayWishes.send();
	}

	
	public void setMailVerifyMail(VelocityTemplateMailMessage mailVerifyMail) {
		this.mailVerifyMail = mailVerifyMail;
	}

	public void setMailImageServerBroker(StampURLBroker mailImageServerBroker) {
		this.mailImageServerBroker = mailImageServerBroker;
	}

	public void setMailAppServerBroker(URLBroker mailAppServerBroker) {
		this.mailAppServerBroker = mailAppServerBroker;
	}

	public VelocityTemplateMailMessage getSendResetPasswordMail() {
		return sendResetPasswordMail;
	}

	public void setSendResetPasswordMail(
			VelocityTemplateMailMessage sendResetPasswordMail) {
		this.sendResetPasswordMail = sendResetPasswordMail;
	}


}
