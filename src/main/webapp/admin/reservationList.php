<?php 
header('Content-Type: application/json');
require_once("./db_info.php");
$s=mysql_connect("$SERV", "$USER", "$PASS") or die("실패입니다.");


mysql_select_db("$DBNM",$s);
$re=mysql_query("SELECT reservation_time, server_name, user_name, reservation_etc 
	FROM reservationView ORDER BY reservation_time ASC");


$i=0;
while($result=mysql_fetch_array($re)){
	$reservationList[$i]=array("reservation_time"=>$result[0],
		"server_name"=>$result[1],
		"user_name"=>$result[2],
		"reservation_etc"=>$result[3]
		);
	$i++;
}

echo json_encode($reservationList);
?>