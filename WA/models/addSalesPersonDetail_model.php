<?php

class AddSalesPersonDetail_Model extends Model {

    public function __construct() {
        parent::__construct();
    }

    public function run($data) {
        $this->db->insert('sales_person', array(
            'NIC' => $data['NIC'],
            'first_name' => $data['first_name'],
            'second_name' => $data['second_name'],
            'initials' => $data['initials'],
            'email' => $data['email'],
            'telephone_no' => $data['telephone_no'],
            'date_of_birth' => $data['date_of_birth'],
            'age' => $data['age'],
            'gender' => $data['gender'],
            'house_no' => $data['house_no'],
            'street' => $data['street'],
            'city' => $data['city'],
            'company_id' => $data['company_id'],
        ));
        
        header('location: ../addSalesPersonDetail');
    }
}
