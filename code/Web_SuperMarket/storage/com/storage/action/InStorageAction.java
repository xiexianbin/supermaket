package com.storage.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mvc.http.aware.HttpAware;
import com.storage.bean.InStorageBean;
import com.storage.bean.StoreBean;
import com.storage.dao.InStorageDao;
import com.storage.dao.OtherDao;
import com.storage.dao.StoreDao;
import com.tools.Utils;

public class InStorageAction extends HttpAware{
	
	InStorageDao dao=new InStorageDao();
	StoreDao sd=new StoreDao();
	
	public String inStorageList(){
		List<InStorageBean> list=dao.getList();
		
		if(list!=null){
			//System.out.println(list.size());
			request.setAttribute("inStorageList", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	public String addInStorage(){
		//添加库存信息  
		StoreBean store=new StoreBean();
		store.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		store.setStorageId(Integer.parseInt(request.getParameter("storageId")));
		store.setRemainNum(Integer.parseInt(request.getParameter("inNum")));
		int row1=sd.insert(store);
		if(row1!=0){
			System.out.println("库存信息添加成功");
		}else{
			System.out.println("失败");
		}
		
		//添加入库信息
		InStorageBean bean=new InStorageBean();
		bean.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		bean.setStorageId(Integer.parseInt(request.getParameter("storageId")));
		//bean.setProductId(Integer.parseInt(request.getParameter("productId")));
		//bean.setProductName(request.getParameter("productName"));
		HttpSession session = request.getSession();
		int employeeId= (Integer) session.getAttribute("loginId");
		bean.setEmployeeId(employeeId);
		String employeeName=(String) session.getAttribute("loginName");
		bean.setEmployeeName(employeeName);
		bean.setInNum(Integer.parseInt(request.getParameter("inNum")));
		bean.setInTime(Utils.getDate());
		bean.setInReason(request.getParameter("inReason"));
		bean.setRemarks(request.getParameter("remarks"));
		int row=dao.insert(bean);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String findInStorage(){
		int id=Integer.parseInt(request.getParameter("id"));
		InStorageBean bean=dao.findOne(id);
		if(bean!=null){
			request.setAttribute("inStorage", bean);
			return SUCCESS;
		}
		return ERROR;
		
	}
	
	public String updateInStorage(){
		InStorageBean bean=new InStorageBean();
		bean.setInstorageId(Integer.parseInt(request.getParameter("instorageId")));
		bean.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		bean.setStorageId(Integer.parseInt(request.getParameter("storageId")));
		//bean.setProductId(Integer.parseInt(request.getParameter("productId")));
		//bean.setProductName(request.getParameter("productName"));
		bean.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		bean.setEmployeeName(request.getParameter("employeeName"));
		bean.setInNum(Integer.parseInt(request.getParameter("inNum")));
		bean.setInTime(request.getParameter("inTime"));
		bean.setInReason(request.getParameter("inReason"));
		bean.setRemarks(request.getParameter("remarks"));
		int row=dao.update(bean);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String selectOther(){
		//获取仓库编号列表，登录用户编号，登录用户名
		OtherDao od=new OtherDao();
		List<Integer> list=od.getStorageId();
		HttpSession session = request.getSession();
		int id=(Integer) session.getAttribute("loginId");
		String name=(String) session.getAttribute("loginName");
		//String time=Utils.getDate();
		//System.out.println(time);
		request.setAttribute("storageIdList", list);
		request.setAttribute("employeeId", id);
		request.setAttribute("employeeName", name);
		//request.setAttribute("date", time);
		return SUCCESS;
	}
	
	public String getProductInf(){
		//获取商品编号 ，商品名称
		int id=0;
		if(request.getParameter("purchId")!=""){
			id=Integer.parseInt(request.getParameter("purchId"));
		}
		
		OtherDao od=new OtherDao();
		int productId=od.getProductId(id);
		
		//request.setAttribute("productId", productId);
		if(productId!=0){
			int purchCount=od.getPurchCount(id);
			//System.out.println(purchCount);
		String productName=od.getProductName(productId);
		request.setAttribute("productId", productId);
		request.setAttribute("productName", productName);
		request.setAttribute("purchCount", purchCount);
		return SUCCESS;
		}else{
			request.setAttribute("productId", productId);
			return SUCCESS;
		}
		
	}
	
}

