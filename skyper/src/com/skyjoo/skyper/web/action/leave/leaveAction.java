package com.skyjoo.skyper.web.action.leave;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.jmx.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.attandance.service.AttandanceService;
import com.skyjoo.skyper.biz.leave.domain.Leave;
import com.skyjoo.skyper.biz.leave.service.LeaveService;
import com.skyjoo.skyper.web.action.BaseAction;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;

@Controller
public class leaveAction extends BaseAction{
	@Autowired
	private LeaveService leaveService;
	@Autowired 
	private AttandanceService attandanceService;

	@RequestMapping(value = "/leave/list.htm")
	public String getlist(ModelMap model ,@ModelAttribute("page2") Leave leave) {
		leave.setPageSize(5);
		
		leave =  (Leave)leaveService.getPaginatedLeave(leave);
	
		model.addAttribute("page2", leave);
		return "leave/list";
	}
	
	@RequestMapping(value = "/leave/accept.htm")
	public String accept(@RequestParam("id") Long id) throws Exception
	{
		Leave leave=leaveService.findById(id);
		leave.setIsAccept(1);
		//���뿼�ڱ�
		Attandance attandance=new Attandance();
		Date startDate=leave.getLeaveTime();
		Date endDate=leave.getLeaveTargetTime();
		
		if (startDate.after(endDate))
	        throw new Exception("��ʼʱ��Ӧ���ڽ���ʱ��֮��");
	    Long spi = endDate.getTime() - startDate.getTime();
	    Long step = spi / (24 * 60 * 60 * 1000);// �������

/*	    List<Date> dateList = new ArrayList<Date>();
	    dateList.add(endDate);
	    for (int i = 1; i <= step; i++) {
	        dateList.add(new Date(dateList.get(i - 1).getTime()
	                - (24 * 60 * 60 * 1000)));// ����һ���һ
	    }
		*/
	    for(int i=0;i<=step;i++)
	    {
	    	attandance.setStaffId(leave.getStaffId());
	    	attandance.setType(leave.getLeaveType());
	    	attandance.setStaffName(leave.getStaffName());
	    	attandance.setDatetime(new Date(startDate.getDate()+i*(24 * 60 * 60 * 1000)));
	    	attandanceService.save(attandance);
	    }
	    
	   
		leaveService.update(leave);
		
	       return "redirect:/leave/list.htm";
	}
    /*����*/
    @RequestMapping("/leave/detail.htm")
       public String detailInit(@RequestParam("id") Long id,
               @ModelAttribute("leave") Leave leave, Model model) {
    	leave= leaveService.findById(id);
           model.addAttribute("leave", leave);
           return "/leave/detail";
    }
	@RequestMapping(value = "/leave/leavecount.htm")
	public String leavecount(ModelMap model ,@ModelAttribute("page2") Leave leave,SystemUserAgent agent,Cookyjar cookyjar) {
		leave.setPageSize(5);
		leave.setStaffId(agent.getId());
		leave =  (Leave)leaveService.getPaginatedLeave(leave);
		model.addAttribute("page2", leave);
		return "leave/leavecount";
	}
}
