<h1>Note: Edit</h1>
<?php  print_r($this->note[0]);?>

<form method="post" action="<?php echo URL;?>note/editSave/<?php echo $this->note[0]['note_id'];?>">
    <label>Title</label><input type="text" name ="title" value="<?php echo $this->note[0]['title'];?>"/><br />
    <label>Context</label><input type="text" name="context" value="<?php echo $this->note[0]['context'];?>"/><br />
    
    <label>&nbsp;</label><input type = "submit"/>
</form>