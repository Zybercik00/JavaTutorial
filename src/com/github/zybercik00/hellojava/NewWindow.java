package com.github.zybercik00.hellojava;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;

public class NewWindow  {
    JFrame frame = new JFrame();
        JLabel label = new JLabel("INFO");
        NewWindow() {
            label.setText("Here you can get all information about this program");
            label.setBounds(125,10,100,50);
            label.setFont(new Font(null, Font.PLAIN, 30));
            label.setVerticalAlignment(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
            frame.setSize(1200,500);
            frame.setLayout(new FlowLayout());
            frame.setTitle("Documentation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.add(label);
            frame.setVisible(true);
        }
}
