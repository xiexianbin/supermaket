<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />

<script type="text/javascript" src="../../js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="../../js/jquery.wysiwyg.js"></script>
<link rel="stylesheet" href="../../css/jquery.wysiwyg.css"
	type="text/css" />


<link rel="stylesheet" rev="stylesheet" href="../../css/style.css"
	type="text/css" media="all" />


<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>

<script type="text/javascript" src="../../js/calendar.js"></script>

<link type="text/css" href="css/ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="dateFile/jquery-1.3.2.js"></script>
<script type="text/javascript" src="dateFile/ui.core.js"></script>
<script type="text/javascript" src="dateFile/ui.datepicker.js"></script>
<script type="text/javascript" src="dateFile/ui.datepicker-zh-CN.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datepicker').datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>


<script type="text/javascript">
	//创建XMLHttprequest对象
	var xmlHttp;

	function createHttpRequest() {
		// 火狐，非IE浏览器及IE7(7.0及以上版本)，用xmlhttprequest对象创建
		if (window.XMLHttpRequest) {

			xmlHttp = new XMLHttpRequest();
		} else if (window.ActiveXObject) {

			xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
		}
	}

	function deptUser(productId) {
		createHttpRequest();
	//	alert(productId);
		xmlHttp.open("get", "addOne3.do?productId=" + productId 
				, true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = StateChange;

	}

	function StateChange() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var Resouse=xmlHttp.responseText.split("#");
					
					var reResouse = Resouse[1].split(",");
	//				alert(reResouse);
					document.getElementById("productName").value=reResouse[0];
					document.getElementById("productTypeName").value=reResouse[1];
					document.getElementById("productPrice").value=reResouse[2];
			}
		}
	}

	function back() {
		window.location.replace("giftList.do");

	}

	function show1() {
		window.location.replace("addOne.do");
	}
	
	function go() {
		var productId=document.getElementById("productId").value;
		var score=document.getElementById("score").value;
		if(productId==""){
			alert("请选择商品编号");
			return false;
		}else{
		if(score==""){
			alert("请输入积分");
			return false;
			}else{
			window.location.replace("addOne1.do");
			return true;
			}
		}
		
	}
</script>

</head>



