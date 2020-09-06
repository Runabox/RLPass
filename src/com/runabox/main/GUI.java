package com.runabox.main;

import com.runabox.password.Password;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.*;

public class GUI extends JPanel {
    private JSlider jcomp1;
    private JTextField jcomp2;
    private JButton jcomp3;
    private JLabel jcomp4;
    private JButton jcomp5;

    private int state = 2;

    private Password pswd;

    public enum State {
        STATE1, STATE2, STATE3
    }

    public Enum getState(){
        if(state == 0){
            return State.STATE1;
        } else if (state == 1){
            return State.STATE2;
        } else {
            return State.STATE3;
        }
    }

    public GUI() {
        pswd = new Password();

        //construct components
        jcomp1 = new JSlider (0, 2);
        jcomp2 = new JTextField (5);
        jcomp3 = new JButton ("Generate");
        jcomp4 = new JLabel ("Current Mode: Complex");
        jcomp5 = new JButton("Advanced");

        //set components properties
        jcomp1.setOrientation (JSlider.HORIZONTAL);
        jcomp1.setMinorTickSpacing (1);
        jcomp1.setMajorTickSpacing (5);
        jcomp1.setPaintTicks (true);
        jcomp1.setPaintLabels (false);
        jcomp1.setValue(2);

        jcomp2.setEditable(false);

        //adjust size and set layout
        setPreferredSize (new Dimension (945, 575));
        setLayout (null);

        jcomp3.addActionListener(e -> {
            String password = pswd.generatePassword(getState());
            jcomp2.setText(password);

            String str = password;

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            StringSelection strSel = new StringSelection(str);
            clipboard.setContents(strSel, null);

            toolkit.beep();

            JOptionPane.showMessageDialog(null, "Successfully generated password and copied to clipboard!");

            System.out.println("Password Generated: " + str);
        });

        jcomp1.addChangeListener(e -> {
            if(jcomp1.getValue() == 0){
                //not secure
                jcomp4.setText("Current Mode: Not Secure");
                jcomp4.setBounds (390, 255, 300, 25);
                state = 0;
            } else if (jcomp1.getValue() == 1){
                jcomp4.setText("Current Mode: Simple");
                jcomp4.setBounds (410, 255, 300, 25);
                state = 1;
            } else {
                jcomp4.setText("Current Mode: Complex");
                jcomp4.setBounds (400, 255, 300, 25);
                state = 2;
            }
        });

        jcomp5.addActionListener(e -> new AdvancedGUI());

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (310, 280, 315, 45);
        jcomp2.setBounds (355, 115, 225, 20);
        jcomp3.setBounds (420, 200, 100, 25);
        jcomp4.setBounds (400, 255, 300, 25);
        jcomp5.setBounds (840, 520, 100, 25);
    }

}
