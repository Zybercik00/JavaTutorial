package com.github.zybercik00.hellojavagui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem openFile;
    JMenuItem saveFile;
    JMenuItem exitFile;
    ImageIcon image;

    public MyFrame() {
        
    this.setTitle("Moja pierwsza aplikacja z GUI");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600,600);
    this.setLayout(new FlowLayout());

    menuBar = new JMenuBar();

    fileMenu = new JMenu("File");
    editMenu = new JMenu("Edit");
    helpMenu = new JMenu("Help");

    menuBar.add(fileMenu);
    menuBar.add(editMenu);
    menuBar.add(helpMenu);

    openFile = new JMenuItem("Open File");
    saveFile = new JMenuItem("Save File");
    exitFile = new JMenuItem("Exit");

    openFile.addActionListener(this);

    fileMenu.add(openFile);
    fileMenu.add(saveFile);
    fileMenu.add(exitFile);

    this.setJMenuBar(menuBar);
    this.setVisible(true);

    image = new ImageIcon("songo.jpg");
    this.setIconImage(image.getImage());
    this.getContentPane().setBackground(new Color(0,0,0));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==openFile) {
            System.out.println("open");
        }

    }

    public static void main(String[] args) {
        new MyFrame();
    }
    
}
