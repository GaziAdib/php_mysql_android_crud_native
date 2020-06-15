<?php
$connection = mysqli_connect("localhost","id13508374_adib","s]R5OMEdf%fmZOCP","id13508374_employee_db");

     $id = $_POST["id"];
     $name = $_POST["name"];
     $email = $_POST["email"];
     $contact = $_POST["contact"];
     $address = $_POST["address"];
     
     $sql = "UPDATE data SET  name = '$name', email = '$email', contact = '$contact', address = '$address' WHERE id = '$id' ";
     
     $result = mysqli_query($connection,$sql);
     
     if($result){
         echo "Data Updated";
        
     }
     else{
         echo "Failed";
     }
     mysqli_close($connection);
?>