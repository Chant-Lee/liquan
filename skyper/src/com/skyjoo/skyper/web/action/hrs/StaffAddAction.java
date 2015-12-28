package com.skyjoo.skyper.web.action.hrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.biz.common.upload.UploadFileException;
import com.skyjoo.skyper.biz.common.upload.UploadFileResult;
import com.skyjoo.skyper.biz.common.upload.UploadManager;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.staff.service.StaffService;
import com.skyjoo.skyper.web.action.BaseAction;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;

@Controller
public class StaffAddAction extends BaseAction{
	@Autowired
	private	StaffService staffService;
	@RequestMapping(value = "hr/add-init.htm")
	public String add(@ModelAttribute("staff") Staff staff,
			BindingResult result, ModelMap model,SystemUserAgent agent,Cookyjar cookyjar) {	
			return "hr/addStaff";
	}
	 @Autowired UploadManager uploadManager;
	@RequestMapping(value = "/hr/add.htm", method = RequestMethod.POST)
	public String success(@ModelAttribute("staff") Staff staff,
			BindingResult result, ModelMap model,SystemUserAgent agent,Cookyjar cookyjar,@RequestParam("upfile") MultipartFile upfile) throws UploadFileException {		
		UploadFileResult result2= uploadManager.uploadFile(upfile);
		if(result2.isSuccess())
		{
			staff.setPhoto(result2.getFilePath());
			staffService.save(staff);
		}
	
	
		return "redirect:/hr/list.htm";
	}
}
