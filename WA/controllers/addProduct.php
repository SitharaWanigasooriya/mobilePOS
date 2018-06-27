<?php

class AddProduct extends Controller {

    function __construct() {
        parent::__construct();
        Auth::handleLogin();
    }

    function index() {
        $this->view->title = 'Add Products';
        $this->view->message ="";
        $this->view->render('header');
        $this->view->render('addProduct/index');
        $this->view->render('footer');
    }

    function run() {

        $data = array();

        $data['product_code'] = filter_input(INPUT_POST, 'product_code');
        $data['prodcut_name'] = filter_input(INPUT_POST, 'prodcut_name');
        if ($this->validate->minlength($data['prodcut_name'],2)){
            $mess=$this->validate->minlength($data['prodcut_name'],2,'prodcut name');
            echo $mess;          
        }
        $data['discount'] = filter_input(INPUT_POST, 'discount');
        $data['quantity'] = filter_input(INPUT_POST, 'quantity');
        $data['price'] = filter_input(INPUT_POST, 'price');
        
        //@TODO: Do your error checking!
        //refresh the page
        //header('location: '.URL.'user');
        $this->model->run($data, $mess);
        $this->view->message = $mess;
    }

}
