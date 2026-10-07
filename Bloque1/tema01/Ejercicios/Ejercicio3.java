import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Escribir el abecedario en el achivo
        try {
            File archivo = new File("./Ejercicios/Complementos/datos.txt"); // ruta del archivo
            FileWriter fw = new FileWriter(archivo); // creamos el achivo
            fw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ"); // escribimos el abecedario
            fw.close();

        } catch (IOException ioe) {
            System.out.println("Error al crear el archivo: " + ioe.getMessage());
            return;
        }

        // Pedir datos al usuario
        try {
            System.out.println("Introduce la posicion que deseas modificar: ");
            int posicion = sc.nextInt();
            sc.nextLine();

            System.out.println("Introduce el caracter que deseas establecer: ");
            char nuevoCaracter = sc.nextLine().charAt(0);

            RandomAccessFile file = new RandomAccessFile("./Ejercicios/Complementos/datos.txt", "rw");

            if (posicion < 0 || posicion >= file.length()) {
                System.out.println("Error: Posición inválida.");
            } else {
                // A) Posicionarse y sobrescribir
                file.seek(posicion);
                file.write((byte) nuevoCaracter);
                System.out.println("\n--- Carácter modificado con éxito ---");

                // B) Comprobar el resultado aplicando lo aprendido en tu Ejemplo7
                // Retrocedemos 1 posición (si es posible) para leer el carácter anterior, el
                // nuevo y el siguiente
                int posLectura = Math.max(0, posicion - 1);
                file.seek(posLectura);

                System.out.println("Puntero antes de read: " + file.getFilePointer());

                byte[] arrayBytes = new byte[3];
                int bytesLeidos = file.read(arrayBytes, 0, 3); // Leemos hasta 3 bytes

                System.out.println("Bytes leidos: " + bytesLeidos);
                System.out.println("Puntero despues de read: " + file.getFilePointer());

                // Imprimimos el resultado como en el ejemplo de clase
                for (int i = 0; i < bytesLeidos; i++) {
                    System.out.println(
                            "\n arrayBytes[" + i + "] = " + arrayBytes[i] + " -> '" + (char) arrayBytes[i] + "'");
                }
            }

            file.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
