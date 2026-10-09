package tema03.CasosPracticos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo4 {
    public static void main(String[] args) {

        try {
            FileReader file = new FileReader("tema03/Complementos/archivo.xml");
            int data;

            while ((data = file.read()) != -1) {
                System.out.println((char) data);

            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Error FileNotFoundException: ");
            fnfe.printStackTrace();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {
            System.out.println("Esto se ejecuta siempre");
        }
    }
}
