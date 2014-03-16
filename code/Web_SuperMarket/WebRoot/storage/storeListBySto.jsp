<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link href="../css/demos.css" rel="stylesheet" type="text/css" />
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/xiangmu.js"></script>
	<script type="text/javascript" language="javascript"
		src="../js/jquery.js"></script>
	<script type="text/javascript" language="javascript"
		src="../js/jquery.dataTables.js"></script>
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

	function checks(){
	var value=document.getElementById("sel").value;
	if(value=="storage"){
		window.location.replace("listBySto.do");
	}else if(value=="product"){
		window.location.replace("listByPro.do");
	}else{
		window.location.replace("storeList.do");
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
								<td height="20">
								<a style="margin-left: 3%"></a>
								<span class="newfont07">
								选择查询方式：<select id="sel" onchange="JavaScript:checks()">
								<option value="">== 请选择 ==</option>
								<option value="storage">仓库编号</option>
								<option value="product">商品编号</option>
								</select>
								</span>
							
								</td>
								</tr>
								 
									<tr>
										<td class="tablestyle_title">库存信息列表</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<div id="container">
												<div id="demo">
												<table width="100%" style="margin-top:5px; margin-bottom: 5px" border="0" cellpadding="4" cellspacing="1" bgcolor="#6898B9" class="newfont03" class="display" id="example">
														<thead>
															<tr>
																
																<th style="color:#fff">仓库编号</th>
																<th style="color:#fff">商品编号</th>
																<th style="color:#fff">商品名称</th>
																<th style="color:#fff">库存数量</th>
																
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${storeListBySto}" var="store">
																<tr>
																	
																	<td align="center">${store.storageId}</td>
																	<td align="center">${store.productId}</td>
																	<td align="center">${store.productName}</td>
																	<td align="center">${store.remainNum}</td>
																	
																</tr>
															</c:forEach>
														</tbody>
													
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