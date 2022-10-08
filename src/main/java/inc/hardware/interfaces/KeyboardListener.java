package inc.hardware.interfaces;

import java.awt.event.KeyEvent;

public interface KeyboardListener {
    void keyTyped(KeyEvent evt);
    void keyPressed(KeyEvent evt);
    void keyReleased(KeyEvent evt);
}
