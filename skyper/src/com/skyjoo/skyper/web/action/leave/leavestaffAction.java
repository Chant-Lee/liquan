package com.skyjoo.skyper.web.action.leave;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.biz.leave.domain.Leave;
import com.skyjoo.skyper.biz.leave.service.LeaveService;
import com.skyjoo.skyper.web.action.BaseAction;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;
@Controller
public class leavestaffAction extends BaseAction {
	@Autowired
   private LeaveService  leaveService;
	@RequestMapping(value = "leave/leave.htm")
	public String add(@ModelAttribute("leave") Leave leave,
			 ModelMap model) {	
			return "leave/leave";
	}
	@RequestMapping(value = "leave/apply.htm")
	public String success(@ModelAttribute("leave") Leave leave,
			 ModelMap model,SystemUserAgent agent,Cookyjar cookyjar) {	
		
		leave.setStaffId(agent.getId());
		leave.setStaffName(agent.getLoginName());
		Date nowDate=new Date();
		System.out.println(nowDate);
		leave.setDateSubmission(nowDate);
		leaveService.save(leave);
		return "main";
	}
}
