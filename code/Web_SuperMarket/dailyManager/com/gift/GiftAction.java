package com.gift;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.mvc.http.aware.HttpAware;
import com.tools.Utils;

public class GiftAction extends HttpAware{
	GiftDao dao = new GiftDao();
	public String listGift(){
		//查询出所有礼品信息
		List<GiftBean> giftList=dao.selectAll();
		request.setAttribute("giftList", giftList);
		return SUCCESS;
	}
	
	
	public String addOne(){
	int b=0;
	request.setAttribute("b", b);
	String time = Utils.getDate();
		int a=dao.selectMax();
		List<GiftBean> productIdList = dao.productId();
		request.setAttribute("productIdList", productIdList);
		request.setAttribute("time", time);
		request.setAttribute("max", a+1);
		return SUCCESS;
		
	}
	//添加一个礼品信息
	public String addOne1(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int giftId=Integer.parseInt(request.getParameter("giftId"));
		int productId=Integer.parseInt(request.getParameter("productId"));
		int score = Integer.parseInt(request.getParameter("score"));
		String mass=request.getParameter("Remarks");
//		System.out.println(mass);
		GiftBean gift = new GiftBean();
		gift.setGiftId(giftId);
		gift.setProductId(productId);
		gift.setScore(score);
		gift.setRemarks(mass);
		int row=dao.insertOne(gift);
		if(row!=0){
		return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	
	
	public String addOne3(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<GiftBean> productIdList = dao.productId();
		request.setAttribute("productIdList", productIdList);
		String productIds=request.getParameter("productId");
		if(productIds.equals("")){
			String products=" , , ";
			request.setAttribute("products", products);
		}else{
		int productId=Integer.parseInt(productIds);
		GiftBean product=dao.selectProduct(productId);	
		String products=null;
		products=product.getProductName()+","+product.getProductTypeName()+","+product.getProductPrice();
		request.setAttribute("products", products);
		}
		return SUCCESS;
	}
	
	
	
	//查询出编号对应的信息
	public String selectOne(){
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("GBK");
		String time=Utils.getDate();
		int giftId=Integer.parseInt(request.getParameter("giftIds"));
		request.setAttribute("time", time);
		GiftBean gift=dao.selectOne(giftId);
		request.setAttribute("giftBean", gift);
		return SUCCESS;
		
		
	}
	
	
	//更新数据
	public String updateOne(){
		
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("GBK");
		
		int giftId=Integer.parseInt(request.getParameter("giftId"));
		int productId=Integer.parseInt(request.getParameter("productId"));
		int score = Integer.parseInt(request.getParameter("score"));
		String mass=request.getParameter("Remarks");
	//	System.out.println(mass);
		GiftBean gift = new GiftBean();
		gift.setGiftId(giftId);
		gift.setProductId(productId);
		gift.setScore(score);
		gift.setRemarks(mass);
		int row=dao.updateOne(gift);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	
	
	//删除所选礼品
	public String deleteAll(){
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("GBK");
		
		String ids=request.getParameter("id");
		String id[]=ids.split(",");
	//	System.out.println(id.length);
		for(int i=0;i<id.length;i++){
		//	System.out.println(id[i]);
			int a=Integer.parseInt(id[i]);
			dao.deleteOne(a);
		}
		return SUCCESS;
		
	}
	
	
}
