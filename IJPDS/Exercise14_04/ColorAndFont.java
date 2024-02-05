import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ColorAndFont extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the text nodes.
        Pane pane = new Pane();
        
        // Run a for-loop and set the texts in random colors and other properties.
        // x and y represent the (x,y) coordinates of the starting point for the text.
        for(int i = 0, x = 0, y = 60; i < 5; i++, x += 50) {
            //A random color.
            Color color = new Color(Math.random(), Math.random(), Math.random(), Math.random());
            
            // Text to display.
            Text text = new Text(x, y, "JavaFX");
            text.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 24)); // Set text font, font weight, posture and size.
            text.setRotate(90);
            text.setFill(color);
            
            pane.getChildren().add(text); // Add text node to the pane.
        }
        
        // Place the pane in a scene, then the scene in a stage.
        Scene scene = new Scene(pane, 270, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Color and font.");
        primaryStage.show(); // Display the stage.
    }
}