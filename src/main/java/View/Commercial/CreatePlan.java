package View.Commercial;

import Control.CRUD.ObjectToJsonFileWriter;
import Model.Plans;
import Control.CRUD.plansControl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreatePlan extends JFrame  {
    private JPanel createPlan;
    private JTextField daysTextField;
    private JSpinner spinnerPeople;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JButton backButton;
    private JLabel CreatePlan;
    private JButton acceptButton;
    private JTextField PlanNameTextField;
    private JTextPane descriptionTextPane;
    private JTextField hourTextField;
    private JTextField priceTextField;
    private JTextField souvenirTextField;

    public CreatePlan(){
        setContentPane(createPlan);
        setTitle("Plan creation");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String planName = PlanNameTextField.getText();
                String planDescription = descriptionTextPane.getText();
                String planDays = daysTextField.getText();
                String planHours = hourTextField.getText();
                int planPrice = Integer.parseInt(priceTextField.getText());
                int accountPeople = (int)spinnerPeople.getValue();
                String planSouvenir = souvenirTextField.getText();
                boolean children = yesRadioButton.isSelected();

                Plans plan = new Plans(planName,planDescription,planDays,planHours,planPrice,accountPeople,planSouvenir,children);
                plansControl.addPlan(plan);

                String planFileName = "Plans.json";
                ObjectToJsonFileWriter.appendToFile(plan,planFileName);

                PlanNameTextField.setText("");
                descriptionTextPane.setText("");
                daysTextField.setText("");
                hourTextField.setText("");
                priceTextField.setText("");
                spinnerPeople.setValue(0);
                souvenirTextField.setText("");
                yesRadioButton.setSelected(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Commercial();
                dispose();
            }
        });
    }

}
