var randomScalingFactor = function(){ return Math.round(Math.random()*1000)};

/*월별 예약정보를 받아와 갯수를 세아리는 함수*/

function getHistoryByMonth(month,year){
	var login_info = JSON.parse(localStorage.getItem('login_info'));
    var obj={
        "reqData":{
            "store_number":login_info.store_number_login,
            "month":month,
            "year" :year
        },

        "reqCode": "HS0003"
    };

    var json_data = JSON.stringify(obj);

    $.ajax({
        url: baseURL+'/History/GetListByMonth',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,
        async:false,
        success : function (data){
        	getHistoryByMonthData=data.resData;
        }
    });
    return getHistoryByMonthData;
}

function Query(query){
	var login_info = JSON.parse(localStorage.getItem('login_info'));
    var obj={
        "reqData":{
            "store_number":login_info.store_number_login,
            "query":query
        },

        "reqCode": "HS0005"
    };

    var json_data = JSON.stringify(obj);

    $.ajax({
        url: baseURL+'/History/Search',  
        dataType: "json",
        type: "post",
        contentType: "application/json",
        data: json_data,
        async:false,
        success : function (data){
        	query_number=data.resData.length;
        }
    });
    return query_number;
}

	var lineChartData = {
			labels : ["1월","2월","3월","4월","5월","6월","7월"],
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					data : [getHistoryByMonth("0","2016"),getHistoryByMonth("1","2016"),getHistoryByMonth("2","2016"),
					getHistoryByMonth("3","2016"),getHistoryByMonth("4","2016"),getHistoryByMonth("5","2016"),getHistoryByMonth("6","2016")]
				},
				{
					label: "My Second dataset",
					fillColor : "rgba(48, 164, 255, 0.2)",
					strokeColor : "rgba(48, 164, 255, 1)",
					pointColor : "rgba(48, 164, 255, 1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(48, 164, 255, 1)",
					data : [getHistoryByMonth("0","2016"),getHistoryByMonth("1","2016"),getHistoryByMonth("2","2016"),
					getHistoryByMonth("3","2016"),getHistoryByMonth("4","2016"),getHistoryByMonth("5","2016"),getHistoryByMonth("6","2016")]
				}
			]

		}
		
	var barChartData = {
			labels : ["10시~12시","12시~2시","2시~4시","4시~6시","6시~8시","8시~10시"],
			datasets : [
				{
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,0.8)",
					highlightFill: "rgba(220,220,220,0.75)",
					highlightStroke: "rgba(220,220,220,1)",
					data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
				},
				{
					fillColor : "rgba(48, 164, 255, 0.2)",
					strokeColor : "rgba(48, 164, 255, 0.8)",
					highlightFill : "rgba(48, 164, 255, 0.75)",
					highlightStroke : "rgba(48, 164, 255, 1)",
					data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
				}
			]
	
		}

	var pieData = [
				{
					value: Query("컷"),
					color:"#30a5ff",
					highlight: "#62b9fb",
					label: "컷"
				},
				{
					value: 50,
					color: "#ffb53e",
					highlight: "#fac878",
					label: "염색"
				},
				{
					value: Query("파마"),
					color: "#1ebfae",
					highlight: "#3cdfce",
					label: "파마"
				},
				{
					value: 120,
					color: "#f9243f",
					highlight: "#f6495f",
					label: "관리"
				}

			];
			
	var doughnutData = [
					{
						value: 300,
						color:"#30a5ff",
						highlight: "#62b9fb",
						label: "Blue"
					},
					{
						value: 50,
						color: "#ffb53e",
						highlight: "#fac878",
						label: "Orange"
					},
					{
						value: 100,
						color: "#1ebfae",
						highlight: "#3cdfce",
						label: "Teal"
					},
					{
						value: 120,
						color: "#f9243f",
						highlight: "#f6495f",
						label: "Red"
					}
	
				];

window.onload = function(){
	var chart1 = document.getElementById("line-chart").getContext("2d");
	window.myLine = new Chart(chart1).Line(lineChartData, {
		responsive: true
	});
	var chart2 = document.getElementById("bar-chart").getContext("2d");
	window.myBar = new Chart(chart2).Bar(barChartData, {
		responsive : true
	});
	var chart3 = document.getElementById("doughnut-chart").getContext("2d");
	window.myDoughnut = new Chart(chart3).Doughnut(doughnutData, {responsive : true
	});
	var chart4 = document.getElementById("pie-chart").getContext("2d");
	window.myPie = new Chart(chart4).Pie(pieData, {responsive : true
	});
	
};