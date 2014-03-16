		//获取系统时间
		function getTimes(){
		//Date
		var date=new Date();
		var year=date.getFullYear();
		var month=date.getMonth()+1;
		var day=date.getDate();
		//一周的第几天
		var weekDay=date.getDay();
		
		switch(weekDay){
			
			case 0:
			weekDay="星期日";
			break;
			case 1:
			weekDay="星期一";
			break;
			
			case 2:
			weekDay="星期二";
			break;
			
			case 3:
			weekDay="星期三";
			break;
			
			case 4:
			weekDay="星期四";
			break;
			
			case 5:
			weekDay="星期五";
			break;
			
			default:
			weekDay="星期六";
			
			}
		
		
		
		var hour=date.getHours();
		
		var minu=date.getMinutes();
		var seco=date.getSeconds();
			
			//处理完整的时分秒格式
		hour=(hour<10)?'0'+hour:hour;
		minu=(minu<10)?'0'+minu:minu;
		seco=(seco<10)?'0'+seco:seco;
		//XXX年xx月xx日
		var content=year+"年"+month+"月"+day+"日 ";
		content+=hour+"时"+minu+"分"+seco+"秒 "+weekDay;
		document.getElementById('times').innerHTML=content;
		
	//每过1秒执当前事件
	window.setTimeout(getTimes,1000);
	}