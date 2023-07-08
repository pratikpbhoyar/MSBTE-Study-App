<?php
if(session_status()!=PHP_SESSION_ACTIVE){
session_start();
}
session_regenerate_id();
if(isset($_REQUEST['quiz_title']) && !empty($_REQUEST['quiz_title'])){
$_SESSION['quiz_title']=$_REQUEST['quiz_title'];
}
if(isset($_SESSION)){
extract($_SESSION);
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
<form action="process_quiz.php" method="POST">
<?php
if(isset($userid) && !empty($userid)){
	?>
	<input type="hidden" name="userid" value="<?php echo"$userid"; ?>">
	<?php
$con=mysqli_connect("localhost","u700859437_msbte","Iqvm3xisy^S9","u700859437_msbte");

if(isset($quiz_title) && !empty($quiz_title)){
	
		?>
	<input type="hidden" name="quiz_title" value="<?php echo"$quiz_title"; ?>">
	<?php
	
	$sql="SELECT * FROM quiz_questions WHERE quiz_title='{$quiz_title}' ORDER BY qqid ASC";
	$res=mysqli_query($con,$sql);
	if(mysqli_num_rows($res)>0){
		$count=0;
		$checkdupunit=null;
		while($row=mysqli_fetch_array($res,MYSQLI_ASSOC)){
			extract($row);
			
	?>
	<input type="hidden" name="qqid[]" value="<?php echo"$qqid"; ?>">
	<input type="hidden" name="right_answer[<?php echo"$qqid"; ?>]" value="<?php echo"$right_answer"; ?>">
	<?php
	
			echo"<tr>
    <td colspan=\"2\"><div align=\"left\">$question</div></td>
  </tr>
  <tr>
    <td width=\"50%\"><div align=\"left\"><strong>Answers:</strong></div></td>
    <td width=\"50%\">&nbsp;</td>
  </tr>
  <tr>
    <td><div align=\"left\"><input type=\"radio\" name=\"option1[$qqid]\" value=\"$option1\"> $option1</div></td>
    <td><div align=\"left\"><input type=\"radio\" name=\"option2[$qqid]\" value=\"$option2\"> $option2</div></td>
  </tr>
  <tr>
    <td><div align=\"left\"><input type=\"radio\" name=\"option3[$qqid]\" value=\"$option3\"> $option3</div></td>
    <td><div align=\"left\"><input type=\"radio\" name=\"option4[$qqid]\" value=\"$option4\"> $option4</div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>";
			$count=$count+1;
		}
	}else{
			echo"<br/><br/><center><h4><strong>No Questions Found</strong></h4></center>";
	}
	
}else{
			echo"<br/><br/><center><h4><strong>No Questions Found</strong></h4></center>";
	}
	
	
}


?>  
</form>
</table>

</body>
</html>

