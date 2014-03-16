package com.storage.bean;

public class StoreBean {

	private int storeId;//库存编号
	private int storageId;//仓库编号 
	private int purchId;//采购流水号
	private int remainNum;//剩余数量
	private String remarks;//备注
	private int productId;//商品编号
	private String productName;//商品名称
	//private String storageType;//仓库类型
	private String productTime;//生产日期
	private String expireTime;//过期时间
	
	public int getStorageId() {
		return storageId;
	}
	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public int getPurchId() {
		return purchId;
	}
	public void setPurchId(int purchId) {
		this.purchId = purchId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getRemainNum() {
		return remainNum;
	}
	public void setRemainNum(int remainNum) {
		this.remainNum = remainNum;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
//	public String getStorageType() {
//		return storageType;
//	}
//	public void setStorageType(String storageType) {
//		this.storageType = storageType;
//	}
	public String getProductTime() {
		return productTime;
	}
	public void setProductTime(String productTime) {
		this.productTime = productTime;
	}
	public String getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	
	
}
