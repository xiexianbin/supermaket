package com.outexpense;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.turnover.TurnoverBean;

public class OutexpenseDao extends ConnectionAware{
	
	//支出列表
	public List<OutexpenseBean> outexpenseList(){
		List<OutexpenseBean> outexpenseList=new ArrayList<OutexpenseBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select outExpenId,outexpense_tab.employeeId,employee_tab.employeeName,dept_tab.deptName,outReason,money,outDate,outexpense_tab.remarks from (outexpense_tab inner join employee_tab on outexpense_tab.employeeId = employee_tab.employeeId) inner join dept_tab on employee_tab.deptId=dept_tab.deptId");
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()){
		    	OutexpenseBean outexpense=new OutexpenseBean();
		    	String outDate1=rs.getString("outDate");
		    	StringBuffer outDate=new StringBuffer(outDate1);
		    	outDate=outDate.insert(4, "-");
		    	outDate=outDate.insert(7, "-");
		    	outexpense.setOutExpenId(rs.getInt("outExpenId"));
		    	outexpense.setEmployeeId(rs.getInt("employeeId"));
		    	outexpense.setEmployeeName(rs.getString("employeeName"));
		    	outexpense.setDeptName(rs.getString("deptName"));
		    	outexpense.setOutReason(rs.getString("outReason"));
		    	outexpense.setMoney(rs.getFloat("money"));
		    	outexpense.setOutDate(outDate.toString());
		    	outexpense.setRemarks(rs.getString("remarks"));
		    	outexpenseList.add(outexpense);
		    }
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outexpenseList;
	}
	
	//查找单个支出记录
	public OutexpenseBean selectOneOutexpense(int id){
		OutexpenseBean outexpense=new OutexpenseBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select outExpenId,outexpense_tab.employeeId,employee_tab.employeeName,dept_tab.deptName,outReason,money,outDate,outexpense_tab.remarks from (outexpense_tab inner join employee_tab on outexpense_tab.employeeId = employee_tab.employeeId) inner join dept_tab on employee_tab.deptId=dept_tab.deptId where outExpenId=?");
		    ps.setInt(1, id);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next()){
		    	String outDate1=rs.getString("outDate");
		    	StringBuffer outDate=new StringBuffer(outDate1);
		    	outDate=outDate.insert(4, "-");
		    	outDate=outDate.insert(7, "-");
		    	outexpense.setOutExpenId(id);
		    	outexpense.setEmployeeId(rs.getInt("employeeId"));
		    	outexpense.setEmployeeName(rs.getString("employeeName"));
		    	outexpense.setDeptName(rs.getString("deptName"));
		    	outexpense.setOutReason(rs.getString("outReason"));
		    	outexpense.setMoney(rs.getFloat("money"));
		    	outexpense.setOutDate(outDate.toString());
		    	outexpense.setRemarks(rs.getString("remarks"));
		    }
