package inc.hardware;

import inc.hardware.exception.VideoNotFoundException;
import inc.hardware.input.Keyboard;
import inc.hardware.motherboard.PAsusMotherboard;

import javax.swing.*;
import java.awt.*;

public class STComputer extends JPanel {
    public static final String TITLE = "STComputer";

    private final PAsusMotherboard motherboard;

    public STComputer() {
        Keyboard keyboard = new Keyboard();
        addKeyListener(keyboard);

        motherboard = new PAsusMotherboard();
        motherboard.connectUsb(keyboard);
    }

    //public Dimension getVideoResolution() throws VideoNotFoundException {
        //return motherboard.getVideoResolution();
   // }

    public static void main(String[] args) throws VideoNotFoundException {
        STComputer computer = new STComputer();

       // Dimension resolution = computer.getVideoResolution();
        //computer.setPreferredSize(resolution);
        //computer.setMaximumSize(resolution);
        //computer.setMinimumSize(resolution);

        JFrame frame = new JFrame(TITLE);
        frame.add(computer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
