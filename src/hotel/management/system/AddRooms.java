package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;

    AddRooms() {
        JLabel ml = new JLabel("ADD ROOMS");
        ml.setBounds(100,20,200,20);
        ml.setFont(new Font("Fahoma",Font.BOLD,17));
        add(ml);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(30,70,200,30);
        l1.setFont(new Font("Fahoma",Font.PLAIN,13));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(150,70,160,30);
        add(t1);

        JLabel l2 = new JLabel("Available");
        l2.setBounds(30,120,200,30);
        l2.setFont(new Font("Fahoma",Font.PLAIN,13));
        add(l2);

        String[] str = {"Available","Occupied"};
        c1 = new JComboBox(str);
        c1.setBounds(150,120,160,30);
        add(c1);

        JLabel status = new JLabel("Cleaning Status");
        status.setBounds(30,170,200,30);
        status.setFont(new Font("Fahoma",Font.PLAIN,13));
        add(status);

        c2 = new JComboBox(new String[]{"Clean","Dirty"});
        c2.setBounds(150,170,160,30);
        add(c2);


        JLabel price = new JLabel("Price");
        price.setBounds(30,220,200,30);
        price.setFont(new Font("Fahoma",Font.PLAIN,13));
        add(price);

        t2 = new JTextField();
        t2.setBounds(150,220,160,30);
        add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setBounds(30,270,200,30);
        type.setFont(new Font("Fahoma",Font.PLAIN,13));
        add(type);

        String[] str2 = {"Single Bed","Double Bed"};
        c3 = new JComboBox(str2);
        c3.setBounds(150,270,160,30);
        add(c3);

        b1 = new JButton("Add Room");
        b1.setBounds(30,350,110,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(190,350,110,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,380,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel il = new JLabel(i3);
        il.setBounds(350,30,450,350);
        add(il);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setBounds(460,200,820,430);
    }
    public static void main(String[] args){

        new AddRooms().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == b1){
            String room = t1.getText();
            String availableStatus = (String)c1.getSelectedItem();
            String cleaningStatus = (String)c2.getSelectedItem();
            String price = t2.getText();
            String bedType = (String)c3.getSelectedItem();

            Conn c = new Conn();
            String query = "insert into rooms values('"+room+"','"+availableStatus+"','"+cleaningStatus+"','"+price+"','"+bedType+"')";
            try
            {
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"New Room added");
                this.setVisible(false);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

        } else if(actionEvent.getSource() == b2){
            this.setVisible(false);
        }
    }
}
