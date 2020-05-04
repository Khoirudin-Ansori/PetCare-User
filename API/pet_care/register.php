<?php

include("config.php");

	$email=$_POST['email'];
	$username=$_POST['username'];
	$password=$_POST['password'];

	$sql = "INSERT INTO customer(email, username, password) values('$email','$username', '$password')";
	$query = mysqli_query($db, $sql);

	//apakah data berhasil di update
	if($query ) {

	}else{
		//kalau gagal tampilkan pesan 
		die("Gagal menyimpan perubahan...");
	}

?>
