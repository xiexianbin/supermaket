package com.goodsaction;

import java.util.List;

import com.goodsbean.DownGoods;
import com.goodsbean.Lose;
import com.goodsbean.OnSell;
import com.goodsbean.UpGoods;
import com.goodsbean.UpGoods1;
import com.goodsbean.alarm;
import com.goodsdao.AlarmDao;
import com.goodsdao.DownGoodsDao;
import com.goodsdao.LoseDao;
import com.goodsdao.OnSellDao;
import com.goodsdao.UpGoodsDao;
import com.mvc.http.aware.HttpAware;
import com.part.PartDao;
import com.tools.Utils;

public class GoodsAction extends HttpAware {
	UpGoodsDao dao = new UpGoodsDao();

	//超市已上架商品列表
	public String upgoodsList() {
		List<UpGoods> list = dao.upgoodsList();
		request.setAttribute("list", list);
		return SUCCESS;
	}

	// 查看详情
	public String upgoodsList1() {
		String serialid = request.getParameter("serialId");
		List<UpGoods1> list = dao.upgoodsList1(serialid);
		request.setAttribute("list", list);
		return SUCCESS;
	}

	// 商品上架信息
	public String upgoodsInsert() {
		String serialid = request.getParameter("serialId");
		String purchids = request.getParameter("purchId");
		String purchid = purchids.split("-")[0];
		String employids = request.getParameter("employeeId");
		String employid = employids.split("-")[0];
		String shelfids = request.getParameter("shelfId");
		String shelfid = shelfids.split("-")[0];
		String upcount = request.getParameter("upCount");
		String uptime = Utils.getDateTime();
		String remarks = request.getParameter("remarks");
		UpGoods upgoods = new UpGoods();
		upgoods.setSerialId(Integer.parseInt(serialid));
		upgoods.setPurchId(Integer.parseInt(purchid));
		upgoods.setEmployeeId(Integer.parseInt(employid));
		upgoods.setShelfId(Integer.parseInt(shelfid));
		upgoods.setUpCount(Integer.parseInt(upcount));
		upgoods.setUpTime(uptime);
		upgoods.setRemarks(remarks);
		
//		System.out.println(purchid+employid+shelfid+upcount);
		
		int row = dao.upgoodsInsert(upgoods);
		if (row != 0) {
			return SUCCESS;
		}
		return ERROR;
	}
	//商品上架时的下拉框信息
	public String editUpgoodsInsert() {
		int ans = dao.selectMaxSerialId();
		List<String> shelfList = dao.selectAllshelf();// 货架编号
		List<String> purchList = dao.selectAllpurch();// 采购流水号-商品名称
		if (ans != -1 || shelfList != null) {
			request.setAttribute("shelfList", shelfList);
			request.setAttribute("purchList", purchList);
			request.setAttribute("SerialId", (ans + 1));
			return SUCCESS;
		}
		return ERROR;
	}

