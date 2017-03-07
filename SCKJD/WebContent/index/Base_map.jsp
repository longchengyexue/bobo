<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/index/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基地地图</title>
<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>js/time.js" type="text/javascript"></script>
<script src="<%=basePath %>AC_RunActiveContent.js" type="text/javascript"></script>
</head>
<body onload="show();">
<s:include value="header.jsp"></s:include>
<style type="text/css">
<!--
#body3_body_long{ width:998px; height:700px; margin:4px auto; border:1px solid #D8D8D8; }
#apDiv1 {
	position:absolute;
	left:250px;
	top:400px;
	width:201px;
	height:47px;
	z-index:24;
	visibility: hidden;
}
#apDiv2 {
	position:absolute;
	left:320px;
	top:490px;
	width:167px;
	height:47px;
	z-index:23;
	visibility: hidden;
}
#apDiv3 {
	position:absolute;
	left:350px;
	top:370px;
	width:181px;
	height:145px;
	z-index:22;
	visibility: hidden;
}
#apDiv4 {
	position:absolute;
	left:340px;
	top:480px;
	width:198px;
	height:74px;
	z-index:21;
	visibility: hidden;
}
#apDiv5 {
	position:absolute;
	left:400px;
	top:470px;
	width:192px;
	height:72px;
	z-index:20;
	visibility: hidden;
}
#apDiv6 {
	position:absolute;
	left:400px;
	top:520px;
	width:213px;
	height:96px;
	z-index:19;
	visibility: hidden;
}
#apDiv7 {
	position:absolute;
	left:400px;
	top:700px;
	width:189px;
	height:115px;
	z-index:18;
	visibility: hidden;
}
#apDiv8 {
	position:absolute;
	left:480px;
	top:470px;
	width:160px;
	height:118px;
	z-index:17;
	visibility: hidden;
}
#apDiv9 {
	position:absolute;
	left:490px;
	top:450px;
	width:146px;
	height:104px;
	z-index:16;
	visibility: hidden;
}
#apDiv10 {
	position:absolute;
	left:480px;
	top:310px;
	width:171px;
	height:75px;
	z-index:15;
	visibility: hidden;
}
#apDiv11 {
	position:absolute;
	left:520px;
	top:330px;
	width:179px;
	height:73px;
	z-index:14;
	visibility: hidden;
}
#apDiv12 {
	position:absolute;
	left:520px;
	top:380px;
	width:211px;
	height:55px;
	z-index:13;
	visibility: hidden;
}
#apDiv13 {
	position:absolute;
	left:530px;
	top:450px;
	width:197px;
	height:53px;
	z-index:12;
	visibility: hidden;
}
#apDiv14 {
	position:absolute;
	left:570px;
	top:560px;
	width:186px;
	height:29px;
	z-index:11;
	visibility: hidden;
}
#apDiv0 {
	position:absolute;
	top:8px;
	width:0;
	height:0;
	z-index:25;
}
-->
</style>
<script type="text/javascript">
<!--
function MM_showHideLayers() { //v9.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) 
  with (document) if (getElementById && ((obj=getElementById(args[i]))!=null)) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}
//-->
</script>
		<script type="text/javascript"
			src="<%=basePath%>res/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>res/js/base/base.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>res/js/window.js"></script>
		<script type="text/javascript">