<body class="ContentBody">


	<form action="addOne1.do" method="post" name="vip">
		<div id="productDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">礼品添加</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width: 100%">

							<tr>
								<td width="100%">
									<fieldset style="height: 100%;">
										<legend> 添加礼品信息 </legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width: 100%">
											<tr>
												<td nowrap="nowrap" align="right" width="15%">礼品编号:</td>
												<td width="35%"><input readonly="readonly"
													name='giftId' type="text" class="text" id="giftId"
													style="width: 154px" value="${max}" /></td>
												<td width="16%" align="right" nowrap="nowrap">商品编号:</td>
												<td width="34%"><select id="productId" name="productId"
													onchange="deptUser(this.value)">
														<option value="">==请选择==</option>
														<c:forEach items="${productIdList}" var="productIdList">
															<option value="${productIdList.productId}">${productIdList.productId}</option>
														</c:forEach>
												</select> <!--  			<input class="text" name='productId' style="width: 154px"
															id='productId' value="" onchange="deptUser()"/>
													--></td>
											</tr>

											<tr>
												<td nowrap="nowrap" align="right" width="15%">商品名称:</td>
												<td width="35%"><input name='productName' type="text"
													class="text" readonly="readonly" style="width: 154px"
													id="productName" value="" /></td>
												<td width="16%" align="right" nowrap="nowrap">商品类别:</td>
												<td width="34%"><input class="text"
													name='productTypeName' style="width: 154px"
													id="productTypeName" readonly="readonly" value="" /></td>
											</tr>


											<tr>
												<td nowrap="nowrap" align="right">商品价格:</td>
												<td><input class="text" name='productPrice'
													id="productPrice" style="width: 154px" readonly="readonly"
													value="" /></td>
												<td align="right">操作员Id:</td>
												<td width="35%"><input name='vipIdNum' type="text"
													class="text" readonly="readonly" style="width: 154px"
													value="${loginId}" />
												</td>

											</tr>
											<tr>
												<td align="right">操作员姓名:</td>
												<td width="35%"><input name='vipIdNum' type="text"
													class="text" readonly="readonly" style="width: 154px"
													value="${loginName}" />
												</td>
												<td align="right">所需积分:</td>

												<td><input class="text" name='score'
												id="score"	style="width: 154px" value="" /></td>
											</tr>

											<tr>


												<td align="right">时间:</td>
												<td width="35%"><input name="date" type="text"
													id="date" class="text" style="width: 154px" value="${time}"
													readonly="readonly" /></td>
											</tr>
											<tr>
												<!--  	<td align="right">
														计划备注:
													</td>
													<td colspan="3">
														<textarea name="Remarks" cols="100" rows="8"></textarea>
													</td>
													
													-->
												<td align="right">备注:</td>
												<td colspan="3">
													<noscript>Enable JavaScript to use WYSIWYG
														features.</noscript>
													<div>
														<textarea name="Remarks" id="Remarks" rows="5" cols="80"></textarea>
													</div> <script type="text/javascript">
														(function($) {
															$('#Remarks')
																	.wysiwyg(
																			{
																				controls : {
																					strikeThrough : {
																						visible : true
																					},
																					underline : {
																						visible : true
																					},

																					separator00 : {
																						visible : true
																					},

																					justifyLeft : {
																						visible : true
																					},
																					justifyCenter : {
																						visible : true
																					},
																					justifyRight : {
																						visible : true
																					},
																					justifyFull : {
																						visible : true
																					},

																					separator01 : {
																						visible : true
																					},

																					indent : {
																						visible : true
																					},
																					outdent : {
																						visible : true
																					},

																					separator02 : {
																						visible : true
																					},

																					subscript : {
																						visible : false
																					},
																					superscript : {
																						visible : false
																					},

																					separator03 : {
																						visible : false
																					},

																					undo : {
																						visible : false
																					},
																					redo : {
																						visible : false
																					},

																					separator04 : {
																						visible : false
																					},

																					insertOrderedList : {
																						visible : true
																					},
																					insertUnorderedList : {
																						visible : true
																					},
																					insertHorizontalRule : {
																						visible : true
																					},

																					h4mozilla : {
																						visible : false && $.browser.mozilla,
																						className : 'h4',
																						command : 'heading',
																						arguments : [ 'h4' ],
																						tags : [ 'h4' ],
																						tooltip : "Header 4"
																					},
																					h5mozilla : {
																						visible : false && $.browser.mozilla,
																						className : 'h5',
																						command : 'heading',
																						arguments : [ 'h5' ],
																						tags : [ 'h5' ],
																						tooltip : "Header 5"
																					},
																					h6mozilla : {
																						visible : false && $.browser.mozilla,
																						className : 'h6',
																						command : 'heading',
																						arguments : [ 'h6' ],
																						tags : [ 'h6' ],
																						tooltip : "Header 6"
																					},

																					h4 : {
																						visible : false && !($.browser.mozilla),
																						className : 'h4',
																						command : 'formatBlock',
																						arguments : [ '<H4>' ],
																						tags : [ 'h4' ],
																						tooltip : "Header 4"
																					},
																					h5 : {
																						visible : false && !($.browser.mozilla),
																						className : 'h5',
																						command : 'formatBlock',
																						arguments : [ '<H5>' ],
																						tags : [ 'h5' ],
																						tooltip : "Header 5"
																					},
																					h6 : {
																						visible : false && !($.browser.mozilla),
																						className : 'h6',
																						command : 'formatBlock',
																						arguments : [ '<H6>' ],
																						tags : [ 'h6' ],
																						tooltip : "Header 6"
																					},

																					separator07 : {
																						visible : false
																					},

																					cut : {
																						visible : false
																					},
																					copy : {
																						visible : false
																					},
																					paste : {
																						visible : false
																					}
																				}
																			});
														})(jQuery);
													</script></td>

											</tr>
										</table>
										<br />
									</fieldset></td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td colspan="2" align="center" height="50px"><input
						type="submit" name="Submit" value="确定" class="button"
						onclick="return go();" /> <input type="button" name="Submit2" value="返回"
						class="button" onclick="back()" /></td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>

