<?php

class BibliothequeClient {
    private $client;

    // Constructeur pour initialiser le client SOAP
    public function __construct($wsdl) {
        try {
            $this->client = new SoapClient($wsdl);
        } catch (Exception $e) {
            die('Erreur de connexion au service SOAP : ' . $e->getMessage());
        }
    }

    // Recherche un livre par ISBN
    public function getLivreParISBN($isbn) {
        try {
            // Convertir l'ISBN en chaîne de caractères
            $isbn = strval($isbn); // Utiliser directement le paramètre passé dans la fonction
            $response = $this->client->__soapCall('getLivreParISBN', [['isbn' => $isbn]]);
            return $response;
        } catch (Exception $e) {
            return 'Erreur lors de la recherche du livre : ' . $e->getMessage();
        }
    }

    // Ajouter un nouveau livre
    public function ajouterLivre($isbn, $titre, $auteur, $annee, $genre) {
        try {
            // Assurez-vous que les variables sont bien formatées
            $isbn = strval($isbn); // Assurez-vous que c'est une chaîne
            $annee = strval($annee); // Assurez-vous que l'année est convertie correctement en chaîne

            // Effectuer la requête SOAP
            $response = $this->client->__soapCall('ajouterLivre', [
                [
                    'isbn' => $isbn,
                    'title' => $titre,
                    'author' => $auteur,
                    'year' => $annee,
                    'genre' => $genre
                ]
            ]);
            return $response;
        } catch (Exception $e) {
            return 'Erreur lors de l\'ajout du livre : ' . $e->getMessage();
        }
    }


    // Supprimer un livre par ISBN
    public function supprimerLivre($isbn) {
        try {
            $isbn = strval($isbn);
            $response = $this->client->__soapCall('supprimerLivre', [['isbn' => $isbn]]);
            return $response ? 'Livre supprimé avec succès.' : 'Livre non trouvé.';
        } catch (Exception $e) {
            return 'Erreur lors de la suppression du livre : ' . $e->getMessage();
        }
    }

    // Mettre à jour les informations d'un livre
    public function mettreAJourLivre($isbn, $titre, $auteur, $annee, $genre) {
        try {
            $isbn = strval($isbn);
            $annee = strval($annee);
            $response = $this->client->__soapCall('mettreAJourLivre', [
                [
                    'isbn' => $isbn,
                    'nouveauTitle' => $titre,
                    'nouvelAuthor' => $auteur,
                    'nouvelleYear' => $annee,
                    'nouveauGenre' => $genre
                ]
            ]);
            return $response ? 'Livre mis à jour avec succès.' : 'Livre non trouvé.';
        } catch (Exception $e) {
            return 'Erreur lors de la mise à jour du livre : ' . $e->getMessage();
        }
    }

    // Lister tous les livres
    public function getAllLivres() {
        try {
            $response = $this->client->__soapCall('getAllLivres', []);
            return $response;
        } catch (Exception $e) {
            return 'Erreur lors de la récupération de la liste des livres : ' . $e->getMessage();
        }
    }

    // Rechercher des livres par auteur
    public function rechercherLivresParAuteur($auteur) {
        if (empty($auteur)) {
            return 'L\'auteur ne peut pas être vide.';
        }
        try {
            $response = $this->client->__soapCall('rechercherLivresParAuteur', [['author' => $auteur]]);
            return $response;
        } catch (Exception $e) {
            return 'Erreur lors de la recherche des livres par auteur : ' . $e->getMessage();
        }
    }
}
?>
