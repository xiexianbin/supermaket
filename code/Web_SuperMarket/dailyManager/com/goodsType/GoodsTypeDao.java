package com.goodsType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.connection.basic.ConnectionAware;

public class GoodsTypeDao extends ConnectionAware{
	
	
	
	
	public ArrayList<GoodsTypeBean> getGoodsTypeList(){
		
		ArrayList<GoodsTypeBean> list=new ArrayList<GoodsTypeBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from productType_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GoodsTypeBean gtb=new GoodsTypeBean();
				gtb.setProductTypeId(rs.getInt("productTypeId"));
				gtb.setProductTypeName(rs.getString("productTypeName"));
				gtb.setRemarks(rs.getString("remarks"));
				
				list.add(gtb);
			}
			
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public int insertGoodsType(GoodsTypeBean gtb){
		
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into productType_tab(productTypeName,remarks)values(?,?)");
			ps.setString(1, gtb.getProductTypeName());
			ps.setString(2, gtb.getRemarks());
			
			row=ps.executeUpdate();
		
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
		
	}
	
	
	
	public int deleteGoodsType(int id){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("delete from productType_tab where productTypeId=?");
			ps.setInt(1, id);
			row=ps.executeUpdate();
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
		
	}
	
	
	public GoodsTypeBean findGoodsType(int id){
		GoodsTypeBean gtb=new GoodsTypeBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from productType_tab where productTypeId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){

				gtb.setProductTypeId(id);
				gtb.setProductTypeName(rs.getString("productTypeName"));
				gtb.setRemarks(rs.getString("remarks"));
				
			}
			closeConn(conn, rs, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gtb;
		
	}
	
	
	public int updateGoodsType(GoodsTypeBean gtb){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("update productType_tab set productTypeName=?,remarks=? where productTypeId=?");
			
			
//			private int productTypeId;
//			private String productTypeName;
//			private String remarks;
			
			ps.setString(1, gtb.getProductTypeName());
			ps.setString(2, gtb.getRemarks());
			ps.setInt(3, gtb.getProductTypeId());
			row=ps.executeUpdate();
			
			closeConn(conn, ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	

}
