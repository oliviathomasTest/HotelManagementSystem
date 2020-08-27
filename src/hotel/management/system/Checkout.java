package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Checkout extends JFrame implements ActionListener
{

    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;

    Checkout(){

        JLabel l1 = new JLabel("Check Out");
        l1.setFont(new Font("Fahoma", Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100,20,100,30);
        add(l1);

        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30,80,100,30);
        add(l2);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("Number"));
            }
            c1.setBounds(200,80,150,30);
            add(c1);
        } catch (Exception e){
            e.printStackTrace();
        }

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,130,150,30);
        add(t1);

        b1 = new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        b1.setBounds(30,200,120,30);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        b2.setBounds(170,200,120,30);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.addActionListener(this);
        b3.setBounds(350,85,20,20);
        add(b3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(420,300,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel il = new JLabel(i6);
        il.setBounds(400,0,420,300);
        add(il);


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setBounds(500,200,850,300);
    }

    public static void main(String[] args){
        new Checkout().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1) {

            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where Number = '"+id+"'";
            String str2 = "update rooms set availableStatus = 'Available' where room = '"+room+"'";
            Conn c = new Conn();
            try
            {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"Checkout done");
                new Reception().setVisible(true);
                this.setVisible(false);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

        } else if(actionEvent.getSource() == b2){
                new Reception().setVisible(true);
                this.setVisible(false);
        } else if(actionEvent.getSource() == b3){
                Conn c = new Conn();
                String id = c1.getSelectedItem();
            try
            {
                ResultSet rs  = c.s.executeQuery("select * from customer where Number ='"+id+"'");
                while (rs.next()){
                    t1.setText(rs.getString("RoomNumber"));
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }
}
