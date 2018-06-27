<?php

class Signup extends Controller {

    function __construct() {
        parent::__construct();
    }

    function index() {
        $this->view->title= 'SignUp';
        
        $this->view->render('header');
        $this->view->render('signup/index');
        $this->view->render('footer');
    }
    function run(){
        $this->model->run();
    }
}
