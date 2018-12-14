<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable
		$id = $_POST['id'];
		$judul = $_POST['judul'];
		$isi_memo = $_POST['isi_memo'];

		//import file koneksi database
		require_once('koneksi.php');

		//Membuat SQL Query
		$sql = "UPDATE memo SET judul = '$judul', isi_memo = '$isi_memo' WHERE id = $id;";

		//Meng-update Database
		if(mysqli_query($conn,$sql)){
			echo 'Berhasil Update Memo';
		}else{
			echo 'Gagal Update Memo';
		}

		mysqli_close($conn);
	}
?>
