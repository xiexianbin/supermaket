package com.storage.action;

import java.util.List;

import com.mvc.http.aware.HttpAware;
import com.storage.bean.AlarmBean;
import com.storage.dao.AlarmDao;

public class AlarmAction extends HttpAware{

	AlarmDao dao = new AlarmDao();
	public String alarmList(){
		List<AlarmBean> list=dao.getList();
		//System.out.println("alarmList:"+list.size());
		if(list!=null){
		request.setAttribute("alarmList", list);
		return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String addAlarm(){
		AlarmBean alarm = new AlarmBean();
		alarm.setProductId(Integer.parseInt(request.getParameter("productId")));
		alarm.setStorageCountLimit(Integer.parseInt(request.getParameter("storageCountLimit")));
		alarm.setMarketCountLimit(Integer.parseInt(request.getParameter("marketCountLimit")));
		alarm.setDayLimit(Integer.parseInt(request.getParameter("dayLimit")));
		alarm.setRemarks(request.getParameter("remarks"));
		int row=dao.insert(alarm);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String deleteAlarm(){
		int id=Integer.parseInt(request.getParameter("id"));
		int row=dao.delete(id);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String findAlarm(){
		int id=Integer.parseInt(request.getParameter("id"));
		AlarmBean alarm=dao.findOne(id);
		if(alarm!=null){
			request.setAttribute("alarm", alarm);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String updateAlarm(){
		AlarmBean alarm = new AlarmBean();
		alarm.setAlarmId(Integer.parseInt(request.getParameter("alarmId")));
		alarm.setProductId(Integer.parseInt(request.getParameter("productId")));
		alarm.setStorageCountLimit(Integer.parseInt(request.getParameter("storageCountLimit")));
		alarm.setMarketCountLimit(Integer.parseInt(request.getParameter("marketCountLimit")));
		alarm.setDayLimit(Integer.parseInt(request.getParameter("dayLimit")));
		alarm.setRemarks(request.getParameter("remarks"));
		int row=dao.update(alarm);
		if(row!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	
}
