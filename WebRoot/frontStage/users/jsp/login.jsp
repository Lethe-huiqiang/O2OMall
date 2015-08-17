<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String referer = request.getHeader("referer");
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login page!</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="<%=basePath %>frontStage/users/css/reset.css">
    <link rel="stylesheet" href="<%=basePath %>frontStage/users/css/supersized.css">
    <link rel="stylesheet" href="<%=basePath %>frontStage/users/css/loginstyle.css">
	<%-- <link rel="stylesheet" type="text/css" href="<%=basePath %>frontStage/users/css/bootstrap.min.css"> --%>
	<!-- <style type="text/css">
	.right{float:left;margin-top:30px; width:50%; height:300px;margin-left:25%;border:2px solid #428BCA;margin-bottom:70px;}
	.controls{margin-left:20%;}
	</style> -->
	

  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/supersized.3.2.7.min.js"></script>
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/supersized-init.js"></script>
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/scripts.js"></script>
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/jquery.form.js"></script>
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/login.js"></script>
  
        
  </head>
  
  <body>
  <%-- <div id="header">
	<jsp:include flush="true" page="header.jsp"/><!--引入header.jsp-->
	</div> --%>
	
	<div class="page-container">
  
  		<form  id="login" method="post">
  		<h1>登录</h1>
  	
			<!-- <p style="margin-top:30%;margin-left:20%;">还没帐号？<a href="javascript:location.href='users_registUI.action'">马上注册</a></p>
			<!-- <input class="login_sub submitA btn btn-primary" id="regist" type="button" value="注册"  onclick="window.open('users_registUI.action')"> -->
		
          	<input type="text" name="users.email"  class="username" id="email" placeholder="邮箱"/>
      		<input type="password" name="users.password" class="password" id="password" placeholder="密码"/>

			<button id="usersLogin" type="button" onclick="userslogin();">登录</button>
	 	
		</form>
		<br>
		<B class="" style="color:red;margin-right:5px;" id="validation"></B>
		
		<div class="connect">
                <p>还没注册？或是忘记密码？</p>
                <p>
                <a class="regist" href="javascript:location.href='users_registUI.action'"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="forget" href="<%=basePath%>frontStage/users/jsp/forget_pass.jsp"></a>
                </p>
        </div>
	
</div>

<%-- <div id="footer" style="clear:both">
	<jsp:include flush="true" page="footer.jsp"/><!--引入footer.jsp-->
</div> --%>

	<input type="hidden" value="<%=referer%>" name="referer" id="referer"/>
  </body>
</html>
