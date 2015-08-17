<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jixie.bean.UsersInfo" %>
<%@ page import="com.jixie.utils.Utils" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
UsersInfo usersInfo=(UsersInfo)request.getAttribute("usersInfo");
 %>

<%--该页面用于完善个人信息 --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jixieweb-usersInfoUI</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<s:debug></s:debug>
  <script type="text/javascript" src="<%=basePath %>/frontStage/users/js/jquery-1.8.2.min.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>/frontStage/users/js/usersInfoUI.js"></script>
  <script type="text/javascript" src="<%=basePath %>/frontStage/users/js/jquery.form.js"></script></head>
  
  <body>
    <form action="users_usersInfoFulfil.action" method=post class="" id="usersInfoForm" enctype="multipart/form-data"><!-- action="users_usersInfoFulfil.action" -->
    
    	<table width="100%" class="" cellspacing="0">
    	
    	
    	<input type="hidden" name="usersInfo.id" id="id" value="<s:property value='usersInfo.id' />">
    	<input type="hidden" name="usersInfo.grade" value="<s:property value='usersInfo.grade' />">
    	<input type="hidden" name="usersInfo.status" value="<s:property value='usersInfo.status' />">
    	<input type="hidden" name="usersInfo.pictureId" value="<s:property value='usersInfo.pictureId' />">
			<tr>
				<td class="">头像</td>
				<td class=""><img src="<%=basePath %>${usersInfo.fileSource.path }" width=180px height="200px"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="file" name="picture" id="picture" ></td>
			</tr>
			<tr>
				<td class="">昵称</td>
				<td class=""><input type="text" name="usersInfo.nickname" id="nickname" value="<s:property value='usersInfo.nickname'/>"
					placeholder="输入昵称" id="nickname" ><span class="" id="validNickname"></span>
				</td>
			</tr>
			<tr>
				<td class="">邮箱</td>
				<td class=""><input type="text" name="usersInfo.email" id="email" value="<s:property value='usersInfo.email' />"
					placeholder="输入邮箱" id="email" ><span class="" id="validEmail"></span>
				</td>
			</tr>    
    		<tr>
    			<td class="">专业</td>
    			<td class=""><input type="text" name="usersInfo.major" id="major" value="<s:property value='usersInfo.major' />"
    				plaeholder="输入专业" id="major" >
    			</td>
    		</tr>
    		<tr>
				<td class="">注册码</td>
				<td class=""><input type="text" name="usersInfo.registCode" id="registCode" value='<s:property value='usersInfo.registCode' />' readonly=ture>
				</td>
			</tr>    
    		<tr>
    			<td class="">推荐码</td><%--推荐码只能输入一次，后台检测，如果数据库已有记录，则只返回记录，不能输入 --%>
    			<td class="">
    			<%if((Utils.null2Str(usersInfo.getUsersCode())).equals("")) {%>
    			<input type="text" name="usersInfo.usersCode" id="usersInfoCode" value="<s:property value='usersInfo.usersCode' />"
    				plaeholder="输入推荐码" id="usersCode" >
    			<%}else{ %>
    			<s:property value='usersInfo.usersCode' />
    			<%} %>
    			</td>
    		</tr>
    		<tr>
    			<td class="">更新时间</td>
    			<td class="">
    			<%=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(usersInfo.getUpdateTime()) %>
<!--     			<s:property value='usersInfo.updateTime' /> -->
    			</td>
    		</tr>
    		<tr>
    			<td class=""><input type="submit" value="保存" id="save" ></td> <!-- onclick="javascript:updateUsersInfo()" onclick="updateUsersInfo();"-->
    		</tr>
    	</table>
    </form>
<!--     <img height="150" width="150" src="<%=basePath %><s:property value='fs.path' />" ><a href="<%=basePath %><s:property value='fs.path' />">tupian</a> -->
    
  </body>
  
</html>
