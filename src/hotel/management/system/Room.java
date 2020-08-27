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

public class Room extends JFrame implements ActionListener
{
    JTable t1;
    JButton b1,b2;

    Room(){
        t1 = new JTable();
        t1.setGridColor(Color.BLACK);
        t1.setRowHeight(30);

        JTableHeader tableHeader = t1.getTableHeader();
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setBackground(Color.BLACK);
        tableHeader.setFont(new Font("Verdana",Font.PLAIN,14));

        JScrollPane t2 = new JScrollPane(t1);
        LineBorder lb = new LineBorder(new Color(0, 0, 0, 0));
        t2.setBorder(lb);
        t2.setBounds(0,40,630,400);
        add(t2);

        b1 = new JButton("Load Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.setBounds(100,460,120,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.setBounds(250,460,120,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(570,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(630,0,570,600);
        add(l1);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setBounds(260,200,1200,600);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == b1){
            Conn c = new Conn();
            String str = "select * from rooms";
            try
            {
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (SQLException e)
            {
                System.out.println(e);
                e.printStackTrace();
            }
        } else if(actionEvent.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args){
        new Room().setVisible(true);
    }
}
