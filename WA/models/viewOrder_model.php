<?php

class ViewOrder_Model extends Model {

    public function __construct() {
        parent::__construct();
    }

    public function salesOrderList() {
        return $this->db->select('SELECT orderr.product_code,orderr.quantity,orderr.NIC FROM orderr',array());
    }
}