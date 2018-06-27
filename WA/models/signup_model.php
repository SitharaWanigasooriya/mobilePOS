<?php

class Signup_Model extends Model {

    public function __construct() {
         parent::__construct();
    }
    public function run(){
        $sql = "INSERT INTO user (`user_name`,`email`,`password`,`company_name`,`role_id`)VALUES (:user_name,:email,:password,:company_name,:role_id)";
        $sth = $this->db->prepare($sql);
        print_r($this->db->prepare($sql));
        die();
        $sth->execute(array(
            ':user_name'=> filter_input(INPUT_POST, 'user_name'),
            ':email'=> filter_input(INPUT_POST, 'email'),
            ':password' => Hash::create('sha256',filter_input(INPUT_POST, 'password'),HASH_PASSWORD_KEY),
            ':company_name' => filter_input(INPUT_POST, 'company_name'),
            ':role_id'=> filter_input(INPUT_POST, 'role_id')
            ));

            
        header('location: ../login');
      
    }

}