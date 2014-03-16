package com.SaleRank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;
//根据商品标号和时间（年月），统计某一商品月销售量
public class SaleRankDao extends ConnectionAware{
   
	  public SaleRankBean saleAll(int proId,String ymonth){
    	 SaleRankBean bean = new SaleRankBean();
    	 try {
		PreparedStatement ps=	conn.prepareStatement("select sum(count) as coun from sales_tab where productId=? and salesTime like '"+ymonth+"%'");
			ps.setInt(1, proId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
			
				
				bean.setProId(proId);
				bean.setCount(rs.getInt("coun"));
				bean.setTime(ymonth);
				
				
				
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
     }
     /*
	  //获取数据库中的商品类别和商品类别名
	     public List<proType> allproType(){
	    	 List<proType> list = new ArrayList<proType>();
	    	try {
				PreparedStatement ps= conn.prepareStatement("select distinct productTypeId, productTypeName from productType_tab");
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					proType pro = new proType();
					pro.setProTyId(rs.getInt("productTypeId"));
					pro.setProTyName(rs.getString("productTypeName"));

					
					list.add(pro);
				}
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
	    	 
	     }*/
	     
	     
     
     /*
     public List<proType> proType(int protyId){
    	 List<proType> list = new ArrayList<proType>();
    	try {
			PreparedStatement ps= conn.prepareStatement("select productType_tab.productTypeId, productType_tab.productTypeName,product_tab.productId,product_tab.productName from productType_tab join product_tab on productType_tab.productTypeId=product_tab.productTypeId where productType_tab.productTypeId=?");
			ps.setInt(1, protyId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				proType pro = new proType();
				pro.setProTyId(protyId);
				pro.setProTyName(rs.getString("productTypeName"));
				pro.setProId(rs.getInt("productId"));
				pro.setProName(rs.getString("productName"));
				list.add(pro);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    	 
     }*/
     
     
     
     public List<proType> proall(){
    	 List<proType> list = new ArrayList<proType>();
    	try {
			PreparedStatement ps= conn.prepareStatement("select  distinct product_tab.productId, productType_tab.productTypeId, productType_tab.productTypeName,product_tab.productName from productType_tab join product_tab on productType_tab.productTypeId=product_tab.productTypeId");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				proType pro = new proType();
				pro.setProTyId(rs.getInt("productTypeId"));
				pro.setProTyName(rs.getString("productTypeName"));
				pro.setProId(rs.getInt("productId"));
				pro.setProName(rs.getString("productName"));
				list.add(pro);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
    	 
     }
     
}
