<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
		<link rel="stylesheet" rev="stylesheet" href="../css/style.css"
			type="text/css" media="all" />

<script type="text/javascript" src="../js/calendar.js"></script>

 <script type="text/javascript" src="../js/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="../js/jquery.wysiwyg.js"></script>
	<link rel="stylesheet" href="../css/jquery.wysiwyg.css" type="text/css" />

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
		<form action="updateAlarm.do" method="post" name="alarm" >
			<div class="MainDiv">
				<table width="99%" border="0" cellpadding="0" cellspacing="0"
					class="CContent">
					<tr>
						<th class="tablestyle_title">
							报警信息修改
						</th>
					</tr>
					<tr>
						<td class="CPanel">

							<table border="0" cellpadding="0" cellspacing="0"
								style="width: 100%">

								<tr>
									<td width="100%">
										<fieldset style="height: 100%;">
											<legend>
												修改报警信息
											</legend>
											<table border="0" cellpadding="2" cellspacing="1"
												style="width: 100%">
												
												<tr>
													<td nowrap="nowrap" align="right" width="15%">
														报警编号:
													</td>
													<td width="35%">
														<input name='alarmId' type="text" class="text" readonly="readonly"
															style="width: 154px" value="${alarm.alarmId}" />
													</td>
													<td nowrap="nowrap" align="right">
														商品编号:
													</td>
													<td>
														<input class="text" name='productId' style="width: 154px"
															value="${alarm.productId}" />
													</td>
													</tr>
												
												<tr>
													<td align="right">
														库存商品数量下线:
													</td>
													<td width="35%">
														<input name='storageCountLimit' type="text" class="text"
															style="width: 154px" value="${alarm.storageCountLimit}" />
															</td>
													<td align="right">
														超市商品数量下线:
													</td>
													<td width="35%">
														<input name='marketCountLimit' type="text" class="text"
															style="width: 154px" value="${alarm.marketCountLimit}" />
															</td>		
													
												</tr>
												
												<tr>
												<td align="right">
														距保质期天数下线:
													</td>
													<td width="35%">
														<input name='dayLimit' type="text" class="text"
															style="width: 154px" value="${alarm.dayLimit}" />
															</td>
												</tr>
												
												<tr>
													<td align="right">
														备注:
													</td>
													<td colspan="3">
													<div>
														<textarea name="remarks" id="remarks" rows="7" cols="100">${alarm.remarks}</textarea>
														</div>
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
		</form>
		<script type="text/javascript">
		(function($) {
			$('#remarks').wysiwyg({
				controls : {
					strikeThrough : {
						visible : true
					},
					underline : {
						visible : true
					},

					separator00 : {
						visible : true
					},

					justifyLeft : {
						visible : true
					},
					justifyCenter : {
						visible : true
					},
					justifyRight : {
						visible : true
					},
					justifyFull : {
						visible : true
					},

					separator01 : {
						visible : true
					},

					indent : {
						visible : true
					},
					outdent : {
						visible : true
					},

					separator02 : {
						visible : true
					},

					subscript : {
						visible : false
					},
					superscript : {
						visible : false
					},

					separator03 : {
						visible : false
					},

					undo : {
						visible : false
					},
					redo : {
						visible : false
					},

					separator04 : {
						visible : false
					},

					insertOrderedList : {
						visible : true
					},
					insertUnorderedList : {
						visible : true
					},
					insertHorizontalRule : {
						visible : true
					},

					h4mozilla : {
						visible : false && $.browser.mozilla,
						className : 'h4',
						command : 'heading',
						arguments : [ 'h4' ],
						tags : [ 'h4' ],
						tooltip : "Header 4"
					},
					h5mozilla : {
						visible : false && $.browser.mozilla,
						className : 'h5',
						command : 'heading',
						arguments : [ 'h5' ],
						tags : [ 'h5' ],
						tooltip : "Header 5"
					},
					h6mozilla : {
						visible : false && $.browser.mozilla,
						className : 'h6',
						command : 'heading',
						arguments : [ 'h6' ],
						tags : [ 'h6' ],
						tooltip : "Header 6"
					},

					h4 : {
						visible : false && !($.browser.mozilla),
						className : 'h4',
						command : 'formatBlock',
						arguments : [ '<H4>' ],
						tags : [ 'h4' ],
						tooltip : "Header 4"
					},
					h5 : {
						visible : false && !($.browser.mozilla),
						className : 'h5',
						command : 'formatBlock',
						arguments : [ '<H5>' ],
						tags : [ 'h5' ],
						tooltip : "Header 5"
					},
					h6 : {
						visible : false && !($.browser.mozilla),
						className : 'h6',
						command : 'formatBlock',
						arguments : [ '<H6>' ],
						tags : [ 'h6' ],
						tooltip : "Header 6"
					},

					separator07 : {
						visible : false
					},

					cut : {
						visible : false
					},
					copy : {
						visible : false
					},
					paste : {
						visible : false
					}
				}
			});
		})(jQuery);
	</script>
	</body>
</html>

