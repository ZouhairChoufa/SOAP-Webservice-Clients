package com.example.client;

import java.util.List;

public class ClientBibliotheque {
    public static void main(String[] args) {
        // 1 Connexion au service SOAP
        BibliothequeServiceImplService serviceFactory = new BibliothequeServiceImplService();
        BibliothequeService service = serviceFactory.getBibliothequeServiceImplPort();

        // 2 Récupérer tous les livres
        System.out.println("\n📖 Liste des livres disponibles :");
        List<String> livres = service.getAllLivres();
        for (String livre : livres) {
            System.out.println("📘 " + livre);
        }

        // 3 Ajouter un nouveau livre
        System.out.println("\n📚 Ajout d'un nouveau livre...");
        String ajoutResponse = service.ajouterLivre("978-1-56619-909-4", "Java for Beginners", "John Doe", 2023, "Programmation");
        System.out.println("✅ Réponse : " + ajoutResponse);

        // 4 Rechercher un livre par ISBN
        System.out.println("\n🔍 Recherche d'un livre par ISBN...");
        String livreInfo1 = service.getLivreParISBN("978-1-56619-909-4");
        System.out.println("📄 " + livreInfo1);

        // 5 Mettre à jour un livre
        System.out.println("\n✏️ Mise à jour du livre...");
        boolean updateStatus = service.mettreAJourLivre("978-1-56619-909-4", "Java Avancé", "John Doe", 2024, "Programmation avancée");
        System.out.println(updateStatus ? "✅ Livre mis à jour." : "❌ Échec de la mise à jour.");

        // 6 Rechercher un livre par ISBN
        System.out.println("\n🔍 Recherche d'un livre par ISBN...");
        String livreInfo2 = service.getLivreParISBN("978-1-56619-909-4");
        System.out.println("📄 " + livreInfo2);

        // 7 Supprimer un livre
        System.out.println("\n🗑️ Suppression d'un livre...");
        boolean suppressionStatus = service.supprimerLivre("978-1-56619-909-4");
        System.out.println(suppressionStatus ? "✅ Livre supprimé." : "❌ Échec de la suppression.");

        // 8 Rechercher un livre par ISBN
        System.out.println("\n🔍 Recherche d'un livre par ISBN...");
        String livreInfo3 = service.getLivreParISBN("978-1-56619-909-4");
        System.out.println("📄 " + livreInfo3);
    }
}
