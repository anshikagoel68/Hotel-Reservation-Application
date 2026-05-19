package model;

public class Room implements IRoom {

    private final String roomNumber;
    private final Double price;
    private final RoomType roomType;

  public Room(String roomNumber, Double price, RoomType roomType) {

    if (roomNumber == null || roomNumber.trim().isEmpty()) {
        throw new IllegalArgumentException("Room number cannot be empty.");
    }

    if (price < 0) {
        throw new IllegalArgumentException("Price must be positive.");
    }

    this.roomNumber = roomNumber;
    this.price = price;
    this.roomType = roomType;
}
    public String getRoomNumber() {
        return roomNumber;
    }
    public Double getRoomPrice() {
        return price;
    }
    public RoomType getRoomType() {
        return roomType;
    }
    public boolean isFree() {
        return price == 0;
    }
    public String toString() {
        return "Room Number: " + roomNumber +
                ", Price: " + price +
                ", Type: " + roomType;
    }
}