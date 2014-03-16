package com.salary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.EmployeeBean;
import com.mvc.connection.basic.ConnectionAware;
import com.part.PartBean;
import com.tools.Utils;

public class WagesDao extends ConnectionAware{
	
	
	public EmployeeBean selectEmp(int id){
		EmployeeBean eb=new EmployeeBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from employee_tab where employeeId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				eb.setEmployeeId(id);
				eb.setEmployeeName(rs.getString("employeeName"));
				eb.setBasicWage(rs.getFloat("basicWage"));
				eb.setDeptId(rs.getInt("deptId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eb;
	}
	
	
	
	public String selectOnePartInfo(int deptId){
		String deptName="";
		PreparedStatement ps = null;
		String sql = "select * from dept_tab where deptId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				deptName=rs.getString("deptName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return null;
		}
		return deptName;
	}
	
	
	public int selectNum(String sql){
		int num=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				num=rs.getInt("num");
			}
			if(sql.endsWith("overtime=1")){
				closeConn(conn, rs, ps);
				//System.out.println("11111");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num;
	}
	//添加工资表信息
	
	public int insertSalary(SalaryBean bean){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into salary_tab (employeeId,salary,salaryTime,remarks) values(?,?,?,?)");
			ps.setInt(1, bean.getEmployeeId());
			ps.setFloat(2, bean.getSalary());
			ps.setString(3, bean.getSalaryTime());
			ps.setString(4, bean.getRemarks());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	//查询员工是否已经发过工资
	public int onesalary(String sql){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				row=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	//查询所有工资表信息
	public List<SalaryBean> selectAll(){
		List<SalaryBean> list=new ArrayList<SalaryBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from salary_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SalaryBean bean=new SalaryBean();
				bean.setSalaryId(rs.getInt("salaryId"));
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setSalary(rs.getInt("salary"));
				bean.setSalaryTime(rs.getString("salaryTime"));
				bean.setRemarks(rs.getString("remarks"));
				
				//获取员工部门编号
				EmployeeBean eb=this.selectEmp(rs.getInt("employeeId"));
				bean.setEmployeeName(eb.getEmployeeName());
				
				//获取员工部门名称
				bean.setDeptName(this.selectOnePartInfo(eb.getDeptId()));
				
//				System.out.println(bean.getEmployeeName());
//				System.out.println(bean.getDeptName());
				
				list.add(bean);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	//查询员工今年工资列表
	public List<SalaryBean> selectOne(int employeeId){
		
		String date=Utils.getDate();
		date=date.substring(0, 5);
		
		String sql="select * from salary_tab where employeeId="+employeeId+" and salaryTime like '"+date+"%'";
		
		List<SalaryBean> list=new ArrayList<SalaryBean>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SalaryBean bean=new SalaryBean();
				bean.setSalaryId(rs.getInt("salaryId"));
				bean.setEmployeeId(rs.getInt("employeeId"));
				bean.setSalary(rs.getInt("salary"));
				bean.setSalaryTime(rs.getString("salaryTime"));
				bean.setRemarks(rs.getString("remarks"));
				
				//获取员工部门编号
				EmployeeBean eb=this.selectEmp(rs.getInt("employeeId"));
				bean.setEmployeeName(eb.getEmployeeName());
				
				//获取员工部门名称
				bean.setDeptName(this.selectOnePartInfo(eb.getDeptId()));
				
//				System.out.println(bean.getEmployeeName());
//				System.out.println(bean.getDeptName());
				
				list.add(bean);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
		
		
		
		
	}
	
	
}
