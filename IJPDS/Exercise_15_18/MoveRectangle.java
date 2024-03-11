/**
 * @author Almamy Bangoura
 * @version 5/3/24
 * 
 * Instructions in readme file.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MoveRectangle extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane to draw the rectangle on.
        Pane pane = new Pane();
        
        // Create a rectangle.
        Rectangle rectangle = new Rectangle(220, 170, 60, 30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        
        // Add rectangle to the pane.
        pane.getChildren().add(rectangle);
        
        // Create and register an event handler for when the rectangle is dragged.
        rectangle.setOnMouseDragged(e -> {
            // Check the pane boundaries to keep the rectangle within.
            // Left hand of the main && operator checks for boundaries on the x-axis,
            // and the right hand checks for boundaries along the y-axis.
            if(((e.getX() > 0) && ((e.getX()) <= pane.getWidth())) && ((e.getY() > 0) && (e.getY() <= pane.getHeight()))) {
                rectangle.setX(e.getX() - 30); // Center rectangle at x-coordinate and ...
                rectangle.setY(e.getY() - 15); //... y-coordinate of mouse pointer.
            }
        });
        
        // Create a scene and add it to a stage to be displayed.
        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("Move a Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
