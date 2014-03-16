package com.storage.action;

import java.util.List;

import com.mvc.http.aware.HttpAware;
import com.storage.bean.StoreBean;
import com.storage.dao.StoreDao;

public class StoreAction extends HttpAware{
	StoreDao dao=new StoreDao();
	public String storeList(){
		List<StoreBean> list=dao.selectAll();
		if(list!=null){
			request.setAttribute("storeList", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public String storeDetil(){
		int id=Integer.parseInt(request.getParameter("id"));
		StoreBean store=dao.findOne(id);
		if(store!=null){
			request.setAttribute("store", store);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String listBySto(){
		//以仓库编号，商品编号分组的库存列表
		List<StoreBean> list=dao.getListBySto();
		if(list!=null){
			request.setAttribute("storeListBySto", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String listByPro(){
		//以商品编号分组的库存列表   即查询所有商品的全部库存数量
		List<StoreBean> list=dao.getListBySto();
		if(list!=null){
			request.setAttribute("storeListByPro", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
           