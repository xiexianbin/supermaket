package com.goodsType;

import java.util.ArrayList;

import com.mvc.http.aware.HttpAware;

public class GoodsTypeAction extends HttpAware{

	GoodsTypeDao dao=new GoodsTypeDao();
	
	public String getGoodsTypelist(){
		
		ArrayList<GoodsTypeBean> list=dao.getGoodsTypeList();
		
		
		if(list!=null){
			request.setAttribute("goodsTypelist", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	
	
	
	
	
	
	public String addGoodsType(){
		GoodsTypeBean gt=new GoodsTypeBean();
		
		gt.setProductTypeName(request.getParameter("productTypeName"));
		gt.setRemarks(request.getParameter("remarks"));
		
		
		
		int row=dao.insertGoodsType(gt);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	
	public String findGoodstypeData(){
		int id=Integer.parseInt(request.getParameter("id"));
		GoodsTypeBean bean=dao.findGoodsType(id);  
		if(bean!=null){
			request.setAttribute("goodstypeData", bean);
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	
	
	
	public String updateGoodsType(){
		GoodsTypeBean bean=new GoodsTypeBean();
		
		bean.setProductTypeId(Integer.parseInt(request.getParameter("productTypeId")));
		bean.setProductTypeName(request.getParameter("productTypeName"));
		bean.setRemarks(request.getParameter("remarks"));
		int row=dao.updateGoodsType(bean);  
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	
	
	
	
	
	
	public String goodsTypeDetails(){
		int id=Integer.parseInt(request.getParameter("id"));
		GoodsTypeBean bean=dao.findGoodsType(id);  
		if(bean!=null){
			request.setAttribute("goodstypeData", bean);
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	
	
	
	
	
	
	
}
