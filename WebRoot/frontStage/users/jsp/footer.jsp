<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="../style/style.css" rel="stylesheet" type="text/css" />
</head>
<base href="<%=basePath%>">

<body>
<div id="footer_banner">
	<ul>
		<li><a href="#">友情链接</a></li>
		<li><a href="#">帮助指南</a></li>
		<li><a href="#">关于我们</a></li>
		<li><a href="#">联系我们</a></li>
	</ul>
</div> 
<div id="footer_content">
	<div class="dd">
    	<center>
  			<img src="frontStage/repairclaim/images/footer_content.jpg" width="320" height="35" style="margin:35px auto 50px auto;"/>
        	<p style="font-size:38px;color:#D3D7D8;">广东工业大学计算机协会</p>
        </center>
    </div>
</div>
</body>
</html>