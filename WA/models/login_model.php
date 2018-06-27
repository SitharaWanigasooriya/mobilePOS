<?php

class Login_Model extends Model {

    public function __construct() {
         parent::__construct();
    }
    public function run(){
        
        $sth = $this->db->prepare("SELECT * FROM user LEFT OUTER JOIN company ON user.company_name=company.company_name WHERE user_name = :login AND password=:password");
        //$sth = $this->db->prepare("SELECT * FROM user WHERE user_name = :login AND password=:password");
       
        $sth->execute(array(
            ':login'=>filter_input(INPUT_POST, 'username'),
            ':password'=>Hash::create('sha256',filter_input(INPUT_POST, 'password'),HASH_PASSWORD_KEY)));
        
        $data = $sth->fetch();
        
        $count = $sth->rowCount();
        
        
        if ($count >0){
            //login
            Session::init();
            Session::set('role_id',$data['role_id']);
            header('location: ../dashboard');
            Session::set('loggedIn',true);
            Session::set('user_id',$data['user_id']);
            Session::set('company_name',$data['company_name']);
            Session::set('company_id',$data['company_id']);
        }
        else{
            header('location: ../login');
        }
    }

}