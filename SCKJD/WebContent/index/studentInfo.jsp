<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<base href="<%=basePath%>">

<title></title>
</head>

<body bgcolor="#C7C7CC">
	<center>
		<table border="0">
			<tr>
				<td><font size="5" color="#6641E2"> 辽宁石油化工大学宿舍学生信息管理</font>
				</td>
			</tr>

			<center>
				<table border="0">
					<tr height="35px" align="left">

					</tr>

					<tr>
						<td width="10%" align="center">
						<td width="20%" align="left"><font color="#0066FF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查询条件
						</font></td>
						<td width="10%" align="center"></td>
						<td width="10%" align="right"></td>
						<td width="20%" align="left"></td>
						<td width="10%" align="center">
						<td width="10%" align="center"></td>
					</tr>
					
					<tr height="35px">
						<td width="20%"></td>
						<td width="15%">姓名: <input type="text" name=""
							style="background-color: #888888;" />
						</td>
						<td width="15%">学号: <input type="text" name=""
							style="background-color: #888888;" />
						</td>
						<td></td>
						<td width="20%" align="left"><input type="button" value="查询"
							onclick="" /> <input type="button" value="增加" onclick="" /> <input
							type="button" value="重置" onclick="" />
						</td>
						<td width="10%"></td>
						<td width="10%"></td>

					</tr>
					<tr height="35px"></tr>
				</table>
			</center>
			<table border="1">
				<tr>
					<td width="10%" align="center"><font color="#0066FF">学号
					</font></td>
					<td width="10%" align="center"><font color="#0066FF">姓名
					</font></td>
					<td width="10%" align="center"><font color="#0066FF">性别
					</font></td>
					<td width="10%" align="center"><font color="#0066FF">面貌
					</font></td>
					<td width="10%" align="center"><font color="#0066FF">住宿地址
					</font></td>
					<td width="10%" align="center"><font color="#0066FF">专业
					</font></td>
					<td width="10%" align="center"><font color="#0066FF">备注信息
					</font></td>
					<td width="20%" align="center"><font color="#0066FF">操作
					</font></td>
				</tr>
			</table>
			<%-- <table border="1">
				<s:iterator value="list" var="sv">
					<tr>
						<td width="10%" align="center"><font color="#0066FF"><s:property
									value="#sv.id" /> </font></td>
						<td width="10%" align="center"><font color="#0066FF"><s:property
									value="#sv.name" /> </font></td>
						<td width="10%" align="center"><font color="#0066FF"><s:property
									value="#sv.sex" /> </font></td>
						<td width="10%" align="center"><font color="#0066FF"><s:property
									value="#sv.party" /> </font></td>
						<td width="10%" align="center"><font color="#0066FF"><s:property
									value="#sv.room" /> </font></td>
						<td width="10%" align="center"><font color="#0066FF"><s:property
									value="#sv.profession" /> </font></td>
						<td width="10%" align="center"><font color="#0066FF"><s:property
									value="#sv.demo" /> </font></td>
						<td width="20%" align="center"><font color="#0066FF"><input
								type="button" value="编辑" onclick="" /> <input type="button"
								value="删除" onclick="" /> </font></td>
					</tr>
				</s:iterator>
			</table> --%>
			</center>
			
			
			
				<div id="body3_text_policy_page">
		<%-- <form id="main_pageform" action="student.action" method="post">
			<ul class="tails">
				<li><a href = "student?info.currentPage=1">首页</a></li>
				<li><a href = "student?info.currentPage=<s:property value='info.currentPage'/>&info.pageType=back">上一页</a></li>
				<li>第<s:property value="info.currentPage"/>页</li>
				<li><a href = "student?info.currentPage=<s:property value='info.currentPage'/>&info.pageType=next">下一页</a></li>
				<li><a href = "student?info.currentPage=<s:property value='info.maxPage'/>">尾页</a></li>	
				<li>到第<s:select name="info.currentPage" list="info.listpage" onchange="changePage()"></s:select>页</li>		
			</ul>
		</form>  --%>
	</div>
</body>

</html>