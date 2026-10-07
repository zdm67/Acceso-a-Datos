import java.io.File;

public class Ejemplo2 {
    public static void main(String[] args) {

        File fichero0 = new File("./CasosPracticos/Complementos/crearFichero.txt");
        File carpeta = new File("./CasosPracticos/Complementos", "backup");
        carpeta.mkdirs();

        File destino = new File("./CasosPracticos/Complementos/fichero_movido.txt");
        if (fichero0.renameTo(destino))
            System.out.println("El fichero se ha movido correctamente");
        else
            System.out.println("El fichero no se ha podido mover");

    }
}
