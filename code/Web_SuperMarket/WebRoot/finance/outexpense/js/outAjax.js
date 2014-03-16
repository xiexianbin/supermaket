
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

function addDuty_selectInf() {
	createHttpRequest();
	var employeeId = document.getElementById("employeeId").value;
//	alert(employeeId);
	if(employeeId != ""){
		xmlHttp.open("post","../../dailyManager/duty/getEmployeeInf.action?employeeId="+employeeId, true);
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