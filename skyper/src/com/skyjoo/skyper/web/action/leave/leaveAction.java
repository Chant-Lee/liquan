package com.skyjoo.skyper.web.action.leave;



import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springmodules.validation.bean.conf.loader.annotation.handler.Size;

import com.eyeieye.melos.web.cookyjar.Cookyjar;
import com.skyjoo.skyper.biz.attandance.domain.Attandance;
import com.skyjoo.skyper.biz.attandance.service.AttandanceService;
import com.skyjoo.skyper.biz.leave.domain.Leave;
import com.skyjoo.skyper.biz.leave.service.LeaveService;
import com.skyjoo.skyper.biz.staff.domain.Staff;
import com.skyjoo.skyper.biz.staff.service.StaffService;
import com.skyjoo.skyper.biz.total.domain.Total;
import com.skyjoo.skyper.biz.total.service.TotalService;
import com.skyjoo.skyper.web.action.BaseAction;
import com.skyjoo.skyper.web.action.leaveBase;
import com.skyjoo.skyper.web.action.Interceptor.AuthRole;
import com.skyjoo.skyper.web.cookyjar.SystemUserAgent;

@Controller
public class leaveAction extends leaveBase{
	@Autowired
	private LeaveService leaveService;
	@Autowired 
	private AttandanceService attandanceService;
	@Autowired 
	private StaffService staffService;
	@Autowired
	private TotalService totalService;
	@RequestMapping(value = "/leave/listR.htm")
	@AuthRole
	public String getlist(ModelMap model ,@ModelAttribute("page2") Leave leave) {
		leave.setPageSize(5);
		
		leave =  (Leave)leaveService.getPaginatedLeave(leave);
	
		model.addAttribute("page2", leave);
		return "leave/listR";
	}
	@RequestMapping(value = "/leave/list.htm")
	public String getlistByleader(ModelMap model ,@ModelAttribute("page2") Leave leave,SystemUserAgent agent,Cookyjar cookyjar)
	{
		leave.setPageSize(5);
		leave.setLeaderId(agent.getId());
		leave =  (Leave)leaveService.getPaginatedLeaveByleader(leave);
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
	    double step =  (spi *
	    		1.0/ (24 * 60 * 60 * 1000));// �������

	  
		 
		  int step2=(int) (spi / (24 * 60 * 60 * 1000));

		  if(step==step2)//��С��
		  {
			  
		  }
		  else //��С��
		  {
			  step=(int)step+0.5;
		  }
	    
	    Staff staff=staffService.findById(leave.getStaffId());
	    if(leave.getLeaveType().equals("���"))
	    {
	    	
	    	double annualleave=staff.getAnnualLeave();
	    	if(annualleave>=(step))
	    	{
	    	annualleave=annualleave-step;
	    	staff.setAnnualLeave(annualleave);
	    	staffService.update(staff);	
	    	}
	    	else {
	    		throw new Exception("��ٲ���");
			}
	    }
	    Total total=new Total();
	    total.setStaffid(staff.getId());
	    total.setYearmonth(startDate);//����ٿ�ʼ���ڼ�¼�����ڱ� �漰���������ݲ�����
	    total=    totalService.getSYM(total);
	    total=total.getData().get(0);
	    //������ʹ��� δ�����촦��
	    String remark="";
	    DateFormat df1 = DateFormat.getDateInstance();//���ڸ�ʽ����ȷ����
        System.out.println(df1.format(startDate));
        remark+=df1.format(startDate).toString();
        remark+=""+step+"��";
	    if(leave.getLeaveType().equals("���"))
	    {
	    	  total.setAnnual((step)+total.getAnnual());
	    	  total.setTotalannual((step)+total.getTotalannual());
	    	  
	    	  
	    }
	    if(leave.getLeaveType().equals("����"))
	    {
	    	total.setSice((step)+total.getSice());
	    	total.setTotalsice((step)+total.getTotalsice());
	    }
	    if(leave.getLeaveType().equals("���"))
	    {
	    	total.setMarriage((step)+total.getMarriage());
	    	//total.setTotalmaternity(value)
	    }
	    if(leave.getLeaveType().equals("����"))
	    {
	    	total.setMaternity((step)+total.getMaternity());
	    	total.setTotalmaternity((step)+total.getTotalmaternity());
	    }
	    if(leave.getLeaveType().equals("�����"))
	    {
	    	total.setNurse(total.getNurse()+(step));
	    	
	    }
	    if(leave.getLeaveType().equals("�¼�"))
	    {
	    	total.setThing((step)+total.getThing());
	    	total.setTotalthing((step)+total.getTotalthing());
	    }
	    if(leave.getLeaveType().equals("������"))
	    {
	    	total.setOther((step)+total.getOther());
	    	
	    }
	 
	    total.setRemark(total.getRemark()+remark);
	  
	    //��������
	    totalService.update(total);
	    
	    for(int i=0;i<=step;i++)
	    {
	    	attandance.setStaffId(leave.getStaffId());
	    	attandance.setType(leave.getLeaveType());
	    	attandance.setStaffName(leave.getStaffName());
	    	Date date=new Date(startDate.getTime()+i*(24 * 60 * 60 * 1000));
	    	attandance.setDatetime(new Date(startDate.getTime()+i*(24 * 60 * 60 * 1000)));
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
		double num=staffService.findById(agent.getId()).getAnnualLeave();
		model.put("annualLeaveRemain", num);
		return "leave/leavecount";
	}
}
