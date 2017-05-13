<?php

########################################################
# Information de Login A l'API ZAGSMS
########################################################

$zagsms_user = "237675916748"; //Le Numero de telephone avec lequel vous avez crée votre compte sur ZAGSMS.net au format international.Exemple :23796141711
$zagsms_pwd = "testsms";//Le mot de passe correspondant à votre compte sur ZAGSMS.net
$zagsms_sender= "237675916748";//Votre Identifiant d’envoi qui peut etre numérique (17 caractères maximum) ou alphanumérique (11 caractères Maximum).
$zagsms_dest= "237";//Exempe:237 pour le Cameroun; Indicatif du Pays de destination.
$zagsms_url = "http://zagsms.net:80/lang_fr/apicmr.php?action=envoismsun&";

########################################################
# Fonction Utilisée Pour Envoyer Votre SMS
########################################################
function httpRequest($url){
    $pattern = "/http...([0-9a-zA-Z-.]*).([0-9]*).(.*)/";
    preg_match($pattern,$url,$args);
    $in = "";
    $fp = fsockopen("$args[1]", $args[2], $errno, $errstr, 30);
    if (!$fp) {
       return("$errstr ($errno)");
    } else {
        $out = "GET /$args[3] HTTP/1.1\r\n";
        $out .= "Host: $args[1]:$args[2]\r\n";
        $out .= "User-agent: zagsms PHP client\r\n";
        $out .= "Accept: */*\r\n";
        $out .= "Connection: Close\r\n\r\n";

        fwrite($fp, $out);
        while (!feof($fp)) {
           $in.=fgets($fp, 128);
        }
    }
    fclose($fp);
    return($in);
}



function zagsmsSend($phone, $msg, $debug=false){
      global $zagsms_user,$zagsms_pwd,$zagsms_url,$zagsms_sender,$zagsms_dest;

      $url = 'id='.$zagsms_user;
      $url.= '&pwd='.$zagsms_pwd;
      $url.= '&sender='.urlencode($zagsms_sender);
      $url.= '&codest='.urlencode($zagsms_dest);
      $url.= '&to='.urlencode($phone);
      $url.= '&msg='.urlencode($msg);

      $urltouse =  $zagsms_url.$url;
    

      //Open the URL to send the message
      $response = httpRequest($urltouse);
      if ($debug) {
           echo "Reponse: <br><pre>".
           str_replace(array("<",">"),array("&lt;","&gt;"),$response).
           "</pre><br>"; }

      return($response);
}

########################################################
# GET data from sendsms.html
########################################################

//$phonenum = $_POST['recipient'];//Exempe:96141711; numero de telephone mobile du destinataire sans l'inidicatif du pays de destination.
//$message = $_POST['message'];//Votre message avec 160 caractères maximum/sms.
//$debug = true;

$phonenum = $_POST['recipient'];//Exempe:96141711; numero de telephone mobile du destinataire sans l'inidicatif du pays de destination.
$message = $_POST['message'];//Votre message avec 160 caractères maximum/sms.
$debug = true;

zagsmsSend($phonenum,$message,$debug);
?>
