package com.skyjoo.skyper.web.action.applicationMoney;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.biz.applicationmoney.domain.ApplicationMoney;
import com.skyjoo.skyper.biz.applicationmoney.service.ApplicationMoneyService;

import com.skyjoo.skyper.web.action.BaseAction;
import com.skyjoo.skyper.web.action.Interceptor.AuthRole;
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
		@AuthRole
		@RequestMapping(value = "applicationMoney/applicationMoney.htm")
		public String success(@ModelAttribute("applicationMoney") ApplicationMoney applicationMoney,
				 ModelMap model,SystemUserAgent agent,Cookyjar cookyjar) {	
					
			applicationMoney.setSubDate(new Date());
			applicationMoneyService.save(applicationMoney);
			return "main";
			
		}
		@AuthRole
		@RequestMapping(value = "applicationMoney/list.htm")
		public String getlist(@ModelAttribute("applicationMoney") ApplicationMoney applicationMoney,
				 ModelMap model) {	
					
			
		applicationMoney=(ApplicationMoney)	applicationMoneyService.getPaginatedApplicationMoney(applicationMoney);
			model.addAttribute("page2", applicationMoney);
			
			return "applicationMoney/list";
			
		}
		@AuthRole
		@RequestMapping(value = "applicationMoney/detail.htm")
		public String detail(@ModelAttribute("applicationMoney") ApplicationMoney applicationMoney,
				 ModelMap model,@RequestParam("id") Long id) {	
			applicationMoney=	applicationMoneyService.findById(id);
			model.addAttribute("applicationMoney", applicationMoney);
			return "applicationMoney/detail";
			
		}
		
}
