
//创建XMLHttprequest对象
var xmlHttp;
function createHttpRequest(){
	// 火狐，非IE浏览器及IE7(7.0及以上版本)，用XMLHttpRequest对象创建
	if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		xmlHttp=new ActiveXObject("Microsoft.XMLHttp");
	}
}

function selectPartDutyList(){
	createHttpRequest();
	var deptId = document.getElementById("deptId").value;
//	alert("查询部门值班信息:"+deptId);
	if(deptId != ""){
		xmlHttp.open("post","dutyDeptList.action?deptId="+deptId, true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange=function (){
			if(xmlHttp.readyState==4){//服务器交互完成
				if(xmlHttp.status==200){//服务器相应成功
					document.getElementById('partDutyList').innerHTML=xmlHttp.responseText;
					alert(xmlHttp.responseText);
				}
			}
		};
	}
}

//添加值日信息的ajax
function addDuty_selectInf() {
	createHttpRequest();
	var employeeId = document.getElementById("employeeId").value;
//	alert("employeeId");
	if(employeeId != ""){
		xmlHttp.open("post","getEmployeeInf.action?employeeId="+employeeId, true);
		xmlHttp.onreadystatechange=function (){
			if(xmlHttp.readyState==4){//服务器交互完成
				if(xmlHttp.status==200){//服务器相应成功
					var Resouse=xmlHttp.responseText.split("#");
//					alert("--"+Resouse[1]+"--");
					var reResouse = Resouse[1].split(",");
					document.getElementById("employeeName").value=reResouse[0];
					document.getElementById("deptName").value=reResouse[1];
				}
			}
		};
		xmlHttp.send(null);
	}
}





