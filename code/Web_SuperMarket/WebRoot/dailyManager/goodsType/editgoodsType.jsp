<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link rel="stylesheet" rev="stylesheet" href="../css/style.css"
			type="text/css" media="all" />

<title>jQuery UI Datepicker - Display month &amp; year menus</title>
	<link type="text/css" href="../css/ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="../js/ui.core.js"></script>
	<script type="text/javascript" src="../js/ui.datepicker.js"></script>
	<script type="text/javascript" src="../js/ui.datepicker-zh-CN.js"></script>
	<script type="text/javascript">
	$(function() {
		$('#datepicker').datepicker({
			changeMonth: true,
			changeYear: true
		});
	});
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
		<form action="updateGoodsType.do" method="post">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							商品类别信息修改
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
												修改商品类别信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">
												
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														商品类别编号:
													</td>
													<td width="35%">
														<input name='productTypeId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${goodstypeData.productTypeId}" />
													</td>
													</tr>

												<tr>
													<td nowrap="nowrap" align="right">
														商品类别名称:
													</td>
													<td>
														<input class="text" name='productTypeName' style="width: 154px"
															value="${goodstypeData.productTypeName}" />
												
												</tr>
												
												
														<tr>
													<td align="right">
														备注:
													</td>
													<td colspan="3">
														<textarea name="remarks" cols="100" rows="8" ></textarea>
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

