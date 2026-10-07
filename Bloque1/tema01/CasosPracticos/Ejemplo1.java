import java.io.File;
import java.io.IOException;

public class Ejemplo1 {
    public static void main(String[] args) {

        File fichero = new File("./CasosPracticos/Complementos/crearfichero.txt");
        try {
            if (fichero.createNewFile())
                System.out.println("Fichero creado correctamente" + fichero);
            else
                System.out.println("El fichero esta creado");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}