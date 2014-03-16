package com.goods;

public class ProductBean {
	//商品表实体bean
	private int productId;  //商品编号
	private String productName;//商品名称
	private int productTypeId;//商品类型编号
	private String productTypeName;//商品类型名称
	private String productNorms;//商品规格
	private float productPrice;//商品售价
	private String producer;//生产商
	
	private String barCode;//条形码
	private String remarks;//备注
	
	
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductNorms() {
		return productNorms;
	}
	public void setProductNorms(String productNorms) {
		this.productNorms = productNorms;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	

}