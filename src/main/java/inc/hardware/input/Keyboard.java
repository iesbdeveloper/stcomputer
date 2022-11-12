package inc.hardware.input;

import inc.hardware.interfaces.KeyboardListener;
import inc.hardware.interfaces.Usb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Keyboard implements KeyListener, Usb {
    private final ArrayList<KeyboardListener> keyboardListeners;

    public Keyboard() {
        keyboardListeners = new ArrayList<>();
    }

    public void keyTyped(KeyEvent e) {
        for (KeyboardListener listener : keyboardListeners) {
            listener.keyTyped(e);
        }
    }

    public void keyPressed(KeyEvent e) {
        for (KeyboardListener listener : keyboardListeners) {
            listener.keyPressed(e);
        }
    }

    public void keyReleased(KeyEvent e) {
        for (KeyboardListener listener : keyboardListeners) {
            listener.keyReleased(e);
        }
    }

    public void addListener(KeyboardListener listener) {
        keyboardListeners.add(listener);
    }

    public void removeListener(KeyboardListener listener) {
        keyboardListeners.remove(listener);
    }
}
