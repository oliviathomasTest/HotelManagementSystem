package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener
{
    JRadioButton r1,r2;
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1;
    Choice c2;
    JButton b1,b2;

    AddCustomer(){
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(100,20,250,40);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Fahoma",Font.PLAIN,20));
        add(l1);

        JLabel l2 = new JLabel("ID");
        l2.setBounds(35,80,100,20);
        add(l2);

        c1 = new JComboBox(new String[]{"Passport","Voter ID Card","Aadhar Card","Driving License"});
        c1.setBounds(240,80,150,30);
        add(c1);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(35,130,100,20);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(240,130,150,30);
        add(t1);

        JLabel l4 = new JLabel("Name");
        l4.setBounds(35,180,100,20);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(240,180,150,30);
        add(t2);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(35,230,100,20);
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setBounds(240,230,150,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(330,230,150,30);
        add(r2);


        JLabel l6 = new JLabel("Country");
        l6.setBounds(35,280,100,20);
        add(l6);

        t3 = new JTextField();
        t3.setBounds(240,280,150,30);
        add(t3);

        JLabel l7 = new JLabel("Allocated Room Number");
        l7.setBounds(35,330,170,20);
        add(l7);

        c2 = new Choice();
        try{
            Conn c = new Conn();
            String str = "select * from rooms";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()){
                c2.add(rs.getString("room"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        c2.setBounds(240,330,150,30);
        add(c2);

        JLabel l8 = new JLabel("Checked In");
        l8.setBounds(35,380,150,20);
        add(l8);

        t4 = new JTextField();
        t4.setBounds(240,380,150,30);
        add(t4);

        JLabel l9 = new JLabel("Deposit");
        l9.setBounds(35,430,150,20);
        add(l9);

        t5 = new JTextField();
        t5.setBounds(240,430,150,30);
        add(t5);

        b1 = new JButton("Add Customer");
        b1.setBounds(60,490,140,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(220,490,140,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel il = new JLabel(i3);
        il.setBounds(380,60,480,450);
        add(il);


        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setBounds(460,200,850,580);
    }

    public static void main(String[] args){
        new AddCustomer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            String ID = (String)c1.getSelectedItem();
            String Number = t1.getText();
            String Name = t2.getText();
            String Gender = null;
            if(r1.isSelected()){
                Gender = "Male";
            } else if(r2.isSelected()){
                Gender = "Female";
            }
            String Country = t3.getText();
            String RoomNumber = c2.getSelectedItem();
            String CheckedIn = t4.getText();
            String Deposit = t5.getText();

            Conn c = new Conn();
            String str = "insert into customer values('"+ID+"','"+Number+"','"+Name+"','"+Gender+"','"+Country+"','"+RoomNumber+"','"+CheckedIn+"','"+Deposit+"')";
            String str1 = "update rooms set availableStatus = 'Occupied' where room = '"+RoomNumber+"'";
            try
            {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"New Customer Added");
                this.setVisible(false);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        } else if(actionEvent.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);

        }
    }
}
