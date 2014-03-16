<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>下订单</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

		<link href="../../css/css.css" rel="stylesheet" type="text/css" />
		<link href="../../css/style.css" rel="stylesheet" type="text/css" />
		<style type="text/css" title="currentStyle">
			@import "../../css/demos.css";
		</style>
		<script type="text/javascript" language="javascript" src="../../js/jquery.js"></script>
		<script type="text/javascript" language="javascript" src="../../js/jquery.dataTables.js"></script>
		<script type="text/javascript" charset="GBK">
			$(document).ready(function() {
				$('#example').dataTable( {
					"sPaginationType": "full_numbers"
				} );
			} );
		</script>
</head>


<body id="dt_example" class="example_alt_pagination">
<form name="fom" id="fom" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td>
	  <table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
		  	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		  	
           	  <tr>
                <td height="40" style="line-height:40px;">
			    	<span class="newfont07">
			 			选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-
			 			<a href="#" class="right-font08" onclick="unselectAll();">反选</a>
			 		</span>
	               <input name="Submit" type="button" class="right-button08" value="删除所选项目信息" />
	               <input name="Submit2" type="button" class="right-button08" value="添加项目" onclick="link();"/>
				 </td>
			  </tr>
			  
			  <tr>
				<td class="tablestyle_title">货架列表</td>
			  </tr>
			  
              <tr>
                <td height="40" class="font42">
					<!-- 下面是列表 -->
					<div id="container">			
					<div id="demo">
					
					<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#6898B9" class="newfont03" class="display" id="example">
					<thead>
						  <tr>
								<th>选择</th>
								<th style="color:#fff">货架编号</th>
								<th style="color:#fff">货架位置</th>
								<th style="color:#fff">货架规格</th>
								<th style="color:#fff" width="30%">备注</th>
								<th style="color:#fff" width="10%">操作</th>
						  </tr>
					 </thead>
					 <tbody>
					 <c:forEach items="${shelfList}" var="shelf">
						  <tr>
						  	<!-- 复选框开始 -->
							<td bgcolor="#FFFFFF" align="center"><input type="checkbox" name="delid"/></td>
							<!-- 复选框结束 -->
							
							<td align="center" width="8%">${shelf.shelfId}</td>
							<td align="center">${shelf.shelfLocation}</td>
							<td align="center"><a href="#">${shelf.shelfType}</a></td>
							<td align="left">${shelf.remarks}</td>
							<td align="center">
								<a href="#" style="text-decoration: none;color:blue" title="点击修改信息">修改</a>
								<a style="text-decoration: none">&nbsp;|&nbsp;</a>
								<a href="#" title="点击查看详情" style="text-decoration: none;color:blue">查看</a>
							</td>
						  </tr>
					  </c:forEach>
					  </tbody>
                	</table>
					
					
					</div>
					</div>
					<!-- 列表 -->
				</td>
              </tr>
            </table>
		   </td>
        </tr>
      </table>
	  
	  <!-- 下面是分页  此处用于每次从数据库中取一页数据 -->
 <!-- <table width="95%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FF0000">
        <tr>
          <td height="33">
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
				  <tr>
					<td width="50%">
						共<span class="right-text09">5</span>页| 
						第<span class="right-text09">1</span>页
					</td>
					<td width="49%" align="right">
						[<a href="#" class="right-font08">首页</a>|
						<a href="#" class="right-font08">上一页</a>| 
						<a href="#" class="right-font08">下一页</a>|
						<a href="#" class="right-font08">末页</a>]转至
					</td>
				  </tr>
			  </table>
		  </td>
        </tr>
      </table> -->
	  <!-- 分页结束 -->

	 </td>
  </tr>
</table>
</form>

<SCRIPT language=JavaScript>

function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="xiangmu.htm";
   document.getElementById("fom").submit();
}

</SCRIPT>



</body>
</html>
