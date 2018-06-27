<?php

class ViewOrder extends Controller {

    function __construct() {
        parent::__construct();
        Auth::handleLogin();
    }

    function index() {
        $this->view->title= 'View Order';
        $this->view->salesOrderList = $this->model->salesOrderList();
        
        $this->view->render('header');
        $this->view->render('viewOrder/index');
        $this->view->render('footer');
    }
    
}