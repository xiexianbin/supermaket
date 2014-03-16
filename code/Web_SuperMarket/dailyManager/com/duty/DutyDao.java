package com.duty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class DutyDao extends ConnectionAware {

	//查询全部值日列表
	public List<DutyBean> dutyList(){
		List<DutyBean> list = new ArrayList<DutyBean>();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("" +
					"select duty_tab.dutyId, duty_tab.employeeId, employee_tab.employeeName, dept_tab.deptName, " +
					"date, beginTime, endTime, duty_tab.remarks " +
					"from (duty_tab inner join employee_tab on duty_tab.employeeId = employee_tab.employeeId) " +
					"inner join dept_tab on employee_tab.deptId=dept_tab.deptId");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DutyBean bean = new DutyBean();
				bean.setDutyId(rs.getInt("dutyId"));
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setEmployeeName(rs.getString("employeeName"));
				bean.setDeptName(rs.getString("deptName"));
				bean.setDate(rs.getString("date"));
				bean.setBeginTime(rs.getString("beginTime"));
				bean.setEndTime(rs.getString("endTime"));
				bean.setRemarks(rs.getString("remarks"));
				list.add(bean);
			}
//			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//查询部门值班表
	public List<DutyBean> dutyDeptList(int deptId) {
		// TODO Auto-generated method stub
		System.out.println("查询部门的值班信息。");
		List<DutyBean> list = new ArrayList<DutyBean>();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select duty_tab.dutyId, duty_tab.employeeId, " +
					"employee_tab.employeeName, dept_tab.deptName, duty_tab.date, duty_tab.beginTime, " +
					"duty_tab.endTime, duty_tab.remarks " +
					"from (duty_tab inner join employee_tab on duty_tab.employeeId = employee_tab.employeeId) " +
					"inner join dept_tab on employee_tab.deptId=dept_tab.deptId where dept_tab.deptId= ?");
			ps.setInt(1, deptId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DutyBean bean = new DutyBean();
				bean.setDutyId(rs.getInt("dutyId"));
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setEmployeeName(rs.getString("employeeName"));
				bean.setDeptName(rs.getString("deptName"));
				bean.setDate(rs.getString("date"));
				bean.setBeginTime(rs.getString("beginTime"));
				bean.setEndTime(rs.getString("endTime"));
				bean.setRemarks(rs.getString("remarks"));
				list.add(bean);
			}
//			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//获取最大的值日编号
	public int getDutyIdIndex() {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select max(dutyId) max from duty_tab");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				i = rs.getInt("max");
			}
//			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	//获取用户的基本信息
	public String getEmpInf(int employeeId) {
		// TODO Auto-generated method stub
		String empInf = new String();
		try {
			PreparedStatement ps = conn.prepareStatement("select " +
					"employee_tab.employeeName, dept_tab.deptId, dept_tab.deptName " +
					"from employee_tab inner join dept_tab on dept_tab.deptId=employee_tab.deptId " +
					"where employee_tab.employeeId = ?");
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				empInf+=rs.getString("employeeName");
				empInf+=","+rs.getString("deptId");
				empInf+=rs.getString("deptName");
//				System.out.println(empInf);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empInf;
	}

	//插入值日信息
	public int insertDuty(DutyBean dutyBean) {
		// TODO Auto-generated method stub
		int row = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into duty_tab(employeeId, date, beginTime, endTime, remarks) values(?, ?, ?, ?, ?)");
			ps.setInt(1, dutyBean.getEmployeeId());
			ps.setString(2, dutyBean.getDate());
			ps.setString(3, dutyBean.getBeginTime());
			ps.setString(4, dutyBean.getEndTime());
			ps.setString(5, dutyBean.getRemarks());
			row = ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
}
