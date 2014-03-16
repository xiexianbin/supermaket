package com.employee;

public class EmployeeBean {
	
//	员工表（employee_tab)					
//	字段	字段类型	长度	是否为空	是否主键	说明
//	employeeId	int		否	是	员工编号
//	employeeName	varchar	20			员工姓名
//	employeeBirthday	varchar				员工生日
//	employeeSex	varchar	10			性别
//	employeeIdNum	varchar	18			身份证
//	empPoliState	varchar	20	否		政治面貌
//	employeePicture	image				员工头像
//	employeeTel	varchar	20			电话
//	employeeQq	varchar	20			QQ
//	employeeEmail	varchar	50			邮箱
//	employeeSchool	varchar	50			员工学历
//	employeeAddress	varchar	100			员工地址
//	employeePosition	varchar	20			员工职位
//	basicWage	float				基本工资
//	deptId	int				所属部门编号
//	entryTime	varchar	30			入职时间
//	leaveTime	varchar	30			离职时间
//	employeeState	varchar	10			是否在职
//	remarks	text				备注

	private int employeeId;//员工编号
	private String employeeName;//员工姓名
	private String employeeBirthday;//员工年龄
	private String employeeSex;//性别
	private String employeeIdNum;//身份证号
	private String empPoliState;//政治面貌
	private String employeePicture;//员工头像
	private String employeeTel;//电话
	private String employeeQq;//QQ
	private String employeeEmail;//邮箱
	private String employeeSchool;//员工学历
	private String employeeAddress;//员工地址
	private String employeePosition;//员工职位
	private float basicWage;//基本工资
	private int deptId;//所属部门编号
	private String entryTime;//入职时间
	private String leaveTime;//离职时间
	private String employeeState;//是否在职
	private String remarks;//备注
	
	
	

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeBirthday() {
		return employeeBirthday;
	}
	public void setEmployeeBirthday(String employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public float getBasicWage() {
		return basicWage;
	}
	public void setBasicWage(float basicWage) {
		this.basicWage = basicWage;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	public String getEmployeeIdNum() {
		return employeeIdNum;
	}
	public void setEmployeeIdNum(String employeeIdNum) {
		this.employeeIdNum = employeeIdNum;
	}
	public String getEmpPoliState() {
		return empPoliState;
	}
	public void setEmpPoliState(String empPoliState) {
		this.empPoliState = empPoliState;
	}
	public String getEmployeePicture() {
		return employeePicture;
	}
	public void setEmployeePicture(String employeePicture) {
		this.employeePicture = employeePicture;
	}
	public String getEmployeeTel() {
		return employeeTel;
	}
	public void setEmployeeTel(String employeeTel) {
		this.employeeTel = employeeTel;
	}
	public String getEmployeeQq() {
		return employeeQq;
	}
	public void setEmployeeQq(String employeeQq) {
		this.employeeQq = employeeQq;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeSchool() {
		return employeeSchool;
	}
	public void setEmployeeSchool(String employeeSchool) {
		this.employeeSchool = employeeSchool;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getEmployeeState() {
		return employeeState;
	}
	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
