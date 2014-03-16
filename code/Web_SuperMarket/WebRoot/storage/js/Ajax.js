
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

//function selectPartDutyList(){
//	createHttpRequest();
//	var deptId = document.getElementById("deptId").value;
////	alert("查询部门值班信息:"+deptId);
//	if(deptId != ""){
//		xmlHttp.open("post","dutyDeptList.action?deptId="+deptId, true);
//		xmlHttp.send(null);
//		xmlHttp.onreadystatechange=function (){
//			if(xmlHttp.readyState==4){//服务器交互完成
//				if(xmlHttp.status==200){//服务器相应成功
//					document.getElementById('partDutyList').innerHTML=xmlHttp.responseText;
//					alert(xmlHttp.responseText);
//				}
//			}
//		};
//	}
//}


function addIn_selectInf() {
	createHttpRequest();
	var purchId = document.getElementById("purchId").value;
 	//alert(purchId);
	if(purchId != ""){
		xmlHttp.open("post","getProductInf.do?purchId="+purchId, true);
		xmlHttp.onreadystatechange=function (){
			if(xmlHttp.readyState==4){//服务器交互完成
				if(xmlHttp.status==200){//服务器相应成功
					var Resouse=xmlHttp.responseText.split("#");
					//alert("--"+Resouse[1]+"--");
					if(Resouse[1]!=0){
						document.getElementById("productId").value=Resouse[1];
						document.getElementById("productName").value=Resouse[2];
					}else{
						alert("此采购流水号不存在，请重新输入！");
						document.getElementById("purchId").focus();
					}
					
				}
			}
		};
		xmlHttp.send(null);
	}
}

function checkNum(){
	createHttpRequest();
	var inNum=document.getElementById("inNum").value;
	//alert(inNum);
	if (isNaN(inNum))
	{
		alert("非法字符！");
		document.getElementById("inNum").value="";
		//document.getElementById("inNum").focus();
		
	}else{

	var purchId=document.getElementById("purchId").value;
	xmlHttp.open("post","getProductInf.do?purchId="+purchId, true);
	xmlHttp.send(null);
	xmlHttp.onreadystatechange=function (){
		if(xmlHttp.readyState==4){//服务器交互完成
			if(xmlHttp.status==200){//服务器相应成功
				var Resouse=xmlHttp.responseText.split("#");
				//alert("--"+Resouse[3]+"--");
				var purchCount=Resouse[3];
				if(inNum>purchCount){
					alert("入库数量不能大于采购数量！");
					document.getElementById("inNum").value="";
					document.getElementById("inNum").focus();
				}
			}
	}
	};
	}
}
	





