package inc.hardware.exception;

public class VideoNotFoundException extends Exception {
    public VideoNotFoundException() {
        super("Video not found on this computer!");
    }
}
