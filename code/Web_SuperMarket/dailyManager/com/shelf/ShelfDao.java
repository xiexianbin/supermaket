package com.shelf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class ShelfDao extends ConnectionAware {

	//货架列表
	public List<ShelfBean> shelfList(){
		List<ShelfBean> shelfList = new ArrayList<ShelfBean>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from shelf_tab");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ShelfBean shelfBean = new ShelfBean();
				shelfBean.setShelfId(rs.getInt("shelfId"));
				shelfBean.setShelfLocation(rs.getString("shelfLocation"));
				shelfBean.setShelfType(rs.getString("shelfType"));
				shelfBean.setRemarks(rs.getString("remarks"));
				shelfList.add(shelfBean);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shelfList;
	}
	
	//查找货架的最大编号
	public int getShelfIndex() {
		// TODO Auto-generated method stub
		int MaxShelfId = -1;
		try {
			PreparedStatement ps = conn.prepareStatement("select max(shelfId) max from shelf_tab");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				MaxShelfId = rs.getInt("max");
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MaxShelfId;
	}

	//添加货架
	public int addShelf(ShelfBean shelfBean) {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into shelf_tab(shelfLocation, shelfType, remarks) values(?, ?, ?)");
//			ps.setInt(1, shelfBean.getShelfId());
			ps.setString(1, shelfBean.getShelfLocation());
			ps.setString(2, shelfBean.getShelfType());
			ps.setString(3, shelfBean.getRemarks());
			row = ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	//获取货架信息
	public ShelfBean findShelf(int shelfId) {
		// TODO Auto-generated method stub
		ShelfBean shelfBean = new ShelfBean();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from shelf_tab where shelfId = ?");
			ps.setInt(1, shelfId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				shelfBean.setShelfId(shelfId);
				shelfBean.setShelfLocation(rs.getString("shelfLocation"));
				shelfBean.setShelfType(rs.getString("shelfType"));
				shelfBean.setRemarks(rs.getString("remarks"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shelfBean;
	}
	//更新货架信息
	public int updateShelf(ShelfBean shelfBean) {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("update shelf_tab set shelfLocation=?, shelfType=?, remarks=? where shelfId = ?");
			ps.setString(1, shelfBean.getShelfLocation());
			ps.setString(2, shelfBean.getShelfType());
			ps.setString(3, shelfBean.getRemarks());
			ps.setInt(4, shelfBean.getShelfId());
			row = ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
}


