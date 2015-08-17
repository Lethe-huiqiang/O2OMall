<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.jixie.bean.Commodity" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <link type="text/css" rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/css/gs.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/css/head.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/css/store.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/shoppingcart/css/shoppingcart.css">
  </head>
  
  <body>
  	 <!-- 头部 -->
    	<jsp:include  page="../commonhead.jsp"/>
      
   <div class="cate_lg_box" id="store_search_goods_list">
    <div ectype="current_display_mode" class="squares">

      <ul class="list_pic">
      <s:iterator value="#request.pageModel.list"> 
        <li data-id="4740" data-spec_id="7170" data-spec_qty="1" data-href="goods/4740">
          <div class="product_box">
         
            <p><a href="commoditySearch_commodityDetail.action?id=<s:property value='id' />">
            <img class="thumb_cart" src="<%=basePath%><s:property value='fileSource.path' />" height="220" width="220" />
            </a></p>
            <h3>
              <span class="text_link">
                  <span class="depict">
                      <a class="name" target="_blank" href="commoditySearch_commodityDetail.action?id=<s:property value='id' />"><s:property value='name' /></a>
                  </span>
              </span>
              <span class="price">￥<s:property value='price' /></span>
              <b>总销量: <font style="font-weight:600;color:#c4918c;"><s:property value='salesvolume' /></font>  | <a style="color:#568396;"  href="">累加评价:6 </a></b>
              
              <a class="chaoshi-cart" onclick="setShortcutCart(7170,$(this));" href="javascript:;" title="加入购物车"></a>
            </h3>
            
          </div>
        </li>
       </s:iterator>         
      </ul>
       
   <div class="clear"></div>
    </div>
    
      <div class="" style="padding-left:40%">
        <a href="<%=basePath%>commoditySearch_searchByBrandOrCategory.action?searchCondition=<s:property value='#request.searchCondition' />&currentPage=<s:property value='#request.pm.currentPage-1' />">上一页</a>
        第<s:property value='#request.pm.currentPage'/>页
        <a href="<%=basePath%>commoditySearch_searchByBrandOrCategory.action?searchCondition=<s:property value='#request.searchCondition' />&currentPage=<s:property value='#request.pm.currentPage+1' />">下一页</a>
       	共<s:property value='#request.pm.totalPage'/>页
       	<form style="float:right;padding-right:60%;padding-bottom:10px;" action="<%=basePath%>commoditySearch_searchByBrandOrCategory.action?searchCondition=<s:property value='#request.searchCondition'/>" method="post">
       	<p>到第<input type="text" name="currentPage" style="width:30px">页<input type="submit" value="去"/></p>
       	</form>
       </div>
       
   </div>
  <!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>
</body>
</html>