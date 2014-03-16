package com.goodsdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goodsbean.Lose;
import com.mvc.connection.basic.ConnectionAware;
public class LoseDao extends ConnectionAware{
	public List<Lose> loseList(){
//		System.out.println("alarmList();");
		List<Lose> list=new ArrayList<Lose>();
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement("select * from lose_tab");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Lose lose=new Lose();
					lose.setLoseId(rs.getInt("loseId"));
					lose.setPurchId(rs.getInt("purchId"));
					lose.setEmployeeId(rs.getInt("employeeId"));
					lose.setCount(rs.getInt("count"));
					lose.setProductNorms(rs.getString("productNorms"));
					lose.setTime(rs.getString("time"));
					lose.setRemarks(rs.getString("remarks"));
					list.add(lose);
				}
				conn.close();
			} catch (SQLException e) {
			}
		return list;
	}

	//添加下架信息
	public int insertLose(Lose lose) {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("" +
					"insert into lose_tab(purchId, employeeId, count, productNorms, time, remarks) " +
					"values(?, ?, ?, ?, ?, ?)");
			ps.setInt(1, lose.getPurchId());
			ps.setInt(2, lose.getEmployeeId());
			ps.setInt(3, lose.getCount());
			ps.setString(4, lose.getProductNorms());
			ps.setString(5, lose.getTime());
			ps.setString(6, lose.getRemarks());
			row = ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return row;
	}
	
	
}
