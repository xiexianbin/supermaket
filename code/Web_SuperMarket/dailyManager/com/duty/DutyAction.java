package com.duty;

import java.util.List;

import com.employee.EmployeeBean;
import com.employee.EmployeeDao;
import com.mvc.http.aware.HttpAware;
import com.part.PartBean;
import com.part.PartDao;

public class DutyAction extends HttpAware {

	DutyDao dutyDao = new DutyDao();
	PartDao partDao = new PartDao();
	//值班列表
	public String dutyList(){
		//值班信息列表
		List<DutyBean> dutyList = dutyDao.dutyList();
		//部门列表
		List<PartBean> partList = partDao.selectAllPartInfo();
		
		request.setAttribute("dutyList", dutyList);
		request.setAttribute("partList", partList);
		
		return SUCCESS;
	}
	//部门值班列表
	public String dutyDeptList(){
//		int deptId = Integer.parseInt(request.getParameter("deptId"));
//		System.out.println("deptId");
		List<DutyBean> dutyList = dutyDao.dutyDeptList(1007);
		System.out.println(dutyList.size());
		request.setAttribute("dutyList", dutyList);
		return SUCCESS;
	}
	//添加值班信息
	public String addDuty(){
		int dutyId = dutyDao.getDutyIdIndex();
		request.setAttribute("dutyId", dutyId+1);
		EmployeeDao employeeDao = new EmployeeDao();
		List<EmployeeBean> employeeList = employeeDao.getEmployeeList();
		request.setAttribute("employeeList", employeeList);
		return SUCCESS;
	}
	//获取用户的基本信息
	public String getEmployeeInf(){
//		System.out.println("getEmployeeInf();");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String empInf = dutyDao.getEmpInf(employeeId);
		request.setAttribute("empInf", empInf);
		return SUCCESS;
	}
	
	//添加值班信息
	public String addDutyMethod(){
		String employeeId = request.getParameter("employeeId");
		String date = request.getParameter("date");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		String remarks = request.getParameter("remarks");
		
		System.out.println(employeeId+date+beginTime+endTime+remarks);
		
		DutyBean dutyBean = new DutyBean();
		
		dutyBean.setBeginTime(beginTime);
		dutyBean.setDate(date);
		dutyBean.setEmployeeId(Integer.parseInt(employeeId));
		dutyBean.setEndTime(endTime);
		dutyBean.setRemarks(remarks);
		
		int row = dutyDao.insertDuty(dutyBean);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
