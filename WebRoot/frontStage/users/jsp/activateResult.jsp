<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>activate.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<br><br>
<p>
<s:property value="activateResult.activateMsg" />
<s:if test="activateResult.activateEffect==1"><a href="<%=basePath%>frontStage/JixieMall/person_page/person_page.jsp?request=userCenter">先完善信息去吧！</a>
<s:if test="activateResult.activateEffect==2"><a href="users_registUI.action">重新注册吧！</a>
<s:if test="activateResult.activateEffect==3"><a href="users_registUI.action">重新注册吧！</a>
<s:if test="activateResult.activateEffect==4">重新验证吧!</s:if>
</s:if>
</s:if>
</s:if>
</p>
  </body>
</html>
