import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  //create the labels
  JLabel fahLabel;
  JLabel celLabel;

  //create the text fields
  JTextField fahField;
  JTextField celField;

  //create the buttons
  JButton convertToCelButton;
  JButton convertToFahButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Temperature Converter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the class variables
    mainPanel = new JPanel();

    fahLabel = new JLabel("Degrees Fahrenheit");
    celLabel = new JLabel("Degrees Celsius");

    fahField = new JTextField();
    celField = new JTextField();

    convertToCelButton = new JButton("F -> C");
    convertToFahButton = new JButton("C -> F");

    //set class variable bounds
    fahLabel.setBounds(30, 30, 150, 20);
    celLabel.setBounds(30, 55, 150, 20);

    fahField.setBounds(185, 30, 50, 20);
    celField.setBounds(185, 55, 50, 20);

    convertToCelButton.setBounds(240, 30, 80, 20);
    convertToFahButton.setBounds(240, 55, 80, 20);

    //add class variables to main panel
    mainPanel.add(fahLabel);
    mainPanel.add(celLabel);

    mainPanel.add(fahField);
    mainPanel.add(celField);

    mainPanel.add(convertToCelButton);
    mainPanel.add(convertToFahButton);

    
    //add action listeners to the buttons
    convertToCelButton.addActionListener(this);
    convertToFahButton.addActionListener(this);

    //give the buttons action commands
    convertToCelButton.setActionCommand("cel");
    convertToFahButton.setActionCommand("fah");

    //turn on manual layouts
    mainPanel.setLayout(null);

    //add main panel to the frame
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    
    //make a variable to hold the temperature as a double
    double temp = 0;
    //make a variable to hold the temperature as a String
    String tempString = "";

    //check what you are converting to
    if(command.equals("cel")){
      //get temperature and convert it into a double
      tempString = fahField.getText();
      temp = Double.parseDouble(tempString);
      //convert the temperature to celsius
      temp = (temp - 32) * 1.8;
      //make the celsius field say the converted temperature
      celField.setText("" + temp);
    }else{
      //get temperature and convert it into adouble
      tempString = celField.getText();
      temp = Double.parseDouble(tempString);
      //convert the temperature to fahrenhiet
      temp = (temp * 1.8) + 32;
      //make the fahrenhiet field say the converted temperature
      fahField.setText("" + temp);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
