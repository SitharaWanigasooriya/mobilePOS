<?php

class ViewSalesPersonDetail extends Controller {

    function __construct() {
        parent::__construct();
        Auth::handleLogin();
    }

    
    
    public function index() {
        $this->view->title= 'View Sales Person';
        $this->view->salesPersonList = $this->model->salesPersonList();
        
        $this->view->render('header');
        $this->view->render('viewSalesPersonDetail/index');
        $this->view->render('footer');
    }
    
    public function personal($NIC){
        $this->view->title= 'Personal Details';
        //fetch individual user
        $this->view->salesPersonSingleList = $this->model->salesPersonSingleList($NIC);
        
        $this->view->render('header');
        $this->view->render('viewSalesPersonDetail/personal');
        $this->view->render('footer');
    }
    public function editSave($user_id){
        $data=array();
        $data['user_id']=$user_id;
        $data['user_name']=filter_input(INPUT_POST, 'user_name');
        $data['password']=Hash::create('sha256',filter_input(INPUT_POST, 'password'),HASH_PASSWORD_KEY);
        $data['email']=filter_input(INPUT_POST, 'email');
        $data['role_id']=filter_input(INPUT_POST, 'role_id');
        echo  $data['user_name']."".$data['password']."".$data['email']."".$data['role_id'];
    
        //@TODO: Do your error checking!
        $this->model->editSave($data);
        //refresh the page
        header('location: '.URL.'user');
        
    }
    public function delete($id){
        $this->model->delete($id);
        header('location: '.URL.'user');
    }

    
}
