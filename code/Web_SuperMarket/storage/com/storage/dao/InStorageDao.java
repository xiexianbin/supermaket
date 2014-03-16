package com.storage.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.storage.bean.InStorageBean;

public class InStorageDao extends ConnectionAware{
	
	public List<InStorageBean> getList(){
		//查询入库列表
		List<InStorageBean> list=new ArrayList<InStorageBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select inStorage_tab.instorageId,inStorage_tab.inNum,inStorage_tab.inReason,inStorage_tab.inTime,inStorage_tab.remarks,purch_tab.purchId,storage_tab.storageId,storage_tab.storageType,employee_tab.employeeId,employee_tab.employeeName,product_tab.productId,product_tab.productName from product_tab,employee_tab,purch_tab,inStorage_tab,storage_tab " +
					"where inStorage_tab.storageId=storage_tab.storageId and inStorage_tab.purchId=purch_tab.purchId and inStorage_tab.employeeId=employee_tab.employeeId and product_tab.productId=purch_tab.productId");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				InStorageBean bean=new InStorageBean();
				bean.setInstorageId(rs.getInt("instorageId"));
				bean.setStorageId(rs.getInt("storageId"));
				bean.setPurchId(rs.getInt("purchId"));
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setInNum(rs.getInt("inNum"));
				bean.setInTime(rs.getString("inTime"));
				bean.setInReason(rs.getString("inReason"));
				bean.setRemarks(rs.getString("remarks"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setEmployeeName(rs.getString("employeeName"));
				bean.setStorageType(rs.getString("storageType"));
				list.add(bean);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int insert(InStorageBean bean){
		//添加入库信息
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into inStorage_tab (storageId,purchId,employeeId,inNum,inTime,inReason,remarks) values(?,?,?,?,?,?,?)");
			ps.setInt(1, bean.getStorageId());
			ps.setInt(2, bean.getPurchId());
			ps.setInt(3, bean.getEmployeeId());
			ps.setInt(4, bean.getInNum());
			ps.setString(5, bean.getInTime());
			ps.setString(6, bean.getInReason());
			ps.setString(7, bean.getRemarks());
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	public InStorageBean findOne(int id){
		//查询单个
		InStorageBean bean=new InStorageBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select inStorage_tab.instorageId,inStorage_tab.inNum,inStorage_tab.inReason,inStorage_tab.inTime,inStorage_tab.remarks,purch_tab.purchId,storage_tab.storageId,storage_tab.storageType,employee_tab.employeeId,employee_tab.employeeName,product_tab.productId,product_tab.productName from product_tab,employee_tab,purch_tab,inStorage_tab,storage_tab " +
					"where inStorage_tab.storageId=storage_tab.storageId and inStorage_tab.purchId=purch_tab.purchId and inStorage_tab.employeeId=employee_tab.employeeId and product_tab.productId=purch_tab.productId and inStorage_tab.instorageId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setInstorageId(id);
				bean.setStorageId(rs.getInt("storageId"));
				bean.setPurchId(rs.getInt("purchId"));
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setInNum(rs.getInt("inNum"));
				bean.setInTime(rs.getString("inTime"));
				bean.setInReason(rs.getString("inReason"));
				bean.setRemarks(rs.getString("remarks"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductName(rs.getString("productName"));
				bean.setEmployeeName(rs.getString("employeeName"));
				bean.setStorageType(rs.getString("storageType"));
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public int update(InStorageBean bean){
		//修改入库信息
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("update inStorage_tab set storageId=?,purchId=?,employeeId=?,inNum=?,inTime=?,inReason=?,remarks=? where instorageId=?");
			ps.setInt(8, bean.getInstorageId());
			ps.setInt(1, bean.getStorageId());
			ps.setInt(2, bean.getPurchId());
			ps.setInt(3, bean.getEmployeeId());
			ps.setInt(4, bean.getInNum());
			ps.setString(5, bean.getInTime());
			ps.setString(6, bean.getInReason());
			ps.setString(7, bean.getRemarks());
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
}
