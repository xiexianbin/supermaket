<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>管理页面</title>

<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>

<style>
body {
	font:12px Arial, Helvetica, sans-serif;
	color: #000;
	background:url(../images/lbg.jpg);
	background-repeat:no-repeat
}
#container {
	width: 182px;
}
H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;	
}
H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(images/menu_bgs.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}
.content{
	width: 182px;
	height: 26px;
	
}
.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}
.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 182px;
	padding-left: 0px;
}
.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px,0px,0px,0px);
}
.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}
.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	background-image: url(images/menu_bg2.gif);
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
</style>
</head>
<body>

<table width="98%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB" align="center" style="top:15px;">
<tr>
      <td width="10" height="29"><img src="Left/bg_left_tl.gif"/></td>
    <td width="1237" 
    style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(../images/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system">    </td>
      <td width=11><img src="Left/bg_left_tr.gif"/></td>
</tr>
  <tr>
    <td valign="top" colspan="3">
    <div id="container">
    <c:forEach items="${loginState}" var="state">
	    <c:if test="${state==101}">
	      <h1 class="type"><a href="javascript:void(0)">销售管理</a></h1>
	      <div class="content">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
	          </tr>
	        </table>
	        <ul class="MM">
	          <li><a href="../sales/onSale.jsp" target="rightFrame">销售管理</a></li>
	          <li><a href="../sales/salesList.do" target="rightFrame">账单查询</a></li>
	          <li><a href="../sales/vipList.do" target="rightFrame">会员信息管理</a></li>
	        </ul>
	      </div>
	   </c:if>
	   <c:if test="${state==102}">
	      <h1 class="type"><a href="javascript:void(0)">超市商品管理</a></h1>
	      <div class="content">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
	          </tr>
	        </table>
	        <ul class="MM">
	           <li><a href="../goods/upgoodsList.action" target="rightFrame">商品上架</a></li>
	          <li><a href="../goods/downgoodsList.action" target="rightFrame">商品下架</a></li>
	          <li><a href="../goods/loseList.action" target="rightFrame">报损管理</a>
	          <li><a href="../goods/onsellList.action" target="rightFrame">在售商品查询</a></li>
	          <li><a href="../goods/alarmList.action" target="rightFrame">在售商品报警</a></li>

	        </ul>
	      </div>
	      </c:if>
	      <c:if test="${state==103}">
	      	<h1 class="type"><a href="javascript:void(0)">日常管理</a></h1>
	     	<div class="content">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
	          </tr>
	        </table>
	        <ul class="MM">
	        	<c:if test="${loginDeptId==1000}">	  
	        		<li><a href="../dailyManager/employee/employeeList.do" target="rightFrame">员工管理</a></li>
	        		<li><a href="../dailyManager/part/partList.action" target="rightFrame">部门管理</a></li>
	        		<li><a href="../dailyManager/record/CheckList.action" target="rightFrame">考勤管理</a></li>
	        		<li><a href="../dailyManager/supplier/supplierList.action" target="rightFrame">供应商管理</a></li> 
	        		<li><a href="../dailyManager/goods/productList.action" target="rightFrame">商品管理</a></li>
	        		<li><a href="../dailyManager/storage/storageList.action" target="rightFrame">仓库管理</a></li>
	        		<li><a href="../dailyManager/shelf/shelfList.action" target="rightFrame">货架管理</a></li>
	        		<li><a href="../dailyManager/goodsType/goodsTypeList.do" target="rightFrame">商品类别管理</a></li>  
	        		<li><a href="../dailyManager/gift/giftList.do" target="rightFrame">礼品管理</a></li>
	        		<li><a href="../dailyManager/duty/dutyList.action" target="rightFrame">值日管理</a></li>
	        	</c:if>
	        	<c:if test="${loginDeptId==1001}">
	        		<li><a href="../dailyManager/employee/employeeList.do" target="rightFrame">员工管理</a></li>
	        		<li><a href="../dailyManager/part/partList.action" target="rightFrame">部门管理</a></li>
	        		<li><a href="../dailyManager/record/CheckList.action" target="rightFrame">考勤管理</a></li>
	        	</c:if>
	        	<c:if test="${loginDeptId==1002}">	        	
	        	</c:if>
	        	<c:if test="${loginDeptId==1003}">
	        		<li><a href="../dailyManager/supplier/supplierList.action" target="rightFrame">供应商管理</a></li>
	        	</c:if>
	        	<c:if test="${loginDeptId==1004}">
	        		<li><a href="../dailyManager/goods/productList.action" target="rightFrame">商品管理</a></li>
	        		<li><a href="../dailyManager/storage/storageList.action" target="rightFrame">仓库管理</a></li>
	        		<li><a href="../dailyManager/shelf/shelfList.action" target="rightFrame">货架管理</a></li>
	        		<li><a href="../dailyManager/goodsType/goodsTypeList.do" target="rightFrame">商品类别管理</a></li>
	        	</c:if>
	        	<c:if test="${loginDeptId==1005}">
	        		 <li><a href="../dailyManager/gift/giftList.do" target="rightFrame">礼品管理</a></li>
	        	</c:if>
	        	<c:if test="${loginDeptId==1006}">	        	
	        	</c:if>
	        	<c:if test="${loginDeptId==1007}">
	        		<li><a href="../dailyManager/duty/dutyList.action" target="rightFrame">值日管理</a></li>
         			<li><a href="../dailyManager/shelf/test.action" target="rightFrame">test</a></li>
	        	</c:if>
	        	 <li><a href="../dailyManager/notice/insertNotice.jsp" target="rightFrame">每日提醒</a></li>
	        	 <li><a href="../dailyManager/recordcheck/AllRecord.do" target="rightFrame">考勤查询</a></li>
      		     <li><a href="../dailyManager/notice/noticeList.do" target="rightFrame">查看公告</a></li>
	        	
	        </ul>
	      </div>
	      </c:if>
	      <c:if test="${state==104}">
	      <h1 class="type"><a href="javascript:void(0)">财务管理</a></h1>
	      <div class="content">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
	          </tr>
	        </table>
	        <ul class="MM">
	           <li><a href="../finance/salary/sList.do" target="rightFrame">员工工资管理</a></li>
	          <li><a href="../finance/turnover/turnoverList.action" target="rightFrame">营业额管理</a></li>
	          <li><a href="../finance/outexpense/outexpenseList.action" target="rightFrame">支出管理</a></li>
       		  <li><a href="../finance/inexpense/inexpenseList.action" target="rightFrame">收入管理</a></li>
	          <li><a href="../finance/purchase/purchaseList.do" target="rightFrame">采购统计</a></li>
	          <li><a href="../finance/returnPurch/returnPurchaseList.do" target="rightFrame">采购退货统计</a></li>
	          <li><a href="../finance/productSale/salesList.action" target="rightFrame">销售商品统计</a></li>
	          <li><a href="../finance/returnProductSale/returnProductSale.action" target="rightFrame">销售退货统计</a></li>
	          <li><a href="../finance/empSaleStatistics/empSaleStatisticsList.action" target="rightFrame">销售员销售统计</a></li>
	          <li><a href="../finance/salerank/allproType.action" target="rightFrame">商品销售排行</a></li>                  
	        </ul>
	      </div>
	    </c:if>
		<c:if test="${state==105}">
		  <h1 class="type"><a href="javascript:void(0)">售后管理</a></h1>
	      <div class="content">
	          <table width="100%" border="0" cellspacing="0" cellpadding="0">
	            <tr>
	              <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
	            </tr>
	          </table>
	        <ul class="MM">
	           <li><a href="../afterSale/giftList.action" target="rightFrame">积分兑换</a></li>
	          <li><a href="../afterSale/afterSale.do" target="rightFrame">顾客退货</a></li>
	          <li><a href="../afterSale/record.action" target="rightFrame">售后服务记录查询</a></li>
	          <li><a href="../afterSale/giftRecord.action" target="rightFrame">礼品兑换记录查询</a></li>
	        </ul>
	      </div>
		</c:if>
		<c:if test="${state==106}">
		  <h1 class="type"><a href="javascript:void(0)">进货管理</a></h1>
	      <div class="content">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
	          </tr>
	        </table>
	        <ul class="MM">
	            <li><a href="../purch/purchInsert.jsp" target="rightFrame">采购单录入</a></li>
		          <li><a href="../purch/returnInsert.jsp" target="rightFrame">退购单录入</a></li>
		          <li><a href="../purch/purchList.do" target="rightFrame">采购单查询</a></li>
		          <li><a href="../purch/returnList.do" target="rightFrame">退购单查询</a></li>
	        </ul>
	      </div>
	      </c:if>
	      <c:if test="${state==107}">
	      <h1 class="type"><a href="javascript:void(0)">库存管理</a></h1>
	      <div class="content">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
	          </tr>
	        </table>
	        <ul class="MM">
	            <li><a href="../storage/outStorageList.do" target="rightFrame">出库管理</a></li>
	          <li><a href="../storage/inStorageList.do" target="rightFrame">入库管理</a></li>
	          <li><a href="../storage/storeList.do" target="rightFrame">库存查询</a></li>
	          <li><a href="../storage/alarmList.do" target="rightFrame">报警管理</a></li>
	          <li><a href="../storage/numAlarmList.do" target="rightFrame">库存报警</a></li>


	        </ul>
	      </div>   
	      </c:if> 
	      <c:if test="${state==108}">
	      <h1 class="type"><a href="javascript:void(0)">系统设置</a></h1>
	      <div class="content">
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
	          </tr>
	        </table>
	        <ul class="MM">
	          <li><a href="../systemConfig/stateManager.jsp" target="rightFrame">权限管理</a></li>
	        </ul>
	      </div>
	      </c:if>
    	 </c:forEach>
     </div>
     <script language="javascript" type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
    </td>
  </tr>
  <tr>
      <td width="10" height="29"><img src="../images/bg_left_left.gif"/></td>
     <td width="1237" 
    style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(../images/bg_left_middle.gif); COLOR: white; FONT-FAMILY: system">     </td>
      <td width=11><img src="../images/bg_left_right.gif"/></td>
</tr>

</table>

</body>
</html>
