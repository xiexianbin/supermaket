<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<script type="text/javascript" src="../../js/calendar.js"></script>

	</head>
	

  
	<body class="ContentBody">
		<form action="updateOne.do" method="post" name="vip">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							礼品信息修改
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
												修改礼品信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">
												
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														礼品编号:
													</td>
													<td width="35%">
														<input name='giftId' type="text" class="text"
															style="width: 154px" readonly="readonly" value="${giftBean.giftId}" />
														
													</td>
													<td width="16%" align="right" nowrap="nowrap">
														商品编号:
													</td>
													<td width="34%">
														<input class="text" name='productId' style="width: 154px"
															id='productId' value="${giftBean.productId}" />
														
													</td>
												</tr>

												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														商品名称:
													</td>
													<td width="35%">
														<input name='productName' type="text" class="text"
															style="width: 154px" id="productName" onclick="show()" readonly="readonly"
															value="${giftBean.productName}"/>
														
													</td>
													<td width="16%" align="right" nowrap="nowrap">
														商品类别:
													</td>
													<td width="34%">
														<input class="text" name='productTypeName' style="width: 154px"
															readonly="readonly" value="${giftBean.productTypeName}"/>
														
													</td>
												</tr>


												<tr>
													<td nowrap="nowrap" align="right">
														商品价格:
													</td>
													<td>
														<input class="text" name='productPrice' style="width: 154px"
															readonly="readonly"	value="${giftBean.productPrice}"/>
													</td>
													<td align="right">
														所需积分:
													</td>
													<td>
														<input class="text" name='score'
															style="width: 154px" value="${giftBean.score}" />
													</td>
												</tr>
												<tr>
													<td align="right">
														操作员:
													</td>
													<td width="35%">
														<input name='vipIdNum' type="text" class="text"
														readonly="readonly"	style="width: 154px" value="${loginName}" /></td>
														<td align="right">
															修改时间:
														</td>
														<td width="35%">
															<input name="date" type="text" id="date" class="text"
															style="width: 154px"
															value="${time}" readonly="readonly" /></td>
												</tr>
												<tr>
													<td align="right">
														备注:
													</td>
													<td colspan="3">
														<textarea name="Remarks" cols="100" rows="8">${giftBean.remarks}</textarea>
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
							<input type="submit" name="Submit" value="提交" class="button" ;"/>

							<input type="button" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" />
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>

