
<body id ="supervise">
    <div>
        <div class="begin4">
            <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
            <h1>Inventory</h1>
            <table>
                <thead>
                    <tr>
                        <th scope="col" >product code</th>
                        <th scope="col">product name</th>
                        <th scope="col">price</th>
                        <th scope="col">quantity</th>
                   
                    </tr>
                </thead>
                <tbody>
                    <?php
                    foreach ($this->salesItemList as $key => $value) {
                        echo '<tr>';
                        echo '<td>' . $value['product_code']; //sales person table 1 id
                        echo '<td>' . $value['prodcut_name'];
                        echo '<td>' . $value['price'];
                        echo '<td>' . $value['quantity'];
                        echo '</td>';
                        echo '</tr>';
                    }
                    ?>
                </tbody>
            </table>
        </div></div></body>