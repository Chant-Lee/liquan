package com.skyjoo.skyper.web.action.hrs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.staff.service.StaffService;
import com.skyjoo.skyper.web.action.BaseAction;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;



@Controller
public class HrAction extends BaseAction{
	
	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "/hr/list.htm")
	public String getlist(ModelMap model ,@ModelAttribute("page2") Staff staff) {
		
	     String staffName = staff.getStaffName();
	        if (staffName != null) {
	        	staff.setStaffName(staffName.trim());
	        }
		
		staff.setPageSize(10);
		
		staff =  (Staff)staffService.getPaginatedStaff(staff);
		model.addAttribute("page2", staff);
	
		return "hr/list";
	}
	
       @RequestMapping("/hr/edit-init.htm")
       public String editInit(@RequestParam("id") Long staffId,
               @ModelAttribute("staff") Staff staff, Model model) {
    	   staff= staffService.findById(staffId);
    	   model.addAttribute("staffId", staffId);
           model.addAttribute("staff", staff);
           return "/hr/edit";
    }
	
	    @RequestMapping(value = "/hr/edit.htm")
	    public String edit(@ModelAttribute("staff") Staff staff,
	                       HttpServletRequest request, SystemUserAgent agent, Model model) {
	    				String photo=staffService.findById(staff.getId()).getPhoto();
	    				if(staff.getPhoto()==null||staff.getPhoto()=="")
	    					staff.setPhoto(photo);
	    	             staffService.update(staff);
	    	
	    	
	    	         	return "redirect:/hr/list.htm";
	    }
	    
	    
	    
	    
	    
	    /*ฯ๊ว้*/
	    @RequestMapping("/hr/detail.htm")
	       public String detailInit(@RequestParam("id") Long staffId,
	               @ModelAttribute("staff") Staff staff, Model model) {
	    	   staff= staffService.findById(staffId);
	           model.addAttribute("staff", staff);
	           return "/hr/detail";
	    }
		

	    
	    
	    
	    
	    
	    
	
}
