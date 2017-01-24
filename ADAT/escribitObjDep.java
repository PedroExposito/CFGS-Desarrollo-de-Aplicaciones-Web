/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ampliacion7;

import Personas.Persona;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Pedro
 */
public class escribitObjDep {
  public static void main(String[] args) throws IOException {   
   
   Departamento departamento;//defino variable departamento
   
   File fichero = new File("/Users/Pedro/Documents/departamentosObj.dat");//declara el fichero
   FileOutputStream fileout = new FileOutputStream(fichero,true);  //crea el flujo de salida
    //conecta el flujo de bytes al flujo de datos
   ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
   
   String departamentos[] = {"CONTABILIDAD", "INFORMÁTICA", "ELECTRONICA", "ADMINISTRACION"};
   String localidad [] = {"ANDUJAR", "UBEDA", "LINARES", "JAEN"};
   
   System.out.println("GRABO LOS DATOS DE DEPARTAMENTO.");      
   for (int i=0;i<localidad.length; i++){ //recorro los arrays    
      departamento= new Departamento(i+1,departamentos[i],localidad[i]); //creo la persona	  
	  dataOS.writeObject(departamento); //escribo la persona en el fichero
	  System.out.println("GRABO LOS DATOS DE DEPARTAMENTO.");  
   }     
   dataOS.close();  //cerrar stream de salida    
   }
}