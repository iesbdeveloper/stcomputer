package inc.hardware.motherboard.chipset.m1;

import inc.hardware.interfaces.LGA;

public class CpuController {

    public static LGA cpu1;

    public static void connectCpu(LGA peripheral){

        if(cpu1 == null){
            cpu1 = peripheral;
        }

    }

    public static void removeCpu(){

        cpu1 = null;

    }

}
