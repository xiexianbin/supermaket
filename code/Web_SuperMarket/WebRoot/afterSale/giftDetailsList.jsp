<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
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




</script>

	</head>
	<body class="ContentBody">
	
		<form method="post" name="vip">
			
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							礼品兑换详细信息
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
												礼品兑换
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%" >
												
												<tr>
													
													<td width="16%" align="right" nowrap="nowrap">
														礼品编号:
													</td>
													<td width="34%">
														<input class="text" readonly="readonly" name='AfterSaleId' style="width: 154px"
															id="AfterSaleId" value="${gift.giftId}"/>
													
													</td>
													
													<td width="16%" align="right" nowrap="nowrap">
														商品流水号:
													</td>
													<td width="34%">
														<input class="text" name='employeeId' id="employeeId" style="width: 154px"
															value="${gift.purchId}"/>
														
													</td>
													
												</tr>
                                                	              
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														商品名称:
													</td>
													<td width="34%">
														<input class="text" name='productId' style="width: 154px"
															id='productId' value="${gift.productName}"/>
													
													</td>
													
													<td nowrap="nowrap" align="right" width="15%">
														兑换数量:
													</td>
													<td width="34%">
														<input class="text" name='productId' style="width: 154px"
															id='productId' value="${gift.giftCount}"/>
													
													</td>
													
													
													
												</tr>


												<tr>
													<td nowrap="nowrap" align="right">
														操作员:
													</td>
													<td>
														<input class="text" name='time' style="width: 154px"
															value="${gift.employeeId}"/>
													</td>
													<td nowrap="nowrap" align="right">
														兑换时间:
													</td>
													<td>
														<input class="text" name='time' style="width: 154px"
															value="${gift.gifttime}"/>
													</td>
												
													
												</tr>
												<tr>
												
												<td nowrap="nowrap" align="right">
														会员编号:
													</td>
													<td>
														<input class="text" name='time' style="width: 154px"
															value="${gift.vipId}"/>
													</td>
													
												</tr>
												
												<tr>
									
												<td nowrap="nowrap" align="right" width="15%">
														备&nbsp;&nbsp;&nbsp;&nbsp;注:
													</td>
													<td >
														<textarea name="Remarks" id="Remarks" cols="100" rows="8">${gift.remarks}</textarea>
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
			
		</form>
		
	</body>
</html>

