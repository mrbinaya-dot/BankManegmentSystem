import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton b, b1;
    JTextField t1,t2;
    String cos_pin;
    PinChange(String cos_pin) {
        this.cos_pin=cos_pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 900);
       add(l2);


        JLabel j1 = new JLabel("Change your pin ");
        j1.setForeground(Color.white);
        j1.setFont(new Font("System", Font.BOLD, 16));
        j1.setBounds(200, 300, 700, 30);
        l2.add(j1);

        JLabel j2 = new JLabel("New PIN ");
        j2.setBounds(190,350,300,35);
        j2.setFont(new Font("System",Font.BOLD,15));
        j2.setForeground(Color.WHITE);
        l2.add(j2);

         t1 = new JTextField();
        t1.setBounds(300,350,200,35);
        t1.setFont(new Font("System",Font.BOLD,15));
        t1.setForeground(Color.BLACK);
        l2.add(t1);

         t2 = new JTextField();
        t2.setBounds(300,410,200,35);
        t2.setFont(new Font("System",Font.BOLD,15));
        t2.setForeground(Color.BLACK);
        l2.add(t2);


        JLabel j3 = new JLabel("Re-Enter PIN ");
        j3.setBounds(190,410,300,35);
        j3.setFont(new Font("System",Font.BOLD,15));
        j3.setForeground(Color.WHITE);
        l2.add(j3);

        b = new JButton("Back");
        b.setFont(new Font("System", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(210, 500, 90, 30);
        l2.add(b);
        b.addActionListener(this);

        b1 = new JButton("Change");
        b1.setFont(new Font("System", Font.BOLD, 11));
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.black);
        b1.setBounds(400, 500, 90, 30);
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

                String pin = t1.getText();
                String npin = t2.getText();
            try {


                 if (pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "please enter the pin");
                    return;


                }  if (npin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "please re-enter the pin");
                    return;
                }
                 if (!pin.equals(npin)) {
                     JOptionPane.showMessageDialog(null, "Entered pin doesn't match ");
                     return;
                 }

                 Conn c1 = new Conn();
                 String q1 = "update Bank set pin ='"+npin+"'where pin = '"+cos_pin+"'";
                String q2 = "update signup4 set pin ='"+npin+"'where pin = '"+cos_pin+"'";
                String q3 = "update login set customer_pin ='"+npin+"'where customer_pin = '"+cos_pin+"'";
                c1.s1.executeUpdate(q1);
                c1.s1.executeUpdate(q2);
                c1.s1.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "pin change sucessful ");




            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transaction("").setVisible(true);
        }

    }




    public static void main(String[] args ){
         new PinChange("");


    }


}
