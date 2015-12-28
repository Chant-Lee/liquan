package com.skyjoo.skyper.web.action.applicationMoney;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.biz.applicationmoney.domain.ApplicationMoney;
import com.skyjoo.skyper.biz.applicationmoney.service.ApplicationMoneyService;
import com.skyjoo.skyper.biz.leave.domain.Leave;
import com.skyjoo.skyper.biz.leave.service.LeaveService;
import com.skyjoo.skyper.web.action.BaseAction;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;

@Controller
public class ApplicationMoneyAction extends BaseAction{
	@Autowired
	   private ApplicationMoneyService  applicationMoneyService;
		@RequestMapping(value = "applicationMoney/application.htm")
		public String add(@ModelAttribute("applicationMoney") ApplicationMoney applicationMoney,
				 ModelMap model) {	
				return "applicationMoney/applicationMoney";
		}
		@RequestMapping(value = "applicationMoney/applicationMoney.htm")
		public String success(@ModelAttribute("applicationMoney") ApplicationMoney applicationMoney,
				 ModelMap model,SystemUserAgent agent,Cookyjar cookyjar) {	
					
			applicationMoneyService.save(applicationMoney);
			return "main";
			
		}
}
