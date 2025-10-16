package com.example.metier;

public class Livre {
    private String titre;
    private int annee;
    private String genre;
    private String isbn;
    private String auteur;

    public Livre(String isbn, String titre, String auteur, int annee, String genre) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public int getAnnee() {
        return annee;
    }
    public String getGenre() {
        return genre;
    }
    public String getIsbn() {
        return isbn;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    @Override
    public String toString() {
        return "Livre est d'infos : " + "ISBN: " + isbn + ", Titre: " + titre + ", Auteur: " + auteur + ", Année: " + annee + ", Genre: " + genre;
    }
}
