package inc.hardware.so.listaligada.model;

public class Location {
    private long start;
    private Location next;

    public Location(long start, Location next) {
        super();
        this.start = start;
        this.next = next;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }


}
