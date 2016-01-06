package com.skyjoo.skyper.web.action.staff;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.staff.service.StaffService;
import com.skyjoo.skyper.web.action.BaseAction;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;


@Controller
public class StaffAction extends BaseAction{
	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "/staff/infomation.htm")
	public String getInfomation(ModelMap model, @ModelAttribute("page") Staff staff){

		String staffName = staff.getStaffName();
		if (staffName != null) {
			staff.setStaffName(staffName.trim());
		}

		staff.setPageSize(10);

		staff = (Staff) staffService.getPaginatedStaff(staff);
		model.addAttribute("page", staff);

		return "staff/infomation";
	}
	@RequestMapping(value = "/staff/edit.htm")
	public String edit(@ModelAttribute("staff") Staff staff,
			HttpServletRequest request, SystemUserAgent agent, Model model) {
		Staff s=staffService.findById(staff.getId());
		String photo = s.getPhoto();
		if (staff.getPhoto() == null || staff.getPhoto() == "")
			staff.setPhoto(photo);
		int  isAdmin= s.getIsAdmin();	  
			  staff.setIsAdmin(isAdmin);
		Date entrytimeDate=s.getEntryTime();
		staff.setEntryTime(entrytimeDate);
		double annualleave=s.getAnnualLeave();
		staff.setAnnualLeave(annualleave);
		Date endtimeDate=s.getJobDeadLine();
		staff.setJobDeadLine(endtimeDate);
		staff.setJobCategories(s.getJobCategories());
		staffService.update(staff);
		return "redirect:/main.htm";
	}
	
	@RequestMapping("/staff/edit-init.htm")
	public String editInit(@RequestParam("id") String staffId,SystemUserAgent systemUserAgent,
			 @ModelAttribute("staff") Staff staff, Model model,Cookyjar cookyjar) {
		
		staff.setPageSize(100);
	
		staff=(Staff) staffService.getPaginatedStaff(staff);
	    model.addAttribute("leaderlist", staff);
		staff = staffService.findById(staffId);
		model.addAttribute("staff", staff);

		return "/staff/edit";
	}
	
	

}
