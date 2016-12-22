<?php
    

    $fName = $_POST["firstName"];
    $lName = $_POST["lastName"];
    $age = $_POST["age"];
    $phone = $_POST["phone"];
    $email = $_POST["email"];
    $user = $_POST["username"];
    $pass = $_POST["password"]; 
    
    //TESTING DUMMY DATA
    /*$fName = "Timmy";
    $lName = "Birdy";
    $age = "26";
    $phone = "0218955";
    $email = "emails@killingus.com";
    $user = "timmyturner";
    $pass = "testing124";*/
        
    
    require("db_config.php");
    require("encryption.php");

    $con = mysqli_connect($host, $username, $password, $database);
    // Check connection
    if (mysqli_connect_errno()){
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
      }


    
     //Check if the username you provided is available
    function usernameAvailable(){
        global $con, $user, $pass;
        $statement = mysqli_prepare($con, "SELECT * FROM Users WHERE USERNAME = ?");
        mysqli_stmt_bind_param($statement, "s", $user);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement); 
        if ($count < 1){
            return true; 
        }else {
            return false; 
        }
    }
    
    //Register the user
    function registerUser(){
        global $con, $fName, $lName, $age, $phone, $email, $user, $pass;
        $passHash = password_hash($pass, PASSWORD_DEFAULT);
        $statement = mysqli_prepare($con,"INSERT INTO Users (FIRSTNAME, LASTNAME, AGE, PHONE, EMAIL, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?)");
        // Perform a query, check for error
        if (!$statement){
          echo("Error description: " . mysqli_error($con));
          }
        if (!mysqli_stmt_bind_param($statement,"sssssss", $fName, $lName, $age, $phone, $email, $user, $passHash)){
          echo("Error description: " . mysqli_error($con));
          }
        if (!mysqli_stmt_execute($statement)){
          echo("Error description: " . mysqli_error($con));
          }
        mysqli_close($con);
    }

    //Excecution of registration
    $response = array();
    $response["success"] = false;
    $response["userTaken"] = false;

    if (usernameAvailable()){
        registerUser();
        $response["success"] = true;  
    }else{
        $response["userTaken"] = true;
    }
    echo json_encode($response);
    
?>