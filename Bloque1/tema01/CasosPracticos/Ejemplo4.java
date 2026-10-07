import java.io.FileReader;
import java.io.FileWriter;

public class Ejemplo4 {
    public static void main(String[] args) {

        try {
            FileReader lector = new FileReader("./CasosPracticos/Complementos/prueba.txt");
            FileWriter escritor = new FileWriter("./CasosPracticos/Complementos/escritura.txt");
            int data;
            while ((data = lector.read()) != -1) {
                escritor.write(data);
                System.out.println((char) data);
            }
            lector.close();
            escritor.close();
            System.out.println(" \nLectura correcta");

        } catch (Exception e) {
            e.printStackTrace();
        }

        /* 
        try {
            FileWriter fw = new FileWriter("./tema1/Complementos/escritura.txt");
            fw.write("Esto es un ejemplo de escritura");
            fw.close();
            System.out.println("Fichero escrito correctamente.");
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }*/
    }
}