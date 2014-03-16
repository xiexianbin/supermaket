package com.goodsdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goodsbean.alarm;
import com.mvc.connection.basic.ConnectionAware;

public class AlarmDao extends ConnectionAware{
	//查询
	public List<alarm> alarmList(){
//		System.out.println("alarmList();");
		List<alarm> list=new ArrayList<alarm>();
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement("select * from alarm_tab");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					alarm alar=new alarm();
					alar.setAlarmId(rs.getInt("alarmId"));
					alar.setProductId(rs.getInt("productId"));
					alar.setStorageCountLimit(rs.getInt("storageCountLimit"));
					alar.setMarketCountLimit(rs.getInt("marketCountLimit"));
					alar.setDayLimit(rs.getInt("dayLimit"));
					alar.setRemarks(rs.getString("remarks"));
					list.add(alar);
				
				}
				conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			

		return list;
	}

	//获取报损的最大编号
	public int getLoseId() {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select max(loseId) as id from lose_tab");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				row = rs.getInt("id");
			}
//			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return row;
	}
	
}
