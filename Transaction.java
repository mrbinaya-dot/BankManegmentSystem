import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class Transaction extends JFrame {

    Transaction() {
        // Load image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 900, Image.SCALE_DEFAULT);

        // Wrap scaled image back in ImageIcon
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);

        // Set position and size
        j1.setBounds(0, 0, 700, 850);
        add(j1);







        // Layout and frame settings
        setLayout(null);  // Use absolute positioning
        setLocation(300, 0);
        setSize(700, 900);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Transaction();
    }
}





