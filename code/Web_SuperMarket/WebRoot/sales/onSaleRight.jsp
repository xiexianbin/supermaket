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
	src="../js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="../js/jquery.dataTables.sale.js"></script>
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
		document.getElementById("fom").action = "addInStorage.jsp";
		document.getElementById("fom").submit();
	}
	
	
	
	function jisuan(){
	
                    

	 	//var temp=/^[1-9]+[0-9]*]*$/;//判断正整数
	 	//判断正浮点数
	 	var temp=/(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]*)|([0-9]*[1-9][0-9]*))$/;
	
		if(temp.test(document.getElementById("shishou").value)==false){
		 alert("输入正确付款金额！");}else{
			a=Number(document.getElementById("yingfu").value);
			b=Number(document.getElementById("shishou").value);
			if(b<a)
					{
					alert("顾客付款不足，请核实！");
					}
			else
					{
					c=b-a;
					c = parseFloat(c.toFixed(2)); //格式化小数点长度
					document.getElementById("zhaoling").value=c;
					}
		}
	
	}
	
	function finish(){
	
	
		 	var temp=/^[1-9]+[0-9]*]*$/;
	
		if(temp.test(document.getElementById("shishou").value)==false){
		 alert("输入正确金额！");}else{
	if(!document.getElementById("zhaoling").value==""){
		document.getElementById("fom").action = "finishOneDeal.do";
	document.getElementById("fom").submit();
	}
	

	}
	}
	
	function clearList(){
	document.getElementById("fom").action = "clearList.do";
	document.getElementById("fom").submit();
	
	}
	
	function deletePro(val){
	
	
		//	alert("qqqq2");
		//	alert(val);
			var arr='deletePro.do?proid='+val;
		//	alert(arr);
			document.getElementById('q2').href=arr;
	
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
								<table width="95%" bordercolor="#6898B9" border="1" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td align="center" style="height: 30px">
										<font size="3" color="blue">购买清单:</font>&nbsp;&nbsp;
										<input type="button" class="right-button08" value="清空" onclick="clearList()"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<!--<input style="margin-right: 1%;border: 0" readonly="readonly" />  -->	 
										
										<font size="3" color="blue">应付</font>&nbsp;&nbsp;<input type="text" id="yingfu" value="${addPrice}" size="8" />
										<font size="3" color="blue">实付</font>&nbsp;&nbsp;<input type="text" id="shishou" size="8" />
										<font size="3" color="blue">找零</font>&nbsp;&nbsp;<input type="text" id="zhaoling" size="8" />
										<input type="button" class="right-button08" onclick="jisuan()" value="结算"/>
										支付方式：<select id="PayType" name="PayType">
													<option value="现金支付" selected="selected">现金支付</option>
													<option value="刷卡支付">刷卡支付</option>
												</select>
										<input type="button" class="right-button08" onclick="finish()" value="结账"/>
										</td>
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
																<th style="color:#fff">选择</th>
																<th style="color:#fff">商品编号</th>
																<th style="color:#fff">商品名称</th>
																<th style="color:#fff">商品售价</th>
																<th style="color:#fff">购买数量</th>
																<th style="color:#fff">金额</th>
																<th style="color:#fff">操作</th>
															</tr>
														</thead>
														<tbody>
														<c:if test="${! empty buyList}">
															<c:forEach items="${buyList}" var="s">
																<tr>
																	<td align="center"><input type="checkbox"
																		name="delid" /></td>
																	<td align="center">${s.productId}</td>
																	<td align="center">${s.productName}</td>
																	<td align="center">${s.productPrice}</td>
																	<td align="center">${s.count}</td>
																	<td align="center">${s.soloprice}</td>
																	<td align="center">
																	<a href=""  id="q2" onclick="deletePro('${s.productId}')" style="text-decoration: none;color:blue"><font size="3">删除</font></a>
																	</td>
																</tr>
															</c:forEach>
															</c:if>
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