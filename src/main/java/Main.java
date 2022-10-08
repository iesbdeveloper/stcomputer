import inc.hardware.so.FileSystem.No;
import inc.hardware.storage.HardDisk10M;

public class Main {
    private static HardDisk10M disk10M = new HardDisk10M();
    public static void main(String[] args) {

        byte[] u = {0,0,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,1,0,1};
        byte[] s = {0,0,0,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1};
        No<Long> l = disk10M.write(u);
        No<Long> m = disk10M.write(s);
        dbyte(l);
        dbyte(m);
        System.out.println("\nos espacos  \ntotal " + disk10M.espacoTotal() + " \nlivre " + disk10M.espacoLivre() );
    }
    public static void dbyte(No<Long> nl)
    {
        for (byte o : disk10M.read(nl)) {
        System.out.print(o + "");
    }
        System.out.println("\n");
    }
}