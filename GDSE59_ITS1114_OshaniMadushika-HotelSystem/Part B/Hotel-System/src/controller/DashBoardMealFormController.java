package controller;

import db.Database;
import db.DatabaseM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Meal;
import model.Room;
import view.tm.MealTm;
import view.tm.RoomTm;

import java.io.IOException;
import java.util.Optional;

public class DashBoardMealFormController {
   
    public AnchorPane DashboardMealContext;
    public TextField txtMealNumber;
    public TextField txtPrice;
    public Button btnSaveandUpdate;
    public ComboBox cmbMealName;
    public TableView tblMeal;
    public TableColumn colMealNumber;
    public TableColumn colMealName;
    public TableColumn ColPrice;
    public TableColumn ColOption;


    public void initialize() {
        cmbMealName.getItems().addAll("Fried Rice", "Kottu", "Burger", "Soup");

        colMealNumber.setCellValueFactory(new PropertyValueFactory<>("MealNumber"));
        colMealName.setCellValueFactory(new PropertyValueFactory<>("MealName"));
        ColPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        ColOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllMeals();

        tblMeal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData((MealTm) newValue);
            }
        });

    }
    private void loadAllMeals(){
        ObservableList<MealTm> observableList= FXCollections.observableArrayList();
        for (Meal m: DatabaseM.mealsTable) {
            Button btn=new Button("Delete");
            MealTm tm=new MealTm(m.getMealNumber(),m.getMealName(), m.getPrice(),btn);
            observableList.add(tm);

            btn.setOnAction(e->{
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure",ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)) {
                    DatabaseM.mealsTable.remove(m);
                    observableList.remove(tm);
                }
            });
        }
        tblMeal.setItems(observableList);
    }

    private void setData(MealTm tm){
        btnSaveandUpdate.setText("Update");
        txtMealNumber.setText(tm.getMealNumber());
        txtPrice.setText(tm.getPrice());
        cmbMealName.setValue(tm.getMealName());
    }
        public void addOnaction(ActionEvent actionEvent) {
            if(btnSaveandUpdate.getText().equals("+ Add Meal")) {
                Meal meal = new Meal(txtMealNumber.getText(), (String) cmbMealName.getValue(), txtPrice.getText());

                DatabaseM.mealsTable.add(meal);
                loadAllMeals();
            }else{
                for (Meal tm:DatabaseM.mealsTable) {
                    if(tm.getMealNumber().equals(txtMealNumber.getText())){
                        tm.setMealName((String) cmbMealName.getValue());
                        tm.setPrice(txtPrice.getText());
                        loadAllMeals();
                        return;
                    }
                }
            }
    }

    public void addAnotherOnAction(ActionEvent actionEvent) {
        btnSaveandUpdate.setText("+ Add Meal");
        txtMealNumber.clear();
        txtPrice.clear();
        cmbMealName.setValue("");
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUI("DashBoardAdmin");
    }
    private void setUI(String location) throws IOException {

        Stage stage = (Stage) DashboardMealContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));

    }
}
