<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>超市采购</title>
</head>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<body class="ContentBody">

  <form action="purchUpdate.do" method="post"  name="form"  >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >采购单更新</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		
				<TR>
			<TD width="100%"> 
				<fieldset style="height:100%;">
				<legend>采购信息更新</legend>
				
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  
					  <tr>
					    <td nowrap align="right" width="15%">商品编号:</td>
					    <td width="35%"><input name='productId' class="text" type="text" value="${onePurch.productId}">
					    <td width="16%" align="right" nowrap="nowrap">采购时间:</td>
					    <td width="34%"><input class="text" name='purchTime' value="${onePurch.purchTime}"></td>
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">商品进价:</td>
					    <td><input class="text" name='inPrice' value="${onePurch.inPrice}"></td>
					    <td align="right">采购数量:</td>
					    <td><input class="text" name='purchCount' value="${onePurch.purchCount}"></td>
					  </tr>
					  <tr>
					    <td nowrap="nowrap" align="right">生产时间:</td>
					    <td><input class="text" name='productTime' value="${onePurch.productTime}"></td>
					    <td align="right">过期时间:</td>
					    <td><input class="text" name='expireTime'value="${onePurch.expireTime}"></td>
					  </tr>
					  <tr>
					    <td nowrap="nowrap" align="right">员工编号:</td>
					    <td><input class="text" name='employeeId'value="${onePurch.employeeId}" ></td>
					    <td align="right">供货商编号:</td>
					    <td><input class="text" name='companyId'value="${onePurch.companyId}"></td>
					  </tr>
					  <tr>
					    <td nowrap="nowrap" align="right">采购流水号:</td>
					    <td><input class="text" name='purchId' value="${onePurch.purchId}"  readonly="readonly"></td>
					  </tr>
					 
					  <tr>
					    <td align="right">备&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
					    <td colspan="3"><textarea name="remarks" cols="100" rows="5" >${onePurch.remarks}</textarea></td>
					    </tr>
					    
					  </table>
					  
					  
			  <br />
				</fieldset>			</TD>
			
		</TR>
		
		
		</TABLE>
	
	 </td>
  </tr>
  
		
		<tr>
			<td colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="更新" class="button" onclick="alert('更新成功！');"/>　
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
			</td>
		</tr>
		</table>
	
	
	 <br>
  
</div>
</form>

</body>
  
</html>
