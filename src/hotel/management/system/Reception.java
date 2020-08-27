package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Reception extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    Reception(){
        b1 = new JButton("New Customer Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(10,30,200,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(10,70,200,30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Department");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setOpaque(true);
        b3.setBorderPainted(false);
        b3.setBounds(10,110,200,30);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("All Employee Info");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setOpaque(true);
        b4.setBorderPainted(false);
        b4.setBounds(10,150,200,30);
        b4.addActionListener(this);
        add(b4);


        b5 = new JButton("Customer Info");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setOpaque(true);
        b5.setBorderPainted(false);
        b5.setBounds(10,190,200,30);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setOpaque(true);
        b6.setBorderPainted(false);
        b6.setBounds(10,230,200,30);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("Check Out");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setOpaque(true);
        b7.setBorderPainted(false);
        b7.addActionListener(this);
        b7.setBounds(10,270,200,30);
        add(b7);

        b8 = new JButton("Update Check Status");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setOpaque(true);
        b8.setBorderPainted(false);
        b8.addActionListener(this);
        b8.setBounds(10,310,200,30);
        add(b8);

        b9 = new JButton("Update Room Status");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setOpaque(true);
        b9.setBorderPainted(false);
        b9.addActionListener(this);
        b9.setBounds(10,350,200,30);
        add(b9);

        b10 = new JButton("Pick up Service ");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setOpaque(true);
        b10.setBorderPainted(false);
        b10.addActionListener(this);
        b10.setBounds(10,390,200,30);
        add(b10);

        b11 = new JButton("Search Room");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setOpaque(true);
        b11.setBorderPainted(false);
        b11.addActionListener(this);
        b11.setBounds(10,430,200,30);
        add(b11);

        b12 = new JButton("Logout");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.setOpaque(true);
        b12.setBorderPainted(false);
        b12.addActionListener(this);
        b12.setBounds(10,470,200,30);
        add(b12);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(250,30,500,470);
        add(l1);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setBounds(500,200,780,550);
    }

    public static void main(String[] args){
        new Reception().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            new AddCustomer().setVisible(true);
            this.setVisible(false);
        } else  if(actionEvent.getSource() == b2){
                new Room().setVisible(true);
                this.setVisible(false);

        } else  if(actionEvent.getSource() == b3){
                new Department().setVisible(true);
                this.setVisible(false);
        } else  if(actionEvent.getSource() == b4){
                new EmployeeInfo().setVisible(true);
                this.setVisible(false);
        } else  if(actionEvent.getSource() == b5){
                new Customerinfo().setVisible(true);
                this.setVisible(false);
        } else  if(actionEvent.getSource() == b6){
                new ManagerInfo().setVisible(true);
                this.setVisible(false);
        } else  if(actionEvent.getSource() == b7){
            new Checkout().setVisible(true);
            this.setVisible(false);
        } else  if(actionEvent.getSource() == b8){
                new UpdateCheck().setVisible(true);
                this.setVisible(false);
        } else  if(actionEvent.getSource() == b9){
                new UpdateRoom().setVisible(true);
                this.setVisible(false);
        } else  if(actionEvent.getSource() == b10){
                new PickUp().setVisible(true);
                this.setVisible(false);
        } else  if(actionEvent.getSource() == b11){
                new SearchRoom().setVisible(true);
                this.setVisible(false);
        } else  if(actionEvent.getSource() == b12){
                    this.setVisible(false);
        }

    }
}
