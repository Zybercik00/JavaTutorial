package com.github.zybercik00.hellojava;

import javax.swing.*;

public class HelloWorldSwing extends JPanel {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createandShowGUI();
            }
        });
    }
    

    private static void createandShowGUI() {
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        frame.pack();;
        frame.setVisible(true);
    }
    
}
