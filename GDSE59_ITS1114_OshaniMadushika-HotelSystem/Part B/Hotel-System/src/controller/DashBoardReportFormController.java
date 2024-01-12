package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardReportFormController {
    public AnchorPane ReportContext;

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardAdmin");
    }
    private void setUI(String location) throws IOException {

        Stage stage = (Stage) ReportContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }
}
