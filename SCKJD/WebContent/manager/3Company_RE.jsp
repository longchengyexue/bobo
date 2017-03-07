<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业信息</title>
<style type="text/css">
<!--
table,td,th {
	padding: 5px;
	font-size: 14px;
	color: #333333;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
.input{ width:150px;
height:20px;
}
</style>
<link href="<%=basePath %>manager/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>manager/css/mystyle.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="body1">
  <div id="bodyup0">
    <div id="bodyup11">
	  <div id="bodyup1title3">
	    <div id="body3_title6"></div>
	  </div>
	  	<div id="bodyup1text1">
		<br/>
		<center>
		  <div id="Combg">
		  	<div id="Comimage"><img src="<s:property value='%{ev.elogopath}'/>" width="300px" height="350px"/></div>
			<div id="Comtext">
				<table align="center" cellpadding="8" cellspacing="8">
				<tr>
					<td width="30%">
						<font color="#0066FF">企业名称：</font>
					</td>
					<td width="70%" align="left">
						<s:property value="%{ev.ename}"/>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">所属基地：</font>
					</td>
					<td align="left">
						<s:property value="%{ev.web}"/>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">企业电话：</font>
					</td>
					<td align="left">
						<s:property value="%{ev.mobile}"/>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">企业简介：</font>
					</td>
					<td align="left">
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宜兴市（节能环保）于2011年12月被江苏省商务厅认定为江苏省科技兴贸出口创新基地。同时也是工信部认定的“中国环保装备国家新型工业化示范基地”、科技部认定的“国家火炬计划宜兴环保装备制造及服务特色产业基地”。
					</td>
				</tr>
				</table>
			</div>
		  </div>
		</center>
		</div>
	</div>
  </div>
</div>
</body>
</html>