package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import net.proteanit.sql.DbUtils;

public class Customerinfo extends JFrame implements ActionListener {
    JButton b1,b2;
    JTable table;

    Customerinfo(){

        table = new JTable();
        table.setRowHeight(30);
        table.setGridColor(Color.BLACK);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(Color.black);
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(new Font("Verdana",Font.PLAIN,14));


        JScrollPane t2 = new JScrollPane(table);
        t2.setBounds(0,40,1000,480);
        LineBorder lb = new LineBorder(new Color(0, 0, 0, 0));
        t2.setBorder(lb);
        add(t2);

        b1 = new JButton("Load Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(300,530,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        b2.setBounds(480,530,120,30);
        add(b2);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setBounds(340,200,1000,600);
    }

    public static  void main(String[] args){
        new Customerinfo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            try
            {
                Conn c = new Conn();
                String str = "select * from customer";
                ResultSet rs = c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));
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
