package com.example.service;

import com.example.metier.Livre;
import sun.rmi.transport.LiveRef;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.example.service.BibliothequeService")
public class BibliothequeServiceImpl implements BibliothequeService {
    private static final List<Livre> livres = new ArrayList<>();

    public String[] makeTrimFunc(String isbn, String titre, String auteur, String genre) {
        isbn = isbn != null ? isbn.trim() : null;
        titre = titre != null ? titre.trim() : null;
        auteur = auteur != null ? auteur.trim() : null;
        genre = genre != null ? genre.trim() : null;

        return new String[] {isbn, titre, auteur, genre}; // Return as an array
    }
    public BibliothequeServiceImpl() {
        livres.add(new Livre("978-2-07-061275-8", "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "Conte"));
        livres.add(new Livre("978-2-07-036145-8", "Vol de nuit", "Antoine de Saint-Exupéry", 1931, "Roman"));
        livres.add(new Livre("978-2-07-037240-9", "Terre des hommes", "Antoine de Saint-Exupéry", 1939, "Récit"));

        livres.add(new Livre("978-2-07-036002-4", "L'Étranger", "Albert Camus", 1942, "Roman"));
        livres.add(new Livre("978-2-07-036820-4", "La Peste", "Albert Camus", 1947, "Roman"));
        livres.add(new Livre("978-2-07-032253-4", "Le Mythe de Sisyphe", "Albert Camus", 1942, "Essai"));

        livres.add(new Livre("978-0-452-28423-4", "1984", "George Orwell", 1949, "Dystopie"));
        livres.add(new Livre("978-0-452-28425-8", "Animal Farm", "George Orwell", 1945, "Satire politique"));
        livres.add(new Livre("978-0-15-670176-1", "Homage to Catalonia", "George Orwell", 1938, "Autobiographie"));

        livres.add(new Livre("978-0-14-143951-8", "Pride and Prejudice", "Jane Austen", 1813, "Romance"));
        livres.add(new Livre("978-0-14-143982-2", "Sense and Sensibility", "Jane Austen", 1811, "Romance"));
        livres.add(new Livre("978-0-14-143980-8", "Emma", "Jane Austen", 1815, "Romance"));

        livres.add(new Livre("978-0-06-085052-4", "Brave New World", "Aldous Huxley", 1932, "Dystopie"));
        livres.add(new Livre("978-0-06-090101-1", "The Doors of Perception", "Aldous Huxley", 1954, "Essai"));
        livres.add(new Livre("978-0-06-057062-1", "Island", "Aldous Huxley", 1962, "Roman"));

        livres.add(new Livre("978-0-307-38789-9", "The Road", "Cormac McCarthy", 2006, "Post-apocalyptique"));
        livres.add(new Livre("978-0-679-73232-7", "No Country for Old Men", "Cormac McCarthy", 2005, "Thriller"));
        livres.add(new Livre("978-0-679-72837-5", "Blood Meridian", "Cormac McCarthy", 1985, "Western"));

        livres.add(new Livre("9999-01", "Solo Levling", "ZOUHAIR CHOUFA", 2003, "Just for Test"));
        livres.add(new Livre("9999-02", "Bleach", "ZOUHAIR CHOUFA", 2004, "Anime 2"));
        livres.add(new Livre("9999-03", "Hanter X Hanter", "ZOUHAIR CHOUFA", 2005, "Anime 3"));
    }

    @Override
    public String getLivreParISBN(String isbn) {
        isbn = isbn != null ? isbn.trim() : null;
        System.out.println("ISBN reçu côté serveur : " + isbn);
        // Recherche de l'ISBN dans la liste des livres
        String finalIsbn = isbn;
        String result = livres.stream()
                .filter(l -> l.getIsbn().equals(finalIsbn))
                .findFirst()
                .map(Livre::toString)
                .orElse("Livre non trouvé dans les livres...");
        System.out.println("Résultat trouvé côté serveur : " + result);
        return result;
    }

    @Override
    public String ajouterLivre(String isbn, String titre, String auteur, int annee, String genre) {
        String[] trimmedValues = makeTrimFunc(isbn, titre, auteur, genre);
        isbn = trimmedValues[0];
        titre = trimmedValues[1];
        auteur = trimmedValues[2];
        genre = trimmedValues[3];
//        System.out.println("ISBN reçu côté serveur : " + isbn);
//        System.out.println("Titre reçu côté serveur : " + titre);
//        System.out.println("Auteur reçu côté serveur : " + auteur);
//        System.out.println("Année reçue côté serveur : " + annee);
//        System.out.println("Genre reçu côté serveur : " + genre);
        try {
            String finalIsbn = isbn;
            if (livres.stream().anyMatch(l -> l != null && l.getIsbn() != null && l.getIsbn().equals(finalIsbn))) {
                return "Un livre avec cet ISBN existe déjà.";
            }
            Livre livre = new Livre(isbn, titre, auteur, annee, genre);
            livres.add(livre);
            return livre.toString();
        } catch (NullPointerException e) {
            System.err.println("Erreur de NullPointerException : " + e.getMessage());
            e.printStackTrace();
            return "Erreur interne lors de l'ajout du livre.";
        }
    }

    @Override
    public boolean supprimerLivre(String isbn) {
        isbn = isbn != null ? isbn.trim() : null;
        System.out.println("ISBN reçu côté serveur : " + isbn);
        if (livres == null) {
            System.out.println("La liste des livres est null");
            return false;
        }
        String finalIsbn = isbn;
        return livres.removeIf(livre -> livre.getIsbn().equals(finalIsbn));
    }

    @Override
    public List<String> getAllLivres() {
        List<String> livresString = new ArrayList<>();
        livres.forEach(livre -> livresString.add(livre.toString()));
        return livresString;
    }

    @Override
    public boolean mettreAJourLivre(String isbn, @WebParam(name = "nouveauTitle") String nouveauTitre, String nouvelAuteur, int nouvelleAnnee, String nouveauGenre) {
        String[] trimmedValues = makeTrimFunc(isbn, nouveauTitre, nouvelAuteur, nouveauGenre);
        isbn = trimmedValues[0];
        nouveauTitre = trimmedValues[1];
        nouvelAuteur = trimmedValues[2];
        nouveauGenre = trimmedValues[3];
//        System.out.println("ISBN reçu côté serveur : " + isbn + " " + nouveauTitre + " " + nouvelAuteur + " " + nouvelleAnnee);
        for (Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)) {
                livre.setTitre(nouveauTitre);
                livre.setAuteur(nouvelAuteur);
                livre.setAnnee(nouvelleAnnee);
                livre.setGenre(nouveauGenre);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> rechercherLivresParAuteur(String auteur) {
        auteur = auteur != null ? auteur.trim() : null;
        if (auteur == null || auteur.isEmpty()) {
            throw new IllegalArgumentException("L'auteur ne peut pas être vide");
        }
//        System.out.println("Recherche de livres pour l'auteur: " + auteur);
        List<String> livresString = new ArrayList<>();
        String auteurLowerCase = auteur.toLowerCase();
        if (auteurLowerCase.equals("all")) return getAllLivres();
        if (livres.isEmpty()) {
            livresString.add("Aucun livre disponible.");
            return livresString;
        }
        livres.forEach(livre -> {
            if (livre.getAuteur().toLowerCase().equals(auteurLowerCase)) {
                livresString.add(livre.toString());
            }
        });
        if (livresString.isEmpty()) {
            livresString.add("Aucun livre trouvé avec l'auteur " + auteur + ". Merci de réessayer avec un autre nom.");
        }
        return livresString;
    }

}
