package inc.hardware.interfaces;

public interface Memory {

    byte[] memory = new byte[4096];

    byte get(short address);

    void set(short address, byte content);

}
