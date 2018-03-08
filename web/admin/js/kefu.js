

$(function(){
	loginajax();
})
    function loginajax(){
	
		$.ajax({
			type : "post",
			url : "./../xlcr/admin/get/kefu/get/allinfo.do",
			success : function(data) {
				
			var trinsert = "";	
				for(var i = 0; i <data.obj.length; i++){
					 
					
			trinsert += "<tr>"+
							"<td>"+ data.obj[i].name +"</td>"+
							"<td>"+ data.obj[i].phone +"</td>"+
							"<td>"+ data.obj[i].qqNumber+"</td>"+
							"<td>"+ data.obj[i].typeName+"</td>"+
						"</tr>"					
							
						} 
					  $('#tbodyone').append(trinsert);
					},
					   /*success结束位置*/
					 error: function(XMLHttpRequest, textStatus, errorThrown) {
						 window.open('login.html','_blank');
							window.close(); 
		            }
				});
				
			}

