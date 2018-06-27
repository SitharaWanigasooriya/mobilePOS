
<body>
    <div class="begin">
        <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
        <div class="contain_form">
            <form method="post" action="<?php echo URL; ?>user/editSave/<?php echo $this->user[0]['user_id']; ?>">
                <h1>User: Edit</h1>
                <input type="text" name ="user_name" value="<?php echo $this->user[0]['user_name']; ?>"/><br />
                <input type="password" name="password" value="<?php echo ''; ?>"/><br />
                <input type="text" name="email" value="<?php echo $this->user[0]['email']; ?>"/><br />
                <select name ="role_id">
                    <option value="2"<?php if ($this->user[0]['role_id'] == 2) {echo 'selected';} ?>>Supervise</option>
                    <option value="3"<?php if ($this->user[0]['role_id'] == 3) {echo 'selected';} ?>>Data Entry</option>


                </select><br />
                <label>&nbsp;</label><input type = "submit" value="Update" id="button"/>
            </form>
        </div>
    </div>
</body>