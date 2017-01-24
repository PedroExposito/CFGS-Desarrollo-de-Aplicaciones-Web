/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personas;

import java.io.*;

public class LeerFichObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persona persona; // defino la variable persona
        File fichero = new File("/Users/Pedro/Documents/personas.dat");
        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

        int i = 1;
        try {
            while (true) { // lectura del fichero
            persona = (Persona) dataIS.readObject(); // leer una Persona
            System.out.print(i + "=>");
            i++;
            System.out.printf("Nombre: %s, edad: %d %n",
            persona.getNombre(),persona.getEdad());

            }
            } catch (EOFException eo) {
                System.out.println("FIN DE LECTURA.");
            } catch (StreamCorruptedException x) {
            }
        dataIS.close(); // cerrar stream de entrada
	}
}