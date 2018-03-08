$(function(){
	loginajax();
})
 function loginajax(){
	var  trcontent = "";
	$.ajax({
		type : "post",
		url : "./../xlcr/admin/get/allauthentication.do",
		success : function(data) {
			//alert(1)
		for(var i=0;i < data.obj.length;i++){
trcontent += "<tr>"+
				"<td>"+data.obj[i].userName+"</td>"+
				"<td>"+data.obj[i].userCard+"</td>"+
				/*"<td id = "userimg">"+
					"<img src = "img/Koala.jpg" alt = "" style = "width:200px;height:50px;cursor:pointer;">"+
				"</td>"+
				"<td id = "userphone">"+
					"<img src = "img/Koala.jpg" alt = "" style = "width:200px;height:50px;cursor:pointer;">"+
				"</td>"+*/
				"<td>"+data.obj[i].userImg+"</td>"+
				"<td>"+data.obj[i].userBImg+"</td>"+
				"<td>"+data.obj[i].userState+"</td>"+
				"<td>"+data.obj[i].implDate+"</td>"+					
			 "</tr>"
								  
		} /*循环结束位置*/
		$('#insert').append(trcontent);
		},
		   /*success结束位置*/
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
			 window.open('login.html','_blank');
				window.close(); 
       }	
	})
  }	
