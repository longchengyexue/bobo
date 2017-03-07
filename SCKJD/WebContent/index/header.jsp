<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/index/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>头部</title>
</head>
<body>
<div id="top">
 <div id="top1000">
  <div id="top1000_number" class="top14bold"></div>
  <div id="top1000_login" class="bottom1links14bold"><a href="reg.action" >注册</a> |<a href="log.action" class="14boldblacklinks">登录</a></div>
 </div>
</div>
<div id="logo">
	<div id="logo1000">
	  <div id="logo1"><img src="<%=basePath1 %>images/logo.jpg" width="1000" height="168" /></div>
	  <div id="logo2"></div>
	</div>
</div>
<div id="nav">
 <div id="nav1000">
   <div id="nav1000_01"><a href="selectindex.action">首页</a></div>
   <div id="nav1000_02"><a href="Base_map.action">出口基地</a></div>
   <div id="nav1000_03"><a href="selectCompanyRE.action">基地企业</a></div>
   <div id="nav1000_04"><a href="#">基地产品</a></div>
   <div id="nav1000_05"><a href="#">政策法规</a></div>
   <div id="nav1000_06"><a href="#">资讯动态</a></div>
   <div id="nav1000_07"><a href="#">市场开拓</a></div>
 </div>
</div>
</body>
</html>