package com.storage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.storage.bean.AlarmBean;

public class AlarmDao extends ConnectionAware{

	public List<AlarmBean> getList(){
		List<AlarmBean> list=new ArrayList<AlarmBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("" +
					"select alarmId,product_tab.productId,productName," +
					"storageCountLimit,marketCountLimit,dayLimit,alarm_tab.remarks " +
					"from alarm_tab,product_tab " +
					"where alarm_tab.productId=product_tab.productId");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				AlarmBean alarm = new AlarmBean();
				alarm.setAlarmId(rs.getInt("alarmId"));
				alarm.setProductId(rs.getInt("productId"));
				alarm.setProductName(rs.getString("productName"));
				alarm.setStorageCountLimit(rs.getInt("storageCountLimit"));
				alarm.setMarketCountLimit(rs.getInt("marketCountLimit"));
				alarm.setDayLimit(rs.getInt("dayLimit"));
				alarm.setRemarks(rs.getString("remarks"));
				list.add(alarm);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(AlarmBean alarm){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into alarm_tab (productId,storageCountLimit,marketCountLimit,dayLimit,remarks) values(?,?,?,?,?)");
			ps.setInt(1, alarm.getProductId());
			ps.setInt(2, alarm.getStorageCountLimit());
			ps.setInt(3, alarm.getMarketCountLimit());
			ps.setInt(4, alarm.getDayLimit());
			ps.setString(5, alarm.getRemarks());
			row=ps.executeUpdate();
			closeConn(conn, ps);
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public AlarmBean findOne(int id){
		AlarmBean alarm = new AlarmBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select alarmId,product_tab.productId,productName,storageCountLimit,marketCountLimit,dayLimit,alarm_tab.remarks from alarm_tab,product_tab where alarm_tab.productId=product_tab.productId and alarmId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				alarm.setAlarmId(rs.getInt("alarmId"));
				alarm.setProductId(rs.getInt("productId"));
				alarm.setProductName(rs.getString("productName"));
				alarm.setStorageCountLimit(rs.getInt("storageCountLimit"));
				alarm.setMarketCountLimit(rs.getInt("marketCountLimit"));
				alarm.setDayLimit(rs.getInt("dayLimit"));
				alarm.setRemarks(rs.getString("remarks"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alarm;
	}
	
	public int update(AlarmBean alarm){
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("update alarm_tab set productId=?,storageCountLimit=?,marketCountLimit=?,dayLimit=?,remarks=? where alarmId=?");
			ps.setInt(1, alarm.getProductId());
			ps.setInt(2, alarm.getStorageCountLimit());
			ps.setInt(3, alarm.getMarketCountLimit());
			ps.setInt(4, alarm.getDayLimit());
			ps.setString(5, alarm.getRemarks());
			ps.setInt(6, alarm.getAlarmId());
			
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	public int delete(int id){
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("delete from alarm_tab where alarmId=?");
			ps.setInt(1, id);
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
}
