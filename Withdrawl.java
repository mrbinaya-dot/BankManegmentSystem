import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Withdrawl extends JFrame implements ActionListener {
    JButton b, b1;
    JTextField jt1;
    String cos_pin;

    Withdrawl(String cos_pin) {
        this.cos_pin = cos_pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
        add(l2);

        JLabel j1 = new JLabel("Enter the amount you want to Withdraw");
        j1.setForeground(Color.white);
        j1.setFont(new Font("System", Font.BOLD, 16));
        j1.setBounds(200, 300, 700, 30);
        l2.add(j1);

        jt1 = new JTextField();
        jt1.setForeground(Color.BLACK);
        jt1.setFont(new Font("System", Font.BOLD, 16));
        jt1.setBounds(200, 350, 300, 30);
        l2.add(jt1);

        b = new JButton("Back");
        b.setFont(new Font("System", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(210, 400, 90, 30);
        l2.add(b);
        b.addActionListener(this);

        b1 = new JButton("Withdraw");
        b1.setFont(new Font("System", Font.BOLD, 11));
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.black);
        b1.setBounds(400, 400, 90, 30);
        l2.add(b1);
        b1.addActionListener(this);


        setLayout(null);
        setSize(900, 1080);
        setLocation(100, 0);

        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String number = jt1.getText();
            Date date = new Date();
            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "please enter the amount first!!!");

            } else {
                try {
                    Conn c1 = new Conn();
                    String q1 = "INSERT into Bank values('" + cos_pin + "','" + date + "','withdrawl','" + number + "')";
                    c1.s1.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Given Amount Withdrawl");
                    new Transaction("").setVisible(true);
                    setVisible(false);


                } catch (Exception ex) {
                    System.out.println(ex);

                }
            }

        } else if (ae.getSource() == b) {
            setVisible(false);
            new Transaction(cos_pin).setVisible(true);


        }



    }


    public static void main (String[]args){
        new Withdrawl("");

    }
}


