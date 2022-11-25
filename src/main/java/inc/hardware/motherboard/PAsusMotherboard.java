package inc.hardware.motherboard;

import inc.hardware.exception.VideoNotFoundException;
import inc.hardware.interfaces.*;
import inc.hardware.motherboard.chipset.m1.CpuController;
import inc.hardware.motherboard.chipset.m2.HardDiskController;
import inc.hardware.motherboard.chipset.m1.MemoryController;
import inc.hardware.motherboard.chipset.m1.PCIE16XController;
import inc.hardware.motherboard.chipset.m2.UsbController;
import inc.hardware.so.FileSystem.No;
import inc.hardware.sound.Beep;
import inc.hardware.video.OnboardVideo;

import java.awt.*;

public class PAsusMotherboard implements Motherboard {

    private PCIE16X pcieSlot1 = new OnboardVideo();
    private PCIE16X pcieSlot2;
    private PCIE16X pcieSlot3;
    private PCIE16X onboardVideoSlot;

    private Usb usbSlot1;
    private Usb usbSlot2;
    private Usb usbSlot3;

    private Sata sataSlot1;
    private Sata sataSlot2;

    private Memory memorySlot1;
    private Memory memorySlot2;
    private Memory memorySlot3;

    public PAsusMotherboard board = new PAsusMotherboard();
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

    public No<Long> writeSata(int index, byte[] dado){
        return HardDiskController.write(index, dado);
    }

    public byte[] ReadSata(int index, No<Long> dado){
        return HardDiskController.read(index, dado);
    }

    public Long getFreeSpaceHD(int index){
        return HardDiskController.getFreeSpaceHD(index);
    }

    public Long getSizeHD(int index){
        return HardDiskController.getSizeHD(index);
    }

    @Override
    public void connectCpu(LGA peripheral) {
        CpuController.connectCpu(peripheral);
    }

    @Override
    public void removeCpu() {
        CpuController.removeCpu();
    }

    @Override
    public void connectMemory(Memory peripheral) {
        MemoryController.connectMemory(peripheral);
    }

    @Override
    public void removeMemory(Memory peripheral) {
        MemoryController.removeMemory(peripheral);
    }

    public byte memoryGet(int index, short address){

        return MemoryController.get(index, address);

    }

}
