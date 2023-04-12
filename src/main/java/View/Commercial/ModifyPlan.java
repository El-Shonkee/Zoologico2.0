package View.Commercial;

import Control.CRUD.plansControl;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import Model.Plans;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public ModifyPlan() {
        setContentPane(ModifyPlan);
        setTitle("Plan modification");
        setSize(500, 700);
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
                Path filePath = Paths.get("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\JSONS\\Plans.json");

                String namePlan = planNameTextField.getText();
                String descriptionPlan = descriptionPane.getText();
                String days = daysTextField.getText();
                String hours = hourTextField.getText();
                int pricePlan = Integer.parseInt(priceTextField.getText());
                int accountingPeople = peopleCounter.getComponentCount();
                String souvenir = souvenirTextField.getText();

                String newNamePlan = planNameTextField.getText(); // Obtener el nuevo nombre del plan

                JFrame frame = new JFrame();
                // Modificar el plan en el archivo JSON
                try {
                    boolean planModified = plansControl.modifyPlan(filePath, namePlan, newNamePlan, descriptionPlan, days, hours, pricePlan, accountingPeople, souvenir);
                    if (planModified) {
                        JOptionPane.showMessageDialog(frame, "The plan has been updated.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Plan cannot been updated.");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    plansControl.loadPlansFromJSON(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                new Commercial();
                dispose();
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
                int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure to delete this plan?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Obtener el plan seleccionado en el comboBox
                    Plans plan = plansControl.searchPlan(selectPlanBox.getSelectedItem().toString());
                    // Eliminar el plan de la lista de planes
                    plansControl.removePlan(plan);

                    // Actualizar el archivo JSON
                    ObjectMapper objectMapper = new ObjectMapper();
                    Path filePath = Paths.get("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\JSONS\\Plans.json");
                    try {
                        objectMapper.writeValue(filePath.toFile(), plansControl.plansArrayList);
                        JOptionPane.showMessageDialog(null, "Plan has been deleted successfully");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error in the process");
                        ex.printStackTrace();
                    }
                    plansControl.updatePlanNames(); // actualiza la lista de nombres de planes
                    Object[] plansArray = plansControl.planNames.toArray();
                    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(plansArray);
                    selectPlanBox.setModel(comboBoxModel);
                }
                new Commercial();
                dispose();
                }
        });

    }
}

