package com.gift;

public class GiftBean {
	
	private int giftId;//礼品编号
	private int productId;//商品编号
	private String productName;//商品名称
	private int score;//所需积分
	private float productPrice;//商品价格
	private String productTypeName;//商品类型
	private String remarks;//备注
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getGiftId() {
		return giftId;
	}
	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	

}
