$(function(){
	gifttypeajax();
	obtainidajax();
	//alert(GetQueryString("id"))
	$('#submitbtn').click(function(){
		submitajax();
		
		
	})
})
/*调用id对应的游戏接口默认显示并且禁用*/
function obtainidajax(){
	$.ajax({
		type : "post",			
		url  : "./../xlcr/admin/get/giftinfobyid.do?id=" + GetQueryString("id"),		
		success : function(data) {
		/*得到的data进行渲染*/	
		/*游戏名称且不能更改当前的游戏*/
		$('#gamename').val(data.obj[0].gameInfo.name);
		//$('#gamename').addClass('disabled');
		$('#gamename').attr('disabled','disabled');
		/*礼包类型*/	
		$('#id').val()
		/*礼包的标题*/
		$('#gifttitle').val(data.obj[0].giftInfos.giftTitle);
		/*礼包的描述*/
		$('#giftdiscrip').val(data.obj[0].giftInfos.giftDescribe);
		/*礼包提供商*/
		$('#giftsupp').val(data.obj[0].giftInfos.giftProvder);
		/*礼包内容*/
		$('#content').val(data.obj[0].giftInfos.giftContent);
		/*礼包金额*/
		$('#giftmoney').val(data.obj[0].giftInfos.giftMoney);
		/*礼包总数*/
		$('#giftnum').val(data.obj[0].giftInfos.giftNum);
		/*礼包已经领取的数量*/
		$('#giftlingqu').val(data.obj[0].giftInfos.giftReceive);
		/*礼包规则*/
		$('#giftrule').val(data.obj[0].giftInfos.giftRule);
		/*礼包起始时间*/
		$('#starttime').val(data.obj[0].giftInfos.gameId);
		/*礼包结束时间*/
		$('#endtime').val(data.obj[0].giftInfos.giftType);
		/*httpimg*/
		$('#httpimg').val(data.obj[0].giftInfos.httpimg);
		}
	})
}

/*正则获得url传递的参数值*/
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURI(r[2]);
    return null;
}

/*礼包类型获取接口*/
function gifttypeajax(){	
	$.ajax({
		type : "post",
		url  : "./../xlcr/admin/get/gifttypes.do",
		success : function(data) {
			//alert(1)
		var liinsert = "";
		for(var i = 0;i < data.obj.length;i++){
		liinsert +=  "<li onclick = 'choosegift(&quot;"+data.obj[i].name+"&quot;,&quot;"+data.obj[i].id+"&quot;)'><a>"+data.obj[i].name+"</a></li>"+
					 "<li role='separator' class='divider'></li>";
		}						
		$('#ulgift').append(liinsert);		
   }
 })
}
/*将当前的类型显示为点击后的内容并且把当前的类型对应的ID存起来*/
function choosegift(name,id){
	$('#btnid').val(name);
	$('#id').val(id);
}

/*提交修改*/
function submitajax(){
	//alert($('#endtime').val());
	$.ajax({
		
		type : "post",
		data:{
			"id"         :GetQueryString("id"),      //游戏礼包的整行ID不是游戏的ID
			"giftTitle"  :$('#gifttitle').val(),     //礼包的标题
			"giftType"   :$('#id').val(),            //礼包的类型
			"giftContent":$('#content').val(),       //礼包的内容
			"giftNum"    :$('#giftnum').val(),       //礼包总数
			"giftProvder":$('#giftsupp').val(),      //礼包提供商
			"giftRule"   :$('#giftrule').val(),      //礼包规则
			"giftMoney"  :$('#giftmoney').val(),     //礼包金额
		   "giftDescribe":$('#giftdiscrip').val(),   //礼包描述
		    "httpimg"    :$('#httpimg').val(),       //礼包图片网址
			"startDate"  :$('#starttime').val(),     //起始时间
			"endDate"    :$('#endtime').val()        //结束时间			
		 },
		url  : "./../xlcr/admin/update/giftinfo.do",
		success : function(data) {
			//alert(1)
			$('#submitbtn').addClass('disabled');
			
			$('#myModal').modal('show');
			$('#myModalLabel').html('系统提示');
			$('#textcontent').html('修改成功');
		}
	})
	
}
