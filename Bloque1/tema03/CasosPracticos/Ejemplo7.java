package tema03.CasosPracticos;

public class Ejemplo7 {
    public static void main(String[] args) {

        try {
            int a = 8;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException ae) {
            System.out.println("Error aritmetico: " + ae.getMessage());
            ae.printStackTrace();
        }
    }
}
