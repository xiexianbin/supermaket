package com.storage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.storage.bean.OutStorageBean;
import com.storage.bean.StoreBean;

public class OutStorageDao extends ConnectionAware{

	public List<OutStorageBean> getList(){
		//查询出库信息
		List<OutStorageBean> list=new ArrayList<OutStorageBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select outStorage_tab.outStorageId,outStorage_tab.outNum,outStorage_tab.outDirection,outStorage_tab.reason,outStorage_tab.outTime,purch_tab.purchId,storage_tab.storageId,storage_tab.storageType,employee_tab.employeeId,employee_tab.employeeName,product_tab.productId,product_tab.productName " +
					"from product_tab,employee_tab,purch_tab,outStorage_tab,storage_tab where outStorage_tab.storageId=storage_tab.storageId and outStorage_tab.purchId=purch_tab.purchId and outStorage_tab.employeeId=employee_tab.employeeId and product_tab.productId=purch_tab.productId");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				OutStorageBean bean=new OutStorageBean();
				bean.setOutStorageId(rs.getInt("outstorageId"));
				bean.setStorageId(rs.getInt("storageId"));
				bean.setPurchId(rs.getInt("purchId"));
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setOutNum(rs.getInt("outNum"));
				bean.setOutTime(rs.getString("outTime"));
				bean.setOutDirection(rs.getString("outDirection"));
				bean.setReason(rs.getString("reason"));
				bean.setEmployeeName(rs.getString("employeeName"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setStorageType(rs.getString("storageType"));
				list.add(bean);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(OutStorageBean bean){
		//添加出库信息
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into outStorage_tab (storageId,purchId,employeeId,outNum,outTime,outDirection,reason) values(?,?,?,?,?,?,?)");
			ps.setInt(1, bean.getStorageId());
			ps.setInt(2, bean.getPurchId());
			ps.setInt(3, bean.getEmployeeId());
			ps.setInt(4, bean.getOutNum());
			ps.setString(5, bean.getOutTime());
			ps.setString(6, bean.getOutDirection());
			ps.setString(7, bean.getReason());
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public OutStorageBean findOne(int id){
		//按流水号查找单个出库记录
		OutStorageBean bean=new OutStorageBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select outStorage_tab.outstorageId,outStorage_tab.outNum,outStorage_tab.outDirection,outStorage_tab.reason,outStorage_tab.outTime,purch_tab.purchId,storage_tab.storageId,storage_tab.storageType,employee_tab.employeeId,employee_tab.employeeName,product_tab.productId,product_tab.productName " +
					"from product_tab,employee_tab,purch_tab,outStorage_tab,storage_tab where outStorage_tab.storageId=storage_tab.storageId and outStorage_tab.purchId=purch_tab.purchId and outStorage_tab.employeeId=employee_tab.employeeId and product_tab.productId=purch_tab.productId and outStorage_tab.outstorageId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setOutStorageId(id);
				bean.setStorageId(rs.getInt("storageId"));
				bean.setPurchId(rs.getInt("purchId"));
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setOutNum(rs.getInt("outNum"));
				bean.setOutTime(rs.getString("outTime"));
				bean.setOutDirection(rs.getString("outDirection"));
				bean.setReason(rs.getString("reason"));
				bean.setEmployeeName(rs.getString("employeeName"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setStorageType(rs.getString("storageType"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public int update(OutStorageBean bean){
		//修改出库信息
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("update outStorage_tab set storageId=?,purchId=?,employeeId=?,outNum=?,outTime=?,outDirection=?,reason=? where outStorageId=?");
			ps.setInt(1, bean.getStorageId());
			ps.setInt(2, bean.getPurchId());
			ps.setInt(3, bean.getEmployeeId());
			ps.setInt(4, bean.getOutNum());
			ps.setString(5, bean.getOutTime());
			ps.setString(6, bean.getOutDirection());
			ps.setString(7, bean.getReason());
			ps.setInt(8, bean.getOutStorageId());
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	public StoreBean selectStore(int purchId){
		StoreBean store=new StoreBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from store_tab where purchId=?");
			ps.setInt(1,purchId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				store.setPurchId(purchId);
				store.setStorageId(rs.getInt("storageId"));
				store.setRemainNum(rs.getInt("remainNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return store;
	}
	
	
}
