<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link rel="stylesheet" rev="stylesheet" href="../css/style.css"
	type="text/css" media="all" />

<script type="text/javascript">

	function findEmployee(){
		var mess = document.getElementById("id_mess").value;
		window.location.replace("findEmployee.action?mess="+mess);
	}
	function changeStates(){
		var val="";
		var states = document.getElementsByName("states");
		for(var i=0;i<states.length;i++){
			if(states[i].checked){
				if(val!="")
					val+=",";
				val+=states[i].value;
				
			}
		}
			
		document.getElementById("id_state").value=val;
		
	}

</script>

<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>
</head>

<body class="ContentBody">
	<form action="updateState.action" method="post" name="vip">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">权限管理</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width: 100%">
							<tr>
								<td width="100%">
									<fieldset style="height: 100%;">
										<legend> 权限管理 </legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width: 100%">
											<tr>
												<td>&nbsp;</td>
												<td align="right">按编号搜索:<input type="text" id="id_mess"
													name="mess" value="${employeeData.employeeId}" />&nbsp;</td>
												<td><input type="button" value="搜索"
													onclick="findEmployee()" />
												</td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td nowrap="nowrap" align="right" width="15%">员工编号:</td>
												<td width="35%"><input name='employeeId' type="text"
													class="text" style="width: 154px" readonly="readonly"
													value="${employeeData.employeeId}" />
												</td>
												<td nowrap="nowrap" align="right" width="15%">员工姓名:</td>
												<td width="35%"><input name='employeeName' type="text"
													class="text" style="width: 154px" readonly="readonly"
													value="${employeeData.employeeName}" />
												</td>
											</tr>
											<tr>
												<td nowrap="nowrap" align="right" width="15%">性别:</td>
												<td width="35%"><input name='employeeSex' type="text"
													class="text" style="width: 154px" readonly="readonly"
													value="${employeeData.employeeSex}" />
												</td>
												<td nowrap="nowrap" align="right" width="15%">政治面貌:</td>
												<td width="35%"><input name='empPoliState' type="text"
													class="text" style="width: 154px" readonly="readonly"
													value="${employeeData.empPoliState}" />
												</td>
											</tr>
											<tr>
												<td nowrap="nowrap" align="right" width="15%">所属部门:</td>
												<td width="35%"><input name='deptName' type="text"
													class="text" style="width: 154px" readonly="readonly"
													value="${Dept}" />
												</td>
												<td nowrap="nowrap" align="right" width="15%">员工职位:</td>
												<td width="35%"><input name='employeePosition'
													type="text" class="text" style="width: 154px"
													readonly="readonly"
													value="${employeeData.employeePosition}" />
												</td>
											</tr>
											<tr>
												<td align="right">权限:</td>
												<td><input type="text" id="id_state" name="state" readonly="readonly"
													value="${State}" />
												</td>

											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>
													<input type="checkbox" name="states" onclick="changeStates()" value="101" />销售管理
													<input type="checkbox" name="states" onclick="changeStates()" value="102" />商品管理 
													<input type="checkbox" name="states" onclick="changeStates()" value="103" />日常管理
												</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>
													<input type="checkbox" name="states" onclick="changeStates()" value="104" />财务管理
													<input type="checkbox" name="states" onclick="changeStates()" value="105" />售后管理
													<input type="checkbox" name="states" onclick="changeStates()" value="106" />进货管理
												</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>
													<input type="checkbox" name="states" onclick="changeStates()" value="107" />库存管理
													<input type="checkbox" name="states" onclick="changeStates()" value="108" />系统设置
												</td>
											</tr>
										</table>
										<br />
									</fieldset></td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td colspan="2" align="center" height="50px"><input
						type="submit" name="Submit" value="提交" class="button" /> <input
						type="button" name="Submit2" value="返回" class="button"
						onclick="window.history.go(-1);" /></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>

