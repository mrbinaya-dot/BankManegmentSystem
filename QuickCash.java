

import com.sun.source.tree.WhileLoopTree;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;
import javax.swing.*;

public class QuickCash extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String cos_pin;
    QuickCash(String cos_pin){
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


        b1 = new JButton("RS 100");
        b2 = new JButton("RS 500");
        b3 = new JButton("RS 1000");
        b4 = new JButton("RS 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
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


        if(ae.getSource()==b7){
            System.exit(0);
        }
        else {
            String number = ((JButton)ae.getSource()).getText().substring(3);
            Conn c1 = new Conn();
            try{
                ResultSet rs =c1.s1.executeQuery("Select * from Bank where pin = '"+cos_pin+"'");
                int  balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }else {
                            balance-=Integer.parseInt(rs.getString("amount"));
                        }
                    }
                  if (ae.getSource()!=b7 && balance >= Integer.parseInt(number)) {
                      JOptionPane.showMessageDialog(null, "Insufficient Balance");
                  }  else{
                        Date date = new Date();
                        String qr ="insert into Bank values ('"+cos_pin+"','"+date+"','withdrawl','"+number+"')";
                        c1.s1.executeUpdate(qr);
                        JOptionPane.showMessageDialog(null,"Transaction sucessful "+number);
                        setVisible(false);
                        new Transaction("").setVisible(true);


                    }




            }catch (Exception ex){
                System.out.println(ex);
            }

        }
    }

    public static void main(String[] args){
        new QuickCash("");
    }
}