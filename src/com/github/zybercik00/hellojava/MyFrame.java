package com.github.zybercik00.hellojava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class MyFrame extends JFrame  {

    public MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1200);
        this.setTitle("Bullet Jurnal");

        JPanel topPanel = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel maiPanel = new JPanel();

        topPanel.setPreferredSize(new Dimension(100,100));
        topPanel.setBackground(Color.GRAY);
        this.add(topPanel, BorderLayout.NORTH);

        leftPanel.setPreferredSize(new Dimension(100,100));
        leftPanel.setBackground(Color.GRAY);
        this.add(leftPanel, BorderLayout.WEST);
        
        
        JEditorPane editorPane = new JEditorPane();
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500,500));
        
        
        
        
        
        
        maiPanel.setPreferredSize(new Dimension(100,100));
        maiPanel.setBackground(Color.lightGray);
        maiPanel.add(scrollPane);
        this.add(maiPanel);

        this.setVisible(true);
    }

}