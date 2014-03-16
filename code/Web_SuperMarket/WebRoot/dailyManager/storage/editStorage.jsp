<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link rel="stylesheet" rev="stylesheet" href="../../css/style.css"
			type="text/css" media="all" />


		<script language="JavaScript" type="text/javascript">
function check()
{
 if(window.vip.storageAddress.value==""){
  alert("带*为必填内容");
  window.vip.storageAddress.focus();
  return false;
  }
  if(window.vip.employeeId.value==""){
  alert("带*为必填内容");
  window.vip.employeeId.focus();
  return false;
  }
}
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
		<form action="updateStorage.action" method="post" name="vip" onsubmit="return check()">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							修改仓库信息
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
												修改仓库信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">

												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														仓库编号:
													</td>
													<td width="35%">
														<input name='storageId' readonly="readonly" type="text" class="text"
															style="width: 154px" value="${Storage.storageId}" />
														<span class="red">*</span>
													</td>
													<td width="16%" align="right" nowrap="nowrap">
														仓库地址:
													</td>
													<td width="34%">
														<input class="text" name='storageAddress' style="width: 154px"
															value="${Storage.storageAddress}" />
														<span class="red">*</span>
													</td>
												</tr>


												<tr>
													<td nowrap="nowrap" align="right">
														仓库面积:
													</td>
													<td>
														<input class="text" name='storageArea' style="width: 154px"
															value="${Storage.storageArea}" />
													</td>
													<td align="right">
														仓库类型:
													</td>
													<td>
														<input class="text" name='storageType'
															style="width: 154px" value="${Storage.storageType}" />
													</td>
												</tr>
												<tr>
													<td align="right">
														负责人:
													</td>
													<td width="35%">
															<select id="id_employList" name="employeeId">
																	<option value="" selected="selected">==请选择==</option>
																<c:forEach items="${EmployeeList}" var="employee">
																	<c:if test="${Name==employee}">
																		<option selected="selected" value="${employee}">${employee}</option>
																	</c:if>
																	<c:if test="${Name!=employee}">
																		<option value="${employee}">${employee}</option>
																	</c:if>
																</c:forEach>
															</select>
															<span class="red">*</span>
													</td>
												</tr>
												<tr>
													<td align="right">
														备注:
													</td>
													<td colspan="3">
														<textarea name="remarks" cols="100" rows="8">${Storage.remarks}</textarea>
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

