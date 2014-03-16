<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<script type="text/javascript" src="../calendar.js"></script>
		<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="../js/jquery.wysiwyg.js"></script>
    <link rel="stylesheet" href="../css/jquery.wysiwyg.css" type="text/css" />
		
		
		<link rel="stylesheet" rev="stylesheet" href="../css/style.css"
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



<script "text/javascript" src="../js/calendar.js"></script>

<link type="text/css" href="css/ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="dateFile/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="dateFile/ui.core.js"></script>
	<script type="text/javascript" src="dateFile/ui.datepicker.js"></script>
	<script type="text/javascript" src="dateFile/ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#datepicker').datepicker({
			changeMonth: true,
			changeYear: true
		});
	});
	</script>


<script language="JavaScript">

function show1(){
var afterSaleId=document.getElementById("AfterSaleId").value;
var productId=document.getElementById("productId").value;
var employeeId=document.getElementById("employeeId").value;
var reason=document.getElementById("reason").value;
var Remarks=document.getElementById("Remarks").value;
var date=document.getElementById("date").value;
if(productId==""){
alert("请输入商品编号");
return false;
}else{
var check=window.confirm("是否确定退货？");
if(check){

window.location.replace("addReturn.do?productId="+productId+"&employeeId="+employeeId+"&reason="+reason+"&Remarks="+Remarks+"&date="+date+"&afterSaleId="+afterSaleId);
return true;
}
}
}

//创建XMLHttprequest对象
var xmlHttp;

function createHttpRequest(){
	// 火狐，非IE浏览器及IE7(7.0及以上版本)，用xmlhttprequest对象创建
	if(window.XMLHttpRequest){
	
		xmlHttp=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		
		xmlHttp=new ActiveXObject("Microsoft.XMLHttp");
	}
}


function deptUser(id){
	createHttpRequest();
//	alert(id);
	xmlHttp.open("get","afterSale1.do?productId="+id, true);
	xmlHttp.send(null);
	xmlHttp.onreadystatechange=StateChange;
}

function StateChange(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
		
		var Resouse=xmlHttp.responseText.split("#");
					
					var reResouse = Resouse[1].split(",");
					document.getElementById("productName").value=reResouse[0];
					document.getElementById("productTypeName").value=reResouse[1];
					document.getElementById("productPrice").value=reResouse[2];
		}
	}
}



