package com.gift;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.connection.basic.ConnectionAware;

public class GiftDao extends ConnectionAware{
	//查询所有礼物-->积分的关系
	public List<GiftBean> selectAll(){
		List<GiftBean> list=new ArrayList<GiftBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select giftId,gift_tab.productId,productName,score,productPrice,productTypeName from productType_tab inner join(gift_tab inner join product_tab on gift_tab.productId=product_tab.productId) on product_tab.productTypeId=productType_tab.productTypeId");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GiftBean gift=new GiftBean();
				gift.setGiftId(rs.getInt("giftId"));
				gift.setProductId(rs.getInt("productId"));
				gift.setScore(rs.getInt("score"));
				gift.setProductName(rs.getString("productName"));
				gift.setProductTypeName(rs.getString("productTypeName"));
				gift.setProductPrice(rs.getFloat("productPrice"));
				list.add(gift);
			}conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	public int selectMax(){
		int a=0;
		try {
			PreparedStatement ps=conn.prepareStatement("select max(giftId) as ID from gift_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				a=rs.getInt("ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	//查询礼品编号
	public List<GiftBean> productId(){
		List<GiftBean> productIdList=new ArrayList<GiftBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select product_tab.productId from product_tab where product_tab.productId not in(select gift_tab.productId from gift_tab)");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GiftBean productId=new GiftBean();
				productId.setProductId(rs.getInt("productId"));
				productIdList.add(productId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productIdList;
		
	}
	
	
	//按礼品编号
	public List selectGift(){
		List giftList=new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select giftId from gift_tab");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				giftList.add(rs.getInt("giftId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giftList;
	}
	
	
	public GiftBean selectProduct(int id){
		
		GiftBean product = new GiftBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select productName,productPrice,productTypeName from productType_tab inner join product_tab on productType_tab.productTypeId=product_tab.productTypeId where productId="+id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				product.setProductId(id);
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getInt("productPrice"));
				product.setProductTypeName(rs.getString("productTypeName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	
	}
	
	
//	
//	public boolean selectProduct1(int id){
//		
//		try {
//			PreparedStatement ps=conn.prepareStatement("select productName,productPrice,productTypeName from productType_tab inner join product_tab on productType_tab.productTypeId=product_tab.productTypeId where productId="+id);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()){
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	
//	}
	
	
	
	
	
	
	
	//按商品编号
	public List<GiftBean> selectProduct(){
		List<GiftBean> productList=new ArrayList<GiftBean>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select productId,productName,productPrice,productTypeName from productType_tab inner join product_tab on productType_tab.productTypeId=product_tab.productTypeId");
			ResultSet rs=ps.executeQuery();
//			System.out.println(rs.next());
			while(rs.next()){
				GiftBean product = new GiftBean();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductTypeName(rs.getString("productTypeName"));
				product.setProductPrice(rs.getFloat("productPrice"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	
	}
	
	//添加礼品信息
	public int insertOne(GiftBean gift){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into gift_tab(giftId,productId,score,remarks) values(?,?,?,?)");
			ps.setInt(1, gift.getGiftId());
			ps.setInt(2, gift.getProductId());
			ps.setInt(3, gift.getScore());
			ps.setString(4, gift.getRemarks());
			
			row=ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	//查询出一个礼品对应的信息
	public GiftBean selectOne(int id){
		GiftBean gift = new GiftBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select gift_tab.productId,productName,score,productPrice,productTypeName,gift_tab.remarks from productType_tab inner join(gift_tab inner join product_tab on gift_tab.productId=product_tab.productId) on product_tab.productTypeId=productType_tab.productTypeId where giftId="+id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				gift.setGiftId(id);
				gift.setProductId(rs.getInt("productId"));
				gift.setScore(rs.getInt("score"));
				gift.setProductName(rs.getString("productName"));
				gift.setProductTypeName(rs.getString("productTypeName"));
				gift.setProductPrice(rs.getFloat("productPrice"));
				gift.setRemarks(rs.getString("remarks"));
			}conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gift;
	}
	
	
	public int updateOne(GiftBean gift){
		int row=0;
		try {
			
			PreparedStatement ps=conn.prepareStatement("update gift_tab set productId=?,score=?,remarks=? where giftId=?");
			ps.setInt(1, gift.getProductId());
			ps.setInt(2, gift.getScore());
			ps.setString(3, gift.getRemarks());
			ps.setInt(4, gift.getGiftId());
			
			row=ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	
	
	
	//删除所选的礼品信息
	
	public void deleteOne(int id){
		try {
			PreparedStatement ps=conn.prepareStatement("delete from gift_tab where giftId="+id);
			ps.executeUpdate();
	//		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
