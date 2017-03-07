<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业注册</title>
<link href="<%=basePath %>index/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>index/css/mystyle.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>index/js/checkAll.js" type="text/javascript" language="javascript" charset="GB2312"></script>
<script type="text/javascript" src="<%=basePath %>index/js/time.js" language="javascript"></script>
</head>
<body onload="show()">
<%@ include file="header.jsp"%>
<div id="body1">
  <div id="bodyup0">
    <div id="bodyup11">
	  <div id="bodyup1title1"></div>
	  	<div id="bodyup1text1">
			<br/>
			<form id="myForm" name="myForm" action="registration.action" method="post" enctype="multipart/form-data">
			<table align="center" cellpadding="6">
				<tr>
					<td>
						&nbsp;登录名：
					</td>
					<td>
						<input id="ev.username" type="text" name="ev.username" style="height: 20px;width: 180px;"/>
					</td>
					<td>
						<p><font color="#FF0000">*</font>由3-15位字母、数字或中文组成</p>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;密&nbsp;&nbsp;&nbsp;码：&nbsp;
					</td>
					<td>
						<input id="ev.password" type="password" name="ev.password" style="height: 20px;width: 180px;"/>
					</td>
					<td>
						<p><font color="#FF0000">*</font>由6-12位数字或字符组成</p>
					</td>
				</tr>
				<tr>
					<td>
						确认密码：
					</td>
					<td>
						<input id="queren" type="password" name="queren" style="height: 20px;width: 180px;"/>
					</td>
					<td>
						<p><font color="#FF0000">*</font>由6-12位数字或字符组成</p>
					</td>
				</tr>
				<tr>
					<td>
						企业名称：
					</td>
					<td>
						<input id="ev.ename" type="text" name="ev.ename" style="height: 20px;width: 180px;"/>
					</td>
					<td>
						<p><font color="#FF0000">*</font>企业名称不能为空</p>
					</td>
				</tr>
				<tr>
					<td>
						联系电话：
					</td>
					<td>
						<input id="ev.mobile" type="text" name="ev.mobile" style="height: 20px;width: 180px;"/>
					</td>
					<td>
						<p><font color='#FF0000'>*</font>如1381408xxxx,010-12345678</p>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;Email：&nbsp;&nbsp;
					</td>
					<td>
						<input id="ev.email" type="text" name="ev.email" style="height: 20px;width: 180px;"/>
					</td>
					<td>
						<p><font color='#FF0000'>*</font>如abcd1234@163.com</p>
					</td>
				</tr>
 				<tr>
					<td>
						&nbsp;&nbsp;基地：&nbsp;&nbsp;
					</td>
					<td>
						<s:select  id="ev.bid" name="ev.bid" list="bnamemap" theme="simple"></s:select>
					</td>
					<td>
						<p><font color='#FF0000'>*</font></p>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;行业：&nbsp;&nbsp;
					</td>
					<td>
						<select>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
							<option value="行业1">科技兴贸新能源-风电装备&nbsp;&nbsp;</option>
						</select>
					</td>
					<td>
						<p><font color='#FF0000'>*</font></p>
					</td>
				</tr>
				<tr>
					<td>
						企业LOGO：
					</td>
					<td>
						<input type="file" id="myfile" name="myfile"/>
					</td>
					<td>
						<p><font color='#FF0000'>*</font></p>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align="center">
						<table>
							<tr>
								<td>
									<img src="<%=basePath %>index/images/ok.jpg" onclick="return checkAll();"/>
								</td>
								<td>
									<img src="<%=basePath %>index/images/reset.jpg" onclick="reset();"/>
								</td>
							</tr>
						</table>
					</td>
					<td></td>
				</tr>
			</table>
			</form>
		</div>
	</div>
  </div>
</div>
<br />
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