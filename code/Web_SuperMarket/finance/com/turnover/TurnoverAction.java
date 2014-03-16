package com.turnover;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
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

import com.mvc.http.aware.HttpAware;
import com.salary.SalaryBean;
import com.tools.Utils;

public class TurnoverAction extends HttpAware{
	/**
	 * 营业额统计
	 * @return
	 */
	public String turnoverList(){
		String datetime = request.getParameter("datetime");
		String date = request.getParameter("date");
//		System.out.println("****"+datetime+"****"+date+"********");
		if(datetime==null){		
			String id = String.valueOf(request.getSession().getAttribute("loginId"));
			String time = Utils.getDate();
			TurnoverDao dao = new TurnoverDao();
			List<TurnoverBean> list = dao.selectTurnoverToday(id, time);
			if(list!=null){
				request.setAttribute("LIST", list);
				request.setAttribute("TIME", time);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			if(datetime.length()==4){
				String id = String.valueOf(request.getSession().getAttribute("loginId"));
				TurnoverDao dao = new TurnoverDao();
				List<TurnoverBean> list = dao.selectTurnoverYear(id, datetime);
				if(list!=null){
					date+="-0-0";
//					System.out.println(datetime);
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", date);
					return SUCCESS;
				}else{
					return ERROR;
				}
			}else if(datetime.length()==7){
				String id = String.valueOf(request.getSession().getAttribute("loginId"));
				TurnoverDao dao = new TurnoverDao();
				List<TurnoverBean> list = dao.selectTurnoverMonth(id, datetime);
				if(list!=null){
					date+="-0";
//					System.out.println(datetime);
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", date);
					return SUCCESS;
				}else{
					return ERROR;
				}
			}else if(datetime.length()==10){
				String id = String.valueOf(request.getSession().getAttribute("loginId"));
				TurnoverDao dao = new TurnoverDao();
				List<TurnoverBean> list = dao.selectTurnoverToday(id, datetime);
				if(list!=null){
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", date);
					return SUCCESS;
				}else{
					return ERROR;
				}
			}
		}
		return ERROR;
	}
	/**
	 * 营业额报表
	 * @return
	 */
	public String barGraph(){
		String datetime = request.getParameter("datetime");
		if(datetime.length()==4){
			String id = String.valueOf(request.getSession().getAttribute("loginId"));
			TurnoverDao dao = new TurnoverDao();
			List<TurnoverBean> list = dao.selectTurnoverYear(id, datetime);
			if(list!=null){
				//
				String name="";
		    	double num1[]=new double[12];
		    	for(int i=0;i<list.size();i++){
		    		TurnoverBean bean=list.get(i);
		    		//System.out.println(bean.getSalaryTime().substring(5, 7));
		    		//System.out.println(bean.getSalary());
		    		num1[i]=bean.getMoney();
		    		//name=bean.getEmployeeName();
		    	}
		    	String row[]={"营业额"};
				String col[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
				double num[][]={num1};
				//double num[][]={{60,40,30,70,50,40,30,70,50,40,50,40}};
				CategoryDataset cd=DatasetUtilities.createCategoryDataset(row, col, num);
				JFreeChart chart=ChartFactory.createBarChart3D(name+"营业额详情", "月份/月", "营业额/元", cd, PlotOrientation.VERTICAL, true, true, true);
				
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
				File files=new File(request.getRealPath("/")+"others/"+datetime+".jpg");
//				System.out.println(request.getRealPath("/")+"others/"+datetime+".jpg");
				//创建文件并保存到files中	
				try {
					ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				} catch (IOException e) {
					e.printStackTrace();
				}
				request.setAttribute("datetime", datetime+".jpg");
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else if(datetime.length()==7){
			String id = String.valueOf(request.getSession().getAttribute("loginId"));
			TurnoverDao dao = new TurnoverDao();
			List<TurnoverBean> list = dao.selectTurnoverMonth(id, datetime);
			if(list!=null){
//				System.out.println(datetime);
				String name="";
		    	double num1[]=new double[31];
		    	for(int i=0;i<list.size();i++){
		    		TurnoverBean bean=list.get(i);
		    		//System.out.println(bean.getSalaryTime().substring(5, 7));
		    		//System.out.println(bean.getSalary());
		    		num1[i]=bean.getMoney();
		    		//name=bean.getEmployeeName();
		    	}
		    	String row[]={"营业额"};
				String col[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
						"19","20","21","22","23","24","25","26","27","28","29","30","31"};
				double num[][]={num1};
				//double num[][]={{60,40,30,70,50,40,30,70,50,40,50,40}};
				CategoryDataset cd=DatasetUtilities.createCategoryDataset(row, col, num);
				JFreeChart chart=ChartFactory.createBarChart3D(name+"营业额详情", "天/月", "营业额/元", cd, PlotOrientation.VERTICAL, true, true, true);
				
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
				File files=new File(request.getRealPath("/")+"others/"+datetime+".jpg");
//				System.out.println(request.getRealPath("/")+"others/"+datetime+".jpg");
				//创建文件并保存到files中	
				try {
					ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				} catch (IOException e) {
					e.printStackTrace();
				}
				request.setAttribute("datetime", datetime+".jpg");
				return SUCCESS;
			}else{
				return ERROR;
			}
		}else if(datetime.length()==10){
			String id = String.valueOf(request.getSession().getAttribute("loginId"));
			TurnoverDao dao = new TurnoverDao();
			List<TurnoverBean> list = dao.selectTurnoverToday(id, datetime);
			if(list!=null){
				String name="";
		    	double num1[]=new double[1];
		    	for(int i=0;i<list.size();i++){
		    		TurnoverBean bean=list.get(i);
		    		//System.out.println(bean.getSalaryTime().substring(5, 7));
		    		//System.out.println(bean.getSalary());
		    		num1[i]=bean.getMoney();
		    		//name=bean.getEmployeeName();
		    	}
		    	String row[]={"营业额"};
				String col[]={"1"};
				double num[][]={num1};
				CategoryDataset cd=DatasetUtilities.createCategoryDataset(row, col, num);
				JFreeChart chart=ChartFactory.createBarChart3D(name+"营业额详情", "天/月", "营业额/元", cd, PlotOrientation.VERTICAL, true, true, true);
				
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
				File files=new File(request.getRealPath("/")+"others/"+datetime+".jpg");
//				System.out.println(request.getRealPath("/")+"others/"+datetime+".jpg");
				//创建文件并保存到files中	
				try {
					ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				} catch (IOException e) {
					e.printStackTrace();
				}
				request.setAttribute("datetime", datetime+".jpg");
				return SUCCESS;
			}else{
				return ERROR;
			}
		}
		return SUCCESS;
	}

}
