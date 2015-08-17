<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
if(session.getAttribute("users")==null){
	response.sendRedirect("login.html");
}
 %>
 
<input type="hidden" id="quanxian" value=<s:property value="#session.users.UType"/>>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>维修管理系统</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css" />
    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/outlook2.js"> </script>
    <script type="text/javascript">
    
    var _menus;
    
    if($('#quanxian').val()==2){
	
	 _menus = {
		                 "menus":[
						{"menuid":"8","icon":"icon-sys","menuname":"组长管理",
							"menus":[{"menuid":"21","menuname":"显示所有报修单","icon":"icon-set","url":"repairmanagement_gettable.action?pageModel.currentPage=1"},
									{"menuid":"22","menuname":"查看组员接单情况","icon":"icon-log","url":"repairmanagement_showachievement.action"},
									{"menuid":"23","menuname":"查看反馈情况","icon":"icon-page","url":"repairmanagement_showbosscomment.action"}
								]
						},{"menuid":"56","icon":"icon-sys","menuname":"管理系统详细规则",
							"menus":[{"menuid":"31","menuname":"流程详解","icon":"icon-nav","url":"rule/demo1.html"},
									{"menuid":"32","menuname":"评比明细","icon":"icon-nav","url":"rule/demo2.html"}
								]
						},{"menuid":"39","icon":"icon-sys","menuname":"其他操作",
							"menus":[{"menuid":"51","menuname":"文件操作","icon":"icon-nav","url":"menu2/tree2.html"},
									{"menuid":"53","menuname":"哈哈哈哈","icon":"icon-nav","url":"menu1/treegrid.html"}
								]
						}
				]};
				
				
				}
		else if($('#quanxian').val()==1){
			
			_menus = {
		                 "menus":[
						           {"menuid":"1","icon":"icon-sys","menuname":"我的报修单",
							      "menus":[
									{"menuid":"12","menuname":"派给我的维修单","icon":"icon-page","url":"repairmanagement_getmemtable.action"},
									{"menuid":"13","menuname":"已接维修单详情","icon":"icon-class","url":"repairclaim_showmemclaim.action"},
									{"menuid":"14","menuname":"总结我的维修单","icon":"icon-role","url":"repairmanagement_getID.action"},
									{"menuid":"15","menuname":"查看机主留言条","icon":"icon-nav","url":"repairmanagement_showleavewords.action"},
									{"menuid":"16","menuname":"查看机主的反馈","icon":"icon-log","url":"repairmanagement_showmemcomment.action"}
								    ]},
						{"menuid":"56","icon":"icon-sys","menuname":"管理系统详细规则",
							"menus":[{"menuid":"31","menuname":"流程详解","icon":"icon-nav","url":"rule/demo1.html"},
									{"menuid":"32","menuname":"评比明细","icon":"icon-nav","url":"rule/demo2.html"}
								]
						},{"menuid":"39","icon":"icon-sys","menuname":"其他操作",
							"menus":[{"menuid":"51","menuname":"文件操作","icon":"icon-nav","url":"menu2/tree2.html"},
									{"menuid":"53","menuname":"哈哈哈哈","icon":"icon-nav","url":"menu1/treegrid.html"}
								]
						}
				]};
		
		}
		else{
			location.href = "login.html";
		}
				
				
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 160,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }

        

        //修改密码
        function serverLogin() {
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');

            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post(
            	'users_newpass.action', 
            	function(msg) {
                msgShow('系统提示', '恭喜，密码修改成功！<br>您的新密码为：' + msg, 'info');
                $newpass.val('');
                $rePass.val('');
                close();
            });
            
        }

        $(function() {

            openPwd();

            $('#editpass').click(function() {
                $('#w').window('open');
            });

            $('#btnEp').click(function() {
                serverLogin();
            })

			$('#btnCancel').click(function(){closePwd();})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = 'users_adlogout.action';
                    }
                });
            })
        });
		
		
    </script>
    </head>
    <body class="easyui-layout" style="overflow-y: hidden"  scroll="no">
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;"> <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' /> </div>
    </noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体"> <span style="float:right; padding-right:20px;" class="head">欢迎 <s:property value="#session.users.nickname"/> <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span> <span style="padding-left:10px; font-size: 16px; "><img src="images/blocks.gif" width="20" height="20" align="absmiddle" />维修管理系统</span> </div>
<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
      <div class="footer">计算机协会</div>
    </div>
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
      <div id="nav" class="easyui-accordion" fit="true" border="false"> 
    <!--  导航内容 --> 
  </div>
    </div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
      <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
    <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
          <h1 style="font-size:24px;">欢迎使用维修管理系统</h1>
        </div>
  </div>
    </div>
<div region="east" title="其他" split="true" style="width:180px;overflow:hidden;">
      <div class="easyui-calendar"></div>
    </div>

<!--修改密码窗口-->
<div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 150px; padding: 5px;
        background: #fafafa;">
      <div class="easyui-layout" fit="true">
    <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
          <table cellpadding=3>
        <tr>
              <td>新密码：</td>
              <td><input id="txtNewPass" type="password" class="txt01" /></td>
            </tr>
        <tr>
              <td>确认密码：</td>
              <td><input id="txtRePass" type="password" class="txt01" /></td>
            </tr>
      </table>
        </div>
    <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;"> <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" > 确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a> </div>
  </div>
    </div>
<div id="mm" class="easyui-menu" style="width:150px;">
      <div id="mm-tabupdate">刷新</div>
      <div class="menu-sep"></div>
      <div id="mm-tabclose">关闭</div>
      <div id="mm-tabcloseall">全部关闭</div>
      <div id="mm-tabcloseother">除此之外全部关闭</div>
      <div class="menu-sep"></div>
      <div id="mm-tabcloseright">当前页右侧全部关闭</div>
      <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
      <div class="menu-sep"></div>
      <div id="mm-exit">退出</div>
    </div>
</body>
</html>