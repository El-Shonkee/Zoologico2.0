package View.Logistic;

import Control.CRUD.ObjectToJsonFileWriter;
import Control.CRUD.animalsControl;
import Model.Animals;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_animals extends JFrame {
    private JButton finishButton;
    private JTextField nameAnimal;
    private JTextField speciesAnimal;
    private JTextField ageAnimal;
    private JTextField weightAnimal;
    private JButton cancelButton;
    private JPanel addAnimals;
    private JTextField typeAnimal;
    private JTextField zoneAnimal;

    public add_animals(){
        setContentPane(addAnimals);
        setTitle("Add animals");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= nameAnimal.getText();
                int age= Integer.parseInt(ageAnimal.getText());
                String specie= speciesAnimal.getText();
                float weight= Float.parseFloat(weightAnimal.getText());
                String gender= typeAnimal.getText();
                String zone= zoneAnimal.getText();

                Animals animal= new Animals(name,gender,specie,age,weight,zone);
                animalsControl.addAnimal(animal);

                String animalFilename = "C:\\Users\\shonk\\OneDrive\\Escritorio\\Zoologico 2.0\\JSONS\\Animals.json";
                ObjectToJsonFileWriter.appendToFile(animal,animalFilename);

                nameAnimal.setText("");
                ageAnimal.setText("");
                speciesAnimal.setText("");
                weightAnimal.setText("");
                typeAnimal.setText("");
                zoneAnimal.setText("");
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
