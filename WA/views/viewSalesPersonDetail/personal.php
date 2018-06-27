<body id ="supervise">
    <div>
        <div class="begin5">
            <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
            <div class="">

                <h1>Personal Details</h1>
                <table id="personaltable">
                    <thead>
                        <tr>
                            <th scope="col" >NIC</th>
                            <th scope="col">Name </th>
                            <th scope="col">Email</th>
                            <th scope="col">Telephone Number</th>
                            <th scope="col">Date of birth</th>
                            <th scope="col">gender</th>
                            <th scope="col">Address</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        foreach ($this->salesPersonSingleList as $key => $value) {

                            echo '<tr>' . '<td>' . $value['NIC']; //sales person table 1 id
                            echo '<td>' . $value['initials'] . $value['first_name'] . $value['second_name'];
                            echo '<td>' . $value['email'];
                            echo '<td>' . $value['telephone_no'];
                            echo '<td>' . $value['date_of_birth'];
                            echo '<td>' . $value['gender'];
                            echo '<td>' . $value['house_no'] . $value['street'] . $value['city'];
                            echo '<td>
           <a href="' . URL . 'viewSalesPersonDetail/pdf/' . $value['NIC'] . '">PDF</a>' . '</td></tr>';

//            <a href="' . URL . 'viewSalesPersonDetail/official/' . $value['NIC'] . '">Official Details</a>          
                        }
                        ?>
                    </tbody>
                </table>
            </div></div></div></body>