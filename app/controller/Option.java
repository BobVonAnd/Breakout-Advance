package app.controller;
import app.visuel.GameSetup;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Option 
{

     

    //indicates what mode[] is selected
    private static int whatMode = 0;

    //Easy, Medium, Hard, Costem.
    private static Boolean[] mode = new Boolean[] {true, false, false};
    private static boolean multiplayerSelected = false;

    private static Scene gameScene;
    

    //chances value of mode[] and returns it
    public Boolean[] chanceMode(int arrowHit)
    {
        mode[whatMode] = false;
        whatMode = whatMode + arrowHit;
        
        if(whatMode < 0)
        {
            whatMode = mode.length-1;
        }
        else if(whatMode > mode.length-1)
        {
            whatMode = 0;
        }
        mode[whatMode] = true;
        return mode;
    }

    //checks what mode[] is true and returns it as an int.
    public int modeSelected()
    {
        int sendBool = 0;

        //find what i is true
        for(int i = 0; i < mode.length; i++)
        {
            if(mode[i])
            {
                sendBool = i;
            }
        }
        return sendBool;
    }


    //swiches scens with GameSetup
    public void swichScene(int whatScene, Stage primaryStage, int[] mn)
    {
        int gameSceneWidth = 600;
        int gameSceneHeight = 600;

        //makes games width twich as big + 5 pixes
        if(multiplayerSelected)
        {
            gameSceneWidth = gameSceneWidth * 2 + 5;
        }

        GameSetup gameSetup = new GameSetup(gameSceneWidth, gameSceneHeight, multiplayerSelected, mn);
       
        //swithes scenes
        switch (whatScene) {
            case 0:
                primaryStage.setScene(gameSetup.makeEasyPane());
                break;
        
            default:
                break;
        }
        
        Game game = new Game(gameSetup.getBlocks(), gameSetup.getPlatform(), gameSetup.getBall());
        
    }

    
    //swiches between true or false when checkbox is clicked
    public void setMultiplayerSelected(boolean clicked)
    {
        multiplayerSelected = clicked;
    }

    public boolean getMultiplayerSelected()
    {
        return multiplayerSelected;
    }

    public Scene getGamScene()
    {
        return gameScene;
    }
   

}
