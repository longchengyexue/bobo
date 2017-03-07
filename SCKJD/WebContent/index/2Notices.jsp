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
<title>3级最新公告</title>
<style type="text/css">
.tails li{
display:inline;
padding-right:6px;
}
</style>
<script type="text/javascript">
	function changePage(){
		document.getElementById("main_pageform").submit();
	}
</script>
<link href="<%=basePath %>index/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>index/js/time.js" language="javascript"></script>
</head>
<body onload="show()">
<%@ include file="header.jsp"%>
<div id="body3">
  <div id="body3_body0">
    <div id="body3_title2"></div>
	<div id="body3_text">
	 <div id="body3_text_policy">
	 <ul>
<s:iterator value="list" var="ev" >
		<li>
		<span id="body3_text_policy_con">
			<a href="select3Notices.action?nid=<s:property value="#ev.nid"/>">
			<s:property value="#ev.ntitle"/>
			</a>
		</span>
		<span id="body3_text_policy_date"><s:property value="#ev.ndate"/></span>
		</li>
</s:iterator>
	 </ul>
	 </div>
	<div id="body3_text_policy_page">
		<form id="main_pageform" action="select2Notices.action" method="post">
			<ul class="tails">
				<li><a href = "select2Notices?info.currentPage=1">首页</a></li>
				<li><a href = "select2Notices?info.currentPage=<s:property value='info.currentPage'/>&info.pageType=back">上一页</a></li>
				<li>第<s:property value="info.currentPage"/>页</li>
				<li><a href = "select2Notices?info.currentPage=<s:property value='info.currentPage'/>&info.pageType=next">下一页</a></li>
				<li><a href = "select2Notices?info.currentPage=<s:property value='info.maxPage'/>">尾页</a></li>	
				<li>到第<s:select name="info.currentPage" list="info.listpage" onchange="changePage()"></s:select>页</li>		
			</ul>
		</form> 
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