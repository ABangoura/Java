import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class RectanglePane extends Application {
    private Rectangle rectangle;
    private double x = 150; // x value for the rectangle's (x,y) coordinates.
    private double y = 150; // y value for the rectangle's (x,y) coordinates.
    
    // Add doc-style comments!!
    
    @Override
    public void start(Stage primaryStage) {
        // Create a rectangle and place it in a pane.
        rectangle = new Rectangle(x, y, 300, 150);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        
        Pane pane = new Pane(rectangle);
        
        // Create a HBox to hold the control buttons.
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        
        // Create buttons and place them in the HBox.
        Button btnLeft = new Button("Left");
        Button btnRight = new Button("Right");
        Button btnUp = new Button("Up");
        Button btnDown = new Button("Down");
        hBox.getChildren().addAll(btnLeft, btnRight, btnUp, btnDown);
        
        // Create and register the different event handlers for the buttons.
        // Move rectangle left.
        btnLeft.setOnAction(e -> {
            rectangle.setX(rectangle.getX() - 5);
        });
        
        // Move Rectangle right.
        btnRight.setOnAction(e -> {
            rectangle.setX(rectangle.getX() + 5);
        });
        
        // Move rectangle up.
        btnUp.setOnAction(e -> {
            rectangle.setY(rectangle.getY() - 5);
        });
        
        // Move rectangle down.
        btnDown.setOnAction(e -> {
            rectangle.setY(rectangle.getY() + 5);
        });
        
        // Create a BorderPane instance to hold the pane and hBox.
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        
        // Create a scene and place borderPane in it.
        Scene scene = new Scene(borderPane, 600, 500);
        
        // Set up the primaryStage to display the scene.
        primaryStage.setTitle("Exercise 15.03");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
}