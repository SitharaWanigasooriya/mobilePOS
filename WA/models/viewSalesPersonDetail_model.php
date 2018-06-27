<?php

class ViewSalesPersonDetail_Model extends Model {

    public function __construct() {
        parent::__construct();
    }

    public function salesPersonList() {
        return $this->db->select('SELECT sales_person.NIC,sales_person.first_name,sales_person.email FROM sales_person LEFT OUTER JOIN company ON sales_person.company_id=company.company_id WHERE sales_person.company_id=:company_id',array(':company_id'=>$_SESSION['company_id']));
    }

    public function salesPersonSingleList($NIC) {//fetch the details in the salesperson table
        return $this->db->select('SELECT * FROM sales_person WHERE `NIC` =:NIC AND `company_id`=:company_id', array(':NIC' => $NIC,':company_id'=>$_SESSION['company_id']));
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

