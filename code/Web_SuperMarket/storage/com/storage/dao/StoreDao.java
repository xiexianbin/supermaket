package com.storage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.storage.bean.StoreBean;

public class StoreDao extends ConnectionAware{
	
//	public void insert(){
//		try {
//			PreparedStatement ps=conn.prepareStatement("insert into store_tab (storageId,purchId,remainNum) " +
//					"select inStorage_tab.storageId,inStorage_tab.purchId,sum(inNum)-sum(outNum) as 'remainNum' " +
//					"from inStorage_tab join outStorage_tab on inStorage_tab.storageId=outStorage_tab.storageId " +
//					"group by inStorage_tab.purchId,inStorage_tab.storageId");
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public List<StoreBean> selectAll(){
		
		List<StoreBean> list=new ArrayList<StoreBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select store_tab.storeId,store_tab.purchId,store_tab.storageId,store_tab.remainNum,store_tab.remarks,purch_tab.productTime,purch_tab.expireTime,product_tab.productId,product_tab.productName " +
					"from store_tab,purch_tab,product_tab where store_tab.purchId=purch_tab.purchId and purch_tab.productId=product_tab.productId");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StoreBean bean=new StoreBean();
				bean.setStoreId(rs.getInt("storeId"));
				bean.setPurchId(rs.getInt("purchId"));
				bean.setStorageId(rs.getInt("storageId"));
				bean.setRemainNum(rs.getInt("remainNum"));
				bean.setRemarks(rs.getString("remarks"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setProductTime(rs.getString("productTime"));
				bean.setExpireTime(rs.getString("expireTime"));
				list.add(bean);
			}
			//closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(StoreBean bean){ 
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into store_tab (purchId,storageId,remainNum) values (?,?,?)");
			ps.setInt(1, bean.getPurchId());
			ps.setInt(2, bean.getStorageId());
			ps.setInt(3, bean.getRemainNum());
			row=ps.executeUpdate();
			//closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	public int update(StoreBean bean){
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("update store_tab set remainNum=? where purchId=?");
			ps.setInt(1, bean.getRemainNum());
			ps.setInt(2, bean.getPurchId());
			row=ps.executeUpdate();
			//closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	public StoreBean findOne(int id){
		StoreBean bean=new StoreBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select store_tab.storeId,store_tab.purchId,store_tab.storageId,store_tab.remainNum,store_tab.remarks,purch_tab.productTime,purch_tab.expireTime,product_tab.productId,product_tab.productName " +
						"from store_tab,purch_tab,product_tab where store_tab.purchId=purch_tab.purchId and purch_tab.productId=product_tab.productId and storeId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setStoreId(rs.getInt("storeId"));
				bean.setPurchId(rs.getInt("purchId"));
				bean.setStorageId(rs.getInt("storageId"));
				bean.setRemainNum(rs.getInt("remainNum"));
				bean.setRemarks(rs.getString("remarks"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setProductTime(rs.getString("productTime"));
				bean.setExpireTime(rs.getString("expireTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public List<StoreBean> getListBySto(){
		//以仓库编号，商品编号分组的库存列表
		List<StoreBean> list=new ArrayList<StoreBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select store_tab.storageId,product_tab.productId,product_tab.productName,sum(store_tab.remainNum) as 'remainNum'" +
					"from store_tab,purch_tab,product_tab where store_tab.purchId=purch_tab.purchId and purch_tab.productId=product_tab.productId group by store_tab.storageId,product_tab.productId,product_tab.productName");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StoreBean bean=new StoreBean();
				bean.setStorageId(rs.getInt("storageId"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setRemainNum(rs.getInt("remainNum"));
				list.add(bean);
			}
		closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public List<StoreBean> getListByPro(){
		List<StoreBean> list=new ArrayList<StoreBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select product_tab.productId,product_tab.productName,sum(store_tab.remainNum) " +
					"from store_tab,purch_tab,product_tab where store_tab.purchId=purch_tab.purchId and purch_tab.productId=product_tab.productId " +
					"group by product_tab.productId,product_tab.productName");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StoreBean bean=new StoreBean();
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setRemainNum(rs.getInt("remainNum"));
				list.add(bean);
			}
		closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
