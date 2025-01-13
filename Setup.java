import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;





public class Setup implements EventHandler<ActionEvent>
{

    private Option option = new Option();

    private Label easyLabel;
    private Label mediumLabel;
    private Label hardLabel;

    private Font labelFont = Font.font("Anton", FontWeight.BOLD, FontPosture.REGULAR, 40);
    private Font buttonFont = Font.font("Anton", FontWeight.BOLD, FontPosture.REGULAR, 20);

    private Pane startPane = new Pane();  
    
    private Scene gameScene;

    private GameSetup gameSetup = new GameSetup();

    public void chooseModePage()
    {
        Button leftButton = new Button("<-");
        Button rightButton = new Button("->");
        Button playButton = new Button("PLAY");

        easyLabel = new Label("Easy");
        mediumLabel = new Label("Medium");
        hardLabel = new Label("Hard");
       

        //Button_____________________________________________________________________
        playButton.setWrapText(true);
        playButton.setPrefSize(100, 70);
        playButton.setLayoutX(350);
        playButton.setLayoutY(330);
        playButton.setFont(buttonFont);
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            
            private Setup setup = new Setup();
            private Option option = new Option();
            private Main main = new Main();

            @Override
            public void handle(ActionEvent actionEvent)
            {

                setup.swichScene(option.modeSelected(), main.getPrimaryStage());
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
        rightButton.setLayoutX(700);
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
        easyLabel.setLayoutX(360);
        easyLabel.setLayoutY(150);
        easyLabel.setFont(labelFont);   
        

        mediumLabel.setWrapText(true);
        mediumLabel.setLayoutX(325);
        mediumLabel.setLayoutY(150);
        mediumLabel.setVisible(false);
        mediumLabel.centerShapeProperty();
        mediumLabel.setFont(labelFont);

        hardLabel.setWrapText(true);
        hardLabel.setLayoutX(356);
        hardLabel.setLayoutY(150);
        hardLabel.setVisible(false);
        hardLabel.centerShapeProperty();
        hardLabel.setFont(labelFont);

        
        //________________________________
        
        startPane.getChildren().addAll(leftButton,rightButton,playButton,
        easyLabel, mediumLabel, hardLabel);
    }

    //fix!!!!!! behøves ikke men giver error
    @Override public void handle(ActionEvent actionEvent)
    {
       
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

    public void swichScene(int whatScene, Stage primaryStage)
    {
        System.out.println(whatScene);
        switch (whatScene) {
            case 0:
                gameScene = new Scene(gameSetup.makeEasyPane(),800,600);
                break;
            case 1:
                gameScene = new Scene(gameSetup.makeMediumPane(),800,600);
                break;
            case 2:
                gameScene = new Scene(gameSetup.makeHardPane(),800,600);
                break;
            default:
                break;
        }
       
        primaryStage.setScene(gameScene);
    }


}
