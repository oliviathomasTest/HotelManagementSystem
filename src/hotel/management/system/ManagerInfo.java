package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;


public class ManagerInfo extends JFrame implements ActionListener {

    JTable t1;
    JButton b1,b2;

    ManagerInfo(){
        t1 = new JTable();
        t1.setRowHeight(30);
        t1.setGridColor(Color.BLACK);

        JTableHeader tableHeader = t1.getTableHeader();
        tableHeader.setBackground(Color.black);
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(new Font("Verdana",Font.PLAIN,16));


        JScrollPane t2 = new JScrollPane(t1);
        t2.setBounds(0,40,1000,500);
        LineBorder lb = new LineBorder(new Color(0, 0, 0, 0));
        t2.setBorder(lb);
        add(t2);

        b1 = new JButton("Load Data");
        b1.setBounds(250,550,110,35);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(400,550,110,35);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setBounds(450,200,1000,620);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            try{
                Conn c = new Conn();
                String str = "select * from employee where job='Manager'";
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

    public static void main(String[] args){
        new ManagerInfo().setVisible(true);
    }
}

