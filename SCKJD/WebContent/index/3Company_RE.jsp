<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>3级基地企业</title>
<link href="<%=basePath %>index/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>index/js/time.js" language="javascript"></script>
</head>
<body onload="show()">
<%@ include file="header.jsp"%>
<div id="body3">
  <div id="body3_body">
    <div id="body3_title"><img src="<%=basePath %>index/images/3Company_RE_title.jpg" /></div>
	<div id="body3_text">
	 <div >
	  	<div align="left"><a href="#"> 所有种类</a> > <a href="#">  包装 </a> > <a href="#"> 纸类包装容器 </a> > <a href="#">纸盒</a></div><br />
		<div style="width:378px; float:left"><img src="<s:property value='%{ev.elogopath}'/>" width="300px" height="350px"/> </div>
		<div style="width:550px; float: right">
			<div>企业名称：<s:property value="%{ev.ename}"/></div><br/>
			<div>所在基地：<s:property value="%{ev.web}"/></div><br/>
			<div>企业电话：<s:property value="%{ev.mobile}"/></div><br/>
			<div>企业简介：</div><br/>
			<div>
				<textarea disabled="disabled" style="overflow:hidden; width:500px; height:200px">&nbsp;&nbsp;&nbsp;&nbsp;宜兴市（节能环保）于2011年12月被江苏省商务厅认定为江苏省科技兴贸出口创新基地。同时也是工信部认定的“中国环保装备国家新型工业化示范基地”、科技部认定的“国家火炬计划宜兴环保装备制造及服务特色产业基地”。宜兴市（节能环保）于2011年12月被江苏省商务厅认定为江苏省科技兴贸出口创新基地。同时也是工信部认定的“中国环保装备国家新型工业化示范基地”、科技部认定的“国家火炬计划宜兴环保装备制造及服务特色产业基地”。
				</textarea>
			</div>
		</div>
	 </div><br/>
	 <div id="body3_text_text2">
	 </div>
	</div>
  </div>
</div>
<div id="bottom">
  <div id="bottom1" class="bottom1links14bold"><a href="#" >沈阳华信1</a>    |    <a href="#">沈阳华信2</a>   |    <a href="#">沈阳华信3</a>    |    <a href="#">沈阳华信4</a>   |    <a href="#">沈阳华信5</a>    |    <a href="#" >百度</a>   |    <a href="#">沈阳华信</a>   |    <a href="#">沈阳华信</a>   |    <a href="#">沈阳华信</a>    |    <a href="#">辽宁省</a></div>
   <div id="bottom2" class="bottom1links16bold"><a href="#"><strong>出口基地展示平台</strong></a> | <a href="#"><strong>站点地图</strong></a> | <a href="#"><strong>关于我们</strong></a> | <a href="#"><strong>联系我们</strong></a> </div>
   <div id="bottom3">您是第 <a href="#"><strong>101791</strong></a> 位访客问本站</div>
   <div id="bottom4">Copyright 2014 Liaoning Province Export base Information platform,AllRights Reserved 辽ICP备10214897号  辽公安网安备1101020000000号 <br />
   辽宁省出口基地公共信息平台 版权所有
   </div>
</div>
</body>
</html>