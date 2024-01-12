import com.sun.xml.internal.ws.api.client.SelectOptimalEncodingFeature;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class MainFormController {
    public TextField txt;

    public void ClickmeOnAction(ActionEvent actionEvent) {
        System.out.println(txt.getText());
    }
}
