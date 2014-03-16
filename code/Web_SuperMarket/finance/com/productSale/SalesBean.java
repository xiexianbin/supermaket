package com.productSale;

public class SalesBean {

	private int salesId;//主键
	private int productId;//商品Id--商品表
	private int count;//顾客购买的数量
	private String salesTime;//时间
	private String salesWaterNo;//交易流水号（收银员工编号+交易时间）
	private String remarks;//备注
	private String Time;
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public int getSalesId() {
		return salesId;
	}
	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