//		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outexpense;
	}
	
	//更新支出信息
	public int updateOutexpense(OutexpenseBean outexpense){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("update outexpense_tab set employeeId=?,outReason=?,money=?,outDate=?,remarks=? where outExpenId=?");
		    ps.setInt(1, outexpense.getEmployeeId());
		    ps.setString(2, outexpense.getOutReason());
		    ps.setFloat(3, outexpense.getMoney());
		    ps.setString(4, outexpense.getOutDate());
		    ps.setString(5, outexpense.getRemarks());
		    ps.setInt(6, outexpense.getOutExpenId());
		    row=ps.executeUpdate();
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	//添加支出信息
	public int insertOutexpense(OutexpenseBean outexpense){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into outexpense_tab (employeeId,outReason,money,outDate,remarks) values(?,?,?,?,?)");
			ps.setInt(1, outexpense.getEmployeeId());
		    ps.setString(2, outexpense.getOutReason());
		    ps.setFloat(3, outexpense.getMoney());
		    ps.setString(4, outexpense.getOutDate());
		    ps.setString(5, outexpense.getRemarks());
		    row=ps.executeUpdate();
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public int deleteOutexpense(int id){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("delete from outexpense_tab where outExpenId=?");
		    ps.setInt(1, id);
		    row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	
	
	
	//总支出dao
	
	public List<OutexpenseBean> selectOutexpenseToday(String time){
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
		List<OutexpenseBean> list = new ArrayList<OutexpenseBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select sum(money) as count from outExpense_tab where outDate like '"+time+"%' ");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			OutexpenseBean out=new OutexpenseBean();
			out.setCount(rs.getFloat("count"));
			out.setTime(time1);
			list.add(out);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
//	/**
//	 * 获取某段时间的所有销售额
//	 * @param time
//	 * @return
//	 */
//	public float selectMoney(String time){
//		System.out.println("haha"+time);
//		PreparedStatement ps = null;
//		String sql = "select sum(count*productPrice) as Money from sales_tab where salesTime like '"+time+"%'";
//		try {
//			ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()){
//				try{
//					float money = Float.parseFloat(rs.getString("Money"));
//					return money;
//				}catch(Exception e){
//					return 0;
//				}
//			}else{
//				return 0;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return 0;
//		}
//	}
//	/**
//	 * 查询限定年份的12个月的销售额报表
//	 * @param id
//	 * @param time
//	 * @return
//	 */
//	public List<OutexpenseBean> selectOutexpenseYear(String time){
//		List<OutexpenseBean> list = new ArrayList<OutexpenseBean>();
//		for(int i = 1;i<=12;i++){
//			PreparedStatement ps = null;
//			String newTime = null;
//			String FinalTime = null;
//			if(i<10){
//				newTime =time+"年0"+String.valueOf(i)+"月";
//				FinalTime = time+"0"+String.valueOf(i);
//			}else{
//				newTime =time+"年"+String.valueOf(i)+"月";
//				FinalTime = time+String.valueOf(i);
//			}
//			System.out.println("selectTurnoverYear的时间为："+FinalTime);
//			String sql = "SELECT count(distinct salesWaterNo) as SaleNumber FROM sales_tab where salesTime like '"+FinalTime+"%'";
//			try {
//				ps = conn.prepareStatement(sql);
//				ResultSet rs = ps.executeQuery();
//				if(rs.next()){
//					OutexpenseBean tb = new OutexpenseBean();
//					int count = Integer.parseInt(rs.getString("SaleNumber"));
//					tb.setCount(count);
////					System.out.println(FinalTime+"----------------");
//					float money = selectMoney(FinalTime);
//					tb.setMoney(money);
//					tb.setTime(newTime);
//					list.add(tb);
//				}
//			} catch (SQLException e) {
//				//e.printStackTrace();
//			}
//		}
//		return list;
//	}
//	/**
//	 * 每个月的所有天的销售额统计
//	 * @param id
//	 * @param time
//	 * @return
//	 */
//	public List<OutexpenseBean> selectOutexpenseMonth(String time){
//		List<OutexpenseBean> list = new ArrayList<OutexpenseBean>();
//		int year = Integer.parseInt(time.split("-")[0]);
//		int month = Integer.parseInt(time.split("-")[1]);
//		int day;
//		if(month==4||month==6||month==9||month==11){
//			day=30;
//		}else if(month==2){
//			if((year%400==0)||(year%4==0 && year%100!=0)){
//				day=29;
//			}else{
//				day=28;
//			}
//		}else{
//			day=31;
//		}	
//		for(int i=1;i<=day;i++){
//			PreparedStatement ps = null;
//			String newTime = time.replace("-", "年");
//			String FinalTime = time.replace("-", "");
//			if(i<10){
//				newTime +="月0"+String.valueOf(i)+"日";
//				FinalTime +="0"+String.valueOf(i);
//			}else{
//				newTime +="月"+String.valueOf(i)+"日";
//				FinalTime +=String.valueOf(i);
//			}
//			System.out.println("selectTurnoverMonth里的时间为："+FinalTime);
//			String sql = "SELECT count(distinct salesWaterNo) as SaleNumber FROM sales_tab where salesTime like '"+FinalTime+"%'";
//			try {
//				ps = conn.prepareStatement(sql);
//				ResultSet rs = ps.executeQuery();
//				if(rs.next()){
//					OutexpenseBean tb = new OutexpenseBean();
//					int count = Integer.parseInt(rs.getString("SaleNumber"));
//					tb.setCount(count);
//	//				System.out.println(FinalTime+"----------------");
//					float money = selectMoney(FinalTime);
//					tb.setMoney(money);
//					tb.setTime(newTime);
//					list.add(tb);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
//	}
}
