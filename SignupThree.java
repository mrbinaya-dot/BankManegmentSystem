import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JLabel j1, j2, j3, j4, j5, j6, j7;
    JRadioButton jr1, jr2, jr3, jr4;
    JTextField jt1;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton b1, b2;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel j1 = new JLabel("Page 3 : Account Details");
        j1.setFont(new Font("Arial", Font.BOLD, 22));
        j1.setBounds(280, 40, 400, 40);
        add(j1);

        JLabel j2 = new JLabel("Account Type");
        j2.setFont(new Font("Arial", Font.BOLD, 20));
        j2.setBounds(60, 100, 180, 30);
        add(j2);

        jr1 = new JRadioButton("Saving Account");
        jr1.setFont(new Font("Monospaced", Font.BOLD, 14));
        jr1.setBounds(70, 140, 200, 30);
        add(jr1);

        jr2 = new JRadioButton("Fixed Deposit Account");
        jr2.setFont(new Font("Monospaced", Font.BOLD, 14));
        jr2.setBounds(280, 140, 300, 30);
        add(jr2);

        jr3 = new JRadioButton("Current Account");
        jr3.setFont(new Font("Monospaced", Font.BOLD, 14));
        jr3.setBounds(70, 180, 200, 30);
        add(jr3);

        jr4 = new JRadioButton("Recurring Deposit Account");
        jr4.setFont(new Font("Monospaced", Font.BOLD, 14));
        jr4.setBounds(280, 180, 300, 30);
        add(jr4);

        ButtonGroup group = new ButtonGroup();
        group.add(jr1);
        group.add(jr2);
        group.add(jr3);
        group.add(jr4);

        JLabel j3 = new JLabel("Card Number");
        j3.setFont(new Font("Arial", Font.BOLD, 20));
        j3.setBounds(60, 230, 180, 30);
        add(j3);

        JLabel jt1 = new JLabel("XXXX-XXXX-XXXX-3432");
        jt1.setFont(new Font("Arial", Font.BOLD, 20));
        jt1.setBounds(250, 230, 300, 30);
        add(jt1);
        JLabel j4 = new JLabel("(Your 14 digit card no)");
        j4.setFont(new Font("Arial", Font.ITALIC, 10));
        j4.setBounds(70, 250, 180, 30);
        add(j4);

        JLabel j5 = new JLabel("PIN:");
        j5.setFont(new Font("Arial", Font.BOLD, 20));
        j5.setBounds(100, 300, 180, 30);
        add(j5);

        JLabel jt2 = new JLabel("XXXX");
        jt2.setFont(new Font("Arial", Font.BOLD, 20));
        jt2.setBounds(250, 300, 300, 30);
        add(jt2);

        j6 = new JLabel("(Your 4 digit pin no)");
        j6.setFont(new Font("Arial", Font.ITALIC, 10));
        j6.setBounds(70, 320, 180, 30);
        add(j6);

        j7 = new JLabel("Service Required");
        j7.setFont(new Font("Arial", Font.BOLD, 20));
        j7.setBounds(60, 370, 180, 30);
        add(j7);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Arial", Font.BOLD, 14));
        c1.setBounds(60, 420, 200, 30);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Arial", Font.BOLD, 14));
        c2.setBounds(300, 420, 200, 30);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Arial", Font.BOLD, 14));
        c3.setBounds(60, 460, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL,SMS,ALERT");
        c4.setFont(new Font("Arial", Font.BOLD, 14));
        c4.setBounds(300, 460, 200, 30);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Arial", Font.BOLD, 14));
        c5.setBounds(60, 500, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Arial", Font.BOLD, 14));
        c6.setBounds(300, 500, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the  above given detail are all correct to best of my knowledge");
        c7.setFont(new Font("Arial", Font.BOLD, 11));
        c7.setBounds(60, 550, 600, 30);
        add(c7);

        JButton b1 = new JButton("Submit");
        b1.setFont(new Font("Arial", Font.BOLD, 13));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200, 600, 100, 30);
        add(b1);
        b1.addActionListener(this);

        JButton b2 = new JButton("Cancel");
        b2.setFont(new Font("Arial", Font.BOLD, 13));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(400, 600, 100, 30);
        add(b2);
        b2.addActionListener(this);


        getContentPane().setBackground(Color.LIGHT_GRAY);

        setSize(800, 1000);
        setLocation(350, 0);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {


        String atype = null;
        if (jr1.isSelected()) {
            atype = "Saving Account";
        } else if (jr2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (jr3.isSelected()) {
            atype = "Current Account";
        } else if (jr4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        String facility = "";
        if (c1.isSelected()) {
            facility = facility + " ATM Card";
        }
        if (c2.isSelected()) {
            facility = facility + " Internet Banking";
        }
        if (c3.isSelected()) {
            facility = facility + " Mobile Banking";
        }
        if (c4.isSelected()) {
            facility = facility + " EMAIL Alerts";
        }
        if (c5.isSelected()) {
            facility = facility + " Cheque Book";
        }
        if (c6.isSelected()) {
            facility = facility + " E-Statement";
        }


        try {
            Conn c11 = new Conn();
            String q2 = "insert into signup4 values('" + formno + "','" + atype + "','" + cardno + "','" + pin + "','" + facility + "')";
            c11.s1.executeUpdate(q2);
            String q3 = "insert into Login values('"+cardno+"','"+pin+"')";
            c11.s1.executeUpdate(q3);
      // FIXED
            JOptionPane.showMessageDialog(null, "Account Created Successfully!\nCard No: " + cardno + "\nPIN: " + pin);
            setVisible(false);
            new Deposit("").setVisible(true);
            // Navigate to next page or close
        } catch (Exception e) {
            System.out.println("Database Error: " + e);

        }
    }


        public static void main(String args[]) {
        new SignupThree("");

    }
}

