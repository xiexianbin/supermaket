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
		document.getElementById("fom").action = "addPart.jsp";
		document.getElementById("fom").submit();
	}
	
	
	function deleteAll(){
var id=document.getElementsByName("delid");
var ids="";
for(var i=0;i<id.length;i++){
   if(id[i].checked){
   ids+=id[i].value+",";
   }
  
}

ids=ids.substring(0, ids.length-1);

if(ids==""){
alert("请选择你要删除的礼品");
}else{
var check=window.confirm("确定删除吗？");
if(check){
window.location.replace("deleteAll.do?id="+ids);
}
}
}
	
	function selectGift(){
	
	var vipId=document.getElementById("vipId").value;
	if(vipId==""){
	alert("请输入会员编号");
	}else{
	location.replace("vipGiftList.do?vipId="+vipId);
	}
	}
	
	
	function deptUser(name){
	if(name=="商品编号"){
	document.getElementById("div1").style.display='block';
	document.getElementById("div2").style.display='none';
	}else if(name=="时间"){
	document.getElementById("div2").style.display='block';
	document.getElementById("div1").style.display='none';
	}else{
	document.getElementById("div1").style.display='none';
	document.getElementById("div2").style.display='none';
	}
	
	}
	
	
	
	function selectById(){
	var id=document.getElementById("vipId1").value;
	if(id==""){
	alert("请输入商品Id");
	
	}else{
		window.location.replace("selectReturnById.do?vipId1="+id);
	}
	}
	
	function selectByTime(){
  var time=document.getElementById("time").value;
	if(time==""){
	alert("请输入查询时间");
	}else{
	
	window.location.replace("selectReturnByTime.do?time="+time);
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
										<td height="20"><a style="margin-left: 3%"></a><span class="newfont07">选择：<a	href="#" class="right-font08" onclick="selectAll();">全选</a>-<a
												href="#" class="right-font08" onclick="unselectAll();">反选</a>
										</span> <input name="Submit" type="button" class="right-button08"
											value="删除所选礼品信息" onclick="deleteAll()"/> 
										</td>
									</tr>
						
						<tr>
							<td>
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
								
									<tr>
										<td class="tablestyle_title">退货信息查询</td>
									</tr>
									<tr>
									<td>	
								<span class="newfont07">请选择查询方式：</span>
								
								<select onchange="deptUser(this.value)">
								<option value="">==选择条件==</option>
								<option value="商品编号">商品编号</option>
								<option value="时间">时间</option>
								</select>
								
								
								<!-- 	<input type="text" name="vipId" id="vipId">&nbsp;&nbsp;&nbsp; <input 

                                          name="Submit" type="button" class="right-button08"
											value="查询记录" onclick="selectGift()"/> 
											 -->
											
											 <div style="display: none;" id="div1">
											 <span class="newfont07">请输入商品编号:</span>
											 <input type="text" name="vipId1" id="vipId1">&nbsp;&nbsp;&nbsp; <input name="Submit" type="button" class="right-button08"
											value="查询记录" onclick="selectById()"/> 
											 </div>
											  <div style="display: none;" id="div2">
											  <span class="newfont07">请输入时间：</span>
											 <input type="text" name="vipId" id="time">&nbsp;&nbsp;&nbsp; <input name="Submit" type="button" class="right-button08"
											value="查询记录" onclick="selectByTime()"/> 
											 </div>
											 
									</td>
					
				</tr>

									<tr>
								
										<td height="40" class="font42">
											<div id="container">
												<div id="demo">
												<table width="100%" style="margin-top:5px; margin-bottom: 5px" border="0" cellpadding="4" cellspacing="1" bgcolor="#6898B9" class="newfont03" class="display" id="example">
														<thead>
															<tr>
																<th>选择</th>
																<th style="color:#fff">退货编号</th>
																<th style="color:#fff">商品编号</th>
																<th style="color:#fff">商品名称</th>
																<th style="color:#fff">商品价格</th>
																<th style="color:#fff">操作员</th>
																<th style="color:#fff">时间</th>
																<th style="color:#fff">原因</th>
																<th style="color:#fff">备注</th>
																<th style="color:#fff">操作</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${list}" var="list">
																<tr>
																	<td align="center">
																	<input type="checkbox"
																		name="delid"  value="${list.afterSaleId}" id="delids"/>
																	</td>
																	
																	<td align="center">${list.afterSaleId}</td>
																	<td align="center">${list.purchId}</td>
																	<td align="center">${list.productName}</td>
																	<td align="center">${list.money}</td>
																	<td align="center">${list.employeeId}</td>
																	<td align="center">${list.date}</td>
																	<td align="left">${list.reason}</td>
																	<td align="left">${list.remarks}</td>
																	<td align="center"><a href="details.do?afterSaleId=${list.afterSaleId}"
																		style="text-decoration: none;color:blue"
																		title="点击修改信息">查看详情</a>
																</tr>
															</c:forEach>
														</tbody>
										</table>
												</div>
											</div>
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