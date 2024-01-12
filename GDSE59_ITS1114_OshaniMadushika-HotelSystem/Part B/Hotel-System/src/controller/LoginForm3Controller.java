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

import java.io.IOException;
import java.net.URL;

public class LoginForm3Controller {
    public PasswordField twtPassword;
    public TextField txtUserName;
    public AnchorPane LoginForm3Context;

    int plus=0;
    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {

       setUI("LoginForm1");
    }

    public void btnReseptionLoginOnAction(ActionEvent actionEvent) throws IOException {
        plus++;
        if (plus<=3) {
            String tempUserName = txtUserName.getText();
            String tempPassword = twtPassword.getText();
            if (tempUserName.equals("Iroshan") && tempPassword.equals("0322")) {
                setUI("DashBoardReseption");

            } else {
                new Alert(Alert.AlertType.WARNING, "Try again!").show();

            }
        }else{
            txtUserName.setEditable(false);
            twtPassword.setEditable(false);
        }
    }
    private void setUI(String location) throws IOException {

        Stage stage = (Stage) LoginForm3Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }
}
