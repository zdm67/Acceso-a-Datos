import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Guardar");
        System.out.println("2. Imprimir");
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion == 1) {

            System.out.println("Nombre y apellidos: ");
            String nombre = sc.nextLine();

            System.out.println("Email: ");
            String email = sc.nextLine();

            System.out.println("Fecha de Nacimiento:");
            String fechaNac = sc.nextLine();

            System.out.println("Genero: ");
            String genero = sc.nextLine();

            System.out.println("Titulo: ");
            String titulo = sc.nextLine();

            System.out.println("Observaciones: ");
            String observaciones = sc.nextLine();

            String contenido = " ------ Formulario de Matriculacion ------ \n" +
                    "Nombre y apellidos: " + nombre + "\n" +
                    "Email: " + email + "\n" +
                    "Fecha de Nacimiento: " + fechaNac + "\n" +
                    "Genero: " + genero + "\n" +
                    "Titulo: " + titulo + "\n" +
                    "Observaciones: " + observaciones + "\n";
        }
    }
}
