package com.salary;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import com.employee.EmployeeBean;
import com.mvc.http.aware.HttpAware;
import com.tools.Utils;

public class WagesAction extends HttpAware{
	WagesDao dao=new WagesDao();
    public String Ajax(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		//获取员工基本信息
		int employeeId=Integer.parseInt(request.getParameter("employeeId"));
		EmployeeBean eb=dao.selectEmp(employeeId);
		int deptId=eb.getDeptId();
		String deptName=dao.selectOnePartInfo(deptId);
		String employeeName=eb.getEmployeeName();
		int basicWage=(int) eb.getBasicWage();
		//查询上个月月份
		Date da=new Date();
		int date1=da.getMonth();
		String d="";
		if(date1<10){
			d="0"+(date1+1);
		}else{
			d=""+(date1+1);
		}
		String date=Utils.getDate();
		date=date.substring(0, 5);
		String date2=date+d;
		
		//查看员工是否发过工资
		String mess="";
		String sql="select * from salary_tab where salarytime like '"+date2+"%' and employeeId="+employeeId;
		int num=dao.onesalary(sql);
		if(num==1){
			mess="fg";//提示已发过工资
		}
		//获取考情表信息
		String date3=""+date+date1;
		//正常上班天数
		String sql1="select count(date) as num from recordcheck_tab where date like '"+date3+"%' and employeeId="+employeeId+" and late=0 and early=0 and absenteeism=0";
		int num1=dao.selectNum(sql1);
		//System.out.println(num1+"******");
		//迟到次数
		String sql2="select count(date) as num from recordcheck_tab where date like '"+date3+"%' and employeeId="+employeeId+" and late=1";
		int num2=dao.selectNum(sql2);
		
		//早退次数
		String sql3="select count(date) as num from recordcheck_tab where date like '"+date3+"%' and employeeId="+employeeId+" and early=1";
		int num3=dao.selectNum(sql3);
		
		//旷工次数
		String sql4="select count(date) as num from recordcheck_tab where date like '"+date3+"%' and employeeId="+employeeId+" and absenteeism=1";
		int num4=dao.selectNum(sql4);
		
		//加班次数
		String sql5="select count(date) as num from recordcheck_tab where  date like '"+date3+"%' and employeeId="+employeeId+" and overtime=1";
		int num5=dao.selectNum(sql5);
		//System.out.println(num5+"****");
		
		
		int wages=(int) (basicWage+num1*50+num5*50-num2*20-num3*20-num4*100);
		
		request.setAttribute("mess", deptName+"-"+employeeName+"-"+basicWage+"-"+wages+"-"+mess+"-over");
		
		return SUCCESS;
		
	}
	
    //添加工资信息
    public String addSalary(){
    	SalaryBean bean=new SalaryBean();
    	bean.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
    	bean.setSalary(Integer.parseInt(request.getParameter("salary")));
    	bean.setRemarks(request.getParameter("remarks"));
    	bean.setSalaryTime(Utils.getDate());
    	int row=dao.insertSalary(bean);
    	if(row!=0){
    		return SUCCESS;
    	}
    	return ERROR;
    }
    
    
    //工资信息列表
    
    public String sList(){
    	List<SalaryBean> list=dao.selectAll();
    	request.setAttribute("list", list);
    	if(list!=null){
    		request.setAttribute("list", list);
    		return SUCCESS;
    	}
    	return ERROR;
    }
    
    //今年工资详情
    public String onewages(){
    	int employeeId=Integer.parseInt(request.getParameter("employeeId"));
    	List<SalaryBean> list=dao.selectOne(employeeId);
    	String name="";
    	double num1[]=new double[12];
    	for(int i=0;i<list.size();i++){
    		SalaryBean bean=list.get(i);
    		//System.out.println(bean.getSalaryTime().substring(5, 7));
    		//System.out.println(bean.getSalary());
    		num1[Integer.parseInt(bean.getSalaryTime().substring(5, 7))-1]=bean.getSalary();
    		name=bean.getEmployeeName();
    	}
    	String row[]={"工资"};
		String col[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
		double num[][]={num1};
		//double num[][]={{60,40,30,70,50,40,30,70,50,40,50,40}};
		CategoryDataset cd=DatasetUtilities.createCategoryDataset(row, col, num);
		JFreeChart chart=ChartFactory.createBarChart3D(name+"今年工资详情", "月份/月", "工资/元", cd, PlotOrientation.VERTICAL, true, true, true);
		
		chart.getTitle().setFont(new Font("黑体", Font.BOLD, 20));
		Font font=new Font("隶书",Font.ITALIC,14);
		
		chart.getLegend().setItemFont(font);
		
		CategoryPlot plot= chart.getCategoryPlot();
		
		//获取X轴
		CategoryAxis X=plot.getDomainAxis();
			X.setLabelFont(font);
			X.setTickLabelFont(font);
				
		//获取Y轴
	    ValueAxis Y=plot.getRangeAxis();
			Y.setLabelFont(font);
			Y.setTickLabelFont(font);
		//存储文件路径
		File files=new File(request.getRealPath("/")+"others/"+employeeId+".jpg");
		System.out.println(request.getRealPath("/")+"others/"+employeeId+".jpg");
		//创建文件并保存到files中	
		try {
			ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("employeeId", employeeId+".jpg");
    	request.setAttribute("list", list);
    	if(list!=null){
    		request.setAttribute("list", list);
    		return SUCCESS;
    	}
    	return ERROR;
    }
    

}
