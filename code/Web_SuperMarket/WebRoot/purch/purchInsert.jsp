<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>超市采购</title>
  	<link type="text/css" href="../css/ui.all.css" rel="stylesheet" />
	<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="../js/ui.core.js"></script>
	<script type="text/javascript" src="../js/ui.datepicker.js"></script>
	<script type="text/javascript" src="../js/ui.datepicker-zh-CN.js"></script>
	<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
</head>
<script type="text/javascript" src="../js/ajax.js"> </script>
<script type="text/javascript" src="../js/calendar.js"></script>

<script type="text/javascript">

function getTimes(){
	var date=new Date();
	var year=date.getFullYear();
	var month=date.getMonth()+1;
	var days=date.getDate();
	
	document.getElementById("purchTime").value=year+'-'+month+'-'+days;
}

</script>

<body class="ContentBody" onload="getTimes()">

  <form action="insertPurch.do" method="post"  name="form"  >
<div id="divTab"  >
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >采购单录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		
				<TR>
			<TD width="100%"> 
				<fieldset style="height:100%;">
				<legend>采购信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="15%">商品编号:</td>
					    <td width="35%"><input name='productId' class="text" type="text" id="select1" onblur="selectName()">
					    <td align="right">商品名称:</td>
					    <td><input class="text" name='productName' id="select2"  readonly="readonly"></td>
					  </tr>
					  <tr>
					    <td nowrap="nowrap" align="right">供货商编号:</td>
					    <td><input class="text" name='companyId' id="select3"  onblur="selectName1()"></td>
					    <td align="right">供货商名称:</td>
					    <td><input class="text" name='companyName'id="select4" readonly="readonly"></td>
					  </tr>
					   <tr>
					    <td nowrap="nowrap" align="right" >员工编号:</td>
					    <td><input class="text" name='employeeId' id="select5" onblur="selectName2()"></td>
					    <td align="right">员工名字:</td>
					    <td><input class="text" name='employeeName' id="select6" readonly="readonly"></td>
					  </tr>
					   
					  <tr>
					    <td nowrap="nowrap" align="right">商品进价:</td>
					    <td><input class="text" name='inPrice' id="select7"></td>
					    <td align="right">采购数量:</td>
					    <td><input class="text" name='purchCount'></td>
					  </tr>
					  <tr>
					    <td nowrap="nowrap" align="right">生产时间:<td><input name='productTime' class="text" type="text" id="date" onclick="new Calendar().show(this);" readonly="readonly" /></td></td>
					    <td align="right">过期时间:<td><input name='expireTime' class="text" type="text" id="date" onclick="new Calendar().show(this);" readonly="readonly" /></td></td>
					  </tr>
					  <td width="16%" align="right" nowrap="nowrap">采购时间:<td><input name='purchTime' id="purchTime" type="text" class="text" readonly="readonly" /></td></td>
					  <tr>
					  
					 </tr>
					  <tr>
					 
					    <td align="right">备&nbsp;&nbsp;&nbsp;&nbsp;注:<td colspan="3"><textarea name='remarks' id="wysiwyg" rows="5" cols="80" ></textarea></td></td>
					   </tr>
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
					   
					    
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		
		</TABLE>
	
	 </td>
  </tr>
  
		
		<tr>
			<td colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
			</td>
		</tr>
		</table>
	
	
	 <br>
  
</div>
</form>

</body>
  
</html>
