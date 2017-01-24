
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class LeerFichero3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        File fichero = new File ("/Users/Pedro/Documents/empleados.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        
        int id, dep, posicion;
        Double salario;
        char apellido[] = new char[10], aux;
        
        posicion=0; //Para situarnos al principio
        
        for (;;){
            file.seek(posicion);
            id=file.readInt();
            for (int i=0; i<apellido.length;i++){
                apellido[i]=file.readChar(); //Y los guardamos en el array
            }
            
            String apellidoS = new String(apellido).trim(); //Convertimos a string el array
            dep=file.readInt(); //Obtenemos el numero de departamento
            salario=file.readDouble(); //Obtenemos el salario
            
            System.out.println("ID: " + id + ", Apellido: " + apellidoS + ", Departamento: " + dep + 
                    ", Salario: " + salario);
            posicion=posicion+36; //Nos posicionamos para el siguiente empleado 
            //Cada empleado ocupa 36 bytes (4+20+4+8)
            
            //Si se ha recorrido todos los bytes, salimos del for
            
            if (file.getFilePointer()==file.length())
                break;
        }//fin for
        
        file.close(); //Cerramos el fichero
        
    }
    
}
