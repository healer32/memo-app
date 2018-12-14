<?php

 /*

 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/

 */

 //Mendapatkan Nilai ID
 $id = $_GET['id'];

 //Import File Koneksi Database
 require_once('koneksi.php');

 //Membuat SQL Query
 $sql = "DELETE FROM memo WHERE id=$id;";


 //Menghapus Nilai pada Database
 if(mysqli_query($conn,$sql)){
 echo 'Berhasil Menghapus Memo';
 }else{
 echo 'Gagal Menghapus Memo';
 }

 mysqli_close($conn);
 ?>
