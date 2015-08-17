$(function(){	
	
	$('#machine').blur(function(){
		var machine = $('#machine').val();
		if(machine==''){
			$('#validMachine').addClass('tips');
			$('#validMachine').parent().addClass('tipsWrap');//--
			$('#validMachine').html('型号不能为空');
			$("#machine").focus();
			$('#submitFlag').attr('value','');
		}
		else{
			$('#validMachine').removeClass('tips');
			$('#validMachine').parent().removeClass('tipsWrap');
			$('#validMachine').html('');
			$('#submitFlag').attr('value','yes');
			$('#machineHidden').attr('value','true');
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
		}else{
			$('#validDescription').removeClass('tips');
			$('#validDescription').parent().removeClass('tipsWrap');
			$('#validDescription').html('');
			$('#submitFlag').attr('value','yes');
			$('#descriptionHidden').attr('value','true');
		}
	});
	

	
	
/*	$('#label').blur(function(){
		var label = $('#label').val();
		if(label==''){
			$('#validLabel').addClass('tips');
			$('#validLabel').parent().addClass('tipsWrap');//--
			$('#validLabel').html('标签不能为空');
			$('#label').focus();
			$('#submitFlag').attr('value','');
		}else{
			$('#validLabel').removeClass('tips');
			$('#validLabel').parent().removeClass('tipsWrap');//--
			$('#validLabel').html('');
			$('#submitFlag').attr('value','yes');
			$('#labelHidden').attr('value','true');
		}
	});*/
	
	
	
	$('#solution').blur(function(){
		var solution = $('#solution').val();
		if(solution==''){
			$('#validSolution').addClass('tips');
			$('#validSolution').parent().addClass('tipsWrap');
			$('#validSolution').html('分享不能为空');
			$('#solution').focus();
			$('#submitFlag').attr('value','');
		}else if(description.length>200){
			$('#validSolution').addClass('tips');
			$('#validSolution').parent().addClass('tipsWrap');
			$('#validSolution').html('请输入少于200字的解决方法');
			$('#solution').focus();
			$('#submitFlag').attr('value','');
		}else{
			$('#validSolution').removeClass('tips');
			$('#validSolution').parent().removeClass('tipsWrap');
			$('#validSolution').html('');
			$('#submitFlag').attr('value','yes');
			$('#solutionHidden').attr('value','true');
		}
	});
	
	
	
	

/*	$('#agreeNode').click(function(){
	if(getSelectCount("agreeNode")>0){
		$('#registeNode').removeAttr("disabled");
	}else{
		$('#registeNode').attr('disabled','true');
	}

	});*/
});		



	//test
	function test(){
		var test=document.getElementById("isShare").value;
		alert(test);
	}

		
/*	//登陆按钮
	function login(){
		location.href= $('#basePath').val()+'frontStage/front/index.jsp' ;
	}*/
	 
	//登记按钮
	function repsummary(){
//		var flag = $('#submitFlag').val();
		var machineHidden = $('#machineHidden').val();
		var descriptionHidden = $('#descriptionHidden').val();
		var labelHidden = $('#labelHidden').val();
		var solutionHidden = $('#solutionHidden').val();
		var submitFlag = $('#submitFlag').val();
		if(1==1/*machineHidden=='true'&&descriptionHidden=='true'&&
		labelHidden=='true'&&solutionHidden=='true'*/){  //&&phoneHidden=='true'
				
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
	