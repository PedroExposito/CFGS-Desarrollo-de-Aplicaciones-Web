
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class LeerFicheroChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //Creamos un fichero nuevo
        File fichero = new File ("/Users/Pedro/Documents/fichero.txt");
        //Creamos el flujo
        FileReader fr = new FileReader(fichero);
        int i;
        //Con un while, leemos hasta que sea igual a -1, es decir, hasta el final de fichero
        while ((i = fr.read()) != -1){
            System.out.println((char) i);
        }
        //Cerramos el flujo
        fr.close();
    }
    
}
