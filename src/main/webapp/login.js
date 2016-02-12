/*login기능*/
$(document).ready(login())
function login(){
	$("#loginButton").click(function(){

		var username=$("#loginID").val();
		var password=$("#loginPASS").val();
	 
	    $.ajax({
	        url: '/login?username='+username+'&'+'password='+password,
	        type: "post",
	        success : function(data){
	        	console.log("hello");
	        	console.log(data);
	            var string="";
	            /*for(var i=0;i<data.resData.length;i++)
	            {
	                string+="<tr>"
	               
	                string+="</tr>"
	            }
	            string+='</tbody>'
	            
				var login_info = {
					'store_number_login':$("#loginID").val()
				};

				localStorage.setItem('login_info',JSON.stringify(login_info));

				console.log(login_info.store_number_login);
			            $("#serverList").html(string);   */  
			    window.location="./admin/index.html";

	        },
	        error : function(data){
	        	console.log(data);
	        }
	    });
		//
	})
}