<?php
 
/** An example of cron task */
$f = file_get_contents("http://localhost/sifras/index.php?contr=indexs&action=crontask&r=".rand(),"r");
print $f;
