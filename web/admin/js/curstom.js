var context="";

$(function(){
	flowwaterajax();	
	$('#byname').bind('input propertychange', function() {
		if($(this).val()!=context ){
			context=$(this).val();
			flowwaterajax();
		}
	});
	
})
function tiaozhaun(){
	flowwaterajax();
}
function flowwaterajax(obj){
	$("#tbodyone").empty();
	var trid = "";	
		$.ajax({
			type : "post",
			url : "./../xlcr/admin/get/allUserEntity.do",
			data : {
				"contident" : context,
				"nowPage" : obj
			},
			success : function(data){	
			for(var i =0; i < data.obj.length; i++){	
				var sex=data.obj[i].sex;
				if(sex=="1"){
					sex="男";
				}else if("2"){
					sex="女";
				}else{
					sex="未知"
				}
		       trid += "<tr>"+
		       			"<td><img class='showuserimg' src=' "+ data.obj[i].headimgurl  +"'></td>"+
		       			"<td>"+ data.obj[i].nickname  +"</td>"+
						"<td>"+ data.obj[i].country  +"</td>"+
						"<td>"+ data.obj[i].city +"</td>"+
						"<td>"+ data.obj[i].openid+"</td>"+
						"<td>"+ data.obj[i].phone+"</td>"+	
						"<td>"+ sex+"</td>"+
						"<td>"+ data.obj[i].context+"</td>"+
						"<td>"+ data.obj[i].integral+"</td>"+	
					  "</tr>";		
			}
			$('#tbodyone').append(trid);
			$("#pagination").empty();
			/* 渲染分页 */
			if (data.totalpage <= 5) {
				for ( var i = 0; i < data.totalpage; i++) {
					if ((i + 1) == data.nowpage) {
						var li = "<li class='active'><a href='#' onclick='flowwaterajax("+(i+1)+")'>"
								+ (i + 1) + "</a></li>";
						$("#pagination").append(li);
					} else {
						var li = "<li><a href='#' onclick='flowwaterajax("+(i+1)+")' >" + (i + 1)
								+ "</a></li>";
						$("#pagination").append(li);
					}

				}
			}else{
				if(( data.nowpage-3)>0){
					var li1="<li><a href='#' aria-label='Previous'onclick='flowwaterajax(1)' ><span aria-hidden='true'>&laquo;</span></a></li>";
					$("#pagination").append(li1);
				}
				
				if(( data.nowpage-2)>0){
				var li2=" <li><a href='#' onclick='flowwaterajax("+(data.nowpage-2)+")' >"+(data.nowpage-2)+"</a></li>";
				$("#pagination").append(li2);
				}
				
				if(( data.nowpage-1)>0){
				var li3=" <li><a href='#' onclick='flowwaterajax("+(data.nowpage-1)+")' >"+(data.nowpage-1)+"</a></li>";
				$("#pagination").append(li3);
				}
				
				var lime = "<li class='active'><a href='#'>"+ data.nowpage + "</a></li>";
				$("#pagination").append(lime);
				
				if(( data.nowpage+1)<=data.totalpage){
				var li4=" <li><a href='#' onclick='flowwaterajax("+(data.nowpage+1)+")' >"+(data.nowpage+1)+"</a></li>";
				$("#pagination").append(li4);
				}
				
				if(( data.nowpage+2)<=data.totalpage){
				var li5=" <li><a href='#' onclick='flowwaterajax("+(data.nowpage+2)+")' >"+(data.nowpage+2)+"</a></li>";
				$("#pagination").append(li5);
				}
				
				if(( data.nowpage+3)<=data.totalpage){
				var li6=" <li><a href='#' aria-label='Next' onclick='flowwaterajax("+data.totalpage+")' > <span aria-hidden='true'>&raquo;</span></a></li>";
				$("#pagination").append(li6);
				}
			}
		},
		   /*success结束位置*/
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
			 window.open('login.html','_blank');
				window.close(); 
       }				
	})
}