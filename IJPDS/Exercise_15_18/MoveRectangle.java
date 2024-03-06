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
        // Create a pane to draw the triangle on.
        Pane pane = new Pane();
        
        // Create a rectangle.
        Rectangle rectangle = new Rectangle(220, 170, 60, 30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        
        // Add rectangle to the pane.
        pane.getChildren().add(rectangle);
        
        // Create and register an event handler for when the rectangle is dragged.
        rectangle.setOnMouseDragged(e -> {
            // Center rectangle around tip of mouse pointer by...
            rectangle.setX(e.getX() - 30); //... substracting half the rectangle width from current mouse x coordinate...
            rectangle.setY(e.getY() - 15); //... and half the rectangle height from current mouse y coordinate.
        });
        
        // Create a scene and add it to a stage to be displayed.
        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("Move a Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
