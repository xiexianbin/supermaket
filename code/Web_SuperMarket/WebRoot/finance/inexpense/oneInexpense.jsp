<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


</head>
<script type="text/javascript">
	function updateInexpense(id) {
		var check = window.confirm("确定更新吗？");
		if (check) {
			location.replace("selectOneInexpense.do?inExpenId=" + id);
		}
	}
</script>
<body>
	<center>
		<a href="inexpenseInsert.jsp"> <font size="7" face="Verdana">
				录入收入信息 </font> </a>
		<table width="100%" style="margin-top:5px; margin-bottom: 5px"
			border="0" cellpadding="4" cellspacing="1" bgcolor="#6898B9"
			class="newfont03" class="display" id="example">


			<thead>
				<tr>
					<th style="color:#fff">收入流水号</th>
					<th style="color:#fff">员工编号</th>
					<th style="color:#fff">收入原因</th>
					<th style="color:#fff">金额</th>
					<th style="color:#fff">时间</th>
					<th style="color:#fff">备注</th>
					<th style="color:#fff">操作</th>
				</tr>
			</thead>

			<tr>
				<td align="center">${inexpense.inExpenId}</td>
				<td align="center">${inexpense.employeeId}</td>
				<td align="center">${inexpense.inReason}</td>
				<td align="center">${inexpense.money}</td>
				<td align="center">${inexpense.inDate}</td>
				<td align="center">${inexpense.remarks}</td>


				<td><a
					href="javascript:updateInexpense('${inexpense.inExpenId}')">修改</a>

				</td>
			</tr>
		</table>

	</center>

</body>
</html>
