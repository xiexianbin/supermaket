package com.storage.bean;

public class DateAlarmBean {

	private int storageId;//仓库编号
	private int productId;//商品编号
	private String productName;//商品名称
	private int purchId;//采购流水号
	private String productTime;//生产日期
	private String expireTime;//过期时间
	private int safeDay;//距保质期天数
	private int dayLimit;//距保质期天数下线
	public int getStorageId() {
		return storageId;
	}
	public void setStorageId(int storageId) {
		this.storageId = storageId;
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
	public int getPurchId() {
		return purchId;
	}
	public void setPurchId(int purchId) {
		this.purchId = purchId;
	}
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
	public int getSafeDay() {
		return safeDay;
	}
	public void setSafeDay(int safeDay) {
		this.safeDay = safeDay;
	}
	public int getDayLimit() {
		return dayLimit;
	}
	public void setDayLimit(int dayLimit) {
		this.dayLimit = dayLimit;
	}
	
	
}
