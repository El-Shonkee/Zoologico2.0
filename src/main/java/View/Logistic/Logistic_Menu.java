package View.Logistic;

import Control.CRUD.animalsControl;
import Model.Animals;
import View.Menu;
import com.itextpdf.text.DocumentException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Logistic_Menu extends JFrame {
    private JPanel Logistic_menu;
    private JButton editAnimalsButton;

    private JButton addAnimalsButton;
    private JButton backButton;
    private JButton reportButton;

    public Logistic_Menu() {
        setContentPane(Logistic_menu);
        setTitle("Logistic Menu");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addAnimalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new add_animals();
                dispose();
            }
        });
        editAnimalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new editAnimal();
                dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                dispose();
            }
        });
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Animals> animalsList = animalsControl.getAnimalsArrayList();

                try{
                    PDFGeneratorAnimals.generatePDFReport(animalsList);
                    JOptionPane.showMessageDialog(null,"report has been generated successfully");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error generating report" + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }
}