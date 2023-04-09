package View.Commercial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.CRUD.*;
import Model.Plans;

public class ModifyPlan extends JFrame {
    private JPanel ModifyPlan;
    private JComboBox selectPlanBox;
    private JTextField planNameTextField;
    private JTextField daysTextField;
    private JTextField hourTextField;
    private JTextField priceTextField;
    private JSpinner peopleCounter;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JButton acceptButton;
    private JButton backButton;
    private JEditorPane descriptionPane;
    private JLabel selectPlanLabel;
    private JLabel planNameLabel;
    private JLabel descriptionLabel;
    private JLabel daysLabel;
    private JLabel hourLabel;
    private JLabel priceLabel;
    private JLabel peopleLabel;
    private JLabel childrenLabel;
    private JLabel souvenirLabel;
    private JTextField souvenirTextField;
    private JButton removePlanButton;

    public ModifyPlan(){
        setContentPane(ModifyPlan);
        setTitle("Plan modification");
        setSize(500,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Object[] plansArray = plansControl.planNames.toArray();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(plansArray);
        selectPlanBox.setModel(comboBoxModel);

        selectPlanBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plans plan = plansControl.searchPlan(selectPlanBox.getSelectedItem().toString());
                planNameTextField.setText(plan.getNamePlan());
                descriptionPane.setText(plan.getDescriptionPlan());
                daysTextField.setText(plan.getDays());
                hourTextField.setText(plan.getHours());
                priceTextField.setText(String.valueOf(plan.getPricePlan()));
                peopleCounter.setValue(plan.getAccountingPeople());
                yesRadioButton.setSelected(plan.isChildren());
                souvenirTextField.setText(plan.getSouvenir());
            }
        });

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Commercial();
                dispose();

            }
        });
        removePlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }


}
