package com.shelf;

import java.util.List;

import com.mvc.http.aware.HttpAware;

public class ShelfAction extends HttpAware {
	
	ShelfDao shelfDao = new ShelfDao();
	//货架列表
	public String shelfList(){
		List<ShelfBean> shelfList = shelfDao.shelfList();
		request.setAttribute("shelfList", shelfList);
		return SUCCESS;
	}
	
	//测试分页
	public String test(){
		List<ShelfBean> shelfList = shelfDao.shelfList();
		request.setAttribute("shelfList", shelfList);
		return SUCCESS;
	}
	//查找货架最大编号
	public String addShelf(){
		int shelfId = shelfDao.getShelfIndex();
		request.setAttribute("shelfId", shelfId+1);
		
		return SUCCESS;
	}
	
	//添加货架
	public String addShelfMethod(){
		//获取新货架信息
		//id
		String shelfId = request.getParameter("shelfId");
		//shelfLocation
		String f = request.getParameter("shelfLocation_F");
		String a = request.getParameter("shelfLocation_A");
		String n = request.getParameter("shelfLocation_N");
		String shelfLocation = f+a+n;
		//shelfType
		String shelfType = request.getParameter("shelfType");
		//remarks
		String remarks = request.getParameter("remarks");
		ShelfBean shelfBean = new ShelfBean();
		shelfBean.setShelfId(Integer.parseInt(shelfId));
		shelfBean.setShelfLocation(shelfLocation);
		shelfBean.setShelfType(shelfType);
		shelfBean.setRemarks(remarks);
		int row = shelfDao.addShelf(shelfBean);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//updateShelf获取货架信息
	public String updateShelf(){
		String ids = request.getParameter("shelfId");
		int shelfId = Integer.parseInt(ids);
		ShelfBean shelfBean = shelfDao.findShelf(shelfId);
		request.setAttribute("shelfBean", shelfBean);
		return SUCCESS;
	}
	//updateShelfMethod更新货架信息
	public String updateShelfMethod(){
		//获取新货架信息
		//id
		String shelfId = request.getParameter("shelfId");
		//shelfLocation
		String f = request.getParameter("shelfLocation_F");
		String a = request.getParameter("shelfLocation_A");
		String n = request.getParameter("shelfLocation_N");
		String shelfLocation = f+a+n;
		//shelfType
		String shelfType = request.getParameter("shelfType");
		//remarks
		String remarks = request.getParameter("remarks");
		ShelfBean shelfBean = new ShelfBean();
		shelfBean.setShelfId(Integer.parseInt(shelfId));
		shelfBean.setShelfLocation(shelfLocation);
		shelfBean.setShelfType(shelfType);
		shelfBean.setRemarks(remarks);
		int row = shelfDao.updateShelf(shelfBean);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
