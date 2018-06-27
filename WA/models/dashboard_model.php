<?php

class Dashboard_Model extends Model {

    function __construct() {
        parent::__construct();
    }

    function xhrInsert() {
        $text = filter_input(INPUT_POST, 'text');
        $sth = $this->db->prepare('INSERT INTO testing (`text`) VALUES (:text)');
        $sth->execute(array(':text'=>$text));
        $data = array('text'=>$text,'id'=>$this->db->lastInsertId());
        echo json_encode($data);
    }

    function xhrGetListings(){
        $sth=$this->db->prepare('SELECT * FROM testing');
        $sth->setFetchMode(PDO::FETCH_ASSOC);
        $sth->execute();
        $data= $sth->fetchAll();
        echo json_encode($data);
    }
    function xhrDeleteListing(){
        $id = filter_input(INPUT_POST, 'id');
        echo $id;
        $sth-> $this->db->prepare('DELETE FROM testing WHERE id = "'.$id.'"');
        $sth->execute();
        
    }
    

}
