import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class MiniStatement extends JFrame implements ActionListener {
    JLabel l3 ,l4;
    JButton b;
    String cos_pin;
    MiniStatement(String cos_pin){
        this.cos_pin= cos_pin;
        JLabel l1 = new JLabel("Nepal Bank Limited" );
        l1.setBounds(250,50,500,50);
        l1.setFont(new Font("System",Font.BOLD, 40));
        l1.setForeground(Color.black);
        add(l1);

        JLabel l2 = new JLabel("Account No:" );
        l2.setBounds(100,150,300,30);
        l2.setFont(new Font("System",Font.BOLD, 20));
        l2.setForeground(Color.black);
        add(l2);
        l3 = new JLabel();
        l3.setBounds(230,150,300,30);
        l3.setFont(new Font("System",Font.BOLD, 20));
        l3.setForeground(Color.black);
        add(l3);
        l4 = new JLabel();
        l4.setBounds(100,200,500,30);
        l4.setFont(new Font("System",Font.ITALIC, 15));
        l4.setForeground(Color.black);
        add(l4);

        b = new JButton("Back");
        b.setFont(new Font("System", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(450, 600, 90, 30);
        add(b);
        b.addActionListener(this);

        Conn c1 = new Conn();

        try {
            ResultSet rs = c1.s1.executeQuery("Select * from login where customer_pin ='" +cos_pin+ "'");
            while (rs.next()){
                l3.setText(rs.getString("customer_id").substring(0,4)+"XXXXXXXX"+rs.getString("customer_id").substring(12));
                }


        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
           ResultSet rs1 =c1.s1.executeQuery("select * from Bank where pin = '"+cos_pin+"'");
           while (rs1.next()){
               l4.setText(l4.getText()+ "<html>"+rs1.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs1.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs1.getString("Amount")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<br><br></html>");
           }

        }catch(Exception ec){
        System.out.println(ec);
        }

        setLayout(null);
        setSize(900, 1080);
        setLocation(100, 0);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction("").setVisible(true);
    }
    public static void main (String[] args){
        new MiniStatement("");
    }

}
