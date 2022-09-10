package inc.hardware.so.listaligada.model;

public class Location {
    private long start;
    private Location next;

    public Location(long start, Location next) {
        this.start = start;
        this.next = next;
    }

    public long getStart() {
        return this.start;
    }

    public void setStart(long start) {
        this.start = start;
    }
}
