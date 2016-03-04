/*login기능*/
$(document).ready(login())
function login(){
	$("#loginButton").click(function(){

	    var obj=(Username=$("#loginID").val())&(password=$("#loginPASS").val())

	    $.ajax({
	        url: '/login?username='+$("#loginID").val()+'&&'+"password="+$("#loginPASS").val(), 
	        type: "post",
	        success : function(data){
	            
				var login_info = {
					'store_number_login':$("#loginID").val()
				};

				localStorage.setItem('login_info',JSON.stringify(login_info));

				console.log(login_info.store_number_login);
				console.log(data); 
				window.location.replace("./admin/index.html?user_name=10011");
	        }
	    });
	})
}