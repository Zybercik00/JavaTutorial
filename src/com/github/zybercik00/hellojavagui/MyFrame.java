package com.github.zybercik00.hellojavagui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;  
import java.io.File;
import java.nio.file.Files;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    JMenuItem edit;
    JMenuItem readDocumentation;
    ImageIcon image;
    ImageIcon songo;
    

    public MyFrame() {
        
    this.setTitle("Moja pierwsza aplikacja z GUI");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(600,600);
    this.setLayout(new FlowLayout());
    songo = new ImageIcon("songo.png");
    JLabel label = new JLabel();
    label.setIcon(songo);
    label.setText("tekst tekst");
    this.add(label);

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

    fileMenu.add(openFile);
    fileMenu.add(saveFile);
    fileMenu.add(exitFile);

    openFile.addActionListener(this);
    saveFile.addActionListener(this);
    exitFile.addActionListener(this);

    
    edit = new JMenuItem("Edit");
    editMenu.add(edit);
    edit.addActionListener(this);

    readDocumentation = new JMenuItem("Documentation");
    helpMenu.add(readDocumentation);
    readDocumentation.addActionListener(this);


    this.setJMenuBar(menuBar);
    this.setLocationRelativeTo(null);

    image = new ImageIcon("songo.jpg");
    this.setIconImage(image.getImage());
    this.getContentPane().setBackground(new Color(250,250,250));
    this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource()==openFile) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            try {
            File file = new File(chooser.getSelectedFile().getAbsolutePath());
            Desktop desctop = Desktop.getDesktop();
            desctop.open(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (event.getSource()==saveFile) {
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
        }
        
        if (event.getSource()==exitFile) {
            System.exit(0);;
        }
        if (event.getSource()==readDocumentation) {
            NewWindow helpWindow = new NewWindow();

        }
        if (event.getSource()==edit) {
            System.out.println("Editing");
        }

    }

    public static void main(String[] args) {
        new MyFrame();
    }
    private class NewWindow {
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
    
}
