			/*获取焦点触发事件*/
			$('.customerName').focus(function(){
				if($('.customerName').val() == ''){
					//alert(1);					
				}
			})
			 /*input失去焦点触发事件*/
				var $name = "";			
				$('.customerName').change(function(){
						if($('.customerName').val() != ''){ 
								
							$.ajax({
								type : "post",
								url : "./../xlcr/admin/get/allprovider.do?name=" + $('.customerName').val(),
								success : function(data) {
									//alert(data.msg)
									for(var i = 0; i < data.obj.length;i++){
										//alert(data.obj.length);
										$name += "<li class='list-group-item' id = '"+data.obj[i].id+"' onclick = 'userself(this)' style = 'height:35px;'>"+ data.obj[i].userName+"</li>";							   			
									  }										
									$('#ulid').append( $name );
									$('#ulid').css('display','block');																		
								},
								   /*success结束位置*/
								 error: function(XMLHttpRequest, textStatus, errorThrown) {
									 window.open('login.html','_blank');
										window.close(); 
					            }								
							}) /*ajax结束位置*/					 						 				 	
						}
				});	
				/*点击当前的Li列表进行如下操作，首先渲染到input内部，然后取出对应的id*/
				function userself(obj){
					var $nametwo = $(obj).html();
					var $nameid  = $(obj).attr('id');
					$('#providername').val( $nametwo );
					$('#nameid').val($nameid);
					$('#ulid').css('display','none');
					/*通过ajax把参数传给后台*/	
					//alert($nameid);
					}
				/*点击提交按钮验证*/
				$('#submitbtn').click(function(){
					$.ajax({
						type : "post",
						data:{
							"httpUrl":$("#httpimg").val(),    //启动链接地址
							"httpImg":$('#banneraddr').val(),  //banner图链接地址
							"startDate":$("#starttime").val(), //起始时间
							"endDate":$("#endtime").val(),    //结束时间
							"providerId":$('#nameid').val()  //提供商名称
						},
						url  : "./../xlcr/admin/add/banner.do"  ,
						success : function(data) {
							//alert(1)							
								if(data.error == 200){
									$('#submitbtn').addClass('disabled');			
									$('#myModal').modal('show');
									$('#myModalLabel').html('系统提示');
									$('#textcontent').html('添加成功');
								}
							},
							   /*success结束位置*/
							 error: function(XMLHttpRequest, textStatus, errorThrown) {
								 window.open('login.html','_blank');
									window.close(); 
				            }
						});
					})
								
				
		