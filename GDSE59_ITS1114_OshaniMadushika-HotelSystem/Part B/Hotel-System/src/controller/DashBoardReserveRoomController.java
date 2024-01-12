package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardReserveRoomController {
    public AnchorPane ReserveRoomContext;
    public TextField txtAddName;
    public TextField txtEmail;
    public TextField txtNic;
    public TextField txtAddress;
    public TextField txtTp;
    public TextField txtTotalRoom;
    public TextField txtBooking;
    public TextField txtAvailable;
    public TextField txtMeal;
    public TextField txtQuantity;
    public TextField txtPrice;

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardReseption");
    }
    private void setUI(String location) throws IOException {

        Stage stage = (Stage) ReserveRoomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }
}
