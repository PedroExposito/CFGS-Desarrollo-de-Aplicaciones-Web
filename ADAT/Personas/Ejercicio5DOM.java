/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

/**
 *
 * @author Pedro
 */
public class Ejercicio5DOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, TransformerConfigurationException, TransformerException {
        // TODO code application logic here
        Persona persona;
        FileInputStream fis = new FileInputStream(new File("/Users/Pedro/Documents/personas.dat"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
    try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Persona", null);
        document.setXmlVersion("1.0"); //asignamos la versión de nuestro XML
        
        while(fis.available()>0){
            persona = (Persona) ois.readObject();
            Element raiz = document.createElement("Persona"); //Creamos el nodo Persona
            document.getDocumentElement().appendChild(raiz); //Lo pegamos a la raiz del doc
            CrearElemento("nombre",persona.getNombre().trim(), raiz, document);
            CrearElemento("edad",String.valueOf(persona.getEdad()), raiz, document);
            //persona = (Persona) dataIS.readObject();
            
            
        }
        
        Source source = new DOMSource((Node)document);
        Result result = new StreamResult(new java.io.File("/Users/Pedro/NetBeansProjects/Personas.xml"));
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    }
    catch(ParserConfigurationException e){ 
    }  
    ois.close();
    fis.close();
    }
    
    static void CrearElemento (String datoPersona, String valor, Element raiz, Document document){
        Element elem = document.createElement(datoPersona);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }
}

