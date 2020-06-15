<?php
    $connection = mysqli_connect("localhost","id13508374_adib","s]R5OMEdf%fmZOCP","id13508374_employee_db");
    $name = $_POST["name"];
    $email = $_POST["email"];
    $contact = $_POST["contact"];
    $address = $_POST["address"];
    $sql = "INSERT INTO data(name,email,contact,address) VALUES ('$name', '$email', '$contact', '$address')";
    $result = mysqli_query($connection, $sql);
    if($result) {
        echo "Data Inserted successfully";
    } else {
        echo "Data Insertion Failed!";
    }
    mysqli_close($connection);
?>