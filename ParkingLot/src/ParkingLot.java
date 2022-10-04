package parkinglot;

import java.util.List;
import java.util.Map;

public class ParkingLot {

    private String nameOfParkingLot;
    private Address address;

    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;

    private ParkingLot(String nameOfParkingLot,
                       Address address,
                       List<ParkingFloor> parkingFloors) {

        this.nameOfParkingLot = nameOfParkingLot;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }


    public static ParkingLot getInstance(String nameOfParkingLot,
                                         Address address,
                                         List<ParkingFloor> parkingFloors) {
        if (parkingLot == null)
            parkingLot = new ParkingLot(nameOfParkingLot, address, parkingFloors);

        return parkingLot;
    }

    public void addFloors(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkSlots) {
        ParkingFloor parkingFloor = new ParkingFloor(name, parkSlots);
        parkingFloors.add(parkingFloor);
    }




}
