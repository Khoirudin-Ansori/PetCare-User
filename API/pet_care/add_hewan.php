<?php

include("config.php");

	$nama_pemilik=$_POST['nama_pemilik'];
	$alamat_pemilik=$_POST['alamat_pemilik'];
	$no_hp=$_POST['no_hp'];
	$nama_hewan=$_POST['nama_hewan'];
	$jenis_kelamin=$_POST['jenis_kelamin'];
	$tanggal_penitipan=$_POST['tanggal_penitipan'];
	$tanggal_kembali=$_POST['tanggal_kembali'];

	$sql = "INSERT INTO tb_hewan(nama_pemilik, alamat_pemilik, no_hp, nama_hewan, jenis_kelamin, tanggal_penitipan, tanggal_kembali, perawatan_1, perawatan_2, perawatan_3, perawatan_4) values('$nama_pemilik','$alamat_pemilik', '$no_hp', '$nama_hewan', '$jenis_kelamin', '$tanggal_penitipan', '$tanggal_kembali', 'Dalam Perawatan', 'Dalam Perawatan', 'Dalam Perawatan', 'Dalam Perawatan')";
	$query = mysqli_query($db, $sql);

	//apakah data berhasil di update
	if($query ) {

	}else{
		//kalau gagal tampilkan pesan 
		die("Gagal menyimpan perubahan...");
	}

?>
