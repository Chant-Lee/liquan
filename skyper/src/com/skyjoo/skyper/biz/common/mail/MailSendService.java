package com.skyjoo.skyper.biz.common.mail;

import com.skyjoo.skyper.biz.staff.domain.Staff;





/**
 * �ʼ�����service
 * @author lxh
 *
 */
public interface MailSendService {
	
	/**
	 * ������֤���������ʼ�
	 * @param loginId
	 * @param key
	 * @return
	 */
	public boolean sendBirthdayWishes(Staff staff);
    public boolean sendProcessMailVerify(String loginId, String key);

     /**
     * ���ͻ�Ա���������ʼ�
     * @param returnAccount
     * @param key
     * @param newPassword
     * @return
     */

}
