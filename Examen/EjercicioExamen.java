import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class EjercicioExamen {
    public static void main(String[] args) {

        // =========================================================
        // 1. GESTIÓN DE FICHEROS (Preparando el terreno)
        // =========================================================

        // Creamos la "carpeta" virtual en Java.
        File directorio = new File("./datos_juego");

        // Si no existe físicamente en el ordenador, la creamos.
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        // Preparamos la ruta de nuestro archivo de guardado dentro de la carpeta.
        File archivoBinario = new File(directorio, "puntuaciones.dat");

        // =========================================================
        // 2. ESCRITURA DE DATOS (Guardando tipos concretos)
        // =========================================================

        try {
            // DataOutputStream nos permite guardar valores reales (int, String),
            // no solo un montón de bytes incomprensibles.
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivoBinario));

            // Guardamos los datos del Jugador A (ID, Nombre, Puntos)
            dos.writeInt(1);
            dos.writeUTF("JugadorA");
            dos.writeFloat(1500.50f);

            // Guardamos los datos del Jugador B
            dos.writeInt(2);
            dos.writeUTF("JugadorB");
            dos.writeFloat(200.00f);

            dos.close(); // Siempre cerramos la puerta al salir para asegurar el guardado.
            System.out.println("✅ Datos binarios guardados");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }

        // =========================================================
        // 3. ACCESO DIRECTO (Modificando un dato sin borrar el resto)
        // =========================================================

        try {
            // Abrimos el archivo en modo Lectura/Escritura ("rw")
            RandomAccessFile raf = new RandomAccessFile(archivoBinario, "rw");

            // ¡Regla de oro! Para leer, hay que pedir los datos exactamente en el
            // mismo orden en el que los escribimos antes.
            int id = raf.readInt();
            String nombre = raf.readUTF();
            float puntos = raf.readFloat();

            System.out.println("Leído: " + id + " - " + nombre + " - " + puntos);

            // Queremos cambiarle los puntos al Jugador B.
            // Como el cursor ahora está en el Jugador B, leemos su ID y Nombre solo para
            // "saltarlos".
            raf.readInt();
            raf.readUTF();

            // ¡Stop! Ahora el cursor está justo antes de los puntos del Jugador B.
            // Guardamos esta posición exacta como si fuera un punto de control.
            long posicionPuntosB = raf.getFilePointer();

            // Colocamos el cursor en ese punto de control y sobrescribimos los puntos.
            raf.seek(posicionPuntosB);
            raf.writeFloat(5000.75f);

            raf.close();
            System.out.println("✅ Puntuación modificada con éxito.");

        } catch (IOException e) {
            System.out.println("Error en acceso aleatorio: " + e.getMessage());
        } 

        // =========================================================
        // 4. ESCRITURA DE TEXTO CON BUFFER (Creando un log rápido)
        // =========================================================

        File archivoTexto = new File(directorio, "log.txt");

        try {
            // Usamos un Buffer porque es como llevar una carretilla llena de datos al disco
            // duro
            // en lugar de ir a pie llevando carácter por carácter. ¡Es mucho más rápido!
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTexto));

            bw.write("El jugador A consiguio 1500 puntos\n");
            bw.write("El jugador B consiguio 1200 puntos\n");
            bw.write("El jugador C consiguio 1100 puntos\n");

            bw.close();
            System.out.println("✅ Archivo de log creado.");
        } catch (IOException e) {
            System.out.println("Error al crear el log: " + e.getMessage());
        }

        // =========================================================
        // 5. ANÁLISIS DE TEXTO (Leyendo el log línea a línea)
        // =========================================================

        try {
            // Este lector especial nos hace el favor de llevar la cuenta de en qué línea
            // estamos.
            LineNumberReader lnr = new LineNumberReader(new FileReader(archivoTexto));
            String linea;

            // Vamos sacando líneas del archivo hasta que se acaben (hasta que devuelva
            // null).
            while ((linea = lnr.readLine()) != null) {

                System.out.println("\n[Línea " + lnr.getLineNumber() + "]: " + linea);

                // El StreamTokenizer actúa como un "detective". Le pasamos la línea de texto
                // actual
                // y se encarga de trocearla en palabras y números.
                StreamTokenizer detective = new StreamTokenizer(new StringReader(linea));

                // Mientras el detective encuentre trozos y no llegue al final (TT_EOF)...
                while (detective.nextToken() != StreamTokenizer.TT_EOF) {

                    // Si el trozo es una palabra, lo extrae usando .sval (String value)
                    if (detective.ttype == StreamTokenizer.TT_WORD) {
                        System.out.println("  - Palabra: " + detective.sval);

                        // Si el trozo es un número, lo extrae usando .nval (Number value)
                    } else if (detective.ttype == StreamTokenizer.TT_NUMBER) {
                        System.out.println("  - Número: " + detective.nval);
                    }
                }
            }
            lnr.close();
        } catch (IOException e) {
            System.out.println("Error al analizar el texto: " + e.getMessage());
        }
    }
}