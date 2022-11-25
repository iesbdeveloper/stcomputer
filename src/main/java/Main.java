import inc.hardware.so.FileSystem.No;
import inc.hardware.storage.HardDisk10M;
import inc.hardware.storage.SSD32M;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random(1);
    private static SSD32M ssd32M = new SSD32M();
    public static void main(String[] args) {

//        byte[] u = randomByte();
//        byte[] s = randomByte();
//        No<Long> l = disk10M.write(u);
        kbyte();
//        No<Long> m = disk10M.write(s);
//        dbyte(l);
//        dbyte(m);
//        System.out.println("\nos espacoTotalacos  \ntotal " + disk10M.espacoTotal() + " \nlivre " + disk10M.espacoLivre() );
    }
    private static void dbyte(No<Long> nl)
    {
        for (byte o : ssd32M.read(nl)) {
        System.out.print(o + "");
    }
        System.out.println("\n");
    }
    private static byte[] randomByte()
    {
        int u = random.nextInt(512);
        byte[] b = new byte[u];
        int count = 0;
        while (count != b.length )
        {
            byte g = (byte)(random.nextInt(2));
            if(g < 2)
            {
                b[count] = g;
                count++;
            }
        }
        return b;
    }
    private static void kbyte()
    {
        int switcher;
        do {
            switcher = scanner.nextInt();
            switch (switcher)
            {
                case 1:
                {
                    byte[] o = randomByte();
                    No<Long> no = ssd32M.write(o);
                    System.out.println("\nos espacos  \ntotal " + ssd32M.espacoTotal() + " \nlivre " + ssd32M.espacoLivre() +" \n ocupado " + ssd32M.espacoOcupado() );
                    dbyte(no);
                }
            }

        }while (switcher != 0);
    }
}