<?php
$connection = mysqli_connect("localhost","id13508374_adib","s]R5OMEdf%fmZOCP","id13508374_employee_db");
$id = $_POST["id"];
$sql = "DELETE FROM data WHERE id='$id'";
$result = mysqli_query($connection ,$sql);
if($result) {
    echo "Data Deleted Successfully";
} else {
    echo "Failed to Delete Data!";
}
mysqli_close($connection);
?>