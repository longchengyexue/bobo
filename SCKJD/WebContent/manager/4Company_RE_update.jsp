<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>4编辑企业信息</title>
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
<script type="text/javascript" src="<%=basePath %>manager/js/checkAll.js" language="javascript" charset="utf-8"></script>
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
				<s:form name="myForm" action="resetEnterprises.action" method="post">
				<table align="center" cellpadding="4" cellspacing="2">
				<tr>
					<td width="40%">
						<font color="#0066FF">企业名称：</font>
					</td>
					<td width="60%" align="left">
						<input id="ev.ename" name="ev.ename" type="text" style="width:250px; height:20px;" value="<s:property value='%{ev.ename}'/>"/>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">所属基地：</font>
					</td>
					<td align="left">
						<s:select name="ev.bid" list="bnamemap" theme="simple"></s:select>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">用户名：</font>
					</td>
					<td align="left">
						<input id="ev.username" name="ev.username" type="text" style="width:250px; height:20px;" value="<s:property value="%{ev.username}"/>"/>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">密码：</font>
					</td>
					<td align="left">
						<input id="ev.password" name="ev.password" type="text" style="width:250px; height:20px;" value="<s:property value="%{ev.password}"/>"/>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">企业电话：</font>
					</td>
					<td align="left">
						<input id="ev.mobile" name="ev.mobile" type="text" style="width:250px; height:20px;" value="<s:property value="%{ev.mobile}"/>"/>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">企业邮箱：</font>
					</td>
					<td align="left">
						<input id="ev.email" name="ev.email" type="text" style="width:250px; height:20px;" value="<s:property value="%{ev.email}"/>"/>
					</td>
				</tr>
				<tr>
					<td>
						<font color="#0066FF">企业简介：</font>
					</td>
					<td align="left">
						 <textarea id="qintro" name="qintro" cols="" rows="8" style="width:280px; height:auto;">&nbsp;&nbsp;&nbsp;&nbsp;宜兴市（节能环保）于2011年12月被江苏省商务厅认定为江苏省科技兴贸出口创新基地。同时也是工信部认定的“中国环保装备国家新型工业化示范基地”、科技部认定的“国家火炬计划宜兴环保装备制造及服务特色产业基地”。</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input name="ev.eid" type="hidden" value="<s:property value='%{ev.eid}'/>"/>
						<span style="float:left; margin:10px;"><img src="<%=basePath %>manager/images/ok.jpg" border="0" onclick="return qcheck();"/></span>
						<span style="float:left;  margin:10px;"><img src="<%=basePath %>manager/images/reset.jpg" border="0" onclick="return qreset();"/></span>
					</td>
				</tr>
				</table>
				</s:form>
			</div>
		  </div>
		</center>
		</div>
	</div>
  </div>
</div>
</body>
</html>