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
        int[] mn = new int[2];
        Parameters params = getParameters();
        List<String> args = params.getRaw();
        if(args.size() == 2)
        {
            for(int i = 0; i < 2; i++)
            {
                mn[i] = Integer.parseInt(args.get(i)); 
            }
        }
        else
        {
            mn[0] = 2;
            mn[1] = 2; 
        }

        if(!(mn[0] <= 10 && mn[0] >= 1) && !(mn[1] <= 20 && mn[1] <= 5))
        {
            System.out.println("Error: n and m needs to be within (1-10) for n, and (5-20) for m");
        }
        else
        {
            firstStage = primaryStage;      
        
            // Initiate the first stage
            firstStage.setTitle("Breakout");
            setup.chooseModePage(mn);
            startPage = setup.getPane();
            scene = new Scene(startPage, 600, 600);
            firstStage.setScene(scene);
            firstStage.show();
        
            // Initializes background music 
            mediaPlayer = new MediaPlayer(new Media(Paths.get("app/BeepBox-Song.wav").toUri().toString()));
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 
            //mediaPlayer.play();  
        }
    }

    public static Stage getFirstStage()
    {
        return firstStage;
    }
}
