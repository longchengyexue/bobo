<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>3增加后台基地企业</title>
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
<script type="text/javascript" src="<%=basePath %>manager/js/checkAll.js" language="javascript" charset="utf-8"></script>
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
</head>

<body>
<div id="body3">
  <div id="body3_body0">
    <div id="body3_title6"><a href="#"></a></div>
	<div id="body3_text">
	 <div id="body3_text_product_issue">
	<s:form name="myForm" action="addEnterprises.action" method="post" enctype="multipart/form-data">
	   <ul>
	     <li>
	     	<span class="14boldblack" style="float:left;">
				<font size="2"><b>企业名称：</b></font>
			</span>
            <span style="float:left;">
				<input id="ev.ename" name="ev.ename" type="text" style="width:350px; height:20px;" />
			</span>
		</li>
		 <li>
		 	<span class="14boldblack" style="float:left;">
				<font size="2"><b>所属基地：</b></font>
			</span>
	     	<span style="float:left;">
	     		<s:select name="ev.bid" list="bnamemap" theme="simple"></s:select>
	     	</span>
		</li>
		<li>
			<span class="14boldblack" style="float:left;">
				<font size="2"><b>&nbsp;用&nbsp;&nbsp;户&nbsp;名：</b></font>
			</span>
	      	<span style="float:left;" >
				<input id="ev.username" name="ev.username" type="text" style="width:150px; height:20px;" />
			</span>
		</li>
		<li>
			<span class="14boldblack" style="float:left;">
				<font size="2"><b>&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;：</b></font>
			</span>
	      	<span style="float:left;" >
				<input id="ev.password" name="ev.password" type="text" style="width:150px; height:20px;" />
			</span>
		</li>
		<li>
			<span class="14boldblack" style="float:left;">
				<font size="2"><b>企业电话：</b></font>
			</span>
	      	<span style="float:left;" >
				<input id="ev.mobile" name="ev.mobile" type="text" style="width:150px; height:20px;" />
			</span>
		</li>
		<li>
			<span class="14boldblack" style="float:left;">
				<font size="2"><b>企业邮箱：</b></font>
			</span>
	      	<span style="float:left;" >
				<input id="ev.email" name="ev.email" type="text" style="width:150px; height:20px;" />
			</span>
		</li>
		 <li>
		 	<span class="14boldblack" style="float:left;">
				<font size="2"><b>企业简介：</b></font>
			</span>
	      	<span style="float:left;">
				<textarea id="qintro" name="qintro" cols="" rows="10" style="width:350px; height:auto;"></textarea>
			</span>
		</li>
		 <li>
		     <span class="14boldblack" style="float:left;margin-top:10px"><font size="2"><b>企业图片：</b></font></span>
	         <span style="float:left;">
	         	 <input type="file" id="myfile" name="myfile" style="width:250px; height:20px;"/>
	         </span>
		 </li>
		 <li style="padding:0px 100px;">
		 	<span style="float:left; margin:10px;">
				<img src="<%=basePath %>manager/images/ok.jpg" border="0" onclick="return qcheck();"/>
			</span>
		 	<span style="float:left;  margin:10px;">
				<img src="<%=basePath %>manager/images/reset.jpg" border="0" onclick="return reset1();"/>
			</span>
		</li>
	   </ul>
	</s:form>
	 </div>
	</div>
  </div>
</div>
</body>
</html>