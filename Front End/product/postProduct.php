<?php

$data = array(

    'imglink'     => urlencode($_POST['imglink']),
    'pname'     => urlencode($_POST['pname'] ),
    'price'  => urlencode($_POST['price']),
    'category'    => urlencode($_POST['category']),
    'descreption' => urlencode($_POST['descreption'])

);

/* Creation des options de contexte */
$options = array(
    'http' => array(
        'method'  => 'POST',
        'header'  => "Content-Type: application/json",
        'ignore_errors' => true,
        'timeout' =>  10,
        'content' => json_encode($data),
    ),
);

/* Creation du contexte HTTP */
$context  = stream_context_create($options);

/* Execution de la requete */
file_get_contents('http://localhost:8080/add/product', false, $context);

?>