package app.visuel;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import app.breakout.Main;
import app.controller.Option;
import javafx.event.ActionEvent;


public class Setup 
{
    //classes
    private Option option = new Option();


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

    public void chooseModePage(int[] nm) 
    {

        System.out.println(nm[0] + " " + nm[1]);
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
            
            
            

            @Override
            public void handle(ActionEvent actionEvent)
            {
                Stage primaryStage = Main.getFirstStage();
                //gets mode[], Stage and boolean mutiplayer
                option.swichScene(option.modeSelected(), primaryStage, nm);
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

            @Override
            public void handle(ActionEvent actionEvent)
            {
                //sets the muliplayer to true or false, when selected
                option.setMultiplayerSelected(multiplayer.isSelected());
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
}
