<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>最新公告</title>
<link href="<%=basePath %>index/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>index/js/time.js" language="javascript"></script>
</head>
<body onload="show()">
<%@ include file="header.jsp"%>
<div id="body3">
  <div id="body3_body">
    <div id="body3_title"><img src="<%=basePath %>index/images/3Notices_title.jpg" /></div>
	<div id="body3_text">
	 <div id="body3_text_title1"><span class="heibold18"><s:property value="%{ev.ntitle}"/></span></div>
	 <div id="body3_text_text1"><span class="heibold14"><s:property value="%{ev.ncontent}"/></span>
	 <div id="body3_text_text2"> </div>
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