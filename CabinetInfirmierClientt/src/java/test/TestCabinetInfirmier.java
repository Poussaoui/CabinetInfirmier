package test;

import java.awt.Desktop;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SONY
 */
public class TestCabinetInfirmier {

    private static String getNomCabinet() {
        fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier_Service service = new fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier_Service();
        fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier port = service.getCabinetInfirmierPort();
        return port.getNomCabinet();
    }
    
    private static String getHTML(java.lang.String infirmierId) {
        fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier_Service service = new fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier_Service();
        fr.ujfgrenoble.miage.cabinetinfirmier.CabinetInfirmier port = service.getCabinetInfirmierPort();
        return port.getHTML(infirmierId);
    }
    public static void main(String args[])
    {
        String cabineName = getNomCabinet();
        System.out.println(cabineName);
        
        try
        {
            File file = new File("F:\\CabinetInfirmierClientt\\src\\java\\test\\cabinet.html");
            FileWriter outHtml = new FileWriter(file);
            outHtml.write(getHTML("001"));
            outHtml.close();
            Thread.sleep(1000);
            Desktop.getDesktop().browse(file.toURI());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
