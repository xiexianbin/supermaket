package com.outexpense;

import java.util.List;

import com.employee.EmployeeBean;
import com.employee.EmployeeDao;
import com.mvc.http.aware.HttpAware;
import com.tools.Utils;


public class OutexpenseAction extends HttpAware{
	
	OutexpenseDao dao=new OutexpenseDao();
	
	//总支出列表
	public String selectTotalOut(){
		String datetime = request.getParameter("datetime");
		if(datetime==null){		
			String time = Utils.getDate();
			List<OutexpenseBean> list =dao.selectOutexpenseToday(time);
				request.setAttribute("LIST", list);
				request.setAttribute("TIME", time);
				return SUCCESS;
		}
		else{
			List<OutexpenseBean> list =dao.selectOutexpenseToday(datetime);
			request.setAttribute("LIST", list);
			request.setAttribute("TIME", datetime);
			return SUCCESS;
		}
	}
	
	
	
	
//	public String selectTotalOut(){
//		String datetime = request.getParameter("datetime");
////		System.out.println("****"+datetime+"****");
//		if(datetime==null){		
//			String time = Utils.getDate();
//			
//			List<OutexpenseBean> list =dao.selectOutexpenseToday(time);
//			if(list!=null){
//				request.setAttribute("LIST", list);
//				request.setAttribute("TIME", time);
//				return SUCCESS;
//			}else{
//				return ERROR;
//			}
//		}else{
//			if(datetime.length()==4){
//				
//				List<OutexpenseBean> list =dao.selectOutexpenseYear(datetime);
//				if(list!=null){
//					request.setAttribute("LIST", list);
//					request.setAttribute("TIME", datetime);
//					return SUCCESS;
//				}else{
//					return ERROR;
//				}
//			}else if(datetime.length()==7){
//				
//				List<OutexpenseBean> list=dao.selectOutexpenseMonth(datetime);
//				if(list!=null){
//					request.setAttribute("LIST", list);
//					request.setAttribute("TIME", datetime);
//					return SUCCESS;
//				}else{
//					return ERROR;
//				}
//			}else if(datetime.length()==10){
//				List<OutexpenseBean> list=dao.selectOutexpenseToday(datetime);
//				if(list!=null){
//					request.setAttribute("LIST", list);
//					request.setAttribute("TIME", datetime);
//					return SUCCESS;
//				}else{
//					return ERROR;
//				}
//			}
//		}
//		return ERROR;
//	}

	
	
	//支出列表
	public String outexpenseList(){
		List<OutexpenseBean> outexpenseList=dao.outexpenseList();
		request.setAttribute("outexpenseList", outexpenseList);
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
			row=dao.deleteOutexpense(mess1);
		}
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	//查找单个
	public String selectOneOutexpense(){
		OutexpenseBean outexpense=dao.selectOneOutexpense(Integer.parseInt(request.getParameter("outExpenId")));
		EmployeeDao employeeDao = new EmployeeDao();
		List<EmployeeBean> employeeList = employeeDao.getEmployeeList();
		if(outexpense!=null){
			
			request.setAttribute("employeeList", employeeList);
			request.setAttribute("outexpense", outexpense);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//添加支出信息
	public String insertOutexpense(){
		String outDate=request.getParameter("outDate");
		outDate=outDate.replace("-", "");
		OutexpenseBean outexpense=new OutexpenseBean();
		outexpense.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		outexpense.setOutReason(request.getParameter("outReason"));
		outexpense.setMoney(Float.parseFloat(request.getParameter("money")));
		outexpense.setOutDate(outDate);
		outexpense.setRemarks(request.getParameter("remarks"));
		int row=dao.insertOutexpense(outexpense);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	//更新支出信息
	public String updateOutexpense(){
		String outDate=request.getParameter("outDate");
		outDate=outDate.replace("-", "");
		OutexpenseBean outexpense=new OutexpenseBean();
		outexpense.setOutExpenId(Integer.parseInt(request.getParameter("outExpenId")));
		outexpense.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		outexpense.setOutReason(request.getParameter("outReason"));
		outexpense.setMoney(Float.parseFloat(request.getParameter("money")));
		outexpense.setOutDate(outDate);
		outexpense.setRemarks(request.getParameter("remarks"));
		int row=dao.updateOutexpense(outexpense);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String outexpenseInsert1(){
		EmployeeDao employeeDao = new EmployeeDao();
		List<EmployeeBean> employeeList = employeeDao.getEmployeeList();
		String nowTime=Utils.getDateTime();
		
		request.setAttribute("time", nowTime);
		request.setAttribute("employeeList", employeeList);
		return SUCCESS;
	}

}
