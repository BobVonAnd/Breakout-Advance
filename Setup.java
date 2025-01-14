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

    private Option option = new Option();
    private GameSetup gameSetup = new GameSetup();

    private Label easyLabel;
    private Label mediumLabel;
    private Label hardLabel;

    private Font labelFont = Font.font("Anton", FontWeight.BOLD, FontPosture.REGULAR, 40);
    private Font buttonFont = Font.font("Anton", FontWeight.BOLD, FontPosture.REGULAR, 20);
    private Font checkBoxFont = Font.font("Anton", FontWeight.BOLD, FontPosture.REGULAR, 15);

    private Button leftButton;
    private Button rightButton;
    private Button playButton;
    private CheckBox multiplayer;

    private Pane startPane = new Pane();  
    
    private Scene gameScene;

    private static boolean multiplayerSelected = false;

    

    public void chooseModePage()
    {
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
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            
            private Setup setup = new Setup();
            private Option option = new Option();
            private Main main = new Main();

            @Override
            public void handle(ActionEvent actionEvent)
            {
                setup.swichScene(option.modeSelected(), main.getPrimaryStage(), setup.getMultiplayerSelected());
            }
            
        });
        
        //_____________________________________________________________________
        leftButton.setWrapText(true);
        leftButton.setPrefSize(70, 40);
        leftButton.setLayoutX(30);
        leftButton.setLayoutY(260);
        leftButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent actionEvent)
            {
                update(option.chanceMode(-1));
            }
            
        });
        //_____________________________________________________________________
        rightButton.setWrapText(true);
        rightButton.setPrefSize(70, 40);
        rightButton.setLayoutX(500);
        rightButton.setLayoutY(260);
        rightButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent actionEvent)
            {
                update(option.chanceMode(1));
            }
            
        });
        //Label_____________________________________________________________________
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
        multiplayer.setOnAction(new EventHandler<ActionEvent>() {
            
            private Setup setup = new Setup();
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println(multiplayer.isSelected()); 
                setup.setMultiplayerSelected(multiplayer.isSelected());
            }
            
        });
        //________________________________
        
        startPane.getChildren().addAll(leftButton,rightButton,playButton,
        easyLabel, mediumLabel, hardLabel,multiplayer);
    }


    public void update(Boolean[] modes)
    {
        easyLabel.setVisible(modes[0]);
        mediumLabel.setVisible(modes[1]);
        hardLabel.setVisible(modes[2]);
    }

    public Pane getPane()
    {
        return startPane;
    }

    public void swichScene(int whatScene, Stage primaryStage, boolean multiplayer)
    {
        int gameSceneWidth = 600;
        int gameSceneHeight = 600;
        System.out.println(multiplayer);
        if(multiplayer)
        {
            gameSceneWidth = gameSceneWidth * 2 + 5;
        }

        System.out.println(whatScene);
        switch (whatScene) {
            case 0:
                gameScene = new Scene(gameSetup.makeEasyPane(),gameSceneWidth,gameSceneHeight);
                break;
            case 1:
                gameScene = new Scene(gameSetup.makeMediumPane(),gameSceneWidth,gameSceneHeight);
                break;
            case 2:
                gameScene = new Scene(gameSetup.makeHardPane(),gameSceneHeight,gameSceneWidth);
                break;
            default:
                break;
        }
       
        primaryStage.setScene(gameScene);
    }

    public void setMultiplayerSelected(boolean clicked)
    {
        multiplayerSelected = clicked;
        System.out.println(clicked);
    }
    public boolean getMultiplayerSelected()
    {
        return multiplayerSelected;
    }


}
