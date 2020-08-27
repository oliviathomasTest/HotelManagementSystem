package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {

    Choice c1;
    JButton b1,b2;
    JTable t1;

    PickUp(){
        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("Fahoma",Font.BOLD,20));
        l1.setBounds(400,20,200,30);
        add(l1);

        JLabel l2 = new JLabel("Type of Car");
        l2.setBounds(50,100,100,20);
        add(l2);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver ");
            while(rs.next()){
                c1.add(rs.getString("carCompany"));
            }
            c1.setBounds(150,100,200,25);
            add(c1);
        }catch (Exception e){
            e.printStackTrace();
        }



        t1 = new JTable();
        t1.setRowHeight(30);
        t1.setGridColor(Color.BLACK);

        JTableHeader header = t1.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Verdana",Font.PLAIN,14));

        JScrollPane t2 = new JScrollPane(t1);
        LineBorder lb = new LineBorder(new Color(0, 0, 0, 0));
        t2.setBorder(lb);
        t2.setBounds(0,200,1000,300);
        add(t2);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(300,520,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(500,520,120,30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,1000,650);
        setVisible(true);

    }

    public static  void  main(String[] args){
        new PickUp().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            try{
                String str = "select * from driver where carCompany = '"+c1.getSelectedItem()+"'";

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(actionEvent.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
}
