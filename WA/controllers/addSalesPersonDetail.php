<?php

class AddSalesPersonDetail extends Controller {

    function __construct() {
        parent::__construct();
        Auth::handleLogin();
    }

    function index() {
        $this->view->title= 'Add Sales Person';
        
        $this->view->render('header');
        $this->view->render('addSalesPersonDetail/index');
        $this->view->render('footer');
    }
    function run(){
        $data=array();
        $data['NIC']=filter_input(INPUT_POST, 'NIC');
        $data['first_name']=filter_input(INPUT_POST, 'first_name');
        $data['second_name']=filter_input(INPUT_POST, 'second_name');
        $data['initials']=filter_input(INPUT_POST, 'initials');
        $data['email']=filter_input(INPUT_POST, 'email');
        $data['telephone_no']=filter_input(INPUT_POST, 'telephone_no');
        $data['date_of_birth']=filter_input(INPUT_POST, 'date_of_birth');
        $data['age']=filter_input(INPUT_POST, 'age');
        $data['gender']=filter_input(INPUT_POST, 'gender');
        $data['house_no']=filter_input(INPUT_POST, 'house_no');
        $data['street']=filter_input(INPUT_POST, 'street');
        $data['city']=filter_input(INPUT_POST, 'city');
        $data['company_id']=$_SESSION['company_id'];
    
        //@TODO: Do your error checking!
        $this->model->run($data);
        //refresh the page
        //header('location: '.URL.'user');
    }
}
