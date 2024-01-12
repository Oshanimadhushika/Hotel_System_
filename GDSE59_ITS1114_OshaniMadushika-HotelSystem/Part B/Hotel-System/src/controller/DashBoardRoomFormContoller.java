package controller;

import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Room;
import view.tm.RoomTm;

import java.io.IOException;
import java.util.Optional;

public class DashBoardRoomFormContoller {
    public AnchorPane DashboardRoomContext;
    public TextField txtRoomNumber;
    public TextField txtFee;
    public ComboBox cmbRoomType;
    public TableView tblRooms;
    public TableColumn colRoomNumber;
    public TableColumn RoomType;
    public TableColumn ColFee;
    public TableColumn ColOption;
    public Button btnSaveandUpdate;


    public void initialize(){
        cmbRoomType.getItems().addAll("Single","Double","Thrible","Qued");

        colRoomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        RoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        ColFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        ColOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

       loadAllRooms();

       tblRooms.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           if(newValue!=null) {
               setData((RoomTm) newValue);
           }
       });


    }

     private void loadAllRooms(){
       ObservableList<RoomTm> observableList= FXCollections.observableArrayList();
        for (Room r: Database.roomsTable) {
            Button btn=new Button("Delete");
            RoomTm tm=new RoomTm(r.getRoomNumber(),r.getRoomType(),r.getFee(),btn);
            observableList.add(tm);

            btn.setOnAction(e->{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure",ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)) {
                    Database.roomsTable.remove(r);
                    observableList.remove(tm);
                }
            });
        }
        tblRooms.setItems(observableList);
    }

    public void addOnaction(ActionEvent actionEvent) {
        if(btnSaveandUpdate.getText().equals("+ Add Room")) {
            Room room = new Room(txtRoomNumber.getText(), (String) cmbRoomType.getValue(), txtFee.getText());

            Database.roomsTable.add(room);
            loadAllRooms();
        }else{
            for (Room tm:Database.roomsTable) {
                if(tm.getRoomNumber().equals(txtRoomNumber.getText())){
                    tm.setRoomType((String) cmbRoomType.getValue());
                    tm.setFee(txtFee.getText());
                    loadAllRooms();
                    return;
                }
            }
        }
    }

  private void setData(RoomTm tm){
        btnSaveandUpdate.setText("Update");
        txtRoomNumber.setText(tm.getRoomNumber());
        txtFee.setText(tm.getFee());
        cmbRoomType.setValue(tm.getRoomType());
  }

    public void addAnotherOnAction(ActionEvent actionEvent) {
        btnSaveandUpdate.setText("+ Add Room");
        txtRoomNumber.clear();
        txtFee.clear();
        cmbRoomType.setValue("");
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardAdmin");
    }
    private void setUI(String location) throws IOException {

        Stage stage = (Stage) DashboardRoomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }
}
