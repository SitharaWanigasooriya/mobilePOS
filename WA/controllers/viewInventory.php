<?php

class ViewInventory extends Controller {

    function __construct() {
        parent::__construct();
        Auth::handleLogin();
    }

    function index() {
        $this->view->title= 'View Inventory';
        
        $this->view->salesItemList = $this->model->salesItemList();
        
        $this->view->render('header');
        $this->view->render('viewinventory/index');
        $this->view->render('footer');
    }
    function run(){
        $this->model->run();
    }
}