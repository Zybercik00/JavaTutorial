package com.github.zybercik00.hellojava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;


public class BorderDemo extends JPanel {
    
    public BorderDemo() {
        super(new GridLayout(1,0));

    
        Border blackline, raisedetched, loweredetched,
               raisedbevel, loweredbevel, empty;

        Border paneEdge = BorderFactory.createEmptyBorder(0,10,10,10);

        blackline = BorderFactory.createLineBorder(Color.GREEN);
        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        empty = BorderFactory.createEmptyBorder();

        JPanel simpleBorders = new JPanel();
        simpleBorders.setBorder(paneEdge);
        simpleBorders.setLayout(new BoxLayout(simpleBorders,
                                              BoxLayout.Y_AXIS));

        addCompForBorder(blackline, "line border",
                         simpleBorders);
        addCompForBorder(raisedetched, "raised etched border",
                         simpleBorders);
        addCompForBorder(loweredetched, "lowered etched border",
                         simpleBorders);
        addCompForBorder(raisedbevel, "raised bevel border",
                         simpleBorders);
        addCompForBorder(loweredbevel, "lowered bevel border",
                         simpleBorders);
        addCompForBorder(empty, "empty border",
                         simpleBorders);

        JPanel matteBorders = new JPanel();
        matteBorders.setBorder(paneEdge);
        matteBorders.setLayout(new BoxLayout(matteBorders,
                                              BoxLayout.Y_AXIS));

        ImageIcon icon = createImageIcon("/src/com/github/zybercik00/hellojavagui/images/wavy.gif",
                                         "wavy-line border icon"); 
        Border border = BorderFactory.createMatteBorder(5, 1, 1, 10, icon);
        if (icon != null) {
            addCompForBorder(border,
                             "matte border (-1,-1,-1,-1,icon)",
                             matteBorders);
        } else {
            addCompForBorder(border,
                             "matte border (-1,-1,-1,-1,<null-icon>)",
                             matteBorders);
        }
        border = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red);
        addCompForBorder(border,
                         "matte border (1,5,1,1,Color.red)",
                         matteBorders);

        border = BorderFactory.createMatteBorder(0, 20, 0, 0, icon);
        if (icon != null) {
            addCompForBorder(border,
                             "matte border (0,20,0,0,icon)",
                             matteBorders);
        } else {
            addCompForBorder(border,
                             "matte border (0,20,0,0,<null-icon>)",
                             matteBorders);
        }

        JPanel titledBorders = new JPanel();
        titledBorders.setBorder(paneEdge);
        titledBorders.setLayout(new BoxLayout(titledBorders,
                                              BoxLayout.Y_AXIS));
        TitledBorder titled;

        titled = BorderFactory.createTitledBorder("title");
        addCompForBorder(titled,
                         "default titled border"
                         + " (default just., default pos.)",
                         titledBorders);

        titled = BorderFactory.createTitledBorder(
                              blackline, "title");
        addCompForTitledBorder(titled,
                               "titled line border"
                                   + " (centered, default pos.)",
                               TitledBorder.CENTER,
                               TitledBorder.DEFAULT_POSITION,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(loweredetched, "title");
        addCompForTitledBorder(titled,
                               "titled lowered etched border"
                                   + " (right just., default pos.)",
                               TitledBorder.RIGHT,
                               TitledBorder.DEFAULT_POSITION,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(
                        loweredbevel, "title");
        addCompForTitledBorder(titled,
                               "titled lowered bevel border"
                                   + " (default just., above top)",
                               TitledBorder.DEFAULT_JUSTIFICATION,
                               TitledBorder.ABOVE_TOP,
                               titledBorders);

        titled = BorderFactory.createTitledBorder(
                        empty, "title");
        addCompForTitledBorder(titled, "titled empty border"
                               + " (default just., bottom)",
                               TitledBorder.DEFAULT_JUSTIFICATION,
                               TitledBorder.BOTTOM,
                               titledBorders);

        JPanel compoundBorders = new JPanel();
        compoundBorders.setBorder(paneEdge);
        compoundBorders.setLayout(new BoxLayout(compoundBorders,
                                              BoxLayout.Y_AXIS));
        Border redline = BorderFactory.createLineBorder(Color.red);

        Border compound;
        compound = BorderFactory.createCompoundBorder(
                                  raisedbevel, loweredbevel);
        addCompForBorder(compound, "compound border (two bevels)",
                         compoundBorders);

        compound = BorderFactory.createCompoundBorder(
                                  redline, compound);
        addCompForBorder(compound, "compound border (add a red outline)",
                         compoundBorders);

        titled = BorderFactory.createTitledBorder(
                                  compound, "title",
                                  TitledBorder.CENTER,
                                  TitledBorder.BELOW_BOTTOM);
        addCompForBorder(titled, 
                         "titled compound border"
                         + " (centered, below bottom)",
                         compoundBorders);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Simple", null, simpleBorders, null);
        tabbedPane.addTab("Matte", null, matteBorders, null);
        tabbedPane.addTab("Titled", null, titledBorders, null);
        tabbedPane.addTab("Compound", null, compoundBorders, null);
        tabbedPane.setSelectedIndex(0);
        String toolTip = new String("<html>Blue Wavy Line border art crew:<br>&nbsp;&nbsp;&nbsp;Bill Pauley<br>&nbsp;&nbsp;&nbsp;Cris St. Aubyn<br>&nbsp;&nbsp;&nbsp;Ben Wronsky<br>&nbsp;&nbsp;&nbsp;Nathan Walrath<br>&nbsp;&nbsp;&nbsp;Tommy Adams, special consultant</html>");
        tabbedPane.setToolTipTextAt(1, toolTip);

        add(tabbedPane);
    }

    void addCompForTitledBorder(TitledBorder border,
                                String description,
                                int justification,
                                int position,
                                Container container) {
        border.setTitleJustification(justification);
        border.setTitlePosition(position);
        addCompForBorder(border, description,
                         container);
    }

    void addCompForBorder(Border border,
                          String description,
                          Container container) {
        JPanel comp = new JPanel(new GridLayout(1, 1), false);
        JLabel label = new JLabel(description, JLabel.CENTER);
        comp.add(label);
        comp.setBorder(border);

        container.add(Box.createRigidArea(new Dimension(0, 10)));
        container.add(comp);
    }

    protected static ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = BorderDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

   
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("BorderDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderDemo newContentPane = new BorderDemo();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}