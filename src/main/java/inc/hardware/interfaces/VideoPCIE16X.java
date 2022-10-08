package inc.hardware.interfaces;

import java.awt.*;

public interface VideoPCIE16X extends PCIE16X {

    // Sprites para desenho de 0 a F
    byte[] sprite_0 = new byte[]{(byte)0xF0,(byte)0x90,(byte)0x90,(byte)0x90,(byte)0xF0};
    byte[] sprite_1 = new byte[]{(byte)0x20,(byte)0x60,(byte)0x20,(byte)0x20,(byte)0x70};
    byte[] sprite_2 = new byte[]{(byte)0xF0,(byte)0x10,(byte)0xF0,(byte)0x80,(byte)0xF0};
    byte[] sprite_3 = new byte[]{(byte)0xF0,(byte)0x10,(byte)0xF0,(byte)0x10,(byte)0xF0};
    byte[] sprite_4 = new byte[]{(byte)0x90,(byte)0x90,(byte)0xF0,(byte)0x10,(byte)0x10};
    byte[] sprite_5 = new byte[]{(byte)0xF0,(byte)0x80,(byte)0xF0,(byte)0x10,(byte)0xF0};
    byte[] sprite_6 = new byte[]{(byte)0xF0,(byte)0x80,(byte)0xF0,(byte)0x90,(byte)0xF0};
    byte[] sprite_7 = new byte[]{(byte)0xF0,(byte)0x10,(byte)0x20,(byte)0x40,(byte)0x40};
    byte[] sprite_8 = new byte[]{(byte)0xF0,(byte)0x90,(byte)0xF0,(byte)0x90,(byte)0xF0};
    byte[] sprite_9 = new byte[]{(byte)0xF0,(byte)0x90,(byte)0xF0,(byte)0x10,(byte)0xF0};
    byte[] sprite_A = new byte[]{(byte)0xF0,(byte)0x90,(byte)0xF0,(byte)0x90,(byte)0x90};
    byte[] sprite_B = new byte[]{(byte)0xE0,(byte)0x90,(byte)0xE0,(byte)0x90,(byte)0xE0};
    byte[] sprite_C = new byte[]{(byte)0xF0,(byte)0x80,(byte)0x80,(byte)0x80,(byte)0xF0};
    byte[] sprite_D = new byte[]{(byte)0xE0,(byte)0x90,(byte)0x90,(byte)0x90,(byte)0xE0};
    byte[] sprite_E = new byte[]{(byte)0xF0,(byte)0x80,(byte)0xF0,(byte)0x80,(byte)0xF0};
    byte[] sprite_F = new byte[]{(byte)0xF0,(byte)0x80,(byte)0xF0,(byte)0x80,(byte)0x80};

    Dimension getVideoResolution();
}
