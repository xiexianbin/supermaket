package com.productSale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;


public class SalesDao extends ConnectionAware{
	
	ArrayList<SalesBean> list=new ArrayList<SalesBean>();
	
	//获取全部销售商品信息
public  ArrayList<SalesBean> getAllSalesList(String FinalTime){
		try {
			PreparedStatement ps=conn.prepareStatement("select * from sales_tab where salesTime like '"+FinalTime+"%'" );
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SalesBean sb=new SalesBean();
				sb.setSalesId(rs.getInt("salesId"));
				sb.setProductId(rs.getInt("purchId"));
				sb.setCount(rs.getInt("count"));
				sb.setSalesTime(rs.getString("salesTime"));
				sb.setSalesWaterNo(rs.getString("salesWaterNo"));
				sb.setRemarks(rs.getString("remarks"));
				list.add(sb);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//按月查询销售商品信息
public List<SalesBean> selectSalesMonth(String id,String time){
	int year=Integer.parseInt(time.split("-")[0]);
	int month=Integer.parseInt(time.split("-")[1]);
	int day;
	if(month==4||month==6||month==9||month==11){
		day=30;
	}else if(month==2){
		if((year%400==0)||(year%4==0 && year%100!=0)){
			day=29;
		}else{
			day=28;
		}
	}else{
		day=31;
	}	
	for(int i=1;i<=day;i++){
		PreparedStatement ps = null;
		String eTime = time;
		String newTime = time.replace("-", "年");
		String FinalTime = time.replace("-", "");
		if(i<10){
			newTime +="月0"+String.valueOf(i)+"日";
			FinalTime +="0"+String.valueOf(i);
			eTime +="0-"+String.valueOf(i);
		}else{
			newTime +="月"+String.valueOf(i)+"日";
			FinalTime +=String.valueOf(i);
			eTime += "-"+String.valueOf(i);
		}

	String sql="select sum(count) as SaleNumber from sales_tab where salesTime like '"+FinalTime+"%'";

	try {
		ps=conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			SalesBean sb=new SalesBean();
							sb.setCount(rs.getInt("SaleNumber"));
							sb.setSalesTime(newTime);
							sb.setTime(eTime);
							list.add(sb);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return list;
			}
public List<SalesBean> selectSalesToday(String id, String time) {
	PreparedStatement ps=null;
	String newTime=time.replaceFirst("-","年");
	String FinalTime=newTime.replaceFirst("-", "月");
	time=time.replace("-", "");
	String sql="select sum(count) as SaleNumber from sales_tab where salesTime like '"+FinalTime+"%'";
	try {
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			SalesBean sb=new SalesBean();
			sb.setCount(rs.getInt("SaleNumber"));
			sb.setSalesTime(newTime);
			sb.setTime(time);
			list.add(sb);
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return list;
}
public List<SalesBean> selectSalesYear(String id, String time) {
	for(int i = 1;i<=12;i++){
		PreparedStatement ps = null;
		String etime=null;
		String newTime = null;
		String FinalTime = null;
		if(i<10){
			newTime =time+"年0"+String.valueOf(i)+"月";
			FinalTime = time+"0"+String.valueOf(i);
			etime = time+"0-"+String.valueOf(i);
		}else{
			newTime =time+"年"+String.valueOf(i)+"月";
			FinalTime = time+String.valueOf(i);
			etime = time+"-"+String.valueOf(i);
		}
		String sql = "select sum(count) as SaleNumber from sales_tab where salesTime like '"+FinalTime+"%'";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				SalesBean sb=new SalesBean();
				sb.setCount(rs.getInt("SaleNumber"));
				sb.setSalesTime(newTime);
				sb.setTime(etime);
				list.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return list;
}


public List<SalesBean> selectSalesT(String id, String time){
	PreparedStatement ps=null;
	String newTime=time.replaceFirst("-","年");
	String FinalTime=newTime.replaceFirst("-", "月");
	time=time.replace("-", "");
	String sql="select count,purchId from sales_tab where salesTime like '"+FinalTime+"%'";
	try {
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			SalesBean sb=new SalesBean();
			sb.setProductId(rs.getInt("purchId"));
			sb.setCount(rs.getInt("count"));
			sb.setSalesTime(newTime);
			sb.setTime(time);
			list.add(sb);
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
	
}
	
}
