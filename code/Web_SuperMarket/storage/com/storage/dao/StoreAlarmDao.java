package com.storage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.storage.bean.DateAlarmBean;
import com.storage.bean.NumAlarmBean;

public class StoreAlarmDao extends ConnectionAware{

	public List<NumAlarmBean> getNumAlarmList(){
		List<NumAlarmBean> list=new ArrayList<NumAlarmBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select product_tab.productId,product_tab.productName,sum(store_tab.remainNum) as 'allNum',alarm_tab.storageCountLimit from product_tab,alarm_tab,store_tab,purch_tab " +
					"where product_tab.productId=alarm_tab.productId and store_tab.purchId=purch_tab.purchId and product_tab.productId=purch_tab.productId group by product_tab.productId,product_tab.productName,alarm_tab.storageCountLimit having sum(store_tab.remainNum)<alarm_tab.storageCountLimit");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				NumAlarmBean bean=new NumAlarmBean();
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setAllNum(rs.getInt("allNum"));
				bean.setStorageCountLimit(rs.getInt("storageCountLimit"));
				list.add(bean);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<DateAlarmBean> getDateAlarmList(){
		List<DateAlarmBean> list=new ArrayList<DateAlarmBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select store_tab.storageId,product_tab.productId, product_tab.productName,purch_tab.purchId,purch_tab.productTime,purch_tab.expireTime,alarm_tab.dayLimit " +
					"from product_tab,purch_tab,alarm_tab,store_tab where product_tab.productId=purch_tab.productId and alarm_tab.productId=purch_tab.productId and store_tab.purchId=purch_tab.purchId and purch_tab.expireTime!='null'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				DateAlarmBean bean=new DateAlarmBean();
				bean.setStorageId(rs.getInt("storageId"));
				bean.setPurchId(rs.getInt("purchId"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setProductTime(rs.getString("productTime"));
				bean.setExpireTime(rs.getString("expireTime"));
				bean.setDayLimit(rs.getInt("dayLimit"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	
}
