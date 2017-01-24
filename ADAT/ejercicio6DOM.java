/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ampliacion1;

/**
 *
 * @author Pedro
 */
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
public class ejercicio6DOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, TransformerConfigurationException, TransformerException {
        // TODO code application logic here
        File fichero = new File ("/Users/Pedro/Documents/departamentos.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");
        
        int dep, posicion=0;
        char departamento[] = new char [15], aux;
        char localidad [] = new char [15], aux2;
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
    try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Persona", null);
        document.setXmlVersion("1.0"); //asignamos la versión de nuestro XML
        
        for(;;){
            file.seek(posicion); //Nos posicionamos
            dep=file.readInt(); //Obtengo el numero de departamento
            for (int i=0; i<departamento.length;i++){
                aux = file.readChar(); //recorro uno a uno los caracteres del departamento
                departamento[i] = aux; //los voy guardando en el array
            }
            String departamentoS = new String(departamento); //convierto a String el array
            
            //Hago lo mismo con localidad:
            for (int i=0; i<localidad.length;i++){
                aux2 = file.readChar(); 
                localidad[i] = aux2; 
            }
            String localidadS = new String(localidad);
            
            if(dep>0) { //departamentos válidos a partir de 1
                Element raiz = document.createElement("Departamento"); //Creamos el nodo Persona
                document.getDocumentElement().appendChild(raiz); //Lo pegamos a la raiz del doc
                CrearElemento("dep",Integer.toString(dep), raiz, document);
                CrearElemento("departamento",departamentoS.trim(), raiz, document);
                CrearElemento("localidad",localidadS.trim(), raiz, document);
            }            
            posicion= posicion + 64; //Me posiciono en el siguiente departamento
            if (file.getFilePointer() == file.length()){
                break;
            }
        } //fin del for que recorre el fichero
        
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File("/Users/Pedro/NetBeansProjects/Departamentos.xml"));
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
    }
    catch(Exception e){ 
        System.err.println("Error: "+e);
    }  
    file.close();
    }
    
    //Inserción de los datos del departamento
    static void CrearElemento (String datoDepartamento, String valor, Element raiz, Document document){
        Element elem = document.createElement(datoDepartamento); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raíz
        elem.appendChild(text); //pegamos el valor
    }
}

