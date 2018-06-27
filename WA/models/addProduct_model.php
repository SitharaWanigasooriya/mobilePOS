<?php

class AddProduct_Model extends Model {

    public function __construct() {
        parent::__construct();
    }

    public function run($data, $mess) {
        if (empty($mess)) {
            $this->db->insert('inventory', array(
                'product_code' => $data['product_code'],
                'prodcut_name' => $data['prodcut_name'],
                'discount' => $data['discount'],
                'quantity' => $data['quantity'],
                'price' => $data['price'],
                'company_id' => $_SESSION['company_id']
            ));
            $mess = "Successful";
            header('location: ../addProduct');
        } else {
           
          
            header('location: ../addProduct');
        }
    }

}
