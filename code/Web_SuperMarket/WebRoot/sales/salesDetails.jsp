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
							查看销售记录详情
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
												查看销售记录详情
											</legend>
											
											
					<!-- 					
    private int salesId;//销售编号(主键)
	private int purchId;//采购流水号
	private float productPrice;//商品售价
	private int count;//顾客购买的数量
	private int employeeId;//收银员的员工编号
	private String salesTime;//时间
	private String salesWaterNo;//交易流水号（收银员工编号+交易时间）
	private int vipId;//会员Id
	private String payType;//付款方式(现金或刷卡或者网银)
	private String remarks;//备注
							 -->					
											
											
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">
												
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														销售编号:
													</td>
													<td width="35%">
														<input name='salesId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.salesId}" />
													</td>
													
													<td nowrap="nowrap" align="right" width="15%">
														采购流水号:
													</td>
													<td width="35%">
														<input name='productTypeId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.purchId}" />
													</td>
													
													
												</tr>
												
												
												
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														商品名称:
													</td>
													<td width="35%">
														<input name='salesId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.purchId}" />
													</td>
													
													<td nowrap="nowrap" align="right" width="15%">
														商品售价:
													</td>
													<td width="35%">
														<input name='productTypeId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.productPrice}" />
													</td>
												</tr>
												
												
												
																								<tr>
													<td nowrap="nowrap" align="right" width="15%">
														顾客购买的数量:
													</td>
													<td width="35%">
														<input name='salesId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.count}" />
													</td>
													
													<td nowrap="nowrap" align="right" width="15%">
														收银员的员工编号:
													</td>
													<td width="35%">
														<input name='productTypeId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.employeeId}" />
													</td>
												</tr>
												
												
																								<tr>
													<td nowrap="nowrap" align="right" width="15%">
														交易时间:
													</td>
													<td width="35%">
														<input name='salesId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.salesTime}" />
													</td>
													
													<td nowrap="nowrap" align="right" width="15%">
														交易流水号:
													</td>
													<td width="35%">
														<input name='productTypeId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.salesWaterNo}" />
													</td>
												</tr>
												
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														会员Id:
													</td>
													<td width="35%">
														<input name='salesId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.vipId}" />
													</td>
													
													<td nowrap="nowrap" align="right" width="15%">
														付款方式:
													</td>
													<td width="35%">
														<input name='productTypeId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${salesData.payType}" />
													</td>
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
							

							<input type="button" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" />
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>

