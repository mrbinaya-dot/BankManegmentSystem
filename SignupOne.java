
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame {
    SignupOne(){
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        Random ran = new Random();
        long random= Math.abs(ran.nextLong()%9000L+1000L);
        JLabel formno = new JLabel("Application no: ".toUpperCase()  +  random);
        formno.setFont(new Font("Raleway",Font.BOLD,36));
        formno.setBounds(190,20,450,50);
         add(formno);

        JLabel personaldet = new JLabel("Page 1 : Personal Details");
        personaldet.setFont(new Font("Rale way",Font.BOLD,20));
        personaldet.setBounds(280,80,450,30);
        add(personaldet);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Rale way",Font.BOLD,20));
        name.setBounds(80,130,100,30);
        add(name);

        JTextField jname = new JTextField();
        jname.setFont(new Font("Rale way",Font.BOLD,20));
        jname.setBounds(290,130,300,30);
        add(jname);

        JLabel fathername = new JLabel("Father's Name:");
        fathername.setFont(new Font("Rale way",Font.BOLD,20));
        fathername.setBounds(80,180,150,30);
        add(fathername);

        JTextField jfathername = new JTextField();
        jfathername.setFont(new Font("Rale way",Font.BOLD,20));
        jfathername.setBounds(290,180,300,30);
        add(jfathername);


        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Rale way",Font.BOLD,20));
        dob.setBounds(80,230,150,30);
        add(dob);

       JDateChooser ch1 = new JDateChooser();
       ch1.setBounds(290,230,300,30);
       add(ch1);
        ch1.setForeground(Color.blue);


        JLabel dob1 = new JLabel("Gender:");
        dob1.setFont(new Font("Rale way",Font.BOLD,20));
        dob1.setBounds(80,280,150,30);
        add(dob1);

        JRadioButton radio = new JRadioButton("MALE");
        radio.setBounds(290,280,100,30);
        add(radio);

        JRadioButton radio2 = new JRadioButton("FEMALE");
        radio2.setBounds(390,280,100,30);
        add(radio2);

        ButtonGroup button = new ButtonGroup();
        button.add(radio2);
        button.add(radio);

        JLabel dob2 = new JLabel("Email Address:");
        dob2.setFont(new Font("Rale way",Font.BOLD,20));
        dob2.setBounds(80,330,150,30);
        add(dob2);

        JTextField jdob2 = new JTextField();
        jdob2.setFont(new Font("Rale way",Font.BOLD,20));
        jdob2.setBounds(290,330,300,30);
        add(jdob2);


        JLabel do1 = new JLabel("Maritial Status:");
        do1.setFont(new Font("Rale way",Font.BOLD,20));
        do1.setBounds(80,380,150,30);
        add(do1);

        JRadioButton married = new JRadioButton("Married");
        married.setBounds(290,380,100,30);
        add(married);

        JRadioButton umarried = new JRadioButton("Unmarried");
        umarried.setBounds(390,380,100,30);
        add(umarried);

        JRadioButton omarried = new JRadioButton("Other");
        omarried.setBounds(490,380,100,30);
        add(omarried);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(married);
        bg1.add(umarried);
        bg1.add(omarried);







        JLabel ob1 = new JLabel("Address:");
        ob1.setFont(new Font("Rale way",Font.BOLD,20));
        ob1.setBounds(80,430,150,30);
        add(ob1);
        JTextField job1 = new JTextField();
        job1.setFont(new Font("Rale way",Font.BOLD,20));
        job1.setBounds(290,430,300,30);
        add(job1);

        JLabel dob8 = new JLabel("City:");
        dob8.setFont(new Font("Rale way",Font.BOLD,20));
        dob8.setBounds(80,480,150,30);
        add(dob8);

        JTextField jdob8 = new JTextField();
        jdob8.setFont(new Font("Rale way",Font.BOLD,20));
        jdob8.setBounds(290,480,300,30);
        add(jdob8);


        JLabel dob5 = new JLabel("State:");
        dob5.setFont(new Font("Rale way",Font.BOLD,20));
        dob5.setBounds(80,530,150,30);
        add(dob5);

        JTextField jdob5 = new JTextField();
        jdob5.setFont(new Font("Rale way",Font.BOLD,20));
        jdob5.setBounds(290,530,300,30);
        add(jdob5);


        JLabel dob9 = new JLabel("Pin Code:");
        dob9.setFont(new Font("Rale way",Font.BOLD,20));
        dob9.setBounds(80,580,150,30);
        add(dob9);
        JTextField jdob9 = new JTextField();
        jdob9.setFont(new Font("Rale way",Font.BOLD,20));
        jdob9.setBounds(290,580,300,30);
        add(jdob9);

        JButton button2 = new JButton("Next");
        button2.setBackground(Color.white);
        button2.setBounds(360,630,70,30);
        button2.setForeground(Color.BLACK);
        add(button2);

    }

    public static void main(String[] args){
        new SignupOne();

    }
}
