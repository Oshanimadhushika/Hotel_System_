package model;

public class Room {
    private String roomNumber;
    private String roomType;
    private String fee;

    public Room() {
    }

    public Room(String roomNumber, String roomType, String fee) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.fee = fee;
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
}
