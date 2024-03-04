/**
 * Book: Introduction to Java Programming and Data Structures, 11th Edition (Y. Daniel Liang). 
 * Exercise 15_15.
 * (Geometry: add and remove points) Write a program that lets the user click on
 * a pane to dynamically create and remove points (see Figure 15.30a). When the
 * user left-clicks the mouse (primary button), a point is created and displayed
 * at the mouse point. The user can remove a point by pointing to it and rightclicking
 * the mouse (secondary button).
 * 
 * @author Almamy Bangoura
 * @version 3/3/24
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class AddRemovePoints extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane for drawing area.
        Pane pane = new Pane();

        // Create a label for instructions.
        Label label = new Label("Left-click to add a circle anywhere in the pane, right-click on it to remove it.");
        label.setFont(new Font(14));
        label.setStyle("-fx-background-color: yellow");
        
        // Create an hbox to hold the label.
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(label);
        
        // Create a border pane to hold both the pane and hbox.
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBox);
        borderPane.setCenter(pane);
        
        // Create and register event handlers.
        pane.setOnMousePressed(event1 -> {
            double radius = 5.0;
            
            // If the left mouse button was clicked...
            if(event1.getButton() == MouseButton.PRIMARY) {
                //... get the (x,y) coordinates of the mouse pointer...
                double x = event1.getX();
                double y = event1.getY();
                
                //... then draw a circle at that point.
                Circle circle = new Circle(x, y, radius);
                circle.setFill(Color.WHITE); // Set the color for the circle.
                circle.setStroke(Color.BLACK); // Set the circle's border color.
                
                // Add circle to the pane.
                pane.getChildren().add(circle);
                
                // Create and register an event handler for when the circle is right-clicked.
                circle.setOnMousePressed(event2 -> {
                    // If the right mouse button was pressed...
                    if(event2.getButton() == MouseButton.SECONDARY) {
                        //... remove the circle from the pane.
                        pane.getChildren().remove(circle);
                    }
                });
            }
            
        });
        
        
        
        // Create a scene and place it in the stage.
        Scene scene = new Scene(borderPane, 455, 250);
        primaryStage.setTitle("Add and Remove Points");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
