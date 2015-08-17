<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>PicUpload page</title>
    
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
    
<s:form method="post" enctype="multipart/form-data" action="picupload_picUpload.action">
<%-- <s:textfield name="fileNames" lable="文件标题" /><br/> --%>
<%-- <s:file name="files" name="files" lable="选择文件" /><br/> --%>
<input type="file" name="files" lable="请选择文件" />
<s:submit value="上传" />

<!-- 
<input type="file" name="insFile" />
<input type="submit" value="提交" name="submit"> 
 -->

</s:form>



  </body>
</html>
