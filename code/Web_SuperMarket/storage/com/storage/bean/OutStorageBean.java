package com.storage.bean;

public class OutStorageBean {
	
	private int outStorageId;//出库流水号
	private int storageId;//仓库编号 
	private int purchId;//采购流水号
	private int employeeId;//负责人编号
	private int outNum;//出库数量
	private String outTime;//出库时间
	private String outDirection;//出库去向
	private String reason;//原因
	private String storageType;//仓库类型
	private String employeeName;//负责人名字
	private int productId;//商品编号
	private String productName;//商品名称
	
	public int getOutStorageId() {
		return outStorageId;
	}
	public void setOutStorageId(int outStorageId) {
		this.outStorageId = outStorageId;
	}
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
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getOutNum() {
		return outNum;
	}
	public void setOutNum(int outNum) {
		this.outNum = outNum;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getOutDirection() {
		return outDirection;
	}
	public void setOutDirection(String outDirection) {
		this.outDirection = outDirection;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
