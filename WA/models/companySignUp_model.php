<?php

class CompanySignUp_Model extends Model {

    public function __construct() {
         parent::__construct();
    }
    public function run($data){
              
      
        $this->db->insert('company', array(
            'company_name' => $data['company_name'],
            'email' => $data['email'],
            'maximum_no_salesperson' => $data['maximum_no_salesperson'],
            'password' => $data['password'],
            'city' => $data['city'],
            'street' => $data['street'],
        ));
        
        header('location: ../signup');
    }
    

}