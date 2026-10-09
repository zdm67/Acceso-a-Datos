package tema03.CasosPracticos;

public class Ejemplo5 {
    public static void main(String[] args) {

        try {
            int[] numbers = { 1, 2, 3 };
            System.out.println(numbers[5]);
            System.out.println("Ocurrio un excepcion ArrayIndexOutOfBoundsException: Indice fuera de rango");

        } catch (ArrayIndexOutOfBoundsException aioe) {
            System.out.println("Excepcion controlada" + aioe.toString());
        }
    }
}
