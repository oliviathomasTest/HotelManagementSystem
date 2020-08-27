package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener {

    JButton b1,b2;
    JTable t1;

    Department(){
        JLabel l1 = new JLabel("Department");
        l1.setFont(new Font("Fahoma",Font.BOLD,20));
        l1.setBounds(270,20,200,30);
        add(l1);


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
        t2.setBounds(0,80,700,300);
        add(t2);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(170,430,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(350,430,120,30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,700,550);
        setVisible(true);

    }

    public static  void  main(String[] args){
        new Department().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            try{
                String str = "select * from department";

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
