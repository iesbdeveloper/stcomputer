package inc.hardware.so;

import java.io.*;
import java.util.Arrays;

public class FatFileSystem {

    public static byte[] converteParaBytes () {
        String teste = "C://Users//r.rodrigues//Downloads//teste.txt";

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(teste));

            return inputStream.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void  converteParaString (byte []array ) throws FileNotFoundException {
        String str=new String(array);
    }
}
