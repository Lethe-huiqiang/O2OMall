<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
      	var a=$("#articleType");
      	var type=a.text();
      	if(type==1){
      		a.text("商城规则");
          	}else if(type==2){
				a.text("商城活动");
              	}
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
	                        <li><a href="">商城公告</a></li>
	                        <li><a href="">投诉/建议</a></li>
	                        <li><a href="">校园咨询</a></li>
	                        <li><a href="">合作咨询</a></li>	                        

	                    </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="right">
        <div class="article_wrap">
			<div class="keyword">  		
    		<a>商城文章</a> &gt;
    		<a href="mallArticle_showArticleList.action?articleType=<s:property value="#request.article.type" />" id="articleType"><s:property value="#request.article.type" /></a> &gt;
		  文章内容
        </div>
            <div class="article_con">
                <h1><s:property value="#request.article.name" /></h1>
                <h2><s:property value="#request.article.createTime" /></h2>
                <div class="default">
                      <s:property value="#request.article.content" escape="false"/>
                 </div>

               
            </div>
        </div>
		</div>
</div>

<!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>
  </body>
</html>
