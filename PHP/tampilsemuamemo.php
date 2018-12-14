<?php

	require_once('koneksi.php');

	$sql = "SELECT * FROM memo";

	$r = mysqli_query($conn,$sql);

	$result = array();

	while($row = mysqli_fetch_array($r)){

		array_push($result,array(
			"id"=>$row['id'],
			"judul"=>$row['judul'],
			"isi_memo"=>$row['isi_memo']
		));
	}

	echo json_encode(array('result'=>$result));

	mysqli_close($conn);
?>
