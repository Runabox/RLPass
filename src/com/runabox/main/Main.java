package com.runabox.main;

import javax.swing.*;
import java.awt.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static JFrame frame;

    public static String title = "RLPass";
    public static int width = 944, height = 574;

    public Main() throws UnknownHostException {
        //init
        frame = new JFrame(title);

        frame.setTitle("RLPass | Main [Runabox, 2020]");

        frame.setDefaultCloseOperation(3);
        frame.setContentPane(new GUI());
        frame.setResizable(false);
        frame.pack();

        frame.setSize(new Dimension(width, height));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        try {
            new Main();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
