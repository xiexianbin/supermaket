package com.purch.bean;

public class PurchBean {
	private int purchId;
	private int productId;
	private String productName;
	private String companyName;
	private String employeeName;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	private float inPrice;
	private int purchCount;
	private String purchTime;
	private String productTime;
	private String expireTime;
	private int employeeId;
	private int companyId;
	private String remarks;
	public int getPurchId() {
		return purchId;
	}
	public void setPurchId(int purchId) {
		this.purchId = purchId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getInPrice() {
		return inPrice;
	}
	public void setInPrice(float inPrice) {
		this.inPrice = inPrice;
	}
	public int getPurchCount() {
		return purchCount;
	}
	public void setPurchCount(int purchCount) {
		this.purchCount = purchCount;
	}
	public String getPurchTime() {
		return purchTime;
	}
	public void setPurchTime(String purchTime) {
		this.purchTime = purchTime;
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
