package model;

public class House {

    private int price;
    private int squareMeters;
    private int numberOfRooms;
    private int numberOfHalls;

    public House(int price, int squareMeters, int numberOfRooms, int numberOfHalls) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.numberOfRooms = numberOfRooms;
        this.numberOfHalls = numberOfHalls;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfHalls() {
        return numberOfHalls;
    }

    public void setNumberOfHalls(int numberOfHalls) {
        this.numberOfHalls = numberOfHalls;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ": " +
                " price = " + getPrice()  +
                ", square meters = " + getSquareMeters() +
                ", halls = " + getNumberOfHalls() +
                ", rooms = " + getNumberOfRooms();
    }
}