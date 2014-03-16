package com.goodsbean;

public class DownGoods {

	private int serialId;
	private int purchId;
	private int productId;
	private String productName;
	private int employeeId;
	private int employeeName;
	private int shelfId;
	private int downCount;
	private String downTime;
	private String remarks;
	
	public int getShelfId() {
		return shelfId;
	}
	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
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
	public int getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(int employeeName) {
		this.employeeName = employeeName;
	}

	public int getSerialId() {
		return serialId;
	}
	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}
	public int getPurchId() {
		return purchId;
	}
	public void setPurchId(int purchId) {
		this.purchId = purchId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getDownCount() {
		return downCount;
	}
	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}
	public String getDownTime() {
		return downTime;
	}
	public void setDownTime(String downTime) {
		this.downTime = downTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
