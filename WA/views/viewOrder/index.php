<body id ="supervise">
    <div>
        <div class="begin4">
            <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
            <h1>Orders</h1>
            <table>
                <thead>
                    <tr>
                        <th scope="col">NIC</th>
                        <th scope="col" >Product code</th>
                        <th scope="col">Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    foreach ($this->salesOrderList as $key => $value) {
                        echo '<tr>';
                        
                        echo '<td>' . $value['product_code'];
                        echo '<td>' . $value['quantity'];
                        echo '<td>' . $value['NIC']; //sales person table 1 id
                        echo '</td>';
                        echo '</tr>';
                    }
                    ?>
                </tbody>
            </table>
        </div></div></body>