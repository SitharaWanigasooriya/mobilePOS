<body id="DataEntry">
    <div class="begin8">
        <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
        <div class="contain_form8">
            <form action='<?php echo URL; ?>addSalesPersonDetail/run' method='post'>

                <h1>Add Sales Person Detail</h1>
                <hr>

                <input type="text" placeholder="NIC" name="NIC" required><br />
                <input type="text" placeholder="first_name" name="first_name" required><br />
                <input type="text" placeholder="second_name" name="second_name" required><br />
                <input type="text" placeholder="initials" name="initials" required><br />
                <input type="text" placeholder="email" name="email" required><br />
                <input type="text" placeholder="telephone_no" name="telephone_no" required><br />
                <input type="text" placeholder="date_of_birth" name="date_of_birth" required><br />
                <input type="text" placeholder="age" name="age" required><br />
                <input type="text" placeholder="gender" name="gender" required><br />
<!--                <input type="text" placeholder="default_password" name="default_password" required><br />-->
                <input type="text" placeholder="house_no" name="house_no" required><br />
                <input type="text" placeholder="street" name="street" required><br />
                <input type="text" placeholder="city" name="city" required><br />

                <input type="submit" id="button" value="Add">


            </form>
        </div></div></body>