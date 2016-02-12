/*페이지 오픈과 동시에 가게의 전체 이용내역을 불러옴*/
$(document).ready(usage_show());
function usage_show(){
    var obj={
        "reqData":{
            "store_number":"10011"
        },

        "reqCode": "HS0004"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: 'http://54.250.205.0:8080/springboot2/History/GetList/Store',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){  
            var string="";
            string+='<thead>'
            string+='<tr>'
            string+='<th data-sortable="true">날짜</th>'
            string+='<th data-sortable="true">시간</th>'
            string+='<th data-sortable="true">담당자</th>'
            string+='<th data-sortable="true">고객이름</th>'
            string+='<th data-sortable="true">이용내용</th>'
            string+='</tr>'
            string+='</thead>'
            string+='<tbody>'
            for(var i=0;i<data.resData.length;i++)
            {
                string+="<tr>"

                string+="<td>";
                string+=data.resData[i].reservation_date;
                string+="</td>";

                string+="<td>";
                string+=data.resData[i].reservation_time;
                string+="</td>";

                string+="<td>";
                string+=data.resData[i].server.server_name;
                string+="</td>";

                string+="<td>";
                string+=data.resData[i].user.user_name;
                string+="</td>";

                string+="<td>";
                string+=data.resData[i].reservation_etc;
                string+="</td>";

                string+="</tr>"
            }
            string+='</tbody>'
            $("#historyList").html(string);
        }
    });
}
