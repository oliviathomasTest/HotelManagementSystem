package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;

    UpdateCheck(){
        JLabel l1 = new JLabel("Check in Status");
        l1.setFont(new Font("Fahoma",Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100,30,200,30);
        add(l1);

        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30,80,150,30);
        add(l2);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("Number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(200,80,150,30);
        add(c1);

        JLabel l3 = new JLabel("Room No");
        l3.setBounds(30,130,200,30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200,130,150,30);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(30,180,200,30);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(200,180,150,30);
        add(t2);

        JLabel l5 = new JLabel("Check-In");
        l5.setBounds(30,230,200,30);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);

        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(30,280,200,30);
        add(l6);

        t4 = new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);

        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30,330,200,30);
        add(l7);

        t5 = new JTextField();
        t5.setBounds(200,330,150,30);
        add(t5);

        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        b1.setBounds(120,390,120,30);
        add(b1);

        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        b2.setBounds(40,450,120,30);
        add(b2);

        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(220,450,120,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(480,380,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel il = new JLabel(i3);
        il.setBounds(430,80,480,380);
        add(il);

        setLayout(null);
        setVisible(true);
        setBounds(500,200,950,540);
    }

    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            try
            {
                String s1 = c1.getSelectedItem();
                Conn c = new Conn();
                String deposit = null;
                String room = null;
                String price = null;
                int amountPaid;
                ResultSet rs = c.s.executeQuery("select * from customer where Number ='"+s1+"'");
                while(rs.next())
                {
                    room = rs.getString("RoomNumber");
                    t1.setText(rs.getString("RoomNumber"));
                    t2.setText(rs.getString("Name"));
                    t3.setText(rs.getString("CheckedIn"));
                    deposit = rs.getString("Deposit");
                    t4.setText(rs.getString("Deposit"));


                }

                ResultSet rs2 = c.s.executeQuery("select * from rooms where room='"+room+"'");
                while(rs2.next()){
                    price = rs2.getString("price");
                    amountPaid = Integer.parseInt(price) -Integer.parseInt(deposit);

                    t5.setText(Integer.toString(amountPaid));
                }

            }
            catch (SQLException e)
            {
                System.out.println(e);
                e.printStackTrace();
            }
        } else if(actionEvent.getSource() == b2){


        } else if(actionEvent.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
}
