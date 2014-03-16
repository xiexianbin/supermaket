<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link rel="stylesheet" rev="stylesheet" href="../css/style.css"
			type="text/css" media="all" />

	<script>
			function checkstr(str)
			{
			
			if(str>=48&&str<=57)//数字
			{
			return 1;
			}
			else if(str>=65&&str<=90)//大写字母
			{
			return 2;
			}
			else if(str>=97&&str<=122)//小写字母
			{
			return 3;
			}
			else//特殊字符
			{
			return 4;
			}
			}
			function checkl(string)
			{
			n=false;
			s=false;
			t=false;
			l_num=0;
			if(string.length<6)
			{
			l_num=1;
			}
			else
			{
			for(i=0;i<string.length;i++)
			{
			   asc=checkstr(string.charCodeAt(i));
			   if(asc==1&&n==false){l_num+=1;n=true;}
			   if((asc==2||asc==3)&&s==false){l_num+=1;s=true;}
			   if(asc==4&&t==false){l_num+=1;t=true;}
			}
			}
			return l_num;
			}
			
			function checklevel(psw)
			{
			color="#ededed";
			color_l="#ff0000";
			color_m="#ff9900";
			color_h="#33cc00";
			if(psw==null||psw=='')
			{
			lcor=color;
			mcor=color;
			hcor=color;
			}
			else
			{
			thelev=checkl(psw)
			switch(thelev)
			{
			   case 1:
			   lcor=color_l;
			   hcor=mcor=color;
			   break;
			   case 2:
			   mcor=lcor=color_m;
			   hcor=color;
			   break;
			   case 3:
			   hcor=mcor=lcor=color_h;
			   break;
			   default:
			   lcor=mcor=hcor=color;
			}
			}
			document.getElementById("strength_L").style.background=lcor;
			document.getElementById("strength_M").style.background=mcor;
			document.getElementById("strength_H").style.background=hcor;
			}
	</script>
	<script language="JavaScript" type="text/javascript">
	function check()
	{
	 if(window.vip.checkoldpass.innerHTML=="密码有误"){
	  alert("输入的密码有误!");
	  window.vip.checkoldpass.focus();
	  return false;
	  }
	 if(window.vip.oldPassword.value==""){
	  alert("带*为必填内容");
	  window.vip.oldPassword.focus();
	  return false;
	  }
	  if(window.vip.newPassword.value==""){
	  alert("带*为必填内容");
	  window.vip.newPassword.focus();
	  return false;
	  }
	  if(window.vip.newPasswordAgain.value==""){
	  alert("带*为必填内容");
	  window.vip.newPasswordAgain.focus();
	  return false;
	  }
	}
	function checkNewPassword(){
		if(window.vip.newPassword.value!=window.vip.newPasswordAgain.value){
			document.getElementById("passagain").innerHTML="两次输入的密码不一致!";
		}else{
			document.getElementById("passagain").innerHTML="√";
		}
		
	}
	var oldPass="";
	var xmlHttp;
	function createHttpRequest(){
		// 火狐，非IE浏览器及IE7(7.0及以上版本)，用xmlhttprequest对象创建
		if(window.XMLHttpRequest){
			
			xmlHttp=new XMLHttpRequest();
		}else if(window.ActiveXObject){
			
			xmlHttp=new ActiveXObject("Microsoft.XMLHttp");
		}
	}
	function checkPassword(){
		var pass=document.getElementById("id_oldPassword").value;
		
		if(pass!="" && oldPass!=pass){
			oldPass=pass;
			checkMess(pass);
		}else if(pass=="" && oldPass!=""){
			oldPass=pass;
			checkMess(pass);
		}
		window.setTimeout(checkPassword, 1000);
	}
	function checkMess(pass){

		createHttpRequest();
		if(pass!=null){;
			xmlHttp.open("post", "checkPassword.do?pass="+pass,true);
		}else{	
			xmlHttp.open("post", "checkPassword.do",true);
		}
		xmlHttp.send(null);
		xmlHttp.onreadystatechange= stateChange; 
	}
	function stateChange(){
		if(xmlHttp.readyState==4){
				if(xmlHttp.status=200){
					document.getElementById("div_tab").innerHTML=xmlHttp.responseText;
				}
			}
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
		<form action="updatePassword.action" method="post" name="vip" onsubmit="return check()">
			<div class="MainDiv">
			<div id="div_tab">
				<table width="99%" border="1" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title"> 
							密码修改
						</th>
					</tr>
					<c:if test="${!empty MESS}">
					<tr style="height: 10%;color: red">
						<td align="center" >
							<h1>${MESS}</h1>
						</td>
					</tr>
					</c:if>
					<tr>
						<td class="CPanel">

							<table border="0" cellpadding="0" cellspacing="0"
								style="width: 100%">

								<tr>
									<td width="100%">
										<fieldset style="height: 100%;">
											<legend>
												修改密码
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">

												<tr>
												
													<td nowrap="nowrap" align="right" width="45%">
														请输入原密码:
													</td>
													<td width="15%">
														<input id="id_oldPassword" onblur="checkPassword()" name='oldPassword' type="password" class="text"
															style="width: 154px" value="${PASSWORD}" /><span class="red">*</span>
													</td>
													
													<td width="40%">
														<span class="red">${ANS}</span>
														
													</td>
													
												</tr>
												<tr>
													<td align="right" nowrap="nowrap">
														请输入新密码:
													</td>
													<td>
														<input type="password" class="text" onkeyup="checklevel(this.value)" onblur="checklevel(this.value)" id="id_newPassword" name='newPassword' style="width: 154px"
															value="" /><span class="red">*</span>														
													</td>
													<td>
														<table width="50%" cellspacing="1" cellpadding="0" bordercolor="#cccccc" height="9">
															<tr align="center" bgcolor="#eeeeee">
															
															<td width="33%" height="5" id="strength_L"></td>
															
															<td width="33%" id="strength_M"></td>
															
															<td width="33%" id="strength_H"></td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td align="right" nowrap="nowrap">
														请再次输入新密码:
													</td>
													<td>
														<input type="password" class="text" name='newPasswordAgain' onblur="checkNewPassword()" style="width: 154px"
															value="" /><span class="red">*</span>														
													</td>
													<td>
														<span id="passagain" class="red"></span>
													</td>
												</tr>	
											</table>
											<br />
										</fieldset>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" height="50px">
							<input type="submit" name="Submit" value="提交" class="button"/>

							<input type="button" name="Submit2" value="返回" class="button"
								onclick="window.history.go(-1);" />
						</td>
					</tr>
				</table>
						</div>
			</div>
		</form>

	</body>
</html>

