import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEquiry extends JFrame implements ActionListener {
    JButton b1;
    String cos_pin;
  BalanceEquiry(String cos_pin){

      this.cos_pin= cos_pin;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(800, 900, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel l2 = new JLabel(i3);
      l2.setBounds(0, 0, 900, 900);
      add(l2);

      b1 = new JButton("back");
      b1.setFont(new Font("System", Font.BOLD, 11));
      b1.setBackground(Color.ORANGE);
      b1.setForeground(Color.black);
      b1.setBounds(400, 500, 90, 30);
      l2.add(b1);
      b1.addActionListener(this);

      JLabel j1 = new JLabel("The current balance in your account is ");
      j1.setForeground(Color.white);
      j1.setFont(new Font("System", Font.BOLD, 16));
      j1.setBounds(200, 300, 600, 30);
      l2.add(j1);
      int balance = 0;

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s1.executeQuery("Select * from Bank where pin = '" + cos_pin + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("withdrawl")) {
                    balance-= Integer.parseInt(rs.getString("Amount"));
                } else if (rs.getString("type").equals("Deposit")) {
                    balance+= Integer.parseInt(rs.getString("Amount"));
                }



            }
        } catch (Exception e) {
            System.out.println(e);
        }
       JLabel j3 = new JLabel("RS: "+balance);
      j3.setBounds(200,330,300,35);
      j3.setFont(new Font("System",Font.BOLD,15));
      j3.setForeground(Color.GREEN);
      l2.add(j3);

      setLayout(null);
      setSize(900, 1080);
      setLocation(100, 0);
      getContentPane().setBackground(Color.GRAY);

      setVisible(true);





  }
  public void actionPerformed(ActionEvent ae){
      setVisible(false);
      new Transaction("").setVisible(true);

  }
  public static void main(String []args){
      new BalanceEquiry("");
  }
}
