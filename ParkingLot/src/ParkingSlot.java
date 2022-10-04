package parkinglot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    String name;
    boolean isAvailable = true;
    Vehicle vehicle;

    ParkingSlotType parkingSlotType;

    public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    protected void addVehicle(Vehicle vehicle) {
        this.isAvailable = false;
        this.vehicle = vehicle;
    }

    protected void removeVehicle() {
        this.isAvailable = true;
        this.vehicle = null;
    }

}
