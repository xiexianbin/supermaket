<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link rel="stylesheet" rev="stylesheet" href="../css/style.css"
	type="text/css" media="all" />

<title>jQuery UI Datepicker - Display month &amp; year menus</title>
<link type="text/css" href="../css/ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="../js/ui.core.js"></script>
<script type="text/javascript" src="../js/ui.datepicker.js"></script>
<script type="text/javascript" src="../js/ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datepicker').datepicker({
			changeMonth: true,
			changeYear: true
		});
	});
	</script>

<script language="JavaScript" type="text/javascript">
function check()
{
 if(window.instorage.purchId.value==""){
  alert("带*为必填内容");
  window.instorage.purchId.focus();
  return false;
  }
  if(window.instorage.storageId.value==""){
  alert("带*为必填内容");
  window.instorage.storageId.focus();
  return false;
  }
  if(window.instorage.employeeId.value==""){
  alert("带*为必填内容");
  window.instorage.employeeId.focus();
  return false;
  }
   if(window.instorage.inNum.value==""){
  alert("带*为必填内容");
  window.instorage.inNum.focus();
  return false;
  }
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
	<form action="addEmployee.do" method="post" name="instorage"
		onsubmit="return check()">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">添加新员工信息</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width: 100%">

							<tr>
								<td width="100%">
									<fieldset style="height: 100%;">
										<legend> 添加新员工信息 </legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width: 100%">



											<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											</tr>
											<tr>

												<!-- 
													<td nowrap="nowrap" align="right">商品编号:</td>
													<td>
													<input class="text" name='productId' style="width: 154px" value="" />
													</td>
													
												
												<td align="right" >要添加的商品类别名称:</td>
												<td width="60%" ><input class="text" name='productTypeName'  
													 value="" /></td>
											</tr>
											-->



											<tr>

												<td nowrap="nowrap" align="right" width="15%">员工姓名:</td>
												<td width="35%"><input name='employeeName' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeName}" /></td>
													
													
													


											</tr>

											<tr>
											
												<td nowrap="nowrap" align="right" width="15%">员工生日:</td>
												<td width="35%"><input name='employeeBirthday' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeBirthday}" /></td>

												<td nowrap="nowrap" align="right" width="15%">性别:</td>
												<td width="35%"><input name='employeeSex' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeSex}" /></td>



											</tr>
											
														<tr>
											
											<!--  
												<td nowrap="nowrap" align="right">商品类别名称:</td>
												<td><input class="text" name='productTypeName'
													style="width: 154px"
													value="${goodstypeData.productTypeName}" />
												</td>
											-->
												<td nowrap="nowrap" align="right" width="15%">身份证:</td>
												<td width="35%"><input name='employeeIdNum' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeIdNum}" /></td>

												<td nowrap="nowrap" align="right" width="15%">政治面貌:</td>
												<td width="35%"><input name='empPoliState' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.empPoliState}" /></td>



											</tr>
											
											
														<tr>
											
											<!--  
												<td nowrap="nowrap" align="right">商品类别名称:</td>
												<td><input class="text" name='productTypeName'
													style="width: 154px"
													value="${goodstypeData.productTypeName}" />
												</td>
											-->
												<td nowrap="nowrap" align="right" width="15%">电话:</td>
												<td width="35%"><input name='employeeTel' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeTel}" /></td>

												<td nowrap="nowrap" align="right" width="15%">QQ:</td>
												<td width="35%"><input name='employeeQq' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeQq}" /></td>



											</tr>
											
											
														<tr>
											
												<td nowrap="nowrap" align="right" width="15%">邮箱:</td>
												<td width="35%"><input name='employeeEmail' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeEmail}" /></td>

												<td nowrap="nowrap" align="right" width="15%">员工学历:</td>
												<td width="35%"><input name='employeeSchool' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeSchool}" /></td>



											</tr>
											
											
														<tr>
											
												<td nowrap="nowrap" align="right" width="15%">员工职位:</td>
												<td width="35%"><input name='employeePosition' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeePosition}" /></td>

												<td nowrap="nowrap" align="right" width="15%">基本工资:</td>
												<td width="35%"><input name='basicWage' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.basicWage}" /></td>



											</tr>
											
											
														<tr>
											
												<td nowrap="nowrap" align="right" width="15%">所属部门编号:</td>
												<td width="35%"><input name='deptId' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.deptId}" /></td>

												<td nowrap="nowrap" align="right" width="15%">所属部门名称:</td>
												<td width="35%"><input name='deptName' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.deptId}" /></td>



											</tr>
											
											
														<tr>
											
												<td nowrap="nowrap" align="right" width="15%">入职时间:</td>
												<td width="35%"><input name='entryTime' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.entryTime}" /></td>

												<td nowrap="nowrap" align="right" width="15%">地址:</td>
												<td width="35%"><input name='employeeAddress' type="text"
													class="text"  style="width: 154px"
													value="${employeeData.employeeId}" /></td>



											</tr>
											
											
											
											


											
											
											
											
											
											


											<tr>
												<td align="right">备注:</td>
												<td colspan="3"><textarea name="remarks" cols="100"
														rows="8"></textarea></td>
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

