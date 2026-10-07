import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Cuanto rango quieres consultar? ");
            int inicio = Integer.parseInt(sc.nextLine());

            System.out.println("Cuantos asientos quieres consultar a partir del numero seleccionado?");
            int cantidad = Integer.parseInt(sc.nextLine());

            RandomAccessFile asientos = new RandomAccessFile("\"./tema01/Ejercicios/Complementos/asientos.txt\"", "rw");
            asientos.seek(inicio);

            byte[] array = new byte[cantidad];

            asientos.read(array, 0, cantidad);

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
