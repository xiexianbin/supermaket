package com.systemConfig.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.connection.basic.ConnectionAware;

public class systemConfigDao extends ConnectionAware{
	
	public boolean selectLoginUser(int id ,String name){
		PreparedStatement ps = null;
		String sql ="select * from user_tab where employeeId=? and userPass=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				closeConn(conn, rs, ps);
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
	public boolean updatePassword(int id ,String pass){
		PreparedStatement ps = null;
		String sql ="update user_tab set userPass=? where employeeId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setInt(2, id);
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
	public String selectUserState(int id){
		PreparedStatement ps = null;
		String sql = "select userState from user_tab where employeeId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("userState");
			}else{
				return "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	public boolean updateState(int id ,String state){
		PreparedStatement ps = null;
		String sql = "update user_tab set userState=? where employeeId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, state);
			ps.setInt(2, id);
			int ans = ps.executeUpdate();
			if(ans!=0){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public String findDeptName(int id){
		PreparedStatement ps = null;
		String sql = "select deptName from dept_tab where deptId=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("deptName");
			}
			return "";
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
}
