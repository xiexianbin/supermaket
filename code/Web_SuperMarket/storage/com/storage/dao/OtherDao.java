package com.storage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class OtherDao extends ConnectionAware{

	public List<Integer> getStorageId(){
		//获取仓库编号
		List<Integer> list=new ArrayList<Integer>();
		try {
			PreparedStatement ps=conn.prepareStatement("select storageId from storage_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				list.add(rs.getInt("storageId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	public int getProductId(int id){
		//获取商品编号
		int productId = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("select productId from purch_tab where purchId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				productId=rs.getInt("productId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productId;
	}
	
	public String getProductName(int id){
		//获取商品名称
		String productName = null;
		try {
			PreparedStatement ps=conn.prepareStatement("select productName from product_tab where productId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				productName=rs.getString("productName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productName;
	}
	
	public int getPurchCount(int purchId){
		int purchCount = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("select purchCount from purch_tab where purchId=?");
			ps.setInt(1, purchId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				purchCount=rs.getInt("purchCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchCount;
		
	}
}
