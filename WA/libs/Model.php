<?php

class Model {

    function __construct() {
        //database object reuseeable in every whre
        $this->db = new Database(DB_TYPE, DB_HOST, DB_NAME, DB_USER, DB_PASS);
    }

}
