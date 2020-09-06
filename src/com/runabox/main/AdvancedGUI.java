package com.runabox.main;

import com.runabox.password.Password;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.*;

public class AdvancedGUI extends JPanel {
    private JTextArea jcomp2;
    private JLabel jcomp3;
    private JButton jcomp4;
    private JTextField jcomp5;
    private JTextField jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JLabel jcomp10;
    private JButton jcomp11;
    private JTextArea jcomp12;
    private JTextField jcomp13;
    private JLabel jcomp14;
    private JLabel jcomp15;
    private JMenuBar jcomp16;
    private JRadioButton jcomp17;
    private JComboBox jcomp1;

    private static Password pswd;

    public AdvancedGUI() {
        pswd = new Password();

        //construct preComponents
        JMenu fileMenu = new JMenu ("File");
        JMenuItem exitItem = new JMenuItem ("Exit");
        fileMenu.add (exitItem);
        JMenu helpMenu = new JMenu ("Help");
        JMenuItem documentationItem = new JMenuItem ("Documentation");
        helpMenu.add (documentationItem);
        JMenuItem aboutItem = new JMenuItem ("About");
        helpMenu.add (aboutItem);

        documentationItem.addActionListener(e -> {
            try {
                openWebpage(new URL("https://sht.rnbx.me/rlpassdocs.php"));
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
        });

        aboutItem.addActionListener(e -> new AboutMenu());

        exitItem.addActionListener(e -> System.exit(0));

        //construct components
        jcomp2 = new JTextArea (5, 5);
        jcomp3 = new JLabel ("Generate Array:");
        jcomp4 = new JButton ("Generate");
        jcomp5 = new JTextField (5);
        jcomp6 = new JTextField (5);
        jcomp7 = new JLabel ("Amount:");
        jcomp8 = new JLabel ("Length:");
        jcomp9 = new JLabel ("Note: Password Length varys by 3!");
        jcomp10 = new JLabel ("Runabox");
        jcomp11 = new JButton ("Generate");
        jcomp12 = new JTextArea (5, 5);
        jcomp13 = new JTextField (5);
        jcomp14 = new JLabel ("Length:");
        jcomp15 = new JLabel ("Generate Single Password:");
        jcomp16 = new JMenuBar();
        jcomp16.add (fileMenu);
        jcomp16.add (helpMenu);
        jcomp17 = new JRadioButton ("Copy to Clipboard?");

        //set components properties
        jcomp9.setToolTipText ("The password length will be random, so whatever length you put could be that plus 3, 2, or 1.");
        jcomp10.setToolTipText ("Made by Runabox, 2020");
        jcomp17.setToolTipText ("Toggles clipboard functionality");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        //action listeners (f)

        //array generation
        jcomp4.addActionListener(e -> {
            if(jcomp5.getText() == " " || jcomp5.getText() == null){
                JOptionPane.showMessageDialog(null, "Text Field cannot be blank!");
            } else if(jcomp6.getText() == " " || jcomp6.getText() == null){
                JOptionPane.showMessageDialog(null, "Text Field cannot be blank!");
            }

            int amount = Integer.parseInt(jcomp5.getText());
            int length = Integer.parseInt(jcomp6.getText());

            String str;

            if(jcomp1.getSelectedIndex() == 0){
                str = pswd.generatePasswordArray(amount, GUI.State.STATE1, length);
            } else if (jcomp1.getSelectedIndex() == 1){
                str = pswd.generatePasswordArray(amount, GUI.State.STATE2, length);
            } else {
                str = pswd.generatePasswordArray(amount, GUI.State.STATE3, length);
            }

            jcomp2.setText(str);

            if(jcomp17.isSelected()){
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                StringSelection strSel = new StringSelection(str);
                clipboard.setContents(strSel, null);

                toolkit.beep();

                JOptionPane.showMessageDialog(null, "Successfully copied array to clipboard!");
            }
        });

        jcomp11.addActionListener(e -> {
            if(jcomp13.getText() == " " || jcomp13.getText() == null){
                JOptionPane.showMessageDialog(null, "Text Field cannot be blank!");
            }

            int length = Integer.parseInt(jcomp13.getText());
            String str;

            if(jcomp1.getSelectedIndex() == 0){
                str = pswd.generatePassword(GUI.State.STATE1, length);
            } else if (jcomp1.getSelectedIndex() == 1){
                str = pswd.generatePassword(GUI.State.STATE2, length);
            } else {
                str = pswd.generatePassword(GUI.State.STATE3, length);
            }

            jcomp12.setText(str);

            if(jcomp17.isSelected()){
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                StringSelection strSel = new StringSelection(str);
                clipboard.setContents(strSel, null);

                toolkit.beep();

                JOptionPane.showMessageDialog(null, "Successfully copied array to clipboard!");
            }
        });

        //add components
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (jcomp10);
        add (jcomp11);
        add (jcomp12);
        add (jcomp13);
        add (jcomp14);
        add (jcomp15);
        add (jcomp16);
        add (jcomp17);

        //set component bounds (only needed by Absolute Positioning)
        jcomp2.setBounds (25, 40, 270, 355);
        jcomp3.setBounds (25, 20, 100, 25);
        jcomp4.setBounds (110, 465, 100, 25);
        jcomp5.setBounds (25, 415, 100, 25);
        jcomp6.setBounds (195, 415, 100, 25);
        jcomp7.setBounds (25, 395, 100, 25);
        jcomp8.setBounds (195, 395, 100, 25);
        jcomp9.setBounds (5, 550, 280, 25);
        jcomp10.setBounds (890, 0, 100, 25);
        jcomp11.setBounds (735, 465, 100, 25);
        jcomp12.setBounds (650, 40, 270, 355);
        jcomp13.setBounds (680, 415, 215, 25);
        jcomp14.setBounds (680, 395, 100, 25);
        jcomp15.setBounds (650, 20, 230, 25);
        jcomp16.setBounds (0, 0, 950, 25);
        jcomp17.setBounds (405, 45, 150, 25);

        String[] jcomp1Items = {"Not Secure", "Simple", "Complex"};
        jcomp1 = new JComboBox (jcomp1Items);
        add (jcomp1);
        jcomp1.setBounds (420, 165, 100, 25);

        initFrame();
    }


    private void initFrame(){
        JFrame frame = new JFrame("RLPass | Advanced [Runabox, 2020]");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(this);
        frame.pack();
        frame.setSize(new Dimension(944, 574));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }
}
