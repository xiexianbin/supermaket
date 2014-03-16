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

<body id="dt_example" class="example_alt_pagination" onload="ShowElements('${TIME}')">
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
										<td height="20"><a style="margin-left: 3%">
										<input type="button" class="right-button08" onclick="window.history.go(-1);" value="返回"/>
										</a>
										</td>
									</tr>
									<tr>
										<td class="tablestyle_title">销售量详情统计表</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<div id="container">
												<div id="demo">
												<table width="100%" style="margin-top:5px; margin-bottom: 5px" border="0" cellpadding="4" cellspacing="1" bgcolor="#6898B9" class="newfont03" class="display" id="example">
														<thead>
															<tr>
																<th style="color:#fff">销售编号</th>
																<th style="color:#fff">商品编号</th>
																<th style="color:#fff">购买数量</th>
																<th style="color:#fff">交易时间</th>
																<th style="color:#fff">交易流水号</th>
																<th style="color:#fff">备注</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${LIST}" var="s">
																<tr>
																	
																	<td align="center">${s.salesId}</td>
																	<td align="center">${s.productId}</td>
																	<td align="center">${s.count}</td>
																	<td align="center">${s.salesTime}</td>
																	<td align="center">${s.salesWaterNo}</td>
																	<td align="center">${s.payType}</td>
																	<td align="center">${s.remarks}</td>
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