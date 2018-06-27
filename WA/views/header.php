<!DOCTYPE html>
<html>
    <head>
        <title><?= (isset($this->title)) ? $this->title : 'Point of Sales'; ?></title>
        <link rel='stylesheet' href = '<?php echo URL; ?>public/css/default.css'/>
        <script type='text/javascript' src='<?php echo URL; ?>public/js/jQuery.js'></script>
        <script type='text/javascript' src='<?php echo URL; ?>public/js/custom.js'></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <?php
        if (isset($this->js)) {
            foreach ($this->js as $js) {
                echo '<script type="text/javascript" src="' . URL . 'views/' . $js . '"></script>';
            }
        }
        ?>
    </head>
    <body>
        <?php Session::init(); ?>
        <nav class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navi">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <div class="collapse navbar-collapse" id="navi">
                    <ul class="nav navbar-nav navbar-right">
                        <?php if (Session::get('loggedIn') == false): ?>
                            <li><a href="<?php echo URL; ?>home">Home</a></li>
                            <li><a href="<?php echo URL; ?>overview">Overview</a></li>
                        <?php endif; ?>
                        <?php if (Session::get('loggedIn') == true): ?>
                            <li><a href="<?php echo URL; ?>dashboard">Dashboard</a></li>
<!--                            <li><a href="<?php echo URL; ?>note">Note</a></li>-->
                            <?php if (Session::get('role_id') == 2): ?>
                                <li><a href="<?php echo URL; ?>user">Users</a></li>
                                <li><a href="<?php echo URL; ?>viewSalesPersonDetail" class="company">View Sales Person Detail</a></li>
                                <li><a href="<?php echo URL; ?>viewOrder">View Order</a></li>
                                <li><a href="<?php echo URL; ?>viewInventory" class="company">View Inventory</a></li>
                            <?php endif; ?>
                            <?php if (Session::get('role_id') == 3): ?>
                                <li><a href="<?php echo URL; ?>addProduct">Add Product</a></li>
                                <li><a href="<?php echo URL; ?>addSalesPersonDetail" class="company">Add Sales Person Detail</a></li>
                            <?php endif; ?>
                            <li><a href="<?php echo URL; ?>dashboard/logout">LogOut</a></li>
                        <?php else: ?>
                            <li><a href="<?php echo URL; ?>login">Login</a></li>
                            <li><a href="<?php echo URL; ?>signup">SignUp</a></li>
                            <li><a href="<?php echo URL; ?>companySignUp" class="company">Company Sign Up</a></li>
                        <?php endif; ?>
                    </ul>
                </div>
            </div>  


        </nav>

<script>
            $(window).scroll(function () {
                var top = $(window).scrollTop();
                if (top >= 60) {
                    $("nav").addClass('secondary');
                } else {
                    if ($("nav").hasClass('secondary')) {
                        $("nav").removeClass('secondary');
                    }
                }
            });
        </script>
        <div class='containerr'>


