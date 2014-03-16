package com.empSaleStatistics;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.employee.EmployeeBean;
import com.mvc.http.aware.HttpAware;

public class EmpSaleStaAction extends HttpAware{
	
	
	EmpSaleStaDao dao=new EmpSaleStaDao();
	
	
	
	public String empSaleStatisticsList(){
		
		ArrayList<EmpSaleStaBean> wuxuList=new ArrayList<EmpSaleStaBean>();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String dat=sdf.format(date).replace("-", "");;
		if(request.getParameter("selectDate")!=null){//如果页面未获取到，默认为本月
			
			if(!request.getParameter("selectDate").equals("")){
				//2013-11-11
//				System.out.println("获取到的时间："+request.getParameter("selectDate"));
				String sd=request.getParameter("selectDate");
				String sd1=sd.replace("-", "");
				String sd2=sd1.substring(0, 6);
				dat=sd2;
			}

		}
//		System.out.println("截取后的时间："+dat);
		String dattt=dat.substring(0, 4)+"年"+dat.substring(4)+"月";
		request.setAttribute("dattt", dattt);
//		System.out.println("输出的时间："+dattt);
		
		ArrayList<EmployeeBean> emList=dao.getEmployeeList();//获取销售员名单
		
		//遍历销售员
		for(int s=0;s<emList.size();s++){
			float money = 0;
			int employeeId=0;
			String employeeName="";
			EmpSaleStaBean bean=new EmpSaleStaBean();//要返回的消除重复的bean
			
			EmployeeBean eBean=emList.get(s);
//			System.out.println("第"+(s+1)+"个销售员"+eBean.getEmployeeName());//////////////////
			ArrayList<EmpSaleStaBean> everyList=dao.getEveryEmpSaleStaList(eBean.getEmployeeId(),dat);
			//遍历每一位销售员的销售信息
			for(int i=0;i<everyList.size();i++){
				
				EmpSaleStaBean esBean=everyList.get(i);
				employeeName=esBean.getEmployeeName();
//				System.out.println(employeeName+"的销售记录");//////////
//				System.out.println(esBean.getProductId());///////////////////
				employeeId=esBean.getEmployeeId();
				money=money+esBean.getProductPrice()*esBean.getCount();//本月的销售总额
				
			}
			
			
			
			bean.setEmployeeId(employeeId);
			bean.setEmployeeName(employeeName);
			bean.setMoney(money);
			wuxuList.add(bean);
		}
		

		
		
		//按照销售额排序
		EmpSaleStaBean tebean=new EmpSaleStaBean();
		for(int i=0;i<wuxuList.size();i++){
			for(int j=0;j<wuxuList.size()-i-1;j++){
				if(wuxuList.get(j).getMoney()<wuxuList.get(j+1).getMoney()){
					tebean=wuxuList.get(j+1);
					wuxuList.set(j+1, wuxuList.get(j));
					wuxuList.set(j, tebean);
				}
			}
		}
		
		
//		for(int i=0;i<wuxuList.size();i++){
//			EmpSaleStaBean ceshibean=wuxuList.get(i);
//			System.out.println("排序后的第"+(i+1)+"名次的销售额："+ceshibean.getMoney());
//		}
		
		
		
		
		
		
		
		request.setAttribute("returnList", wuxuList);
			return SUCCESS;
	}
	

}
