/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ampliacion1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Pedro
 */
public class EscribirDepartamentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // TODO code application logic here
        // TODO code application logic here
        
        File fichero = new File ("/Users/Pedro/Documents/departamentos.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        //Array con los departamentos:
        String departamento[] = {"CONTABILIDAD", "INFORMÁTICA", "ELECTRONICA", "ADMINISTRACION"};
        //Array con el número de departamento
        int dep[] = {1, 2, 3, 4};
        //Array con la localidad:
        String localidad [] = {"ANDUJAR", "UBEDA", "LINARES", "JAEN"};
        
        StringBuffer buffer = null; //Buffer para almacenar departamentos
        StringBuffer buffer2 = null; //Buffer para almacenar localidades
        int n = departamento.length; //Número de elementos del array
        for (int i=0;i<n;i++){ //Recorro los arrays
            file.writeInt(dep[i]); 
            buffer = new StringBuffer(departamento[i]);
            buffer.setLength(15); //15 caracteres para el departamento
            file.writeChars(buffer.toString()); //Insertar departamento
            buffer2 = new StringBuffer(localidad[i]);
            buffer2.setLength(15);
            file.writeChars(buffer2.toString()); //Insertar localidad
        }
        file.close(); //Cerramos el fichero
    }
    }
