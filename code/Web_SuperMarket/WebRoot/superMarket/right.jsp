<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="www.w3.org/1999/xhtml">
<head>
<title>默认页面</title>
<meta http-equiv="content-Type" content="text/html;charset=gb2312">
<style type="text/css">

</style>
<script language="javascript">
	window.onload=function(){
		var rt=new imgRound("imgContainer",120,90,300,80,230,0.01);
		setInterval(function(){rt.roundMove()},20)
	}
	function imgRound(id,w,h,x,y,r,dv,rh,ah){
		if (ah==undefined) ah=1;
		if (rh==undefined) rh=10;
		var dv=dv*ah; //旋转速度
		var pi=3.1415926575;
		var d=pi/2;
		var pd=Math.asin(w/2/r);
		var smove=true;
		var imgArr=new Array();
		var objectId=id;
		var o=document.getElementById(objectId);
		o.style.position="relative";
		var arrimg=o.getElementsByTagName("img");
		var pn=arrimg.length; //图片数量
		var ed=pi*2/pn;
		for (n=0;n<arrimg.length;n++){
			var lk=arrimg[n].getAttribute("link");
			if (lk!=null) arrimg[n].setAttribute("title",lk)
			arrimg[n].onclick=function(){
				if (this.getAttribute("link")!=null){
					if (this.getAttribute("target")!="_blank") window.location=(this.getAttribute("link"))
					else window.open(this.getAttribute("link"))
				}
			}
			arrimg[n].onmouseout=function(){smove=true;}
			arrimg[n].onmouseover=function(){smove=false;}
			arrimg[n].style.position="absolute";
			imgArr.push(arrimg[n]);
		}
		this.roundMove=function(){
			for (n=0;n<=pn-1;n++){
				var o=imgArr[n];
				var ta=Math.sin(d+ed*n),strFilter;
				if (ta<0) o.style.left=Math.cos(d+ed*n-pd)*r+x+"px";
				else o.style.left=Math.cos(d+ed*n+pd)*r+x+"px";
				o.style.top=ta*rh+rh+y+"px";
				var zoom=Math.abs(Math.sin((d+ed*n)/2+pi/4))*0.5+0.5;
				o.style.width=Math.abs(Math.cos(d+ed*n+pd)-Math.cos(d+ed*n-pd))*zoom*r+"px";
				o.style.height=zoom*h+"px";
				if (ta<0) {ta=(ta+1)*80+20;o.style.zIndex=0;}
				else {ta=100;o.style.zIndex=1}
				if (o.style.zIndex<=0) strFilter="FlipH(enabled:true)"
				else strFilter="FlipH(enabled:false)";
				strFilter=strFilter+" alpha(opacity="+ta+")";
				o.style.opacity=ta/100;
				o.style.filter=strFilter;
			}
			if (smove) d=d+dv;
		}
	}
</script>
</head>
<body style="background-color:#EEF2FB;">

<div id="imgContainer" style="width:400px;height:200px;border:0px;"/>
<img src="../MyOffice/images/zhuye.jpg" link="主页" target="_blank"/>
<img src="../MyOffice/images/renshi.jpg" link="人事管理" target="_blank"/>
<img src="../MyOffice/images/jiangcheng.jpg" link="奖惩管理" target="_blank"/>
<img src="../MyOffice/images/kaoqin.jpg" link="考勤管理" target="_blank"/>
<img src="../MyOffice/images/xinzi.jpg" link="薪资管理" target="_blank"/>
<img src="../MyOffice/images/baobiao.jpg" link="公司报表" target="_blank"/>
<img src="../MyOffice/images/jixiao.jpg" link="绩效管理" target="_blank"/>
<img src="../MyOffice/images/guanli.jpg" link="管理中心" target="_blank"/>
</div>
<table width="514" border="2" align="center">
  <tr>
    <td height="57" colspan="2" align="center" valign="middle">人事管理系统</td>
  </tr>
  <tr>
    <td width="75" align="center" valign="middle">系统模块</td>
    <td width="421" align="center" valign="middle"><p>员工管理，考勤管理，绩效管理，奖惩管理，薪资管理，
   公司报表，权限管理</td>
  </tr>
  <tr>
    <td align="center" valign="middle">开发工具</td>
    <td align="center" valign="middle"><p> 编码工具：myEclipce8.5，数据库：sql server 2005，浏览器：IE8</td>
  </tr> 
</table>
</body>
</html>
