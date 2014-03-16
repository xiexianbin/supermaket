<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link href="../../css/demos.css" rel="stylesheet" type="text/css" />
	<link href="../../css/css.css" rel="stylesheet" type="text/css" />
	<link href="../../css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../../js/xiangmu.js"></script>
	<script type="text/javascript" language="javascript"
		src="../../js/jquery.js"></script>
	<script type="text/javascript" language="javascript"
		src="../../js/jquery.dataTables.js"></script>
	<script type="text/javascript" charset="GBK">
		$(document).ready(function() {
			$('#example').dataTable({
				"sPaginationType" : "full_numbers"
			});
		});
	</script>
</head>
<SCRIPT language=JavaScript>
	function sousuo() {
		window
				.open(
						"gaojisousuo.htm",
						"",
						"depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	


	
	function Todate(){
     if(document.getElementById("year").value==""){
     alert("请输入年份");
	
     }
    else if(document.getElementById("month").value==""){
    alert("请选择月份");
     }else{
var vas=document.getElementById("year").value+"-"+document.getElementById("month").value;

  location.replace("oneproType.do?datime="+vas);
}
}

function checkTu(){
location.replace("checkTu.do");
}
</SCRIPT>

<body>
<table width="99%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="20" align="right"><select  id="year"><option value="">请选择年份</option><option value="2010">2010</option>
								<option value="2011">2011</option><option value="2012">2012</option><option value="2013">2013</option><option value="2014">2014</option><option value="2015">2015</option><option value="2016">2016</option><option value="2017">2017</option>
								<option value="2018">2018</option><option value="2019">2019</option><option value="2020">2020</option><option value="2021">2021</option><option value="2022">2022</option><option value="2023">2023</option><option value="2024">2024</option>
								<option value="2025">2025</option><option value="2026">2026</option><option value="2027">2027</option><option value="2028">2028</option><option value="2029">2029</option><option value="2030">2030</option></select>年
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
      <input type="button" class="right-button08" onclick="Todate()" value="按月查询"></td>
  </tr>
  <tr>
    <td align="center">${time}销售排行列表</td>
  </tr>
  <tr>
    <td align="right"><input type="button" class="right-button08" value="查看饼状图" onclick="checkTu()"></td>
  </tr>
  <tr>
    <td><table border="1" cellspacing="0" align="center">
        <tr>
          <th>商品类别编号</th>
          <th>商品类别名称</th>
          <th>商品编号</th>
          <th>商品名称</th>
          <th>月销售量</th>
        </tr>
        <c:forEach items="${protype}" var="pro">
          <tr>
            <td align="center"><input type="text" style="border: 0"  value="${pro.proTyId}" readonly="readonly" name="protyId"></td>
            <td align="center"><input type="text" style="border: 0"  value="${pro.proTyName}" readonly="readonly" name="protyName"></td>
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