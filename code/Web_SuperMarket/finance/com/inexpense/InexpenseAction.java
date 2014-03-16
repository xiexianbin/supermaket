package com.inexpense;

import java.util.List;

import com.employee.EmployeeBean;
import com.employee.EmployeeDao;
import com.mvc.http.aware.HttpAware;

import com.tools.Utils;


public class InexpenseAction extends HttpAware{

	InexpenseDao dao=new InexpenseDao();
	
	//总支出列表
		public String selectTotalIn(){
			String datetime = request.getParameter("datetime");
			if(datetime==null){		
				String time = Utils.getDate();
				List<InexpenseBean> list =dao.selectInexpenseToday(time);
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", time);
					return SUCCESS;
			}
			else{
				List<InexpenseBean> list =dao.selectInexpenseToday(datetime);
				request.setAttribute("LIST", list);
				request.setAttribute("TIME", datetime);
				return SUCCESS;
			}
		}
	
	
	    //收入列表
		public String inexpenseList(){
			List<InexpenseBean> inexpenseList=dao.inexpenseList();
			request.setAttribute("inexpenseList", inexpenseList);
			return SUCCESS;
		}
		
		public String deleteSelect(){
			String a=request.getParameter("a");
			System.out.println(a);
			String b[]=a.split(",");
			int row=0;
			for(int i=0;i<b.length;i++){
				String mess=b[i];
				System.out.println(mess);
				int mess1=Integer.parseInt(mess);
				row=dao.deleteInexpense(mess1);
			}
			if(row!=0){
				return SUCCESS;
			}
			return ERROR;
		}
		
		
		//查找单个
		public String selectOneInexpense(){
			InexpenseBean inexpense=dao.selectOneInexpense(Integer.parseInt(request.getParameter("inExpenId")));
			EmployeeDao employeeDao = new EmployeeDao();
			List<EmployeeBean> employeeList = employeeDao.getEmployeeList();
			if(inexpense!=null){
				
				request.setAttribute("employeeList", employeeList);
				request.setAttribute("inexpense", inexpense);
				return SUCCESS;
			}
			return ERROR;
		}
		
		//添加收入信息
		public String insertInexpense(){
			String inDate=request.getParameter("inDate");
			inDate=inDate.replace("-", "");
			InexpenseBean inexpense=new InexpenseBean();
			inexpense.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
			inexpense.setInReason(request.getParameter("inReason"));
			inexpense.setMoney(Float.parseFloat(request.getParameter("money")));
			inexpense.setInDate(inDate);
			inexpense.setRemarks(request.getParameter("remarks"));
			int row=dao.insertInexpense(inexpense);
			if(row!=0){
				return SUCCESS;
			}
			return ERROR;
		}
		
		//更新收入信息
		public String updateInexpense(){
			String inDate=request.getParameter("inDate");
			System.out.println(inDate);
			inDate=inDate.replace("-", "");
			System.out.println(inDate);
			InexpenseBean inexpense=new InexpenseBean();
			inexpense.setInExpenId(Integer.parseInt(request.getParameter("inExpenId")));
			inexpense.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
			inexpense.setInReason(request.getParameter("inReason"));
			inexpense.setMoney(Float.parseFloat(request.getParameter("money")));
			inexpense.setInDate(inDate);
			inexpense.setRemarks(request.getParameter("remarks"));
			int row=dao.updateInexpense(inexpense);
			if(row!=0){
				return SUCCESS;
			}
			return ERROR;
		}
		
		public String inexpenseInsert1(){
			EmployeeDao employeeDao = new EmployeeDao();
			List<EmployeeBean> employeeList = employeeDao.getEmployeeList();
			String nowTime=Utils.getDateTime();
			
			request.setAttribute("time", nowTime);
			request.setAttribute("employeeList", employeeList);
			return SUCCESS;
		}
}
