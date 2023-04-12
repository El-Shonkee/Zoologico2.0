package View.Logistic;

import View.Menu;
import Control.CRUD.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import Model.Animals;
import com.fasterxml.jackson.databind.ObjectMapper;


public class editAnimal extends JFrame{
    private JComboBox selectIDComboBox;
    private JTextField nameTextField;
    private JTextField speciesTextField;
    private JTextField ageTextField;
    private JTextField weightTextField;
    private JButton finishButton;
    private JButton cancelButton;
    private JPanel editAnimalPanel;
    private JButton deleteAnimalButton;
    private JTextField genderTextField;
    private JTextField zoneTextField;

    public editAnimal() {
        setContentPane(editAnimalPanel);
        setTitle("Edit Animal");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        Object[] animalsArray = animalsControl.animalsIDs.toArray();
        Object[] animalsArrayWithName = new Object[animalsArray.length];

        for (int i = 0; i < animalsArray.length; i++) {
            int id = (int) animalsArray[i];
            String name = animalsControl.searchAnimal(id).getName();
            String displayString = id + " - " + name;
            animalsArrayWithName[i] = displayString;
        }
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(animalsArrayWithName);
        selectIDComboBox.setModel(comboBoxModel);
        selectIDComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) selectIDComboBox.getSelectedItem();
                int selectedID = Integer.parseInt(selectedItem.split(" ")[0]);
                Animals animal = animalsControl.searchAnimal(selectedID);
                nameTextField.setText(animal.getName());
                speciesTextField.setText(animal.getSpecies());
                ageTextField.setText(String.valueOf(animal.getAge()));
                weightTextField.setText(String.valueOf(animal.getWeight()));
                genderTextField.setText(animal.getGender());
                zoneTextField.setText(animal.getZone());
            }
        });
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path filePath = Paths.get("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\JSONS\\Animals.json");
                String selectedItem = (String) selectIDComboBox.getSelectedItem();
                int selectedID = Integer.parseInt(selectedItem.split(" ")[0]);

                String name = nameTextField.getText();
                String species = speciesTextField.getText();
                float age = Float.parseFloat(ageTextField.getText());
                float weight = Float.parseFloat(weightTextField.getText());
                String gender = genderTextField.getText();
                String zone = zoneTextField.getText();
                String newNameAnimal = nameTextField.getText();

                JFrame frame = new JFrame();

                try{
                    boolean animalModified = animalsControl.modifyAnimal(filePath,selectedID,name,gender,species,age,weight,zone);
                    if(animalModified){
                        JOptionPane.showMessageDialog(frame,"The animal has been updated");
                    }else{
                        JOptionPane.showMessageDialog(frame,"Animal cannot been updated");
                    }
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                try{
                    animalsControl.loadAnimalsFromJSON(filePath);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                new Logistic_Menu();
                dispose();
            }
        });
        deleteAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure to delete this plan?", "Delete confirmation", JOptionPane.YES_NO_OPTION);

                if(confirmation == JOptionPane.YES_OPTION){
                    String selectedItem = (String) selectIDComboBox.getSelectedItem();
                    int selectedID = Integer.parseInt(selectedItem.split(" ")[0]);
                    Animals animal = animalsControl.searchAnimal(selectedID);

                    animalsControl.deleteAnimal(animal);

                    ObjectMapper objectMapper = new ObjectMapper();
                    Path filePath = Paths.get("C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\JSONS\\Animals.json");

                    try{
                        objectMapper.writeValue(filePath.toFile(),animalsControl.animalsArrayList);
                        JOptionPane.showMessageDialog(null,"Animal has been deleted successfully ");
                    }catch (IOException ex){
                        JOptionPane.showMessageDialog(null,"Error in the process");
                        ex.printStackTrace();
                    }
                    animalsControl.updateAnimalIDs();
                    Object[] animalsArray = animalsControl.animalsIDs.toArray();
                    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(animalsArray);
                    selectIDComboBox.setModel(comboBoxModel);
                }
                new Logistic_Menu();
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Logistic_Menu();
                dispose();
            }
        });
    }
}
