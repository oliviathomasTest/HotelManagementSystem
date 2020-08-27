package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener
{
    JTextField t1, t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;

    AddEmployee(){
       JLabel name = new JLabel("NAME");
       name.setFont(new Font("Fahoma",Font.PLAIN,17));
       name.setBounds(60,40,120,30);
       add(name);

       t1 = new JTextField();
       t1.setBounds(200,40,170,30);
       add(t1);

       JLabel age = new JLabel("AGE");
       age.setFont(new Font("Fahoma",Font.PLAIN,17));
       age.setBounds(60,90,120,30);
       add(age);

       t2 = new JTextField();
       t2.setBounds(200,90,170,30);
       add(t2);

        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Fahoma",Font.PLAIN,17));
        gender.setBounds(60,140,120,30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Fahoma",Font.PLAIN,13));
        r1.setBounds(200,140,100,40);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Fahoma",Font.PLAIN,13));
        r2.setBounds(280,140,100,40);
        add(r2);

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Fahoma",Font.PLAIN,17));
        job.setBounds(60,190,120,30);
        add(job);

        String  str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress",
                          "Manager","Accountant","Chef"};
        c1 = new JComboBox(str);
        c1.setBounds(200,190,170,30);
        add(c1);


        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Fahoma",Font.PLAIN,17));
        salary.setBounds(60,240,120,30);
        add(salary);

        t3 = new JTextField();
        t3.setBounds(200,240,170,30);
        add(t3);

        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Fahoma",Font.PLAIN,17));
        phone.setBounds(60,290,120,30);
        add(phone);

        t4 = new JTextField();
        t4.setBounds(200,290,170,30);
        add(t4);


        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setFont(new Font("Fahoma",Font.PLAIN,17));
        aadhar.setBounds(60,340,120,30);
        add(aadhar);

        t5 = new JTextField();
        t5.setBounds(200,340,170,30);
        add(t5);

        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Fahoma",Font.PLAIN,17));
        email.setBounds(60,390,120,30);
        add(email);

        t6 = new JTextField();
        t6.setBounds(200,390,170,30);
        add(t6);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(200,440,170,30);
        b1.addActionListener(this);
        add(b1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(430,480,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,90,430,480);
        add(l1);

        JLabel l2 = new JLabel("ADD EMPLOYEE DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setBounds(430, 50,400,30);
        l2.setFont(new Font("Fahoma",Font.PLAIN,30));
        add(l2);

        getContentPane().setBackground(Color.WHITE);

       setLayout(null);
       setBounds(460,200,850,540);
       setVisible(true);
    }

    public static void main(String[] args){
        new AddEmployee().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();

        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        } else if(r2.isSelected()){
            gender = "Female";
        }

        String job = (String)c1.getSelectedItem();
        Conn c = new Conn();
        String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"'"+ ")";

        try
        {
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee added");
            this.setVisible(false);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
