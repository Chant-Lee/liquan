package com.skyjoo.skyper.web.action.birthday;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.staff.service.StaffService;
@Controller
public class birthdayAction extends Base{
  @Autowired StaffService staffService;
  
  
  @RequestMapping(value = "/birthday/listbyweek.htm")
  public String getlist(ModelMap model ,@ModelAttribute("page2") Staff staff)
  {
	 
		staff.setPageSize(10);
		staff =  (Staff)staffService.getPaginatedStaffBir(staff);
		model.addAttribute("page2", staff);
	  return "birthday/list";
  }
  @RequestMapping(value = "/birthday/listbyMonth.htm")
  public String getlist2(ModelMap model ,@ModelAttribute("page2") Staff staff)
  {
	 
		staff.setPageSize(10);
		staff =  (Staff)staffService.getPaginatedStaffBirM(staff);
		model.addAttribute("page2", staff);
	  return "birthday/list";
  }

	
}
