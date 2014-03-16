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

	function link() {
		document.getElementById("fom").action = "employeeList.action";
		document.getElementById("fom").submit();
	}
	function exportToXls(){
  		window.location.replace("exportToxls.action");
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
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="20"><a style="margin-left: 3%"></a><span class="newfont07">选择：<a	href="#" class="right-font08" onclick="selectAll();">全选</a>-<a
												href="#" class="right-font08" onclick="unselectAll();">反选</a>
										</span>  <input name="Submit2" type="button"
											class="right-button08" value="录入员工考勤" onclick="link();" />&nbsp;&nbsp;<input name="Submit" type="button" class="right-button08"
											value="导出员工考勤信息" onclick="exportToXls();"/>
										</td>
									</tr>
									<tr>
										<td class="tablestyle_title">考勤信息列表</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<div id="container">
												<div id="demo">
												<table width="100%" style="margin-top:5px; margin-bottom: 5px" border="0" cellpadding="4" cellspacing="1" bgcolor="#6898B9" class="newfont03" class="display" id="example">
														<thead>
															<tr>
																<th>选择</th>
																<th style="color:#fff">序号</th>
																<th style="color:#fff">部门号</th>
																<th style="color:#fff">姓名</th>
																<th style="color:#fff">员工号</th>
																<th style="color:#fff">刷卡日期</th>
																<th style="color:#fff">星期</th>
																<th style="color:#fff">打卡1</th>
																<th style="color:#fff">打卡2</th>
																<th style="color:#fff">备注</th>
																<th style="color:#fff">操作</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${list}" var="check">
																<tr>
																	<td align="center"><input type="checkbox"
																		name="delid" />
																	</td>
																	<td align="center">${check.salaryId}</td>
																	<td align="center">${check.deptId}</td>
																	<td align="center">${check.employeeName}</td>
																	<td align="center">${check.employeeId}</td>
																	<td align="center">${check.dateTime}</td>
																	<td align="center">${check.weeks}</td>
																	<td align="center">${check.time1}</td>
																	<td align="center">${check.time2}</td>
																	<c:if test="${empty check.remarks}">
																		<td align="center">&nbsp;</td>
																	</c:if>
																	<c:if test="${!empty check.remarks}">
																		<td align="center">${check.remarks}</td>
																	</c:if>
																	<td align="center"><a href="findCheck.do?id=${check.salaryId}"
																		style="text-decoration: none;color:blue"
																		title="点击修改信息">修改</a>
																	</td>
																</tr>
															</c:forEach>
														</tbody>
														<!--
				  <tr>
				    <td width="4%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="13%" height="20" align="center" bgcolor="#EEEEEE">项目名称</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">单位</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">项目总金额</td>
                    <td width="10%" align="center" bgcolor="#EEEEEE">项目负责人</td>
                    <td width="9%" align="center" bgcolor="#EEEEEE">项目开发人数</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">成本总支出</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">开始时间</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">计划完成时间</td>
					<td width="7%" align="center" bgcolor="#EEEEEE">实际完成时间</td>
                    <td width="7%" align="center" bgcolor="#EEEEEE">任务优先级</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">完成状态</td>
                    <td width="6%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <tr>
				    <td bgcolor="#FFFFFF"><input type="checkbox" name="delid"/></td>
                    <td height="20" bgcolor="#FFFFFF">流动人口项目</td>
                    <td bgcolor="#FFFFFF">电信</td>
                    <td bgcolor="#FFFFFF">500万</td>
                    <td bgcolor="#FFFFFF">张三</td>
                    <td bgcolor="#FFFFFF">5</td>
                    <td bgcolor="#FFFFFF">300万</td>
                    <td bgcolor="#FFFFFF">2007-11-11</td>
                    <td bgcolor="#FFFFFF">2008-1-1</td>
                    <td bgcolor="#FFFFFF">2007-12-12</td>
                    <td bgcolor="#FFFFFF">急</td>
                    <td bgcolor="#FFFFFF">已经完成</td>
                    <td bgcolor="#FFFFFF"><a href="xiangmu.htm">编辑</a></td>
                  </tr>
                 -->
													</table>
												</div>
											</div></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>