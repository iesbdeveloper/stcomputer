package inc.hardware.storage;

import com.sun.imageio.plugins.common.InputStreamAdapter;
import inc.hardware.interfaces.Sata;
import inc.hardware.so.FileSystem.ListaLigada;
import inc.hardware.so.FileSystem.No;

import java.io.*;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class SSDControler implements Sata {
    private final long id;
    private final long NANDSize;
    private final long size;
    private final List<SSDNAND> ssdnandList;
    private final long SectorSize;

    public SSDControler(long id, long NANDSize,long size,int sectorsize) {
        this.id = id;
        this.NANDSize = NANDSize;
        this.size = size;
        this.SectorSize = sectorsize;
        this.ssdnandList = new LinkedList<>();
        for (int i = 0; i < size/NANDSize; i++) {
            ssdnandList.add(new SSDNAND(i,NANDSize/sectorsize,sectorsize));
        }
    }
    private SSDSector getEmptySector() {
        SSDSector sector = null;
        for (SSDNAND ssdnand : ssdnandList ) {
            if (ssdnand.isFull() == false)
            {
                sector = ssdnand.freeSector();
            }
            if (ssdnand.isFull() == true)
            {
               // System.out.println(ssdnand.getId());
            }
        }
        return sector;
    }

    @Override
    public No<Long> write(byte[] dado) {

        if (espacoLivre() == 0){
            return null;
        }
        SSDSector givenSector = getEmptySector();
        String fileName =  "src//main//java//"+givenSector.getiD() + ".bin";

        ListaLigada<Long> lista = new ListaLigada<>();
        byte[] aux = new byte[(int)SectorSize];

        if(dado.length > SectorSize){
            double qttySector = dado.length / SectorSize;

            for(double j=0; j<qttySector; j++)
            {
                int k=0;

                if(j>0){
                    k = (int) (SectorSize * j);
                }

                for(int i=0; i<SectorSize; i++){
                    if(dado[i+k] != 0)
                        aux[i] = dado[i+k];
                    else
                        aux[i] = 0;
                }
                try{
                    ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName));
                    for (byte inter : aux) {
                        file.writeByte(inter);
                    }
                    file.close();
                }
                catch (IOException e){
                    //System.out.println(e.getMessage());
                }

                givenSector.setDado(aux);
                lista.inserir(givenSector.getiD());
            }
        }
        else{
            for (int i=0; i < dado.length; i++){
                if(dado[i] != 0)
                    aux[i] = dado[i];
                else
                    aux[i] = 0;
            }

            try{
                ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName));
                for (byte inter : aux) {
                    file.writeByte(inter);
                }
                file.close();
            }
            catch (IOException e) {
                //System.out.println(e.getMessage());
            }
            givenSector.setDado(aux);
            lista.inserir(givenSector.getiD());
        }

        return lista.recuperarNo(0);
    }

    @Override
    public byte[] read(No<Long> dado) {
        ByteArrayOutputStream Baos = new ByteArrayOutputStream();

        while (dado != null)
        {
            String filename = "src//main//java//" + String.valueOf(dado.getElemento()) + ".bin";

            try{
                File source = new File(filename);
                byte[] bytes = Files.readAllBytes(source.toPath());
                Baos.write(bytes);
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
            dado = dado.getProximo();
        }

        return Baos.toByteArray();
    }

    @Override
    public long espacoTotal() {
        return this.size;
    }

    @Override
    public long espacoLivre() {
        long qntty=0;
        long qnttyS = 0;
        for (SSDNAND ssdnand: ssdnandList) {
                for (SSDSector ssdSector : ssdnand.getSectorList()) {
                    if (ssdSector.getDado()[0] == -1) {
                        qntty++;
                    }
                }
        }
        qntty = qntty * getSectorSize() +(qnttyS * getNANDSize());
        return qntty;
    }

    @Override
    public long espacoOcupado() {
        long qntty=0;
        long qnttyS = 0;
        for (SSDNAND ssdnand: ssdnandList) {
            if (ssdnand.isFull() == true)
            {
                qnttyS++;
            }
            else {
                for (SSDSector ssdSector : ssdnand.getSectorList()) {
                    if (ssdSector.getDado()[0] != -1) {
                        qntty++;
                    }
                }
            }
        }
        //System.out.println(qntty);
        qntty = qntty * getSectorSize() +(qnttyS * getNANDSize());
        return qntty;
    }

    public long getSectorSize() {
        return SectorSize;
    }

    public long getId() {
        return id;
    }

    public long getNANDSize() {
        return NANDSize;
    }

    public long getSize() {
        return size;
    }

}
