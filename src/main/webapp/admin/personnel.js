$(document).ready(server_show());
function server_show(){
    var obj={
        "reqData":{
            "store_number":"10011"
        },

        "reqCode": "SR0003"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: baseURL+'/Server/GetList',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){
            var string="";
            string+='<thead>'
            string+='<tr>'
            string+='<th data-sortable="true">직원코드</th>'
            string+='<th data-sortable="true">이름</th>'
            string+='<th data-sortable="true">나이</th>'
            string+='<th data-sortable="true">핸드폰번호</th>'
            string+='<th data-sortable="true">특이사항</th>'
            string+='</tr>'
            string+='</thead>'
            string+='<tbody>'
            for(var i=0;i<data.resData.length;i++)
            {
                string+="<tr>"
                
                string+="<td>";
                string+='<a href="#" number='+data.resData[i].server_number
                string+=' class="selected">'
                string+=data.resData[i].server_number;
                string+='</a>'
                string+="</td>";

                string+="<td>";
                string+=data.resData[i].server_name;
                string+="</td>";

                string+="<td>";
                string+=data.resData[i].server_age;
                string+="</td>";

                string+="<td>";
                string+=data.resData[i].server_phone;
                string+="</td>";

                string+="<td>";
                string+=data.resData[i].server_etc;
                string+="</td>";

                string+="</tr>"
            }
            string+='</tbody>'
            $("#serverList").html(string);       

        }
    });
}




function server_select(number){
    var obj={
        "reqData":{
            "server_number":number.toString()
        },

        "reqCode": "SR0004"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: baseURL+'/Server/GetInfo',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){
            var string1="<b>이름</b>  "

            string1+=data.resData[0].server_name
            string1+='<br>'
            string1+='<b>나이  </b>'
            string1+=data.resData[0].server_age
            string1+='<br>'
            string1+='<b>P.H  </b>'
            string1+=data.resData[0].server_phone
            string1+='<br>'
            string1+='<b>설명 / 특이사항  </b><br>'
            string1+=data.resData[0].server_etc
            string1+='<br>'

            var string2='';
            string2+='<thead>'
            string2+='<tr>'
            string2+='<th data-field="date" data-align="center">날짜</th>'
            string2+='<th data-field="name" data-align="center" >이름</th>'
            string2+='<th data-field="gender" data-align="center" >성별</th>'
            string2+='<th data-field="contents" >서비스내용</th>'
            string2+='</tr>'
            string2+='</thead><tbody>'

            for(var i=1;i<data.resData.length;i++)
            {
                string2+="<tr>";

                string2+="<td>";
                string2+=data.resData[i].reservation_date;
                string2+="</td>";

                string2+="<td>";
                string2+=data.resData[i].user.user_name;
                string2+="</td>";

                string2+="<td>";
                string2+=data.resData[i].user.gender;
                string2+="</td>";

                string2+="<td>";
                string2+=data.resData[i].reservation_etc;
                string2+="</td>";

                string2+="</tr>";
            }
            string2+='</tbody>';
            $("#server_name").html(data.resData[0].server_name+" / 상세정보");
            $("#server_name2").html(data.resData[0].server_name+" / 서비스 내역");
            $("#server_info").html(string1);
            $("#server_history").html(string2);

        }
    });
}

/*직원삭제 서비스*/
$('#server_delete').click(function(){


    var server_number=$("#server_number").val();
    var server_number_string=server_number.toString();
    alert(server_number_string);
	var obj={
        "reqData":{
            "server_number":server_number_string
        },

        "reqCode": "SR0001"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
    	url: baseURL+'/Server/Delete',	
        dataType: "json",
        type: "post",
      	contentType: "application/json",
        data: json_data,

    	success : function(data){
        	console.log(data);
        	alert("삭제되었습니다.");
      }

    });
});