package com.storage;

public class StorageBean {
	private int storageId;/*仓库编号*/
	private String storageAddress;/*仓库地址*/
	private float storageArea;/*仓库面积*/
	private String storageType;/*仓库类型*/
	private int employeeId;/*负责人编号*/
	private String employeeName;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	private String remarks;/*备注*/
	public int getStorageId() {
		return storageId;
	}
	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public String getStorageAddress() {
		return storageAddress;
	}
	public void setStorageAddress(String storageAddress) {
		this.storageAddress = storageAddress;
	}
	public float getStorageArea() {
		return storageArea;
	}
	public void setStorageArea(float storageArea) {
		this.storageArea = storageArea;
	}
	public String getStorageType() {
		return storageType;
	}
	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

}
