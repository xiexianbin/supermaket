package com.purch.bean;

public class ReturnBean {
	private int returnId;
	private int purchId;
	private float returnPrice;
	private int returnCount;
	private String returnTime;
	private int employeeId;
	private String employeeName;
	private String companyName;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	private int companyId;
	private String remarks;
	public int getReturnId() {
		return returnId;
	}
	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}
	public int getPurchId() {
		return purchId;
	}
	public void setPurchId(int purchId) {
		this.purchId = purchId;
	}
	public float getReturnPrice() {
		return returnPrice;
	}
	public void setReturnPrice(float returnPrice) {
		this.returnPrice = returnPrice;
	}
	public int getReturnCount() {
		return returnCount;
	}
	public void setReturnCount(int returnCount) {
		this.returnCount = returnCount;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

}
