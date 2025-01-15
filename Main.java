import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.nio.file.Paths;

public class Main extends Application 
{
    private static Stage firstStage;
    private Setup setup = new Setup();
    private Scene scene;
    private Pane startPage;
    private MediaPlayer mediaPlayer;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        firstStage = primaryStage;   
        
        // Initiate the first stage
        primaryStage.setTitle("Breakout");
        setup.chooseModePage();
        startPage = setup.getPane();
        scene = new Scene(startPage, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Initializes background music 
        mediaPlayer = new MediaPlayer(new Media(Paths.get("BeepBox-Song.wav").toUri().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 
        mediaPlayer.play();  
    }

    public Stage getPrimaryStage()
    {
        return firstStage;
    }
}
