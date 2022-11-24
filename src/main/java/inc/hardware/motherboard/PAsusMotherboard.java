package inc.hardware.motherboard;

import inc.hardware.exception.VideoNotFoundException;
import inc.hardware.interfaces.*;
import inc.hardware.motherboard.chipset.m1.HardDiskController;
import inc.hardware.motherboard.chipset.m1.MemoryController;
import inc.hardware.motherboard.chipset.m1.PCIE16XController;
import inc.hardware.motherboard.chipset.m1.UsbController;
import inc.hardware.sound.Beep;
import inc.hardware.video.OnboardVideo;

import java.awt.*;

public class PAsusMotherboard implements Motherboard {

    private PCIE16X pcie1 = new OnboardVideo();
    private PCIE16X pcie2;
    private PCIE16X pcie3;
    private PCIE16X onboardVideo;

    private Usb usb1;
    private Usb usb2;
    private Usb usb3;

    private final Sound beep;

    PAsusMotherboard board = new PAsusMotherboard();
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

        UsbController.connectUsb(peripheral);

    }

    @Override
    public void removeUsb(Usb peripheral) {

        UsbController.removeUsb(peripheral);

    }

    @Override
    public void connectPcie(PCIE16X peripheral) {

        PCIE16XController.connectPcie16x(peripheral);

    }

    @Override
    public void removePcie(PCIE16X peripheral) {

        PCIE16XController.removePcie16x(peripheral);

    }

    @Override
    public void connectSata(Sata peripheral) {

        HardDiskController.connectSata(peripheral);

    }

    @Override
    public void removeSata(Sata peripheral) {

        HardDiskController.removeSata(peripheral);

    }

    @Override
    public void connectCpu(LGA cpu) {

    }

    @Override
    public void removeCpu() {

    }

    @Override
    public void connectMemory(Memory peripheral) {

        MemoryController.connectMemory(peripheral);

    }

    @Override
    public void removeMemory(Memory peripheral) {

        MemoryController.removeMemory(peripheral);

    }

}
