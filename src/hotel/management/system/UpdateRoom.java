package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener
{

    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;

    UpdateRoom(){
        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Fahoma",Font.PLAIN,20));
        l1.setBounds(80,25,200,30);
        l1.setForeground(Color.blue);
        add(l1);

        JLabel l2 = new JLabel("Guest ID");
        l2.setBounds(30,80,120,20);
        add(l2);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("Number"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(200,80,150,30);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,120,20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,130,150,30);
        add(t1);

        JLabel l4 = new JLabel("Availability");
        l4.setBounds(30,180,120,20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,180,150,30);
        add(t2);

        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(30,230,120,20);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        b1.setBounds(120,300,120,30);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        b2.setBounds(40,360,120,30);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(220,360,120,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(480,380,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel il = new JLabel(i3);
        il.setBounds(400,30,480,380);
        add(il);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setBounds(500,200,920,480);
    }
    public static void main(String[] args){
        new UpdateRoom().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String s1 = c1.getSelectedItem();
        if(actionEvent.getSource() == b1){

                Conn c = new Conn();
                String room = null;
            try
            {
                ResultSet rs = c.s.executeQuery("select * from customer where Number='"+s1+"'");

                while(rs.next()){
                    t1.setText(rs.getString("RoomNumber"));
                    room = rs.getString("RoomNumber");
                }

                ResultSet rs2 = c.s.executeQuery("select * from rooms where room='"+room+"'");
                while(rs2.next()){
                    t2.setText(rs2.getString("availableStatus"));
                    t3.setText(rs2.getString("cleaningStatus"));
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        } else if(actionEvent.getSource() == b2){

            try{
                String no = t1.getText();
                String availablity = t2.getText();
                String cleanStatus = t3.getText();
                Conn c = new Conn();
                c.s.executeUpdate("update rooms set availableStatus='"+availablity+"',cleaningStatus='"+cleanStatus+"' where room ='"+no+"'");
                JOptionPane.showMessageDialog(null,"Room Updated Succesfully");
                new Reception().setVisible(true);
                this.setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }

        } else if(actionEvent.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
}
