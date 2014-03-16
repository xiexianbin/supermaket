package com.inexpense;

public class InexpenseBean {

	private int inExpenId;
	private int employeeId;
	private String employeeName;
	private String deptName;
	private String inReason;
	private float money;
	private String inDate;
	private String remarks;
	private String time;
	private float count;
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public float getCount() {
		return count;
	}
	public void setCount(float count) {
		this.count = count;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getInExpenId() {
		return inExpenId;
	}
	public void setInExpenId(int inExpenId) {
		this.inExpenId = inExpenId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getInReason() {
		return inReason;
	}
	public void setInReason(String inReason) {
		this.inReason = inReason;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
