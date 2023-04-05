package View.Commercial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyPlan extends JFrame {
    private JPanel ModifyPlan;
    private JComboBox selectPlanBox;
    private JTextField planName;
    private JTextField daysTextField;
    private JTextField hourTextField;
    private JTextField PriceTextField;
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

    public ModifyPlan(){
        setContentPane(ModifyPlan);
        setTitle("Plan modification");
        setSize(500,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

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
    }


}
