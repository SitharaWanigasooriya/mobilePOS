<?php

class CompanySignUp extends Controller{

     function __construct() {
        parent::__construct();
    }

    function index() {
        $this->view->title= 'Company SignUp';
        
        $this->view->render('header');
        $this->view->render('companySignUp/index');
        $this->view->render('footer');
    }
    function run(){
        $data=array();
        $data['company_name']=filter_input(INPUT_POST, 'company_name');
        $data['email']=filter_input(INPUT_POST, 'email');
        $data['maximum_no_salesperson']=filter_input(INPUT_POST, 'maximum_no_salesperson');
        $data['password']=filter_input(INPUT_POST, 'password');
        $data['city']=filter_input(INPUT_POST, 'city');
        $data['street']=filter_input(INPUT_POST, 'street');
    
        //@TODO: Do your error checking!
        $this->model->run($data);
        //refresh the page
        //header('location: '.URL.'user');
    }
}