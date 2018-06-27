<body id="DataEntry">
    <div class="begin">
        <link rel='stylesheet' href = '<?php echo URL; ?>public/css/form.css'/>
        <div class="contain_form7">
            <form action="<?php echo URL; ?>addProduct/run" method='post'>
                <h1>Add Product</h1>
                <hr>
                <?php echo $this->message?>
                <input type="text" placeholder="product_code" name="product_code" required><br />
                <input type="text" placeholder="product_name" name="prodcut_name" required><br />
                <input type="text" placeholder="price" name="price" required><br />
                <input type="text" placeholder="discount" name="discount" required><br />
                <input type="text" placeholder="quantity" name="quantity" required><br />
                <input type="submit" id="button" value="Add">


            </form>
        </div>
    </div>
</body>