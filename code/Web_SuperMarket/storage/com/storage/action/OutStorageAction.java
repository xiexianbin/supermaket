package com.storage.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mvc.http.aware.HttpAware;
import com.storage.bean.OutStorageBean;
import com.storage.bean.StoreBean;
import com.storage.dao.OtherDao;
import com.storage.dao.OutStorageDao;
import com.storage.dao.StoreDao;

public class OutStorageAction extends HttpAware{

	StoreDao sd=new StoreDao();
	OutStorageDao dao=new OutStorageDao();
	public String outStorageList(){
		List<OutStorageBean> list=dao.getList();
		if(list!=null){
			request.setAttribute("outStorageList", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String addOutStorage(){
		
//		OutStorageBean bean=new OutStorageBean();
//		bean.setPurchId(Integer.parseInt(request.getParameter("purchId")));
//		bean.setStorageId(Integer.parseInt(request.getParameter("storageId")));
//		//bean.setProductId(Integer.parseInt(request.getParameter("productId")));
//		//bean.setProductName(request.getParameter("productName"));
//		bean.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
//		bean.setEmployeeName(request.getParameter("employeeName"));
//		bean.setOutNum(Integer.parseInt(request.getParameter("outNum")));
//		bean.setOutTime(request.getParameter("outTime"));
//		bean.setOutDirection(request.getParameter("outDirection"));
//		bean.setReason(request.getParameter("reason"));
//		int row=dao.insert(bean);
//		if(row!=0){
//			return SUCCESS;
//		}else{
//			return ERROR;
//		}
		
	    StoreBean store=dao.selectStore(Integer.parseInt(request.getParameter("purchId")));
		
		//StoreBean store1=new StoreBean();
		store.setRemainNum(store.getRemainNum()-Integer.parseInt(request.getParameter("outNum")));
		//把store更新库存表
		int row1=sd.update(store);
		if(row1!=0){
			System.out.println("库存更新成功！");
		}else{
			System.out.println("更新失败");
		}
		
		
		//更新出库表，添加出库表记录
		OutStorageBean bean=new OutStorageBean();
		bean.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		bean.setStorageId(store.getStorageId());
		//bean.setProductId(Integer.parseInt(request.getParameter("productId")));
		//bean.setProductName(request.getParameter("productName"));
		bean.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		bean.setEmployeeName(request.getParameter("employeeName"));
		bean.setOutNum(Integer.parseInt(request.getParameter("outNum")));
		bean.setOutTime(request.getParameter("outTime"));
		bean.setOutDirection(request.getParameter("outDirection"));
		bean.setReason(request.getParameter("reason"));
		int row=dao.insert(bean);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	public String findOutStorage(){

		int id=Integer.parseInt(request.getParameter("id"));
		OutStorageBean bean=dao.findOne(id);
		if(bean!=null){
			request.setAttribute("outStorage", bean);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String updateOutStorage(){
		OutStorageBean bean=new OutStorageBean();
		bean.setOutStorageId(Integer.parseInt(request.getParameter("outStorageId")));
		bean.setPurchId(Integer.parseInt(request.getParameter("purchId")));
		bean.setStorageId(Integer.parseInt(request.getParameter("storageId")));
		//bean.setProductId(Integer.parseInt(request.getParameter("productId")));
		//bean.setProductName(request.getParameter("productName"));
		bean.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
		bean.setEmployeeName(request.getParameter("employeeName"));
		bean.setOutNum(Integer.parseInt(request.getParameter("outNum")));
		bean.setOutTime(request.getParameter("outTime"));
		bean.setOutDirection(request.getParameter("outDirection"));
		bean.setReason(request.getParameter("reason"));
		int row=dao.update(bean);
		if(row!=0){
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	
	
	
	//出库调用方法
		public String addOutStorageother(OutStorageBean out){
		    StoreBean store=dao.selectStore(out.getPurchId());
			
			store.setRemainNum(store.getRemainNum()-out.getOutNum());
			//把store更新库存表
			int row1=sd.update(store);
			if(row1!=0){
				System.out.println("库存更新成功！");
			}else{
				System.out.println("更新失败");
			}
			
			//更新出库表，添加出库表记录
			int row=dao.insert(out);
			if(row!=0){
				return SUCCESS;
			}else{
				return ERROR;
			}

		}
		
		public String selectOther(){
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
	
}
