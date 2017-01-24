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
public class BorrarDepartamento3 {

 public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        File fichero = new File ("/Users/Pedro/Documents/departamentos.dat");
        File ficheroaux = new File ("/Users/Pedro/Documents/departamentosAux.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        RandomAccessFile fileaux = new RandomAccessFile(ficheroaux, "rw");
        
        int dep, posicion, borrar = Integer.parseInt(args[0]);
        int x=0;
        char departamento[] = new char[15], aux;
        char localidad[] = new char[15], aux2;
        
        posicion=0; //Para situarnos al principio
        StringBuffer buffer = null; //Buffer para almacenar departamentos
        StringBuffer buffer2 = null; //Buffer para almacenar localidades
        for (int j=1; j<=file.length();j++){
            file.seek(posicion);
            dep=file.readInt();
            fileaux.writeInt(j); 
            if(dep==(borrar-1)){
                file.seek(posicion=posicion+64);
            }
            for (int i=0; i<departamento.length;i++){
                aux=file.readChar(); //Recorremos uno a uno los caracteres
                departamento[i]=aux; //Y los guardamos en el array
                buffer = new StringBuffer();
                buffer.setLength(15); //15 caracteres para el departamento
                fileaux.writeChar(aux);
            }
            
            for (int i=0; i<localidad.length;i++){
                aux2 = file.readChar(); //Recorremos uno a uno los caracteres
                localidad[i]=aux2; //Y los guardamos en el array
                buffer = new StringBuffer();
                buffer.setLength(15); //15 caracteres para la localidad
                fileaux.writeChar(aux2);
            }
            
            
            String departamentoS = new String(departamento).trim(); //Convertimos a string el array
            String localidadeS = new String(localidad).trim();
            x++;
            System.out.println("ID departamento: " + dep + ", Departamento: " + departamentoS + ", Localidad: " + localidadeS);
            posicion=posicion+64; //Nos posicionamos para el siguiente empleado 
            //Cada empleado ocupa 46 bytes (4+30+30)
            //Si se ha recorrido todos los bytes, salimos del for
            if (file.getFilePointer()==file.length())
                break;

        }//fin for
        System.out.println("********Departamento "+borrar+" eliminado********");
        System.out.println("Nº total de departamentos: "+x);
        ficheroaux.renameTo(fichero);
        ficheroaux.delete();
        file.close(); //Cerramos el fichero
        
        
        
    }
    
}