//首页时间
</script>
<div id="body3">
  <div id="body3_body_long">
    <div id="body3_title"><img src="<%=basePath%>images/2Map_title.jpg" width="999" height="26" /></div>
	<div id="body3_text">
	  <div id="map">
	  <div id="container"><div id="apDiv0">
  <div id="apDiv1" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town1" width="196" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody>
		<s:iterator value="#request.listbase1" var="listbase">
		<tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
	</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv2" onmouseover="MM_showHideLayers(&#39;apDiv2&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town2" width="162" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody>
	<s:iterator value="#request.listbase2" var="listbase">
	<tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
	</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv3" onmouseover="MM_showHideLayers(&#39;apDiv3&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town3" width="175" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase3" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
	</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv4" onmouseover="MM_showHideLayers(&#39;apDiv4&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town4" width="194" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase4" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
	</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv5" onmouseover="MM_showHideLayers(&#39;apDiv5&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town5" width="185" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody>
      <s:iterator value="#request.listbase5" var="listbase">
			<tr>
	       	 <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
	      </tr>
	</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv6" onmouseover="MM_showHideLayers(&#39;apDiv6&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town6" width="210" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase6" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
		</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv7" onmouseover="MM_showHideLayers(&#39;apDiv7&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town7" width="186" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase7" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
	</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv8" onmouseover="MM_showHideLayers(&#39;apDiv8&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town8" width="156" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase8" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
	</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv9" onmouseover="MM_showHideLayers(&#39;apDiv9&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town9" width="150" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase9" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
		</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv10" onmouseover="MM_showHideLayers(&#39;apDiv10&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town10" width="169" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase10" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
		</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv11" onmouseover="MM_showHideLayers(&#39;apDiv11&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town11" width="173" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase11" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
		</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv12" onmouseover="MM_showHideLayers(&#39;apDiv12&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town12" width="204" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase12" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
		</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv13" onmouseover="MM_showHideLayers(&#39;apDiv13&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town13" width="187" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase13" var="listbase"><tr>
        <td bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
		</s:iterator>
    </tbody></table>
  </div>
  <div id="apDiv14" onmouseover="MM_showHideLayers(&#39;apDiv14&#39;,&#39;&#39;,&#39;show&#39;)" onmouseout="MM_showHideLayers(&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;)" style="visibility: hidden;">
    <table id="town14" width="182" border="0" cellpadding="3" cellspacing="1" bgcolor="707fca">
      <tbody><s:iterator value="#request.listbase14" var="listbase"><tr>
        <td width="174" bgcolor="eef3ff"><div align="center"><a href="_3ExportBase.action?vo.bid=<s:property value='#listbase.bid' />" target="_blank"><s:property value="#listbase.bname"/></a></div></td>
      </tr>
</s:iterator>
    </tbody></table>
  </div>
  </div>
  
  <div id="mainContent">
   
   
   
      <div align="center"><img src="<%=basePath%>images/base_map.jpg" width="620" height="575" border="0" usemap="#Map">
<map name="Map" id="Map">
<area shape="rect" coords="185,250,222,280" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="230,340,267,370" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="270,170,310,207" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="250,290,270,317" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="320,270,330,297" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="340,330,350,357" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="300,530,330,557" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="390,280,410,300" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="400,260,420,280" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="400,190,430,230" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="435,120,455,160" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="445,190,465,210" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="445,255,465,275" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
<area shape="rect" coords="500,365,520,385" href="javascript:void(0)" onmouseover="MM_showHideLayers(&#39;apDiv1&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv2&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv3&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv4&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv5&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv6&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv7&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv8&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv9&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv10&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv11&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv12&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv13&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv14&#39;,&#39;&#39;,&#39;show&#39;,&#39;apDiv15&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv16&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv17&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv18&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv19&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv20&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv21&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv22&#39;,&#39;&#39;,&#39;hide&#39;,&#39;apDiv23&#39;,&#39;&#39;,&#39;hide&#39;)">
</map>
    </div>
</div>

</div>
	  </div>
    </div>
  </div>
</div>
<div id="bottom">
   <div id="bottom1" class="bottom1links14bold"><a href="#" >友情链接</a>    |    <a href="#">友情链接</a>   |    <a href="#">友情链接</a>    |    <a href="#">友情链接</a>   |    <a href="#">友情链接</a>    |    <a href="#" >友情链接</a>   |    <a href="#">友情链接</a>    |    <a href="#">友情链接</a></div>
   <div id="bottom2" class="bottom1links16bold"><a href="#" ">出口基地展示平台</a> | <a href="#">站点地图</a> | <a href="#">关于我们</a> | <a href="#">联系我们</a> </div>
  <div id="bottom3">您是第 <a href="#"><strong>101791</strong></a> 位访客问本站</div>
   <div id="bottom4">Copyright 2014 Liaoning Province Export base Information platform,AllRights Reserved 辽ICP备10214897号  辽公安网安备1101020000000号 <br />
   辽宁省出口基地公共信息平台 版权所有
   </div>
</div>
</body>
</html>
