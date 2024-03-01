/**
 * Book: Introduction to Java Programming and Data Structures, 11th Edition (Y. Daniel Liang). 
 * Exercise 15_10.
 * (Enter and display a string) Write a program that receives a string from the
 * keyboard and displays it on a pane. The Enter key signals the end of a string.
 * Whenever a new string is entered, it is displayed on the pane.
 *
 * @author Almamy Bangoura
 * @version 2/29/24
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class DisplayString extends Application{
    // Text variable to hold user input.
    private Text text = new Text("");
    
    @Override
    public void start(Stage primaryStage) {
      // Create a pane for displaying the text.
      StackPane pane = new StackPane();
      pane.getChildren().add(text);
      
      // Create a textfield for the user to enter a string.
      TextField textField = new TextField();
      
      // Create a border pane to hold both the pane and textfield.
      BorderPane borderPane = new BorderPane();
      borderPane.setCenter(pane);
      borderPane.setBottom(textField);
      
      // Set up the keyboard 'Enter' key event handler.
      textField.setOnKeyPressed(e -> {
          if(e.getCode() == KeyCode.ENTER) { // If the user pressed the 'Enter' key...
              text.setText(textField.getText()); // ... then update the text with user input.
              textField.setText(""); // Set the textfield to an empty string.
            }
      });
      
      // Create a scene and place the borderpane in it.
      Scene scene = new Scene(borderPane, 500, 300);
      
      // Place the scene in the stage and display it.
      primaryStage.setTitle("Display a String");
      primaryStage.setScene(scene);
      primaryStage.show();
    }
}
