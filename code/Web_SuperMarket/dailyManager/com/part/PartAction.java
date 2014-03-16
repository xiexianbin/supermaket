package com.part;

import java.util.List;

import com.employee.EmployeeBean;
import com.mvc.http.aware.HttpAware;

public class PartAction extends HttpAware{
	/**
	 * 列出所有员工信息
	 * @return
	 */
	public String listPart(){
		PartDao pd = new PartDao();
		List<PartBean> PartList=pd.selectAllPartInfo();
		if(PartList!=null){
			request.setAttribute("PartList", PartList);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	/**
	 * 添加编辑员工
	 * @return
	 */
	public String listEmployee(){
		PartDao pd = new PartDao();
		List<String> employeeList = pd.selectAllemployee();
		int ans = pd.selectMaxDeptId();
		if(employeeList!=null && ans!=-1){
			request.setAttribute("EmployList", employeeList);
			request.setAttribute("deptId", (ans+1));
			return SUCCESS;	
		}else{
			return ERROR;
		}
	}
	/**
	 * 添加员工
	 * @return
	 */
	public String addNewPart(){
		String deptName = request.getParameter("deptName");
		String employeeId = request.getParameter("employeeId");
		String ID = employeeId.split("-")[0];
		String deptTel = request.getParameter("deptTel");
		String deptAddress = request.getParameter("deptAddress");
		String remarks = request.getParameter("remarks");
		PartBean pb = new PartBean();
		pb.setDeptName(deptName);
		pb.setEmployeeId(Integer.parseInt(ID));
		pb.setDeptTel(deptTel);
		pb.setDeptAddress(deptAddress);
		pb.setRemarks(remarks);
		PartDao pd = new PartDao();		
		if(pd.insertDept(pb)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	/**
	 * 编辑员工
	 * @return
	 */
	public String editPart(){
		String deptId = request.getParameter("deptId");
		PartDao pd = new PartDao();
		List<String> employeeList = pd.selectAllemployee();
		
		PartBean pb = pd.selectOnePartInfo(Integer.parseInt(deptId));	
		String Name =String.valueOf(pb.getEmployeeId())+"-"+pd.selectEmployeeName(pb.getEmployeeId());
		pd.closeConnection();
		if(pb!=null && employeeList!=null){
			request.setAttribute("Name", Name);
			request.setAttribute("EmployList", employeeList);
			request.setAttribute("Part", pb);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	/**
	 * 更新员工
	 * @return
	 */
	public String updatePart(){
		PartBean pb = new PartBean();
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String employeeId = request.getParameter("employeeId");
		String ID = employeeId.split("-")[0];
		String deptTel = request.getParameter("deptTel");
		String deptAddress = request.getParameter("deptAddress");
		String remarks = request.getParameter("remarks");
		pb.setDeptId(Integer.parseInt(deptId));
		pb.setDeptName(deptName);
		pb.setEmployeeId(Integer.parseInt(ID));
		pb.setDeptTel(deptTel);
		pb.setDeptAddress(deptAddress);
		pb.setRemarks(remarks);
		PartDao pd = new PartDao();
		if(pd.updatePart(pb)){
			return SUCCESS;
		}else{
			return ERROR;
		}		
	}
	public String onePartList(){
		String deptId=request.getParameter("deptId");
		PartDao pd = new PartDao();
		String dept = pd.selectDeptName(Integer.parseInt(deptId));
		List<EmployeeBean> list = pd.selectOnePartList(Integer.parseInt(deptId));
		if(list!=null && dept!=null){
			request.setAttribute("Dept", dept);
			request.setAttribute("employeeList", list);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

}
