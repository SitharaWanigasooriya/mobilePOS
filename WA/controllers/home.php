<?php

class Home extends Controller{

    function __construct() {
        parent::__construct();
        
    }
    function index() {
        $this->view->title= 'Home';
        
        $this->view->render('header');
        $this->view->render('home/index');
        $this->view->render('footer');
    }
    

}