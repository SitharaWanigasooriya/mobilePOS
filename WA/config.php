<?php

// Always provide a TRAILING SLASH (/) AFTER A PATH
define ('URL','http://localhost/WA/');// if the port is different change the port from here

define('LIBS', 'libs/');

define('DB_TYPE','mysql');
define('DB_HOST','localhost');
define('DB_NAME','project');
define('DB_USER','root');
define('DB_PASS','');

// The sitewide hashkey, do not change this because its used for passwords!
define('HASH_GENERAL_KEY','GeneralKeyUsingForHashingFunction');
define('HASH_PASSWORD_KEY', 'PasswordKeyForhashingFunction');