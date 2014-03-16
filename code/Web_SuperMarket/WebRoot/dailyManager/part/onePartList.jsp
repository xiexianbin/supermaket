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
																<th style="color:#fff">员工职位</th>
																<th style="color:#fff">基本工资</th>
																<th style="color:#fff">所属部门</th>
																<th style="color:#fff">入职时间</th>
															</tr>
														</thead>
														<tbody>

															<c:forEach items="${employeeList}" var="g">
																<tr>
																	<td align="center"><input type="checkbox"
																		name="delid" /></td>
																	<td align="center">${g.employeeId}</td>
																	<td align="center">${g.employeeName}</td>
																	<td align="center">${g.employeeBirthday}</td>
																	<td align="center">${g.employeeSex}</td>
														
																	<td align="center">${g.employeePosition}</td>
																	<td align="center">${g.basicWage}</td>
																	<td align="center">${Dept}</td>
																	<td align="center">${g.entryTime}</td>
							
																	<td align="center" nowrap="nowrap"><a
																		href="../employee/findEmployeeData.do?id=${g.employeeId}"
																		style="text-decoration: none;color:blue"
																		title="点击修改信息">修改</a> <a style="text-decoration: none">&nbsp;|&nbsp;</a>
																		<a href="../employee/employeeDetails.do?id=${g.employeeId}"
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