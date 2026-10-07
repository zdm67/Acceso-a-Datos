import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio5 {
    public static void main(String[] args) {

        try {

            FileInputStream fis = new FileInputStream("./tema01/Ejercicios/Complementos/ejercicio5.jpg");
            FileOutputStream fos = new FileOutputStream("./tema01/Ejercicios/Complementos/ejercicio5noBuffer.jpg");

            int data;
            int contador = 0;
            long inicio1 = System.currentTimeMillis();

            while ((data = fis.read()) != -1) {
                fos.write(data);
                contador++;
            }

            System.out.println("Se han copiado " + contador + " bytes.");
            long final1 = System.currentTimeMillis();

            System.out.println("FileImputStream ha tardado: " + (final1 - inicio1) + "ms");

            fis.close();
            fos.close();

        } catch (IOException ioe) {
            System.out.println("error");
        }

        try {

            BufferedInputStream entrada = new BufferedInputStream(
                    new FileInputStream("./tema01/Ejercicios/Complementos/ejercicio5.jpg"));
            BufferedOutputStream salida = new BufferedOutputStream(
                    new FileOutputStream("./tema01/Ejercicios/Complementos/ejercicio5buffered.jpg"));

            byte[] buffered = new byte[1];
            int bytesLeidos;
            // int contador = 0;
            long inicio2 = System.currentTimeMillis();

            while ((bytesLeidos = entrada.read(buffered)) != -1) {
                salida.write(buffered, 0, bytesLeidos);
                // contador++;
            }

            long final2 = System.currentTimeMillis();

            System.out.println("Buffered ha tardado " + (final2 - inicio2) + "ms");

            entrada.close();
            salida.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
