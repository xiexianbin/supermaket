package com.storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class StorageDao extends ConnectionAware{

	/**
	 * 查询所有仓库信息
	 * @return
	 */
	public List<StorageBean> selectAllStorageInfo(){
		List<StorageBean> list = new ArrayList<StorageBean>();
		PreparedStatement ps = null;
		String sql = "select * from storage_tab";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				StorageBean sb = new StorageBean();
				sb.setStorageId(rs.getInt("storageId"));
				sb.setStorageAddress(rs.getString("storageAddress"));
				sb.setStorageArea(rs.getFloat("storageArea"));
				sb.setStorageType(rs.getString("storageType"));
				sb.setEmployeeId(rs.getInt("employeeId"));
				String employeeName=selectEmployeeName(rs.getInt("employeeId"));
				sb.setEmployeeName(employeeName);
				sb.setRemarks(rs.getString("remarks"));
				list.add(sb);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return null;
		}
		return list;
	}
	/**
	 * 
	 */
	public String selectEmployeeName(int id){
		PreparedStatement ps = null;
		String sql = "select employeeName from employee_tab where employeeId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("employeeName");
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 查找仓库最大编号
	 * @return
	 */
	public int selectMaxStorageId(){
		int ans = 0;
		String sql = "select max(storageId) as ID from storage_tab";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ans = rs.getInt("ID");
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return -1;
		}
		return ans;
	}
	/**
	 * 添加新的仓库
	 * @param sb
	 * @return
	 */
	public boolean AddNewStorage(StorageBean sb){
		int ans = 0;
		PreparedStatement ps = null;
		String sql = "insert into storage_tab(storageAddress,storageArea,storageType,employeeId,remarks) values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getStorageAddress());
			ps.setFloat(2, sb.getStorageArea());
			ps.setString(3, sb.getStorageType());
			ps.setInt(4, sb.getEmployeeId());
			ps.setString(5, sb.getRemarks());
			ans = ps.executeUpdate();
			if(ans!=0){
				closeConn(conn, ps);
				return true;
			}else{
				closeConn(conn, ps);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return false;
		}
	}
	/**
	 * 查询单个仓库信息
	 * @param storageId
	 * @return
	 */
	public StorageBean selectOneStorage(int storageId){
		StorageBean sb = new StorageBean();
		PreparedStatement ps = null;
		String sql = "select * from storage_tab where storageId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storageId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sb.setEmployeeId(rs.getInt("employeeId"));
				sb.setStorageId(rs.getInt("storageId"));
				sb.setStorageAddress(rs.getString("storageAddress"));
				sb.setStorageArea(rs.getFloat("storageArea"));
				sb.setStorageType(rs.getString("storageType"));
				sb.setRemarks(rs.getString("remarks"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return null;
		}
		return sb;
	}
	/**
	 * 更新仓库信息
	 * @param sb
	 * @return
	 */
	public boolean updateStorage(StorageBean sb){
		String sql ="update storage_tab set storageAddress=?,storageArea=?,storageType=?,employeeId=?,remarks=? where storageId=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sb.getStorageAddress());
			ps.setFloat(2, sb.getStorageArea());
			ps.setString(3, sb.getStorageType());
			ps.setInt(4, sb.getEmployeeId());
			ps.setString(5, sb.getRemarks());
			ps.setInt(6, sb.getStorageId());
			int ans = ps.executeUpdate();
			if(ans!=0){
				closeConn(conn, ps);
				return true; 
			}else{
				closeConn(conn, ps);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return false;
		}
	}
}
