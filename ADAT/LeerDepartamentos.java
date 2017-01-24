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
public class LeerDepartamentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        File fichero = new File ("/Users/Pedro/Documents/departamentos.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        
        int dep, posicion;
        char departamento[] = new char[15], aux;
        char localidad[] = new char[15], aux2;
        
        posicion=0; //Para situarnos al principio
        
        for (;;){
            file.seek(posicion);
            dep=file.readInt();
            for (int i=0; i<departamento.length;i++){
                aux=file.readChar(); //Recorremos uno a uno los caracteres
                departamento[i]=aux; //Y los guardamos en el array
            }
            
            for (int i=0; i<localidad.length;i++){
                aux2 = file.readChar(); //Recorremos uno a uno los caracteres
                localidad[i]=aux2; //Y los guardamos en el array
            }
            
            
            String departamentoS = new String(departamento).trim(); //Convertimos a string el array
            String localidadeS = new String(localidad).trim();
            
            System.out.println("ID departamento: " + dep + ", Departamento: " + departamentoS + ", Localidad: " + localidadeS);
            posicion=posicion+64; //Nos posicionamos para el siguiente empleado 
            //Cada empleado ocupa 46 bytes (4+30+30)
            
            //Si se ha recorrido todos los bytes, salimos del for
            
            if (file.getFilePointer()==file.length())
                break;
        }//fin for
        
        file.close(); //Cerramos el fichero
        
    }
    
}
