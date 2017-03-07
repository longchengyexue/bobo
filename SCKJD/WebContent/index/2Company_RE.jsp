<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>2级出口基地</title>
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
  <div id="body3_body1">
    <div id="body3_title"><img src="<%=basePath %>index/images/3Company_RE_title.jpg" /></div>
	<div id="body3_text">
	 <div>
	  	<div align="left"><a href="#"> 所有种类</a> > <a href="#">  包装 </a> > <a href="#"> 纸类包装容器 </a> > <a href="#">纸盒</a></div>
		<table id="body3_text_title2" border="0" style="border:1px #CCCCCC solid; font-style: inherit; " >
			<tr >
				<td align="left">用途：</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>通用包</td>
				<td>+更多 </td>
			</tr>
			<tr>
				<td align="left">工艺：</td>
				<td>烫金</td>
				<td>胶印</td>
				<td>彩印</td>
				<td>UV印刷</td>
				<td>贴标</td>
				<td>植绒</td>
				<td>丝网印</td>
				<td>凸印</td>
				<td>凹印</td>
				<td>通用包</td>
				<td>+更多</td>
			</tr>
			<tr>
				<td align="left">纸盒类型</td>
				<td>折叠纸盒</td>
				<td>固定纸盒</td>
				<td>其他</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>+更多</td>
			</tr>
		</table>
	 </div>
	<div id="body3_text_text2">
		<table border="0px" width="800px" height="400px" align="center" style="margin-top:0px">
			<s:iterator value="list" var="ev" status="st">
				<s:if test="(#st.count)%4==1">
					<tr>
					<s:if test="(#st.count)%4==0">
						</tr>
					</s:if>
					<td>
						<a href="selectcompanydetail.action?eid=<s:property value='#ev.eid'/>"><br />
						<img width="225px" height="195px" src="<s:property value='#ev.elogopath'/>" />
						</a>
						<a href="selectcompanydetail.action?eid=<s:property value='#ev.eid'/>"><br />	
							<center><s:property value="#ev.ename"/></center>
						</a></td>
				</s:if>
				<s:else>
					<td>
						<a href="selectcompanydetail.action?eid=<s:property value='#ev.eid'/>"><br />
						<img width="225px" height="195px" src="<s:property value='#ev.elogopath'/>" />
						</a>
						<a href="selectcompanydetail.action?eid=<s:property value='#ev.eid'/>"><br />	
							<center><s:property value="#ev.ename"/></center>
						</a></td>
				</s:else>
			</s:iterator>
			</table><br /><br />
	</div>
	<div id="body3_text_policy_page">
		<form id="main_pageform" action="selectCompanyRE.action" method="post">
			<ul class="tails">
				<li><a href = "selectCompanyRE?info.currentPage=1">首页</a></li>
				<li><a href = "selectCompanyRE?info.currentPage=<s:property value='info.currentPage'/>&info.pageType=back">上一页</a></li>
				<li>第<s:property value="info.currentPage"/>页</li>
				<li><a href = "selectCompanyRE?info.currentPage=<s:property value='info.currentPage'/>&info.pageType=next">下一页</a></li>
				<li><a href = "selectCompanyRE?info.currentPage=<s:property value='info.maxPage'/>">尾页</a></li>	
				<li>到第<s:select name="info.currentPage" list="info.listpage" onchange="changePage()"></s:select>页</li>		
			</ul>
		</form> 
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