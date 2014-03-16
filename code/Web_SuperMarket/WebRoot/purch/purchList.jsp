<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link href="../css/demos.css" rel="stylesheet" type="text/css" />
	<link href="../css/css.css" rel="stylesheet" type="text/css" />
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/xiangmu.js"></script>
	<script type="text/javascript" language="javascript"
		src="../js/jquery.js"></script>
	<script type="text/javascript" language="javascript"
		src="../js/jquery.dataTables.js"></script>
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

	//function link() {
		//document.getElementById("fom").action = "addPart.jsp";
		//document.getElementById("fom").submit();
	//}
	
	
</SCRIPT>

<script language=javascript>
function getValue(){
    
    var arr=document.getElementsByName("delid");
    var a="";
    for(var i=0;i<arr.length;i++){
    if(arr[i].checked){
     a=a+arr[i].value+",";
    }
    }
    var as=a.substring(0,a.length-1);
    if(as==""){
    alert("请选择！");
    
   }else{
   var b=window.confirm("确认删除吗？");
    if(b){
    alert(as);
    window.location.replace("deletePurch.do?id="+as);
    }
   }
	}
	
	function excelIn(){
	window.location.replace("excelIn.do");
	
	}
</script>

<body id="dt_example" class="example_alt_pagination">
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
												href="#" class="right-font08" onclick="unselectAll();">反选</a>
										</span> <input name="Submit" type="button" class="right-button08"
											value="删除所选采购信息" onclick="getValue()"   /> 
											
											<input name="Submit" type="button" class="right-button08"
											value="excel导入信息" onclick="excelIn()"   /> 
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
																<th style="color:#fff">采购流水号</th>
																<th style="color:#fff">商品编号</th>
																<th style="color:#fff">商品名称</th>
																<th style="color:#fff">员工编号</th>
																<th style="color:#fff">员工名字</th>
																<th style="color:#fff">供货商编号</th>
																<th style="color:#fff">供货商名称</th>
																<th style="color:#fff">进价</th>
																<th style="color:#fff">数量</th>
																<th style="color:#fff">采购时间</th>
																<th style="color:#fff">生产时间</th>
																<th style="color:#fff">过期时间</th>
																<th style="color:#fff">备注</th>
																<th style="color:#fff">操作</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${list}" var="purch">
																<tr>
																	<td align="center"><input type="checkbox"
																		name="delid" value="${purch.purchId}"/>
																	</td>
																	<td align="center">${purch.purchId}</td>
																	<td align="center">${purch.productId}</td>
																	<td align="center">${purch.productName}</td>
																	<td align="center">${purch.employeeId}</td>
																	<td align="center">${purch.employeeName}</td>
																	<td align="center">${purch.companyId}</td>
																	<td align="center">${purch.companyName}</td>
																	<td align="center">${purch.inPrice}</td>
																	<td align="center">${purch.purchCount}</td>
																	<td align="center">${purch.purchTime}</td>
																	<td align="center">${purch.productTime}</td>
																	<td align="center">${purch.expireTime}</td>
																	<td align="center">${purch.remarks}</td>
																	
																	<td align="center">
																	<a href="findPurch.do?id=${purch.purchId}"
																	    style="text-decoration: none;color:blue"
																		>更新</a>
																	</td>
																</tr>
															</c:forEach>
														</tbody>
														
													</table>
												</div>
											</div></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>