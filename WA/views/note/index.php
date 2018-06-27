<h1>Note</h1>

<form method="post" action="<?php echo URL; ?>note/create">
    <label>Title</label><input type="text" name ="title"/><br />
    <label>Context</label><input type="text" name ="context"/><br />
    <label>&nbsp;</label><input type = "submit"/>
</form>
<hr />
<table>
    <?php
    foreach ($this->noteList as $key => $value) {
        echo '<tr>';
        echo '<td>' . $value['title'].'</td>';
        echo '<td>' . $value['date'].'</td>';
        echo '<td>
             <a href="' . URL .'note/edit/'. $value['note_id'] . '">Edit</a> 
             <a class="delete" href="' . URL .'note/delete/'. $value['note_id'] . '">Delete</a> 
             </td>';
        echo '</tr>';
    }
    ?>

</table>

<script>
    $(function(){
        $('.delete').click(function(e){
            var c= confirm("Are you sure you want to delete?");
            
            if(c==false) {
                return false;}
        });
    });    
    
    </script>