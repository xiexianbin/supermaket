package com.after.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.after.dao.AfterSaleDao;
import com.afterSale.bean.AfterSale;
import com.afterSale.bean.GiftRecord;
import com.gift.GiftBean;
import com.gift.GiftDao;
import com.mvc.http.aware.HttpAware;
import com.sales.bean.VipBean;
import com.storage.action.OutStorageAction;
import com.storage.bean.InStorageBean;
import com.storage.bean.OutStorageBean;
import com.tools.Utils;

public class afterSaleAction extends HttpAware{
	AfterSaleDao dao = new AfterSaleDao();
	public String listGift(){
		List<GiftBean> giftList=dao.selectAll();
		request.setAttribute("giftList", giftList);
		return SUCCESS;
	}
	
	
	public String vipGiftList(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int vipId=Integer.parseInt(request.getParameter("vipId"));
		List<GiftBean> vipGiftList=dao.selectVipGiftList(vipId);
		request.setAttribute("vipGiftList", vipGiftList);
		request.setAttribute("vipId", request.getParameter("vipId"));
		return SUCCESS;
	}
	
	
	
	public String addReturn(){
		
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int afterSaleId=Integer.parseInt(request.getParameter("afterSaleId"));
		int productId=Integer.parseInt(request.getParameter("productId"));
		int employeeId=Integer.parseInt(request.getParameter("employeeId"));
		String time=request.getParameter("date");
		String reason=request.getParameter("reason");
		String Remarks=request.getParameter("Remarks");
		AfterSale afterSale = new AfterSale();
		afterSale.setAfterSaleId(afterSaleId);
		afterSale.setPurchId(productId);
		afterSale.setEmployeeId(employeeId);
		afterSale.setDate(time);
		afterSale.setReason(reason);
		afterSale.setRemarks(Remarks);
		dao.insertAfterSaleRecord(afterSale);
		dao.updateStore(productId);
		InStorageBean in=dao.selectStorageId(productId);
		InStorageBean inStorage=new InStorageBean();
		inStorage.setStorageId(in.getStorageId());
		inStorage.setPurchId(in.getPurchId());
		inStorage.setEmployeeId(employeeId);
		inStorage.setInNum(1);
		inStorage.setInTime(time);
		inStorage.setInReason("产品不合格");
		inStorage.setRemarks("顾客退货");
		dao.insertIntoInStorage(inStorage);
		return SUCCESS;
		
	}
	
	public String afterSale(){
		int max=dao.selecRecordtMax();
		String time = Utils.getDate();
		List<GiftBean> productId=dao.productId();
		request.setAttribute("productId", productId);
		request.setAttribute("time", time);
		request.setAttribute("max1", max+1);
		return SUCCESS;
		
	}
	
	public String afterSale1(){
		
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("GBK");
		
		int max=dao.selecRecordtMax();
		String productIds=request.getParameter("productId");
		if(productIds.equals("")){
			String products=" , , ";
			request.setAttribute("products", products);
		}else{
		int productId=Integer.parseInt(productIds);
		GiftDao dao1=new GiftDao();
		GiftBean product=dao1.selectProduct(productId);
		String products=null;
		products=product.getProductName()+","+product.getProductTypeName()+","+product.getProductPrice();
		request.setAttribute("products", products);
		request.setAttribute("max1", max+1);
		}
	//	request.setAttribute("product", product);
		return SUCCESS;
		
	}
	
	
	public String record(){
		List<AfterSale> list=dao.selectAll1();
		request.setAttribute("list", list);
		return SUCCESS;
	}
	
	
	public String details(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int afterSaleId=Integer.parseInt(request.getParameter("afterSaleId"));
		AfterSale after = dao.selectDetailsReturn(afterSaleId);
		request.setAttribute("after", after);
		return SUCCESS;
	}
	
	public String giftRecord(){
		List<GiftRecord> giftList=dao.selectAllGiftRecord();
		request.setAttribute("list", giftList);
		return SUCCESS;
	}
	
