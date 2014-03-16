1、核心标签库导入：<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> jstl.jar和standard.jar不导
2、已经导入的包：数据库连接、上传下载，解析excel,
3、图片放在WebRoot下的images文件夹中
4、js放在js文件夹下，命名以所负责模块的名命名
5、css放在css文件夹下，命名以所负责模块的名命名
6、根目录下的others和vip文件夹默认不走过滤器，如无特殊情况不允许使用，使用请告之。
7、各模块页面放于以自己模块名命名的文件夹下。
8、工程默认编码为GBK
9、各模块配置请放在config包下com.config下,并在mvc_config.xml配置格式如下:
	<import file="mvc_user_config.xml"/> 
10、src 下的com.verification_code.servlet包为验证码专用包，请勿修改和使用
11、login.htm的错误不用处理。默认登录名为：10001 密码为：000

12、bean、action和dao的命名规则如例子。action和dao的继承问题请查看示例。
13、工具类在src下的com.tools下的Utils类，类名为Utils,方法均为静态公有方法 getDate() 2013-1-1, getDate() 2013-1-1 1:1:1
14、中文日历插件：
	<script type="text/javascript" src="根目录下js中的calendar.js"></script>
	<input name="date" type="text" id="date" onclick="new Calendar().show(this);" readonly="readonly" />
15、分页插件：
	
	1）引入分页的css（根目录下css中的demos.css）文件和两个js(根目录下js中的jquery.js,jquery.dataTables.js)文件，

		<style type="text/css" title="currentStyle">
			@import "../css/demos.css";
		</style>
		<script type="text/javascript" language="javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" language="javascript" src="../js/jquery.dataTables.js"></script>
		<script type="text/javascript" charset="GBK">
			$(document).ready(function() {
				$('#example').dataTable( {
					"sPaginationType": "full_numbers"
				} );
			} );
		</script>
	
	
	2）在body标签中添加两个属性：id="dt_example" class="example_alt_pagination"
	
	3）表格<table>标签上加上两个<div>
		<div id="container">			
		<div id="demo">
		
	4）针对分页的table表格，添加两个属性：class="display" id="example"

	5）第一行使用一个<thead><tr></th></th></tr></thead>

	6）需要分页的数据行，用<tbody></tr><td></td></tr></tbody>
	

16、登陆后的人的信息
编号：loginId
权限：List集合loginState
姓名：loginName
部门编号：loginDeptId
部门：loginDept
17、所有的Dao层继承ConnectionAware(数据库连接对象为conn),所有的Action继承HttpAware

18、编辑器使用实例如下：
	//导入
	<script type="text/javascript" src="../../js/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="../../js/jquery.wysiwyg.js"></script>
	<link rel="stylesheet" href="../../css/jquery.wysiwyg.css" type="text/css" />

	//编辑框
	<div>
		<textarea name="remarks" id="remarks" rows="7" cols="100"></textarea>
	</div>
	//以下代码放在</body>前
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






