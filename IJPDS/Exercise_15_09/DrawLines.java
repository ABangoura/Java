/**
 * Book: Introduction to Java Programming and Data Structures, 11th Edition (Y. Daniel Liang). 
 * Exercise 15_09.
 * (Draw lines using the arrow keys) Write a program that draws line segments
 * using the arrow keys. The line starts from (100, 100) in the pane and draws
 * toward east, north, west, or south when the right-arrow key, up-arrow key, 
 * leftarrow key, or down-arrow key is pressed, as shown in Figure 15.28b.
 * 
 * @author Almamy Bangoura
 * @version 2/27/24
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class DrawLines extends Application {
    // Starting point.
    private double startX = 100;
    private double startY = 100;
    private double endX = 100;
    private double endY = 100;
    
    @Override
    public void start(Stage primaryStage) {
        // Create a Pane for the drawing area.
        Pane pane = new Pane();
        
        // Create the starting point (100, 100).
        Line line = new Line(startX, startY, endX, endY);
        
        // Add starting point to the pane.
        pane.getChildren().add(line);
        
        // Define an event handler for the different arrow keys.
        line.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case RIGHT: // If user pressed right arrow key, draw line segment to the right.
                    line.setStartX(line.getEndX());
                    line.setStartY(line.getEndY());
                    line.setEndX(line.getStartX() + 10);
                    line.setEndY(line.getEndY());
                    break;
                case LEFT: // If user pressed left arrow key, draw line segment to the left.
                    line.setStartX(line.getEndX());
                    line.setStartY(line.getEndY());
                    line.setEndX(line.getStartX() - 10);
                    line.setEndY(line.getEndY());
                    break;
                case DOWN: // If user pressed down arrow key, draw line segment towards the bottom.
                    line.setStartX(line.getEndX());
                    line.setStartY(line.getStartY());
                    line.setEndX(line.getEndX());
                    line.setEndY(line.getEndY() + 10);
                    break;
                case UP: // If user pressed up arrow key, draw line segment towards the top.
                    line.setStartX(line.getEndX());
                    line.setStartY(line.getStartY());
                    line.setEndX(line.getEndX());
                    line.setEndY(line.getEndY() - 10);
                    break;
                default:       
            }
            
            // Add the new line segment to the pane.
            pane.getChildren().add(new Line(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY()));
        });
        
        // Create a scene and add the pane.
        Scene scene = new Scene(pane, 500, 300);
        
        // Display the scene in the stage.
        primaryStage.setTitle("Exercise_15_09");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Set the input focus on the line.
        line.requestFocus();
    }
}
