package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login(){
        // J-LABEL IS USED TO VISIBLE THE TEXT TO THE J-FRAME
        // J-LABEL FOR THE USERNAME
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);


         // TEXTFIELD IS USE FOT ADDING THE TEXT IN THE LABEL
        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        // J -LABEL FOR THE PASSWORD
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);


         // SAME FOR THE PASSWORD TEXTFIELD
        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);



        // MAKE THE LOGIN BUTTON
        login = new JButton("LOGIN"); // FOR BUTTON
        login.setBounds(150,140,150,30);
        login.setBackground(Color.white);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);


        // MAKE THE BACK BUTTON
        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

         // ADDING THE IMAGE
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
         imgg.setBounds(350,10,600,400);
        add(imgg);

         // ADD THE IMAGE IN THE BACKGROUND
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        // set the size  & visibility of the frame

        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){ // GETSOURCE BTAYEGA KI LOGIN BUTTON PR CLICK KIYA H
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                conn conn = new conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
