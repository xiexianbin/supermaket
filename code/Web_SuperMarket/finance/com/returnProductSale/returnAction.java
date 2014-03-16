package com.returnProductSale;

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
import com.tools.Utils;

public class returnAction extends HttpAware {
	ReturnDao dao = new ReturnDao();

	public String getreturnSalesList() {
		String datetime = request.getParameter("datetime");
		String date = request.getParameter("date");

		// System.out.println(date+"--------"+datetime);

		if (datetime == null) {
			String id = String.valueOf(request.getSession().getAttribute(
					"loginId"));
			String time = Utils.getDate();
			List<ReturnBean> list = dao.selectSalesToday(id, time);
			if (list != null) {
				request.setAttribute("LIST", list);
				request.setAttribute("TIME", time);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			if (datetime.length() == 4) {
				String id = String.valueOf(request.getSession().getAttribute(
						"loginId"));
				List<ReturnBean> list = dao.selectSalesYear(id, datetime);
				if (list != null) {
					date += "-0-0";
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", date);
					return SUCCESS;
				} else {
					return ERROR;
				}
			} else if (datetime.length() == 7) {
				String id = String.valueOf(request.getSession().getAttribute(
						"loginId"));
				List<ReturnBean> list = dao.selectSalesMonth(id, datetime);
				if (list != null) {
					date += "-0";
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", date);
					return SUCCESS;
				} else {
					return ERROR;
				}
			} else if (datetime.length() == 10) {
				String id = String.valueOf(request.getSession().getAttribute(
						"loginId"));
				List<ReturnBean> list = dao.selectSalesToday(id, datetime);
				if (list != null) {
					request.setAttribute("LIST", list);
					request.setAttribute("TIME", date);
					return SUCCESS;
				} else {
					return ERROR;
				}
			}
		}
		return ERROR;
	}

	public String getreturnSalesPictury() {
		String datetime = request.getParameter("datetime");
		String id = String
				.valueOf(request.getSession().getAttribute("loginId"));

		double a = 0;
		if (datetime.length() == 10) {
			List<ReturnBean> list = dao.selectSalesToday(id, datetime);
			for (int i = 0; i < list.size(); i++) {
				a = a + list.get(i).getReturnMoney();
			}
			String row[] = { "金额" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				cols[i] = list.get(i).getReturnpurchNum() + "";
				num[0][i] = (double) list.get(i).getReturnMoney();
			}

			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);
			JFreeChart chart = ChartFactory.createBarChart3D("各时期退货金额比例", "日期",
					"退回金额", cd, PlotOrientation.VERTICAL, true, true, true);
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
			List<ReturnBean> list = dao.selectSalesMonth(id, datetime);
			String row[] = { "金额" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				cols[i] = list.get(i).getTime().split("-")[2];

				num[0][i] = (double) list.get(i).getReturnMoney();
			}
			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);
			JFreeChart chart = ChartFactory.createBarChart3D("各时期退货金额比例", "日期",
					"退回金额", cd, PlotOrientation.VERTICAL, true, true, true);
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
		} else if (datetime.length() == 4) {
			List<ReturnBean> list = dao.selectSalesYear(id, datetime);
			String row[] = { "金额" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				cols[i] = list.get(i).getTime().split("-")[1];
				num[0][i] = (double) list.get(i).getReturnMoney();
			}
			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);
			JFreeChart chart = ChartFactory.createBarChart3D("各时期退货金额比例", "日期",
					"退回金额", cd, PlotOrientation.VERTICAL, true, true, true);
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
		}
		return ERROR;

	}
}
