package inc.hardware.motherboard;

import inc.hardware.exception.VideoNotFoundException;
import inc.hardware.interfaces.*;
import inc.hardware.sound.Beep;

import java.awt.*;

public class PAsusMotherboard implements Motherboard {

    private PCIE16X pcie1;
    private PCIE16X pcie2;
    private PCIE16X pcie3;
    private PCIE16X onboardVideo;

    private Usb usb1;
    private Usb usb2;
    private Usb usb3;

    private final Sound beep;

    public PAsusMotherboard() {
        beep = new Beep();
    }

    @Override
    public Dimension getVideoResolution() throws VideoNotFoundException {
        //TODO: Ask to video card!!
        throw new VideoNotFoundException();
    }

    @Override
    public void connectUsb(Usb peripheral) {

    }

    @Override
    public void removeUsb(Usb slot) {

    }

    @Override
    public void connectPcie(PCIE16X peripheral) {

    }

    @Override
    public void removePcie(PCIE16X slot) {

    }

    @Override
    public void connectSata(Sata peripheral) {

    }

    @Override
    public void removeSata(Sata slot) {

    }

    @Override
    public void connectCpu(LGA cpu) {

    }

    @Override
    public void removeCpu() {

    }

    @Override
    public void connectMemory(Memory peripheral) {

    }

    @Override
    public void removeMemory(Memory peripheral) {

    }

}
