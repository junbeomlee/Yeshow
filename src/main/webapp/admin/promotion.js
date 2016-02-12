/*페이지 오픈과 동시에 가게의 프로모션 내역을 불러옴*/
$(document).ready(promotionShow())

function promotionShow(){
    var login_info = JSON.parse(localStorage.getItem('login_info'));
    var obj={
        "reqData":{
            "store_number":login_info.store_number_login
        },

        "reqCode": "ST0003"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: 'http://54.250.205.0:8080/springboot2/Store/GetInfo',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){
            var string1="";
            var string2="";
            string1+="<p>";
            string1+="<b>상호명</b>  ";
            string1+=data.resData[0].store_name;
            string1+="</p>";
            string1+="<p>";
            string1+="<b>영업 시간</b>  ";
            string1+=data.resData[0].storeDetail.open_time;
            string1+="~";
            string1+=data.resData[0].storeDetail.close_time;
            string1+="</p>";
            string1+="<p>";
            string1+="<b>영업 정보</b>";
            string1+="</p>"
            string1+="<p>";
            string1+=data.resData[0].storeDetail.store_info;
            string1+="</p>";
            string2+="<h3>";
            string2+=data.resData[0].promotion.promotion_name;
            string2+="</h3>";
            string2+=data.resData[0].promotion.promotion_contents;
            $("#store_info").html(string1);
            $("#promotion").html(string2);
      }
    });
}

/*프로모션 등록버튼을 누르면 실행되는 등록 서비스*/
function promotionResister(){
    var editorText=CKEDITOR.instances.promotion_contents.getData();
    alert(editorText);
    var login_info = JSON.parse(localStorage.getItem('login_info'));
    var obj={
        "reqData":{
            "store_number":login_info.store_number_login,
            "promotion_name":$("#promotion_name").val(),
            "promotion_contents":editorText
        },
        "reqCode":"ST0004"
    }

    var json_data = JSON.stringify(obj);
    $.ajax({
        url: 'http://54.250.205.0:8080/springboot2/Store/PromotionAdd',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,

        success : function(data){
            alert("등록되었습니다.");
      }
    });
}
