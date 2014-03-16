<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
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
</head>

<body class="ContentBody">


	<table width="98%" border="0" cellpadding="0" cellspacing="0"
		class="CContent">
		<tr>
			<th class="tablestyle_title">${notbean.noticeTitle}</th>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td width="16%" align="center" nowrap="nowrap" style="font-size:12px">发布部门:${notbean.deptName}&nbsp;
				发布时间:${notbean.noticeTime}&nbsp; 浏览次数:${notbean.lookCount}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="left">
				<div style="margin: 20px 30px 20px 30px; font-size: 16px; line-height: 30px; ">
				<p>
					${notbean.noticeContent}
				</p>
				</div>
			</td>


		</tr>

		<tr>
			<td>&nbsp;</td>
		</tr>

		<tr>

			<td align="left"><p>&nbsp;&nbsp;&nbsp; 备注:${notbean.remarks}
				</p>
			</td>


		</tr>


		<tr>
			<td>
				<div id="dd1" style="position:center;display: none;"></div>
			</td>
		</tr>
	</table>

</body>
</html>

