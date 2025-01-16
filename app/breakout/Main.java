package app.breakout;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.nio.file.Paths;
import java.util.List;

import app.visuel.Setup;


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
        /* 
        int[] mn = new int[2];

        Parameters params = getParameters();
        List<String> args = params.getRaw();
        for(int i = 0; i < 2; i++)
        {
            mn[i] = Integer.parseInt(args.get(i)); 
        }

        if(mn.length == 0)
        {
            mn[0] = 5;
            mn[1] = 5; 
        }
        */

        firstStage = primaryStage;   
        
        // Initiate the first stage
        primaryStage.setTitle("Breakout");
        setup.chooseModePage(new int[2]);
        startPage = setup.getPane();
        scene = new Scene(startPage, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Initializes background music 
        mediaPlayer = new MediaPlayer(new Media(Paths.get("BeepBox-Song.wav").toUri().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 
        //mediaPlayer.play();  
    }

    public Stage getPrimaryStage()
    {
        return firstStage;
    }
}
