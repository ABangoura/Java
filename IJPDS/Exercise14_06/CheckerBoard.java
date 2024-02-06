
/**
 * Book: Introduction to Java Programming and Data Structures, 11th Edition (Y. Daniel Liang). 
 * Exercise 14-06.
 * (Game: display a checkerboard) Write a program that displays a checkerboard in 
 * which each white and black cell is a Rectangle with a fill color black or white, 
 * as shown in Figure 14.44c.
 *
 * @author Almamy Bangoura
 * @version 2/5/24
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CheckerBoard extends Application {
    @Override
    public void start(Stage primaryStage) {
        final int NUMBER_OF_ROWS = 10; // Rows of a 10x10 checkerboard.
        final int NUMBER_OF_COLUMNS = 10; // Columns of a 10x10 checkerboard.
        Color squareColor; // Variable to hold the color of the square.
        
        // Create a grid pane to hold the different squares.
        GridPane gridPane = new GridPane();
        
        // Run a nested for-loop to create each square, 
        // set its color and place it in the grid.
        for(int row = 0; row < NUMBER_OF_ROWS; row++) {            
            for(int column = 0; column < NUMBER_OF_COLUMNS; column++) {
                // Create a new 50x50 pixels rectangle (a square).
                Rectangle rectangle = new Rectangle(50, 50);
                
                // Alternate square colors.
                squareColor = ((row % 2) == (column % 2)) ? Color.WHITE : Color.BLACK;
    
                rectangle.setFill(squareColor); // Set the square's color.
                gridPane.add(rectangle, row, column); // Add square to grid pane.
            }
        }
        
        // Create a scene and place it in the primary stage for displaying the checkerboard.
        Scene scene = new Scene(gridPane);
        
        primaryStage.setTitle("Checkerboard");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
}
