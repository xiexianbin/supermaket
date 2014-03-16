package com.returnProductSale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
import com.turnover.TurnoverBean;

public class ReturnDao extends ConnectionAware{

	
	
	public List<ReturnBean> selectSalesToday(String id, String time) {
		List<ReturnBean> list=new ArrayList<ReturnBean>();
		PreparedStatement ps=null;
		String newTime=time.replaceFirst("-","年");
		String FinalTime=newTime.replaceFirst("-", "月");
		String sql="select count(purchId) as SaleNumber from afterSale_tab where date like '"+FinalTime+"%'";
		
			try {
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					ReturnBean sb=new ReturnBean();
					sb.setReturnpurchNum(rs.getInt("SaleNumber"));
					float money = selectMoney(time);
					sb.setReturnMoney(money);
					sb.setReturnTime(FinalTime);
					sb.setTime(FinalTime);
					list.add(sb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return list;
	}

	public List<ReturnBean> selectSalesYear(String id, String time) {
		List<ReturnBean> list=new ArrayList<ReturnBean>();
		for(int i = 1;i<=12;i++){
			PreparedStatement ps = null;
			String newTime = null;
			String FinalTime = null;
			if(i<10){
				newTime =time+"年0"+String.valueOf(i)+"月";
				FinalTime = time+"-0"+String.valueOf(i)+"-";
			}else{
				newTime =time+"年"+String.valueOf(i)+"月";
				FinalTime = time+"-"+String.valueOf(i)+"-";
			}
		String sql="select count(purchId) as SaleNumber from afterSale_tab where date like '"+FinalTime+"%'";
		
			try {
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					ReturnBean sb=new ReturnBean();
					sb.setReturnpurchNum(rs.getInt("SaleNumber"));
					float money = selectMoney(FinalTime);
					sb.setReturnMoney(money);
					sb.setReturnTime(newTime);
					sb.setTime(FinalTime);
					list.add(sb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<ReturnBean> selectSalesMonth(String id, String time) {
		List<ReturnBean> list=new ArrayList<ReturnBean>();
		int year = Integer.parseInt(time.split("-")[0]);
		int month = Integer.parseInt(time.split("-")[1]);
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
			String newTime = time.replace("-", "年");
			String FinalTime = time.replace("-", "-");
			if(i<10){
				newTime +="月0"+String.valueOf(i)+"日";
				FinalTime +="-0"+String.valueOf(i);
			}else{
				newTime +="月"+String.valueOf(i)+"日";
				FinalTime +="-"+String.valueOf(i);
			}
			String sql="select count(purchId) as SaleNumber from afterSale_tab where date like '"+FinalTime+"%'";
			
			try {
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					ReturnBean sb=new ReturnBean();
					sb.setReturnpurchNum(rs.getInt("SaleNumber"));
					float money = selectMoney(FinalTime);
					sb.setReturnMoney(money);
					sb.setReturnTime(newTime);
					sb.setTime(FinalTime);
					list.add(sb);
				}
				} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public float selectMoney(String time){
		PreparedStatement ps = null;
		String sql = "select sum(money) as Money from afterSale_tab where date like '"+time+"%'";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				try{
					float money = Float.parseFloat(rs.getString("Money"));
					return money;
				}catch(Exception e){
					return 0;
				}
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
