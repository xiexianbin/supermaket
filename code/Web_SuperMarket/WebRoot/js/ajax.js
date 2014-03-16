
//创建XMLhttprequest对象
var xmlHttp;
var oldName="";
function createHttpRequest(){
	// 火狐，非IE浏览器及IE7(7.0及以上版本)，用xmlhttprequest对象创建
	if(window.XMLHttpRequest){
		xmlHttp=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		xmlHttp=new ActiveXObject("Microsoft.XMLHttp");
	}
}

function selectMess(name){
	createHttpRequest();
	if(name!=""){
		xmlHttp.open("post", "ProductBean.do?name="+name,true);
	}
	xmlHttp.send(null);
	//xmlHttp.send("name="+name);
	xmlHttp.onreadystatechange=StateChange;
}

function StateChange(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			document.getElementById("select2").value=xmlHttp.responseText;
			//document.getElementById("select3").focus();
		}
	}
}

function selectName(){
	
	var name=document.getElementById("select1").value;
	if(name!="" && name!=oldName){
		oldName=name;
		selectMess(name);
		
	}
}

/////////////////
function selectMess1(name){
	createHttpRequest();
	if(name!=""){
		xmlHttp.open("post", "SupplierBean.do?name="+name,true);
	}
	xmlHttp.send(null);
	xmlHttp.onreadystatechange=StateChange1;
}

function StateChange1(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			document.getElementById("select4").value=xmlHttp.responseText;
			//document.getElementById("select5").focus();
		}
	}
}
function selectName1(){
	
	var name=document.getElementById("select3").value;
	//alert(name);
	if(name!="" && name!=oldName){
		oldName=name;
		selectMess1(name);
		
	}
	//window.setTimeout(selectName, 3000);
}

////////////////////
function selectMess2(name){
	createHttpRequest();
	if(name!=""){
		xmlHttp.open("post", "EmployeeBean.do?name="+name,true);
	}
	xmlHttp.send(null);
	
	xmlHttp.onreadystatechange=StateChange2;
}

function StateChange2(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
		document.getElementById("select6").value=xmlHttp.responseText;
		}
	}
}
function selectName2(){
	
	var name=document.getElementById("select5").value;
	//alert(name);
	if(name!="" && name!=oldName){
		oldName=name;
		selectMess2(name);
		
	}
	//window.setTimeout(selectName, 3000);
}