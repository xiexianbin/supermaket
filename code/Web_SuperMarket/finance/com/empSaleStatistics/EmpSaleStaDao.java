package com.empSaleStatistics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.EmployeeBean;
import com.inexpense.InexpenseBean;
import com.mvc.connection.basic.ConnectionAware;

public class EmpSaleStaDao extends ConnectionAware {
	
	
	
	
	
	public  ArrayList<EmployeeBean> getEmployeeList(){//在职的运营部员工
		
		ArrayList<EmployeeBean> list=new ArrayList<EmployeeBean>();
		

		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from employee_tab where employeeState=? and deptId=?");
			
			ps.setString(1, "在职" );
			ps.setInt(2, 1004);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				EmployeeBean eb=new EmployeeBean();
				eb.setEmployeeId(rs.getInt("employeeId"));
				eb.setEmployeeName(rs.getString("employeeName"));
				eb.setEmployeeBirthday(rs.getString("employeeBirthday"));         
				eb.setEmployeeSex(rs.getString("employeeSex"));
				eb.setEmployeeIdNum(rs.getString("employeeIdNum"));
				eb.setEmpPoliState(rs.getString("empPoliState"));
				eb.setEmployeePicture(rs.getString("employeePicture"));
				eb.setEmployeeTel(rs.getString("employeeTel"));
				eb.setEmployeeQq(rs.getString("employeeQq"));
				eb.setEmployeeEmail(rs.getString("employeeEmail"));
				eb.setEmployeeSchool(rs.getString("employeeSchool"));
				eb.setEmployeeAddress(rs.getString("employeeAddress"));
				eb.setEmployeePosition(rs.getString("employeePosition"));
				eb.setBasicWage(rs.getFloat("basicWage"));
				eb.setDeptId(rs.getInt("deptId"));
				eb.setEntryTime(rs.getString("entryTime"));
				eb.setLeaveTime(rs.getString("leaveTime"));
				eb.setEmployeeState(rs.getString("employeeState"));
				eb.setRemarks(rs.getString("remarks"));
				
				
				list.add(eb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

	public ArrayList<EmpSaleStaBean> getEveryEmpSaleStaList(int empid, String dat) {
		ArrayList<EmpSaleStaBean> list = new ArrayList<EmpSaleStaBean>();
		try {
			PreparedStatement ps = conn.prepareStatement("select employee_tab.employeeId,employee_tab.employeeName,sales_tab.productId,sales_tab.productPrice,sales_tab.count " +
					"from sales_tab,employee_tab " +
					"where sales_tab.employeeId=employee_tab.employeeId and sales_tab.employeeId=? and sales_tab.salesTime like '"+dat+"%'");
			ps.setInt(1, empid);
//			System.out.println(dat);
			ResultSet rs = ps.executeQuery();

			// private int employeeId;//员工编号
			// private String employeeName;//员工姓名
			// private float productPrice;//商品售价
			// private int count;//顾客购买的数量

			while (rs.next()) {
				EmpSaleStaBean bean = new EmpSaleStaBean();
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setEmployeeName(rs.getString("employeeName"));
				bean.setProductId(rs.getInt("productId"));
				bean.setProductPrice(rs.getFloat("productPrice"));
				bean.setCount(rs.getInt("count"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
