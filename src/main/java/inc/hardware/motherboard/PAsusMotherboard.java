package inc.hardware.motherboard;

import  inc.hardware.exception.VideoNotFoundException;
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
        if (pcie1.getType() == PCIE16X.PeripheralType.VideoCard)
            {

            }
        else if (pcie2.getType() == PCIE16X.PeripheralType.VideoCard)
            {

            }
        else if (pcie3.getType() == PCIE16X.PeripheralType.VideoCard)
            {

            }
        else if (onboardVideo.getType() == PCIE16X.PeripheralType.VideoCard)
            {

            }
        throw new VideoNotFoundException();
    }

    @Override
    public void connectUsb(Usb peripheral) {
        if(usb1 == null){
            usb1 = new Usb()
            {
            };
        } else if(usb2 == null){
            usb2 = new Usb()
            {
            };
        } else if(usb3 == null){
            usb3 = new Usb()
            {
            };
        }
    }

    @Override
    public void removeUsb(Usb slot) {
        if(usb1 != null){
            usb1 = null;
        } if(usb2 != null){
            usb2 = null;
        } if(usb3 != null){
            usb3 = null;
        }
    }

    @Override
    public void connectPcie(PCIE16X peripheral) {
        if(pcie1 == null){
            pcie1 = new PCIE16X() {
                @Override
                public PeripheralType getType() {
                    return null;
                }
            };
        }else if(pcie2 == null){
            pcie2 = new PCIE16X() {
                @Override
                public PeripheralType getType() {
                    return null;
                }
            };
        }else if(pcie3 == null){
            pcie3 = new PCIE16X() {
                @Override
                public PeripheralType getType() {
                    return null;
                }
            };
        }
    }

    @Override
    public void removePcie(PCIE16X slot) {
        if(pcie1 != null){
            pcie1 = null;
        } else if (pcie2 != null){
            pcie2 = null;
        } else if (pcie3 != null){
            pcie3 = null;
        }
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