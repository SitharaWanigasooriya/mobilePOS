<?php

class Note_Model extends Model {

    function __construct() {
        parent::__construct();
        print_r ($_SESSION['company_name']);
    }

    public function noteList() {        
        return $this->db->select('SELECT * FROM note WHERE `user_id` = :user_id', array('user_id' => $_SESSION['user_id']));
    }

    public function noteSingleList($note_id) {
        return $this->db->select('SELECT * FROM note WHERE `user_id` = :user_id AND `note_id` =:note_id ', array('user_id' => $_SESSION['user_id'],':note_id' => $note_id));
    }

    public function create($data) {
        $this->db->insert('note', array(
            'user_id'=> $_SESSION['user_id'],
            'title' => $data['title'],
            'context' => $data['context'],
            'date' => date('Y-m-d H:i:s'),
        ));
    }

    public function editSave($data) {
        
        $postData = array(
            'title' => $data['title'],
            'context' => $data['context'],
            //'date' => $data['date'],
        );
       $this->db->update('note', $postData, "`user_id` = {$_SESSION['user_id']} AND `note_id` = {$data['note_id']}");
    }

    public function delete($note_id) {
        $this->db->delete('note', "`user_id` = {$_SESSION['user_id']} AND `note_id` = $note_id");
        
    }

}
