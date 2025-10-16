<?php
// Inclure le client SOAP PHP
include('BibliothequeClient.php');

// Créer une instance du client SOAP
$wsdl = "http://localhost:1510/ws/Bibliotheque?wsdl"; // Remplacer par l'URL de ton service WSDL
$client = new BibliothequeClient($wsdl);

// Initialiser les messages et résultats
$message = '';
$resultat = '';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Traiter les actions en fonction de l'action du formulaire
    $action = $_POST['action'];

    switch ($action) {
        case 'search':
            $isbn = $_POST['isbn'];
            $resultat = $client->getLivreParISBN($isbn);
            break;
        case 'add':
            $isbn = $_POST['isbn'];
            $titre = $_POST['title'];
            $auteur = $_POST['author'];
            $annee = $_POST['year'];
            $genre = $_POST['genre'];
            $resultat = $client->ajouterLivre($isbn, $titre, $auteur, $annee, $genre);
            break;
        case 'delete':
            $isbn = $_POST['isbn'];
            $resultat = $client->supprimerLivre($isbn);
            break;
        case 'update':
            $isbn = $_POST['isbn'];
            $titre = $_POST['nouveauTitle'];
            $auteur = $_POST['nouvelAuthor'];
            $annee = $_POST['nouvelleYear'];
            $genre = $_POST['nouveauGenre'];
            $resultat = $client->mettreAJourLivre($isbn, $titre, $auteur, $annee, $genre);
            break;
        case 'allBooks':
            $resultat = $client->getAllLivres();
            break;
        case 'searchAuthor':
            $auteur = $_POST['author'];
            $resultat = $client->rechercherLivresParAuteur($auteur);
            break;
        default:
            $message = "Action inconnue.";
            break;
    }
}
?>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Interface Bibliothèque SOAP</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h1>Gestion de la Bibliothèque</h1>

    <!-- Message d'erreur ou de succès -->
    <?php if ($message): ?>
        <div class="message error"><?= $message ?></div>
    <?php elseif ($resultat): ?>
        <div class="message success">
            <?php
            // Vérifier si le résultat est un objet stdClass
            if (is_object($resultat)) {
                // Si l'objet contient une propriété "return"
                if (isset($resultat->return)) {
                    // Si "return" est un tableau, afficher chaque livre
                    if (is_array($resultat->return)) {
                        echo '<ul>';
                        foreach ($resultat->return as $book) {
                            echo '<li>' . htmlspecialchars($book) . '</li>';
                        }
                        echo '</ul>';
                    } else {
                        // Si ce n'est pas un tableau, afficher le message de retour
                        echo $resultat->return;
                    }
                } else {
                    // Si l'objet ne contient pas "return", afficher le résultat
                    echo '<pre>';
                    var_dump($resultat);
                    echo '</pre>';
                }
            } elseif (is_array($resultat)) {
                // Si c'est un tableau de livres, afficher chaque livre
                echo '<ul>';
                foreach ($resultat as $book) {
                    echo '<li>' . htmlspecialchars($book) . '</li>';
                }
                echo '</ul>';
            } else {
                // Si c'est une chaîne de caractères ou autre, afficher le résultat
                echo $resultat;
            }
            ?>
        </div>
    <?php endif; ?>

    <!-- Formulaire pour rechercher un livre -->
    <h2>Rechercher un livre par ISBN</h2>
    <form method="POST">
        <input type="hidden" name="action" value="search">
        <label for="isbn">ISBN :</label>
        <input type="text" id="isbn" name="isbn" required>
        <button type="submit">Rechercher</button>
    </form>

    <!-- Formulaire pour ajouter un livre -->
    <h2>Ajouter un livre</h2>
    <form method="POST">
        <input type="hidden" name="action" value="add">
        <label for="isbn">ISBN :</label>
        <input type="text" id="isbn" name="isbn" required>
        <label for="title">Titre :</label>
        <input type="text" id="title" name="title" required>
        <label for="author">Auteur :</label>
        <input type="text" id="author" name="author" required>
        <label for="year">Année :</label>
        <input type="number" id="year" name="year" required>
        <label for="genre">Genre :</label>
        <input type="text" id="genre" name="genre" required>
        <button type="submit">Ajouter</button>
    </form>

    <!-- Formulaire pour supprimer un livre -->
    <h2>Supprimer un livre</h2>
    <form method="POST">
        <input type="hidden" name="action" value="delete">
        <label for="isbn">ISBN :</label>
        <input type="text" id="isbn" name="isbn" required>
        <button type="submit">Supprimer</button>
    </form>

    <!-- Formulaire pour mettre à jour un livre -->
    <h2>Mettre à jour un livre</h2>
    <form method="POST">
        <input type="hidden" name="action" value="update">
        <label for="isbn">ISBN :</label>
        <input type="text" id="isbn" name="isbn" required>
        <label for="nouveauTitle">Nouveau Titre :</label>
        <input type="text" id="nouveauTitle" name="nouveauTitle" required>
        <label for="nouvelAuthor">Nouvel Auteur :</label>
        <input type="text" id="nouvelAuthor" name="nouvelAuthor" required>
        <label for="nouvelleYear">Nouvelle Année :</label>
        <input type="number" id="nouvelleYear" name="nouvelleYear" required>
        <label for="nouveauGenre">Nouveau Genre :</label>
        <input type="text" id="nouveauGenre" name="nouveauGenre" required>
        <button type="submit">Mettre à jour</button>
    </form>

    <!-- Formulaire pour lister tous les livres -->
    <h2>Lister tous les livres</h2>
    <form method="POST">
        <input type="hidden" name="action" value="allBooks">
        <button type="submit">Lister les livres</button>
    </form>

    <!-- Formulaire pour rechercher des livres par auteur -->
    <h2>Rechercher des livres par auteur</h2>
    <form method="POST">
        <input type="hidden" name="action" value="searchAuthor">
        <label for="author">Auteur :</label>
        <input type="text" id="author" name="author" required>
        <button type="submit">Rechercher</button>
    </form>
</div>

</body>
</html>
