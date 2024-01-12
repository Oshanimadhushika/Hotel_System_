package view.tm;

import javafx.scene.control.Button;

public class MealTm  {
    private String MealNumber;
    private String MealName;
    private String Price;
    private Button btn;

    public MealTm() {
    }

    public MealTm(String mealNumber, String mealName, String price, Button btn) {
        this.MealNumber = mealNumber;
        this.MealName = mealName;
        this.Price = price;
        this.btn = btn;
    }

    public String getMealNumber() {
        return MealNumber;
    }

    public void setMealNumber(String mealNumber) {
        MealNumber = mealNumber;
    }

    public String getMealName() {
        return MealName;
    }

    public void setMealName(String mealName) {
        MealName = mealName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
