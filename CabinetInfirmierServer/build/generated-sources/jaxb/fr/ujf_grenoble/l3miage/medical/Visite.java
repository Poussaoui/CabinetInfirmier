//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.12.03 à 12:53:18 AM CET 
//


package fr.ujf_grenoble.l3miage.medical;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour Visite complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Visite">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acte" type="{http://www.ujf-grenoble.fr/l3miage/medical}Acte" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="date" type="{http://www.ujf-grenoble.fr/l3miage/medical}Date" />
 *       &lt;attribute name="intervenant" type="{http://www.ujf-grenoble.fr/l3miage/medical}Identifiant" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Visite", propOrder = {
    "acte"
})
public class Visite {

    protected Acte acte;
    @XmlAttribute(name = "date")
    protected XMLGregorianCalendar date;
    @XmlAttribute(name = "intervenant")
    protected String intervenant;

    /**
     * Obtient la valeur de la propriété acte.
     * 
     * @return
     *     possible object is
     *     {@link Acte }
     *     
     */
    public Acte getActe() {
        return acte;
    }

    /**
     * Définit la valeur de la propriété acte.
     * 
     * @param value
     *     allowed object is
     *     {@link Acte }
     *     
     */
    public void setActe(Acte value) {
        this.acte = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété intervenant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntervenant() {
        return intervenant;
    }

    /**
     * Définit la valeur de la propriété intervenant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntervenant(String value) {
        this.intervenant = value;
    }

}
