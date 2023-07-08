<?php
if(isset($_REQUEST['name']) && !empty($_REQUEST['name'])){
	
	extract($_REQUEST);
	
	$con=mysqli_connect("localhost","root","123","msbte");
	
	$arr=explode('@',$email);
	$usename=$arr[0];
	
	$sql1="SELECT * FROM user WHERE username='{$usename}'";
	$res=mysqli_query($con,$sql1);
	if(mysqli_num_rows($res)>0){
		$usename=$usename.rand(000,999);
	}
	
	$password=rand(0000,9999);
	
	$sql="INSERT INTO user(name,mobile_number,college_name,city,username,password,email)VALUES('$name','$mob','$college_name','$city','$usename','$password','$email')";
	
	$responce_data=array();
	
	if(mysqli_query($con,$sql)){

$message = "
<html>
<head>
<title>Login Details For MSBTE App</title>
</head>
<body>
<p>Login Details For MSBTE App</p>
<table>
<tr><th>Username: ".$usename."</th></tr>
<tr><th>Password: ".$password."</th></tr>
</table>
</body>
</html>
";
		
$from="info@msbtestudy.online";
$subject="Login Details For MSBTE App!";		
$headers = "MIME-Version: 1.0" . "\r\n";
$headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
$headers .= 'From: <'.$from.'>' . "\r\n";
$headers .= 'Cc: '.$from.'' . "\r\n";

$mail($email,$subject,$message,$headers);	
		
		array_push($responce_data,array('status'=>'success','msg'=>'User Registered Successfully!'));
		echo json_encode(array('server_response'=>$responce_data));
		die();
		
	}else{
		$error=mysqli_error($con);
		array_push($responce_data,array('status'=>'error','msg'=>$error));
		echo json_encode(array('server_response'=>$responce_data));
		die();
	}
	
}


?>