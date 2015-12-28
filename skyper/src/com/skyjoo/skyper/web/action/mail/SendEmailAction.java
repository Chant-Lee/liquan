
package com.skyjoo.skyper.web.action.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.skyper.biz.common.mail.MailSendService;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.staff.service.StaffService;
import com.skyjoo.skyper.web.action.BaseAction;
@Controller
public class SendEmailAction extends BaseAction{
	@Autowired
    private MailSendService   mailSendService;
	@Autowired
	private StaffService      staffService;
	   @RequestMapping("/birthday/sendEmail.htm")
       public String editInit(@RequestParam("id") Long staffId,@ModelAttribute("staff") Staff staff, Model model) {
		   staff= staffService.findById(staffId);
		   mailSendService.sendBirthdayWishes(staff);

    
          return  "redirect:/birthday/listbyMonth.htm";
       
    }
	
}
