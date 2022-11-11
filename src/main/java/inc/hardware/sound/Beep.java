package inc.hardware.sound;

import inc.hardware.interfaces.Sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;

public class Beep implements Sound {
    private boolean isEnabled;
    private boolean isPlaying;
    private SourceDataLine sdl;

    private final byte[] buf = new byte[256];

    public Beep() {
        try {
            AudioFormat af = new AudioFormat(44100f, 8, 1, true, false);
            sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            this.isEnabled = false;
            isPlaying = false;

            Arrays.fill(buf, (byte) 121);
            for (int i = buf.length / 3; i < (2 * buf.length / 3); i++) {
                buf[i] = (byte) 255 - 121;
            }

        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
            isEnabled = false;
        }
    }

    public Beep(boolean isEnabled) {
        this();
        this.isEnabled = isEnabled;
    }

    @Override
    public void play() {
        if (isPlaying || !isEnabled) return;
        isPlaying = true;
        Thread playThread = new PlayThread();
        playThread.setPriority(Thread.MAX_PRIORITY);
        playThread.start();
    }

    public void stopSound() {
        isPlaying = false;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void playWave() {
        try {
            final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("beep2.wav");
            final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Objects.requireNonNull(inputStream));
            Clip beep = AudioSystem.getClip();
            beep.open(audioInputStream);
            beep.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    private class PlayThread extends Thread {
        public void run(){
            try {
                sdl.start();
                do {
                    sdl.write(buf, 0, buf.length);
                } while (isPlaying);
                sdl.stop();
                sdl.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
