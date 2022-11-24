package inc.hardware.motherboard.chipset.m2;

import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.No;

import java.util.ArrayList;
import java.util.List;

public class HardDiskController {
    static List<Sata> hd = new ArrayList<>();

    public List<Sata> getHd() {
        return hd;
    }

    public static void connectSata(Sata peripheral) {
        hd.add(peripheral);
    }
    public static void removeSata(Sata peripheral) {
        hd.remove(peripheral);
    }

    public No<Long> write(int index, byte[] dado) {
        Sata x = hd.get(index);
        return x.write(dado);
    }

    public byte[] read(int index, No<Long> dado) {
        Sata x = hd.get(index);
        return x.read(dado);
    }

    public Long getFreeSpaceHD(int index) {
        Sata x = hd.get(index);
        return x.espacoLivre();
    }

    public Long getSizeHD(int index) {
        Sata x = hd.get(index);
        return x.espacoTotal();
    }


}