	public String giftDetails(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int giftId=Integer.parseInt(request.getParameter("giftId"));
		GiftRecord gift=dao.selectOneGiftRecord(giftId);
		request.setAttribute("gift", gift);
		return SUCCESS;
	}
	
	
	
	public String selectById(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int id=Integer.parseInt(request.getParameter("vipId1"));
		List<GiftRecord> vipGiftList=dao.selectGiftRecordById(id);
		//System.out.println(vipGiftList.size());
		request.setAttribute("vipGiftList", vipGiftList);
		return SUCCESS;
		
	}
	
	public String selectByTime(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String time=request.getParameter("time");
		List<GiftRecord> vipGiftListByTime=dao.selectGiftRecordByTime(time);
		request.setAttribute("vipGiftList", vipGiftListByTime);
		return SUCCESS;
		
	}
	
	public String selectReturnById(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int id=Integer.parseInt(request.getParameter("vipId1"));
//		System.out.println("11111111111111111111111111");
		List<AfterSale> list=dao.selectAll1(id);
		request.setAttribute("list", list);
		return SUCCESS;
	}
	
	
	
	public String selectReturnByTime(){
		try {
			request.setCharacterEncoding("GBK");
			response.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    String time=request.getParameter("time");
//		System.out.println("11111111111111111111111111");
		List<AfterSale> list=dao.selectAll1(time);
		request.setAttribute("list", list);
		return SUCCESS;
	}
	//礼品兑换
	public String giftDuihuan(){
		String vipId=request.getParameter("vipId");
		String score=request.getParameter("score");
		String productId=request.getParameter("productId");
		//查询积分并扣除积分
		VipBean vip=dao.getVipScore(Integer.parseInt(vipId));
		
		vip.setVipId(Integer.parseInt(vipId));
		//System.out.println(vip.getVipId());
		vip.setVipScore(vip.getVipScore()-Integer.parseInt(score));
		
		int row=dao.updateVipScore(vip);
		if(row==0){
			return ERROR;
		}
		
		
//		System.out.println(vipId);
//		System.out.println(score);
//		System.out.println(productId);
		List<Integer> list=dao.getPurchId(Integer.parseInt(productId));
		
		//查找仓库编号
		OutStorageBean out=dao.getStorageId(list);
		out.setEmployeeId((Integer)request.getSession().getAttribute("loginId"));
		out.setOutTime(Utils.getDateTime());
		out.setOutNum(1);
		out.setOutDirection("礼品");
		out.setReason("无");
		
//		System.out.println(out.getEmployeeId());
//		System.out.println(out.getOutNum());
//		System.out.println(out.getOutDirection());
//		System.out.println(out.getStorageId());
//		System.out.println(out.getOutTime());
//		System.out.println(out.getPurchId());
//		System.out.println(out.getReason());
		//添加礼品兑换记录表中
		GiftRecord gr=new GiftRecord();
		gr.setEmployeeId(out.getEmployeeId());
		gr.setVipId(vip.getVipId());
		gr.setRemarks("礼品");
		gr.setGiftCount(1);
		gr.setGifttime(Utils.getDate());
		gr.setPurchId(out.getPurchId());
		int row1=dao.addGiftRecord(gr);
		
		if(row1==0){
			return ERROR;
		}
		
//		OutStorageDao outdao=new OutStorageDao();
//		outdao.insert(out);
		
		OutStorageAction osa=new OutStorageAction();
		osa.addOutStorageother(out);
		
		
		if(out.getStorageId()!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	public String deleteAll(){
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("GBK");
		
		String ids=request.getParameter("id");
		String id[]=ids.split(",");
		for(int i=0;i<id.length;i++){
			int a=Integer.parseInt(id[i]);
			dao.deleteOne(a);
		}
		return SUCCESS;
		
	}
	
	
	
	
	public String deleteAll1(){
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("GBK");
		
		String ids=request.getParameter("id");
		String id[]=ids.split(",");
		for(int i=0;i<id.length;i++){
			int a=Integer.parseInt(id[i]);
			dao.deleteOne1(a);
		}
		return SUCCESS;
		
	}
	
	
	
	


}
