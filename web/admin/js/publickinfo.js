
var context="";
$(function(){
	flowwaterajax(1);
	$('#byname').bind('input propertychange', function() {
		if($(this).val()!=context ){
			context=$(this).val();
			flowwaterajax(1);
		}
	}); 
	
})
function tiaozhaun(){
	flowwaterajax();
}
function flowwaterajax(obj){
	$("#insert").empty();
		var tr = "";
			$.ajax({
				type : "post",	
				data : {
					"contident" : context,
					"nowPage" : obj
				},
				url  : "./../xlcr/admin/get/allnotice.do",
				success : function(data) {
				for(var i=0; i<data.obj.length;i++){				   
			    tr  +=  "<tr>"+
							"<td>"+data.obj[i].title+"</td>"+
							"<td>"+data.obj[i].content+"</td>"+
							"<td>"+data.obj[i].webTile+"</td>"+
							"<td>"+data.obj[i].state+"</td>"+
							"<td>"+data.obj[i].httpUrl+"</td>"+
							"<td id = 'del'>"+
								"<button class = 'btn btn-danger btn-xs' style = 'margin-right:10px;'onclick = 'del(&quot;"+data.obj[i].id+"&quot;)'>删除</button>"+
									/*如果是this,可以直接写 如果是其它需要用到转义字符*/
								"<button class = 'btn btn-warning btn-xs' onclick = 'change(&quot;"+data.obj[i].id+"&quot;)'>修改</button>"+
							"</td>"+														
						"</tr>";				   
						}
					$('#insert').append(tr);						
					$("#pagination2").empty();
					/* 渲染分页 */
					if (data.totalpage <= 5) {
						for ( var i = 0; i < data.totalpage; i++) {
							if ((i + 1) == data.nowpage) {
								var li = "<li class='active'><a href='#' onclick='flowwaterajax("+(i+1)+")'>"
										+ (i + 1) + "</a></li>";
								$("#pagination2").append(li);
							} else {
								var li = "<li><a href='#' onclick='flowwaterajax("+(i+1)+")' >" + (i + 1)
										+ "</a></li>";
								$("#pagination2").append(li);
							}

						}
						}else{
							if(( data.nowpage-3)>0){
								var li1="<li><a href='#' aria-label='Previous'onclick='flowwaterajax(1)' ><span aria-hidden='true'>&laquo;</span></a></li>";
								$("#pagination2").append(li1);
							}
							
							if(( data.nowpage-2)>0){
							var li2=" <li><a href='#' onclick='flowwaterajax("+(data.nowpage-2)+")' >"+(data.nowpage-2)+"</a></li>";
							$("#pagination2").append(li2);
							}
							
							if(( data.nowpage-1)>0){
							var li3=" <li><a href='#' onclick='flowwaterajax("+(data.nowpage-1)+")' >"+(data.nowpage-1)+"</a></li>";
							$("#pagination2").append(li3);
							}
							
							var lime = "<li class='active'><a href='#'>"+ data.nowpage + "</a></li>";
							$("#pagination2").append(lime);
							
							if(( data.nowpage+1)<=data.totalpage){
							var li4=" <li><a href='#' onclick='flowwaterajax("+(data.nowpage+1)+")' >"+(data.nowpage+1)+"</a></li>";
							$("#pagination2").append(li4);
							}
							
							if(( data.nowpage+2)<=data.totalpage){
							var li5=" <li><a href='#' onclick='flowwaterajax("+(data.nowpage+2)+")' >"+(data.nowpage+2)+"</a></li>";
							$("#pagination2").append(li5);
							}
							
							if(( data.nowpage+3)<=data.totalpage){
							var li6=" <li><a href='#' aria-label='Next' onclick='flowwaterajax("+data.totalpage+")' > <span aria-hidden='true'>&raquo;</span></a></li>";
							$("#pagination2").append(li6);
							}
						}
					},
					   /*success结束位置*/
					 error: function(XMLHttpRequest, textStatus, errorThrown) {
						 window.open('login.html','_blank');
						 window.close(); 
		            }
				});
		   }
/*删除公告操作*/			
	function del(obj) {
		/*$('#myModal').modal('show');
		$('#title').html('系统提示');
		$('#content').html('确认删除么');*/
		$.ajax({
			type : "post",
			url : "./../xlcr/admin/delete/notice.do?id=" +obj,
			success : function(data) {
				
				$('#insert').empty();
				flowwaterajax();
			},
			   /*success结束位置*/
			 error: function(XMLHttpRequest, textStatus, errorThrown) {
				 window.open('login.html','_blank');
				 window.close(); 
           }
		})
	}
/*修改公告操作*/
	function change(obj){
		//alert(obj);
		window.location.href="publicchange.html?id=" + obj;
	}
	