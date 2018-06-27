<body>
    <div class="begin2">
        <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
        <div class="contain_form6">

            <form action='<?php echo URL; ?>companySignUp/run' method='post'>
                
                    <h1>Company SignUp</h1>
                    <p>Please fill in this form to create an account.</p>
                    <hr>
                    <input type="text" placeholder="company name" name="company_name" required><br />
                    <input type="text" placeholder="company email" name="email" required><br />
                    <input type="text" placeholder="maximum number of Sales Persons" name="maximum_no_salesperson" required><br />
                    <input type="password" placeholder="password" name="password" required><br />
                    <input type="password" placeholder="confirm password" name="confirm_password" required><br />
                    <input type="text" placeholder="city" name="city" required><br />
                    <input type="text" placeholder="street" name="street" required><br />
                    <label>
                        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
                    </label><br />

                    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p><br />

                    <input type='submit' value="Sign Up" id="button"/>
               
            </form>
        </div>
    </div>
</body>