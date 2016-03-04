$(document).ready(datepic())

/*날짜선택시 불러오는 함수*/
function datepic(){
	$("#calendar").click(function(){
		var dateObject=$("#calendar").datepicker('getDate');
		var year = dateObject.getFullYear();
		var month = dateObject.getMonth();
		var day = dateObject.getDate();
		var string=year+"년  "+(month+1)+"월  "+day+"일 의 타임테이블"
		$("#reservationByDay").html(string);
		var login_info = JSON.parse(localStorage.getItem('login_info'));
		var obj={
			"reqData":{
				"store_number":login_info.store_number_login,
				"year":year.toString(),
				"month":month.toString(),
				"day":day.toString()
			},
			"reqCode":"RV0002"
		}
		var json_data=JSON.stringify(obj);
		$.ajax({
	        url: baseURL+'/Reservation/GetList/Store',  
	        dataType: "json",
	        type: "post",
	        contentType: "application/json",
	        data: json_data,

	        success : function(data){
	            var string="";
	            for(var i=0;i<data.resData.length;i++)
	            {
	                string+="<tr>"
	                
	                string+="<td ";

	                string+=">";
	                string+=data.resData[i].reservation_number;                
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

	                string+="<td>";
	                string+="<button ";
	                string+="number=";
	                string+=data.resData[i].reservation_number;
	                string+=" class='reservation_complete' onclick='reservation_complete(this)'";
	                string+=">";
	                string+="완료";
	                string+="</button>";
	                string+="   ";
	                string+="<button ";
	                string+="number='";
	                string+=data.resData[i].reservation_number;
	                string+="' class='reservation_delete' onclick='reservation_delete(this)'";
	                string+=">";
	                string+="취소";
	                string+="</button>"
	                string+="</td>";

	                string+="</tr>"
	            }
	            $("#reservationList").html(string);       

	        }
    	});
	})
}
/*예약내역을 불러오는 함수*/


/*예약을 접수하는 함수*/
/*
function reservationRegister(){
	alert("ASDF");
	var login_info = JSON.parse(localStorage.getItem('login_info'));
	var obj={
		"reqData":{
			"store_number":login_info.store_number_login,
			"user_name":$("#user_name").val(),
			"user_phone":$("#user_phone").val(),
			"server_number":$("server_number").val(),
			"date":{
				"year":"@",
				"month":"@",
				"day":"@"
			},
			"time":{
				"hour":,
				"min":,

			},
			"reservation_etc":$("reservation_etc").val()
		},
		"reqCode":"RV0001"
	}
	 var json_data=JSON.stringify(obj);

	 $.ajax({
    	url: baseURL+'/Server/SignUp',	
        dataType: "json",
        type: "post",
      	contentType: "application/json",
        data: json_data,

    	success : function(data){
        	alert("접수되었습니다.");
        }

    });
}
*/
/*예약을 취소하는 함수*/

function reservation_delete(number){
	var reservation_number=$(number).attr("number");
	var obj={
		"reqData":{
				"reservation_number":reservation_number
			},
		"reqCode":"RV0004"
	}
	var json_data=JSON.stringify(obj);

	$.ajax({
	    url: baseURL+'/Reservation/Delete',  
    	dataType: "json",
        type: "post",
        contentType: "application/json",
	    data: json_data,

    	success : function(data){
        	if(data.resData=="success"){
        		alert("삭제되었습니다.");
        	}
		}
	});	

}

/*예약을 완료처리하는 함수*/
function reservation_complete(number){
	var reservation_number=$(number).attr("number");
	var obj={
		"reqData":{
				"reservation_number":reservation_number
			},
		"reqCode":"RV0005"
	}
	var json_data=JSON.stringify(obj);
	console.log(json_data);

	$.ajax({
	    url: baseURL+'/Reservation/Complete',  
    	dataType: "json",
        type: "post",
        contentType: "application/json",
	    data: json_data,

    	success : function(data){
    		console.log(data.resCode);
        	alert("완료되었습니다.");
		}
	});

}

