<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/css/head.css">
    <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/create_order/css/order.css">

<script type="text/javascript">
    function createOrder(){
        document.getElementById("orderForm").submit();
    }
</script>
  </head>
  
  <body>
<!-- 头部 -->
    <jsp:include  page="../commonhead.jsp"/>
 <!-- 订单信息内容 -->
    <div class="ordercontent">
    	<div class="orderhead">
    		<img src="<%=basePath%>frontStage/JixieMall/create_order/images/write.png">
    		<span>填写并核对订单信息</span>
    	</div>
    	<div class="orderinfo">
    	  <form action="order_createOrder.action" method="post" id="orderForm">
    	    <div class="userinfo">
    	    	 <div>
    	    	 	<span>收货地址：</span><input  class="input" type="text" name="order.receiverInfo" />
    	    	 </div>
    	    	 <div>
    	    	    <span>收货人：</span><input class="input" type="text" name="order.receiver"/>
    	    	 	<span>联系电话：</span><input class="input" type="text" name="order.usersPhone"/>
    	    	 </div>
    	    	 <div>
    	    	 	<span>支付方式：</span>
			         <input type="radio"  name="typex" checked="checked" /><span>货到付款</span>
			         <input type="hidden" name="orderItem.buynum" />
    	    	 </div>
    	    </div>
    	  </form>
    	 <div class="cartinfo">
    	     <div class="ordertitle">订单详情：</div>
    	   <div class="tableinfo">
	    	 <table class="table" > 
		     	  <thead>
		            <tr>				
						<th>商品名称</th>
						<th>商品种类</th>
						<th>商品单价</th>
						<th>购买数量</th>				
						<th>金额小计</th>				
			        </tr>  	   
			      </thead>
			    <c:set var="money" value="0" />
			<s:iterator value="#session.cartmap">
				  <tr>
				   			    
				    <td>  
				          <p class="name">
	                       <s:property value='key.name' />
	                      </p>     
	                </td>
				    <td>
				          <p class="category">
	                         <s:property value='key.category' />
	                      </p> 
				    </td>
				    <td>
				         <p class="price">			           
	                       <s:property value='key.price' />
	                      </p>   
				    </td>
				    <td>
				        <p class="number">                     
	                       <s:property value='value' />                
	                      </p> 
				    </td>			    
				    <td>
				         <p class="sumprice">
				           <s:property value='key.price* value' />
                            <c:set var="money" value="${money + key.price * value }"/>
				         </p>
				    </td>
				    			  
				</tr>
			</s:iterator>
            </table>
            <div class="infofooter">
            	<span class="fl">购物金额（不含运费）:￥${money }</span>
	    	 	<span class="fl">配送费用:￥0.00</span>
	    	 	<span class="fr">应付金额合计（含运费）:￥${money }</span>
            </div>
           </div>
    	  </div>

    	</div>

    	<div class="orderfooter">
    	    <span>应付金额合计（含运费）:￥${money }</span><br> 	    
    		<div class="gotopay"><a href="javascript:createOrder()">提交订单</a></div>
    		<div class="gotoshop"><a href="commodity_showCommodityList.action">继续购物</a></div>
    	</div>
    </div>
		
     <!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>

	</body>
</html>
