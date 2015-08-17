function repairdo(){
	//var id =document.getElementById("repairid").value;	
	var calimId = document.getElementById("id").value;

	$.ajax({
		url:'repairmanagement_repairdo.action',
		type:'post',
		data:{"calimId":calimId},
		cache:false,
		success:function(data){
			window.location.href='repairmanagement_getmemtable.action';
		}
	});	
}

function repairnotdo(){
	//var id =document.getElementById("repairid").value;	
	var calimId = document.getElementById("id").value;

	$.ajax({
		url:'repairmanagement_repairnotdo.action',
		type:'post',
		data:{"calimId":calimId},
		cache:false,
		success:function(data){
			window.location.href='repairmanagement_getmemtable.action';
		}
	});	
}