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
	</head>

	<body class="ContentBody">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							库存信息
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
												库存信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">
												
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														库存编号:
													</td>
													<td width="35%">
														<input name='storeId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${store.storeId}" />
													</td>
													<td nowrap="nowrap" align="right" width="15%">
														采购流水号:
													</td>
													<td width="35%">
														<input name='purchId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${store.purchId}" />
													</td>
													
													</tr>

												<tr>
													
													<td nowrap="nowrap" align="right" width="15%">
														仓库编号:
													</td>
													<td width="35%">
														<input name='storageId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${store.storageId}" />
													</td>
													<td nowrap="nowrap" align="right">
														商品编号:
													</td>
													<td>
														<input class="text" name='productId' style="width: 154px" readonly="readonly"
															value="${store.productId}" />
													</td>
												</tr>
												

												<tr>
													<td align="right">
														商品名称:
													</td>
													<td>
														<input class="text" name='productName' readonly="readonly"
															style="width: 154px" value="${store.productName}" />
													</td>
													<td align="right">
														库存数量:
													</td>
													<td width="35%">
														<input name='remainNum' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${store.remainNum}" />
															</td>
												</tr>
												
												<tr>
													<td align="right">
														生产日期:
													</td>
													<td>
														<input class="text" name='productTime' readonly="readonly"
															style="width: 154px" value="${store.productTime}" />
													</td>
													<td align="right">
														过期时间:
													</td>
													<td width="35%">
														<input name='expireTime' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${store.expireTime}" />
															</td>
												</tr>
												
												<tr>
													<td align="right">
														备注:
													</td>
													<td colspan="3">
														<textarea name="remarks" cols="100" rows="8" readonly="readonly">${store.remarks}</textarea>
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
	</body>
</html>

