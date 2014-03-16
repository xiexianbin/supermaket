package com.goods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goodsType.GoodsTypeBean;
import com.mvc.connection.basic.ConnectionAware;

public class ProductDao extends ConnectionAware{
	
	
	//商品列表productList
	public List<ProductBean> productList(){
		List<ProductBean> productList=new ArrayList<ProductBean>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select productId,productName,product_tab.productTypeId,productType_tab.productTypeName,productNorms,productPrice,producer,barCode,product_tab.remarks from product_tab inner join productType_tab on product_tab.productTypeId = productType_tab.productTypeId");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ProductBean product=new ProductBean();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductTypeId(rs.getInt("productTypeId"));
				product.setProductTypeName(rs.getString("productTypeName"));
				product.setProductNorms(rs.getString("productNorms"));
				product.setProductPrice(rs.getFloat("productPrice"));
				product.setProducer(rs.getString("producer"));
				product.setBarCode(rs.getString("barCode"));
				product.setRemarks(rs.getString("remarks"));
				productList.add(product);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	
	//添加新商品信息
	public int insertProduct(ProductBean product){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("insert into product_tab (productName,productTypeId,productNorms,productPrice,producer,barCode,remarks) values (?,?,?,?,?,?,?)");
		    ps.setString(1, product.getProductName());
		    ps.setInt(2, product.getProductTypeId());
		    ps.setString(3, product.getProductNorms());
		    ps.setFloat(4, product.getProductPrice());
		    ps.setString(5, product.getProducer());
		    ps.setString(6, product.getBarCode());
		    ps.setString(7, product.getRemarks());
		    row=ps.executeUpdate();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	//删除商品信息
	public int deleteProduct(int id){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("delete from product_tab where productId=?");
		    ps.setInt(1, id);
		    row=ps.executeUpdate();
		  		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return row;		
	}
	
	
	
	//更新商品信息
	public int updateProduct(ProductBean product){
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement("update product_tab set productName=?,productTypeId=?,productNorms=?,productPrice=?,producer=?,barCode=?,remarks=? where productId=?");
			ps.setString(1, product.getProductName());
		    ps.setInt(2, product.getProductTypeId());
		    ps.setString(3, product.getProductNorms());
		    ps.setFloat(4, product.getProductPrice());
		    ps.setString(5, product.getProducer());  
		    ps.setString(6, product.getBarCode());
		    ps.setString(7, product.getRemarks());
		    ps.setInt(8, product.getProductId());
		    row=ps.executeUpdate();
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;		
	}
	
	//通过商品编号查询该商品信息
	public ProductBean selectOneProduct(int id){
		ProductBean product=new ProductBean();
		try {
			PreparedStatement ps=conn.prepareStatement("select productId,productName,product_tab.productTypeId,productType_tab.productTypeName,productNorms,productPrice,producer,barCode,product_tab.remarks from product_tab inner join productType_tab on product_tab.productTypeId = productType_tab.productTypeId where product_tab.productId=?");
		    ps.setInt(1, id);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next()){
		    	product.setProductId(id);
				product.setProductName(rs.getString("productName"));
//				product.setProductTypeId(rs.getInt("productTypeId"));
				product.setProductTypeName(rs.getInt("productTypeId")+rs.getString("productTypeName"));
				product.setProductNorms(rs.getString("productNorms"));
				product.setProductPrice(rs.getFloat("productPrice"));
				product.setProducer(rs.getString("producer"));
				product.setBarCode(rs.getString("barCode"));
				product.setRemarks(rs.getString("remarks"));
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
		
	}

	public List<GoodsTypeBean> getProductType(){
		List<GoodsTypeBean> productTypeList=new ArrayList<GoodsTypeBean>();
		try {
			PreparedStatement ps=conn.prepareStatement("select productTypeId,productTypeName from productType_tab");
		    ResultSet rs=ps.executeQuery();
		    while(rs.next()){
		    	GoodsTypeBean productType=new GoodsTypeBean();
		    	productType.setProductTypeName(rs.getInt("productTypeId")+rs.getString("productTypeName"));
		    	productTypeList.add(productType);
		    }
		    conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productTypeList;
		
	}
}
