
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class ModificarSalario4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int id = Integer.parseInt(args[0]);
        Double salario, sal = Double.parseDouble(args[1]), salAntiguo = null;
        char apellido[] = new char[10], aux;

        File fichero = new File("/Users/Pedro/Documents/empleados.dat");
        //Declaramos el fichero de acceso aleatorio
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        if (id >= file.length()) {
            System.out.println("No existe ningún empleado con ID " + id);
        } else {

            long posicion = (id - 1) * 36;
            posicion = posicion + 4 + 20 + 4; //Sumo el tamaño del ID+Apellido+Departamento
            file.seek(posicion);
            salAntiguo = file.readDouble(); //Guardamos el salario antiguo antes de modificarlo

            sal = sal + salAntiguo;
            file.seek(posicion); //Nos posicionamos
            file.writeDouble(sal);
            file.seek(posicion);//Volvemos a posicionarnos
            salario = file.readDouble(); //Obtenemos el salario del empleado

            long posicionApellido = (id - 1) * 36;
            posicionApellido = posicionApellido + 4;
            file.seek(posicionApellido);//Nos posicionamos en el apellido
            for (int i = 0; i < apellido.length; i++) {
                aux = file.readChar(); //Recorremos uno a uno los caracteres
                apellido[i] = aux; //Y los guardamos en el array
            }
            String apellidoS = new String(apellido).trim(); //Convertimos a string el array

            System.out.println("ID: " + id + ", Apellido: " + apellidoS + ", Salario Antiguo: " + salAntiguo
                    + ", Salario Nuevo: " + salario);
        }

        file.close();

    }

}
