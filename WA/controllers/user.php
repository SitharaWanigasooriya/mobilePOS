<?php

class User extends Controller {

    public function __construct() {
        parent::__construct();
        Auth::handleLogin();
    }

    public function index() {
        $this->view->title= 'Users';
        $this->view->userList = $this->model->userList();
        
        $this->view->render('header');
        $this->view->render('user/index');
        $this->view->render('footer');
    }
    public function create(){
        $data=array();
        $data['user_name']=filter_input(INPUT_POST, 'user_name');
        $data['password']=Hash::create('sha256',filter_input(INPUT_POST, 'password'),HASH_PASSWORD_KEY);
        $data['email']=filter_input(INPUT_POST, 'email');
        $data['role_id']=filter_input(INPUT_POST, 'role_id');
    
        //@TODO: Do your error checking!
        $this->model->create($data);
        //refresh the page
        header('location: '.URL.'user');
    }
    public function edit($user_id){
        $this->view->title= 'Edit User';
        //fetch individual user
        $this->view->user = $this->model->userSingleList($user_id);
        
        $this->view->render('header');
        $this->view->render('user/edit');
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
