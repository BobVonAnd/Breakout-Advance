import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Controller implements EventHandler<ActionEvent>
{
    @Override public void handle(ActionEvent actionEvent)
    {
        System.out.println("bob");
    }
}
