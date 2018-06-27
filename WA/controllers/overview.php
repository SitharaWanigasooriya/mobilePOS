<?php

class Overview extends Controller {

    function __construct() {
        parent::__construct();
    }

    function index() {
        $this->view->title= 'Overview';
        
        $this->view->render('header');
        $this->view->render('overview/index');
        $this->view->render('footer');
    }

    public function other() {
        require 'models/overview_model.php';
        $model = new Help_Model();
        $this->view->blah = $model->blah();
    }

}
