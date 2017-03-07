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
<title>辽宁省出口基地公共信息平台</title>
<link href="<%=basePath %>index/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>index/js/time.js" language="javascript"></script>
</head>
<body onload="show()">
<%@ include file="header.jsp"%>
<div id="body1">
  <div id="bodyup">
    <div id="bodyup1">
	  <div id="bodyup1title"><a href="select2Notices"><img src="<%=basePath %>index/images/more.jpg" width="23" height="5" border="0" /></a></div>
	  <div id="bodyup1text">
	   <ul>
		<s:iterator value="list" var="ev" begin="0" end="5">
	    <li>
			<div id="bodyup1text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup1text_li_text" >
				<a href="select3Notices.action?nid=<s:property value="#ev.nid"/>">
					<s:property value="#ev.ntitle"/>
				</a>
			</div>
			<div id="bodyup1text_li_data" style="font-size: 13px;"><s:property value="#ev.ndate"/></div>
		</li>
		</s:iterator>
	   </ul>
	  </div>
	</div>
	<div id="bodyup2">
	  <div id="bodyup2title"><a href="#"><img src="<%=basePath %>index/images/more.jpg" width="23" height="5" border="0" /></a></div>
	  <div id="bodyup2text">
	  <ul>
	    <li>
			<div id="bodyup2text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup2text_li_text"><a href="#" class="STYLE8">沈阳校区建设</a></div>
		</li>
	    <li>
			<div id="bodyup2text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup2text_li_text"><a href="#" class="STYLE8">关于原产于美国、加拿大和巴西的...</a></div>
		</li>
			    <li>
			<div id="bodyup2text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup2text_li_text"><a href="#" class="STYLE8">关于附加限制性条件批准微软收购...</a></div>
		</li>
			    <li>
			<div id="bodyup2text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup2text_li_text"><a href="#" class="STYLE8">加强安全生产监督检查...</a></div>
		</li>
			    <li>
			<div id="bodyup2text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup2text_li_text"><a href="#" class="STYLE8">强化运输装备监管...</a></div>
		</li>
			    <li>
			<div id="bodyup2text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup2text_li_text"><a href="#" class="STYLE8">加强从业人员管理...</a></div>
		</li>
	   </ul>
	  </div>
	</div>
	<div id="bodyup3">
	  <div id="bodyup3title"><a href="#"><img src="<%=basePath %>index/images/more.jpg" width="23" height="5" border="0" /></a></div>
	  <div id="bodyup3text">
	  <ul>
	    <li>
			<div id="bodyup1text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup1text_li_text"><a href="#" class="14boldblacklinks STYLE8">一季度用电等多项指标...</a></div>
			<div id="bodyup1text_li_data" style="font-size: 15px;">2014-8-31</div>
		</li>
	    <li>
			<div id="bodyup1text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup1text_li_text"><a href="#" class="STYLE8">一季度用电等多项指标...</a></div>
			<div id="bodyup1text_li_data" style="font-size: 15px;">2014-8-31</div>
		</li>
			    <li>
			<div id="bodyup1text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup1text_li_text"><a href="#" class="STYLE8">一季度用电等多项指标...</a></div>
			<div id="bodyup1text_li_data" style="font-size: 15px;">2014-8-31</div>
		</li>
			    <li>
			<div id="bodyup1text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup1text_li_text"><a href="#" class="STYLE8">一季度用电等多项指标...</a></div>
			<div id="bodyup1text_li_data" style="font-size: 15px;">2014-8-31</div>
		</li>
			    <li>
			<div id="bodyup1text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup1text_li_text"><a href="#" class="STYLE8">一季度用电等多项指标...</a></div>
			<div id="bodyup1text_li_data" style="font-size: 15px;">2014-8-31</div>
		</li>
			    <li>
			<div id="bodyup1text_li_img"><img src="<%=basePath %>index/images/square.jpg" /></div>
			<div id="bodyup1text_li_text"><a href="#" class="STYLE8">一季度用电等多项指标...</a></div>
			<div id="bodyup1text_li_data" style="font-size: 15px;">2014-8-31</div>
		</li>
	   </ul>
	  </div>
	</div>
  </div>
  <div id="bodydown">
   <div id="bodydownleft">
     <div id="bodydownleft1">
	   <div id="bodydownleft1_title"></div>
	   <div id="bodydownleft1_text"><a href="Base_map.action"><img src="<%=basePath %>index/images/map_pic.jpg" border="0" /></a></div>
      </div>
   <div id="bodydownleft2">
		<div id="bodydownleft2_title"></div>
		<div id="bodydownleft2_text"><a href="#"><img src="<%=basePath %>index/images/costom_pic.jpg" border="0" /></a></div>
   </div>
   </div>
   <div id="bodydownright">
     <div id="bodydownright1">
	   <div id="bodydownright1_title"><a href="#"><img src="<%=basePath %>index/images/more.jpg" width="23" height="5" border="0" /></a></div>
	   <div id="bodydownright1_text">
	     <div id="bodydownright1_text_ad"><a href="#"><img src="<%=basePath %>index/images/ggw_pic.jpg" border="0" /></a></div>
		 
		 <div id="bodydownright1_text_list">
		 <div class="STYLE10" id="bodydownright1_text_list_city">城市/行业</div>
		 <div id="bodydownright1_text_list_cityccc">
			  <ul>
			   <li><a href="#" class="STYLE8">沈阳</a></li>
			   <li><a href="#">大连</a></li>
			   <li><a href="#">鞍山</a></li>
			   <li><a href="#">辽阳</a></li>
			   <li><a href="#">营口</a></li>
			   <li><a href="#">绥中</a></li>
			   <li><a href="#">葫芦岛</a></li>
			   <li><a href="#">丹东</a></li>
			   <li><a href="#">铁岭</a></li>
			  </ul>
		  </div>
		 </div>
		 <div id="bodydownright1_text_link">
			 <ul>
			   <li><a href="#"><img src="<%=basePath %>index/images/link01.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link02.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link03.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link04.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link05.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link01.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link02.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link03.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link04.jpg" border="0" /></a></li>
			   <li><a href="#"><img src="<%=basePath %>index/images/link05.jpg" border="0" /></a></li>
			 </ul>
		  </div>
	   </div>
	 </div>
	 <div id="bodydownright2">
	   <div id="bodydownright2_title"><a href="#"><img src="<%=basePath %>index/images/more.jpg" width="23" height="5" border="0" /></a></div>
	   <div id="bodydownright2_text">
	    <div id="bodydownright2_text_line1">
			<table width="650px">
			<tr>
				<td align="center"><div class="STYLE6" id="bodydownright2_text_line1_title">手机</div></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >苹果</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >三星</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >LG</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >酷派</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >索尼</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >小米</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >华为</a></td>
			</tr>
			<tr>
				<td align="center"><div class="STYLE6"  id="bodydownright2_text_line2_title">大家电</div></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >平版电脑</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >冰箱</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >空调</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >洗衣机</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >净化器</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >空调</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >油烟机</a></li></td>
			</tr>
			<tr>
				<td align="center"> <div class="STYLE6" id="bodydownright2_text_line3_title">个护电器</div></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >夏季清仓</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >剃须刀</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >洁面仪</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >电动牙刷</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >吹风机</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >足浴盆</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >护理机</a></td>
			</tr>
			<!--<tr>
				<td align="center"><div class="STYLE6" id="bodydownright2_text_line4_title">配件</div></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >移动电源</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >便携音箱</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >路由器</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >U盘</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >打火机</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >数据线</a></td>
				<td align="center"><a href="#" style="color:#999999; text-decoration:none" >智能机</a></td>
			</tr>-->
		</table>
       </div>
	 </div>
   </div>
  </div> 
</div>
<div id="bottom">
   <div id="bottom1" class="bottom1links14bold"><a href="#" >沈阳华信1</a>    |    <a href="#">沈阳华信2</a>   |    <a href="#">沈阳华信3</a>    |    <a href="#">沈阳华信4</a>   |    <a href="#">沈阳华信5</a>    |    <a href="#" >百度</a>   |    <a href="#">沈阳华信</a>   |    <a href="#">沈阳华信</a>   |    <a href="#">沈阳华信</a>    |    <a href="#">辽宁省</a></div>
   <div id="bottom2" class="bottom1links16bold"><a href="#" ">出口基地展示平台</a> | <a href="#">站点地图</a> | <a href="#">关于我们</a> | <a href="#">联系我们</a> </div>
  <div id="bottom3">您是第 <a href="#"><strong>101791</strong></a> 位访客问本站</div>
   <div id="bottom4">Copyright 2014 Liaoning Province Export base Information platform,AllRights Reserved 辽ICP备10214897号  辽公安网安备1101020000000号 <br />
   辽宁省出口基地公共信息平台 版权所有
   </div>
</div>
</body>
</html>