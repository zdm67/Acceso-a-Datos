import java.io.RandomAccessFile;

//Ejemplo de acceso aleatorio o directo

public class Ejemplo7 {

    public static void main(String[] args) {

        try {
            RandomAccessFile file = new RandomAccessFile("./CasosPracticos/Complementos/abecedario.txt", "r");

            file.seek(5); // saltamos directamente a la posición 5, sin leer lo anterior
            System.out.println("Puntero antes de read: " + file.getFilePointer());

            byte[] arrayBytes = new byte[3];
            file.read(arrayBytes, 0, 3);

            System.out.println("Bytes leidos: " + arrayBytes.length);
            System.out.println("Puntero despues de read: " + file.getFilePointer());

            for (int i = 0; i < arrayBytes.length; i++) {
                System.out
                        .println("\n arrayBytes[" + i + "] = " + arrayBytes[i] + " -> '" + (char) arrayBytes[i] + "'");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}