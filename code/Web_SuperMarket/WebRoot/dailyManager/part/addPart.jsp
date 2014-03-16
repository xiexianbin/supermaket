<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link rel="stylesheet" rev="stylesheet" href="../../css/style.css"
			type="text/css" media="all" />

	<script type="text/javascript" src="../../js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="../../js/jquery.wysiwyg.js"></script>
    <link rel="stylesheet" href="../../css/jquery.wysiwyg.css" type="text/css" />
		
	<script language="JavaScript" type="text/javascript">
	function check()
	{
	 if(window.vip.employeeId.value==""){
	  alert("带*为必填内容");
	  window.vip.employeeId.focus();
	  return false;
	  }
	  if(window.vip.deptName.value==""){
	  alert("带*为必填内容");
	  window.vip.deptName.focus();
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
		<form action="addNewPart.action" method="post" name="vip" onsubmit="return check()">
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title"> 
							部门添加 
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
												添加部门
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">

												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														部门编号:
													</td>
													<td width="35%">
														<input name='deptId' readonly="readonly" type="text" class="text"
															style="width: 154px" value="${deptId}" />
														<span class="red">*</span>
													</td>
													<td width="16%" align="right" nowrap="nowrap">
														部门名称:
													</td>
													<td width="34%">
														<input class="text" name='deptName' style="width: 154px"
															value="" /><span class="red">*</span>														
													</td>
												</tr>


												<tr>
													<td nowrap="nowrap" align="right">
														部门经理:
													</td>
													<td>
															<select id="id_employList" name="employeeId">
																	<option value="" selected="selected">==请选择==</option>
																<c:forEach items="${EmployList}" var="employee">
																	<option value="${employee}">${employee}</option>
																</c:forEach>
															</select>
															<span class="red">*</span>
													</td>
													<td align="right">
														部门电话:
													</td>
													<td>
														<input class="text" name='deptTel'
															style="width: 154px" value="" />
													</td>
												</tr>
												<tr>
													<td align="right">
														部门地址:
													</td>
													<td width="35%">
														<input name='deptAddress' type="text" class="text"
															style="width: 154px" value="" /></td>
												</tr>												
												<tr>
													<td align="right">
														备注:
													</td>
													<td colspan="3">
													 <div>
													
														  <textarea name="remarks" id="remarks" rows="5" cols="80" ></textarea>
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
		(function($)
		{
		  $('#remarks').wysiwyg({
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
	</body>
</html>

