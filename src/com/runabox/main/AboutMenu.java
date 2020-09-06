package com.runabox.main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AboutMenu extends JPanel {
    private JLabel jcomp2;
    private JButton jcomp3;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JLabel jcomp7;

    private JFrame frame;

    private BufferedImage logo;

    public AboutMenu() {
        //construct components
        jcomp2 = new JLabel ("About RLPass:");
        jcomp3 = new JButton ("Done");
        jcomp4 = new JLabel ("RLPass is an open source, advanced java password ");
        jcomp5 = new JLabel ("manager. You can visit the github page at:");
        jcomp6 = new JLabel ("https://github.com/Runabox/RLPass");
        jcomp7 = new JLabel ("Discord, Runabox#0001 Email, runa@runa.live");

        try{
            logo = ImageIO.read(new File("resources/logo.png"));
        } catch (IOException e){
            e.printStackTrace();
        }

        //adjust size and set layout
        setPreferredSize (new Dimension (427, 547));
        setLayout (null);

        jcomp3.addActionListener(e -> frame.dispose());

        jcomp6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    try {
                        AdvancedGUI.openWebpage(new URL("https://github.com/Runabox/RLPass"));
                    } catch (MalformedURLException malformedURLException) {
                        malformedURLException.printStackTrace();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //add components
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (jcomp7);

        //set component bounds (only needed by Absolute Positioning)
        jcomp2.setBounds (175, 140, 90, 25);
        jcomp3.setBounds (170, 475, 95, 25);
        jcomp4.setBounds (70, 170, 325, 30);
        jcomp5.setBounds (100, 195, 240, 25);
        jcomp6.setBounds (120, 245, 205, 25);
        jcomp7.setBounds (90, 355, 270, 30);

        init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(logo, 15, 20, this); // see javadoc for more info on the parameters
    }

    private void init(){
        frame = new JFrame("RLPass | About [Runabox, 2020]");

        frame.setDefaultCloseOperation(2);
        frame.setResizable(false);
        frame.setContentPane(this);
        frame.pack();
        frame.setSize(new Dimension(427, 547));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
