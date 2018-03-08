$(function(){
	
	/*跳转到新增界面后，需要调游戏类型接口*/
	gametypeajax();
		
	/*当input发生改变时查询有无游戏名称*/
		var $name = "";			
			$('#gamename').change(function(){
					if($('#gamename').val() != ''){ 
							
						$.ajax({
							type : "post",
							url : "./../xlcr/admin/get/allgameinfo/byname.do?condition=" + $('#gamename').val(),
							success : function(data) {
								
								//alert(data.msg)
								for(var i = 0; i < data.obj.length;i++){
									//alert(data.obj.length);
									$name += "<li class='list-group-item' id = '"+data.obj[i].id+"' onclick = 'gamename(this)' style = 'height:35px;'>"+ data.obj[i].name+"</li>";							   			
								  }										
								$('#ulid').append( $name );
								$('#ulid').css('display','block');																		
							}								
						}) /*ajax结束位置*/					 						 				 	
					}
			});	
	
	$('#submitbtn').click(function(){
		loginajax();
	})
})



/*礼包类型接口*/
function gametypeajax(){	
	$.ajax({
		type : "post",
		url  : "./../xlcr/admin/get/gifttypes.do",
		success : function(data) {
			//alert(1)
		var liinsert = "";
		for(var i = 0;i < data.obj.length;i++){
		liinsert +=  "<li onclick = 'choosegift(&quot;"+data.obj[i].name+"&quot;,&quot;"+data.obj[i].id+"&quot; )'><a>"+data.obj[i].name+"</a></li>"+
					 "<li role='separator' class='divider'></li>";
		}						
		$('#ulgift').append(liinsert);		
   }
 })
}
/*点击赋值操作并且获取礼包类型ID*/
function choosegift(name,id){
	$('#btnid').html(name);
	$('#gifttypeid').val(id);	
}
/*点击当前的游戏帅选操作*/
function gamename(obj){
	var $gamename = $(obj).html();
	var $gameid  = $(obj).attr('id');
	$('#gamename').val( $gamename );
	$('#gameid').val($gameid);
	$('#ulid').css('display','none');
}
/*新增礼包信息*/
function loginajax(){
//	alert($('#endtime').val())
	$.ajax({
		type : "post",
		data:{
			"gameId"      :$('#gameid').val(),
			"giftType"    :$('#gifttypeid').val(),
			"giftTitle"   :$('#gifttitle').val(),
			"giftDescribe":$('#giftdiscrip').val(),
			"giftContent" :$('#content').val(),
			"giftMoney"   :$('#giftmoney').val(),
			"giftNum"     :$('#giftnum').val(),
			"giftRule"    :$('#giftrule').val(),
			"startDate"   :$('#starttime').val(),
			"endDate"     :$('#endtime').val(),
			"giftProvder" :$('#giftsupp').val(),
			"httpimg"     :$('#httpimg').val()
		 },
		url  : "./../xlcr/admin/add/giftinfo.do",
		success : function(data) {
			//alert(1)
			if(data.error == 200){
				$('#submitbtn').addClass('disabled');			
				$('#myModal').modal('show');
				$('#myModalLabel').html('系统提示');
				$('#textcontent').html('添加成功');
			}
			
		}
	})
}