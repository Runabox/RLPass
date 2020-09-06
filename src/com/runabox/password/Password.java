package com.runabox.password;

import com.runabox.main.GUI;
import java.util.Random;

public class Password {

    Random random;
    String[] letterArray;
    String[] randomCharacter;

    public Password(){
        random = new Random();

        initArrays();
    }

    //testing
    /*public static void main(String[] args){
        Password pswd = new Password();

        String str = pswd.generatePasswordArray(10000000, GUI.State.STATE3, 15);
        System.out.println(str);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);

        toolkit.beep();

        JOptionPane.showMessageDialog(null, "Successfully copied contents to clipboard!");
    }*/

    public String generatePasswordArray(int length, Enum mode, int plength){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            sb.append(generatePassword(mode, plength) + "\n");
        }

        return sb.toString();
    }

    public String generatePassword(Enum state){
        if(state == GUI.State.STATE1){
            return generateNotSecurePassword(15);
        } else if (state == GUI.State.STATE2){
            return generateSimplePassword(15);
        } else {
            return generateComplexPassword(15);
        }
    }

    public String generatePassword(Enum state, int length){
        if(state == GUI.State.STATE1){
            return generateNotSecurePassword(length);
        } else if (state == GUI.State.STATE2){
            return generateSimplePassword(length);
        } else {
            return generateComplexPassword(length);
        }
    }

    //default password length is 15
    private String generateNotSecurePassword(int length){
        //returns random string of just letters
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            int rInt = random.nextInt(25);

            boolean isUpperCase = random.nextBoolean();
            if(isUpperCase){
                sb.append(letterArray[rInt].toUpperCase());
            } else {
                sb.append(letterArray[rInt]);
            }
        }

        return sb.toString();
    }

    private String generateSimplePassword(int length){
        //returns random string of letters and numbers
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            boolean isLoN = random.nextBoolean();
            if(isLoN){
                int rInt = random.nextInt(25);

                boolean isUpperCase = random.nextBoolean();
                if(isUpperCase){
                    sb.append(letterArray[rInt].toUpperCase());
                } else {
                    sb.append(letterArray[rInt]);
                }
            } else {
                sb.append(random.nextInt(9));
            }
        }

        return sb.toString();
    }

    private String generateComplexPassword(int defaultLength){
        //returns random string of letters, numbers, and random characters
        StringBuffer sb = new StringBuffer();
        int addedLength = random.nextInt(3);
        int length = defaultLength + addedLength;

        for(int i = 0; i < length; i++){
            boolean isCoN = random.nextBoolean();
            if(isCoN){
                boolean isLoN = random.nextBoolean();
                if(isLoN){
                    int rInt = random.nextInt(25);

                    boolean isUpperCase = random.nextBoolean();
                    if(isUpperCase){
                        sb.append(letterArray[rInt].toUpperCase());
                    } else {
                        sb.append(letterArray[rInt]);
                    }
                } else {
                    //"scheck" is to lower the probability of a number appearing
                    boolean scheck = random.nextBoolean();
                    if(scheck){
                        int rInt = random.nextInt(25);

                        boolean isUpperCase = random.nextBoolean();
                        if(isUpperCase){
                            sb.append(letterArray[rInt].toUpperCase());
                        } else {
                            sb.append(letterArray[rInt]);
                        }
                    } else {
                        sb.append(random.nextInt(9));
                    }
                }
            } else{
                int rInt = random.nextInt(9);
                sb.append(randomCharacter[rInt]);
            }
        }

        return sb.toString();
    }

    private void initArrays() {
        //letter array
        letterArray = new String[]{"", "", "", "", "", "", "","", "", "", "", "", "", "","", "", "", "", "", "", "","", "", "", "", ""};

        letterArray[0] = "a";
        letterArray[1] = "b";
        letterArray[2] = "c";
        letterArray[3] = "d";
        letterArray[4] = "e";
        letterArray[5] = "f";
        letterArray[6] = "g";
        letterArray[7] = "h";
        letterArray[8] = "i";
        letterArray[9] = "j";
        letterArray[10] = "k";
        letterArray[11] = "l";
        letterArray[15] = "m";
        letterArray[13] = "n";
        letterArray[14] = "o";
        letterArray[15] = "p";
        letterArray[16] = "q";
        letterArray[17] = "r";
        letterArray[18] = "s";
        letterArray[19] = "t";
        letterArray[20] = "u";
        letterArray[21] = "v";
        letterArray[22] = "w";
        letterArray[23] = "x";
        letterArray[24] = "y";
        letterArray[25] = "z";

        randomCharacter = new String[]{"", "", "", "", "", "", "", "", "", ""};

        randomCharacter[0] = "!";
        randomCharacter[1] = "%";
        randomCharacter[2] = "$";
        randomCharacter[3] = "#";
        randomCharacter[4] = "@";
        randomCharacter[5] = "^";
        randomCharacter[6] = "&";
        randomCharacter[7] = "*";
        randomCharacter[8] = "+";
        randomCharacter[9] = "_";
    }

}
