package com.sales.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.http.aware.HttpAware;
import com.sales.bean.VipBean;
import com.sales.dao.VipDao;

public class VipAction extends HttpAware{
	VipDao dao=new VipDao();
	//添加
	public String addVip(){
		VipBean vip=new VipBean();
		vip.setVipName(request.getParameter("vipName"));
		vip.setVipPass(request.getParameter("vipPass"));
		vip.setVipSex(request.getParameter("vipSex"));
		vip.setVipBirthday(request.getParameter("vipBirthday"));
		vip.setVipIdNum(request.getParameter("vipIdNum"));
		vip.setVipTel(request.getParameter("vipTel"));
		vip.setVipAddress(request.getParameter("vipAddress"));
		vip.setVipEmail(request.getParameter("vipEmail"));
		vip.setVipQuestion(request.getParameter("vipQuestion"));
		vip.setVipQQ(request.getParameter("vipQQ"));
		vip.setVipAnswer(request.getParameter("vipAnswer"));
		vip.setVipRemarks(request.getParameter("vipRemarks"));
		int row=dao.addVip(vip);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//查找全部
	public String vipList(){
		List<VipBean> viplist=new ArrayList<VipBean>();
		viplist=dao.selsetAll();
		request.setAttribute("viplist", viplist);
		return SUCCESS;
	}
	
	
	//查找单个
	
	public String selectOne(){
		int id=Integer.parseInt(request.getParameter("vipid"));
		VipBean onevip=new VipBean();
		onevip=dao.selsetOne(id);
		request.setAttribute("onevip", onevip);
		return SUCCESS;
	}
	
	//更新
	
	public String updateVip(){
		int id=Integer.parseInt(request.getParameter("vipid"));
		VipBean onevip=new VipBean();
		onevip=dao.selsetOne(id);
		request.setAttribute("onevip", onevip);
		return SUCCESS;
	}
	
	public String addVipValue(){
		VipBean vip=new VipBean();
		vip.setVipId(Integer.parseInt(request.getParameter("vipId")));
		vip.setVipName(request.getParameter("vipName"));
		vip.setVipPass(request.getParameter("vipPass"));
		vip.setVipBirthday(request.getParameter("vipBirthday"));
		vip.setVipIdNum(request.getParameter("vipIdNum"));
		vip.setVipTel(request.getParameter("vipTel"));
		vip.setVipAddress(request.getParameter("vipAddress"));
		vip.setVipEmail(request.getParameter("vipEmail"));
		vip.setVipQQ(request.getParameter("vipQQ"));
		vip.setVipAnswer(request.getParameter("vipAnswer"));
		vip.setVipRemarks(request.getParameter("vipRemarks"));
		int row=dao.updateVip(vip);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String Ajax(){
		
		try {
			request.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("GBK");
		
		String mess=request.getParameter("mess");
		System.out.println(mess);
//		try {
//			PrintWriter pw=response.getWriter();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		request.setAttribute("mess", "李四"+mess);
		
		return SUCCESS;
		
		
	}
	

}