</script>

	</head>
	<body class="ContentBody">
	<div id="showData">
		<form method="post" name="vip">
			
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							顾客退货
						</th>
					</tr>
					<tr>
						<td class="CPanel">

							<table border="0" cellpadding="0" cellspacing="0"
								style="width: 100%">

								<tr>
									<td width="100%">
										<fieldset style="height: 100%;">
											<legend>
												顾客退货
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%" >
												
												<tr>
													
													<td width="16%" align="right" nowrap="nowrap">
														退货编号:
													</td>
													<td width="34%">
														<input class="text" readonly="readonly" name='AfterSaleId' style="width: 154px"
															id="AfterSaleId" value="${max1}"/>
													
													</td>
													
													<td width="16%" align="right" nowrap="nowrap">
														员工编号:
													</td>
													<td width="34%">
														<input class="text" name='employeeId' id="employeeId" style="width: 154px"
															value="${loginId}" readonly="readonly"/>
														
													</td>
													
												</tr>
                                                	              
												<tr>
												<td nowrap="nowrap" align="right" width="15%">
														员工姓名:
													</td>
													<td width="34%">
														<input class="text" name='productId' style="width: 154px"
															 value="${loginName}"readonly="readonly"/>
													
													</td>
													<td nowrap="nowrap" align="right" width="15%">
														商品编号:
													</td>
													<td width="34%">
													<select	onchange="deptUser(this.value)" id="productId">
															<option value="">==请选择==</option>
															<c:forEach items="${productId}" var="productIdList">
																<option value="${productIdList.productId}">${productIdList.productId}</option>
															</c:forEach>
													</select> 
													</td>
													
												</tr>
												<tr>
												<td nowrap="nowrap" align="right" width="15%">
														商品名称:
													</td>
													<td width="34%">
														<input class="text" name='productName' style="width: 154px"
														readonly="readonly"	id="productName" value="" />
													
													</td>
												<td nowrap="nowrap" align="right">
														商品类别:
													</td>
													<td>
														
	                                                  <input class="text" name='productTypeName' style="width: 154px"
														readonly="readonly"	id="productTypeName" value=""/>
															</td>
												</tr>
												<tr>
												<td nowrap="nowrap" align="right">
														应退金额:
													</td>
													<td>
														
	                                                   <input class="text" name='productPrice' style="width: 154px"
														readonly="readonly"	id="productPrice" value=""/>
													</td>
												<td nowrap="nowrap" align="right">
														退货时间:
													</td>
													<td>
														
	                                                   <input name="date" class="text" id="date" value="${time}" readonly="readonly" />
													</td>
												
												</tr>

												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														退货原因:
													</td>
													<td>
														<noscript>Enable JavaScript to use WYSIWYG features.</noscript>
    <div>
      <textarea name="reason" id="reason" rows="5" cols="80" ></textarea>
    </div>
    <script type="text/javascript">
		(function($)
		{
		  $('#reason').wysiwyg({
			controls: {
			  strikeThrough : { visible : true },
			  underline     : { visible : true },
			  
			  separator00 : { visible : true },
			  
			  justifyLeft   : { visible : true },
			  justifyCenter : { visible : true },
			  justifyRight  : { visible : true },
			  justifyFull   : { visible : true },
			  
			  separator01 : { visible : true },
			  
			  indent  : { visible : true },
			  outdent : { visible : true },
			  
			  separator02 : { visible : true },
			  
			  subscript   : { visible : false },
			  superscript : { visible : false },
			  
			  separator03 : { visible : false },
			  
			  undo : { visible : false },
			  redo : { visible : false },
			  
			  separator04 : { visible : false },
			  
			  insertOrderedList    : { visible : true },
			  insertUnorderedList  : { visible : true },
			  insertHorizontalRule : { visible : true },
			  
			  h4mozilla : { visible : false && $.browser.mozilla, className : 'h4', command : 'heading', arguments : ['h4'], tags : ['h4'], tooltip : "Header 4" },
			  h5mozilla : { visible : false && $.browser.mozilla, className : 'h5', command : 'heading', arguments : ['h5'], tags : ['h5'], tooltip : "Header 5" },
			  h6mozilla : { visible : false && $.browser.mozilla, className : 'h6', command : 'heading', arguments : ['h6'], tags : ['h6'], tooltip : "Header 6" },
			  
			  h4 : { visible : false && !( $.browser.mozilla ), className : 'h4', command : 'formatBlock', arguments : ['<H4>'], tags : ['h4'], tooltip : "Header 4" },
			  h5 : { visible : false && !( $.browser.mozilla ), className : 'h5', command : 'formatBlock', arguments : ['<H5>'], tags : ['h5'], tooltip : "Header 5" },
			  h6 : { visible : false && !( $.browser.mozilla ), className : 'h6', command : 'formatBlock', arguments : ['<H6>'], tags : ['h6'], tooltip : "Header 6" },
			  
			  separator07 : { visible : false },
			  
			  cut   : { visible : false },
			  copy  : { visible : false },
			  paste : { visible : false }
			}
		  });
		})(jQuery);
    </script>
	</td>

											
												
												<td nowrap="nowrap" align="right" width="15%">
														备&nbsp;&nbsp;&nbsp;&nbsp;注:
													</td>
													<td >
													<noscript>Enable JavaScript to use WYSIWYG features.</noscript>
    <div>
      <textarea name="Remarks" id="Remarks" rows="5" cols="80" ></textarea>
    </div>
    <script type="text/javascript">
		(function($)
		{
		  $('#Remarks').wysiwyg({
			controls: {
			  strikeThrough : { visible : true },
			  underline     : { visible : true },
			  
			  separator00 : { visible : true },
			  
			  justifyLeft   : { visible : true },
			  justifyCenter : { visible : true },
			  justifyRight  : { visible : true },
			  justifyFull   : { visible : true },
			  
			  separator01 : { visible : true },
			  
			  indent  : { visible : true },
			  outdent : { visible : true },
			  
			  separator02 : { visible : true },
			  
			  subscript   : { visible : false },
			  superscript : { visible : false },
			  
			  separator03 : { visible : false },
			  
			  undo : { visible : false },
			  redo : { visible : false },
			  
			  separator04 : { visible : false },
			  
			  insertOrderedList    : { visible : true },
			  insertUnorderedList  : { visible : true },
			  insertHorizontalRule : { visible : true },
			  
			  h4mozilla : { visible : false && $.browser.mozilla, className : 'h4', command : 'heading', arguments : ['h4'], tags : ['h4'], tooltip : "Header 4" },
			  h5mozilla : { visible : false && $.browser.mozilla, className : 'h5', command : 'heading', arguments : ['h5'], tags : ['h5'], tooltip : "Header 5" },
			  h6mozilla : { visible : false && $.browser.mozilla, className : 'h6', command : 'heading', arguments : ['h6'], tags : ['h6'], tooltip : "Header 6" },
			  
			  h4 : { visible : false && !( $.browser.mozilla ), className : 'h4', command : 'formatBlock', arguments : ['<H4>'], tags : ['h4'], tooltip : "Header 4" },
			  h5 : { visible : false && !( $.browser.mozilla ), className : 'h5', command : 'formatBlock', arguments : ['<H5>'], tags : ['h5'], tooltip : "Header 5" },
			  h6 : { visible : false && !( $.browser.mozilla ), className : 'h6', command : 'formatBlock', arguments : ['<H6>'], tags : ['h6'], tooltip : "Header 6" },
			  
			  separator07 : { visible : false },
			  
			  cut   : { visible : false },
			  copy  : { visible : false },
			  paste : { visible : false }
			}
		  });
		})(jQuery);
    </script>
	</td>
												
									</tr>
											</table>
											<br />
										</fieldset>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" height="50px">
							<input type="button" name="Submit" value="确定" class="button" onclick="return show1()"/>

							<input type="button" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" />
						</td>
					</tr>
				</table>
			
		</form>
		</div>
	</body>
</html>

