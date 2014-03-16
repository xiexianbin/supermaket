<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link rel="stylesheet" rev="stylesheet" href="../css/style.css"
			type="text/css" media="all" />

<script type="text/javascript" src="../js/calendar.js"></script>
<script type="text/javascript" src="js/Ajax.js"></script>

	<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="../js/jquery.wysiwyg.js"></script>
	<link rel="stylesheet" href="../css/jquery.wysiwyg.css" type="text/css" />
	
<script language="JavaScript" type="text/javascript">
function check()
{
 if(window.outstorage.purchId.value==""){
  alert("带*为必填内容");
  window.outstorage.purchId.focus();
  return false;
  }
  if(window.outstorage.storageId.value==""){
  alert("带*为必填内容");
  window.outstorage.storageId.focus();
  return false;
  }
  if(window.outstorage.employeeId.value==""){
  alert("带*为必填内容");
  window.outstorage.employeeId.focus();
  return false;
  }
   if(window.outstorage.outNum.value==""){
  alert("带*为必填内容");
  window.outstorage.outNum.focus();
  return false;
  }
}

	
function checkNum1(){
	//alert("111");
	var outNum=document.getElementById("outNum").value;
	//alert(outNum);
	if (isNaN(outNum))
	{
		alert("非法字符！");
		document.getElementById("outNum").value="";
		document.getElementById("outNum").focus();
		
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
		<form action="addOutStorage.do" method="post" name="outstorage" onsubmit="return check()">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							出库信息录入
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
												添加出库信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">

												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														采购流水号:
													</td>
													<td width="35%">
														<input name='purchId' type="text" class="text" id="purchId"
															style="width: 154px" onblur="JavaScript:addIn_selectInf();"/>
														<span class="red">*</span>
													</td>
													
													<td nowrap="nowrap" align="right" width="15%">
														仓库编号:
													</td>
													<td width="35%">
													<select name='storageId' class="text" style="width: 154px">
													<option value="">==   请选择    ==</option>
													<c:forEach items="${storageIdList}" var="sId">
													<option value="${sId}">${sId}</option>
													</c:forEach>
													</select>
														<span class="red">*</span>
													</td>
													
												</tr>
												
												
												<tr>
													<td nowrap="nowrap" align="right">
														商品编号:
													</td>
													<td>
														<input class="text" name='productId' id="productId" style="width: 154px"
															readonly="readonly" value="" />
													</td>
													<td align="right">
														商品名称:
													</td>
													<td>
														<input class="text" name='productName' id="productName" readonly="readonly"
															style="width: 154px" value="" />
													</td>
												</tr>
												
												<tr>
													<td align="right">
														负责人编号:
													</td>
													<td width="35%">
														<input name='employeeId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${employeeId}" />
															</td>
														<td align="right">
															负责人姓名:
														</td>
														<td width="35%">
															<input name='employeeName' type="text" class="text" readonly="readonly"
																style="width: 154px" value="${employeeName}" /></td>
												</tr>
												
												<tr>
													<td align="right">
														出库数量:
													</td>
													<td width="35%">
														<input name='outNum' id='outNum' type="text" class="text" onblur="JavaScript:checkNum1();"
															style="width: 154px" value="" />
															<span class="red">*</span>
															</td>
														<td align="right">
															出库时间:
														</td>
														<td width="35%">
														<input name='outTime' type="text" class="text" id="date" onclick="new Calendar().show(this);" readonly="readonly" style="width: 154px"/>
														</td>
												</tr>
												
												<tr>
													<td align="right">
														出库去向:
													</td>
													<td colspan="3">
														<input name='outDirection' type="text" class="text" style="width: 75%" value="" />
															</td>
												</tr>
												
												<tr>
													<td align="right">
														出库原因:
													</td>
													<td colspan="3">
														<div>
														<textarea name="reason" id="remarks" rows="7" cols="100"></textarea>
														</div>
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
		
		<script type="text/javascript">
		(function($) {
			$('#remarks').wysiwyg({
				controls : {
					strikeThrough : {
						visible : true
					},
					underline : {
						visible : true
					},

					separator00 : {
						visible : true
					},

					justifyLeft : {
						visible : true
					},
					justifyCenter : {
						visible : true
					},
					justifyRight : {
						visible : true
					},
					justifyFull : {
						visible : true
					},

					separator01 : {
						visible : true
					},

					indent : {
						visible : true
					},
					outdent : {
						visible : true
					},

					separator02 : {
						visible : true
					},

					subscript : {
						visible : false
					},
					superscript : {
						visible : false
					},

					separator03 : {
						visible : false
					},

					undo : {
						visible : false
					},
					redo : {
						visible : false
					},

					separator04 : {
						visible : false
					},

					insertOrderedList : {
						visible : true
					},
					insertUnorderedList : {
						visible : true
					},
					insertHorizontalRule : {
						visible : true
					},

					h4mozilla : {
						visible : false && $.browser.mozilla,
						className : 'h4',
						command : 'heading',
						arguments : [ 'h4' ],
						tags : [ 'h4' ],
						tooltip : "Header 4"
					},
					h5mozilla : {
						visible : false && $.browser.mozilla,
						className : 'h5',
						command : 'heading',
						arguments : [ 'h5' ],
						tags : [ 'h5' ],
						tooltip : "Header 5"
					},
					h6mozilla : {
						visible : false && $.browser.mozilla,
						className : 'h6',
						command : 'heading',
						arguments : [ 'h6' ],
						tags : [ 'h6' ],
						tooltip : "Header 6"
					},

					h4 : {
						visible : false && !($.browser.mozilla),
						className : 'h4',
						command : 'formatBlock',
						arguments : [ '<H4>' ],
						tags : [ 'h4' ],
						tooltip : "Header 4"
					},
					h5 : {
						visible : false && !($.browser.mozilla),
						className : 'h5',
						command : 'formatBlock',
						arguments : [ '<H5>' ],
						tags : [ 'h5' ],
						tooltip : "Header 5"
					},
					h6 : {
						visible : false && !($.browser.mozilla),
						className : 'h6',
						command : 'formatBlock',
						arguments : [ '<H6>' ],
						tags : [ 'h6' ],
						tooltip : "Header 6"
					},

					separator07 : {
						visible : false
					},

					cut : {
						visible : false
					},
					copy : {
						visible : false
					},
					paste : {
						visible : false
					}
				}
			});
		})(jQuery);
	</script>
	</body>
</html>

