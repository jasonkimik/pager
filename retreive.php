<?php
$userID = htmlspecialchars($_GET["userNumber"]);
$myFile = '/var/www/data/'. $userID . ".csv";
if (file_exists($myFile))
{
     $fh = fopen($myFile, 'r');
     echo nl2br(file_get_contents($myFile));
     fclose($fh);
#unlink($myfile);
     exec('rm '.$myFile);
}
else
{
        echo 'NOMSG';
}

?>
