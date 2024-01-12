package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoardReseptionController {
    public AnchorPane DashBoardReseptionContext;


    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm3");
    }

    public void ReserveARoomOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardReserveRoom");
    }

    public void MarkMaintenanceOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardMaintenance");
    }
    private void setUI(String location) throws IOException {

        Stage stage = (Stage) DashBoardReseptionContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }
}
