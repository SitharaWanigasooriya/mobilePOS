<body>
    <div class="begin1">
        <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
        <div class="contain_form1">
            <form action='<?php echo URL; ?>signup/run' method='post'>
                <h1>Sign Up</h1>
                <p>Please fill in this form to create an account.</p>
                <hr>

                <input type="text" placeholder="user name" name="user_name" required><br />
                <input type="text" placeholder="company name" name="company_name" required><br />
                <input type="text" placeholder="email" name="email" required><br />
                <input type="password" placeholder="password" name="password" required><br />
                <input type="password" placeholder="confirm password" name="confirm_password" required><br />
                <select name ="role_id">
                    <option value="2">Superwiser</option>
                    <option value="3">DataEntry</option>

                </select><br />
                <label>
                    <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                </label><br />

                <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p><br />

                <input type='submit' value="Sign Up" id="button"/>
            </form>
        </div>

    </div>
</body>