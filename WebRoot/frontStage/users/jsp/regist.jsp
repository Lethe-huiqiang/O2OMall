<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%request.setCharacterEncoding("utf-8"); %>
<%if(request.getSession().getAttribute("users") != null){
	response.sendRedirect(basePath+"commodity_showCommodityList.action");
	}%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>regist</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" href="<%=basePath %>frontStage/users/css/rreset.css" rel="stylesheet">
	<link type="text/css" href="<%=basePath %>frontStage/users/css/public.css" rel="stylesheet">
	<link type="text/css" href="<%=basePath %>frontStage/users/css/register.css" rel="stylesheet">
	<link rel="shortcut icon" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>frontStage/JixieMall/css/head.css" />
  
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/jquery-1.8.2.min.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/jquery.form.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/regist.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/users/js/json.parse.js"></script>

<script>
$(function(){
    $('.guide-img').hide();
   });
</script>
  </head>
  
  <body>
  <!-- 头部 -->
<jsp:include  page="../../JixieMall/commonhead.jsp"/>
  <div class="register_content">
  	
  	<ul class="step_ul step1 clear">
			<li class="li1">01、填写资料</li>
			<li class="li2">02、完成注册</li>
	</ul>
  	
  
    <form  id="registerForm" method="post" style="padding:60px 40px 88px 40px;font-family:Microsoft Yahei"><!-- action="users_regist.action" -->
<!--      <input type="hidden" name="userInfo.pic" value="123456789"/>  -->
 
 	<div class="div_form clear ">
				<label>账户名：</label>
				<div class="input_div input_div1">
            <input type="text" name="users.nickname" id="nickname" label="昵称" placeholder="16位以下字母或8位以下中文"/><br>
            <input type="hidden" id="nameHidden" value="false">
            <div class=""><span class="" style="color:red;margin-right:5px;" id="validNickname"></span><b></b><em></em></div>
	 	</div>
	</div>
            
     <div class="div_form clear ">
				<label>请创建一个密码：</label>
				<div class="input_div input_div3">
      		<input type="password" name="users.password" id="password" label="密码"  placeholder="6位以上12以下的数字及字母组合"/>
      		<input type="hidden" id="passwordHidden" value="false">
      		<div class=""><span class="" style="color:red;margin-right:5px;" id="validPassword"></span><b></b><em></em></div>
	 	</div>
	</div>
	          
            
    <div class="div_form clear ">
				<label>重新输入密码：</label>
				<div class="input_div input_div4">
            <input type="password"  id="secondPassword" label="密码"  placeholder="6位以上12以下的数字,字母及下划线组合"/>
			<input type="hidden" id="secondPasswordHidden" value="false">
			<div class=""><span class="" style="color:red;margin-right:5px;" id="validSecondPassword"></span><b></b><em></em></div>
	 	</div>
	</div>       
       
             
     <div class="div_form clear ">
				<label>常用的邮箱帐号：</label>
				<div class="input_div input_div2" >   
            <input type="text" name="users.email" id="email" placeholder="******@***.***"/><br>
            <input type="hidden" id="emailHidden" value="false"> 
            <div class=""><span class="" style="color:red;margin-right:5px;" id="validEmail"></span><b></b><em></em></div>
	 	</div>
	</div>             
              	
    <div class="div_form clear ">
    	<label></label>
		<div class="input_div" id="agreement">
			<!-- <span style="color:blue;">*&nbsp;支持使用用户名或邮箱登陆</span> -->
			<input type="hidden" id="submitFlag" value="" />
			<p> <input type="checkbox" id="agreeNode" name="agreeNode" />已阅读和同意计协网站的<a href="#">服务条款及用户须知</a>并同意条款及须知 </p>
		</div>
	</div>
	
	<div class="div_form clear ">
	<label></label>
		<div class="input_div">			
			<input class="login_sub submitA" id="registeNode" type="button" value="马上注册" disabled onclick="register();">
		</div>
	</div>
		
		
   	</form>
   	
   	<div class="reg_login">
			<p>已有帐号？</p>
			<a class="btn2" href="<%=basePath %>frontStage/users/jsp/login.jsp">登录</a>
	</div>
	<div class="bg"></div>
   	
  </div>
  </body>
</html>
