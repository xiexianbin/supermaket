<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	
	<link href="../../css/css.css" rel="stylesheet" type="text/css" />
	<link href="../../css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../../js/xiangmu.js"></script>
	
	
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

	function link() {
		document.getElementById("fom").action = "employeeList.action";
		document.getElementById("fom").submit();
	}
	
	function checkDept(vsa){
	if(vsa==""){
	  alert("请选择日期");
	}else{
	
	location.replace("selectDept.do?ids="+vsa);
	
	}
	
function Todate(){
var vas=document.getElementById("year").value+"-"+document.getElementById("month").value;
  location.replace("dateList?datime"+vas);
}
	
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
										<td class="tablestyle_title">${datime}考勤信息列表</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											
											
												<table width="100%" style="margin-top:5px; margin-bottom: 5px" border="1" cellpadding="4" cellspacing="0" bgcolor="#6898B9" class="newfont03" class="display" id="example">
														
															<tr>
																
																<th style="color:#fff">员工编号</th>
																<th style="color:#fff">员工姓名</th>
															    
																<th style="color:#fff">迟到</th>
																<th style="color:#fff">早退</th>
																<th style="color:#fff">加班</th>
																<th style="color:#fff">旷工</th>
																
																
															</tr>
														
														
															
																<tr>
																	<td align="center">${loginId}</td>
																	<td align="center">${loginName}</td>
																	
																	<td align="center"><a href="workLate.do?dtime=${datime}">${ymode.late}</a></td>
																	<td align="center"><a href="workEarly.do?dtime=${datime}">${ymode.early}</a></td>
																	<td align="center"><a href="workAdd.do?dtime=${datime}">${ymode.add}</a></td>
																	<td align="center"><a href="workAbsence.do?dtime=${datime}">${ymode.absence}</a></td>
																	
																</tr>
															
																								
													</table>
												
											</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>