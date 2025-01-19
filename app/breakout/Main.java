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
    
    //starts javafx
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //gets nm form args
        int[] nm = new int[2];
        Parameters params = getParameters();
        List<String> args = params.getRaw();
        //checks if args has the right size og 2
        if(args.size() == 2)
        {
            for(int i = 0; i < 2; i++)
            {
                nm[i] = Integer.parseInt(args.get(i)); 
            }
        }
        else
        {
            nm[0] = 4;
            nm[1] = 7; 
        }
        //checks if nm has the right values 
        if(!(nm[0] <= 10 && nm[0] >= 1) && !(nm[1] <= 20 && nm[1] <= 5))
        {
            System.out.println("Error: n and m needs to be within (1-10) for n, and (5-20) for m");
        }
        else
        {
            // Initiate the first stage with scene from setup
            firstStage = primaryStage;      
            firstStage.setTitle("Breakout");
            setup.chooseModePage(nm);
            startPage = setup.getPane();
            scene = new Scene(startPage, 600, 600);
            firstStage.setScene(scene);
            firstStage.show();
        
            // Initializes background music 
            mediaPlayer = new MediaPlayer(new Media(Paths.get("BeepBox-Song.wav").toUri().toString()));
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 
            mediaPlayer.play();  
        }
    }

    public static Stage getFirstStage()
    {
        return firstStage;
    }
}
