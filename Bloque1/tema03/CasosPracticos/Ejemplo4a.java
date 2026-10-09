package tema03.CasosPracticos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejemplo4a {
    public static void main(String[] args) throws IOException {

        FileReader file = new FileReader("tema03/Complementos/archivO.txt");
        int data;

        while ((data = file.read()) != -1) {
            System.out.println((char) data);

        }
    }
}
