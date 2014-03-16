<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />

<script type="text/javascript" src="../js/calendar.js"></script>
<script language="JavaScript" type="text/javascript">
function check()
{
 if(window.vip.vipName.value==""){
  alert("你还有未填写的内容");
  window.vip.vipName.focus();
  return false;
  }
  if(window.vip.vipPass.value==""){
  alert("你还有未填写的内容");
  window.vip.vipPass.focus();
  return false;
  }
  if(window.vip.vipAnswer.value==""){
  alert("你还有未填写的内容");
  window.vip.vipAnswer.focus();
  return false;
  }
}
</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>
<script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="../js/jquery.wysiwyg.js"></script>
    <link rel="stylesheet" href="../css/jquery.wysiwyg.css" type="text/css" />
<body class="ContentBody">
  <form action="addVipValue.do" method="post"  name="vip" onsubmit="return check()">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >会员详细信息</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
			<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>会员详细信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td align="right" width="15%">会员编号:</td>
					    <td width="35%"><input name='vipId' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipId}" /><span class="red">#</span></td>
					    <td width="16%" align="right" nowrap="nowrap">会员姓名:</td>
					    <td width="34%"><input class="text" name='vipName' style="width:154px"  value="${onevip.vipName}"/></td>
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">密码:</td>
					    <td><input class="text" name='vipPass' style="width:154px"  value="${onevip.vipPass}"/></td>
					    <td align="right">性别:</td>
					    <td><input class="text" name='vipSex' style="width:154px" readonly="readonly" value="${onevip.vipSex}" /><span class="red">#</span></td>
					  </tr>
					  <tr>
					    <td align="right">出生年月:</td>
					    <td width="35%"><input name='vipBirthday' class="text" id="date" type="text" onclick="new Calendar().show(this);"  style="width:154px"  value="${onevip.vipBirthday}" readonly="readonly"/></td>
					    <td align="right">身份证:</td>
					    <td width="35%"><input name='vipIdNum' type="text" class="text" style="width:154px"  value="${onevip.vipIdNum}" /></td>
					  </tr>
					  <tr>
					    <td align="right">电话:</td>
						<td width="35%"><input name='vipTel' type="text" class="text" style="width:154px"  value="${onevip.vipTel}"/></td>
					    <td align="right">地址:</td>
					    <td width="35%"><input name='vipAddress' type="text" class="text" style="width:154px"  value="${onevip.vipAddress}" /></td>
					  </tr>
					  <tr>
                        <td align="right">邮箱:</td>
					    <td width="35%"><input name='vipEmail' type="text" class="text" style="width:154px"  value="${onevip.vipEmail}" />
							
						</td>
					    <td align="right">QQ:</td>
					    <td width="35%"><input name='vipQQ' type="text" class="text" style="width:154px"  value="${onevip.vipQQ}" /></td>
					    </tr>
					  <tr>
                        <td align="right">余额:</td>
					    <td width="35%"><input name='vipMoney' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipMoney}" /><span class="red">#</span>
							
						</td>
					    <td align="right">积分:</td>
					    <td width="35%"><input name='vipScore' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipScore}" /><span class="red">#</span></td>
					    </tr>
					    <tr>
                        <td align="right">密码提示问题:</td>
					    <td width="35%"><input name='vipQuestion' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipQuestion}" /><span class="red">#</span>
							
						</td>
					    <td align="right">注册时间:</td>
					    <td width="35%"><input name='vipTime' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipTime}" /><span class="red">#</span></td>
					    </tr>
					 
					 <tr>
                        <td align="right">答案:</td>
					    <td width="35%"><input name='vipAnswer' type="text" class="text" style="width:154px"  value="${onevip.vipAnswer}" />
							
						</td>
					    
					    </tr>
					  <tr>
					    <td align="right">备注:</td>
					    <td colspan="3"><textarea name="vipRemarks" id="wysiwyg" rows="8" cols="100" >${onevip.vipRemarks}</textarea></td>
					    <!--<td colspan="3"><textarea name="vipRemarks" cols="100" rows="8"></textarea></td>-->
					    </tr>
					  </table>
			  <br/>
				</fieldset>			
				</TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
  <TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="更新" class="button" />　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
</TABLE>
</div>
</form>
</body>
</html>
<script type="text/javascript">
	
	function aaa()
	{
	var a = document.getElementById("wysiwyg").value;
	alert(a);
	}
    </script>
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

