package View.Commercial;

import Model.Plans;
import View.Menu;
import Control.CRUD.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Commercial extends JFrame {
    private JButton reportButton;
    private JButton modifyPlanButton;
    private JButton createPlanButton;
    private JButton backButton;
    private JPanel commercialMenu;

    public Commercial() {

        setContentPane(commercialMenu);
        setTitle("Commercial menu");
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        createPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreatePlan();
                dispose();
            }
        });

        modifyPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifyPlan();
                dispose();
            }
        });

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Plans> plansList = plansControl.getPlansArrayList();

                try {
                    PDFGeneratorPlans.generatePDFReport(plansList);
                    JOptionPane.showMessageDialog(null, "Report has been generates succesfully");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error generating report" + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().setVisible(true);
                dispose();
            }
        });
    }
}
