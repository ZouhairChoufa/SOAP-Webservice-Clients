
package com.example.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AjouterLivre_QNAME = new QName("http://service.example.com/", "ajouterLivre");
    private final static QName _AjouterLivreResponse_QNAME = new QName("http://service.example.com/", "ajouterLivreResponse");
    private final static QName _GetAllLivres_QNAME = new QName("http://service.example.com/", "getAllLivres");
    private final static QName _GetAllLivresResponse_QNAME = new QName("http://service.example.com/", "getAllLivresResponse");
    private final static QName _GetLivreParISBN_QNAME = new QName("http://service.example.com/", "getLivreParISBN");
    private final static QName _GetLivreParISBNResponse_QNAME = new QName("http://service.example.com/", "getLivreParISBNResponse");
    private final static QName _MettreAJourLivre_QNAME = new QName("http://service.example.com/", "mettreAJourLivre");
    private final static QName _MettreAJourLivreResponse_QNAME = new QName("http://service.example.com/", "mettreAJourLivreResponse");
    private final static QName _RechercherLivresParAuteur_QNAME = new QName("http://service.example.com/", "rechercherLivresParAuteur");
    private final static QName _RechercherLivresParAuteurResponse_QNAME = new QName("http://service.example.com/", "rechercherLivresParAuteurResponse");
    private final static QName _SupprimerLivre_QNAME = new QName("http://service.example.com/", "supprimerLivre");
    private final static QName _SupprimerLivreResponse_QNAME = new QName("http://service.example.com/", "supprimerLivreResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AjouterLivre }
     * 
     */
    public AjouterLivre createAjouterLivre() {
        return new AjouterLivre();
    }

    /**
     * Create an instance of {@link AjouterLivreResponse }
     * 
     */
    public AjouterLivreResponse createAjouterLivreResponse() {
        return new AjouterLivreResponse();
    }

    /**
     * Create an instance of {@link GetAllLivres }
     * 
     */
    public GetAllLivres createGetAllLivres() {
        return new GetAllLivres();
    }

    /**
     * Create an instance of {@link GetAllLivresResponse }
     * 
     */
    public GetAllLivresResponse createGetAllLivresResponse() {
        return new GetAllLivresResponse();
    }

    /**
     * Create an instance of {@link GetLivreParISBN }
     * 
     */
    public GetLivreParISBN createGetLivreParISBN() {
        return new GetLivreParISBN();
    }

    /**
     * Create an instance of {@link GetLivreParISBNResponse }
     * 
     */
    public GetLivreParISBNResponse createGetLivreParISBNResponse() {
        return new GetLivreParISBNResponse();
    }

    /**
     * Create an instance of {@link MettreAJourLivre }
     * 
     */
    public MettreAJourLivre createMettreAJourLivre() {
        return new MettreAJourLivre();
    }

    /**
     * Create an instance of {@link MettreAJourLivreResponse }
     * 
     */
    public MettreAJourLivreResponse createMettreAJourLivreResponse() {
        return new MettreAJourLivreResponse();
    }

    /**
     * Create an instance of {@link RechercherLivresParAuteur }
     * 
     */
    public RechercherLivresParAuteur createRechercherLivresParAuteur() {
        return new RechercherLivresParAuteur();
    }

    /**
     * Create an instance of {@link RechercherLivresParAuteurResponse }
     * 
     */
    public RechercherLivresParAuteurResponse createRechercherLivresParAuteurResponse() {
        return new RechercherLivresParAuteurResponse();
    }

    /**
     * Create an instance of {@link SupprimerLivre }
     * 
     */
    public SupprimerLivre createSupprimerLivre() {
        return new SupprimerLivre();
    }

    /**
     * Create an instance of {@link SupprimerLivreResponse }
     * 
     */
    public SupprimerLivreResponse createSupprimerLivreResponse() {
        return new SupprimerLivreResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterLivre }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AjouterLivre }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "ajouterLivre")
    public JAXBElement<AjouterLivre> createAjouterLivre(AjouterLivre value) {
        return new JAXBElement<AjouterLivre>(_AjouterLivre_QNAME, AjouterLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AjouterLivreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AjouterLivreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "ajouterLivreResponse")
    public JAXBElement<AjouterLivreResponse> createAjouterLivreResponse(AjouterLivreResponse value) {
        return new JAXBElement<AjouterLivreResponse>(_AjouterLivreResponse_QNAME, AjouterLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLivres }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllLivres }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "getAllLivres")
    public JAXBElement<GetAllLivres> createGetAllLivres(GetAllLivres value) {
        return new JAXBElement<GetAllLivres>(_GetAllLivres_QNAME, GetAllLivres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllLivresResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllLivresResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "getAllLivresResponse")
    public JAXBElement<GetAllLivresResponse> createGetAllLivresResponse(GetAllLivresResponse value) {
        return new JAXBElement<GetAllLivresResponse>(_GetAllLivresResponse_QNAME, GetAllLivresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivreParISBN }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetLivreParISBN }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "getLivreParISBN")
    public JAXBElement<GetLivreParISBN> createGetLivreParISBN(GetLivreParISBN value) {
        return new JAXBElement<GetLivreParISBN>(_GetLivreParISBN_QNAME, GetLivreParISBN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLivreParISBNResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetLivreParISBNResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "getLivreParISBNResponse")
    public JAXBElement<GetLivreParISBNResponse> createGetLivreParISBNResponse(GetLivreParISBNResponse value) {
        return new JAXBElement<GetLivreParISBNResponse>(_GetLivreParISBNResponse_QNAME, GetLivreParISBNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MettreAJourLivre }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MettreAJourLivre }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "mettreAJourLivre")
    public JAXBElement<MettreAJourLivre> createMettreAJourLivre(MettreAJourLivre value) {
        return new JAXBElement<MettreAJourLivre>(_MettreAJourLivre_QNAME, MettreAJourLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MettreAJourLivreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MettreAJourLivreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "mettreAJourLivreResponse")
    public JAXBElement<MettreAJourLivreResponse> createMettreAJourLivreResponse(MettreAJourLivreResponse value) {
        return new JAXBElement<MettreAJourLivreResponse>(_MettreAJourLivreResponse_QNAME, MettreAJourLivreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherLivresParAuteur }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RechercherLivresParAuteur }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "rechercherLivresParAuteur")
    public JAXBElement<RechercherLivresParAuteur> createRechercherLivresParAuteur(RechercherLivresParAuteur value) {
        return new JAXBElement<RechercherLivresParAuteur>(_RechercherLivresParAuteur_QNAME, RechercherLivresParAuteur.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherLivresParAuteurResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RechercherLivresParAuteurResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "rechercherLivresParAuteurResponse")
    public JAXBElement<RechercherLivresParAuteurResponse> createRechercherLivresParAuteurResponse(RechercherLivresParAuteurResponse value) {
        return new JAXBElement<RechercherLivresParAuteurResponse>(_RechercherLivresParAuteurResponse_QNAME, RechercherLivresParAuteurResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerLivre }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SupprimerLivre }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "supprimerLivre")
    public JAXBElement<SupprimerLivre> createSupprimerLivre(SupprimerLivre value) {
        return new JAXBElement<SupprimerLivre>(_SupprimerLivre_QNAME, SupprimerLivre.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupprimerLivreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SupprimerLivreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "supprimerLivreResponse")
    public JAXBElement<SupprimerLivreResponse> createSupprimerLivreResponse(SupprimerLivreResponse value) {
        return new JAXBElement<SupprimerLivreResponse>(_SupprimerLivreResponse_QNAME, SupprimerLivreResponse.class, null, value);
    }

}