	// upgoods更新
	public String upgoodsUpdate() {
		UpGoods upgoods = new UpGoods();
		upgoods.setSerialId(Integer.parseInt(request.getParameter("serialId")));
		upgoods.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		upgoods.setEmployeeId(Integer.parseInt(request
				.getParameter("employeeId")));
		upgoods.setShelfId(Integer.parseInt(request.getParameter("shelfId")));
		upgoods.setUpCount(Integer.parseInt(request.getParameter("upCount")));
		upgoods.setUpTime(Utils.getDateTime());
		upgoods.setRemarks(request.getParameter("remarks"));

		int row = dao.upgoodsUpdate(upgoods);
		if (row != 0) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String findsUpgoods() {
		String id = request.getParameter("serialId");
		UpGoods upgoods = dao.findUpgoods(Integer.parseInt(id));
		if (upgoods != null) {
			request.setAttribute("upgoods", upgoods);
			return SUCCESS;
		}
		return ERROR;

	}


	DownGoodsDao goodsDao = new DownGoodsDao();
	// 商品下架中下拉框
	public String downgoodsList() {
		List<DownGoods> list = goodsDao.downgoodsList();
		request.setAttribute("list", list);
		return SUCCESS;
	}

	// 查看下架商品详情
	public String downgoodsList1() {
		String serialid = request.getParameter("serialId");
		List<UpGoods1> list = goodsDao.downgoodsList1(serialid);
		request.setAttribute("list", list);
		return SUCCESS;
	}

	//在售商品下架是获取下拉框的内容
	public String downgoodsInsert1() {
		DownGoodsDao dao1 = new DownGoodsDao();
		int row = dao1.selectMaxSerialId1();
		List<String> onsellList = dao.selectAllOnsell();// 在售商品
		List<String> shelfList = dao.selectAllshelf();// 货架
		request.setAttribute("shelfList", shelfList);
		request.setAttribute("onsellList", onsellList);
		request.setAttribute("row", row + 1);
		return SUCCESS;
	}

	//插入新的下架记录
	public String downgoodsInsert() {
		String purchid = request.getParameter("purchId").split("-")[0];
		String employeeid = request.getParameter("employeeId").split("-")[0];
		String downcount = request.getParameter("downCount");
//		String shelfid = request.getParameter("shelfId").split("-")[0];
		String downtime = Utils.getDateTime();
		String remarks = request.getParameter("remarks");

		DownGoods downgoods = new DownGoods();
		downgoods.setPurchId(Integer.parseInt(purchid));
		downgoods.setEmployeeId(Integer.parseInt(employeeid));
		downgoods.setDownCount(Integer.parseInt(downcount));
//		downgoods.setShelfId(Integer.parseInt(shelfid));
		downgoods.setDownTime(downtime);
		downgoods.setRemarks(remarks);
		//          		100001 20130001 3 10002 2013-11-10 20:45:39 1
//		System.out.println(purchid+employeeid+downcount+downtime+remarks);
		int row = goodsDao.downgoodsInsert(downgoods);
		if (row != 0) {
			return SUCCESS;
		}
		return ERROR;
	}

	// down更新
	public String downgoodsUpdate() {
		DownGoods downgoods = new DownGoods();
		downgoods
				.setSerialId(Integer.parseInt(request.getParameter("serialId")));
		downgoods.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		downgoods.setEmployeeId(Integer.parseInt(request
				.getParameter("employeeId")));
		downgoods.setDownCount(Integer.parseInt(request
				.getParameter("downCount")));
		downgoods.setDownTime(Utils.getDateTime());
		downgoods.setRemarks(request.getParameter("remarks"));
		int row = goodsDao.downgoodsUpdate(downgoods);
		if (row != 0) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String findsDowngoods() {
		String id = request.getParameter("serialId");
		DownGoods downgoods = goodsDao.findsDowngoods(Integer.parseInt(id));
		if (downgoods != null) {
			request.setAttribute("downgoods", downgoods);
			return SUCCESS;
		}
		return ERROR;
	}

	OnSellDao onselldao = new OnSellDao();

	// onsellList查询
	public String onsellList() {
		List<OnSell> list = onselldao.onsellList();
		request.setAttribute("list", list);
		return SUCCESS;
	}

	// alarm查询
	AlarmDao alarmdao = new AlarmDao();

	public String alarmList() {
		List<alarm> list = alarmdao.alarmList();
		request.setAttribute("list", list);
		return SUCCESS;
	}

	// lose查询
	LoseDao losedao = new LoseDao();
	public String loseList() {
		List<Lose> list = losedao.loseList();
		request.setAttribute("list", list);
		return SUCCESS;
	}

	//获取仓库商品的基本信息，用户商品上架时使用
	public String upGoodsInfo(){
		String purchId = request.getParameter("purchId");
		purchId = purchId.split("-")[0];
		String goodsInfo = goodsDao.getGoodsInfo(Integer.parseInt(purchId));
		request.setAttribute("goodsInfo", goodsInfo);
		return SUCCESS;
	}
	
	//获在售商品的基本信息，用户商品下架时使用
	public String onsellInfo(){
		String purchId = request.getParameter("purchId");
		purchId = purchId.split("-")[0];
		String goodsInfo = goodsDao.getOnsellGoodsInfo(Integer.parseInt(purchId));
		request.setAttribute("goodsInfo", goodsInfo);
		return SUCCESS;
	}
	
	//但跳转报损也页面时获取报损编号
	public String addLosePage(){
		int loseId = alarmdao.getLoseId();
		request.setAttribute("loseId", loseId+1);
		List<String> onsellList = dao.selectAllOnsell();// 在售商品
		request.setAttribute("onsellList", onsellList);
		return SUCCESS;
	}
	
	//插入报损商品
	public String loseInsert(){
		String purchId = request.getParameter("purchId").split("-")[0];
		String employeeId = request.getParameter("employeeId").split("-")[0];
		String count = request.getParameter("loseCount");
		String dateTime = Utils.getDateTime();		
		String productNorms = request.getParameter("productNorms");
		String remarks = request.getParameter("remarks");
		
		Lose lose = new Lose();
		lose.setPurchId(Integer.parseInt(purchId));
		lose.setEmployeeId(Integer.parseInt(employeeId));
		lose.setCount(Integer.parseInt(count));
		lose.setTime(dateTime);
		lose.setRemarks(remarks);
		
		System.out.println(purchId+employeeId+count+dateTime+productNorms);
		
		int row = losedao.insertLose(lose);
		
		return SUCCESS;
	}
}
