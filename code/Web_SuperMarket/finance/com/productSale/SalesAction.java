package com.productSale;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import com.mvc.http.aware.HttpAware;
import com.returnProductSale.ReturnBean;
import com.tools.Utils;

public class SalesAction extends HttpAware {
	SalesDao dao = new SalesDao();

	public String getList(){
		String time = request.getParameter("time");
		time.replace("年", "");
		time.replace("月", "");
		if(time.length()>9){
			time.replace("日", "");
		}
		List<SalesBean> list = dao.getAllSalesList(time);
		if(list!=null){
			request.setAttribute("List", list);
			return SUCCESS;
		}
		return ERROR; 
	}
	
	public String getSalesList() {
		String datetime = request.getParameter("datetime");
		String date = request.getParameter("date");
		if(datetime==null){		
			String id = String.valueOf(request.getSession().getAttribute("loginId"));
			String time = Utils.getDate();
			List<SalesBean> list = dao.selectSalesToday(id, time);
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
				List<SalesBean> list = dao.selectSalesYear(id, datetime);
				if(list!=null){
					date+="-0-0";
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", date);
					return SUCCESS;
				}else{
					return ERROR;
				}
			}else if(datetime.length()==7){
				String id = String.valueOf(request.getSession().getAttribute("loginId"));
				List<SalesBean> list = dao.selectSalesMonth(id, datetime);
				if(list!=null){
					date+="-0";
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", date);
					return SUCCESS;
				}else{
					return ERROR;
				}
			}else if(datetime.length()==10){
				String id = String.valueOf(request.getSession().getAttribute("loginId"));
				List<SalesBean> list = dao.selectSalesToday(id, datetime);
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

	public String getPictury(){
		String datetime = request.getParameter("datetime");
		String id = String
				.valueOf(request.getSession().getAttribute("loginId"));

		double a = 0;
		if (datetime.length() == 10) {
			List<SalesBean> list=dao.selectSalesT(id, datetime);
			for (int i = 0; i < list.size(); i++) {
				a = a + list.get(i).getProductId();
			}
			String row[] = { "数量" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				cols[i] = list.get(i).getProductId() + "";
				num[0][i] = (double) list.get(i).getCount();
			}

			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);
			JFreeChart chart = ChartFactory.createBarChart3D("各时期货物销量比例", "产品",
					"销量", cd, PlotOrientation.VERTICAL, true, true, true);
			// 设置标题字体样式
			TextTitle title = chart.getTitle();
			Font fontTit = new Font("黑体", Font.ITALIC, 20);
			title.setFont(fontTit);

			// 设置说明项的字体样式
			LegendTitle lend = chart.getLegend();
			Font font = new Font("隶书", Font.ITALIC, 14);
			lend.setItemFont(font);

			// 获取柱状图，然后根据柱状图获取他的X轴和Y轴
			CategoryPlot cp = chart.getCategoryPlot();

			// 获取X轴
			CategoryAxis X = cp.getDomainAxis();
			X.setLabelFont(font);
			X.setTickLabelFont(font);

			// 获取Y轴
			ValueAxis Y = cp.getRangeAxis();
			Y.setLabelFont(font);
			Y.setTickLabelFont(font);
			String path = request.getRealPath("Upload");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			Date date = new Date();
			long time = date.getTime();
			File files = new File(file, time + ".jpg");
			try {
				ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				request.setAttribute("fileName", time + ".jpg");
				return SUCCESS;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (datetime.length() == 7) {
			List<SalesBean> list = dao.selectSalesMonth(id, datetime);
			String row[] = { "销量" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				cols[i] = list.get(i).getTime().split("-")[2];

				num[0][i] = (double) list.get(i).getCount();
			}
			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);
			JFreeChart chart = ChartFactory.createBarChart3D("各时期货物销量比例", "日期",
					"销量", cd, PlotOrientation.VERTICAL, true, true, true);
			// 设置标题字体样式
			TextTitle title = chart.getTitle();
			Font fontTit = new Font("黑体", Font.ITALIC, 20);
			title.setFont(fontTit);

			// 设置说明项的字体样式
			LegendTitle lend = chart.getLegend();
			Font font = new Font("隶书", Font.ITALIC, 14);
			lend.setItemFont(font);

			// 获取柱状图，然后根据柱状图获取他的X轴和Y轴
			CategoryPlot cp = chart.getCategoryPlot();

			// 获取X轴
			CategoryAxis X = cp.getDomainAxis();
			X.setLabelFont(font);
			X.setTickLabelFont(font);

			// 获取Y轴
			ValueAxis Y = cp.getRangeAxis();
			Y.setLabelFont(font);
			Y.setTickLabelFont(font);
			String path = request.getRealPath("Upload");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			Date date = new Date();
			long time = date.getTime();
			File files = new File(file, time + ".jpg");
			try {
				ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				request.setAttribute("fileName", time + ".jpg");
				return SUCCESS;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (datetime.length() == 4) {
			List<SalesBean> list = dao.selectSalesYear(id, datetime);
			String row[] = { "销量" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				cols[i] = list.get(i).getTime().split("-")[1];
				num[0][i] = (double) list.get(i).getCount();
			}
			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);
			JFreeChart chart = ChartFactory.createBarChart3D("各时期货物销量比例", "日期",
					"货物销量", cd, PlotOrientation.VERTICAL, true, true, true);
			// 设置标题字体样式
			TextTitle title = chart.getTitle();
			Font fontTit = new Font("黑体", Font.ITALIC, 20);
			title.setFont(fontTit);

			// 设置说明项的字体样式
			LegendTitle lend = chart.getLegend();
			Font font = new Font("隶书", Font.ITALIC, 14);
			lend.setItemFont(font);

			// 获取柱状图，然后根据柱状图获取他的X轴和Y轴
			CategoryPlot cp = chart.getCategoryPlot();

			// 获取X轴
			CategoryAxis X = cp.getDomainAxis();
			X.setLabelFont(font);
			X.setTickLabelFont(font);

			// 获取Y轴
			ValueAxis Y = cp.getRangeAxis();
			Y.setLabelFont(font);
			Y.setTickLabelFont(font);
			String path = request.getRealPath("Upload");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			Date date = new Date();
			long time = date.getTime();
			File files = new File(file, time + ".jpg");
			try {
				ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				request.setAttribute("fileName", time + ".jpg");
				return SUCCESS;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ERROR;

	}
}
