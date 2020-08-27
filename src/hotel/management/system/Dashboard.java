package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener
{

    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard(){
        mb = new JMenuBar();
        add(mb);
        mb.setOpaque(true);

        m1 = new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.RED);
        m1.setOpaque(true);
        mb.add(m1);

        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.CYAN);
        m2.setOpaque(true);
        mb.add(m2);


        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);

        i4 = new JMenuItem("ADD DRIVER");
        i4.addActionListener(this);
        m2.add(i4);

        mb.setBounds(0,0,1800,40);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1800,1000);
        add(l1);

        JLabel l2 = new JLabel("THE OLIVIA GROUP WELCOMES YOU");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Fahoma",Font.BOLD,30));
        l2.setOpaque(false);
        l2.setBounds(580,60,600,60);
        l1.add(l2);

        setLayout(null);
        setBounds(0,0,1800,1000);
        setVisible(true);
    }

    public static void main(String[] args){

        new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {   if(actionEvent.getActionCommand().equals("RECEPTION")){
        new Reception().setVisible(true);
        } else if(actionEvent.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee().setVisible(true);
        } else if(actionEvent.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        } else  if(actionEvent.getActionCommand().equals("ADD DRIVER")){
            new AddDriver().setVisible(true);
        }
    }
}
