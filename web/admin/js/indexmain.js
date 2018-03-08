
/*跳转到bnnner图页面*/
function secondHandHouse(obj){
	$(obj).siblings().removeClass('active');
	$(obj).addClass('active');
	$("#rightcontent").html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='secondHandHouse.html' frameborder=0></iframe>");
}

function newHouse(){
	$("#rightcontent").html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='newHouse.html' frameborder=0></iframe>");
}
function guest(){
    $("#rightcontent").html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='guest.html' frameborder=0></iframe>");
}
function landlord(){
    $("#rightcontent").html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='landlord.html' frameborder=0></iframe>");
}


/*跳转二手房頁面*/
function secondHandHouse(obj){
	$(obj).siblings().removeClass('active');
	$(obj).addClass('active');
	$('#rightcontent').html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='secondHandHouse.html' frameborder=0></iframe>");
}
/*跳转到新房界面*/
function newHouse(obj){
	$(obj).siblings().removeClass('active');
	$(obj).addClass('active');
	$('#rightcontent').html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='newHouse.html' frameborder=0></iframe>");
}
/*跳转到客戶界面*/
function guest(obj){
    $(obj).siblings().removeClass('active');
    $(obj).addClass('active');
    $('#rightcontent').html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='guest.html' frameborder=0></iframe>");
}
function landlord(obj){
    $(obj).siblings().removeClass('active');
    $(obj).addClass('active');
    $("#rightcontent").html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='landlord.html' frameborder=0></iframe>");
}


/*用户信息退出跳转到登录界面*/
function quitid() {
    $.ajax({
        type: "post",
        url: "./../phm/GraduationProject/logout.do",
        success: function (data) {
            window.open('confirm.html', '_blank');
            window.close();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            window.location.href = "confirm.html";
        }

    });
}
/*修改密码*/
$("#xiugai").click(function(){
     $('#rightcontent').html("<iframe name='content_frame' marginwidth=0 marginheight=0 width=100% height=100% src='xiupassword.html' frameborder=0></iframe>");
    // window.location.href="xiupassword.html";
})




		
				

