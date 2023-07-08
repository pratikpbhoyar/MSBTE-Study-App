<?php
if(session_status()!=PHP_SESSION_ACTIVE){
session_start();
}
session_regenerate_id();
if(isset($_REQUEST['userid']) && !empty($_REQUEST['userid'])){
$_SESSION['userid']=$_REQUEST['userid'];
}
if(isset($_REQUEST['subject']) && !empty($_REQUEST['subject'])){
$_SESSION['subject']=$_REQUEST['subject'];
}
if(isset($_REQUEST['category']) && !empty($_REQUEST['category'])){
$_SESSION['category']=$_REQUEST['category'];
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
</head>
<body  style=" background: url('./bg15.jpeg') no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;">
<table width="100%" style="width:100%; padding-left:2px;padding-right:2px;">
<tr><td>
<?php
if(isset($_REQUEST['userid']) && !empty($_REQUEST['userid'])){
	
	extract($_REQUEST);
	$con=mysqli_connect("localhost","root","123","msbte");

if(isset($category) && !empty($category) && $category=="lectures"){
	
	$sql="SELECT * FROM lectures WHERE subject='{$subject}' ORDER BY unit ASC";
	$res=mysqli_query($con,$sql);
	if(mysqli_num_rows($res)>0){
		$count=0;
		$checkdupunit=null;
		while($row=mysqli_fetch_array($res,MYSQLI_ASSOC)){
			extract($row);
			if($count==0){
				echo"<br/><center><h3><strong>SUBJECT: <u>$subject</u></strong></h3></center>";
				echo"<center><h4><strong>$unit</strong></h4></center>";
				$checkdupunit=$unit;
			}
			if($checkdupunit==$unit){
				
			}else{
				echo"<center><h4><strong>$unit</strong></h4></center>";
				$checkdupunit=$unit;
			}
			echo"<h4>$lecture_title</h4>";
			$lecture_video_link=str_replace('width="560"','width="100%"',$lecture_video_link);
			$lecture_video_link=str_replace('height="315"','height="auto"',$lecture_video_link);
			echo"$lecture_video_link";
			echo"<br/><br/>";
			$count=$count+1;
		}
	}else{
			echo"<br/><br/><center><h4><strong>No Lectures Found</strong></h4></center>";
	}
	
}elseif(isset($category) && !empty($category) && $category=="study"){
	
	$sql="SELECT * FROM study_material WHERE subject='{$subject}' ORDER BY unit ASC";
	$res=mysqli_query($con,$sql);
	if(mysqli_num_rows($res)>0){
		$count=0;
		$checkdupunit=null;
		while($row=mysqli_fetch_array($res,MYSQLI_ASSOC)){
			extract($row);
			if($count==0){
				echo"<br/><center><h3><strong>SUBJECT: <u>$subject</u></strong></h3></center>";
				echo"<center><h4><strong>$unit</strong></h4></center>";
				$checkdupunit=$unit;
			}
			if($checkdupunit==$unit){
				
			}else{
				echo"<center><h4><strong>$unit</strong></h4></center>";
				$checkdupunit=$unit;
			}
		
			echo"<a href=\"$pdf_file_link\" download=\"$subject-$unit.pdf\">$subject-$unit.pdf</a>";
			echo"<br/><br/>";
			$count=$count+1;
		}
	}else{
			echo"<br/><br/><center><h4><strong>No Study Material Found</strong></h4></center>";
	}
	
}elseif(isset($category) && !empty($category) && $category=="quiz"){
	
	$sql="SELECT * FROM quiz WHERE subject='{$subject}' ORDER BY unit ASC";
	$res=mysqli_query($con,$sql);
	if(mysqli_num_rows($res)>0){
		$count=0;
		$checkdupunit=null;
		while($row=mysqli_fetch_array($res,MYSQLI_ASSOC)){
			extract($row);
			echo"<h3><strong><a href=\"view_quiz.php?quiz_title=$quiz_title\">$unit</a></strong></h3>";		
			$count=$count+1;
		}
	}else{
			echo"<br/><br/><center><h4><strong>No Quiz Found</strong></h4></center>";
	}
	
}else{
	
}
	
	
}


?>  
</td>
</tr>
</table>

</body>
</html>

