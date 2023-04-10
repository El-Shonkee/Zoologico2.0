package View.Administrative;

import Control.CRUD.sellsControl;
import View.Menu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Administrative extends JFrame {
    private JButton reportButton;
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

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Model.Sells> sellsList = sellsControl.getSellsArrayList();

                try {
                    PDFGeneratorSells.generatePDFReport(sellsList);
                    JOptionPane.showMessageDialog(null, "Report has been generated successful");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error generating report" + ex.getMessage());
                    ex.printStackTrace();
                }
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
