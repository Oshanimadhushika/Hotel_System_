package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class LoginForm1Controller {


    public AnchorPane LoginForm1Context;

    public void AdminLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm2");
    }

    public void ReseptionistLoginOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm3");
    }

    private void setUI(String location) throws IOException {

        Stage stage = (Stage) LoginForm1Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }

}
