package com.inexpense;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class InexpenseDao extends ConnectionAware{

	//收入列表
		public List<InexpenseBean> inexpenseList(){
			List<InexpenseBean> inexpenseList=new ArrayList<InexpenseBean>();
			try {
				PreparedStatement ps=conn.prepareStatement("select inExpenId,inexpense_tab.employeeId,employee_tab.employeeName,dept_tab.deptName,inReason,money,inDate,inexpense_tab.remarks from (inexpense_tab inner join employee_tab on inexpense_tab.employeeId = employee_tab.employeeId) inner join dept_tab on employee_tab.deptId=dept_tab.deptId");
			    ResultSet rs=ps.executeQuery();
			    while(rs.next()){
			    	InexpenseBean inexpense=new InexpenseBean();
			    	String inDate1=rs.getString("inDate");
			    	StringBuffer inDate=new StringBuffer(inDate1);
			    	inDate=inDate.insert(4, "-");
			    	inDate=inDate.insert(7, "-");
			    	inexpense.setInExpenId(rs.getInt("inExpenId"));
			    	inexpense.setEmployeeId(rs.getInt("employeeId"));
			    	inexpense.setEmployeeName(rs.getString("employeeName"));
			    	inexpense.setDeptName(rs.getString("deptName"));
			    	inexpense.setInReason(rs.getString("inReason"));
			    	inexpense.setMoney(rs.getFloat("money"));
			    	inexpense.setInDate(inDate.toString());
			    	inexpense.setRemarks(rs.getString("remarks"));
			    	inexpenseList.add(inexpense);
			    }
			conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return inexpenseList;
		}
		
		//查找单个收入记录
		public InexpenseBean selectOneInexpense(int id){
			InexpenseBean inexpense=new InexpenseBean();
			try {
				PreparedStatement ps=conn.prepareStatement("select inExpenId,inexpense_tab.employeeId,employee_tab.employeeName,dept_tab.deptName,inReason,money,inDate,inexpense_tab.remarks from (inexpense_tab inner join employee_tab on inexpense_tab.employeeId = employee_tab.employeeId) inner join dept_tab on employee_tab.deptId=dept_tab.deptId where inExpenId=?");
			    ps.setInt(1, id);
			    ResultSet rs=ps.executeQuery();
			    if(rs.next()){
			    	String inDate1=rs.getString("inDate");
			    	StringBuffer inDate=new StringBuffer(inDate1);
			    	inDate=inDate.insert(4, "-");
			    	inDate=inDate.insert(7, "-");
			    	inexpense.setInExpenId(id);
			    	inexpense.setEmployeeId(rs.getInt("employeeId"));
			    	inexpense.setEmployeeName(rs.getString("employeeName"));
			    	inexpense.setDeptName(rs.getString("deptName"));
			    	inexpense.setInReason(rs.getString("inReason"));
			    	inexpense.setMoney(rs.getFloat("money"));
			    	inexpense.setInDate(inDate.toString());
			    	inexpense.setRemarks(rs.getString("remarks"));
			    }
//			    conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return inexpense;
		}
		
		//更新收入信息
		public int updateInexpense(InexpenseBean inexpense){
			int row=0;
			try {
				PreparedStatement ps=conn.prepareStatement("update inexpense_tab set employeeId=?,inReason=?,money=?,inDate=?,remarks=? where inExpenId=?");
			    ps.setInt(1, inexpense.getEmployeeId());
			    ps.setString(2, inexpense.getInReason());
			    ps.setFloat(3, inexpense.getMoney());
			    ps.setString(4, inexpense.getInDate());
			    ps.setString(5, inexpense.getRemarks());
			    ps.setInt(6, inexpense.getInExpenId());
			    row=ps.executeUpdate();
			    conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row;
		}
		
		//添加收入信息
		public int insertInexpense(InexpenseBean inexpense){
			int row=0;
			try {
				PreparedStatement ps=conn.prepareStatement("insert into inexpense_tab (employeeId,inReason,money,inDate,remarks) values(?,?,?,?,?)");
				ps.setInt(1, inexpense.getEmployeeId());
			    ps.setString(2, inexpense.getInReason());
			    ps.setFloat(3, inexpense.getMoney());
			    ps.setString(4, inexpense.getInDate());
			    ps.setString(5, inexpense.getRemarks());
			    row=ps.executeUpdate();
			    conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row;
		}
		
		public int deleteInexpense(int id){
			int row=0;
			try {
				PreparedStatement ps=conn.prepareStatement("delete from inexpense_tab where inExpenId=?");
			    ps.setInt(1, id);
			    row=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return row;
			
		}
		
		public List<InexpenseBean> selectInexpenseToday(String time){
			String time1=null;System.out.println(time.length());
			
			if(time.length()==4){
				time1=time+"年";
			}else if(time.length()==7){
				time1=time.replaceFirst("-", "年");
				time1=time1+"月";
			}else{
				time1=time.replaceFirst("-", "年");
				time1=time1.replace("-", "月");
				time1=time1+"日";
			}
			time=time.replace("-", "");
			List<InexpenseBean> list = new ArrayList<InexpenseBean>();
			try {
				PreparedStatement ps=conn.prepareStatement("select sum(money) as count from inExpense_tab where inDate like '"+time+"%' ");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				InexpenseBean out=new InexpenseBean();
				out.setCount(rs.getFloat("count"));
				out.setTime(time1);
				list.add(out);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
			
		}
}
