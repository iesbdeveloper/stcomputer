//package inc.hardware.so;
//
//import inc.hardware.exception.OperatingSystemNotFoundException;
//import inc.hardware.interfaces.cpu.Cpu;
//import inc.hardware.interfaces.motherboard.Chipset;
//import inc.hardware.interfaces.system.BootLoader;
//import inc.hardware.interfaces.system.OperatingSystem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GrubBootLoader implements BootLoader {
//    private final List<OperatingSystem> operatingSystems = new ArrayList<>();
//    private int selected = 0;
//
//    public GrubBootLoader() {
//        operatingSystems.add(new STLinux());
//    }
//
//    public GrubBootLoader(OperatingSystem operatingSystem) {
//        operatingSystems.add(operatingSystem);
//    }
//
//    @Override
//    public void setChiset(Chipset chipset) {
//        for (OperatingSystem operatingSystem : operatingSystems) {
//            operatingSystem.setChiset(chipset);
//        }
//    }
//
//    @Override
//    public void setCpu(Cpu cpu) {
//        for (OperatingSystem operatingSystem : operatingSystems) {
//            operatingSystem.setCpu(cpu);
//        }
//    }
//
//    @Override
//    public void selectOperatingSystem(int index) throws OperatingSystemNotFoundException {
//        if (index > operatingSystems.size() - 1 || index < 0) {
//            throw new OperatingSystemNotFoundException();
//        }
//        selected = index;
//    }
//
//    @Override
//    public void loadSelectedOperatingSystem() {
//        try {
//            loadOperatingSystem(selected);
//        } catch (OperatingSystemNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void loadOperatingSystem(int index) throws OperatingSystemNotFoundException {
//        if (operatingSystems.size() == 0) {
//            throw new OperatingSystemNotFoundException();
//        }
//        OperatingSystem system = operatingSystems.size() == 1 ? operatingSystems.get(0) :  operatingSystems.get(index);
//
//        //TODO: SHOW OPERATING SYSTEM INIT MESSAGE ON VIDEO CARD
//        system.initialize();
//    }
//
//    @Override
//    public void addOperatingSystem(OperatingSystem system) {
//        operatingSystems.add(system);
//    }
//}
