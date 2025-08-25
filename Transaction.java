

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String cos_pin;
    Transaction(String cos_pin){
        this.cos_pin = cos_pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));


        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(235,300,700,35);
        l2.add(l1);

        b1.setBounds(190,350,130,35);
        b1.setFont(new Font("System",Font.BOLD,10));

        l2.add(b1);

        b2.setBounds(380,350,130,35);
        b2.setFont(new Font("System",Font.BOLD,10));


        l2.add(b2);

        b3.setBounds(190,400,130,35);
        b3.setFont(new Font("System",Font.BOLD,10));
        l2.add(b3);

        b4.setBounds(380,400,130,35);
        b4.setFont(new Font("System",Font.BOLD,10));
        l2.add(b4);

        b5.setBounds(190,450,130,35);
        b5.setFont(new Font("System",Font.BOLD,10));
        l2.add(b5);

        b6.setBounds(380,450,130,35);
        b6.setFont(new Font("System",Font.BOLD,10));
        l2.add(b6);

        b7.setBounds(300,500,110,35);
        l2.add(b7);



        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setLayout(null);
        setSize(900,1080);
        setLocation(100,0);
        setUndecorated(true);
        getContentPane().setBackground(Color.GRAY);
        setVisible(true);





    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            setVisible(false);
            new Deposit(cos_pin).setVisible(true);
        }

       if(ae.getSource()==b7){
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Transaction("");
    }
}