import inc.hardware.so.FileSystem.No;
import inc.hardware.storage.HardDisk10M;

public class Main {
    public static void main(String[] args) {
        HardDisk10M disk10M = new HardDisk10M();
        byte[] u = {0,0,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,1,0,1};
        No<Long> nl = disk10M.write(u);
        for (byte o : disk10M.read(nl)) {
            System.out.println(o);
        }
        System.out.println("fifi \n" + disk10M.espacoTotal() + " \n" + disk10M.espacoLivre() );
    }
}