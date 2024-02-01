/* 
    Exercise to display a Tic-Tac-Toe board with random X and O gif images or a blank tile.   
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class TicTacToe_14_1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        int randomValue; //To help determine a random image.
        final int GRID_SIZE = 3; //3x3 grid.
        
        //Knowing the Tic-Tac-Toe is a 3x3 board,
        //we can set up a GridPane to add the different images to.
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(15);
        pane.setVgap(15);
        pane.setPrefSize(900, 900);
        
        for(int column = 0; column < GRID_SIZE; column++) {
            for(int row = 0; row < GRID_SIZE; row++) {
                //Get a random image and add it to the cell determined by [column, row];
                randomValue = (int)(Math.random() * 3);
                
                switch(randomValue) {
                    case 0:
                        pane.add(new ImageView("O.gif"), column, row); // 'O' cell.
                        break;
                    case 1:
                        pane.add(new ImageView("X.gif"), column, row); // 'X' cell.
                        break;
                    case 2:
                        pane.add(new ImageView(), column, row); // Empty cell.
                        break;
                    default:
                        break;
                }
                
            }
        }
        
        //Create a Scene. Place it in Stage. Display the stage.
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
