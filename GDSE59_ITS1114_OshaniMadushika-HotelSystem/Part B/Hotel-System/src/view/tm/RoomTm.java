package view.tm;

import javafx.scene.control.Button;

public class RoomTm {
    private String roomNumber;
    private String roomType;
    private String fee;
    private Button btn;

    public RoomTm() {
    }

    public RoomTm(String roomNumber, String roomType, String fee, Button btn) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.fee = fee;
        this.btn = btn;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
