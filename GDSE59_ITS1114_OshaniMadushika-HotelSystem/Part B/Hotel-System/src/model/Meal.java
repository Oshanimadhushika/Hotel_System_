package model;

public class Meal {
    private String MealNumber;
    private String MealName;
    private String Price;


    public Meal() {
    }

    public Meal(String mealNumber, String mealName, String price) {
        this.MealNumber = mealNumber;
        this.MealName = mealName;
        this.Price = price;

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


}
