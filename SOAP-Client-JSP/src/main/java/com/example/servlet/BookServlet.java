package com.example.servlet;

import com.example.client.BibliothequeService;
import com.example.client.BibliothequeServiceImplService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BibliothequeService bibliothequeService;

    @Override
    public void init() throws ServletException {
        BibliothequeServiceImplService service = new BibliothequeServiceImplService();
        bibliothequeService = service.getBibliothequeServiceImplPort();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("error", "Action invalide !");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        switch (action) {
            case "search":
                rechercherLivre(request, response);
                break;
            case "add":
                ajouterLivre(request, response);
                break;
            case "delete":
                supprimerLivre(request, response);
                break;
            case "update":
                mettreAJourLivre(request, response);
                break;
            case "allBooks":
                listerLivres(request, response);
                break;
            case "searchAuthor":
                rechercherLivresParAuteur(request, response);
                break;
            default:
                request.setAttribute("error", "Action inconnue !");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private void rechercherLivre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        if (isbn != null) isbn = isbn.trim();

        if (isbn == null || isbn.isEmpty()) {
            request.setAttribute("error", "ISBN ne peut pas être vide.");
        } else {
            String livre = bibliothequeService.getLivreParISBN(isbn);
            if (livre != null) livre = livre.trim();
            request.setAttribute("livre", livre);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void ajouterLivre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titre = request.getParameter("title");
        String auteur = request.getParameter("author");
        String anneeStr = request.getParameter("year");
        String genre = request.getParameter("genre");

        if (isbn != null) isbn = isbn.trim();
        if (titre != null) titre = titre.trim();
        if (auteur != null) auteur = auteur.trim();
        if (anneeStr != null) anneeStr = anneeStr.trim();
        if (genre != null) genre = genre.trim();

        if (isbn.isEmpty() || titre.isEmpty() || auteur.isEmpty() || anneeStr.isEmpty() || genre.isEmpty()) {
            request.setAttribute("error", "Tous les champs sont obligatoires !");
        } else {
            try {
                int annee = Integer.parseInt(anneeStr);
                String result = bibliothequeService.ajouterLivre(isbn, titre, auteur, annee, genre);
                if (result != null) result = result.trim();
                request.setAttribute("message", result);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "L'année doit être un nombre valide.");
            }
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void supprimerLivre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        if (isbn != null) isbn = isbn.trim();

        if (isbn == null || isbn.isEmpty()) {
            request.setAttribute("error", "ISBN requis pour supprimer un livre.");
        } else {
            boolean success = bibliothequeService.supprimerLivre(isbn);
            if (success) {
                request.setAttribute("message", "Livre supprimé avec succès.");
            } else {
                request.setAttribute("error", "Livre non trouvé.");
            }
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void mettreAJourLivre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titre = request.getParameter("newTitle");
        String auteur = request.getParameter("newAuthor");
        String anneeStr = request.getParameter("newYear");
        String genre = request.getParameter("newGenre");

        if (isbn != null) isbn = isbn.trim();
        if (titre != null) titre = titre.trim();
        if (auteur != null) auteur = auteur.trim();
        if (anneeStr != null) anneeStr = anneeStr.trim();
        if (genre != null) genre = genre.trim();

        if (isbn.isEmpty() || titre.isEmpty() || auteur.isEmpty() || anneeStr.isEmpty() || genre.isEmpty()) {
            request.setAttribute("error", "Tous les champs sont obligatoires !");
        } else {
            try {
                int annee = Integer.parseInt(anneeStr);
                boolean success = bibliothequeService.mettreAJourLivre(isbn, titre, auteur, annee, genre);
                if (success) {
                    request.setAttribute("message", "Livre mis à jour avec succès.");
                } else {
                    request.setAttribute("error", "Livre non trouvé.");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "L'année doit être un nombre valide.");
            }
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void listerLivres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> livres = bibliothequeService.getAllLivres();
        if (livres != null) {
            livres = livres.stream().map(l -> l != null ? l.trim() : null).collect(Collectors.toList());
        }
        request.setAttribute("livres", livres);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void rechercherLivresParAuteur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String auteur = request.getParameter("auteur");
        if (auteur != null) auteur = auteur.trim();

        if (auteur == null || auteur.isEmpty()) {
            request.setAttribute("error", "Le nom de l'auteur est requis.");
        } else {
            List<String> livres = bibliothequeService.rechercherLivresParAuteur(auteur);
            if (livres != null) {
                livres = livres.stream().map(l -> l != null ? l.trim() : null).collect(Collectors.toList());
            }
            request.setAttribute("booksByAuthor", livres);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
