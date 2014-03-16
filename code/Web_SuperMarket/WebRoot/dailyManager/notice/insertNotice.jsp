<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link rel="stylesheet" rev="stylesheet" href="../../css/style.css"
	type="text/css" media="all" />
	<script type="text/javascript" src="../../js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="../../js/jquery.wysiwyg.js"></script>
    <link rel="stylesheet" href="../../css/jquery.wysiwyg.css" type="text/css" />
<script language="JavaScript" type="text/javascript">
	function check() {
		if (document.getElementById("tite").value == "") {
			alert("公告标题不能为空");
			document.getElementById("tite").focus();
			return false;
		}
		if (document.getElementById("date").value== "") {
			alert("发布时间不能为空");
			document.getElementById("date").focus();
			return false;
		}
		if (document.getElementById("con").value == "") {
			alert("公告内容不能为空");
			document.getElementById("con").focus();
			return false;
		}
	}

	function showt(){
	var d = new Date(); 
	var mm;  
 var y= d.getFullYear()+"-";                     
  var m= (d.getMonth() + 1) + "-";         
  var d = d.getDate();               
 
  if(m<10){
  mm="0"+m;
  }else{
  mm=m;
  }
    document.getElementById("date").value=y+mm+d;
  
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
<table width="99%" border="0" cellpadding="0" cellspacing="0"  class="CContent">
	
<tr>
<th class="tablestyle_title">公告录入</th>
</tr>



<tr>
<td class="CPanel"> <table border="0" cellpadding="0"
	cellspacing="0" style="width: 100%">
<tr>
<td width="100%"> <fieldset style="height: 100%">
<legend> 公告录入 </legend>
<form action="insertNotice.do" method="post" onsubmit="return check()">

<table border="0" cellpadding="2" cellspacing="1" style="width: 100%">
<tr>
<td nowrap="nowrap" align="right" width="15%">公告标题:</td>
<td width="35%"><input name='title' type="text" class="text" id="tite"
	style="width: 154px" value="" /> 
</td>
<td width="16%" align="right" nowrap="nowrap">发布部门:</td>
<td width="34%"><input class="text" name='deptName' readonly="readonly"
	style="width: 154px" value="${loginDept}" />
</td>
</tr>
<tr>
<td nowrap="nowrap" align="right" width="15%">发布时间:</td>
<td width="35%"><input name='time' type="text" id = "date" class="text"
	onclick="showt()"  readonly="readonly"

  style="width: 154px" /> 
</td>
<td></td>
<td></td>
</tr>
<tr>
<td align="right">公告内容:</td>
<td colspan="3"><textarea name="content" id="con" cols="100" rows="8"></textarea> 
</td>
</tr>
<tr>
<td align="right">备注:</td>
<td colspan="3"><textarea name="remarks" id="rem" cols="100" rows="6"></textarea>
</td>
</tr>
<tr>
<td align="center" height="50px" colspan="4"> <input type="submit"
	name="Submit" value="提交" class="button" /> 
<input type="button" name="but2" value="返回" class="button"
	onclick="window.history.go(-1);" />
</td>
</tr>
</table>




</form>



</fieldset> </td>
</tr>


</table>
</td>
</tr>
</table>
<script type="text/javascript">
		(function($)
		{
		  $('#con').wysiwyg({
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
		(function($)
		{
		  $('#rem').wysiwyg({
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
