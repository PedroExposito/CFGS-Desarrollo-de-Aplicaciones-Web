/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ampliacion7;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

/**
 *
 * @author Pedro
 */
public class Convertidor8 {

 public static void main(String argv[]) throws IOException{ 
  String hojaEstilo = "/Users/Pedro/NetBeansProjects/ADAT/src/Ampliacion7/departamentosPlantilla.xsl";
  String datosDepartamentos = "/Users/Pedro/Documents/Departamentos.xml";
  File pagHTML = new File("/Users/Pedro/Documents/ampliacion7.html");
  FileOutputStream os = new FileOutputStream(pagHTML); //crear fichero HTML
  
  Source estilos =new StreamSource(hojaEstilo); //fuente XSL
  Source datos =new StreamSource(datosDepartamentos); //fuente XML
  Result result = new StreamResult(os);         //resultado de la transformación
  
  try{     
   Transformer transformer =  
               TransformerFactory.newInstance().newTransformer(estilos);   
   transformer.transform(datos, result);	//obtiene el HTML
  }
  catch(Exception e){System.err.println("Error: "+e);}
  
  os.close();  //cerrar fichero 	
 }//de main
}//de la clase

