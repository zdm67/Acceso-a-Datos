import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {

        try {
            FileInputStream entrada = new FileInputStream("./Ejercicios/Complementos/ejercicio5.jpg");
            FileOutputStream salida = new FileOutputStream("./Ejercicios/Complementos/ejercicio5copia.jpg");
            int data;
            int num = 0;
            while ((data = entrada.read()) != -1) {
                num++;
                salida.write(data);

                // System.out.print((char) data);
            }
            entrada.close();
            salida.close();
            System.out.println(" Lectura completa + bytes: " + num);

        } catch (IOException ioe) {
            System.err.println("Error al leer el archivo: " + ioe.getMessage());

        }
    }
}
