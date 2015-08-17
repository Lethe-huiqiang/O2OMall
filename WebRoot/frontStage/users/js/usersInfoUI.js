var nicknameFlag=true;
var emailFlag=true;

$(function(){
	$('#nickname').blur(function(){
		var name = $('#nickname').val();
		if(name==''){
			$('#validNickname').addClass('tips');
			$('#validNickname').addClass('tipsWrap');//--
			$('#validNickname').html('昵称不能为空');
			$("#nickname").focus();
			nicknameFlag=false;
			/*$('#submitFlag').attr('value','');*/
		}else{
			$.ajax({
				url:'users_checkName.action',
				type:'post',
				data:{name_phone_mail:$('#nickname').val(),usersId:$('#id').val()},
				cache:false,
				success:function(data){
					if(data=='yes'){
						$('#validNickname').removeClass('tips');
						$('#validNickname').removeClass('tipsWrap');
						$('#validNickname').html('');
						nicknameFlag=true;
						/*$('#submitFlag').attr('value','yes');*/
						$('#nameHidden').attr('value','true');
					}else if(data=='no'){
						$('#validNickname').addClass('tips');
						$('#validNickname').addClass('tipsWrap');
						$('#validNickname').html('此昵称已被使用');
						$("#nickname").focus();
						nicknameFlag=false;
						/*$('#submitFlag').attr('value','');*/
					}else{
						alert('网络繁忙');
						nicknameFlag=false;
						/*$('#submitFlag').attr('value','');*/
					}
				}
			});
		}
			
	});
	
	$('#email').blur(function(){
		var email = $('#email').val();
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.|\-]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(email==''){
			$('#validEmail').addClass('tips');
			$('#validEmail').addClass('tipsWrap');
			$('#validEmail').html('邮箱不能为空');
			$('#email').focus();
			emailFlag=false;
			/*$('#submitFlag').attr('value','');*/
		}else if(!myreg.test(email)){
			$('#validEmail').addClass('tips');
			$('#validEmail').addClass('tipsWrap');
			$('#validEmail').html('邮箱格式不正确');
			$('#email').focus();
			emailFlag=false;
			/*$('#submitFlag').attr('value','');*/
		}else{
			$.ajax({
				url:'users_checkName.action',
				type:'post',
				data:{name_phone_mail:$('#email').val(),usersId:$('#id').val()},
				cache:false,
				success:function(data){
					if(data=='yes'){
						$('#validEmail').removeClass('tips');
						$('#validEmail').removeClass('tipsWrap');
						$('#validEmail').html('');
						emailFlag=true;
						/*$('#submitFlag').attr('value','yes');*/
						$('#emailHidden').attr('value','true');
					}else if(data=='no'){
						$('#validEmail').addClass('tips');
						$('#validEmail').addClass('tipsWrap');
						$('#validEmail').html('此邮箱已被使用');
						$('#email').focus();
						emailFlag=false;
						/*$('#submitFlag').attr('value','');*/
					}else{
						alert('网络繁忙');
						emailFlag=false;
						/*$('#submitFlag').attr('value','');*/
					}
				}
			});
			
		}
	});
	
});


function updateUsersInfo(){ 
	/*var fromDate = "";
	formDate = $('#usersInfoForm').serialize();*/
	if (nicknameFlag==true&&emailFlag==true){
		document.forms[0].submit();
		alert('提交个人信息成功！');
	}else{
		alert('请先输入正确的注册信息！')
	}
//		commonUpdateUsersInfo(formDate);
	
};
	
function commonUpdateUsersInfo(formDate){
	$.ajax({
		url:'users_usersInfoFulfil.action',
		type:'post',
		data:formDate,
		cache:false,
		success:function(data){
			if(data=='ok'){
				alert('个人信息修改成功!');
				window.location("common_usersMain.action");
			}else{
				alert('系统繁忙,请稍后再试!');
			}
		}
	});
	
}