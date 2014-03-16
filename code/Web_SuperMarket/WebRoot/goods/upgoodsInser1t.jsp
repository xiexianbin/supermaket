<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>0000
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link rel="stylesheet" rev="stylesheet" href="../../css/style.css"
			type="text/css" media="all" />
		<script language="JavaScript" type="text/javascript">
//function check()
//{
 //if(window.vip.employeeId.value==""){
// alert("带*为必填内容");
  //window.vip.employeeId.focus();
  //return false;
  //}
  //if(window.vip.deptName.value==""){
 // alert("带*为必填内容");
 // window.vip.deptName.focus();
 // return false;
 // }
//}
var xmlHttp;
function createHttpRequest(){
	// 火狐，非IE浏览器及IE7(7.0及以上版本)，用xmlhttprequest对象创建
	if(window.XMLHttpRequest){
	
		xmlHttp=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		
		xmlHttp=new ActiveXObject("Microsoft.XMLHttp");
	}
}
function deptUser(productId){
	createHttpRequest();
	var giftId=document.getElementById("giftId").value;
	xmlHttp.open("get","addOne3.do?productId="+productId+"&giftId="+giftId, true);
	xmlHttp.send(null);
	xmlHttp.onreadystatechange=StateChange;
}
function StateChange(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
		document.getElementById("productDiv").innerHTML=xmlHttp.responseText;
		}
	}
}

</script>
		<style type="text/css">
<!--
.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}
-->
</style>
	</head>

	<body class="ContentBody">
		<form action="upgoodsInsert.action" method="post" name="vip" onsubmit="return check()">
			<div class="MainDiv" id="productDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title"> 
							商品上架信息添加 
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
												添加商品上架信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														上架流水号:
													</td>
													<td width="35%">
														<input name='serialId'  type="text" class="text"
															style="width: 154px" value="${SerialId}" />
														<!-- <span class="red">*</span> -->
													</td>
												
													<td align="right">
														采购流水号:
													</td>
													<td>
															<select id="purchId" name="purchId">
																	<option value="" selected="selected">==请选择==</option>
																<c:forEach items="${purchList}" var="purch">
																	<option value="${purch}">${purch}</option>
																</c:forEach>
															</select>
													
												</tr>


												
													<tr>
													<td align="right">
														负责人编号:
													</td>
													<td>
															<select id="employeeId" name="employeeId">
																	<option value="" selected="selected">==请选择==</option>
																<c:forEach items="${EmployList}" var="employee">
																	<option value="${employee}">${employee}</option>
																</c:forEach>
															</select>
															<!-- <span class="red">*</span> -->
													</td>
													<td align="right">
														货架编号:
													</td>
													<td>
															<select id="shelfId" name="shelfId">
																	<option value="" selected="selected">==请选择==</option>
																<c:forEach items="${shelfList}" var="shelf">
																	<option value="${shelf}">${shelf}</option>
																</c:forEach>                                
															</select>
															<!-- <span class="red">*</span> -->
														
													</td>
												</tr>
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														上架数量:
													</td>
													<td width="35%">
														<input name='upCount'  type="text" class="text"
															style="width: 154px" value="${UpCount}" />
														<!-- <span class="red">*</span> -->
													</td>	
														<td align="right">
														
													</td>
													<td>
															
													</td>									
												</tr>
												<tr>
													<td align="right">
														备注:
													</td>
													<td colspan="3">
														<textarea name="remarks" cols="100" rows="8"></textarea>
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
							<input type="submit" name="Submit" value="提交" class="button"/>

							<input type="button" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" />
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>

