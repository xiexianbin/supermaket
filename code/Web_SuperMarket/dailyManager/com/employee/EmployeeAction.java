package com.employee;

import com.mvc.http.aware.HttpAware;
import com.part.PartBean;
import com.part.PartDao;





import java.util.ArrayList;


public class EmployeeAction extends HttpAware{

	EmployeeDao dao=new EmployeeDao();
	
	//ajax用的
	public String getDeptInf(){
		
//		System.out.println("getDeptInfAction");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String deptInfo = dao.getDeptInfo(deptId);
		request.setAttribute("deptInfo", deptInfo);
		return SUCCESS;
	}
	
	
	
	
	
	
	public String getEmployeelist(){
		
		ArrayList<EmployeeBean> list=dao.getEmployeeList();
		
		
		if(list!=null){
			request.setAttribute("employeeList", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	
	
	public String editAddEmployee(){
//		System.out.println("editAddEmployee");
		
		PartDao pdao=new PartDao();
		
		ArrayList<PartBean> list=(ArrayList<PartBean>) pdao.selectAllPartInfo();
		request.setAttribute("partList", list);
		if(list!=null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	
	
	
	public String addEmployee(){
		EmployeeBean eb=new EmployeeBean();
		
		eb.setEmployeeName(request.getParameter("employeeName"));
		
		
		
		
		eb.setEmployeeBirthday(request.getParameter("birthday"));
		
		eb.setEmployeeSex(request.getParameter("employeeSex"));
		eb.setEmployeeIdNum(request.getParameter("employeeIdNum"));
		eb.setEmpPoliState(request.getParameter("empPoliState"));
		eb.setEmployeePicture(request.getParameter("employeePicture"));
		eb.setEmployeeTel(request.getParameter("employeeTel"));
		eb.setEmployeeQq(request.getParameter("employeeQq"));
		eb.setEmployeeEmail(request.getParameter("employeeEmail"));
		eb.setEmployeeSchool(request.getParameter("employeeSchool"));
		eb.setEmployeeAddress(request.getParameter("employeeAddress"));
		eb.setEmployeePosition(request.getParameter("employeePosition"));
		
		
		eb.setBasicWage(Float.parseFloat(request.getParameter("basicWage")));
//		eb.setBasicWage(Float.parseFloat("100.0"));
		
		eb.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		
		
		eb.setEntryTime(request.getParameter("entryTime"));
		eb.setLeaveTime(request.getParameter("leaveTime"));
		eb.setEmployeeState("在职");
		eb.setRemarks(request.getParameter("remarks"));
		
		
		
		
		
//		gt.setProductTypeName(request.getParameter("productTypeName"));
//		gt.setRemarks(request.getParameter("remarks"));
		
		
		
		int row=dao.insertEmployee(eb);    
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	
	public String findEmployeeData(){
		int id=Integer.parseInt(request.getParameter("id"));
		EmployeeBean bean=dao.findEmployee(id);     
		if(bean!=null){
			request.setAttribute("employeeData", bean);
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	
	
	
	public String updateEmployee(){
		EmployeeBean eb=new EmployeeBean();
		eb.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		eb.setEmployeeName(request.getParameter("employeeName"));
		
		eb.setEmployeeBirthday(request.getParameter("employeeBirthday"));
		eb.setEmployeeSex(request.getParameter("employeeSex"));
		eb.setEmployeeIdNum(request.getParameter("employeeIdNum"));
		eb.setEmpPoliState(request.getParameter("empPoliState"));
		eb.setEmployeePicture(request.getParameter("employeePicture"));
		eb.setEmployeeTel(request.getParameter("employeeTel"));
		eb.setEmployeeQq(request.getParameter("employeeQq"));
		eb.setEmployeeEmail(request.getParameter("employeeEmail"));
		eb.setEmployeeSchool(request.getParameter("employeeSchool"));
		eb.setEmployeeAddress(request.getParameter("employeeAddress"));
		eb.setEmployeePosition(request.getParameter("employeePosition"));
		
		
		eb.setBasicWage(Float.parseFloat(request.getParameter("basicWage")));
		eb.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		
		
		eb.setEntryTime(request.getParameter("entryTime"));
		eb.setLeaveTime(request.getParameter("leaveTime"));
		eb.setEmployeeState(request.getParameter("employeeState"));
		eb.setRemarks(request.getParameter("remarks"));
		
		
		
		
		
//		bean.setProductTypeId(Integer.parseInt(request.getParameter("productTypeId")));
//		bean.setProductTypeName(request.getParameter("productTypeName"));
		int row=dao.updateUser(eb);    
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	
	
	
	
	
	
	public String employeeDetails(){
		int id=Integer.parseInt(request.getParameter("id"));
		EmployeeBean bean=dao.findEmployee(id);  
		if(bean!=null){
			request.setAttribute("employeeData", bean);
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	
	
	
	
	
	
	
}
