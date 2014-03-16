<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN">
<HTML>
<HEAD>
	<TITLE>超市管理系统</TITLE>
	<META http-equiv=Content-Type content="text/html; charset=GBK">
	<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
	<FRAMESET id=index border=0 frameSpacing=0 rows=120,* frameBorder=no>
	<FRAME id=topFrame name=topFrame src="superMarket/top.jsp" noresize="noresize" scrolling=no>
	<FRAMESET border=0 frameSpacing=0 frameBorder=no cols=200,*>
	<FRAME id=left name=leftFrame src="superMarket/left.jsp"  noresize="noresize" scrolling=no>
	<frameset rows="36,*" cols="*" frameborder="no" border="0" framespacing="0">
	  	<frame src="superMarket/rtop.html" name="rtopFrame" scrolling="No" id="rtopFrame" title="tpFrame" />
		<frame src="dailyManager/notice/noticeList.do" name="rightFrame" scrolling="auto" id="rightFrame" title="rigFrame" />
	</frameset>
	</FRAMESET>
	</FRAMESET>

</HTML>
