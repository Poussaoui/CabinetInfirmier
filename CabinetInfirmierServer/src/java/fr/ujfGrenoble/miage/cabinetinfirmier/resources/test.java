/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ujfGrenoble.miage.cabinetinfirmier.resources;
import fr.ujf_grenoble.l3miage.medical.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author SONY
 */
public class test {
    public static void main(String args[])
    {
        String xmlFile = "F:\\CabinetInfirmierServer\\src\\java\\fr\\ujfGrenoble\\miage\\cabinetinfirmier\\resources\\cabinet.xml";
        CabinetProcessing cabinetPros = new CabinetProcessing(xmlFile);
        String name = cabinetPros.getCabineName();
        System.out.println(name);
        
        List<Patient> myList = cabinetPros.getListePatients(1);
        for(int i = 0; i < myList.size(); i++)
            System.out.println("name : " + myList.get(i).getNom());
        
        
        String xslFile = "F:\\CabinetInfirmierServer\\src\\java\\fr\\ujfGrenoble\\miage\\cabinetinfirmier\\resources\\test.xsl";
        String output = cabinetPros.getHTML("001", xslFile);
        try
        {
            BufferedWriter outHtml = new BufferedWriter(new FileWriter("F:\\CabinetInfirmierServer\\src\\java\\fr\\ujfGrenoble\\miage\\cabinetinfirmier\\resources\\cab.html"));
            outHtml.write(output);
            outHtml.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
