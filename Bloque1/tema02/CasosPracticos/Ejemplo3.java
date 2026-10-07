package CasosPracticos;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejemplo3 {
    public static void main(String[] args) {
        
        try{
            
            DataOutputStream dps = new DataOutputStream(new FileOutputStream("./tema02/Complementos/salida.txt"));
            dps.writeInt(123);
            dps.writeInt(987);
            dps.writeFloat(123.45F);
            dps.writeLong(953325447);
            dps.writeDouble(9.3);
            

            DataInputStream dis = new DataInputStream(new FileInputStream("./tema02/Complementos/salida.txt"));
            int entero1 = dis.readInt();
            int entero2 = dis.readInt();
            float numeroFloat = dis.readFloat();
            long numeroLong = dis.readLong();
            double numeroDouble = dis.readDouble();
            dps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}