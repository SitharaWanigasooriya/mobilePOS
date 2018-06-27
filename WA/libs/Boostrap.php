<?php

/*
 * 
 */
class Boostrap {

    private $_url = null;
    private $_controller = null;
    
    private $_controllerPath='controllers/';
    private $_modelPath='models/';
    private $_errorFile='errorr.php';
     private $_defaultFile = 'home.php';

    
    /*
     * Starts the boostrap
     */
    public function init() {
        //Sets the protected $_url
        $this->_getUrl();

        // load the default controller if no url is set
        if (empty($this->_url[0])) {
            $this->_loadDefaultController();

            return false;
        }
        $this->_loadExistingController();
        $this->_callControllerMethod();
    }

    public function setControolerPath($path){
        $this->_controllerPath = trim($path, '/') . '/';
    }
    
    public function setModelPath($path){
        $this->_modelPath = trim($path, '/') . '/';
    }
    
    public function setErrorFile($path){
        $this->_errorFile = trim($path, '/');
    }
    
    public function setDefaultFile($path)
    {
        $this->_defaultFile = trim($path, '/');
    }
    /**
     * Fetches the $_GET from 'url'
     */
    private function _getUrl() {// if private better use underscore
        //$url = isset($_GET['url']) ? $_GET['url'] : null;
        $this->_url = filter_input(INPUT_GET, 'url');
        $this->_url = rtrim($this->_url, '/');
        $this->_url = filter_var($this->_url, FILTER_SANITIZE_URL);
        //clean up the url's noby
        $this->_url = explode('/', $this->_url);
    }

    /**
     * This loads if there is no GET parameter passed
     */
    private function _loadDefaultController() {
        require $this->_controllerPath.$this->_defaultFile;
        $this->_controller = new Home();
        $this->_controller->index();
    }

    /**
     * Load an existing controller if there IS a GET parameter passed
     * 
     * @return boolean|string
     */
    private function _loadExistingController() {
        $file = $this->_controllerPath . $this->_url[0] . '.php';
        if (file_exists($file)) {
            require $file;
            $this->_controller = new $this->_url[0];
            $this->_controller->loadModel($this->_url[0],$this->_modelPath);
        } else {
            $this->_errorr();
            return false;
        }
    }

    /**
     * If a method is passed in the GET url paremter
     * 
     *  http://localhost/controller/method/(param)/(param)/(param)
     *  url[0] = Controller
     *  url[1] = Method
     *  url[2] = Param
     *  url[3] = Param
     *  url[4] = Param
     */
    private function _callControllerMethod() {

        $length = count($this->_url);


        if ($length > 1) {
            //check whether  the calling methods are exists
            if (!method_exists($this->_controller, $this->_url[1])) {

                $this->_errorr();
            }
        }
        switch ($length) {
            case 5:
                //Controller->Method(Param1, Param2, Param3)
                $this->_controller->{$this->_url[1]}($this->_url[2], $this->_url[3], $this->_url[4]);
                break;

            case 4:
                //Controller->Method(Param1, Param2)
                $this->_controller->{$this->_url[1]}($this->_url[2], $this->_url[3]);
                break;

            case 3:
                //Controller->Method(Param1, Param2)
                $this->_controller->{$this->_url[1]}($this->_url[2]);
                break;

            case 2:
                //Controller->Method(Param1)
                $this->_controller->{$this->_url[1]}();
                break;

            default:
                //Something has heywire with the parameters
                $this->_controller->index();
                break;
        }
    }

    private function _errorr() {
        require $this->_controllerPath . $this->_errorFile;
        $this->_controller = new Errorr();
        $this->_controller->index();
        exit;
    }

}
