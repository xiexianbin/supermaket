package com.part;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employee.EmployeeBean;
import com.mvc.connection.basic.ConnectionAware;

public class PartDao extends ConnectionAware{
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有部门的信息
	 */
	public List<PartBean> selectAllPartInfo(){
		
		List<PartBean> list = new ArrayList<PartBean>();
		String sql = "select * from dept_tab";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				PartBean pb = new PartBean();
				pb.setDeptId(rs.getInt("deptId"));
				pb.setDeptName(rs.getString("deptName"));
				pb.setEmployeeId(rs.getInt("employeeId"));
				//通过员工编号获取员工的名称，并存下来
				pb.setEmployeeName(selectEmployeeName(rs.getInt("employeeId")));
				pb.setDeptTel(rs.getString("deptTel"));
				pb.setDeptAddress(rs.getString("deptAddress"));
				if(rs.getString("remarks")!=null){
					pb.setRemarks(rs.getString("remarks"));
				}else{
					pb.setRemarks("");
				}
				list.add(pb);
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
	 * 通过员工编号查询员工的名字
	 * @param employeeId
	 * @return
	 */
	public String selectEmployeeName(int employeeId){
		String emplyeeName = null;
		PreparedStatement ps = null;
		String sql = "select employeeName as Name from employee_tab where employeeId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				emplyeeName = rs.getString("Name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emplyeeName;
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
			//closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			//closeConn(conn, ps);
			return null;
		}
		return list;
	}
	/**
	 * 查询部门的最大编号,并将此编号+1传到后台
	 * @return
	 */
	public int selectMaxDeptId(){
		int ans = 0;
		String sql = "select max(deptId) as ID from dept_tab";
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
	 * 向部门表中添加新的数据
	 * @param pb
	 * @return
	 */
	public boolean insertDept(PartBean pb){
		PreparedStatement ps = null;
		String sql = "insert into dept_tab(deptName,employeeId,deptTel,deptAddress,remarks) values(?,?,?,?,?)";
		try {
			ps = conn.prepareCall(sql);
			ps.setString(1, pb.getDeptName());
			ps.setInt(2, pb.getEmployeeId());
			ps.setString(3, pb.getDeptTel());
			ps.setString(4, pb.getDeptAddress());
			ps.setString(5, pb.getRemarks());
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
	/**
	 * 选择某一个部门表的详细信息
	 * @param deptId
	 * @return
	 */
	public PartBean selectOnePartInfo(int deptId){
		PartBean pb = new PartBean();
		PreparedStatement ps = null;
		String sql = "select * from dept_tab where deptId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				pb.setDeptId(deptId);
				pb.setDeptName(rs.getString("deptName"));
				pb.setDeptAddress(rs.getString("deptAddress"));
				pb.setDeptTel(rs.getString("deptTel"));
				pb.setEmployeeId(rs.getInt("employeeId"));
				pb.setRemarks(rs.getString("remarks"));
			}
		//	closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
			closeConn(conn, ps);
			return null;
		}
		return pb;
	}
	/**
	 * 更新某个部门的信息
	 * @param pb
	 * @return
	 */
	public boolean updatePart(PartBean pb){
		String sql = "update dept_tab set deptAddress=?,deptTel=?,employeeId=?,remarks=? where deptId=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pb.getDeptAddress());
			ps.setString(2, pb.getDeptTel());
			ps.setInt(3, pb.getEmployeeId());
			ps.setString(4, pb.getRemarks());
			ps.setInt(5, pb.getDeptId());
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
	/**
	 * 选出同一部门的所有员工
	 * @param id
	 * @return
	 */
	public List<EmployeeBean>  selectOnePartList(int id){
		List<EmployeeBean> list=new ArrayList<EmployeeBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from employee_tab where deptId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
//			System.out.println(rs);
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
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public String selectDeptName(int id){
		PreparedStatement ps = null;
		String sql = "select deptName from dept_tab where deptId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getString("deptName");
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
