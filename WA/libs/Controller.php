<?php

class Controller {

    function __construct() {
        $this->view = new View();
        $this->validate = new Validate();
    }
    /*
     * @param string $name= name of the model
     * @param string $path = location of the model
     */
    public function loadModel($name,$modelPath='models/'){
        
        $path = $modelPath.$name.'_model.php';
        
        if(file_exists($path)){
            require $modelPath.$name.'_model.php';
            
            $modelName = $name.'_Model';
            $this->model = new $modelName();
        }
    }

}

