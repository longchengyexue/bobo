<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台基地企业</title>
<style type="text/css">
.tails li{
display:inline;
padding-right:6px;
}
</style>
<script type="text/javascript">
	function changePage(){
		document.getElementById("main_pageform").submit();;
	}
</script>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="<%=basePath %>manager/css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
a {
	font-size: 12px;
	color: #666666;
}
a:link {
	text-decoration: none;
	color: #333333;
}
a:visited {
	text-decoration: none;
	color: #333333;
}
a:hover {
	text-decoration: underline;
	color: #666666;
}
a:active {
	text-decoration: none;
}
.STYLE6 {
	font-size: 14px;
	font-weight: bold;
}
.STYLE7 {
	font-size: 14px;
	color: #000000;
	font-weight: bold;
}
-->
</style>

<script type="text/javascript">
var $ = function (id) {
	return "string" == typeof id ? document.getElementById(id) : id;
};

var Extend = function(destination, source) {
	for (var property in source) {
		destination[property] = source[property];
	}
	return destination;
}

var CurrentStyle = function(element){
	return element.currentStyle || document.defaultView.getComputedStyle(element, null);
}

var Bind = function(object, fun) {
	var args = Array.prototype.slice.call(arguments).slice(2);
	return function() {
		return fun.apply(object, args.concat(Array.prototype.slice.call(arguments)));
	}
}

var Tween = {
	Quart: {
		easeOut: function(t,b,c,d){
			return -c * ((t=t/d-1)*t*t*t - 1) + b;
		}
	},
	Back: {
		easeOut: function(t,b,c,d,s){
			if (s == undefined) s = 1.70158;
			return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
		}
	},
	Bounce: {
		easeOut: function(t,b,c,d){
			if ((t/=d) < (1/2.75)) {
				return c*(7.5625*t*t) + b;
			} else if (t < (2/2.75)) {
				return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
			} else if (t < (2.5/2.75)) {
				return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
			} else {
				return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
			}
		}
	}
}
//容器对象,滑动对象,切换数量
var SlideTrans = function(container, slider, count, options) {
	this._slider = $(slider);
	this._container = $(container);//容器对象
	this._timer = null;//定时器
	this._count = Math.abs(count);//切换数量
	this._target = 0;//目标值
	this._t = this._b = this._c = 0;//tween参数
	
	this.Index = 0;//当前索引
	
	this.SetOptions(options);
	
	this.Auto = !!this.options.Auto;
	this.Duration = Math.abs(this.options.Duration);
	this.Time = Math.abs(this.options.Time);
	this.Pause = Math.abs(this.options.Pause);
	this.Tween = this.options.Tween;
	this.onStart = this.options.onStart;
	this.onFinish = this.options.onFinish;
	
	var bVertical = !!this.options.Vertical;
	this._css = bVertical ? "top" : "left";//方向
	
	//样式设置
	var p = CurrentStyle(this._container).position;
	p == "relative" || p == "absolute" || (this._container.style.position = "relative");
	this._container.style.overflow = "hidden";
	this._slider.style.position = "absolute";
	
	this.Change = this.options.Change ? this.options.Change :
		this._slider[bVertical ? "offsetHeight" : "offsetWidth"] / this._count;
};
SlideTrans.prototype = {
  //设置默认属性
  SetOptions: function(options) {
	this.options = {//默认值
		Vertical:	true,//是否垂直方向（方向不能改）
		Auto:		true,//是否自动
		Change:		0,//改变量
		Duration:	50,//滑动持续时间
		Time:		10,//滑动延时
		Pause:		4000,//停顿时间(Auto为true时有效)
		onStart:	function(){},//开始转换时执行
		onFinish:	function(){},//完成转换时执行
		Tween:		Tween.Quart.easeOut//tween算子
	};
	Extend(this.options, options || {});
  },
  //开始切换
  Run: function(index) {
	//修正index
	index == undefined && (index = this.Index);
	index < 0 && (index = this._count - 1) || index >= this._count && (index = 0);
	//设置参数
	this._target = -Math.abs(this.Change) * (this.Index = index);
	this._t = 0;
	this._b = parseInt(CurrentStyle(this._slider)[this.options.Vertical ? "top" : "left"]);
	this._c = this._target - this._b;
	
	this.onStart();
	this.Move();
  },
  //移动
  Move: function() {
	clearTimeout(this._timer);
	//未到达目标继续移动否则进行下一次滑动
	if (this._c && this._t < this.Duration) {
		this.MoveTo(Math.round(this.Tween(this._t++, this._b, this._c, this.Duration)));
		this._timer = setTimeout(Bind(this, this.Move), this.Time);
	}else{
		this.MoveTo(this._target);
		this.Auto && (this._timer = setTimeout(Bind(this, this.Next), this.Pause));
	}
  },
  //移动到
  MoveTo: function(i) {
	this._slider.style[this._css] = i + "px";
  },
  //下一个
  Next: function() {
	this.Run(++this.Index);
  },
  //上一个
  Previous: function() {
	this.Run(--this.Index);
  },
  //停止
  Stop: function() {
	clearTimeout(this._timer); this.MoveTo(this._target);
  }
};
</script>
<style type="text/css">
#body3_body0{ width:998px; height:auto; margin:4px auto; border:1px solid #D8D8D8; }
</style>
</head>
<body>
<div id="logo">
	<div id="logo1000">
	  <div id="logo1"><a href="#"><img src="<%=basePath %>manager/images/logo.jpg" alt="辽宁省出口基地信息平台" border="0" /></a></div>
	  <div id="logo2"></div>
	</div>
