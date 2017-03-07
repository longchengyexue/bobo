<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业登录</title>
<link href="<%=basePath %>index/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>index/css/mystyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>index/js/checkAll.js" language="javascript" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>index/js/time.js" language="javascript"></script>
</head>
<body onload="show()">
<%@ include file="header.jsp"%>
<div id="body1">
  <div id="bodyup0">
    <div id="bodyup11">
	  <div id="bodyup1title2"></div>
	  	<div id="bodyup1text1">
		<br/>
		<center>
		  <div id="loginbg">
		  	<div id="logintext">
			<form name="myForm" action="login.action" method="post">
			<table align="center" cellpadding="6">
				<tr>
					<td>
						<font color="#0066FF">用户名</font>
					</td>
					<td>
						<input style="height: 25px;width: 180px;" type="text" name="ev.username" id="username" width="50" />
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">密&nbsp;&nbsp;&nbsp;码</font>
					</td>
					<td>
						<input style="height: 25px;width: 180px;" type="password" name="ev.password" id="password" width="50" />
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<table>
							<tr>
								<td>
									<img src="<%=basePath %>index/images/ok.jpg" onclick="return submitt();"/>
								</td>
								<td>
									<img src="<%=basePath %>index/images/reset.jpg" onclick="return resett();"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</form>
			</div>
			</div>
		</center>
		</div>
	</div>
  </div>
</div>
<br/>
<div id="bottom">
   <div id="bottom1" class=" bottom1links14bold"><a href="#" >友情链接</a>    |    <a href="#">友情链接</a>   |    <a href="#">友情链接</a>    |    <a href="#">友情链接</a>   |    <a href="#">友情链接</a>    |    <a href="#">友情链接</a>   |    <a href="#">友情链接</a>    |    <a href="#">友情链接</a></div>
   <div id="bottom2" class="bottom1links16bold"><a href="#"><strong>出口基地展示平台</strong></a> | <a href="#"><strong>站点地图</strong></a> | <a href="#"><strong>关于我们</strong></a> | <a href="#"><strong>联系我们</strong></a> </div>
   <div id="bottom3">您是第 <a href="#"><strong>101791</strong></a> 位访客问本站</div>
   <div id="bottom4">Copyright 2014 Liaoning Province Export base Information platform,AllRights Reserved 辽ICP备10214897号  辽公安网安备1101020000000号 <br />
   辽宁省出口基地公共信息平台 版权所有
   </div>
</div>
</body>
</html>