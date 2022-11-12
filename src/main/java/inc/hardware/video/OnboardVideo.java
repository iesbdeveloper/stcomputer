package inc.hardware.video;

import inc.hardware.interfaces.VideoPCIE16X;

import java.awt.*;

/**
 * Onboard video card
 *
 */
public class OnboardVideo implements VideoPCIE16X {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final int SCALE = 1;

    @Override
    public PeripheralType getType() {
        return PeripheralType.VideoCard;
    }

    @Override
    public Dimension getVideoResolution() {
        return new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
    }
}
