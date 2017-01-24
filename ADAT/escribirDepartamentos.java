/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ampliacion7;

/**
 *
 * @author Pedro
 */

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class escribirDepartamentos {
  public static void main(String[] args) throws IOException, ClassNotFoundException {   	
    File fichero = new File("/Users/Pedro/Documents/departamentosObj.dat");
    FileInputStream filein = new FileInputStream(fichero);//flujo de entrada   
    //conecta el flujo de bytes al flujo de datos
    ObjectInputStream dataIS = new ObjectInputStream(filein);      
    System.out.println ("Comienza el proceso de creaciÛn del fichero a XML ...");
				
    //Creamos un objeto Lista de Departamentos
    ListaDepartamentos listaper = new ListaDepartamentos();	 
     
    try {
      while (true) { //lectura del fichero
          //leer un departamento
	    Departamento departamento= (Departamento) dataIS.readObject();    
	    listaper.add(departamento); //añadir departamento a la lista  
      }	
    }catch (EOFException eo) {}
    dataIS.close();  //cerrar stream de entrada     
    
    try {
		XStream xstream = new XStream();   
		//cambiar de nombre a las etiquetas XML
		xstream.alias("ListaDepartamentosLocalidad", ListaDepartamentos.class);	
		xstream.alias("DatosDepartamento", Departamento.class);
		
		
		//quitar etiqueta lista (atributo de la claseListaDepartamentos)
		xstream.addImplicitCollection
                          (ListaDepartamentos.class, "lista");
		//Insertar los objetos en el XML
	      xstream.toXML(listaper, new
                          FileOutputStream("/Users/Pedro/Documents/Departamentos.xml"));	
		System.out.println("Creado fichero XML....");
	
     }catch (Exception e) 
	   {e.printStackTrace();}	    
  } // fin main
} //fin EscribirDepartamentos
