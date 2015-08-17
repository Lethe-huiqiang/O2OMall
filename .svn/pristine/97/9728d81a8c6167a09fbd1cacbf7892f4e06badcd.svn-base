$(function(){	
	$('#macOwner').blur(function(){
		var macOwner = $('#macOwner').val();
		if(macOwner==''){
			$('#validMacOwner').addClass('tips');
			$('#validMacOwner').parent().addClass('tipsWrap');//--
			$('#validMacOwner').html('机主名不能为空');
			$("#macOwner").focus();
			$('#submitFlag').attr('value','');
		}
		else{
			$.ajax({
				url:'repairclaim_checkName.action',
				type:'post',
				data:{macOwner:$('#macOwner').val()},
				cache:false,
				success:function(data){
					if(data=='yes'){
						$('#validMacOwner').removeClass('tips');
						$('#validMacOwner').parent().removeClass('tipsWrap');
						$('#validMacOwner').html('');
						$('#submitFlag').attr('value','yes');
						$('#macOwnerHidden').attr('value','true');
					}else if(data=='no'){
						$('#validMacOwner').addClass('tips');
						$('#validMacOwner').parent().addClass('tipsWrap');
						$('#validMacOwner').html('你的账号已登记报修，请耐心等候');
						$("#macOwner").focus();
						$('#submitFlag').attr('value','');
						$('#submitA').attr('disabled',"true");
					}else{
						alert('请先登录');
						$('#submitFlag').attr('value','');
						$('#submitA').attr('disabled',"true");
						location.href = "frontStage/users/jsp/login.jsp";
					}
				}
			});
		}
	});
	
	//还没测试是否数字
	$('#longTel').blur(function(){
		var longTel = $('#longTel').val();
		if(longTel==''){
			$('#validLongTel').addClass('tips');
			$('#validLongTel').parent().addClass('tipsWrap');
			$('#validLongTel').html('长号不能为空');
			$('#longTel').focus();
			$('#submitFlag').attr('value','');
		}else if(longTel.length!=11){
			$('#validLongTel').addClass('tips');
			$('#validLongTel').parent().addClass('tipsWrap');
			$('#validLongTel').html('您输入的长号长度有误');
			$('#longTel').focus();
			$('#submitFlag').attr('value','');
		}else{
			$('#validLongTel').removeClass('tips');
			$('#validLongTel').parent().removeClass('tipsWrap');
			$('#validLongTel').html('');
			$('#submitFlag').attr('value','yes');
			$('#longTelHidden').attr('value','true');
		}
	});
	

	
	
	$('#address').blur(function(){
		var address = $('#address').val();
		if(address==''){
			$('#validAddress').addClass('tips');
			$('#validAddress').parent().addClass('tipsWrap');//--
			$('#validAddress').html('地址不能为空');
			$('#address').focus();
			$('#submitFlag').attr('value','');
		}else{
			$('#validAddress').removeClass('tips');
			$('#validAddress').parent().removeClass('tipsWrap');//--
			$('#validAddress').html('');
			$('#submitFlag').attr('value','yes');
			$('#addressHidden').attr('value','true');
		}
	});
	
	
	
	$('#description').blur(function(){
		var description = $('#description').val();
		if(description==''){
			$('#validDescription').addClass('tips');
			$('#validDescription').parent().addClass('tipsWrap');
			$('#validDescription').html('描述不能为空');
			$('#description').focus();
			$('#submitFlag').attr('value','');
		}else if(description.length>200){
			$('#validDescription').addClass('tips');
			$('#validDescription').parent().addClass('tipsWrap');
			$('#validDescription').html('请输入少于200字的描述');
			$('#description').focus();
			$('#submitFlag').attr('value','');
		}else{
			$('#validDescription').removeClass('tips');
			$('#validDescription').parent().removeClass('tipsWrap');
			$('#validDescription').html('');
			$('#submitFlag').attr('value','yes');
			$('#descriptionHidden').attr('value','true');
		}
	});
	
	
	
	//点击同意条款
	$('#agreeNode').click(function(){
		if(getSelectCount("agreeNode")>0){
			$('#registeNode').removeAttr("disabled");
		}else{
			$('#registeNode').attr('disabled','true');
		}
	});
		
});
		
	//登陆按钮
	function login(){
		location.href= $('#basePath').val()+'frontStage/front/index.jsp' ;
	}
	 
	//登记按钮
	function repairclaim(){
//		var flag = $('#submitFlag').val();
		var macOwnerHidden = $('#macOwnerHidden').val();
		var longTelHidden = $('#longTelHidden').val();
		var addressHidden = $('#addressHidden').val();
		var descriptionHidden = $('#descriptionHidden').val();
		var submitFlag = $('#submitFlag').val();
		var fromDate = "";
		formDate = $('#repairForm').serialize();
		if(/*macOwnerHidden=='true'&&*/longTelHidden=='true'&&
		  addressHidden=='true'&&descriptionHidden=='true'){  //&&phoneHidden=='true'
			$.ajax({
				url:'repairclaim_repairclaim.action',
				type:'post',
				data:formDate,
				cache:false,
				success:function(data){
					if(data=='yes'){
						alert('登记成功，我们会尽快为您处理！');	
						//location.href='users_usersInfoUI.action';
						$('#submitA').attr("disabled","disabled");
					}else{
						alert('登记失败！');
					}
				}
			});
//			document.getElementById("registerForm").submit();
				
		}else{
			alert('请先输入正确的信息！');
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
	