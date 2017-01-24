/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Pedro
 */
public class Ejercicio6SAX {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, IOException {
        // TODO code application logic here
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();//Creamos un objeto procesador de XML
        GestionContenido gestor = new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("Empleados.xml"); //Defino el fichero a leer
        procesadorXML.parse(fileXML);//Procesamos el documento XML
    }
}
    class GestionContenido extends DefaultHandler{
        public GestionContenido(){
            super();
        }
        
        public void startDocument(){
            System.out.println("Comienzo del documento XML");
        }
        
        public void endDocument(){
            System.out.println("Final del documento XML");
        }
        
        public void startElement(String uri, String nombre, String nombreC, Attributes atts){
            System.out.println("\tPrincipio elemento: " + nombre);
        }
        
        public void endElement(String uri, String nombre, String nombreC){
            System.out.println("\tFin elemento: " + nombre);
        }
        
        public void characters(char[] ch, int inicio, int longitud){
            String car=new String(ch, inicio, longitud);
            car = car.replaceAll("[\t\n]","");//quitar saltos de línea
            System.out.println("\tCaracteres: " + car);
        }
    }