
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class CrearFichero3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        File fichero = new File ("/Users/Pedro/Documents/empleados.dat");

        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        String apellido[] = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};

        int dep[] = {10, 20, 10, 10, 30, 30, 20};

        Double salario [] = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0};
        
        StringBuffer buffer = null; //Buffer para almacenar apellidos
        int n = apellido.length; 
        for (int i=0;i<n;i++){ 
            file.writeInt(i+1); //i+1 será el id del empleado
            buffer = new StringBuffer(apellido[i]);
            buffer.setLength(10); 
            file.writeChars(buffer.toString()); //Insertar apellido
            file.writeInt(dep[i]); //Insertar departamento
            file.writeDouble(salario[i]); //Insertar salario
        }
        file.close(); //Cerramos el fichero
    }
    
}
