package com.afterSale.bean;

public class AfterSale {
	
	private int afterSaleId;//退货编号
	private int purchId;//商品号
	private String productName;//商品名称
	private float money;//价格
	private int employeeId;//操作员
	private String date;//时间
	private String reason;//原因
	private String remarks;//备注
	public int getAfterSaleId() {
		return afterSaleId;
	}
	public void setAfterSaleId(int afterSaleId) {
		this.afterSaleId = afterSaleId;
	}
	public int getPurchId() {
		return purchId;
	}
	public void setPurchId(int purchId) {
		this.purchId = purchId;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
