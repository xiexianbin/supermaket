package com.storage.bean;

public class AlarmBean {

	private int alarmId;//流水号
	private int storageCountLimit;//库存商品数量下线
	private int marketCountLimit;//超市商品数量下线
	private int dayLimit;//距保质期天数下线
	private String remarks;//备注
	private int productId;//商品编号
	private String productName;//商品名称
	
	public int getAlarmId() {
		return alarmId;
	}
	public void setAlarmId(int alarmId) {
		this.alarmId = alarmId;
	}
	public int getStorageCountLimit() {
		return storageCountLimit;
	}
	public void setStorageCountLimit(int storageCountLimit) {
		this.storageCountLimit = storageCountLimit;
	}
	public int getMarketCountLimit() {
		return marketCountLimit;
	}
	public void setMarketCountLimit(int marketCountLimit) {
		this.marketCountLimit = marketCountLimit;
	}
	public int getDayLimit() {
		return dayLimit;
	}
	public void setDayLimit(int dayLimit) {
		this.dayLimit = dayLimit;
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
	
	
	
}
