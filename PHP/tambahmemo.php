<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

	if($_SERVER['REQUEST_METHOD']=='POST'){

		//Mendapatkan Nilai Variable
		$judul = $_POST['judul'];
		$isi_memo = $_POST['isi_memo'];

		//Pembuatan Syntax SQL
		$sql = "INSERT INTO memo (judul,isi_memo) VALUES ('$judul','$isi_memo')";

		//Import File Koneksi database
		require_once('koneksi.php');

		//Eksekusi Query database
		if(mysqli_query($conn,$sql)){
			echo 'Berhasil Menambahkan Memo';
		}else{
			echo 'Gagal Menambahkan Memo';
		}

		mysqli_close($conn);
	}
?>
