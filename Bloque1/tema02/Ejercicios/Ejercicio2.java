package Ejercicios;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Indica qué línea quieres leer: ");
        int opcion = Integer.parseInt(sc.nextLine());

        boolean lineaEncontrada = false;

        try {
            LineNumberReader ln = new LineNumberReader(new FileReader("tema02/Complementos/entrada.txt"));
            String line;

            // Leer el archivo linea por linea
            while ((line = ln.readLine()) != null) {

                if (ln.getLineNumber() == opcion) {
                    System.out.println("Contenido de la línea número " + opcion + ":");
                    System.out.println(line);
                    lineaEncontrada = true;
                    break;
                }
            }

            if (!lineaEncontrada) {
                System.out.println("El numero de línea " + opcion + " no existe");
            }

            ln.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
