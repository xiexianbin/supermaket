<%@ page language="java" import="java.util.*,com.goods.*"
	pageEncoding="GBK"%>
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
	src="js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="js/jquery.dataTables.js"></script>
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
		window.open(
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
		document.getElementById("fom").action = "addInStorage.jsp";
		document.getElementById("fom").submit();
	}
	
	
	
	function inquire() {
	
		 var temp=/^[1-9]+[0-9]*]*$/;
	
		if(temp.test(document.getElementById("inputcode").value)==false){
		 alert("请重新扫描条码！");}else{
	
	
		document.getElementById("fom").action = "inquireProductData.do";
		document.getElementById("fom").submit();
		
		}
		
	}
	
	
	function tianjia(){
	
	
	
	
		var temp=/^[1-9]+[0-9]*]*$/;
	
		if(temp.test(document.getElementById("count").value)==false){
		 alert("请输入正确购买数量！");
		 document.getElementById('q1').href="onSaleRight.jsp";
		 
		 }else{
						var a1=document.getElementById("count").value;
						
						var a2=document.getElementById("vipId").value;
						var arr='addToBuyList.do?barcode=${productData.barCode}&vipId='+a2+'&count='+a1;
						document.getElementById('q1').href=arr;
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
										<td class="tablestyle_title">查询商品</td>
									</tr>
									<tr>
										<td height="20">
											<font size="3"> &nbsp;&nbsp;条形码：</font><input type="text" name="barcode" id="inputcode">
											<input name="Submit2" type="button" class="right-button08" value="查询" onclick="inquire();" />
											<font size="3">会员卡号：</font><input name="vipId" id='vipId' type="text" value="">
										</td>
									</tr>
									<tr>
										<td height="40" class="font42">
										
													<table width="100%"
														style="margin-top:5px; margin-bottom: 5px" border="1"
														cellpadding="4" cellspacing="1" >
															<tr style="background-color:#6898B9">
																<th style="width: 10%;color:#fff">操作</th>
																<th style="width: 15%;color:#fff">商品编号</th>
																<th style="width: 20%;color:#fff">商品名称</th>
																<th style="width: 20%;color:#fff">单价</th>
																<th style="width: 15%;color:#fff">数量</th>
																<th style="width: 20%;color:#fff">厂家</th>
															</tr>
																<tr style="background-color: #E2E4FF">
																	<c:if test="${! empty productData}">
																		<td align="center"><a id='q1' href="onSaleRight.jsp" target="right" style="text-decoration: none;color:blue" 
																		title="点击添加" onclick="tianjia()"><font size="3">[添加]</font></a></td>
																	</c:if>
																	<c:if test="${empty productData}">
																		<td>&nbsp;</td>
																	</c:if>
																	<td align="center">${productData.productId}</td>
																	<td align="center">${productData.productName}</td>
																	<td align="center">${productData.productPrice}</td>
																	<c:if test="${! empty productData}">
																		<td align="center"><input type="text" size="5" style="border: 0 #E2E4FF" name="count" id="count" value="${1}" /> </td>
																	</c:if>
																	<c:if test="${empty productData}">
																		<td align="center"><input type="text" size="5" style="border: 0" name="count" id="count" value="" /> </td>
																	</c:if>
																	<td align="center">${productData.producer}</td>

																</tr>
													</table>
											
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