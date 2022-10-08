package inc.hardware.interfaces;

public interface Usb {
    enum PeripheralType {
        Mouse, KeyBoard, PenDrive, HeadSet
    }

    PeripheralType getType();
}