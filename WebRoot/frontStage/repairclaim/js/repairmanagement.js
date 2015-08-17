//dispatch按钮
function dispatch(id,name){
	
	document.getElementById("id").value=id;
	
	var str0 = document.getElementById("base")
	  .getElementsByTagName("tr")[2*name+2]
	  .getElementsByTagName("td")[0].innerHTML;	
	
	var str1 = document.getElementById("base")
	  .getElementsByTagName("tr")[2*name+2]
	  .getElementsByTagName("td")[1].innerHTML;	
	
	var str2 = document.getElementById("base")
	  .getElementsByTagName("tr")[2*name+2]
	  .getElementsByTagName("td")[2].innerHTML;	
	
	var str3 = document.getElementById("base")
	  .getElementsByTagName("tr")[2*name+2]
	  .getElementsByTagName("td")[3].innerHTML;	
	
	var str4 = document.getElementById("base")
	  .getElementsByTagName("tr")[2*name+2]
	  .getElementsByTagName("td")[4].innerHTML;	
	
	var str5 = document.getElementById("base")
	  .getElementsByTagName("tr")[2*name+2]
	  .getElementsByTagName("td")[5].innerHTML;	
	
	//description
	var str6 = document.getElementById("base")
	  .getElementsByTagName("tr")[2*name+2]
	  .getElementsByTagName("td")[6].innerHTML;	
	
	var str7 = document.getElementById("base")
	  .getElementsByTagName("tr")[2*name+2]
	  .getElementsByTagName("td")[7].innerHTML;	
	
	
	document.getElementById("more")
	  .getElementsByTagName("tr")[1]
	  .getElementsByTagName("td")[0]
	  .innerHTML = str0;
	
	document.getElementById("more")
	  .getElementsByTagName("tr")[1]
	  .getElementsByTagName("td")[1]
	  .innerHTML = str1;
	
	document.getElementById("more")
	  .getElementsByTagName("tr")[1]
	  .getElementsByTagName("td")[2]
	  .innerHTML = str2;
	
	document.getElementById("more")
	  .getElementsByTagName("tr")[1]
	  .getElementsByTagName("td")[3]
	  .innerHTML = str3;
	
	document.getElementById("more")
	  .getElementsByTagName("tr")[1]
	  .getElementsByTagName("td")[4]
	  .innerHTML = str4;
	
	document.getElementById("more")
	  .getElementsByTagName("tr")[1]
	  .getElementsByTagName("td")[5]
	  .innerHTML = str5;
	
	//description是str6
	document.getElementById("more")
	  .getElementsByTagName("tr")[1]
	  .getElementsByTagName("td")[6]
	  .innerHTML = str7;
	
	document.getElementsByTagName("textarea")[0]
	  .innerHTML = str6;
}

$(function(){
	 $(".level1 > a").click(function(){
	     $(this).addClass("current")
		 .next().show()
		 .parent().siblings().children("a").removeClass("current")
		 .next().hide();
		 return false;
		 
     });
								 
	});
