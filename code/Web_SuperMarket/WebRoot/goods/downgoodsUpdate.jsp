<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


		<script language="JavaScript" type="text/javascript">
		function check()
		{
		 if(window.vip.vipName.value==""){
		  alert("带*为必填内容");
		  window.vip.vipName.focus();
		  return false;
		  }
		  if(window.vip.vipPass.value==""){
		  alert("带*为必填内容");
		  window.vip.vipPass.focus();
		  return false;
		  }
		  if(window.vip.vipAnswer.value==""){
		  alert("带*为必填内容");
		  window.vip.vipAnswer.focus();
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
	
		<form action="downgoodsUpdate.action" method="post">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							商品下架信息修改
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
												修改商品下架信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">

												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														流水号:
													</td>
													<td width="35%">
														<input name='serialId' type="text" class="text"
															style="width: 154px" value="${downgoods.serialId}" readonly="readonly" />
														<span class="red">*</span>
													</td>
													<td width="16%" align="right" nowrap="nowrap">
														商品编号:
													</td>
													<td width="34%">
														<input class="text" name='purchId' style="width: 154px"
															value="${downgoods.purchId}" readonly="readonly"/>
														<span class="red">*</span>
													</td>
												</tr>


												<tr>
													<td nowrap="nowrap" align="right">
														员工编号:
													</td>
													<td>
														<input class="text" name='employeeId' style="width: 154px"
															value="${downgoods.employeeId}" />
													</td>
													<td align="right">
														下架数量:
													</td>
													<td>
														<input class="text" name='downCount'
															style="width: 154px" value="${downgoods.downCount}" />
													</td>
												</tr>
												<tr>
													<td align="right">
														备注:
													</td>
													<td colspan="3">
														<textarea name="remarks" cols="100" rows="8" >${downgoods.remarks}</textarea>
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


