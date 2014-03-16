package com.storage.bean;

public class NumAlarmBean {
	private int productId;//商品编号
	private String productName;//商品名称
	private int allNum;//总剩余数量
	private int storageCountLimit;//仓库数量下线
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
	public int getAllNum() {
		return allNum;
	}
	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}
	public int getStorageCountLimit() {
		return storageCountLimit;
	}
	public void setStorageCountLimit(int storageCountLimit) {
		this.storageCountLimit = storageCountLimit;
	}
	
	

}
