package Ejercicios;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejercicio1 {
    public static void main(String[] args) {

        try {

            LineNumberReader ln = new LineNumberReader(new FileReader("tema02/Complementos/entrada.txt"));
            String line;

            while ((line = ln.readLine()) != null) {
                StreamTokenizer st = new StreamTokenizer(new StringReader(line));
                int palabras = 0;
                int numeros = 0;

                System.out.println("----- Linea nº " + ln.getLineNumber() + " -----");
                System.out.println(line);

                while ((st.nextToken()) != StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        palabras++;

                    } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                        numeros++;
                    }
                }

                System.out.println("Palabras: " + palabras + " Numeros " + numeros);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
