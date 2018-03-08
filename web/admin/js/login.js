/*当光标移出验证input后判断验证码位数*/
$('#testcode').blur(function(){	
	if($('#testcode').val().length < 5 ){		
		$('#infoone').html('系统提示');
		$('#infotwo').html('验证码不得小于5位');
		/*$('#myModal').show(); jquery用来显示内容 模态框自己的api*/
		$('#myModal').modal();
	}
});
/*点击登录进行判断*/
$('#loginbtn').click(function(){
	if($('#username').val().length < 2){
		$('#infoone').html('系统提示');
		$('#infotwo').html('用户名不得小于2位');
		$('#myModal').modal();
		return false;
	}	
	if($('#userpassword').val().length < 2){
		$('#infoone').html('系统提示');
		$('#infotwo').html('密码不得小于2位');
		$('#myModal').modal();
		return false;
	}
	loginajax();
});

function loginajax() {
	$.ajax({
		type : "POST",
		url : "./../xlcr/admin/userlogin.do?username="+ $("#username").val() + "&userpwd=" + $("#userpassword").val() + "&vcode=" + $("#testcode").val(),
		success : function(data) {
			if (data.error != 200) {
				//alert("error")
				$('#myModal').modal('show');
				$("#myModalLabel").html("系统提示");
				$("#showtxt").html(data.msg);
			} else {
				//跳转首页
				window.location.href = "indexmain.html";
			}
		}
	});
}
