package com.sales.bean;

public class SalesBean {

	//销售表对应的bean
	
	
	private int salesId;//主键
	private int productId;//商品Id--商品表
	private float productPrice;//商品售价
	private int count;//顾客购买的数量
	private int employeeId;//收银员的员工编号
	private String salesTime;//时间
	private String salesWaterNo;//交易流水号（收银员工编号+交易时间）
	private int vipId;//会员Id
	private String payType;//付款方式(现金或刷卡或者网银)
	private String remarks;//备注
	
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getSalesTime() {
		return salesTime;
	}
	public void setSalesTime(String salesTime) {
		this.salesTime = salesTime;
	}
	public String getSalesWaterNo() {
		return salesWaterNo;
	}
	public void setSalesWaterNo(String salesWaterNo) {
		this.salesWaterNo = salesWaterNo;
	}
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
}
