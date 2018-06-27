<?php
require 'config.php';
require 'util/Auth.php';

// Using an autoloader
function __autoload($class) {
require LIBS . $class .".php";
}






$boostrap = new Boostrap();

//
//$bootstrap->setControllerPath('name of the controllers containing folder');
//$bootstrap->setModelPath('name of the controllers containing folder');
//$bootstrap->setDefaultFile('');
//$bootstrap->setErrorFile('');

$boostrap->init();