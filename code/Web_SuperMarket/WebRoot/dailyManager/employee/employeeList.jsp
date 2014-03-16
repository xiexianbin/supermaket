<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="../../css/demos.css" rel="stylesheet" type="text/css" />
<link href="../../css/css.css" rel="stylesheet" type="text/css" />
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/xiangmu.js"></script>
<script type="text/javascript" language="javascript"
	src="../../js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="../../js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="GBK">
	$(document).ready(function() {
		$('#example').dataTable({
			"sPaginationType" : "full_numbers"
		});
	});
</script>
</head>
<SCRIPT language=JavaScript>
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	function selectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}

//为员工办理离职
	function link2() {
		document.getElementById("fom").action = "";
		document.getElementById("fom").submit();
	}

//添加新员工
	function link() {
		document.getElementById("fom").action = "addEmployee.jsp";
		document.getElementById("fom").submit();
	}
</SCRIPT>

<body id="dt_example" class="example_alt_pagination">
	<form name="fom" id="fom" method="post" action="">
		<table width="99%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table id="subtree1" style="DISPLAY: " width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="20"><a style="margin-left: 3%"></a><span
											class="newfont07">选择：<a href="#" class="right-font08"
												onclick="selectAll();">全选</a>-<a href="#"
												class="right-font08" onclick="unselectAll();">反选</a> </span> 
											
											<input name="Submit2" type="button"	class="right-button08"  value="添加新员工信息" onclick="link();" />
											<input name="Submit"  type="button" class="right-button08"	value="为所选员工办理离职"  style="width: 120px"/> 
											
											</td>
									</tr>
									<tr>
										<td class="tablestyle_title">员工管理</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<div id="container">
												<div id="demo">
													<table width="100%"
														style="margin-top:5px; margin-bottom: 5px" border="0"
														cellpadding="4" cellspacing="1" bgcolor="#6898B9"
														class="newfont03" class="display" id="example">
														<thead>
															<tr>
																<th>选择</th>
																<th style="color:#fff">员工编号</th>
																<th style="color:#fff">员工姓名</th>
																<th style="color:#fff">员工生日</th>
																<th style="color:#fff">性别</th>


																<!-- 
																
																<th style="color:#fff">身份证</th>
																<th style="color:#fff">政治面貌</th>
																<th style="color:#fff">员工头像</th>
																<th style="color:#fff">电话</th>
																
																
																
																	<th style="color:#fff">QQ</th>
																<th style="color:#fff">邮箱</th>
																<th style="color:#fff">员工学历</th>
																<th style="color:#fff">员工地址</th>
																
																 -->
																<th style="color:#fff">员工职位</th>
																<th style="color:#fff">基本工资</th>
																<th style="color:#fff">所属部门编号</th>
																<th style="color:#fff">入职时间</th>







																<!-- 
																
																<th style="color:#fff">离职时间</th>
																<th style="color:#fff">是否在职</th>
																<th style="color:#fff">备注</th>
																
																-->
															</tr>
														</thead>
														<tbody>


															<!-- 	
														//		员工表（employee_tab)					
//		字段	字段类型	长度	是否为空	是否主键	说明
//		employeeId	int		否	是	员工编号
//	1	employeeName	varchar	20			员工姓名
//	employeeBirthday	varchar				员工生日
//	3	employeeSex	varchar	10			性别
//	4	employeeIdNum	varchar	18			身份证
//	5	empPoliState	varchar	20	否		政治面貌
//	6	employeePicture	image				员工头像
//	7	employeeTel	varchar	20			电话
//	8	employeeQq	varchar	20			QQ
//	9	employeeEmail	varchar	50			邮箱
//	10	employeeSchool	varchar	50			员工学历
//	11	employeeAddress	varchar	100			员工地址
//	12	employeePosition	varchar	20			员工职位
//	13	basicWage	float				基本工资
//	14	deptId	int				所属部门编号
//	15	entryTime	varchar	30			入职时间
//	16	leaveTime	varchar	30			离职时间
//	17	employeeState	varchar	10			是否在职
//	18	remarks	text				备注
														
						 -->
															<c:forEach items="${employeeList}" var="g">
																<tr>
																	<td align="center"><input type="checkbox"
																		name="delid" /></td>
																	<td align="center">${g.employeeId}</td>
																	<td align="center">${g.employeeName}</td>
																	<td align="center">${g.employeeBirthday}</td>
																	<td align="center">${g.employeeSex}</td>
															<!--  		
																	<td align="center">${g.employeeIdNum}</td>
																	<td align="center">${g.empPoliState}</td>
																	<td align="center">${g.employeePicture}</td>
																	<td align="center">${g.employeeTel}</td>
																	
																	<td align="center">${g.employeeQq}</td>
																	<td align="center">${g.employeeEmail}</td>
																	<td align="center">${g.employeeSchool}</td>
																	<td align="center">${g.employeeAddress}</td>
															-->
																	<td align="center">${g.employeePosition}</td>
																	<td align="center">${g.basicWage}</td>
																	<td align="center">${g.deptId}</td>
																	<td align="center">${g.entryTime}</td>
															<!-- 

																	<td align="center">${g.leaveTime}</td>
																	<td align="center">${g.employeeState}</td>
																	<td align="center">${g.remarks}</td>
															-->


																	<td align="center" nowrap="nowrap"><a
																		href="findEmployeeData.do?id=${g.employeeId}"
																		style="text-decoration: none;color:blue"
																		title="点击修改信息">修改</a> <a style="text-decoration: none">&nbsp;|&nbsp;</a>
																		<a href="employeeDetails.do?id=${g.employeeId}"
																		title="点击查看详情"
																		style="text-decoration: none;color:blue">查看</a></td>
																</tr>
															</c:forEach>
														</tbody>










													</table>
												</div>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>