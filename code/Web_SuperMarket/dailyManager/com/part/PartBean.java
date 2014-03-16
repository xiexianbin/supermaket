package com.part;

public class PartBean {
	
	private int deptId;//部门编号
	private String deptName;//部门名称
	private int employeeId;//部门经理编号
	private String employeeName;//部门经理的名称
	private String deptTel;//部门电话
	private String deptAddress;//部门地址
	private String remarks;//备注
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDeptTel() {
		return deptTel;
	}
	public void setDeptTel(String deptTel) {
		this.deptTel = deptTel;
	}
	public String getDeptAddress() {
		return deptAddress;
	}
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
