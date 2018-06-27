<?php

class ViewInventory_Model extends Model {

    public function __construct() {
        parent::__construct();
    }

    public function salesItemList() {
        return $this->db->select('SELECT  product_code,prodcut_name,price,quantity FROM inventory WHERE `company_id`=:company_id' ,array(':company_id'=>$_SESSION['company_id']));
        //return $this->db->select('SELECT product_code,product_name,price,quantity FROM inventory WHERE `inventory.company_id`=:company_id',array(':company_id'=>$_SESSION['company_id']));
    }
}