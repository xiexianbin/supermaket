package com.afterSale.bean;

public class GiftRecord {

	private int giftId;//礼品编号
	private int purchId;//商品号
	public String productName;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	private int giftCount;//兑换数量
	private int employeeId;//操作员
	private int vipId;//会员号
	private String gifttime;//兑换时间
	private String remarks;//备注
	public int getGiftId() {
		return giftId;
	}
	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}
	public int getPurchId() {
		return purchId;
	}
	public void setPurchId(int purchId) {
		this.purchId = purchId;
	}
	public int getGiftCount() {
		return giftCount;
	}
	public void setGiftCount(int giftCount) {
		this.giftCount = giftCount;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
	public String getGifttime() {
		return gifttime;
	}
	public void setGifttime(String gifttime) {
		this.gifttime = gifttime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
