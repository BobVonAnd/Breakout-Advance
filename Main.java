import javafx.application.Application;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;;


public class Main extends Application 
{



    private GameSetup gameSetup = new GameSetup();

    public static void main(String[] args)
    {
        System.setProperty("glass.disableDpiScaling", "true");
        launch(args);
    }



    @Override
    public void start(Stage primaryStage)
    {
        //VBox.setVgrow(vboxGrey, Priority.ALWAYS);
        //HBox.setHgrow(vboxGrey, Priority.ALWAYS);
        

        gameSetup.drawStartGame();

        primaryStage.setTitle("Breakout");

        Pane test = new Pane();

        VBox vBox = new VBox();

        HBox hBox = new HBox();
        
        
        //block.getR().intersects(root.getBoundsInLocal());

        //delta time fix collider


        for(int i = 0; i < gameSetup.getWalls().length; i++)
        {
            test.getChildren().add(gameSetup.getWalls()[i].getWall());
        }
        test.getChildren().add(gameSetup.getBall().getCircle());
        
          



        Scene scene = new Scene(test, 800, 600);
        // primaryStage.setRenderScaleX(1.0);
        // primaryStage.setRenderScaleY(1.0);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }


    private void show()
    {
        
    }
}
