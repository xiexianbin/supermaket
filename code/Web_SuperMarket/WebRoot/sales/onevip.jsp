<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="addVip.do" method="post"  name="vip" >
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
					    <td width="35%"><input name='vipId' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipId}" />
					    <td width="16%" align="right" nowrap="nowrap">会员姓名:</td>
					    <td width="34%"><input class="text" name='vipName' style="width:154px" readonly="readonly" value="${onevip.vipName}"/></td>
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">密码:</td>
					    <td><input class="text" name='vipPass' style="width:154px" readonly="readonly" value="${onevip.vipPass}"/></td>
					    <td align="right">性别:</td>
					    <td><input class="text" name='vipSex' style="width:154px" readonly="readonly" value="${onevip.vipSex}" /></td>
					  </tr>
					  <tr>
					    <td align="right">出生年月:</td>
					    <td width="35%"><input name='vipBirthday' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipBirthday}" /></td>
					    <td align="right">身份证:</td>
					    <td width="35%"><input name='vipIdNum' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipIdNum}" /></td>
					  </tr>
					  <tr>
					    <td align="right">电话:</td>
						<td width="35%"><input name='vipTel' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipTel}"/></td>
					    <td align="right">地址:</td>
					    <td width="35%"><input name='vipAddress' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipAddress}" /></td>
					  </tr>
					  <tr>
                        <td align="right">邮箱:</td>
					    <td width="35%"><input name='vipEmail' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipEmail}" />
							
						</td>
					    <td align="right">QQ:</td>
					    <td width="35%"><input name='vipQQ' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipQQ}" /></td>
					    </tr>
					  <tr>
                        <td align="right">余额:</td>
					    <td width="35%"><input name='vipMoney' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipMoney}" />
							
						</td>
					    <td align="right">积分:</td>
					    <td width="35%"><input name='vipScore' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipScore}" /></td>
					    </tr>
					    <tr>
                        <td align="right">密码提示问题:</td>
					    <td width="35%"><input name='vipQuestion' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipQuestion}" />
							
						</td>
					    <td align="right">注册时间:</td>
					    <td width="35%"><input name='vipTime' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipTime}" /></td>
					    </tr>
					 
					 <tr>
                        <td align="right">答案:</td>
					    <td width="35%"><input name='vipAnswer' type="text" class="text" style="width:154px" readonly="readonly" value="${onevip.vipAnswer}" />
							
						</td>
					    
					    </tr>
					  <tr>
					    <td align="right">备注:</td>
					    <td colspan="3"><textarea name="vipRemarks" cols="100" rows="8" readonly="readonly">${onevip.vipRemarks}</textarea></td>
					    </tr>
					  </table>
			  <br/>
				</fieldset>			
				</TD>
		</TR>
		</TABLE>
	 </td>
  </tr>
</TABLE>
</div>
</form>
</body>
</html>

