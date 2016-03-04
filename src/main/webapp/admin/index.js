$(document).ready(getGoodNum(),getComment(),getThisMonthNum(),getReservation());
/*좋아요수 불러오는 함수*/
function getGoodNum() {
    var login_info = JSON.parse(localStorage.getItem('login_info'));
    var obj={
        "reqData":{
            "store_number":login_info.store_number_login
        },

        "reqCode": "GB0001"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: baseURL+'/GoodBad/GetGoodNum',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){
            $("#good_num").html(data.resData.length);
      }
    });
}


/*리뷰정보를 불러오는 함수*/

function getComment(){
    var login_info = JSON.parse(localStorage.getItem('login_info'));
    var obj={
        "reqData":{
            "store_number":login_info.store_number_login
        },

        "reqCode": "CM0001"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: baseURL+'/Comment/GetList/Store',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){
            var string="";
            for(var i=0;i<data.resData.length;i++)
            {
                string+="<li><div class='chat-body clearfix'>";
                string+='<div class="header"><string class="primary-font">';
                /*string+=data.resData[i].user_name;*/
                string+=data.resData[i].comment_number;
                string+='</strong>  ';
                string+=data.resData[i].user.user_name;
                string+='<small class="text-muted">';
                string+=data.resData[i].commentDate;
                string+='  ';
                string+="</small></div>";
                string+="<p>";
                string+=data.resData[i].contents;
                string+="</p>"
                string+="</div></li>"
            }
            $("#comment").html(string);
            $("#commentNum").html(data.resData.length);

      }
    });
}
/*이번달 이용횟수 불러오는 함수*/
function getThisMonthNum(){
    var login_info = JSON.parse(localStorage.getItem('login_info'));
    var obj={
        "reqData":{
            "store_number":login_info.store_number_login
        },

        "reqCode": "HS0002"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: baseURL+'/History/GetListByThisMonth',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){
            $("#thisMonthNum").html(data.resData.length);

      }
    });
}

/*오늘 예약 불러오는 함수*/
function getReservation(){
    var currentDate=new Date();
    var year=currentDate.getFullYear();
    var month=currentDate.getMonth();
    var day=currentDate.getDate();
    var login_info = JSON.parse(localStorage.getItem('login_info'));
    var obj={
        "reqData":{
            "store_number":login_info.store_number_login,
            "year":year.toString(),
            "month":month.toString(),
            "day":day.toString()
        },

        "reqCode": "RV0002"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: baseURL+'/Reservation/GetList/Store',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){
            $("#reservation_num").html(data.resData.length);

      }
    });
}