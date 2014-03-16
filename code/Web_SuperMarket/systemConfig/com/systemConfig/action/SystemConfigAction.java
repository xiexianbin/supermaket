package com.systemConfig.action;

import com.employee.EmployeeBean;
import com.employee.EmployeeDao;
import com.mvc.http.aware.HttpAware;
import com.systemConfig.dao.systemConfigDao;

public class SystemConfigAction extends HttpAware{
	
	public String checkPassword(){
		int id = Integer.parseInt(request.getSession().getAttribute("loginId").toString());
		String pass = request.getParameter("pass");
		systemConfigDao sd = new systemConfigDao();
		if(sd.selectLoginUser(id, pass)){
			request.setAttribute("ANS", "°Ã");
			request.setAttribute("PASSWORD", pass);
			return SUCCESS;
		}else{
			request.setAttribute("ANS", "√‹¬Î”–ŒÛ");
			request.setAttribute("PASSWORD", pass);
			return ERROR;
		}
	}
	
	public String updatePassword(){
		int id = Integer.parseInt(request.getSession().getAttribute("loginId").toString());
		String pass = request.getParameter("newPassword");
		systemConfigDao sd = new systemConfigDao();
		if(sd.updatePassword(id, pass)){
			request.setAttribute("MESS", "–ﬁ∏ƒ≥…π¶!");
			return SUCCESS;
		}else{
			request.setAttribute("MESS", "–ﬁ∏ƒ√‹¬Î ß∞‹!");
			return ERROR;
		}
	}
	public String findEmployee(){
		String id = request.getParameter("mess");
		if(id!=""){
			systemConfigDao scd = new systemConfigDao();
			String state = scd.selectUserState(Integer.parseInt(id));
			EmployeeDao dao=new EmployeeDao();
			EmployeeBean bean=dao.findEmployee(Integer.parseInt(id));
			if(bean!=null){
				String dept = scd.findDeptName(bean.getDeptId()); 
				request.setAttribute("employeeData", bean);
				request.setAttribute("State", state);
				request.setAttribute("Dept", dept);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
		
	}
	public String updateState(){
		String id = request.getParameter("employeeId");
		String state = request.getParameter("state");
		systemConfigDao scd = new systemConfigDao();
		if(scd.updateState(Integer.parseInt(id), state)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
