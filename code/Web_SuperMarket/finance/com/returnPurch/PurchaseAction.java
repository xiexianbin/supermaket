package com.returnPurch;

import java.util.List;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

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

public class PurchaseAction extends HttpAware {
	PurchaseDao dao1 = new PurchaseDao();

	public String returnPurchaseList() {
		String datetime = request.getParameter("datetime");
		PurchaseDao dao = new PurchaseDao();
		// System.out.println(datetime);
		if (datetime == null) {
			String time = Utils.getDate();
			List<Purchase> list = dao.selectToday(time);
			request.setAttribute("LIST", list);
			request.setAttribute("TIME", time);
			return SUCCESS;
		} else {
			if (datetime.length() == 4) {
				List<Purchase> list = dao.selectTurnoverYear(datetime);
				datetime += "-0-0";
				// System.out.println(datetime);
				request.setAttribute("LIST", list);
				request.setAttribute("TIME", datetime);
				return SUCCESS;
			} else if (datetime.length() == 7) {
				// System.out.println(datetime);
				// System.out.println(datetime);
				List<Purchase> list = dao.selectTurnoverMonth(datetime);
				request.setAttribute("LIST", list);
				request.setAttribute("TIME", datetime);
				return SUCCESS;
			} else if (datetime.length() == 10) {
				List<Purchase> list = dao.selectToday(datetime);
				request.setAttribute("LIST", list);
				request.setAttribute("TIME", datetime);
				return SUCCESS;
			}
		}

		return datetime;
	}

	public String PurchaseOneList() {
		String time = request.getParameter("time");
		// System.out.println(time.length());
		if (time.length() == 10) {
			List<Purchase> list = dao1.selectOne(time);
			request.setAttribute("LIST", list);
			return SUCCESS;
		} else if (time.length() == 7) {
			// System.out.println("000000000000000");
			List<Purchase> list = dao1.selectOne1(time);
			// System.out.println(list.size());
			request.setAttribute("LIST", list);
			return SUCCESS;
		}
		return SUCCESS;
	}

	public String purchaseBar() {
		String time = request.getParameter("datetime");
		// System.out.println(time);
		double a = 0;
		if (time.length() == 10) {
			List<Purchase> list = dao1.selectOne(time);
			for (int i = 0; i < list.size(); i++) {
				a = a + list.get(i).getMoney();
			}
			String row[] = { "费用" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				cols[i] = list.get(i).getProductName();
				// System.out.println(cols[i]);
				num[0][i] = (double) list.get(i).getMoney();
			}

			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);

			// 创建柱状图
			JFreeChart chart = ChartFactory.createBarChart3D(time + "产品退购金额",
					"产品", "金钱", cd, PlotOrientation.VERTICAL, true, true, true);
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

			String path = request.getSession().getServletContext()
					.getRealPath("upload1");
			// System.out.println(path);
			// String path1=this.class.getClassLoader().getResource("");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();

			}

			File files = new File(file, time + ".jpg");

			try {
				ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				request.setAttribute("fileName", time+".jpg");
				// request.getRequestDispatcher("bar.jsp").forward(request,
				// response);
				return SUCCESS;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (time.length() == 7) {

			List<Purchase> list = dao1.selectTurnoverMonth(time);

			// System.out.println(a);
			String row[] = { "费用" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {

				cols[i] = list.get(i).getTime().split("-")[2];

				num[0][i] = (double) list.get(i).getMoney();

			}

			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);

			// 创建柱状图
			JFreeChart chart = ChartFactory.createBarChart3D(time + "产品退购金额",
					"天", "金钱", cd, PlotOrientation.VERTICAL, true, true, true);
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

			String path = request.getSession().getServletContext()
					.getRealPath("upload1");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();

			}

			File files = new File(file, time + ".jpg");

			try {
				ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				request.setAttribute("fileName", time+".jpg");
				// request.getRequestDispatcher("bar.jsp").forward(request,
				// response);
				return SUCCESS;
			} catch (IOException e) {
				e.printStackTrace();
			}

			return SUCCESS;
		} else if (time.length() == 4) {
			List<Purchase> list = dao1.selectTurnoverYear(time);
			// System.out.println(a);
			String row[] = { "费用" };
			String cols[] = new String[list.size()];
			double[][] num = new double[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				// System.out.println(list.get(i).getProductName());
				cols[i] = list.get(i).getTime().split("-")[1];
				// System.out.println(cols[i]);
				num[0][i] = (double) list.get(i).getMoney();
				// System.out.println(cols[i]+"--------"+num[0][i]);
			}

			CategoryDataset cd = DatasetUtilities.createCategoryDataset(row,
					cols, num);

			// 创建柱状图
			JFreeChart chart = ChartFactory.createBarChart3D(time + "产品退购金额",
					"月", "金钱", cd, PlotOrientation.VERTICAL, true, true, true);
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

			String path = request.getSession().getServletContext()
					.getRealPath("upload1");
			// String path1=this.class.getClassLoader().getResource("");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();

			}

			File files = new File(file, time + ".jpg");

			try {
				ChartUtilities.saveChartAsJPEG(files, chart, 800, 500);
				request.setAttribute("fileName", time + ".jpg");
				// request.getRequestDispatcher("bar.jsp").forward(request,
				// response);
				return SUCCESS;
			} catch (IOException e) {
				e.printStackTrace();
			}

			return SUCCESS;
		}
		return ERROR;

	}

}
