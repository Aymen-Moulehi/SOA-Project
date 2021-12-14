<?php

$data = array(

    'uname'     => urlencode($_POST['uname']),
    'email'     => urlencode($_POST['email'] ),
    'message'  => urlencode($_POST['message']),
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
file_get_contents('http://localhost:8080/add/contact', false, $context);

?>