</div>
<div id="nav_welcome">
 <div id="nav1000_welcome">
   <div id="nav1000_01"><a href="welcome.action">首页</a></div>
   <div id="nav1000_02"><a href="2ExportBase.action">出口基地</a></div>
   <div id="nav1000_03"><a href="managerCompanyRE.action">基地企业</a></div>
   <div id="nav1000_04"><a href="#">基地产品</a></div>
   <div id="nav1000_05"><a href="#">政策法规</a></div>
   <div id="nav1000_06"><a href="#">资讯动态</a></div>
   <div id="nav1000_07"><a href="#">市场开拓</a></div>
   <div id="nav1000_08"><a href="managerNotices.action">最新公告</a></div>
   <div id="nav1000_09"><a href="#">公共服务平台</a></div>
 </div>
</div>
<div id="body3">
  <div id="body3_body0">
    <div id="body3_title6"><a href="add.action"><img src="<%=basePath %>manager/images/add_add.jpg" border="0" /></a></div>
	<div id="body3_text">
	 <div id="body3_text_policy">
	 <ul>
		<s:iterator value="list" var="ev">
		<li>
		<span id="body3_text_policy_con"><a href="managercompanydetail.action?eid=<s:property value='#ev.eid'/>"><s:property value="#ev.ename"/></a></span>
		<span id="body3_text_policy_date">2016-08-02</span>
		<span style="float:left; width:90px;">
			<a href="updateEnterprises.action?eid=<s:property value='#ev.eid'/>">
				<img src="<%=basePath %>manager/images/edit.jpg" border="0" />
			</a>
		</span>
		<span style="float:left; width:90px">
			<a href="deleteEnterprises.action?eid=<s:property value='#ev.eid'/>">
				<img src="<%=basePath %>manager/images/del.jpg" border="0" />
			</a>
		</span>
		</li>
		</s:iterator>
	 </ul>
	 </div>
	 <div id="body3_text_policy_page">
		<form id="main_pageform" action="managerCompanyRE.action" method="post">
			<ul class="tails">
				<li><a href = "managerCompanyRE.action?info.currentPage=1">首页</a></li>
				<li><a href = "managerCompanyRE.action?info.currentPage=<s:property value='info.currentPage'/>&info.pageType=back">上一页</a></li>
				<li>第<s:property value="info.currentPage"/>页</li>
				<li><a href = "managerCompanyRE.action?info.currentPage=<s:property value='info.currentPage'/>&info.pageType=next">下一页</a></li>
				<li><a href = "managerCompanyRE.action?info.currentPage=<s:property value='info.maxPage'/>">尾页</a></li>	
				<li>到第<s:select name="info.currentPage" list="info.listpage" onchange="changePage()"></s:select>页</li>		
			</ul>
		</form> 
	</div>
	</div>
  </div>
</div>
</body>
</html>