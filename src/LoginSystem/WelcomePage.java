package LoginSystem;

import javax.swing.*;
import java.awt.*;

public class WelcomePage {
    private JFrame frame = new JFrame();
    private JLabel welcomeLabel = new JLabel();

    public WelcomePage(String userID) {

        welcomeLabel.setBounds(0, 0, 200, 35);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 15));
        welcomeLabel.setText("Welcome, " + userID);

        frame.add(welcomeLabel);
        frame.setTitle("Welcome page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
