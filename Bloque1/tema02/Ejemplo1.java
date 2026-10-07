package tema02;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Ejemplo1 {
    public static void main(String[] args) throws Exception {

        StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader("./tema02/Complementos/datos.txt"));

        // Configurar para que el carácter de nueva línea sea significativo
        streamTokenizer.eolIsSignificant(true);

        int contadorPalabras = 0;
        int contadorNumeros = 0;

        try {
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println("Word - " + streamTokenizer.sval); // token de tipo palabra
                    contadorPalabras++;

                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println("number - " + streamTokenizer.nval); // token de tipo numero
                    contadorNumeros++;

                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println();
                }

            }
            System.out.println("");
            System.out.println("Cantidad de Palabras: " + contadorPalabras);
            System.out.println("Cantidad de Numeros: " + contadorNumeros);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}