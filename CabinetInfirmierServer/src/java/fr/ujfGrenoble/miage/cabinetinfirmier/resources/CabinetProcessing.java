/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ujfGrenoble.miage.cabinetinfirmier.resources;
import fr.ujf_grenoble.l3miage.medical.Cabinet;
import fr.ujf_grenoble.l3miage.medical.Patient;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.transform.*;
/**
 *
 * @author SONY
 */
public class CabinetProcessing {
    private Cabinet cabinet;
    public CabinetProcessing(Cabinet cabinet){
        this.cabinet = cabinet;
   }
    public CabinetProcessing(String fileName)
    {
        try
        {
            cabinet = fromXML(fileName);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
      // unmarshalling du Cabinet à partir d'un fichier XML
    Cabinet fromXML(String nomFichier) throws Exception {
        try {
            // création du contexte
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Cabinet.class.getPackage().getName());
            // création d'un unmarshaller 
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            // unmarshalling... (utilisation d'un transtypage)
            return (Cabinet) unmarshaller.unmarshal(new java.io.File(nomFichier)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N  
        }
        return null;
    }

      // Marshalling de l'instance vers un fichier
    void toXML(String nomFichier) {
        try {
            // Fabrication d'un contexte pour notre classe.
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(Cabinet.class.getClass().getPackage().getName());

            // création d'un marshaller pour notre package
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();

            // quelques paramètres pour le support du bon encoding et pour l'affichage simplifié pour les humains
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Les 4 lignes ci-dessous sont optionnelles
            // On y indique quel est le schema utilisé : cela permet de créer une instance XML
            // directement validable (contenant l'attribut xsi:instance)            
            SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("src/java/fr/ujfGrenoble/miage/cabinetinfirmier/resources/cabinet.xsd"));
            marshaller.setSchema(schema);
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_SCHEMA_LOCATION, "http://www.ujf-grenoble.fr/l3miage/medical ./cabinet.xsd");

            // et c'est parti pour l'opération de marshalling (cf cours pour la définition)
            marshaller.marshal(Cabinet.class, new FileOutputStream(nomFichier));

        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Probleme d'ouverture fichier " + nomFichier + " en ecriture !");
        } catch (SAXException ex) {
            Logger.getLogger(CabinetProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getCabineName()
    {
        return cabinet.getNom();
    }
    public String getHTML(String infirmierId, String xslFileName) {
        try {
            // Traitements éventuels sur le cabinet
            /*
            * ici sont réalisés les traitements souhaités pour récupérer les informations utiles
            * ex: classement des patients par ordre alphabétique
            * ex: classement de la liste des patients d'une infirmière selon la distance
            */
            // On fabrique un document DOM à partir d'un objet, ici un cabinet
            Document doc = XMLUtil.DocumentFactory.fromObject(cabinet);
            // on charge la feuille de transformation
            StreamSource xslStreamSource = new StreamSource(xslFileName);
            // Crée un transformateur de Documents DOM à partir d'une fabrique de transformateurs
            // le transformateur est créé à partir d'une source provenant de la feuille de transformation XSL, 
            // donc il transformera le Document selon cette feuille XSL
            Transformer tf = TransformerFactory.newInstance().newTransformer(xslStreamSource);                        
            // On donne un nom au paramètre ; ce nom est celui utilisé dans la feuille de transformation
            String id = "IDinf";
            // On indique au processeur de document d'appliquer un paramètre auquel on donne sa valeur.
            tf.setParameter(id, infirmierId);
            // On applique la transformation
            return XMLUtil.DocumentTransform.fromTransformation(tf, doc);
        } catch (Exception ex) {
            Logger.getLogger(CabinetProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   
    
    public List<Patient> getListePatients(int id)
    {
        String idInf = "00" + id;
        List<Patient> listPatient = cabinet.getPatients().getPatients();
        List<Patient> newListPatients = new ArrayList<>();
        for(int i = 0; i < listPatient.size(); i++)
        {
            if(listPatient.get(i).getVisites().get(0).getIntervenant().equals(idInf))
                newListPatients.add(listPatient.get(i));
        }
        return newListPatients;
    }
}
