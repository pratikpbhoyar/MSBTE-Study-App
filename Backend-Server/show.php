<?php
$con=mysqli_connect("localhost","u700859437_chms","S4m/y395i[","u700859437_chms");
$sql="SELECT * FROM atldata";
$res=mysqli_query($con,$sql);
if(mysqli_num_rows($res)>0){
	while($row=mysqli_fetch_array($res,MYSQLI_ASSOC)){
		extract($row);
	}
}else{
	$r1="Updating..";
	$r2="Updating..";
}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<style>
.dotred {
  height: 300px;
  width: 300px;
  background-color: #FF6347;
  border-radius: 50%;
  display: inline-block;
  font-size: 22px;
}
.dotgreen {
  height:300px;
  width: 300px;
  background-color: #7CFC00;
  border-radius: 50%;
  display: inline-block;
   font-size: 22px;
}
</style>
</head>
<body  style=" background: url('./bg15.jpg') no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;">
    
	<div style=" margin: 0;
  position: absolute;top: 50%;
  -ms-transform: translateY(-50%);
  transform: translateY(-50%);">

<?php
if($r1=="OPEN"){
	?>
	<span class="dotgreen"> Lane 1 is <?php echo"$r1"; ?></span>
	<?php
}elseif($r1=="CLOSED"){
	?>
	<span class="dotred"> Lane 1 is <?php echo"$r1"; ?></span>
	<?php
}else{
	?>
	<span class="dotred"> Lane 1 is <?php echo"$r1"; ?></span>
	<?php
}
?>
<br/><br/>
<?php
if($r2=="OPEN"){
	?>
	<span class="dotgreen"> Lane 2 is <?php echo"$r2"; ?> </span>
	<?php
}elseif($r2=="CLOSED"){
	?>
	<span class="dotred"> Lane 2 is <?php echo"$r2"; ?></span>
	<?php
}else{
	?>
	<span class="dotred"> Lane 2 is <?php echo"$r2"; ?></span>
	<?php
}
?>

</div>
</body>
</html>

