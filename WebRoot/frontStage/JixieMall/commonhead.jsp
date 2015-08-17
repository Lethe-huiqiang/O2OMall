<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<div class="nav">
			<div class="nav-content">
				<div class="nav-wel"><span id="userName">Hi,${session.users.nickname}</span><span>欢迎来到计协商城！</span>
				<s:if test="#session.users.nickname!=null">
					<a href="users_logouts.action">退出登录</a>
				</s:if>
				<s:else>
				<span><a href="<%=basePath%>frontStage/users/jsp/login.jsp">[登录]</a><a href="<%=basePath%>frontStage/users/jsp/regist.jsp">[免费注册]</a></span>
				</s:else>
				</div>
				
				<div class="nav-ul">
					<ul>
						<li><a href="order_showMyOrder.action">我的订单</a></li>
						<li>|</li>
						<li><a href="shoppingcart_myShoppingCart.action">购物车</a></li>
						<li>|</li>
						<li><a href="<%=basePath%>frontStage/JixieMall/person_page/person_page.jsp?request=favorite">收藏夹</a></li>
						<li>|</li>
						<li><a href="<%=basePath%>frontStage/JixieMall/person_page/person_page.jsp?request=userCenter">个人中心</a></li>
					</ul>
				</div>
			</div>
	</div>

		<!-- logo和搜索 -->
		<div class="logo">
			<div class="logo-content">
				<div class="logo-logo"><a href="commodity_showCommodityList.action"><img src="<%=basePath%>frontStage/JixieMall/person_page/images/logo.png"></a></div>
				<div class="logo-shop"><img src="<%=basePath%>frontStage/JixieMall/person_page/images/shop.png"></div>
				<div class="logo-btngroup">
				 <%--<form action="commoditySearch_search.action"  method="post">
				   <s:textfield name="queryString" label="搜索产品"/>
				         
				         <input  class="logo-btn" type="submit"  value="搜索"/>
				       <s:submit></s:submit>
				      </form>
				    --%>
				    		    
				    <a href="javascript:void(0);" onclick="location='commoditySearch_search.action?queryString='+document.getElementById('queryString').value;" class="logo-btn">搜索</a>
				    <input id="queryString" class="btn-input" type="search" placeholder="请输入你要搜索的品牌或商品名" />
					
				</div>
			</div>
		</div>

		<!-- 导航栏 -->
		<div class="guide">
			<div class="guide-content">
				<div class="guide-img"><img src="<%=basePath%>frontStage/JixieMall/person_page/images/03.png"></div>
				<div class="guide-ul">
					<ul>
						<li><a href="commodity_showCommodityList.action">商城首页</a></li>
						<li>|</li>
						<li><a href="commoditySearch_searchByBrandOrCategory.action?currentPage=1&searchCondition=all">全部商品</a></li>
						<li>|</li>
						<li><a href="#">U盘</a></li>
						<li>|</li>
						<li><a href="#">手机</a></li>
						<li>|</li>
						<li><a href="#">笔记本</a></li>
						<li>|</li>
						<li><a href="#">鼠标</a></li>
						<li>|</li>
						<li><a href="#">键盘</a></li>
					</ul>
				</div>
			</div>
			
		</div>