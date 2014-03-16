package com.sales.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.goods.ProductBean;
import com.mvc.connection.basic.ConnectionAware;
import com.sales.bean.SalesBean;

public class SalesDao extends ConnectionAware{

	
	
	
	//输入条形码，获取商品信息
	public ProductBean selectOneProduct(String barcode){
		ProductBean product=new ProductBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from product_tab where barCode=?");
			ps.setString(1, barcode);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next()){
		    	product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductTypeId(rs.getInt("productTypeId"));
				product.setProductNorms(rs.getString("productNorms"));
				product.setProductPrice(rs.getFloat("productPrice"));
				product.setProducer(rs.getString("producer"));
//				product.setSupplierId(rs.getInt("supplierId"));
				product.setBarCode(rs.getString("barCode"));
				product.setRemarks(rs.getString("remarks"));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
		
	}
	
	
	
	public  ArrayList<SalesBean> getSalesList(){
		
		ArrayList<SalesBean> list=new ArrayList<SalesBean>();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from sales_tab order by salesId desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SalesBean sb=new SalesBean();
				sb.setSalesId(rs.getInt("salesId"));
				sb.setProductId(rs.getInt("productId"));
				sb.setProductPrice(rs.getFloat("productPrice"));
				sb.setCount(rs.getInt("count"));
				sb.setEmployeeId(rs.getInt("employeeId"));
				sb.setSalesTime(rs.getString("salesTime"));
				sb.setSalesWaterNo(rs.getString("salesWaterNo"));
				sb.setVipId(rs.getInt("vipId"));
				sb.setPayType(rs.getString("payType"));
				sb.setRemarks(rs.getString("remarks"));
				
				list.add(sb);
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
//	private int salesId;//主键
//	private int purchId;//采购流水号
//	private float productPrice;//商品售价
//	private int count;//顾客购买的数量
//	private int employeeId;//收银员的员工编号
//	private String salesTime;//时间
//	private String salesWaterNo;//交易流水号（收银员工编号+交易时间）
//	private int vipId;//会员Id
//	private String payType;//付款方式(现金或刷卡或者网银)
//	private String remarks;//备注
	public int updateVip积分(SalesBean sb){
		
		
		return 0;
		
		
		
		
	}
	
	
	
	public int insertSales(SalesBean sb){
		
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into sales_tab(productId,productPrice,count,employeeId,salesTime,salesWaterNo,vipId,payType,remarks)values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, sb.getProductId());
			ps.setFloat(2, sb.getProductPrice());
			ps.setInt(3, sb.getCount());
			ps.setInt(4, sb.getEmployeeId());
			ps.setString(5, sb.getSalesTime());
			ps.setString(6, sb.getSalesWaterNo());
			ps.setInt(7, sb.getVipId());
			ps.setString(8, sb.getPayType());
			ps.setString(9, sb.getRemarks());
			
			row=ps.executeUpdate();
		
			//closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
		
	}
	
	
	public int deleteUser(int id){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("delete from sales_tab where salesId=?");
			ps.setInt(1, id);
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
		
	}
	
	
	public SalesBean findSalesData(int id){
		SalesBean sb=new SalesBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from sales_tab where salesId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				
				
				sb.setSalesId(id);
				sb.setProductPrice(rs.getFloat("productPrice"));
				sb.setCount(rs.getInt("count"));
				sb.setEmployeeId(rs.getInt("employeeId"));
				sb.setSalesTime(rs.getString("salesTime"));
				sb.setSalesWaterNo(rs.getString("salesWaterNo"));
				sb.setVipId(rs.getInt("vipId"));
				sb.setPayType(rs.getString("payType"));
				sb.setRemarks(rs.getString("remarks"));
				
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb;
		
	}
	
	public int updateUser(SalesBean sb){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("update sales_tab set purchId=?,productPrice=?,count=?,employeeId=?,salesTime=?,salesWaterNo=?,vipId=?,payType=?,remarks=? where salesId=?");
			ps.setFloat(1, sb.getProductPrice());
			ps.setInt(2, sb.getCount());
			ps.setInt(3, sb.getEmployeeId());
			ps.setString(4, sb.getSalesTime());
			ps.setString(5, sb.getSalesWaterNo());
			ps.setInt(6, sb.getVipId());
			ps.setString(7, sb.getPayType());
			ps.setString(8, sb.getRemarks());
			ps.setInt(9, sb.getSalesId());
			row=ps.executeUpdate();
			
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}



	public int getJifen(int vipId) {
		
		PreparedStatement ps;
		int jifen=0;
		try {
			ps = conn.prepareStatement("select *  from vip_tab where vipId=?");
			ps.setInt(1, vipId);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				jifen=rs.getInt("vipScore");
			}
//			closeConn(conn, rs, ps);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return jifen;
	}



	public int upJifen(int vipId, int f) {
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement("update vip_tab set vipScore=? where vipId=?");
			ps.setInt(1, f);
			ps.setInt(2, vipId);
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	
	
	
}
