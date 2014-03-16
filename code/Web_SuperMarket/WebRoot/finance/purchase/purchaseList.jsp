<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
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
	function selectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}

	function unselectAll() {
		var obj = document.fom.elements;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}
		function set_Year(year){
		
		for(var i =2010;i<=2030;i++){
			var option = new Option(); 
			option.text = i;
			option.value = i;
			document.getElementById("id_year").options.add(option);
		}
		var n = year-2010;
		document.getElementById("id_year").options[n].selected="selected";
	}
	function set_Month(month){
	
		for(var i =0;i<=12;i++){
			var option = new Option(); 
			if(i==0){
				option.text = "请选择";
				option.value = "";
			}else{
				option.text = i;
				option.value = i;
			}
			document.getElementById("id_month").options.add(option);
		}
		var n = month;
		document.getElementById("id_month").options[n].selected="selected";
	}
	function set_Day(day){
	
		for(var i =0;i<=31;i++){
			var option = new Option(); 
			if(i==0){
				option.text = "请选择";
				option.value = "";
			}else{
				option.text = i;
				option.value = i;
			}
			document.getElementById("id_day").options.add(option);
		}
		var n = day-1+1;
		document.getElementById("id_day").options[n].selected="selected";
	}
	function setNewDay(){
		var year = document.getElementById("id_year").value;
		var month = document.getElementById("id_month").value;
		if(month!=""){
			if(month==4||month==6||month==9||month==11){
				document.getElementById("id_day").length = 0;
				for(var i =0;i<=30;i++){
					var option = new Option(); 
					if(i==0){
						option.text = "请选择";
						option.value = "";
					}else{
						option.text = i;
						option.value = i;
					}
					document.getElementById("id_day").options.add(option);
				}
			}else if(month==2){
				document.getElementById("id_day").length = 0;
				if((year%400==0)||(year%4==0 && year%100!=0)){
					for(var i =0;i<=29;i++){
						var option = new Option(); 
						if(i==0){
							option.text = "请选择";
							option.value = "";
						}else{
							option.text = i;
							option.value = i;
						}
						document.getElementById("id_day").options.add(option);
					}
				}else{
					for(var i =0;i<=28;i++){
						var option = new Option(); 
						if(i==0){
							option.text = "请选择";
							option.value = "";
						}else{
							option.text = i;
							option.value = i;
						}
						document.getElementById("id_day").options.add(option);
					}
				}
			}else{
				document.getElementById("id_day").length = 0;
				for(var i =0;i<=31;i++){
					var option = new Option(); 
					if(i==0){
						option.text = "请选择";
						option.value = "";
					}else{
						option.text = i;
						option.value = i;
					}
					document.getElementById("id_day").options.add(option);
				}
			}
		}else{
			document.getElementById("id_day").length = 0;
			var option = new Option(); 
			option.text = "请选择";
			option.value = "";
			document.getElementById("id_day").options.add(option);
		}
	}
	function ShowElements(time){
		var t=time.split("-");
		var day=t[2];
		var month=t[1];
		var year=t[0];
		set_Year(year);
		set_Month(month);
		set_Day(day);
	}
	function search(){
		var year=document.getElementById("id_year").value;
		var month=document.getElementById("id_month").value;
		var day=document.getElementById("id_day").value;
		var datetime = year;
		if(month!=""){
			datetime+="-";
			if(month<10){
				datetime+="0";
			}
			datetime+=month;
		}
		if(day!=""){
			datetime+="-";
			if(day<10){
				datetime+="0";
			}
			datetime+=day;
		}
		window.location.replace("purchaseList.action?datetime="+datetime);
	}
	
	function search1(){
		var year=document.getElementById("id_year").value;
		var month=document.getElementById("id_month").value;
		var day=document.getElementById("id_day").value;
		var datetime = year;
		if(month!=""){
			datetime+="-";
			if(month<10){
				datetime+="0";
			}
			datetime+=month;
		}
		if(day!=""){
			datetime+="-";
			if(day<10){
				datetime+="0";
			}
			datetime+=day;
		}
		window.location.replace("purchaseBar.action?datetime="+datetime);
	}
	
</SCRIPT>

<body id="dt_example" class="example_alt_pagination" onload="ShowElements('${TIME}')">
	<form name="fom" id="fom" method="post" action="">
		<table width="99%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table id="subtree1" style="DISPLAY: " width="100%" border="0"
						cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="20"><a style="margin-left: 3%"></a><span class="newfont07">选择：<a	href="#" class="right-font08" onclick="selectAll();">全选</a>-<a
												href="" class="right-font08" onclick="unselectAll();">反选</a>
													<select id="id_year" onchange="setNewDay()">
													</select>年
													<select  id="id_month" onchange="setNewDay()">        
												    </select>月
												    <select id="id_day">												        
												    </select>日
												    &nbsp;&nbsp;<input type="button" onclick="search()" class="right-button08" value="查询"/> &nbsp;&nbsp;<input type="button" class="right-button08" onclick="search1()" value="查看柱状图"/>
										</td>
									</tr>
									<tr>
										<td class="tablestyle_title">采购信息列表</td>
									</tr>
									<tr>
										<td height="40" class="font42">
											<div id="container">
												<div id="demo">
												<table width="100%" style="margin-top:5px; margin-bottom: 5px" border="0" cellpadding="4" cellspacing="1" bgcolor="#6898B9" class="newfont03" class="display" id="example">
														<thead>
															<tr>
																<th>选择</th>
																<th style="color:#fff">时间</th>
																<th style="color:#fff">交易总金额</th>
																<th style="color:#fff">交易总数</th>
																<th style="color:#fff">操作</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${LIST}" var="list">
																<tr>
																<td align="center"><input type="checkbox"
																		name="delid" />
																	</td>
																	<td align="center">${list.time}</td>
																	<td align="center">${list.money}</td>
																	<td align="center">${list.count}</td>
																	<td align="center"><a href="PurchaseOneList.do?time=${list.time}" title="点击查看详情"
																		style="text-decoration: none;color:blue">查看详情</a>
																	</td>
																</tr>
															</c:forEach>
														</tbody>										
													</table>
												</div>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>