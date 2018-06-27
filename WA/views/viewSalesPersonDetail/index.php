
<body id ="supervise">
    <div>
        <div class="begin4">
            <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
            <h1>Sales Persons</h1>
            <table>
                <thead>
                    <tr>
                        <th scope="col" >NIC</th>
                        <th scope="col">first name</th>
                        <th scope="col">Email</th>
                        <th scope="col" colspan="2"></th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    foreach ($this->salesPersonList as $key => $value) {
                        echo '<tr>';
                        echo '<td>' . $value['NIC']; //sales person table 1 id
                        echo '<td>' . $value['first_name'];
                        echo '<td>' . $value['email'];
                        echo '<td>
            <a href="' . URL . 'viewSalesPersonDetail/personal/' . $value['NIC'] . '">Personal Details</a> 
            <td><a href="' . URL . 'viewSalesPersonDetail/official/' . $value['NIC'] . '">Official Details</a>
            </td>';
                        echo '</tr>';
                    }
                    ?>
                </tbody>
            </table>
        </div></div></body>