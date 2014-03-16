package com.sales.bean;

import java.io.Serializable;

public class OnSaleProductBean implements Serializable{

	
	private int productId;//商品Id--商品表
	private String barCode;//条形码
	
	private String productName;//名字
	private float productPrice;
	private String producer;//名字
	
	private int count;//顾客购买的商品数量--页面获取
	private float soloprice;//单笔金额
	
	private int vipId;//会员Id，为计算VIP卡积分使用--会员表
	private int employeeId;//员工ID--页面获取-员工表
	private String employeeName;//
	
	private String payType;//付款方式
	
	private String salesTime;//交易时间，页面获取
	private String salesWaterNo;
	private String reMarks;
	
	
	
	
	
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
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
	public float getSoloprice() {
		return soloprice;
	}
	public void setSoloprice(float soloprice) {
		this.soloprice = soloprice;
	}
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
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
	public String getReMarks() {
		return reMarks;
	}
	public void setReMarks(String reMarks) {
		this.reMarks = reMarks;
	}
	
	
	
	
	
	
}
