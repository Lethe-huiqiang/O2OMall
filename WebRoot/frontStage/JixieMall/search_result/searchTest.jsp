<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jixie.bean.Commodity" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
    <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/css/head.css">
    <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/css/store.css">
    <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/shoppingcart/css/shoppingcart.css">
    
    <script language="JavaScript">
    var ETNGpager = function( srcName, dstName, cntPP, cntPS, dstPage )  
    {  
    this.srcName= srcName;  
    this.dstName= dstName;  
    this.dstPage = dstPage;  
    this.curP= 1;//默认当前页为第一页  
    this.cntPP= cntPP || 2;//默认每页两条纪录, 或者由用户指定的条数  
    this.cntPS= cntPS || 3;//默认每页显示3个分页上下文  
    this.items= [];  
    this.showPNP= true;/*显示上下页链接*/  
    this.showType= true;/*滑动分页*/  
    this.result= {pagedata:[],pagebar:'',limit:[0,0],report:''};  
    this.parse();/*总纪录数*/  
    }  
    ETNGpager.prototype.page = function (pagem){  
    this.cntP= Math.ceil(this.cntR/this.cntPP);/*总页数*/  
    this.cntS= Math.ceil(this.cntP/this.cntPS);/*总段数*/  
    this.curS= Math.ceil(this.curP/this.cntPS);/*当前段*/  
    this.preP= this.curP -1;/*上一页*/  
    this.nextP= this.curP +1;/*下一页*/  
    this.preS= this.curS -1;/*上一段*/  
    this.nextS= this.curS +1;/*下一段*/  
    this.startR= (this.curP -1)*this.cntPP + 1;/*起始纪录*/  
    this.endR= (this.curP*this.cntPP >this.cntR)?this.cntR:this.curP*this.cntPP;/*结束纪录*/  
    this.result['pagedata']=[];  
    if(this.showType){  
    this.perSide= Math.floor(this.cntPS/2);  
    this.startP= (this.curP > this.perSide)?(this.curP - this.perSide):1;  
    this.endP= (this.startP + this.cntPS)>this.cntP?this.cntP:(this.startP + this.cntPS);  
    }else{  
    this.startP= (this.curS-1)*this.cntPS+1;  
    this.endP= (this.curS*this.cntPS>this.cntP)?this.cntP:(this.curS*this.cntPS);  
    }  
    for(var i = this.startP;i<=this.endP;i++){  
    this.result['pagedata'].push((i==this.curP)?'<span class="curPage">'+i+'</span>':'<span  style="cursor:pointer; text-decoration:underline" mce_style="cursor:pointer; text-decoration:underline" onclick="'+pagem+'('+i+');" class="ctrlPages">'+i+'</span>');  
    }  
    if(this.showPNP){  
    if(this.curP>1)  
    this.result['pagedata'].unshift('<span  style="cursor:pointer; text-decoration:underline" mce_style="cursor:pointer; text-decoration:underline" onclick="'+pagem+'('+(this.curP-1)+');" class="ctrlPages">上一页</span>');  
    else  
    this.result['pagedata'].unshift('上一页');  
    if(this.curP<this.cntP)  
    this.result['pagedata'].push('<span  style="cursor:pointer; text-decoration:underline" mce_style="cursor:pointer; text-decoration:underline" onclick="'+pagem+'('+(this.curP+1)+');" class="ctrlPages">下一页</span>');  
    else  
    this.result['pagedata'].push('下一页');  
    }  
    //for(var j = this.endR-this.startR+1;j<this.cntPP;j++){ //加入空白行  
    //this.result['pagedata'].unshift('<br>');  
    //}  
    this.result['pagebar']= this.result['pagedata'].join('  ');  
    this.result['limit']= [this.startR,this.endR];  
    //this.result['report']= '共 <b>'+this.cntR+'</b> 条，当前页'+this.startR+'-'+this.endR+'，'+this.curP+'/'+this.cntP+' 页';  
    }  
    ETNGpager.prototype.parse = function (){  
    var obj = document.getElementById(this.srcName);  
    for(var i = 0;i<obj.childNodes.length;i++){  
    if(obj.childNodes[i].nodeType!=3)this.items[this.items.length]=obj.childNodes[i].innerHTML;  
    }  
    this.cntR = this.items.length;  
    return this.items.length;  
    }  
    ETNGpager.prototype.create=function(pagem){  
    this.page(pagem);  
    if(pagem=="page3")  
    {  
      if(this.endR != 0)  
      {  
        document.getElementById(this.dstName).innerHTML='<li class="show">'+this.items.slice(this.startR-1,this.endR).join('</li><li class="show">')+'</li>';  
      }  
         var tmpend = this.endR;  
         if(this.endR == 0)  
         {  
          tmpend = 1;  
         }  
         if(tmpend % 8 != 0 )  
         {  
            for(var i = 0; tmpend %8 != 0; i++)  
            {  
              tmpend ++ ;  
             document.getElementById(this.dstName).innerHTML = document.getElementById(this.dstName).innerHTML +"<li></li>";  
            }   
        }  
    }  
    else  
    {  
    document.getElementById(this.dstName).innerHTML='<li>'+this.items.slice(this.startR-1,this.endR).join('</li><li>')+'</li>';  
    }  
    document.getElementById(this.dstPage).innerHTML='<p class="colorPage">'+this.result['pagebar']+' '+this.result['report']+'</p>';  
    }  
    </script>  
    
  </head>
  
  <body>
  	 <!-- 头部 -->
    	<jsp:include  page="../commonhead.jsp"/>
    <s:if test="#request.searchresults.size!=0">
    共搜索到<font color="red"><s:property value="#request.searchresults.size"/></font>记录<br/>
  <s:else>
    no results found.
  </s:else>
  </s:if>
 <div class="cate_lg_box" id="store_search_goods_list">
    <div ectype="current_display_mode" class="squares">

           <ul class="list_pic" id="ul1temp" style="display:none">
      <s:iterator status="st"  value="#request.searchresults"> 
        <li data-id="4740" data-spec_id="7170" data-spec_qty="1" data-href="goods/4740">
          <div class="product_box">
         
            <p><a href="commoditySearch_commodityDetail.action?id=<s:property value='id' />">
            <img class="thumb_cart" src="<%=basePath%><s:property value='fileSource.path' />" height="220" width="220">
            </a></p>
            <h3>
              <span class="text_link">
                  <span class="depict">
                      <a class="name" target="_blank" href="commoditySearch_commodityDetail.action?id=<s:property value='id' />"><s:property value='name' /></a>
                  </span>
              </span>
              <span class="price"><del>¥</del><s:property value='price' /></span>
              <%--
              <del class="mk_price">¥<s:property value='price+400'/></del>--%>
              
              <b>总销量: <font style="font-weight:600;color:#c4918c;"><s:property value='salesvolume'/></font>  | <a style="color:#568396;"  href="">累加评价:6 </a></b>
              
              <a class="chaoshi-cart" onclick="setShortcutCart(7170,$(this));" href="javascript:;" title="加入购物车"></a>
            </h3>
            
          </div>
        </li>
       </s:iterator>         
      </ul>
      
      <ul id="ul1" class="list_pic">  
	    <li>加载中...</li>  
	   </ul>
       
   <div class="clear"></div>
   <div id="divpage1" style="margin-left:43%;margin-bottom:10px;"></div>
   <script language="javascript" type="text/javascript"><!--  
       
                var pager = new ETNGpager('ul1temp','ul1',4,3, "divpage1");  
                var curP = 1;  
                //showtime = setInterval("page()", 5000);  
                function page(i){  
                curP =(curP>pager.cntP)?1:curP;  
                if(i){  
                curP = n =i;  
                }else{  
                n = curP++;  
                }  
                pager.curP = (n>pager.cntP)?pager.cntP:n;  
                pager.create("page");  
                }  
                pager.curP = curP;  
                pager.create("page");  
        
    </script>  
   
    </div>
    
    <div class="shop_list_page">   </div>
   </div>
   
   <!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>
  </body>
  <script type="text/javascript">
  	function nextPage(){
  		
  	}
  </script>
</html>
