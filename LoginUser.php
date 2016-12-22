<?php

    $user = $_POST["username"];
    $pass = $_POST["password"];
    
    //Some dummy data
    $fname = "First Name";
    $lname = "Last Name";
    $age = "99";
    $phone = "021xxxxxx";
    $email = "anemail@testing.com";
    //$user = "username";
    //$pass = "password";

    require("db_config.php");
    require("encryption.php");

    $con = mysqli_connect($host, $username, $password, $database);


    $statement = mysqli_prepare($con, "SELECT * FROM Users WHERE USERNAME = ? AND PASSWORD = ?");
    mysqli_stmt_bind_param($statement, "ss", $user, $pass);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID, $fname, $lname, $age, $phone, $email, $user, $colPass);    

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){ 
        if(password_verify($pass, $colPass)){
            $response["success"] = true;
            $response["firstName"] = $fname;
            $response["lastName"] = $lname;
            $response["age"] = $age;
            $response["phone"] = $phone;
            $response["email"] = $email;
            $response["user"] = $user;
            $response["pass"] = $pass;
        }
    }

    echo json_encode($response);
?>