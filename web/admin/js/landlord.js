var context="";

$(function(){
    flowwaterajax();
    $('#qpp').bind('input propertychange', function() {
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
        url : "./../phm/get/allLandlord.do",
        data : {
            "contident" : context,
            "nowPage" : obj
        },
        success : function(data){
            for(var i =0; i < data.obj.length; i++){
                var sex =data.obj[i].sex;
                if(sex ==1){
                    sex="<span style='color:#006030;'><strong>男</strong></span>"
                }else{
                    sex="<span style='color:#EA0000;'><strong>女</strong></span>"
                }
                trid += "<tr>"+
                    "<td><span style='color:#613030;' ><strong>"+ data.obj[i].name +"</strong></span></td>"+
                    "<td>"+ sex+"</td>"+
                    "<td>"+ data.obj[i].age+"</td>"+
                    "<td>"+ data.obj[i].idCard+"</td>"+
                    "<td>"+ data.obj[i].phone+"</td>"+
                    "<td>"+ data.obj[i].context+"</td>"+
                    "<td id = 'del'>"+
                    "<button class = 'btn btn-danger btn-xs' style = 'margin-right:10px;'onclick = 'del(&quot;"+data.obj[i].id+"&quot;)'>删除</button>"+
                    /*如果是this,可以直接写 如果是其它需要用到转义字符*/
                    "<button class = 'btn btn-warning btn-xs' onclick = 'change(&quot;"+data.obj[i].id+"&quot;)'>修改</button>"+
                    "</td>"+
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
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            window.location.href = "confirm.html";
        }

    })
}
/*删除*/
function del(obj) {
    /*$('#myModal').modal('show');
    $('#title').html('系统提示');
    $('#content').html('确认删除么');*/
    $.ajax({
        type : "post",
        data : {
            id:obj
        },
        url : "./../phm/delete/Landlord.do",
        success : function(data) {

            $('#tbodyone').empty();
            flowwaterajax();
        },
        /*success结束位置*/
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            window.open('confirm.html','_blank');
            window.close();
        }
    })
}
/*修改操作*/
function change(obj){
    //alert(obj);
    window.location.href="landlordChange.html?id=" + obj;
}
/*修改热度*/
function changehot(id,hot){
    var realhot;
    if(hot == 1){
        realhot = 0
    }else{
        realhot = 1
    }
    $.ajax({
        type : "post",
        data : {
            "hot" : realhot,
            "id" : id,
        },
        url : "./../phm/update/NewHouseInfo.do",
        success : function(data){
            if(data.error == 200){
                $('#myModal').modal('show');
                $('#title').html('系统提示');
                $('#content').html('修改成功');
                flowwaterajax();
            }
        }
    })
}
/*修改上架状态*/
function statefunction(id,state){
    var realstate;
    if(state == 1){
        realstate = 0
    }else{
        realstate = 1
    }
    $.ajax({
        type : "post",
        data : {
            "id" : id,
            "state" : realstate
        },
        url : "./../phm/update/NewHouseInfo.do",
        success : function(data){
            if(data.error == 200){
                $('#myModal').modal('show');
                $('#title').html('系统提示');
                $('#content').html('修改成功');
                flowwaterajax();
            }
        }
    })
}