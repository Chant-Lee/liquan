package com.skyjoo.skyper.biz.common.mail;

import com.skyjoo.skyper.biz.staff.domain.Staff;





/**
 * 邮件发送service
 * @author lxh
 *
 */
public interface MailSendService {
	
	/**
	 * 发送验证开户流程邮件
	 * @param loginId
	 * @param key
	 * @return
	 */
	public boolean sendBirthdayWishes(Staff staff);
    public boolean sendProcessMailVerify(String loginId, String key);

     /**
     * 发送会员密码重置邮件
     * @param returnAccount
     * @param key
     * @param newPassword
     * @return
     */

}
