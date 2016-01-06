package com.skyjoo.skyper.web.action.user;

import java.util.List;

import oracle.jdbc.util.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.eyeieye.melos.util.digest.MessageDigest;
import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.biz.applicationmoney.domain.ApplicationMoney;
import com.skyjoo.skyper.biz.applicationmoney.service.ApplicationMoneyService;
import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.attandance.service.AttandanceService;
import com.skyjoo.skyper.biz.leave.domain.Leave;
import com.skyjoo.skyper.biz.leave.service.LeaveService;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.staff.service.StaffService;
import com.skyjoo.skyper.biz.user.dao.UserDao;
import com.skyjoo.skyper.biz.user.domain.User;
import com.skyjoo.skyper.biz.user.manager.UserManager;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;

@Controller
public class UserLoginAction {
	@Autowired
	private UserManager userManager;
	@Autowired
	private UserDao userDao;
	@Autowired
	private StaffService staffService;
	@Autowired
	LeaveService leaveService;
	@Autowired
	ApplicationMoneyService applicationMoneyService;
	@Autowired
	AttandanceService attandanceService;
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login(@ModelAttribute("user") Staff user,
			BindingResult result, ModelMap model,SystemUserAgent agent,Cookyjar cookyjar) {	
			return "login";
	}
	
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String index(SystemUserAgent agent,Cookyjar cookyjar,ModelMap model) {
			model.put("name", agent.getLoginName());
			
			if(staffService.findById(agent.getId()).getIsAdmin()==1)
			{
			return "hr/index";
			}
			return "staff/index";

	}
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String loginin(@ModelAttribute("user") Staff staff,BindingResult result, ModelMap model,SystemUserAgent agent,Cookyjar cookyjar) {
		System.out.println();
	
			if(staff.getId()!=null)
			{
                   String   id=staff.getId();
			if(	staffService.findById(id)!=null)
			{
				String password=staff.getPassword();
				if(staffService.findById(id).getPassword().equals(password))
				{
					staff=staffService.findById(staff.getId());
					agent=new SystemUserAgent(staff);
					cookyjar.set(agent);			
				    return "redirect:/index.htm"; 
				}
			}
			}
			model.put("error", "’À√‹≥ˆ¥Ì");
			 
	
		return "login";
	}
	
	@RequestMapping(value = "/logout.htm")
	public String loginout(@ModelAttribute("user") Staff staff,BindingResult result, ModelMap model,SystemUserAgent agent,Cookyjar cookyjar) {
		System.out.println();
	
			 if(agent!=null)
			 {
				 cookyjar.remove(SystemUserAgent.class);
			 }
	
		return "login";
	}

}
