/**
 * 显示时间的js
 * @return
 */
	function show( )
	{
		var date= new Date( ) ;
		var year="",month="",day="",week="",hour="",minute="",second="";
		year=date.getYear();
		month=add_zero(date.getMonth()+1);
		day=add_zero(date.getDate());
		week=date.getDay();
		switch(date.getDay()){
			case 0:val ="星期天";break;
			case 1:val ="星期一";break;
			case 2:val ="星期二";break;
			case 3:val ="星期三";break;
			case 4:val ="星期四";break;
			case 5:val ="星期五";break;
			case 6:val ="星期六";					
		}		
		hour=add_zero(date.getHours());
		minute=add_zero(date.getMinutes());
		second=add_zero(date.getSeconds());
		var h="欢迎访问辽宁省出口基地信息平台";
		var time=("欢迎访问辽宁省出口基地信息平台&nbsp;&nbsp;"+year+"年"+month+"月"+day+"日"+val+"&nbsp;&nbsp;"+hour+"点"+minute+"分"+second+"秒");   <!--为什么月份上要加1-->  
		
		document.getElementById("top1000_number").innerHTML=h;
		document.getElementById("top1000_number").innerHTML=time;		
		setTimeout("show()",1000)
		}
	function add_zero(temp) 
{ 
if(temp<10) return "0"+temp; 
else return temp; 
} 
