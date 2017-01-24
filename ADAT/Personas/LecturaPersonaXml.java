/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
/**
 *
 * @author Pedro
 */
public class LecturaPersonaXml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // TODO code application logic here
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("/Users/Pedro/NetBeansProjects/Personas.xml"));
            document.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            //crea una lista con todos los nodos persona
            NodeList personas = document.getElementsByTagName("Persona");
            //recorrer la lista
            for(int i = 0; i < personas.getLength(); i++){
                Node perso = personas.item(i); //Obtener un nodo
                if (perso.getNodeType() == Node.ELEMENT_NODE){ //tipo de nodo
                    Element elemento = (Element) perso; //obtener todos los elementos del nodo
                    System.out.println("Nombre: "+ getNodo("nombre", elemento));
                    System.out.println("Edad:" + getNodo("edad", elemento));
                }
            }
        }catch (Exception e) {e.printStackTrace();}
        
    }
    
    //Obtener la información de un nodo
    private static String getNodo(String etiqueta, Element elem){
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();//devuelve el valor del nodo
    }
    
}
