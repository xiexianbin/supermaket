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
</head>
<%
		String str = (String) request.getAttribute("fileName");
		str = "\\Web_SuperMarket\\Upload\\" + str;
	%>
<body id="dt_example" class="example_alt_pagination">
<form name="fom" id="fom" method="post" action="">
<div class="MainDiv">
		<table width="99%" border="0" cellspacing="0" cellpadding="0">
	<tr>
	<img src="<%=str%>">
	</tr>
	<tr>
	<td  colspan="2" align="center" height="30px">
	<input type="button" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" />
								</td>
								</tr>
								</table>
								</div>
								</form>
								
</body>
</html>
