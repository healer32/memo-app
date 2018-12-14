<?php


	$id = $_GET['id'];

	require_once('koneksi.php');

	$sql = "SELECT * FROM memo WHERE id=$id";
	$r = mysqli_query($conn,$sql);
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(
			"id"=>$row['id'],
			"judul"=>$row['judul'],
			"isi_memo"=>$row['isi_memo']
		));

	echo json_encode(array('result'=>$result));

	mysqli_close($conn);
?>
