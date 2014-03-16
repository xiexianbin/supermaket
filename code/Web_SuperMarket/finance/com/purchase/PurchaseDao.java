package com.purchase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class PurchaseDao extends ConnectionAware{
	
	public List<Purchase> selectToday(String time){
		List<Purchase> purchaseList=new ArrayList<Purchase>();
		try {
			PreparedStatement ps=conn.prepareStatement("select sum(purchCount) as SaleNumber from purch_tab where purchTime=?");
			ps.setString(1, time);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				Purchase purchase=new Purchase();
				purchase.setCount(rs.getInt("SaleNumber"));
				PurchaseDao dao = new PurchaseDao();
				float money=dao.selectMoney(time);
				purchase.setMoney(money);
				purchase.setTime(time);
				purchaseList.add(purchase);
			}closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseList;
	}
	
	public float selectMoney(String time){
		float money=0;
		try {
			PreparedStatement ps=conn.prepareStatement("select sum(inprice*purchCount) as money from purch_tab where purchTime like '"+time+"%'");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				money=rs.getFloat("money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return money;
	}
	
	
	
	public List<Purchase> selectTurnoverYear(String time){
		List<Purchase> purchaseList=new ArrayList<Purchase>();
		for(int i=1;i<=12;i++){
			String newTime = null;
			String FinalTime = null;
			if(i<10){
				newTime =time+"-0"+String.valueOf(i);
				FinalTime = time+"-0"+i;
			}else{
				newTime =time+"-"+String.valueOf(i);
				FinalTime = time+"-"+i;
			}
			try {
				PreparedStatement ps=conn.prepareStatement("select sum(purchCount) as SaleNumber from purch_tab where purchTime like '"+FinalTime+"%'");
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					Purchase purchase=new Purchase();
					purchase.setCount(rs.getInt("SaleNumber"));
					PurchaseDao dao = new PurchaseDao();
		//			System.out.println(FinalTime);
					float money=dao.selectMoney(FinalTime);
					purchase.setMoney(money);
					purchase.setTime(newTime);
					System.out.println(newTime);
					purchaseList.add(purchase);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return purchaseList;
	}
	
	public List<Purchase> selectTurnoverMonth(String time){
		List<Purchase> purchaseList=new ArrayList<Purchase>();
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
			String newTime = time;
			String FinalTime = time;
			if(i<10){
				newTime +="-0"+String.valueOf(i);
				FinalTime +="-0"+String.valueOf(i);
			}else{
				newTime +="-"+String.valueOf(i);
				FinalTime +="-"+String.valueOf(i);
			}
			String sql = "select sum(purchCount) as SaleNumber from purch_tab where purchTime like '"+FinalTime+"%'";
			try {
				ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					Purchase purchase=new Purchase();
					purchase.setCount(rs.getInt("SaleNumber"));
					PurchaseDao dao = new PurchaseDao();
					
					float money=dao.selectMoney(FinalTime);
					purchase.setMoney(money);
					purchase.setTime(newTime);
	//				System.out.println(newTime);
					purchaseList.add(purchase);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return purchaseList;
	}
	
	
	
	public List<Purchase> selectOne(String time){
		List<Purchase> purchaseList=new ArrayList<Purchase>();
		try {
			PreparedStatement ps=conn.prepareStatement("select productName,productTypeName, sum(inPrice*purchCount) as money,sum(purchCount)as count from purch_tab inner join (productType_tab inner join product_tab on productType_tab.productTypeId=product_tab.productTypeId)" +
					"on purch_tab.productId=product_tab.productId  where purchTime like ? group by productName,productTypeName");
			ps.setString(1, time);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Purchase purchase=new Purchase();
				purchase.setProductTypeName(rs.getString("ProductTypeName"));
				purchase.setProductName(rs.getString("ProductName"));
	//			System.out.println(rs.getString("ProductName"));
				purchase.setMoney(rs.getFloat("money"));
				purchase.setCount(rs.getInt("count"));
				purchaseList.add(purchase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseList;
	}
	
	
	public List<Purchase> selectOne1(String time){
		System.out.println(time);
		List<Purchase> purchaseList=new ArrayList<Purchase>();
		try {
			PreparedStatement ps=conn.prepareStatement("select productName,productTypeName, sum(inPrice*purchCount) as money,sum(purchCount)as count from purch_tab inner join (productType_tab inner join product_tab on productType_tab.productTypeId=product_tab.productTypeId)" +
					"on purch_tab.productId=product_tab.productId  where purchTime like '"+time+"%' group by productName,productTypeName");
		//	ps.setString(1, time);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			//	System.out.println(rs.next());
				Purchase purchase=new Purchase();
				purchase.setProductTypeName(rs.getString("ProductTypeName"));
				purchase.setProductName(rs.getString("ProductName"));
				purchase.setMoney(rs.getFloat("money"));
				purchase.setCount(rs.getInt("count"));
				purchaseList.add(purchase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseList;
	}
	
	
	
}

	


