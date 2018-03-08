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
        url : "./../phm/get/allkehuinfo.do",
        data : {
            "contident" : context,
            "nowPage" : obj
        },
        success : function(data){
            for(var i =0; i < data.obj.length; i++){

                trid += "<tr>"+
                    "<td>"+ data.obj[i].name +"</td>"+
                    "<td>"+ data.obj[i].sex +"</td>"+
                    "<td>"+ data.obj[i].age+"</td>"+
                    "<td>"+ data.obj[i].phone+"</td>"+
                    "<td>"+ data.obj[i].hobby+"</td>"+
                    "<td>"+ data.obj[i].gmoney+"</td>"+
                    "<td>"+ data.obj[i].dmoney+"</td>"+
                    "<td>"+ data.obj[i].registeredDate+"</td>"+

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