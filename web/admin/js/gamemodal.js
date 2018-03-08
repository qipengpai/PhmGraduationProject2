
var context="";
$(function(){
	loginajax(1);
	
	$('#search').bind('input propertychange', function() {
		if($(this).val()!=context ){
			context=$(this).val();
			loginajax(1);
		}
	}); 
	
})
function loginajax(obj){
	/*获取加载数据*/
	var trinsert = "";
	$.ajax({
		type : "post",
		url : "./../xlcr/admin/get/allgameinfo.do?nowPage="+obj+"&condition="+context,			
		success : function(data){	
			//清空上一次数据
			$("#insertout").empty();
			//alert(1)
		/*for循环开始*/
			for(var i = 0;i < data.obj.length;i++){
				
				var state=data.obj[i].gameInfos.state;
				if(state==1){
					state="<span style='color:#949494;' onclick = 'statefunction(&quot;"+data.obj[i].gameInfos.id+"&quot; ,&quot;"+data.obj[i].gameInfos.state+"&quot;)' class='glyphicon glyphicon-ok'></span>";
				
				}else{
					state="<span style='color:#3F9F00;' onclick = 'statefunction(&quot;"+data.obj[i].gameInfos.id+"&quot; ,&quot;"+data.obj[i].gameInfos.state+"&quot;)' class='glyphicon glyphicon-ok'></span>";
				}
				
				
				
				var hot=data.obj[i].gameInfos.hot;
				if(hot==1){
					hot="<i class='glyphicon glyphicon-fire' onclick = 'changehot(&quot;"+data.obj[i].gameInfos.id+"&quot; ,&quot;"+data.obj[i].gameInfos.hot+"&quot;)' style='color:red;cursor: pointer;'></i>";
				}else{
					hot="<i class='glyphicon glyphicon-fire' onclick = 'changehot(&quot;"+data.obj[i].gameInfos.id+"&quot; ,&quot;"+data.obj[i].gameInfos.hot+"&quot;)' style='cursor: pointer;' ></i>";
				}
				
				/*计算描述长度*/
				var bigintroduce=data.obj[i].gameInfos.bigintroduce;
				if(bigintroduce.length>15){
					bigintroduce="<span class = 'spanclass'>"+bigintroduce.substring(0,14)+"</span>...";
				}else{
					bigintroduce="<span class = 'spanclass'>"+bigintroduce+"</span>";
				}
				
				/*短描述*/
				var smallintroduce=data.obj[i].gameInfos.smallintroduce;
				if(smallintroduce.length>15){
					smallintroduce=smallintroduce.substring(0,14);
				}
			  trinsert += "<tr>"+
							"<td>"+
								"<img src = '"+ data.obj[i].gameInfos.ico +"' style = 'width:30px;height:35px;cursor:pointer;'>"+
							"</td>"+
							"<td>"+data.obj[i].gameInfos.name+"</td>"+
							"<td>"+data.obj[i].click+"</td>"+
							"<td>"+data.obj[i].gameInfos.gift+"</td>"+
							"<td>" +
								"<p>"+
									"<span class = 'spantopclass'>"+smallintroduce+"</span>..."+
								"</p>"+
							"</td>"+
							"<td>"+
								"<p>"+bigintroduce+
								"</p>"+
							"</td>"+
							"<td>"+
								"<p>"+
									"<span class = 'spanbotclass'>"+data.obj[i].userName.userName+"</span></span>"+
									"</p>"+
							"</td>"+
							"<td>"+data.obj[i].money+"</td>"+
							"<td id = 'hot'>"+
							hot+
							"</td>"+
							/*排序*/
							"<td id = 'paixu'>"+
								"<button class = 'btn btn-danger btn-xs ' style = 'margin-right:10px;' onclick = 'upfunction(&quot;"+data.obj[i].gameInfos.id+"&quot;)'><span class='glyphicon glyphicon-arrow-up'></span></button>"+
								/*如果是this,可以直接写 如果是其它需要用到转义字符*/
								"<button class = 'btn btn-warning btn-xs ' onclick = 'downfunction(&quot;"+data.obj[i].gameInfos.id+"&quot;)'><span class='glyphicon glyphicon-arrow-down'></span></button>"+
							"</td>"+
							/*状态上线还是下线*/
							"<td id = 'paixu'>"+state+
							"</td>"+
						"</tr>";				
			}  /*for结束位置*/			
      		$('#insertout').append(trinsert);      		     		      		
      		
      		/*分页渲染*/
      		$("#pagination").empty();
     		
			/* 渲染分页 */
			if (data.totalpage <= 5) {
				for ( var i = 0; i < data.totalpage; i++) {
					if ((i + 1) == data.nowpage) {
						var li = "<li class='active'><a href='#' onclick='loginajax("+(i+1)+")'>"
								+ (i + 1) + "</a></li>";
						$("#pagination").append(li);
					} else {
						var li = "<li><a href='#' onclick='loginajax("+(i+1)+")' >" + (i + 1)
								+ "</a></li>";
						$("#pagination").append(li);
					}

				}
			}else{
			if(( data.nowpage-3)>0){
				var li1="<li><a href='#' aria-label='Previous'onclick='loginajax(1)' ><span aria-hidden='true'>&laquo;</span></a></li>";
				$("#pagination").append(li1);
			}
			
			if(( data.nowpage-2)>0){
			var li2=" <li><a href='#' onclick='loginajax("+(data.nowpage-2)+")' >"+(data.nowpage-2)+"</a></li>";
			$("#pagination").append(li2);
			}
			
			if(( data.nowpage-1)>0){
			var li3=" <li><a href='#' onclick='loginajax("+(data.nowpage-1)+")' >"+(data.nowpage-1)+"</a></li>";
			$("#pagination").append(li3);
			}
			
			var lime = "<li class='active'><a href='#'>"+ data.nowpage + "</a></li>";
			$("#pagination").append(lime);
			
			if(( data.nowpage+1)<=data.totalpage){
			var li4=" <li><a href='#' onclick='loginajax("+(data.nowpage+1)+")' >"+(data.nowpage+1)+"</a></li>";
			$("#pagination").append(li4);
			}
			
			if(( data.nowpage+2)<=data.totalpage){
			var li5=" <li><a href='#' onclick='loginajax("+(data.nowpage+2)+")' >"+(data.nowpage+2)+"</a></li>";
			$("#pagination").append(li5);
			}
			
			if(( data.nowpage+3)<=data.totalpage){
			var li6=" <li><a href='#' aria-label='Next' onclick='loginajax("+data.totalpage+")' > <span aria-hidden='true'>&raquo;</span></a></li>";
			$("#pagination").append(li6);
			}
      		
			}
 
      		
		},
		   /*success结束位置*/
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
           window.location.href="login.html";
       }
    })    
}


