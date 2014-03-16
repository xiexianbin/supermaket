<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<SCRIPT language=JavaScript>
	
	function Todate(){
     if(document.getElementById("year").value==""){
     alert(请输入年份);
	document.getElementById("year").focus();
     }
    else if(document.getElementById("month").value==""){
    alert(请选择月份);
     }else{
var vas=document.getElementById("year").value+"-"+document.getElementById("month").value;

  location.replace("oneproType.do?datime="+vas);
}
}
</SCRIPT>

<body>
<table width="99%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="20" align="right"><input type="text" id="year">
      年
      <select  id="month">
        <option value="">请选择月份</option>
        <option value="1">01</option>
        <option value="2">02</option>
        <option value="3">03</option>
        <option value="4">04</option>
        <option value="5">05</option>
        <option value="6">06</option>
        <option value="7">07</option>
        <option value="8">08</option>
        <option value="9">09</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
      </select>
      月
      <input type="button" onclick="Todate()" value="按月查询"></td>
  </tr>
  <tr>
    <td align="center">${time}销售排行列表</td>
  </tr>
  <tr>
    <td align="right"><input type="button" value="查看饼状图"></td>
  </tr>
  <tr>
    <td><table border="1" cellspacing="0" align="center">
        <tr>
          <th>商品类别编号</th>
          <th>商品类别名称</th>
          <th >商品编号</th>
          <th>商品名称</th>
          <th >月销售量</th>
        </tr>
        <c:forEach items="${protype}" var="pro">
          <tr>
            <td align="center"><input type="text" style="border: 0;list-style-position: center"  value="${pro.proTyId}" readonly="readonly" name="protyId"></td>
            <td align="center"><input type="text" style="border: 0;"  value="${pro.proTyName}" readonly="readonly" name="protyName"></td>
            <td align="center"><input type="text" style="border: 0"  value="${pro.proId}" readonly="readonly" name="proId"></td>
            <td align="center"><input type="text" style="border: 0"  value="${pro.proName}" readonly="readonly" name="proName"></td>
            <td align="center"><input type="text" style="border: 0"  value="${pro.sumcount}" readonly="readonly" name="sumcount"></td>
          </tr>
        </c:forEach>
      </table></td>
  </tr>
</table>
</body>
</html>