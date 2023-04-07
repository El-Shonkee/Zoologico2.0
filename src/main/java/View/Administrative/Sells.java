package View.Administrative;

import Model.*;
import Control.CRUD.*;
import Control.CRUD.plansControl;
import Control.CRUD.ObjectToFileWriter;


import javax.swing.*;
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

    public Sells(){

        setContentPane(sellPanel);
        setTitle("Sells");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        //Spinner only can take positive values
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);

        spinnerQuantitySells.setModel(model);
        spinnerAdults.setModel(model1);
        spinnerChildren.setModel(model2);

        Plans plan1 = new Plans("Plan A", "Descripción del Plan A", "Lunes a Viernes", "9:00 - 17:00", 200, 10, "Camiseta", true);
        Plans plan2 = new Plans("Plan B", "Descripción del Plan B", "Sábado y Domingo", "10:00 - 18:00", 300, 20, "Taza", false);

        plansControl.addPlan(plan1);
        plansControl.addPlan(plan2);

        Object[] plansArray = plansControl.planNames.toArray();

        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(plansArray);
        planSelector.setModel(comboBoxModel);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plans plan = plansControl.searchPlan(planSelector.getSelectedItem().toString());
                String name = userNameTextField.getText();
                String id = userIDTextField.getText();
                int age = Integer.parseInt(userAgeTextField.getText());
                String email = userEmailTextField.getText();
                String phone = userNumberTextField.getText();
                int quantitySell = (int)spinnerQuantitySells.getValue();
                int adultsQuan = (int)spinnerAdults.getValue();
                int childrenQuan = (int)spinnerChildren.getValue();
                int priceSell = Integer.parseInt(formattedTextFieldPrice.getText());

                if(plan.isChildren() && (childrenQuan>0 || childrenQuan==0)){
                    Users user = new Users(name,id,age,email,phone);
                    usersControl.addUser(user);
                    Model.Sells sell = new Model.Sells(plan,user,quantitySell,adultsQuan,childrenQuan,priceSell);
                    sellsControl.addSell(sell);
                    System.out.println(sellsControl.sellsArrayList.toString());

                    String fileName = "Sells.json";
                    ObjectToJsonFileWriter.saveInFile(sell,fileName);

                    ObjectToFileWriter.saveInDocument(sell, "C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\sellReport.txt");

                }else{
                    System.out.println("Children are not allowed for this plan");
                }
                resetForm();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Administrative();
                dispose();
            }
        });

        planSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String planSelected = (String) planSelector.getSelectedItem();

                    Plans priceFinder=plansControl.searchPlan(planSelected);

                formattedTextFieldPrice.setValue(priceFinder.getPricePlan()*(int)spinnerQuantitySells.getValue());
            }
        });
    }

    private void resetForm(){
        userNameTextField.setText("");
        userIDTextField.setText("");
        userAgeTextField.setText("");
        userEmailTextField.setText("");
        userNumberTextField.setText("");
        spinnerQuantitySells.setValue(0);
        spinnerAdults.setValue(0);
        spinnerChildren.setValue(0);
        formattedTextFieldPrice.setText("");
    }
}
