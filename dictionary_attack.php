<?php

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
  if (isset($_POST['password'])) {
    $password = $_POST['password'];

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
  } else {
    // Gérer le cas où le champ de mot de passe n'a pas été soumis
    $response = array('found' => false, 'password' => null);

    // Renvoie la réponse en tant que JSON
    header('Content-Type: application/json');
    echo json_encode($response);
  }
} else {
  // Gérer le cas où la méthode de requête n'est pas POST
  $response = array('found' => false, 'password' => null);

  // Renvoie la réponse en tant que JSON
  header('Content-Type: application/json');
  echo json_encode($response);
}
?>
