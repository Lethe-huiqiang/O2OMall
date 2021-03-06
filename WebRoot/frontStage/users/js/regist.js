$(function(){	
	$('#nickname').blur(function(){
		var name = $('#nickname').val();
		if(name==''){
			$('#validNickname').addClass('tips');
			$('#validNickname').parent().addClass('tipsWrap');//--
			$('#validNickname').html('昵称不能为空');
			$("#nickname").focus();
			$('#submitFlag').attr('value','');
		}else{
			$.ajax({ 
				url:'users_checkName.action',
				type:'post',
				data:{name_phone_mail:$('#nickname').val()},
				cache:false,
				success:function(data){
					if(data=='yes'){
						$('#validNickname').removeClass('tips');
						$('#validNickname').parent().removeClass('tipsWrap');
						$('#validNickname').html('');
						$('#submitFlag').attr('value','yes');
						$('#nameHidden').attr('value','true');
					}else if(data=='no'){
						$('#validNickname').addClass('tips');
						$('#validNickname').parent().addClass('tipsWrap');
						$('#validNickname').html('请不要重复登记，我们会尽快为您处理');
						$("#nickname").focus();
						$('#submitFlag').attr('value','');
					}else{
						alert('网络繁忙');
						$('#submitFlag').attr('value','');
					}
				}
			});
		}
			
	});
	
	$('#password').blur(function(){
		var password = $('#password').val();
		if(password==''){
			$('#validPassword').addClass('tips');
			$('#validPassword').parent().addClass('tipsWrap');
			$('#validPassword').html('密码不能为空');
			$('#password').focus();
			$('#submitFlag').attr('value','');
		}else if(password.length<6 || password.length>12){
			$('#validPassword').addClass('tips');
			$('#validPassword').parent().addClass('tipsWrap');
			$('#validPassword').html('密码应该在6-12位之间');
			$('#password').focus();
			$('#submitFlag').attr('value','');
		}else{
			$('#validPassword').removeClass('tips');
			$('#validPassword').parent().removeClass('tipsWrap');
			$('#validPassword').html('');
			$('#submitFlag').attr('value','yes');
			$('#passwordHidden').attr('value','true');
		}
	});
	
	$('#secondPassword').blur(function(){
		var secondPassword = $('#secondPassword').val();
		var password = $('#password').val(); 
		if(secondPassword==''){
			$('#validSecondPassword').addClass('tips');
			$('#validSecondPassword').parent().addClass('tipsWrap');//--
			$('#validSecondPassword').html('确认密码不能为空');
			$('#secondPassword').focus();
			$('#submitFlag').attr('value','');
		}else if(password!=secondPassword){
			$('#validSecondPassword').addClass('tips');
			$('#validSecondPassword').parent().addClass('tipsWrap');//--
			$('#validSecondPassword').html('两次密码不一致');
			$('#secondPassword').focus();
			$('#submitFlag').attr('value','');
		}else{
			$('#validSecondPassword').removeClass('tips');
			$('#validSecondPassword').parent().removeClass('tipsWrap');//--
			$('#validSecondPassword').html('');
			$('#submitFlag').attr('value','yes');
			$('#secondPasswordHidden').attr('value','true');
		}
	});
	
	/*$('#phone').blur(function(){
		var phone = $('#phone').val();
		var parten = /^\s*$/;
		var phone = phone.replace(/[ ]/g,"");
		if(phone==''){
			$('#validPhone').addClass('tips');
			$('#validPhone').parent().addClass('tipsWrap');//--
			$('#validPhone').html('手机号码不能为空');
			$('#phone').focus();
			$('#submitFlag').attr('value','');
		}else if(checkNum(phone)==false){
  			$('#validPhone').addClass('tips');
  			$('#validPhone').parent().addClass('tipsWrap');//--
			$('#validPhone').html('手机号码格式不正确');
			$('#phone').focus();
			$('#submitFlag').attr('value','');
		}else if(phone.length<7){
			$('#validPhone').addClass('tips');
			$('#validPhone').parent().addClass('tipsWrap');
			$('#validPhone').html('手机号码不能低于7位');
	  		$('#phone').focus();
			$('#submitFlag').attr('value','');
  		}else{
  			$.ajax({
				url:'member_checkName.action',
				type:'post',
				data:{name_phone_mail:$('#phone').val()},
				cache:false,
				success:function(data){
					if(data=='yes'){
						$('#validPhone').removeClass('tips');
						$('#validPhone').parent().removeClass('tipsWrap');//--
						$('#validPhone').html('');
						$('#submitFlag').attr('value','yes');
						$('#phoneHidden').attr('value','true');
					}else if(data=='no'){
						$('#validPhone').addClass('tips');
						$('#validPhone').parent().addClass('tipsWrap');
						$('#validPhone').html('此手机号码已被使用');
				  		$('#phone').focus();
						$('#submitFlag').attr('value','');
					}else{
						alert('网络繁忙');
						$('#submitFlag').attr('value','');
					}
				}
			});
		}
	});*/
	
	$('#email').blur(function(){
		var email = $('#email').val();
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(email==''){
			$('#validEmail').addClass('tips');
			$('#validEmail').parent().addClass('tipsWrap');
			$('#validEmail').html('邮箱不能为空');
			$('#email').focus();
			$('#submitFlag').attr('value','');
		}else if(!myreg.test(email)){
			$('#validEmail').addClass('tips');
			$('#validEmail').parent().addClass('tipsWrap');
			$('#validEmail').html('邮箱格式不正确');
			$('#email').focus();
			$('#submitFlag').attr('value','');
		}else{
			$.ajax({
				url:'users_checkName.action',
				type:'post',
				data:{name_phone_mail:$('#email').val()},
				cache:false,
				success:function(data){
					if(data=='yes'){
						$('#validEmail').removeClass('tips');
						$('#validEmail').parent().removeClass('tipsWrap');
						$('#validEmail').html('');
						$('#submitFlag').attr('value','yes');
						$('#emailHidden').attr('value','true');
					}else if(data=='no'){
						$('#validEmail').addClass('tips');
						$('#validEmail').parent().addClass('tipsWrap');
						$('#validEmail').html('此邮箱已被使用');
						$('#email').focus();
						$('#submitFlag').attr('value','');
					}else{
						alert('网络繁忙');
						$('#submitFlag').attr('value','');
					}
				}
			});
			
		}
	});
	
	//点击同意条款
	$('#agreeNode').click(function(){
		if(getSelectCount("agreeNode")>0){
			$('#registeNode').removeAttr("disabled");
			$('#registeNode').attr('style','background:#0697d5');
		}else{
			$('#registeNode').attr('disabled','true');
			$('#registeNode').attr('style','background:#D1D1D1');
		}
	});
		
});
		
	//登陆按钮
	function login(){
		location.href= $('#basePath').val()+'frontStage/front/index.jsp' ;
	}
	 
	//注册按钮  agreeNode
	function register(){
		var flag = $('#submitFlag').val();
		var nameHidden = $('#nameHidden').val();
		var passwordHidden = $('#passwordHidden').val();
		var secondPasswordHidden = $('#secondPasswordHidden').val();
//		var phoneHidden = $('#phoneHidden').val();
		var emailHidden = $('#nameHidden').val();
		var fromDate = "";
		var email = $('#email').val();
		formDate = $('#registerForm').serialize();
		if(flag=='yes'&&nameHidden=='true'&&passwordHidden=='true'&&
			secondPasswordHidden=='true'&&emailHidden=='true'){  //&&phoneHidden=='true'
			$.ajax({
				url:'users_regist.action',
				type:'post',
				data:formDate,
				cache:false,
				success:function(data){
					if(data=='yes'){
						alert('注册成功！ Have fun！请先到邮箱验证账号吧！');	
						//location.href='users_usersInfoUI.action';
						$('#registerForm').attr('style','display:none;');
						$('.step1 .li1').attr('style','background:#D1D1D1');
						$('.step1 .li2').attr('style','background:#0697d5');
						$('.reg_login p').html("还差一步就能完成注册啦！");
						$('.reg_login a').attr('href','http://mail.'+email.split('@')[1]);
						$('.btn2').attr('style','background:#0697d5;');
						$('.reg_login a').html('点击到邮箱完成激活');
						
					}else{
						alert('注册失败！');
					}
				}
			});
//			document.getElementById("registerForm").submit();
				
		}else{
			alert('请先输入正确的注册信息！');
		}
	}
	
	//是否是数字
	function checkNum(input){
		var re =  /^[1-9]+[0-9]*]*$/;   // /^[1-9]+[0-9]*]*$/
	    if (!re.test(input)){
	    	return false;
	    }
	    return true;
	}
	
	//选中的个数
	function getSelectCount(checkboxName) {
	    var chks = document.getElementsByName(checkboxName);
	    var j = 0;
	    for (i = 0; i < chks.length; i++) {
	        if (chks[i].checked) {
	            j++;
	        }
	    }
	    return j;
	}
	