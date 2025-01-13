import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application //implements EventHandler<ActionEvent>
{
    private static Stage firstStage;
    
    private Option option = new Option(); 
    private Setup setup = new Setup();

    private Scene scene;
  
    //The first Pane
    private Pane startPage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        //gets primaryStage
        firstStage = primaryStage;   
        
        //inisiates the first stage
        primaryStage.setTitle("Breakout");
        setup.chooseModePage();
        startPage = setup.getPane();
        scene = new Scene(startPage, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Stage getPrimaryStage()
    {
        return firstStage;
    }

}
