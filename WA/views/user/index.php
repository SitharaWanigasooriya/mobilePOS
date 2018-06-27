<body id ="supervise">
    <div>
    <div class="begin4">
        <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
        <div class="contain_form4">


            <form method="post" action="<?php echo URL; ?>user/create">
                <h1>User</h1>
                <input type="text" name ="user_name" placeholder="user name"/><br />
                <input type="password" name="password" placeholder="password"/><br />
                <input type="text" name="email" placeholder="email"/><br />
                <select name ="role_id" id="options">
                    <option value="">--Role--</option>
                    <option value="2">Supervise</option>
                    <option value="3">Data Entry</option>

                </select><br />
                <label>&nbsp;</label><input type = "submit" Value="Enter" id="button"/>
            </form>
        </div></div>
    <hr />
    
    <table>

        <thead>
            <tr>
                <th scope="col" >ID</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col" colspan="2"></th>
            </tr>
        </thead>
        <tbody>
        <?php
        foreach ($this->userList as $key => $value) {
            echo '<tr>';
            echo '<td>' . $value['user_id'];
            echo '<td>' . $value['user_name'];
            echo '<td>' . $value['email'];
            echo '<td>
            <a href="' . URL . 'user/edit/' . $value['user_id'] . '">Edit</a> 
            <td> <a href="' . URL . 'user/delete/' . $value['user_id'] . '">Delete</a>
            </td>';
            echo '</tr>';
           
        }
        ?>
        </tbody>

    </table>
    </div>
</body>