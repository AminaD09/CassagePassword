<?php
// Récupère le mot de passe soumis depuis la requête
$password = $_POST['password'];
if (empty($password)) {
  $response = array('found' => false, 'password' => null);
} elseif (in_array($password, $dictionaryPasswords)) {
  $response = array('found' => true, 'password' => $password);
} else {
  $response = array('found' => false, 'password' => null);
}

// Charge le dictionnaire depuis un fichier texte
$dictionaryPasswords = file('dictionnary.txt', FILE_IGNORE_NEW_LINES);

// Vérifie si le mot de passe se trouve dans le dictionnaire
if (in_array($password, $dictionaryPasswords)) {
  $response = array('found' => true, 'password' => $password);
} else {
  $response = array('found' => false, 'password' => null);
}

// Renvoie la réponse en tant que JSON
header('Content-Type: application/json');
echo json_encode($response);
?>
