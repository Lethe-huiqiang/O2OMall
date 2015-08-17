<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addSuppliers.jsp' starting page</title>
    
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
       <div>
   
    <h1>计协商城_添加合作商家</h1><hr>
 <form action="suppliers_addSuppliers.action" method="post" enctype="multipart/form-data">   
         <div style="margin-bottom: 20px;">商家称谓：<input type="text" name="sup.name">        </div>
            
         <div style="margin-bottom: 20px;"> 商家公司名：<input type="text" name="sup.company">      </div>
          
          <div style="margin-bottom: 20px;"> 商家公司地址：<input type="text" name="sup.address"></div>
          
         <div style="margin-bottom: 20px;"> 商家联系电话：<input type="text" name="sup.phone"></div>
         
         <div style="margin-bottom: 20px;">  商家代表人姓名：<input type="text" name="sup.deputy"></div>
         
         <div style="margin-bottom: 20px;">经营品牌： <input type="text" name="sup.brand"/>  </div>
                         
         <div style="margin-bottom: 20px;">商家LOGO图：<input type="file" name="suppliersPicture" >   </div>
         <input type="submit" value="添加合作商家">
    </div>
   </form>
  </body>
</html>
