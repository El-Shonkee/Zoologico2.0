package View.Administrative;

import View.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrative extends JFrame {
    private JButton reportButton1;
    private JButton sellButton;
    private JButton backButton;
    private JPanel administrativePanel;

    public Administrative() {
        setContentPane(administrativePanel);
        setTitle("Administrative");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sells();
                dispose();
            }
        });

        reportButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu();
            }
        });
    }

}
