<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD id=Head1>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<TITLE>���й���ͷ��</TITLE>
<STYLE type=text/css>
* {
	FONT-SIZE: 12px;
	COLOR: white
}

#logo {
	COLOR: white
}

#logo A {
	COLOR: white
}

FORM {
	MARGIN: 0px
}
</STYLE>
<SCRIPT src="Top/Clock.js" type=text/javascript></SCRIPT>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY style="BACKGROUND-IMAGE: url(../images/bg.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x">
	<form id="form1">
		<DIV id=logo
			style="BACKGROUND-IMAGE: url(../images/logo.png); BACKGROUND-REPEAT: no-repeat">
			<DIV style="PADDING-RIGHT: 50px; BACKGROUND-POSITION: right 50%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(../images/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 30px; TEXT-ALIGN: right">
				 <IMG src="Top/menu_seprator.gif" align=absMiddle>
				<A id=HyperLink2 href="main.action" target="rightFrame">������ҳ</A>
				<IMG src="Top/menu_seprator.gif" align=absMiddle>
				<A id=HyperLink3 href="logout.action" target="_top">�˳�ϵͳ</A>
			</DIV>
			<DIV style="DISPLAY: block; HEIGHT: 54px"></DIV>
			<DIV style="BACKGROUND-IMAGE: url(../images/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px">
				<TABLE cellSpacing=0 cellPadding=0 width="100%">
					<TBODY>
						<TR>
							<TD>
								<DIV>
									<IMG src="Top/nav_pre.gif" align=absMiddle> ��ӭ
									<SPAN id=lblBra>�ڻҳ��й���ϵͳ</SPAN>
									<SPAN id=lblDep>${loginDept }</SPAN>
									[${loginId }] ${loginName }����
								</DIV>
							</TD>
							<TD align=right width="70%">
								<SPAN style="PADDING-RIGHT: 50px">
								<A href="javascript:history.go(-1);">
								<IMG src="Top/nav_back.gif" align=absMiddle border=0>����</A>
								<A href="javascript:history.go(1);">
								<IMG src="Top/nav_forward.gif" align=absMiddle border=0>ǰ��</A>
								<A href="logout.action" target=_top><IMG src="Top/nav_changePassword.gif" align=absMiddle border=0>���µ�¼</A>
								<A href="../systemConfig/updatePassword.jsp" target=rightFrame>
								<IMG src="Top/nav_resetPassword.gif" align=absMiddle border=0>�޸�����</A>
								<A href="http://localhost:1479/Web/sys/Top.aspx#" target=mainFrame>
								<IMG src="Top/nav_help.gif" align=absMiddle border=0>����</A>
								<IMG src="Top/menu_seprator.gif" align=absMiddle>
								<SPAN id=clock></SPAN>
							</SPAN>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</DIV>
		<SCRIPT type=text/javascript>
			var clock = new Clock();
			clock.display(document.getElementById("clock"));
		</SCRIPT>
	</form>
</BODY>
</HTML>
