package com.example.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface BibliothequeService {

    @WebMethod
    String getLivreParISBN(@WebParam(name = "isbn") String isbn);

    @WebMethod
    String ajouterLivre(
            @WebParam(name = "isbn") String isbn,
            @WebParam(name = "title") String titre,
            @WebParam(name = "author") String auteur,
            @WebParam(name = "year") int annee,
            @WebParam(name = "genre") String genre
    );

    @WebMethod
    boolean supprimerLivre(@WebParam(name = "isbn") String isbn);

    @WebMethod
    List<String> getAllLivres();

    @WebMethod
    boolean mettreAJourLivre(
            @WebParam(name = "isbn") String isbn,
            @WebParam(name = "nouveauTitle") String nouveauTitre,
            @WebParam(name = "nouvelAuthor") String nouvelAuteur,
            @WebParam(name = "nouvelleYear") int nouvelleAnnee,
            @WebParam(name = "nouveauGenre") String nouveauGenre
    );

    @WebMethod
    List<String> rechercherLivresParAuteur(@WebParam(name = "author") String auteur);
}
