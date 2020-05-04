<?php

include("config.php");

$sql = "SELECT * FROM tb_hewan";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'nama_pemilik' => $row['nama_pemilik'],
    'nama_hewan' => $row['nama_hewan'],
    'perawatan_1' => $row['perawatan_1'],
    'perawatan_2' => $row['perawatan_2'],
    'perawatan_3' => $row['perawatan_3'],
    'perawatan_4' => $row['perawatan_4']    
));
}
echo json_encode(array("result" => $result));
?>