package View.Administrative;

import Model.*;
import Control.CRUD.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Sells extends JFrame {
    private JPanel sellPanel;
    private JSpinner spinnerAdults;
    private JSpinner spinnerQuantitySells;
    private JComboBox planSelector;
    private JSpinner spinnerChildren;
    private JButton acceptButton;
    private JButton cancelButton;
    private JTextField userNameTextField;
    private JTextField userIDTextField;
    private JTextField userEmailTextField;
    private JTextField userNumberTextField;
    private JTextField userAgeTextField;
    private JFormattedTextField formattedTextFieldPrice;

    private boolean canAccept = true;
    public Sells() {

        setContentPane(sellPanel);
        setTitle("Sells");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        //Spinner only can take positive values
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
        SpinnerNumberModel model1 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
        SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

        spinnerQuantitySells.setModel(model);
        spinnerAdults.setModel(model1);
        spinnerChildren.setModel(model2);

        //Planes de prueba
        Plans plan1 = new Plans("Plan A", "Descripción del Plan A", "Lunes a Viernes", "9:00 - 17:00", 200, 10, "Camiseta", true);
        Plans plan2 = new Plans("Plan B", "Descripción del Plan B", "Sábado y Domingo", "10:00 - 18:00", 300, 20, "Taza", false);
        plansControl.addPlan(plan1);
        plansControl.addPlan(plan2);

        Object[] plansArray = plansControl.planNames.toArray();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(plansArray);
        planSelector.setModel(comboBoxModel);

        planSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String planSelected = (String) planSelector.getSelectedItem();
                Plans priceFinder = plansControl.searchPlan(planSelected);
                formattedTextFieldPrice.setValue(priceFinder.getPricePlan() * (int) spinnerQuantitySells.getValue());
            }
        });

        // Método para actualizar la variable canAccept

// Controlador de cambio para spinnerQuantitySells
        spinnerQuantitySells.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String planSelected = (String) planSelector.getSelectedItem();
                Plans priceFinder = plansControl.searchPlan(planSelected);
                formattedTextFieldPrice.setValue(priceFinder.getPricePlan() * (int) spinnerQuantitySells.getValue());

                updateCanAccept(); // actualizar la variable canAccept
            }
        });

// Controlador de cambio para spinnerAdults
        spinnerAdults.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateCanAccept(); // actualizar la variable canAccept
            }
        });

// Controlador de cambio para spinnerChildren
        spinnerChildren.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateCanAccept(); // actualizar la variable canAccept
            }
        });

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (canAccept) {
                    Plans plan = plansControl.searchPlan(planSelector.getSelectedItem().toString());
                    String name = userNameTextField.getText();
                    String id = userIDTextField.getText();
                    int age = Integer.parseInt(userAgeTextField.getText());
                    String email = userEmailTextField.getText();
                    String phone = userNumberTextField.getText();
                    int quantitySell = (int) spinnerQuantitySells.getValue();
                    int adultsQuan = (int) spinnerAdults.getValue();
                    int childrenQuan = (int) spinnerChildren.getValue();
                    int priceSell = (int)formattedTextFieldPrice.getValue();

                    Users user = new Users(name, id, age, email, phone);
                    usersControl.addUser(user);
                    Model.Sells sell = new Model.Sells(plan, user, quantitySell, adultsQuan, childrenQuan, priceSell);
                    sellsControl.addSell(sell);
                    System.out.println(sellsControl.sellsArrayList.toString());

                    ObjectToFileWriter.saveInDocument(sell, "C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\sellReport.txt");
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot accept the sale. The plan has limited capacity.");
                }

                resetForm();
                new Administrative();
                dispose();
                }
            });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Administrative();
                dispose();
            }
        });
    }

    private void updateCanAccept(){
        String planSelected = (String) planSelector.getSelectedItem();
        Plans accountingPeople = plansControl.searchPlan(planSelected);

        int adults = (int) spinnerAdults.getValue();
        int children = (int) spinnerChildren.getValue();
        int totalPeople = adults + children;

        // Verificar si el número de personas es mayor que el límite del plan
        if (totalPeople > accountingPeople.getAccountingPeople()) {
            JOptionPane.showMessageDialog(null, "The plan is only for " + accountingPeople.getAccountingPeople());
            canAccept = false;
        } else if (!accountingPeople.isChildren() && children > 0) {
            JOptionPane.showMessageDialog(null, "Children are not allowed for this plan");
            canAccept = false;
        } else {
            canAccept = true;
        }
    }

    private void resetForm(){
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
        userNameTextField.setText("");
        userIDTextField.setText("");
        userAgeTextField.setText("");
        userEmailTextField.setText("");
        userNumberTextField.setText("");
        spinnerQuantitySells.setModel(model);
        spinnerAdults.setValue(0);
        spinnerChildren.setValue(0);
        formattedTextFieldPrice.setText("");
    }

}
