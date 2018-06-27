<?php

class Note extends Controller {

    public function __construct() {
        parent::__construct();
        Auth::handleLogin();
      
    }

    public function index() {
        $this->view->title= 'Notes';
        $this->view->noteList = $this->model->noteList();
        
        $this->view->render('header');
        $this->view->render('note/index');
        $this->view->render('footer');
    }
    public function create(){
        $data=array(
            'title'=> filter_input(INPUT_POST,  'title'),
            'context' => filter_input(INPUT_POST,'context'));
         
        //@TODO: Do your error checking!
       
        $this->model->create($data);
        //refresh the page
        header('location: '.URL.'note');
    }
    public function edit($id){
        $this->view->title= 'Edit Note';
        //fetch individual user
        $this->view->note = $this->model->noteSingleList($id);
        
        $this->view->render('header');
        $this->view->render('note/edit');
        $this->view->render('footer');
    }
    public function editSave($note_id){
        $data=array(
            'note_id'=>$note_id,
            'title'=> filter_input(INPUT_POST,  'title'),
            'context' => filter_input(INPUT_POST,'context'));
        
    
        //@TODO: Do your error checking!
        $this->model->editSave($data);
        //refresh the page
        header('location: '.URL.'note');
        
    }
    public function delete($note_id){
        $this->model->delete($note_id);
        header('location: '.URL.'note');
    }

    
}
