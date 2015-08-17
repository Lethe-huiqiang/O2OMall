<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'article_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>frontStage/JixieMall/css/head.css" />
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>frontStage/JixieMall/css/store.css" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>frontStage/JixieMall/article/css/article.css" />
  <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery.min.js"></script>
  <script type="text/javascript">
  	$(function(){
      	$('.guide-img').hide();
	   });
  </script>
  </head>
  
  <body>
  <!-- 头部 -->
    	<jsp:include  page="../commonhead.jsp"/>
	<!-- 内容页面 -->

  <div class="article_content">
	<div class="blank"></div>
    	<div class="left">
        	<div class="art_left">
            <h2><b>文章分类</b></h2>
            	<div class="wrap">
                	<div class="wrap_child">
                   	 <div class="classify_list">
                        <ul>
	                        <li><a href="mallArticle_showArticleList.action?articleType=1">商城规则</a></li>
	                        <li><a href="mallArticle_showArticleList.action?articleType=2">商城活动</a></li>
	                        <li><a href="mallArticle_showArticleList.action?articleType=3">商城公告</a></li>
	                        <li><a href="mallArticle_showArticleList.action?articleType=4">校园咨询</a></li>
	                        <li><a href="mallArticle_showArticleList.action?articleType=5">合作咨询</a></li>	                        

	                    </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="right">
        <div class="shop_text_list"> 
         																											
            <table>
			 <tbody>
			 <s:iterator value="#request.articleList"> 	
			 	<tr> 
                    <td><a href="mallArticle_showArticleContent.action?articleId=<s:property value='id' /> " class="lebioa"><s:property value="name" /></a></td>
                    <td class="width9"><s:property value="createTime" /></td>
                </tr>    
               </s:iterator>            
                </tbody>
            
               </table>
  		            
        	</div>
		</div>
</div>

<!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>
  </body>
</html>