/*修改热度*/
function changehot(obj,hot){
	if(hot == 1){
		hot = 0;
	}
	else{
		hot = 1;
	}
	$.ajax({
		type : "post",
		url : "./../xlcr/admin/get/updateHot.do",
		data:{
			"id" :obj,    
			"hot":hot,  
		 },
		success : function(data){
			if(data.error == 200){
				$('#myModal').modal('show');
				$('#title').html('系统提示');
				$('#content').html('修改成功');
				
				/*重新加载页面*/
				$('#insertout').empty();
				loginajax(1);
				
			}
			
			}	
		})
}

/*点击向上排序按钮向上提高一位*/
	function upfunction(obj){
		$.ajax({
			type : "post",
			url : "./../xlcr/admin/update/gameinfo/sort.do?id="+obj+"&contident=1",			
			success : function(data){	
				if(data.error == 200){
					/*重新加载页面*/
					$('#insertout').empty();
					loginajax(1);
					
				}
			}
		})      					
	}
/*点击向下排序按钮向下降低一位*/	
	function downfunction(obj){
		$.ajax({
			type : "post",
			url : "./../xlcr/admin/update/gameinfo/sort.do?id="+obj+"&contident=0",			
			success : function(data){	
				if(data.error == 200){
					/*重新加载页面*/
					$('#insertout').empty();
					loginajax(1);
					
				}
			}
		})     					
	}
/*点击切换上线或者下线状态*/
	function statefunction(id,state){
		$.ajax({
			type : "post",
			url : "./../xlcr/admin/update/gameinfo/state.do?id=" + id + "&state=" + state,			
			success : function(data){
				$('#myModal').modal('show');
				$('#title').html('系统提示');
				$('#content').html("修改成功");
				loginajax(1);
			}
		})      					
	}