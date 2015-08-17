<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jixie.bean.Commodity" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% Commodity commodity=(Commodity)request.getAttribute("commodity");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>计算机协会网上商城</title>
    
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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontStage/JixieMall/css/style.css" />
    <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery.min.js"></script>
<script type="text/javascript">


    //搜素商品类型或品牌
    function searchByBrandOrCategory(obj){
          var searchCondition=obj.innerHTML;
          var currentPage=1;
          window.location.href="commoditySearch_searchByBrandOrCategory.action?currentPage="+currentPage+"&&searchCondition="+searchCondition;
        }
</script>

</head>
<body>
  
   <!-- 头部 -->
    	<jsp:include  page="commonhead.jsp"/>
	<!-- 内容页面 -->
		<div class="content">
			<div class="content-content">
				<div class="content-pic">
					<div class="content-left">
						<ul class="classify">
							<li>
								<div>笔记本</div>
								<ul class="eachclass">
									<li><a href="#">华硕</a></li>
									<li>|</li>
									<li><a href="#">惠普</a></li>
									<li>|</li>
									<li><a href="#">戴尔</a></li>
								</ul>
							</li>
							<li>
								<div>U盘</div>
								<ul class="eachclass">
									<li><a href="#">金士顿</a></li>
									<li>|</li>
									<li><a href="#">爱国者</a></li>
									<li>|</li>
									<li><a href="#">闪迪</a></li>
								</ul>
							</li>
							<li>
								<div>鼠标</div>
								<ul class="eachclass">
									<li><a href="#">技嘉</a></li>
									<li>|</li>
									<li><a href="#">双飞燕</a></li>
									<li>|</li>
									<li><a href="#">戴尔</a></li>
								</ul>
							</li>
							<li>
								<div>键盘</div>
								<ul class="eachclass">
									<li><a href="#">双飞燕</a></li>
								</ul>
							</li>
							
							<li>
								<div>手机</div>
								<ul class="eachclass">
									<li><a href="#">Iphone</a></li>
									<li>|</li>
									<li><a href="#">华为</a></li>
									<li>|</li>
									<li><a href="#">小米</a></li>
								</ul>
							</li>
							<!-- <li>
								<div>个人护理</div>
								<ul class="eachclass">
									<li><a href="#">洗发水</a></li>
									<li>|</li>
									<li><a href="#">沐浴露</a></li>
								</ul>
							</li> -->
						</ul>
					</div>
					<div class="content-center">
	                         <div class="banner">
	                         	<ul>
						        <li><a href="#" title=""><img width="509px" height="269" src="<%=basePath%>frontStage/JixieMall/images/banner1.png" alt="" /></a></li>
						        <li><a href="#" title=""><img width="509px" height="269" src="<%=basePath%>frontStage/JixieMall/images/banner2.png" alt="" /></a></li>
						        <li><a href="#" title=""><img width="509px" height="269" src="<%=basePath%>frontStage/JixieMall/images/mallshow3.jpg" alt="" /></a></li>
						        				     
	                        </ul>		
	                        </div>
	                    <!--  
						<div class="content-center-bottom">
							<div></div>
							<div></div>
							<div></div>
						</div>
						-->
					</div>
					<div class="content-right-top"><img width="143px" height="106px" src="<%=basePath%>frontStage/JixieMall/images/massage.png"/></div>
					<div class="content-right-center"><img src="<%=basePath%>frontStage/JixieMall/images/activity1.png"/></div>
					<div class="content-right-bottom"><img src="<%=basePath%>frontStage/JixieMall/images/activity2.png"/></div>
				</div>
			</div>
		</div>
	<!-- 楼层 -->
		<div  class="store_index_box">
			<div class="class_goods_box" id="f1">
	            <div class="hd">
	                <h2 class="bg1">
	                    <a href="commoditySearch_searchByBrandOrCategory.action?currentPage=1&searchCondition=phone" target="_blank">手&nbsp&nbsp机</a>
	                </h2>
	                <div class="class_box">
	                    <div>
	                     <ul>
	                         <li><a href="javascript:void(0)" onclick="searchByBrandOrCategory(this)" target="_blank">iphone</a> </li>
	                         <li><a href="javascript:void(0)" onclick="searchByBrandOrCategory(this)" target="_blank">samsung</a> </li>
	                         <li><a href="javascript:void(0)" onclick="searchByBrandOrCategory(this)" target="_blank">HTC</a> </li>
	                         <li><a href="javascript:void(0)" onclick="searchByBrandOrCategory(this)" target="_blank">垃圾牌</a> </li>
	                         <li><a href="javascript:void(0)" onclick="searchByBrandOrCategory(this)" target="_blank">华为</a> </li>
	                         <li><a href="javascript:void(0)" onclick="searchByBrandOrCategory(this)" target="_blank">联想</a> </li>
	                         <li><a href="javascript:void(0)" onclick="searchByBrandOrCategory(this)" target="_blank">诺基亚</a> </li>
	                    </ul>
	                    </div>
	                </div>
	                <div class="more"><a href="commoditySearch_searchByBrandOrCategory.action?currentPage=1&searchCondition=phone">More&nbsp
	                <img src="<%=basePath%>frontStage/JixieMall/images/more.png"> </a></div>
	            </div>
	            <div class="bd">
	                <div class="goods_box_l">
	                    <a href="" target="_blank">
	                        <img title="手机" src="<%=basePath%>frontStage/JixieMall/images/leftphone.png" height="390" width="190">
	                     </a>
	                </div>
	                 <div class="goods_box_r">
	                  <s:iterator value="#request.categoryList[0]">
	                 	 <ul>
	                 	 	<li>
	                 	 		<a href="commoditySearch_commodityDetail.action?id=<s:property value='id' />">
	                 	 		<img src="<%=basePath%><s:property value='fileSource.path' />" height="180" width="180" />
	                                <p class="statis">
	                                已售: <font><s:property value='salesvolume' /></font> 件 | 
	                                <span>评论:68 </span></p>
	                                <p class="name">
	                                 <s:property value='name' /></p>
	                                <p class="price">
		                                <strong>¥</strong><span> <s:property value='price' /></span> / 
		                                <del><s:property value='price*1.2'/>  </del>
                                   </p>
	                 	 		</a>
	                 	 	</li>             	 	
	                 	 </ul>
	                  </s:iterator>
	                 </div>
	                </div>
	                
	            </div>
	            <div class="class_goods_box" id="f2">
	            <div class="hd">
	                <h2 class="bg2">
	                    <a href="commoditySearch_searchByBrandOrCategory.action?currentPage=1&searchCondition=Udisk" target="_blank">U&nbsp&nbsp盘</a>
	                </h2>
	                <div class="class_box">
	                    <div>
	                     <ul>
	                         <li><a href="" target="_blank">金士顿</a> </li>
	                         <li><a href="" target="_blank">爱国者</a> </li>
	                         <li><a href="" target="_blank">联想</a> </li>
	                         <li><a href="" target="_blank">闪迪</a> </li>
	                         <li><a href="" target="_blank">华为</a> </li>
	                         <li><a href="" target="_blank">西数</a> </li>
	                    </ul>
	                    </div>
	                </div>
	                <div class="more"><a href="">More&nbsp<img src="<%=basePath%>frontStage/JixieMall/images/more.png"> </a></div>
	            </div>
	            <div class="bd">
	                <div class="goods_box_l">
	                    <a href="" target="_blank">
	                        <img title="手机" src="<%=basePath%>frontStage/JixieMall/images/showleft.png" height="390" width="190">
	                     </a>
	                </div>
	                 <div class="goods_box_r">
	                 <s:iterator value="#request.categoryList[1]">
	                 	 <ul>
	                 	 	<li>
	                 	 		<a href="commoditySearch_commodityDetail.action?id=<s:property value='id' />">
	                 	 		<img src="<%=basePath%><s:property value='fileSource.path' />" height="180" width="180" />
	                                <p class="statis">
	                                已售: <font><s:property value='salesvolume' /></font> 件 | 
	                                <span>评论:68 </span></p>
	                                <p class="name">
	                                <s:property value='name' /></p>
	                                <p class="price">
                                <strong>¥</strong><span> <s:property value='price' /></span> / 
                                <del><s:property value='price*1.2'/>  </del>
                                </p>
	                 	 		</a>
	                 	 	</li>
	                 	 	
	                 	 </ul>
	                   </s:iterator>
	                 </div>
	                </div>
	                
	            </div>
	        </div>
<!-- 尾部 -->
<jsp:include  page="commonfooter.jsp"/>

<script src="<%=basePath%>frontStage/JixieMall/js/jquery.min.js"></script>  
<script src="<%=basePath%>frontStage/JixieMall/js/unslider.js"></script>
<!-- 图片自动切换jq控制 -->
 <script type="text/javascript" >
			$(function() {
		$('.banner').unslider();
		$('.banner').unslider({
	speed: 500,               //  The speed to animate each slide (in milliseconds)
	delay: 3000,              //  The delay between slide animations (in milliseconds)
	complete: function() {},  //  A function that gets called after every slide animation
	keys: true,               //  Enable keyboard (left, right) arrow shortcuts
	dots: true,               //  Display dot navigation
	fluid: false              //  Support responsive design. May break non-responsive designs
});
	});
    
 </script>
</body>
</html>