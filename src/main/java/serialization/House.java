package serialization;

import java.util.List;

public class House {
    private String address;
    private boolean garden;
    private boolean garage;
    private List<Room> rooms;

    public House() {
    }

    public House(String address, boolean garden, boolean garage, List<Room> rooms) {
        this.address = address;
        this.garden = garden;
        this.garage = garage;
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
