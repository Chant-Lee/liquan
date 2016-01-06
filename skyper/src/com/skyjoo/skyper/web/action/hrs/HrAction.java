package com.skyjoo.skyper.web.action.hrs;

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
import com.skyjoo.skyper.web.action.Interceptor.AuthRole;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;

@Controller
public class HrAction extends BaseAction {

	@Autowired
	private StaffService staffService;
	@AuthRole
	@RequestMapping(value = "/hr/list.htm")
	public String getlist(ModelMap model, @ModelAttribute("page2") Staff staff) {

		String staffName = staff.getStaffName();
		if (staffName != null) {
			staff.setStaffName(staffName.trim());
		}

		staff.setPageSize(10);

		staff = (Staff) staffService.getPaginatedStaff(staff);
		model.addAttribute("page2", staff);

		return "hr/list";
	}
	@AuthRole
	@RequestMapping("/hr/edit-init.htm")
	public String editInit(@RequestParam("id") String staffId,SystemUserAgent systemUserAgent,
			 @ModelAttribute("staff") Staff staff, Model model,Cookyjar cookyjar) {
		
		staff.setPageSize(100);
	
		staff=(Staff) staffService.getPaginatedStaff(staff);
	    model.addAttribute("leaderlist", staff);
		staff = staffService.findById(staffId);
		model.addAttribute("staff", staff);

		return "/hr/edit";
	}
/**
 * 编辑保存
 * @param staff
 * @param request
 * @param agent
 * @param model
 * @return
 */@AuthRole
	@RequestMapping(value = "/hr/edit.htm")
	public String edit(@ModelAttribute("staff") Staff staff,
			HttpServletRequest request, SystemUserAgent agent, Model model) {
		Staff s=staffService.findById(staff.getId());
		String photo = s.getPhoto();
		if (staff.getPhoto() == null || staff.getPhoto() == "")
			staff.setPhoto(photo);
		int  isAdmin= s.getIsAdmin();	  
			  staff.setIsAdmin(isAdmin);
	    String passwordString=s.getPassword();
	      staff.setPassword(passwordString);
		staffService.update(staff);
	

		return "redirect:/hr/list.htm";
	}

	/* 详情 */
	@AuthRole
	@RequestMapping("/hr/detail.htm")
	public String detailInit(@RequestParam("id") String staffId,
			@ModelAttribute("staff") Staff staff, Model model) {
		staff = staffService.findById(staffId);
		model.addAttribute("staff", staff);
		return "/hr/detail";
	}
	/* 部分详情 */
	@RequestMapping("/staff/detail.htm")
	public String detailInit2(@RequestParam("id") String staffId,
			@ModelAttribute("staff") Staff staff, Model model) {
		staff = staffService.findById(staffId);
		model.addAttribute("staff", staff);
		return "/staff/detail";
	}
	@AuthRole
	@RequestMapping("/hr/remove.htm")
	public String removeStaffById(@RequestParam("id") String staffId,Model model) {
		staffService.delete(staffId);
		return "redirect:/hr/list.htm";
	}
	@AuthRole
	@RequestMapping("/hr/addAdmin.htm")
	public String addAdmin(@RequestParam("id") String staffId,Model model){
	  Staff	staff =staffService.findById(staffId);
	  staff.setIsAdmin(1);
	    staffService.update(staff);
	    return "redirect:/hr/list.htm";
	}  
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/common/tagbox.htm")
	public String getlistfortag(ModelMap model, @ModelAttribute("page2") Staff staff,SystemUserAgent agent,Cookyjar cookyjar) {

		String staffName = staff.getStaffName();
		if (staffName != null) {
			staff.setStaffName(staffName.trim());
		}

		staff.setPageSize(10);

		staff = (Staff) staffService.getPaginatedStaff(staff);
		model.addAttribute("page2", staff);
		
        /*合同提醒*/
		if(agent.getIsAdmin().equals(1))
		{
			Date now=new Date();
			int size=staff.getData().size();
			int Month=now.getMonth();
			int Year=now.getYear();

			 for(int i=0;i<size;i++)
			 {
				 Date date=staff.getData().get(i).getJobDeadLine();
				 if(date!=null)
				 {
				 if(Year==date.getYear())
				 {
					 if(Month+1>=date.getMonth()&&(Month<=date.getMonth()&&now.getDay()<=date.getDay()))
					 {
						 model.put("hetong", "部分合同到期");
						break;
					 }
				 }
				 }
				 
			 }	
		}
	
		
		
		return "common/tagbox";
	}
	
	/**
	 * 员工合同时间管理
	 */
	@AuthRole
	@RequestMapping("/hr/contract.htm")
	public String contractManagement( @ModelAttribute("page3") Staff staff,Model model){

		String staffName = staff.getStaffName();
		if (staffName != null) {
			staff.setStaffName(staffName.trim());
		}

		staff.setPageSize(10);

		staff = (Staff) staffService.getPaginatedStaff(staff);
		model.addAttribute("page3", staff);
		return "hr/contract";
	}

}
