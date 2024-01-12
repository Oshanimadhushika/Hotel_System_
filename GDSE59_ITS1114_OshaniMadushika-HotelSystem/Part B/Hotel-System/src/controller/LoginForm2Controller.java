package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class LoginForm2Controller {

    public PasswordField twtPassword;
    public TextField txtUserName;
    public AnchorPane LoginForm2Context;

    int attemts=0;

    public void btnAdminLoginOnAction(ActionEvent actionEvent) throws IOException {
        attemts++;
        if (attemts<=3) {
            String tempUserName = txtUserName.getText();
            String tempPassword = twtPassword.getText();
            if (tempUserName.equals("Oshani") && tempPassword.equals("0305")) {
                setUI("DashBoardAdmin");

            } else {
                new Alert(Alert.AlertType.WARNING, "Try again!").show();

            }
        }else{
            txtUserName.setEditable(false);
            twtPassword.setEditable(false);
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {
       setUI("LoginForm1");
    }
    private void setUI(String location) throws IOException {

        Stage stage = (Stage) LoginForm2Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }
}
