<body>
    <div class="begin">
        <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
        <div class="contain_form">
            
            <form action ='<?php echo URL; ?>login/run' method='post'>
                <h1>Login</h1>
                <input type='text' name='username' id="user_name" placeholder="user name"/><br />
                <input type="password" name='password' id="password" placeholder="password"/><br />
                <input type='submit' value="LOGIN" id="button"/>
                <a href="">forget password?</a>
            </form>
        </div>
    </div>
