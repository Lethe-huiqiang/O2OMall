<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta property="qc:admins" content="1441367700641055776375">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单生成成功</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>frontStage/JixieMall/css/head.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>frontStage/JixieMall/css/store.css" />
<script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery.min.js"></script>
<script>
$(function(){
    $('.guide-img').hide();
   });
</script>
</head>
<body>
<!-- 头部 -->
    <jsp:include  page="../commonhead.jsp"/>
 <div style="margin:0 auto;margin-left:280px;min-height: 300px;">  

<h2>订单确认成功，我们会尽快为您配送商品</h2>
<a href="commodity_showCommodityList.action" >返回商城首页</a>
<a href="order_showMyOrder.action" >查看我的订单</a>
</div> 

 <!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>
</body>

</html>