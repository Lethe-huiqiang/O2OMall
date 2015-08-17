	function userslogin(){
//		window.location('http://www.cctv.com');
		$.ajax({
			url:'users_login.action',
			type:'post',
			data:{email:$('#email').val(),password:$('#password').val(),referer:$('#referer').val()},
			cache:false,
			success:function(data){
				if(data=='error'){
					$('#validation').addClass('tips');
					$('#validation').addClass('tipsWrap');
					$('#validation').html('服务器繁忙!');
//					alert('登录成功!');
//					window.open('common_askPages.action?page=usersMain');
				}else if(data=='wrong'){
					$('#validation').addClass('tips');
					$('#validation').addClass('tipsWrap');
					$('#validation').html('用户名不存在或密码错误！登录失败！');
				}else{
					$('#validation').removeClass('tips');
					$('#validation').removeClass('tipsWrap');
					$('#validation').html('登录成功!');
					location.href = data;
				}
			}
		});
	}
