<?php

class User_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    public function userList() {
        return $this->db->select('SELECT user_id,user_name,email FROM user WHERE `company_name`=:company_name',array(':company_name'=>$_SESSION['company_name']));
    }

    public function userSingleList($user_id) {
        return $this->db->select('SELECT user_id,user_name,email,role_id FROM user WHERE `user_id` =:user_id AND `company_name`=:company_name', array(':user_id' => $user_id,':company_name'=>$_SESSION['company_name']));
    }

    public function create($data) {
        $this->db->insert('user', array(
            'user_name' => $data['user_name'],
            'password' => $data['password'],
            'email' => $data['email'],
            'role_id' => $data['role_id'],
            'company_name' => $_SESSION['company_name']
        ));
    }

    public function editSave($data) {
        
        $postData = array(
            'user_name' => $data['user_name'],
            'password' => Hash::create('sha256', $data['password'], HASH_PASSWORD_KEY),
            'email' => $data['email'],
            'role_id' => $data['role_id']
        );
       $this->db->update('user', $postData, "`user_id` = {$data['user_id']}");
    }

    public function delete($user_id) {
        $result = $this->db->select('SELECT role_id FROM user WHERE `user_id` = :user_id AND `company_name`=:company_name', array(':user_id' => $user_id,':company_name'=>$_SESSION['company_name']));
        
        if ($result[0]['role_id'] == 2) 
            return false;

        $this->db->delete('user', "user_id = '$user_id'");
        
    }

}
