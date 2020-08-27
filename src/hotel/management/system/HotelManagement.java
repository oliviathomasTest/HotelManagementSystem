package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HotelManagement extends JFrame implements ActionListener {

    HotelManagement(){
        setBounds(300,200,1366,565);
       // setSize(400,400);

        //setLocation(300,300);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1366,565);
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(20,450,1000,70);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("serif",Font.ITALIC,70));
        l1.add(l2);

        JButton b1 = new JButton("Next");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBounds(1150,450,100,50);
        l1.add(b1);

        setLayout(null);
        //by default ,it will have border layout
        setVisible(true);

        while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch (Exception e){
            e.printStackTrace();
            }
            l2.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        //Swings are used for creating desktop applications
        new HotelManagement();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        new Login().setVisible(true);
        this.setVisible(false);
    }
}
