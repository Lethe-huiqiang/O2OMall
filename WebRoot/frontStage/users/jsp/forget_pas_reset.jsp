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
<link href="<%=basePath%>pages/front/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>frontStage/users/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frontStage/users/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frontStage/users/js/formValidator.js"></script> 
<script type="text/javascript" src="<%=basePath%>frontStage/users/js/formValidatorRegex.js"></script> 
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

<div class="main" style="min-height:700px">
	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	
<%--<jsp:include page="header2.jsp"/>--%>
	<hr style="margin-top:0px">
	<div class="main_content">
		<div class="main_command" style="margin:0 auto;">
	<div>
		<p style="margin:0 auto;font-family:'黑体';font-size:22px;">重置密码</p>
	</div>
	<form action="<%=basePath%>changePass.action" id="change_form" method="post" class="well" style="width:550px;margin:0 auto;background-color:#FCFDFF">
		<p class="explain" style="margin-top: 10px;">
			（带<span class="fixed-fill">*</span>号为必填项目）
		</p>
		<input type="hidden" name="userId" id="userId" value="${requestScope.userId}">
		<input type="hidden" name="key" id="key" value="${requestScope.key}">
		<div class="form-group p_update">
			<label class="control-label" style="margin-left: 15px;">新密码：</label> <input type="password"
				name="newpassword" id="newpassword" class="control-ipt form-control"
				title="请输入密码"  /> <label class="control-lab">*</label>
				<div id="newpasswordTip" style="float: right; margin-left: 10px;"></div>
		</div>
		<div class="form-group p_update">
			<label class="control-label">确认密码：</label> <input type="password"
				name="repassword" id="repassword" class="control-ipt form-control"
				title="请输入密码"  /> <label class="control-lab">*</label>
				<div id="repasswordTip" style="float: right; margin-left: 10px;"></div>
		</div>
		
		<input type="submit" id="confirm" value="确认修改" class="btn btn-primary"/>
			
	</form>
<%-- 	<jsp:include page="bottom.jsp"></jsp:include> --%>
<!-- 	<script type="text/javascript" src="js/jquery.modaldialog.js"></script> -->
<!-- 	<script src="<%=basePath%>pages/front/js/formValidator.js" type="text/javascript" charset="UTF-8"></script> -->
	<script type="text/javascript">
		var reg = {
		    init: function() {
		        self = this;
		        $.formValidator.initConfig({
		            formid: "change_form",
		            onerror: function(msg) {
		                self.onError(msg);
		            },
		            onsuccess: function() {
		                //self.ajaxSubmit();
		            	//return false;//阻止事件冒泡
		            },
		        });
	
		        
		    $("#newpassword").formValidator({
		            onshow: "请输入密码",
		            oncorrect: "密码合法"
		        }).inputValidator({
		            min: 1,
		            empty: {
		                leftempty: false,
		                rightempty: false,
		                emptyerror: "密码两边不能有空符号"
		            },
		            onerror: "密码不能为空,请确认"
		        });
		        //确认密码
			$("#repassword").formValidator({
		            onshow: "请输入重复密码",
		            oncorrect: "密码一致"
		        }).inputValidator({
		            min: 1,
		            empty: {
		                leftempty: false,
		                rightempty: false,
		                emptyerror: "重复密码两边不能有空符号"
		            },
		            onerror: "重复密码不能为空,请确认"
		        }).compareValidator({
		            desid: "newpassword",
		            operateor: "=",
		            onerror: "两次密码不一致,请确认"
		        });
		        
		       },
			onError: function(msg) {
		        $.modaldialog.prompt(msg, {
		        	type:'warning',
		            width: 400,
		            title: '注册失败'
		        });
		    },
		    onSuccess: function(msg) {
		        $.modaldialog.prompt(msg, {
		            width: 400,
		            title: '注册成功'
		        });
		       // window.location.href='person.jsp';
		    },
			ajaxSubmit:function(){
			 $.ajax({
		            url: "changePass.action",
		            type: "post",
		            data: {"userId":$('#userId').val(),"pass":$('#newpassword').val(),"repassword":$('#repassword').val()},
		            cache: false,
		            ifModified: true,
		            success: function(data) {
			            console.log(data.message);
		                if (data.message == '修改成功！') {
		                	alert("修改成功！");
		                	//p.load('user_detail.action');
		                	window.location.href='/webjixie/frontStage/users/jsp/login.jsp';
		                }
		                else{
<%--		                	alert(data);--%>
							window.location.href='<%=basePath%>pages/front/jsp/requestUseless.jsp?message=\u8BE5\u8BF7\u6C42\u65E0\u6548\uFF01'
		                }
		            }
		        });
			 return false;//不刷新页面
			}
		};
		reg.init();

	</script>
</div>
</div>
</div>
</body>
</html>