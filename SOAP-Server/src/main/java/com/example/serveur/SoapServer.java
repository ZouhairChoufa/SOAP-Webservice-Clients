package com.example.serveur;

import com.example.service.BibliothequeServiceImpl;
import javax.xml.ws.Endpoint;

public class SoapServer {
    public static void main(String[] args) {
        String url = "http://localhost:1510/ws/Bibliotheque";
        System.out.println("Démarrage du serveur SOAP à " + url);
        Endpoint.publish(url, new BibliothequeServiceImpl());
        System.out.println("Service SOAP disponible à : " + url + "?wsdl");
        System.out.println("Serveur SOAP en cours d'exécution...");
    }
}
