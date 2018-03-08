var context="";
$(function(){
	bannerpic();	
	$('#byname').bind('input propertychange', function() {
		if($(this).val()!=context ){
			context=$(this).val();
			bannerpic();
		}
	});
})
function tiaozhuan(){
	bannerpic();
}
/*banner图数据获取*/
function bannerpic(){
			$.ajax({
				type : "post",
				url : "./../xlcr/admin/get/allbanner.do",
				data :{
					"contident" : context
				},
				success : function(data2) {
					/*每次点击后，ajax会重新刷新，此时，通过把之前的数据全部清掉，包括要删除的，删除后，再重新渲染新的数据*/
					$("#tbodyone").empty();
					if(data2.error == 200){
						for( var i = 0; i <data2.obj.length;i++){
							
							
				var tr = "<tr id ='trid' >" +
						"<td id = 'provideruser'>" + data2.obj[i].provider.companyName + "</td>" + 							
							"<td id = 'userimg'>" +
								/*"<img src ='"+data.obj[i].banner.httpImg+"'  style = 'width:30px;height:30px;cursor:pointer;'>"+*/
							 	   "<a href = '"+ data2.obj[i].banner.httpImg +"'>外链banner地址</a>"+
							"</td>"+
							"<td id = 'starturl'>"+
								"<a href = '"+data2.obj[i].banner.httpUrl+"'>图片外连</a>"+
							"</td>"+
							"<td id = 'strartDate'>" + data2.obj[i].banner.providerId +"</td>"+							
							"<td id = 'endDate'>" + data2.obj[i].banner.title +"</td>	"+
							/*"<td id = 'implDate'>" + data.obj[i].banner.implDate + "</td>"+*/
							"<td id = 'del'>"+
								"<button class = 'btn btn-danger btn-xs' style = 'margin-right:10px;' onclick = 'dele(&quot;"+data2.obj[i].banner.id+"&quot;)'>删除</button>"+
									/*如果是this,可以直接写 如果是其它需要用到转义字符*/
								"<button class = 'btn btn-warning btn-xs' onclick = 'change(&quot;"+data2.obj[i].banner.id+"&quot;)'>修改</button>"+
							"</td>"+
						"</tr>";						
						$('#tbodyone').append(tr);																					
						}
						
					}									
				},  /*success结束位置*/
				 error: function(XMLHttpRequest, textStatus, errorThrown) {
					 window.open('login.html','_blank');
					window.close(); 
                }
			});
		} /*获取banner图结束位置*/

		/*删除操作*/
		 function dele(obj){
			 /*弹出对应的ID*/
			//alert('&quot;"+data.obj[i].banner.id+"&quot;');
			 $(this).parent('#trid').remove();
			 /*这一步只是删除了当前的前端数据通过传递当前的ID找到删除bannner的地址，后台删除对应ID 的数据，下次再调用ajax已经没有数据了*/ 
			 //alert(1)
			 $.ajax({
					type : "post",
					url : "./../xlcr/admin/delete/banner.do?id="+obj,
					success : function(data) {
						bannerpic();
						},
			   /*success结束位置*/
			 error: function(XMLHttpRequest, textStatus, errorThrown) {
                window.location.href="login.html";
            }
					}); 	 
		 		}
		 
		 /*修改操作*/
		 function change(ob){
			 window.location.href="change.html?id=" + ob;			 
		 }

