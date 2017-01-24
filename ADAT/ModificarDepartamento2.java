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
public class ModificarDepartamento2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int posicion, dep = Integer.parseInt(args[0]);
        String nuevoNombre = args[1], localidadNueva = args[2];
        char nombreDepartamento[] = new char[15], aux;
        char localidad[] = new char[15], aux2;
        
        File fichero = new File ("/Users/Pedro/Documents/departamentos.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        
        posicion=(dep-1)*64;
        if (posicion>=file.length()) {
            System.out.println("No existe ningún departamento con el Nº " + dep);
        } else {
            file.seek(posicion); //Nos posicionamos
            dep=file.readInt(); //Leemos el numero de departamento y lo guardamos

            for (int i=0; i<nombreDepartamento.length;i++){
                aux = file.readChar(); //Recorremos uno a uno los caracteres
                nombreDepartamento[i]=aux; //Y los guardamos en el array
            }
            
            for (int i=0; i<localidad.length;i++){
                aux2 = file.readChar(); //Recorremos uno a uno los caracteres
                localidad[i]=aux2; //Y los guardamos en el array
            }
            
            String departamentoAntiguo = new String(nombreDepartamento).trim(); //Convertimos a string el array
            String localidadAntigua = new String(localidad).trim();
            
            file.seek(posicion+4); //Volvemos al principio del registro, saltandonos el numero de dep
            
            StringBuffer buffer=null;
            buffer=new StringBuffer(nuevoNombre);
            buffer.setLength(15);
            file.writeChars(buffer.toString());
            buffer=new StringBuffer(localidadNueva);
            buffer.setLength(15);
            file.writeChars(buffer.toString());
            System.out.print("****************************\tDatos antiguos\t****************************\n");
            System.out.println("ID departamento: " + dep + ", Departamento: " + departamentoAntiguo + ", Localidad: " + localidadAntigua + "\n");
            System.out.println("****************************\tDatos nuevos\t****************************\n");
            System.out.println("ID departamento: " + dep + ", Departamento: " + nuevoNombre + ", Localidad: " +localidadNueva);
         }
           file.close(); 
        }
        
        
     }

