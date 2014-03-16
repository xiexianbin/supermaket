package com.record;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.recordcheck.RecordcheckBean;

public class CheckDao extends ConnectionAware{
	/**
	 * 查询所有部门的编号和名字
	 * @return
	 */
	public List<String> selectAllemdept(){
		List<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String sql = "select deptId,deptName from dept_tab";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String id=String.valueOf(rs.getInt("deptId"));
				String name=rs.getString("deptName");
				String mess = id+"-"+name;
				list.add(mess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	/**
	 * 查询所有员工的编号和名字
	 * @return
	 */
	public List<String> selectAllemployee(){
		List<String> list = new ArrayList<String>();
		PreparedStatement ps = null;
		String sql = "select employeeId,employeeName from employee_tab";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String id=String.valueOf(rs.getInt("employeeId"));
				String name=rs.getString("employeeName");
				String mess = id+"-"+name;
				list.add(mess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	//显示所有考勤信息
	public List<Check> selectAll() {
		List<Check> userList=new ArrayList<Check>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from check_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Check user=new Check();
				user.setSalaryId(rs.getInt("salaryId"));
				user.setDeptId(rs.getInt("deptId"));
				user.setEmployeeId(rs.getInt("employeeId"));
				user.setEmployeeName(rs.getString("employeeName"));
				user.setWeeks(rs.getString("weeks"));
				user.setDateTime(rs.getString("dateTime"));
				user.setTime1(rs.getString("time1"));
				user.setTime2(rs.getString("time2"));
				user.setRemarks(rs.getString("remarks"));
				userList.add(user);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return userList;
	}
	//插入excel表中的考勤信息
	public int insertCheck(List<Check> list){
		int row = 0;
		for(int i=0;i<list.size();i++){
			Check check=list.get(i);
			insertCheck(check);
		try {
			PreparedStatement ps=conn.prepareStatement("insert into check_tab(deptId,employeeName,employeeId,dateTime,weeks,time1,time2,remarks) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, check.getDeptId());
			ps.setString(2, check.getEmployeeName());
			ps.setInt(3, check.getEmployeeId());
			ps.setString(4, check.getDateTime());
			ps.setString(5, check.getWeeks());
			ps.setString(6, check.getTime1());
			ps.setString(7, check.getTime2());
			ps.setString(8, check.getRemarks());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return row;
	}
	
	//插入填写的考勤信息
	public int insertCheck(Check check){
		insertRecordcheck(check);
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into check_tab(deptId,employeeName,employeeId,dateTime,weeks,time1,time2,remarks) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, check.getDeptId());
			ps.setString(2, check.getEmployeeName());
			ps.setInt(3, check.getEmployeeId());
			ps.setString(4, check.getDateTime());
			ps.setString(5, check.getWeeks());
			ps.setString(6, check.getTime1());
			ps.setString(7, check.getTime2());
			ps.setString(8, check.getRemarks());
			insertRecordcheck(check);
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	//解析考勤信息存入recordcheck表中
	public int insertRecordcheck(Check check){
		RecordcheckBean rcb=new RecordcheckBean();
		int row = 0;
		if(!check.getTime1().equals("")&&Integer.parseInt((check.getTime1().split(":"))[0])>9){
			rcb.setLate(1);
		}else if(!check.getTime2().equals("")&&Integer.parseInt((check.getTime2().split(":"))[0])<17){
			rcb.setEarly(1);
		}else if(check.getTime1().equals("")&&check.getTime2().equals("")&&check.getRemarks().equals("")){
			rcb.setAbsenteeism(1);
		}else if(!check.getTime2().equals("")&&Integer.parseInt((check.getTime2().split(":"))[0])>19){
			rcb.setOvertime(1);
		}
		try {
			PreparedStatement ps=conn.prepareStatement("insert into recordcheck_tab(employeeId,date,late,early,overtime,absenteeism,remarks) values(?,?,?,?,?,?,?)");
			ps.setInt(1, check.getEmployeeId());
			ps.setString(2, check.getDateTime());
			ps.setInt(3, rcb.getLate());
			ps.setInt(4, rcb.getEarly());
			ps.setInt(5, rcb.getOvertime());
			ps.setInt(6, rcb.getAbsenteeism());
			ps.setString(7, rcb.getRemarks());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public int updateCheck(Check check){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("update check_tab set deptId=?,employeeName=?,employeeId=?,dateTime=?,weeks=?,time1=?,time2=?,remarks=? where salaryId=?");
			ps.setInt(1, check.getDeptId());
			ps.setString(2, check.getEmployeeName());
			ps.setInt(3, check.getEmployeeId());
			ps.setString(4, check.getDateTime());
			ps.setString(5, check.getWeeks());
			ps.setString(6, check.getTime1());
			ps.setString(7, check.getTime2());
			ps.setString(8, check.getRemarks());
			ps.setInt(9, check.getSalaryId());
			row=ps.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	
	public void deleteCheck(int employeeId){
		try {
			PreparedStatement ps=conn.prepareStatement("delete from check_tab where employeeId=?");
			ps.setInt(1, employeeId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Check findUser(int id){
		Check user=new Check();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from Check_tab where salaryId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user.setSalaryId(id);
				user.setDeptId(rs.getInt("deptId"));
				user.setEmployeeId(rs.getInt("employeeId"));
				user.setEmployeeName(rs.getString("employeeName"));
				user.setWeeks(rs.getString("weeks"));
				user.setDateTime(rs.getString("dateTime"));
				user.setTime1(rs.getString("time1"));
				user.setTime2(rs.getString("time2"));
				user.setRemarks(rs.getString("remarks"));
				
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	public ResultSet selectBean(){
		try {
			PreparedStatement ps=conn.prepareStatement("select * from check_tab");
			ResultSet rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
