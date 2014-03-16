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
	function deleteSelect() {
		var obj = document.fom.elements;
		var a = "";
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true) {
					a += obj[i].value + ",";
				}
			}
		}
		if (a == "") {
			alert("你尚未选择要删除的商品信息");
		} else {
			var check = window.confirm("确认删除所选的商品信息吗？");

			if (check) {
				window.location.replace("deleteSelect.do?a=" + a);
			}
		}
	}

	function link() {
		document.getElementById("fom").action = "productInsert1.do";
		document.getElementById("fom").submit();
	}

	function updateProduct(id) {
		var check = window.confirm("确定更新吗？");
		if (check) {
			location.replace("selectOneProduct.do?productId=" + id);
		}
	}
	function seeOneProduct(id) {
		location.replace("selectOne.do?productId=" + id);
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
										<td height="20"><a style="margin-left: 3%"></a><span
											class="newfont07">选择：<a href="#" class="right-font08"
												onclick="selectAll();">全选</a>-<a href="#"
												class="right-font08" onclick="unselectAll();">反选</a> </span> <input
											name="Submit" type="button" class="right-button08"
											value="删除所选商品" onclick="deleteSelect();" /> <input
											name="Submit2" type="button" class="right-button08"
											value="添加商品" onclick="link();" /></td>
									</tr>
									<tr>
										<td class="tablestyle_title">商品信息列表</td>
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
																<th style="color:#fff">商品编号</th>
																<th style="color:#fff">商品名称</th>
																<th style="color:#fff">商品类型编号</th>
																<th style="color:#fff">商品类型名称</th>
																<th style="color:#fff">商品规格</th>
																<th style="color:#fff">商品售价</th>
																<th style="color:#fff">生产商</th>

																<th style="color:#fff">条形码</th>
																<th style="color:#fff">商品备注</th>
																<th style="color:#fff">操作</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${productList}" var="product">
																<tr>
																	<td align="center"><input type="checkbox"
																		name="delid" value="${product.productId}" /></td>

																	<td align="center">${product.productId}</td>
																	<td align="center">${product.productName}</td>
																	<td align="center">${product.productTypeId}</td>
																	<td align="center">${product.productTypeName}</td>
																	<td align="center">${product.productNorms}</td>
																	<td align="center">${product.productPrice}</td>
																	<td align="center">${product.producer}</td>

																	<td align="center">${product.barCode}</td>

																	<c:if test="${empty product.remarks}">
																		<td align="center">&nbsp;</td>
																	</c:if>
																	<c:if test="${!empty product.remarks}">
																		<td align="center">${product.remarks}</td>
																	</c:if>
																	<td align="center"><a
																		href="javascript:updateProduct('${product.productId}')"
																		style="text-decoration: none;color:blue"
																		title="点击修改信息">更新</a> <!--  
																		<a style="text-decoration: none">&nbsp;|&nbsp;</a><a
																		href="javascript:seeOneProduct('${product.productId}')"
																		title="点击查看详情"
																		style="text-decoration: none;color:blue">查看</a>
																		--></td>
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