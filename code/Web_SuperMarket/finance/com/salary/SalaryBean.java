package com.salary;

public class SalaryBean {
	
	private int salaryId;
	private int employeeId;
	private String employeeName;
	private String deptName;
	private float salary;
	private String salaryTime;
	private String remarks;
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
	public int getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getSalaryTime() {
		return salaryTime;
	}
	public void setSalaryTime(String salaryTime) {
		this.salaryTime = salaryTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
