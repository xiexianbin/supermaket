package com.storage.bean;

public class InStorageBean {

	private int instorageId;//入库流水号
	private int storageId;//仓库编号 
	private int purchId;//采购流水号
	private int employeeId;//负责人编号
	private int inNum;//入库数量
	private String inReason;//入库原因
	private String inTime;//入库时间
	private String remarks;//备注
	private String employeeName;//负责人名字
	private int productId;//商品编号
	private String productName;//商品名称
	private String storageType;//仓库类型
	
	public int getInstorageId() {
		return instorageId;
	}
	public void setInstorageId(int instorageId) {
		this.instorageId = instorageId;
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
	public int getInNum() {
		return inNum;
	}
	public void setInNum(int inNum) {
		this.inNum = inNum;
	}
	public String getInReason() {
		return inReason;
	}
	public void setInReason(String inReason) {
		this.inReason = inReason;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	
	
}
