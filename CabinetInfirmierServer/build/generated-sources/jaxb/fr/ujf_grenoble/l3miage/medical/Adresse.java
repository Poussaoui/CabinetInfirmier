//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2017.12.03 � 12:53:18 AM CET 
//


package fr.ujf_grenoble.l3miage.medical;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Adresse complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Adresse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="�tage" type="{http://www.ujf-grenoble.fr/l3miage/medical}Etage" minOccurs="0"/>
 *         &lt;element name="num�ro" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="rue" type="{http://www.ujf-grenoble.fr/l3miage/medical}Rue"/>
 *         &lt;element name="ville" type="{http://www.ujf-grenoble.fr/l3miage/medical}Ville"/>
 *         &lt;element name="codePostal" type="{http://www.ujf-grenoble.fr/l3miage/medical}codePostal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adresse", propOrder = {
    "\u00e9tage",
    "num\u00e9ro",
    "rue",
    "ville",
    "codePostal"
})
public class Adresse {

    protected String étage;
    protected Integer numéro;
    @XmlElement(required = true)
    protected String rue;
    @XmlElement(required = true)
    protected String ville;
    @XmlElement(required = true)
    protected String codePostal;

    /**
     * Obtient la valeur de la propri�t� �tage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getétage() {
        return étage;
    }

    /**
     * D�finit la valeur de la propri�t� �tage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setétage(String value) {
        this.étage = value;
    }

    /**
     * Obtient la valeur de la propri�t� num�ro.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNuméro() {
        return numéro;
    }

    /**
     * D�finit la valeur de la propri�t� num�ro.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNuméro(Integer value) {
        this.numéro = value;
    }

    /**
     * Obtient la valeur de la propri�t� rue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRue() {
        return rue;
    }

    /**
     * D�finit la valeur de la propri�t� rue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRue(String value) {
        this.rue = value;
    }

    /**
     * Obtient la valeur de la propri�t� ville.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * D�finit la valeur de la propri�t� ville.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
    }

    /**
     * Obtient la valeur de la propri�t� codePostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * D�finit la valeur de la propri�t� codePostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostal(String value) {
        this.codePostal = value;
    }

}
