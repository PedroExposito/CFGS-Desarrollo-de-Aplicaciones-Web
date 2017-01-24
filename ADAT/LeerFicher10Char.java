
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
public class LeerFicher10Char {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        File fichero = new File ("/Users/Pedro/Documents/fichero.txt");
        FileReader fr = new FileReader(fichero);
        int i;
        char c[] = new char[10];//Creamos un array de longitud 10
        while ((i = fr.read(c)) != -1){//Recorremos el fichero y lo guardamos en el array
            System.out.println(c);
        }
        
    }
    
}
