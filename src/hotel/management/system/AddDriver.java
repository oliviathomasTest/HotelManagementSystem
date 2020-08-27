package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener
{

    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;

    AddDriver(){
        JLabel title = new JLabel("ADD DRIVERS");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("Fahoma",Font.BOLD,20));
        add(title);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Fahoma",Font.PLAIN,14));
        name.setBounds(60,70,100,30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Fahoma",Font.PLAIN,14));
        age.setBounds(60,120,100,30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200,120,150,30);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Fahoma",Font.PLAIN,14));
        gender.setBounds(60,170,100,30);
        add(gender);

        c1 = new JComboBox(new String[]{"Male","Female"});
        c1.setBounds(200,170,150,30);
        add(c1);

        JLabel car = new JLabel("Car Company");
        car.setFont(new Font("Fahoma",Font.PLAIN,14));
        car.setBounds(60,220,100,30);
        add(car);


        t3 = new JTextField();
        t3.setBounds(200,220,150,30);
        add(t3);

        JLabel model = new JLabel("Car Model");
        model.setFont(new Font("Fahoma",Font.PLAIN,14));
        model.setBounds(60,270,100,30);
        add(model);


        t4 = new JTextField();
        t4.setBounds(200,270,150,30);
        add(t4);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Fahoma",Font.PLAIN,14));
        available.setBounds(60,320,100,30);
        add(available);

        c2 = new JComboBox(new String[]{"Available","Busy"});
        c2.setBounds(200,320,150,30);
        add(c2);

        JLabel location = new JLabel("Location");
        location.setFont(new Font("Fahoma",Font.PLAIN,14));
        location.setBounds(60,370,100,30);
        add(location);

        t5 = new JTextField();
        t5.setBounds(200,370,150,30);
        add(t5);

        b1 = new JButton("Add Driver");
        b1.setBounds(60,440,130,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(220,440,130,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(380,100,500,300);
        add(l1);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(460,200,900,540);
        setVisible(true);
    }

    public  static void main(String[] args){
        new AddDriver().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem();
            String carCompany = t3.getText();
            String carModel = t4.getText();
            String available = (String)c2.getSelectedItem();
            String location = t5.getText();

            Conn c = new Conn();
            String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+carCompany+"','"+carModel+"','"+available+"','"+location+"')";
            try
            {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver added");
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
