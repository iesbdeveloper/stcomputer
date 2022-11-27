package inc.hardware.so.FileSystem.model;

public class Sistema {

    private String name;
    private String ext;
    private long   size;

    Location loc = new Location(124,null);


    public Sistema(String name, String ext, long size, Location loc) {
        super();

        this.name = name;
        this.ext = ext;
        this.size = size;
        this.loc = loc;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }

    public String getExt() {
        return ext;
    }
    public void setExt(String ext) {
        this.ext = ext;
    }


    @Override
    public String toString() {
        return  "\t"+ name +"\t"+ ext+ "\t" +  size + "\t" + loc
                + "\n";
    }


}
