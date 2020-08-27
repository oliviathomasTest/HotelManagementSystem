package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener
{

    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){
        l1 = new JLabel("Username");
        l1.setBounds(30,40,100,30);
        add(l1);

        l2 = new JLabel("Passsword");
        l2.setBounds(30,90,100,30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150,40,150,34);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150,90,150,34);
        add(t2);


        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        b1.setBounds(30,170,130,30);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        b2.setBounds(190,170,130,30);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,270,200);
        add(l3);

        getContentPane().setBackground(Color.WHITE );
        setLayout(null);
        setBounds(600,300,600,300);
        setVisible(true);
    }

    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
       if(actionEvent.getSource() == b1){
            String username = t1.getText();
            String password = t2.getText();
            Conn c = new Conn();

            String str = "select * from login where username = '"+username+"' and password = '"+password+"'";
           try {
             ResultSet rs = c.s.executeQuery(str);
             if(rs.next()){
                 new Dashboard().setVisible(true);
                 this.setVisible(false);
             } else {
                 JOptionPane.showMessageDialog(null,"Invalid username and password");
                 this.setVisible(false);
             }
           } catch (SQLException e) {
               e.printStackTrace();
           }

       } else if(actionEvent.getSource() == b2){
           System.exit(0);
       }
    }
}
