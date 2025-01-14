import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;





public class Setup 
{
    //classes
    private Option option = new Option();
    private GameSetup gameSetup = new GameSetup();

    //labels
    private Label easyLabel;
    private Label mediumLabel;
    private Label hardLabel;

    //fonts
    private Font labelFont = Font.font("Anton", FontWeight.BOLD, FontPosture.REGULAR, 40);
    private Font buttonFont = Font.font("Anton", FontWeight.BOLD, FontPosture.REGULAR, 20);
    private Font checkBoxFont = Font.font("Anton", FontWeight.BOLD, FontPosture.REGULAR, 15);

    //buttons
    private Button leftButton;
    private Button rightButton;
    private Button playButton;
    private CheckBox multiplayer;

    private Pane startPane = new Pane();  
    
    private Scene gameScene;

    
    private static boolean multiplayerSelected = false;

    

    public void chooseModePage()
    {
        //creates all the nodes in the scene
        leftButton = new Button("<-");
        rightButton = new Button("->");
        playButton = new Button("PLAY");
        multiplayer = new CheckBox("Multiplayer");

        easyLabel = new Label("Easy");
        mediumLabel = new Label("Medium");
        hardLabel = new Label("Hard");
       

        //Button_____________________________________________________________________
        playButton.setWrapText(true);
        playButton.setPrefSize(100, 70);
        playButton.setLayoutX(250);
        playButton.setLayoutY(330);
        playButton.setFont(buttonFont);

        //makes anonymous class
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            
            private Setup setup = new Setup();
            private Option option = new Option();
            private Main main = new Main();

            @Override
            public void handle(ActionEvent actionEvent)
            {
                //gets mode[], Stage and boolean mutiplayer
                setup.swichScene(option.modeSelected(), main.getPrimaryStage(), setup.getMultiplayerSelected());
            }
            
        });
        
        //_____________________________________________________________________
        leftButton.setWrapText(true);
        leftButton.setPrefSize(70, 40);
        leftButton.setLayoutX(30);
        leftButton.setLayoutY(260);
        //makes anonymous class
        leftButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //updates mode[]
                update(option.chanceMode(-1));
            }
            
        });
        //_____________________________________________________________________
        rightButton.setWrapText(true);
        rightButton.setPrefSize(70, 40);
        rightButton.setLayoutX(500);
        rightButton.setLayoutY(260);
        //makes anonymous class
        rightButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent actionEvent)
            {
                //updates mode[]
                update(option.chanceMode(1));
            }
            
        });
        //Labels_____________________________________________________________________
        easyLabel.setWrapText(true);
        easyLabel.setLayoutX(260);
        easyLabel.setLayoutY(150);
        easyLabel.setFont(labelFont);   
        

        mediumLabel.setWrapText(true);
        mediumLabel.setLayoutX(225);
        mediumLabel.setLayoutY(150);
        mediumLabel.setVisible(false);
        mediumLabel.centerShapeProperty();
        mediumLabel.setFont(labelFont);

        hardLabel.setWrapText(true);
        hardLabel.setLayoutX(256);
        hardLabel.setLayoutY(150);
        hardLabel.setVisible(false);
        hardLabel.centerShapeProperty();
        hardLabel.setFont(labelFont);
        //________________________________
        multiplayer.setLayoutX(370);
        multiplayer.setLayoutY(330);
        multiplayer.setFont(checkBoxFont);
        //makes anonymous class
        multiplayer.setOnAction(new EventHandler<ActionEvent>() {
            
            private Setup setup = new Setup();

            @Override
            public void handle(ActionEvent actionEvent)
            {
                //sets the muliplayer to true or false, when selected
                setup.setMultiplayerSelected(multiplayer.isSelected());
            }
            
        });
        //________________________________
        
        //adds all nodes to scene
        startPane.getChildren().addAll(leftButton,rightButton,playButton,
        easyLabel, mediumLabel, hardLabel,multiplayer);
    }

    public void update(Boolean[] modes)
    {
        //swiches the visability of the labels
        easyLabel.setVisible(modes[0]);
        mediumLabel.setVisible(modes[1]);
        hardLabel.setVisible(modes[2]);
    }

    public Pane getPane()
    {
        return startPane;
    }

    //swiches scens with GameSetup
    public void swichScene(int whatScene, Stage primaryStage, boolean multiplayer)
    {
        int gameSceneWidth = 600;
        int gameSceneHeight = 600;

        //makes games width twich as big + 5 pixes
        if(multiplayer)
        {
            gameSceneWidth = gameSceneWidth * 2 + 5;
        }

        //dicides what mode[] was selected and gets the scene from that mode
        switch (whatScene) {
            case 0:
                gameScene = new Scene(gameSetup.makeEasyPane(multiplayer),gameSceneWidth,gameSceneHeight);
                break;
            case 1:
                gameScene = new Scene(gameSetup.makeMediumPane(multiplayer),gameSceneWidth,gameSceneHeight);
                break;
            case 2:
                gameScene = new Scene(gameSetup.makeHardPane(multiplayer),gameSceneHeight,gameSceneWidth);
                break;
            default:
                break;
        }
       
        //swithes scenes
        primaryStage.setScene(gameScene);
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


}
