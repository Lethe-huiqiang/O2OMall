<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>广东工业大学计算机协会商城</title>
    <link rel="SHORTCUT ICON" href="<%=basePath%>frontStage/users/images/favicon.ico">
<!-- <link href="<%=basePath%>pages/front/css/main.css" rel="stylesheet" type="text/css"> -->
<link href="<%=basePath%>frontStage/users/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>frontStage/users/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frontStage/users/css/bootstrap.min.css"></script>
<%--<link href="<%=basePath%>pages/front/css/style.css" rel="stylesheet" type="text/css">--%>
<!--[if IE]>
    <script src="js/html5.js"></script>
<![endif]--> 
<!--  <link rel="<%=basePath %>/css/common.css" type="text/css"></link>-->

<style type="text/css">
.head1 {
	width: 1000px;
	height: 100px;
	margin: 0 auto;
	border-bottom:3px solid #027D0B;
}
.login-logo {
	float: left;
}
.logo{
	width:293px;
	height: 97px;
}
.login-right {
	float: right;
}
.bottom {
	width: 1000px;
	height: 50px;
	margin: 0 auto;
}
.bottom p {
	height: 50px;
	line-height: 68px;
	color: #999999;
	text-align: center;

}
.login-right p {
	font-size: 14px;
	color: #999999;
	margin-top: 62px;
}
</style>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#confirm1").click(function(){
		$.ajax({
			url:"sendPsEmail.action",
			type:"post",
			cache:false,
			data:{"mail":$("#mail").val()},
			success:function(data){
				if(data=='ok'){
					alert("提交成功，重置密码链接已发送至你的邮箱，请在24小时内操作！");
				}else if(data=='toomuch'){
					alert("您之前有提交过重置密码请求，请到邮箱查收链接！");
				}else{
					alert("不存在该邮箱，请检查输入的邮箱是否正确！");
				}
			}
		});
	});
})
</script>

	<div class="main" style="min-height:500px">
<%--	<jsp:include page="header2.jsp"/>--%>
	<hr style="margin-top:0px">
	<div class="main_content">
		<div class="main_command">
			<form action="sendPsEmail.action" method="post" class="well" style="width:560px;margin:0 auto;padding-bottom:30px;background-color:#FCFDFF">
				<div class="pc_main_title page-header" style="margin-top: 20px; width: 380px;">
					<h3 style="font-weight:bold">忘记密码</h3>
				</div>
		
				<p class="explain" style="margin-top: 10px;">
				请输入您的登录邮箱，重置密码的链接将会发送至您的邮箱！
				</p>
				<div class="form-inline p_update" style="margin-top:30px">
					<label class="control-label" > 邮箱：</label>
					<input type="text" name="mail" id="mail" class="form-control " title="请输入邮箱" placeholder="请输入邮箱" />
					<input type="submit" id="confirm1" class="btn btn-primary"  value="提交"/>
					<div class="col-sm-10">
				      <p class="form-control-static" style="color:red;">${requestScope.message}</p>
				    </div>
					<%-- <div id="passwordTip" style="margin-left: 45px; color:red;margin-bottom:5px">${requestScope.message}</div> --%>
				</div>
			</form>
		</div> 

</div>
</div>
	</div>
	<%-- <jsp:include page="bottom.jsp"></jsp:include> --%>
<%--</div>--%>
</body>
</html>