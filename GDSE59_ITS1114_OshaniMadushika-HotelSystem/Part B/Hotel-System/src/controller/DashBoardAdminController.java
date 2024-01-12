package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoardAdminController {
    public AnchorPane DashBoardAdminContext;

    public void ROOMSOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardRoomForm");
    }

    public void MEALPACKAGEOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardMealForm");
    }

    public void INCOMEREPORTOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardReportForm");
    }

    public void BACKOnAction(ActionEvent actionEvent) throws IOException {
       setUI("LoginForm2");
    }
    private void setUI(String location) throws IOException {

        Stage stage = (Stage) DashBoardAdminContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }
}
