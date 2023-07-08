<?php
if(isset($_REQUEST['usename']) && !empty($_REQUEST['usernae'])){
	
	extract($_REQUEST);
	
	$con=mysqli_connect("localhost","root","123","msbte");
	

	$sql1="SELECT * FROM user WHERE username='{$usename}' AND password='{$password}'";
	$res=mysqli_query($con,$sql1);
	if(mysqli_num_rows($res)>0){
		
		while($row=mysqli_fetch_array($res,MYSQLI_ASSOC)){
		extract($row);
		array_push($responce_data,array('status'=>'success','msg'=>'User Logged Inn Successfully!','user_id'=>$user_id));
		echo json_encode(array('server_responce'=>$responce_data));
		die();
		}
		
	}else{
		
		array_push($responce_data,array('status'=>'error','msg'=>'Wrong username or password!','user_id'=>''));
		echo json_encode(array('server_responce'=>$responce_data));
		die();
	}
	
	
}


?> 