<?php
if(isset($_POST['userid']) && !empty($_POST['userid'])){
extract($_POST);

$con=mysqli_connect("localhost","u700859437_msbte","Iqvm3xisy^S9","u700859437_msbte");
$score=0;
$countq=count($qqid);
for($i=0;$i<$countq;$i++){
$var_qquid=$qqid[$i];
$ans="";
if(if(isset($option3[$i])) && !empty($option3[$i])){
$ans="Option 3";
}elseif(if(isset($option2[$i])) && !empty($option2[$i])){
$ans="Option 2";
}elseif(if(isset($option1[$i])) && !empty($option1[$i])){
$ans="Option 1";
}elseif(if(isset($option4[$i])) && !empty($option4[$i])){
$ans="Option 4";
}
if(right_answer[$i]==$ans){
$score=$score+1;
}
}
$score_p=100*$score/$countq;

$sql="INSERT INTO quiz_given(quiz_title,userid,score)VALUES('$quiz_title','$userid','$score_p')";
if(mysqli_query($con,$sql)){
	
	
$message = "
<html>
<head>
<title>QUIZ RESULT</title>
</head>
<body>
<p>QUIZ RESULT</p>
<p>Your score is: $score_p% for quiz: $quiz_title</p>
</body>
</html>
";
		
$from="info@msbtestudy.online";
$subject="Login Details For MSBTE App!";		
$headers = "MIME-Version: 1.0" . "\r\n";
$headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
$headers .= 'From: <'.$from.'>' . "\r\n";
$headers .= 'Cc: '.$from.'' . "\r\n";

@mail($email,$subject,$message,$headers);	


exit(header("Location: ./view_quiz.php?msg=Quiz Completed Successfully, Your Score is $score_p%!&type=success"));
}else{
exit(header("Location: ./view_quiz.php?msg=Something Went Wrong, Please try Again1&type=success"));
}
}else{
exit(header("Location: ./view_quiz.php?msg=Something Went Wrong, Please try Again1&type=success"));
}
?>