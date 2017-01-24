
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class BuscarID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int dep, id=Integer.parseInt(args[0]);
        Double salario;
        char apellido[] = new char[10], aux;
        
        File fichero = new File ("/Users/Pedro/Documents/empleados.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        
        int posicion=(id-1)*36; //Calculo donde empieza el registro

        if(posicion >= file.length()){
            System.out.println("No existe ningún empleado con ID "+id);
        }
        else{
            
                file.seek(posicion); //Nos posicionamos
                id=file.readInt(); //Obtenemos el id del empleado

            
                for (int i=0; i<apellido.length;i++){
                    aux=file.readChar(); //Recorremos uno a uno los caracteres
                    apellido[i]=aux; //Y los guardamos en el array
                }
                String apellidoS = new String(apellido).trim(); //Convertimos a string el array
            
                dep=file.readInt();
                salario=file.readDouble(); //Obtenemos el salario del empleado
            
                System.out.println("ID: " + id + ", Apellido: " + apellidoS + ", Departamento: " + dep + 
                    ", Salario: " + salario);
        }//fin else
        file.close();
        
    }
    
}
