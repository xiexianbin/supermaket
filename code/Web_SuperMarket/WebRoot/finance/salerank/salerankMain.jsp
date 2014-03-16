

<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; 

charset=gb2312" />
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

	

	function link() {
		document.getElementById("fom").action = "addPart.jsp";
		document.getElementById("fom").submit();
	}
	
	function checkTu(){
location.replace("checkTu.do");
}
	
	function Todate(){
	
     if(document.getElementById("year").value==""){
     alert("请输入年份");

     }
   else if(document.getElementById("month").value==""){
    alert("请输入月份");
     }else{
var vas=document.getElementById("year").value

+"-"+document.getElementById("month").value;

  location.replace("dateList.do?datime="+vas);
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
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">


									<tr>


										<td height="20" align="right"><select id="year"><option
													value="">请选择 年份</option>
												<option value="2010">2010</option>
												<option value="2011">2011</option>
												<option value="2012">2012</option>
												<option value="2013">2013</option>
												<option value="2014">2014</option>
												<option value="2015">2015</option>
												<option value="2016">2016</option>
												<option value="2017">2017</option>
												<option value="2018">2018</option>
												<option value="2019">2019</option>
												<option value="2020">2020</option>
												<option value="2021">2021</option>
												<option value="2022">2022</option>
												<option value="2023">2023</option>
												<option value="2024">2024</option>
												<option value="2025">2025</option>
												<option value="2026">2026</option>
												<option value="2027">2027</option>
												<option value="2028">2028</option>
												<option value="2029">2029</option>
												<option value="2030">2030</option>
										</select>年 <select id="month"><option value="">请选择月份</option>
												<option value="1">01</option>
												<option value="2">02</option>
												<option value="3">03</option>
												<option value="4">04</option>
												<option value="5">05</option>
												<option value="6">06</option>
												<option value="7">07</option>
												<option value="8">08</option>
												<option value="9">09</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
										</select>月<input type="button" class="right-button08" value="按时间查询"
											onclick="Todate

()"></td>


									</tr>


									<tr>


										<td class="tablestyle_title">${time}销售排行列表</td>


									</tr>
									<tr>
										<td align="right"><input type="button"
											class="right-button08" value="查看饼状图" onclick="checkTu()">
										</td>
									</tr>


									<tr>


										<td height="40" class="font42">


											<div id="container">


												<div id="demo">


													<table width="100%"
														style="margin-top:5px; margin-

bottom: 5px" border="0"
														cellpadding="7" cellspacing="1" bgcolor="#6898B9"
														class="newfont03" class="display" id="example">


														<thead>


															<tr>





																<th style="color:#fff">商品类别编号</th>


																<th style="color:#fff">商品类别名称</th>


																<th style="color:#fff">商品编号</th>


																<th style="color:#fff">商品名称</th>


																<th style="color:#fff">月销售量</th>




															</tr>


														</thead>


														<tbody>


															<c:forEach items="${protype}" var="pro">


																<tr>


																	<td align="center">${pro.proTyId}
																		
																	</td>


																	<td align="center">${pro.proTyName}
																	</td>


																	<td align="center">${pro.proId}
																		
																	</td>


																	<td align="center">${pro.proName}


																	<td align="center">${pro.sumcount}
																	</td>







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
