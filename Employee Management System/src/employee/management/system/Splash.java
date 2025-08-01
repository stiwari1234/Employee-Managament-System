package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif")); // take the icon from icon AND VISIBLE to the FRAME
        Image i2 = i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT); // GETSCALARINSTANCE IS USED TO SCALE THE IMAGE IN THE FRAME
        ImageIcon i3 = new ImageIcon(i2); // IT TAKE  ANOTHER VARIABLE FOR IMAGE  TO THE FRAME
        JLabel image = new JLabel(i3); // TAKE IMAGE TO THE JLABEL TO SET THE IMAGE
        image.setBounds(0,0,1170,650); // SET THE POSITION  OF IMAGE TO THE FRAME
        add(image);// ADD THE IMAGE


        setSize(1170,650); // size of the frame
        setLocation(200,50); // postion of the frame
        setLayout(null); // layout of the frame --> border layout null
        setVisible(true); // for visibility of the frame
        // USE THREAD TO OPEN LOGIN PAGE AFTER  SOME SECOND

        try{
            Thread.sleep(5000); // USE THREAD TO OPEN FRAME FOR THE SECOND
            setVisible(false); // TO CLOSE THE FRAME AFTER THE GIVEN ABOVE SECOND
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Splash();
    }
} 
