var context = "";

$(function() {
	giftajax();

	$('#byname').bind('input propertychange', function() {
		if ($(this).val() != context) {
			context = $(this).val();
			giftajax();
		}
	});

})
function tiaozhaun() {
	giftajax();
}
function giftajax(obj) {
	$("#tbodyid").empty();
	$
			.ajax({
				type : "post",
				url : "./../xlcr/admin/get/giftinfos.do",
				data : {
					"contident" : context,
					"nowPage" : obj
				},
				success : function(data) {
					var tr = "";
					for ( var j = 0; j < data.obj.length; j++) {
						// alert(data.obj.length)
						tr += "<tr id = 'trid'>" + "<td>"
								+ data.obj[j].giftType.name
								+ "</td>"
								+ "<td>"
								+ data.obj[j].gameInfo.name
								+ "</td>"
								+ "<td>"
								+ data.obj[j].giftInfos.giftTitle
								+ "</td>"
								+ "<td>"
								+ data.obj[j].giftInfos.giftDescribe
								+ "</td>"
								+ "<td>"
								+ data.obj[j].giftInfos.giftMoney
								+ "</td>"
								+ "<td>"
								+ data.obj[j].giftInfos.giftNum
								+ "</td>"
								+ "<td>"
								+ data.obj[j].giftInfos.giftReceive
								+ "</td>"
								+ "<td>"
								+ data.obj[j].giftInfos.giftRule
								+ "</td>"
								+ "<td>"
								+ data.obj[j].giftInfos.gameId
								+ "</td>"
								+ "<td>"
								+ data.obj[j].giftInfos.giftType
								+ "</td>"
								+ "<td><a href = '"
								+ data.obj[j].giftInfos.httpimg
								+ "'><img src = '"
								+ data.obj[j].gameInfo.ico
								+ "' style = 'width:50px;height:50px;'></a></td>"
								+ "<td id = 'del'>"
								+ "<button class = 'btn btn-danger btn-xs' style = 'margin-right:10px;' onclick = 'dele(&quot;"
								+ data.obj[j].giftInfos.id
								+ "&quot;)'>删除</button>" +
								/* 如果是this,可以直接写 如果是其它需要用到转义字符 */
								"<button class = 'btn btn-warning btn-xs' onclick = 'change(&quot;"
								+ data.obj[j].giftInfos.id
								+ "&quot;)'>修改</button>" + "</td>" + "</tr>";
					}
					// console.log(tr);
					$('#tbodyid').append(tr);
					$("#pagination").empty();
					/* 渲染分页 */
					if (data.totalpage <= 5) {
						for ( var i = 0; i < data.totalpage; i++) {
							if ((i + 1) == data.nowpage) {
								var li = "<li class='active'><a href='#' onclick='giftajax("
										+ (i + 1)
										+ ")'>"
										+ (i + 1)
										+ "</a></li>";
								$("#pagination").append(li);
							} else {
								var li = "<li><a href='#' onclick='giftajax("
										+ (i + 1)
										+ ")' >"
										+ (i + 1)
										+ "</a></li>";
								$("#pagination").append(li);
							}

						}
					} else {
						if ((data.nowpage - 3) > 0) {
							var li1 = "<li><a href='#' aria-label='Previous'onclick='giftajax(1)' ><span aria-hidden='true'>&laquo;</span></a></li>";
							$("#pagination").append(li1);
						}

						if ((data.nowpage - 2) > 0) {
							var li2 = " <li><a href='#' onclick='giftajax("
									+ (data.nowpage - 2)
									+ ")' >"
									+ (data.nowpage - 2) + "</a></li>";
							$("#pagination").append(li2);
						}

						if ((data.nowpage - 1) > 0) {
							var li3 = " <li><a href='#' onclick='giftajax("
									+ (data.nowpage - 1)
									+ ")' >"
									+ (data.nowpage - 1) + "</a></li>";
							$("#pagination").append(li3);
						}

						var lime = "<li class='active'><a href='#'>"
								+ data.nowpage + "</a></li>";
						$("#pagination").append(lime);

						if ((data.nowpage + 1) <= data.totalpage) {
							var li4 = " <li><a href='#' onclick='giftajax("
									+ (data.nowpage + 1)
									+ ")' >"
									+ (data.nowpage + 1) + "</a></li>";
							$("#pagination").append(li4);
						}

						if ((data.nowpage + 2) <= data.totalpage) {
							var li5 = " <li><a href='#' onclick='giftajax("
									+ (data.nowpage + 2)
									+ ")' >"
									+ (data.nowpage + 2) + "</a></li>";
							$("#pagination").append(li5);
						}

						if ((data.nowpage + 3) <= data.totalpage) {
							var li6 = " <li><a href='#' aria-label='Next' onclick='giftajax("
									+ data.totalpage
									+ ")' > <span aria-hidden='true'>&raquo;</span></a></li>";
							$("#pagination").append(li6);
						}
					}
				},
				/* success结束位置 */
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					window.open('login.html', '_blank');
					window.close();
				}

			})
}

/* 点击修改跳转到修改界面 */
function change(id) {
	window.location.href = "changegiftmodal.html?id=" + id;
}
/* 删除当前礼包的内容，两部：1：得到当前礼包信息的id，ajax修改数据库 */
function dele(id) {
	/* 把所有的内容全部清空 */
	$(this).parent('#trid').remove();
	/* 把这个id传给后台 */
	$.ajax({
		type : "post",
		url : "./../xlcr/admin/delete/giftinfo.do?id=" + id,
		success : function(data) {
			// alert(1)
			giftajax();
		}
	})
}
