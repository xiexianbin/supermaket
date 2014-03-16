package com.SaleRank;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import com.mvc.http.aware.HttpAware;
import com.tools.Utils;

public class SaleRankAction extends HttpAware{
	SaleRankDao dao =new SaleRankDao();
	public String allproType(){
		List<proType> list=	dao.proall();
		String time=Utils.getDate().split("-")[0]+"-"+Utils.getDate().split("-")[1];
		for(int i=0;i<list.size();i++){
			proType pro=list.get(i);
			
			 SaleRankBean bean=	dao.saleAll(pro.getProId(), time);
			 pro.setSumcount(bean.getCount());
			 pro.setYmonth(time);
			 list.set(i, pro);
		}
		
		
		
		//根据销量排序
		proType prra =new proType();
		
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.size()-i-1;j++){
				if(list.get(j).getSumcount()<list.get(j+1).getSumcount()){
					prra=list.get(j+1);
					list.set(j+1, list.get(j));
					list.set(j, prra);
				}
			}
			
			
		
		}
		
		//取排好序的list的前十位
		
		List<proType> list1=new ArrayList<proType>();
		
		
		for(int i=0;i<list.size();i++){
			proType pt=list.get(i);
			
			
			if(i<10){

				list1.add(pt);
				
			}
			
			
		}
		
		request.getSession().setAttribute("protype", list1);
		request.getSession().setAttribute("time",time );
		return SUCCESS;
	}
	

	
	
	//
	public String oneproType(){
		List<proType> list=	dao.proall();
		String time=request.getParameter("datime");
		for(int i=0;i<list.size();i++){
			proType pro=list.get(i);
			
			 SaleRankBean bean=	dao.saleAll(pro.getProId(), time);
			 pro.setSumcount(bean.getCount());
			 pro.setYmonth(time);
			 list.set(i, pro);
		}
		
		
		
		//根据销量排序
		proType prra =new proType();
		
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.size()-i-1;j++){
				if(list.get(j).getSumcount()<list.get(j+1).getSumcount()){
					prra=list.get(j+1);
					list.set(j+1, list.get(j));
					list.set(j, prra);
				}
			}
			
			
		
		}
		
		
		//取排好序的list的前十位
		List<proType> list1=new ArrayList<proType>();
		
		
		for(int i=0;i<list.size();i++){
			proType pt=list.get(i);
			
			
			if(i<10){

				list1.add(pt);
				
			}
			
			
		}
		

		request.getSession().setAttribute("protype", list1);
		request.getSession().setAttribute("time",time );
		return SUCCESS;
	}
	
	public String checkTu(){
		String time=request.getSession().getAttribute("time").toString();
		List<proType> list=(List<proType>) request.getSession().getAttribute("protype");
		String mess="";
		String str="";
		int sumcou=0;
		for(int i=0;i<list.size();i++){
			proType pro = list.get(i);
			sumcou=sumcou+pro.getSumcount();
			mess=mess+pro.getSumcount()+",";
			str=str+pro.getProName()+",";
		}
		String ss[]=mess.split(",");
		String sss[]=str.split(",");
		//初始化配置数据
				DefaultPieDataset dp=new DefaultPieDataset();
				//设置数据所占比例
				for(int i=0;i<list.size();i++){
					try{
						dp.setValue(sss[i], Integer.parseInt(ss[i])*100/sumcou);
					}catch(Exception e){
						return ERROR;
					}
				}
				

				
				//创建饼状图
				JFreeChart chart=ChartFactory.createPieChart3D(time+"销售排行列表", dp, true, true, true);
				//设置标题的字体样式
				Font titleFont=new Font("宋体",Font.BOLD,20);
				//获取标题
				TextTitle title=chart.getTitle();
				title.setFont(titleFont);
				//设置说明项的字体样式
				Font otherFont=new Font("楷体",Font.BOLD,13);
				LegendTitle lend=chart.getLegend();
				lend.setItemFont(otherFont);
				
				//获取饼状图
				PiePlot plot=(PiePlot) chart.getPlot(); 
				plot.setLabelFont(otherFont);
				
				//获取工程的发布目录
				String path=SaleRankAction.class.getResource("").getPath();
				File file=new File(path,"images");
				if(!file.exists()){
					file.mkdirs();
				}
				
				//以当前系统时间来命名这个饼状图
				
				
				File files=new File(file,time+".jpg");
				try {
					ChartUtilities.saveChartAsJPEG(files, chart, 800, 450);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("fileName", files.toString());
				
				
			
		
		return SUCCESS;
	}
}
