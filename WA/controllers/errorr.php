<?php

class Errorr extends Controller {

    function __construct() {
        parent::__construct();
        echo 'This is an error!';       
    }
    function index(){
        $this->view->title= '404 Error';
        $this->view->msg = 'This page does not exists';
        
        $this->view->render('header');
        $this->view->render('errorr/index');
        $this->view->render('footer');
    }


}

