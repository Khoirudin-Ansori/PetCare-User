<?php

include("config.php");

$sql = "SELECT * FROM tb_hewan";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'nama_pemilik' => $row['nama_pemilik'],
    'alamat_pemilik' => $row['alamat_pemilik'],
    'no_hp' => $row['no_hp'],
    'nama_hewan' => $row['nama_hewan'],
    'jenis_kelamin' => $row['jenis_kelamin'],
    'tanggal_penitipan' => $row['tanggal_penitipan'],
    'tanggal_kembali' => $row['tanggal_kembali']
    
));
}
echo json_encode(array("result" => $result));
?>