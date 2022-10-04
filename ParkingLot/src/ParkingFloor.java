package parkinglot;

import java.util.Map;

public class ParkingFloor {
    String floorName;
    Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    public ParkingFloor(String floorName,
                        Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.floorName = floorName;
        this.parkingSlots = parkingSlots;
    }


    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        Map<String, ParkingSlot> relevantParkingSlot = parkingSlots.get(parkingSlotType);

        ParkingSlot slot = null;

        for (Map.Entry<String, ParkingSlot> mm : relevantParkingSlot.entrySet()) {
            if (mm.getValue().isAvailable()) {
                slot = mm.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }

        return slot;
    }

    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory) {
        if (vehicleCategory.equals(VehicleCategory.TwoWheeler))
            return ParkingSlotType.TwoWheeler;
        else if (vehicleCategory.equals(VehicleCategory.SUV) || vehicleCategory.equals(VehicleCategory.Sedan))
            return ParkingSlotType.Compact;
        else if (vehicleCategory.equals(VehicleCategory.HatchBack))
            return ParkingSlotType.Medium;
        else if (vehicleCategory.equals(VehicleCategory.Bus))
            return ParkingSlotType.Large;

        return null;
    }


}
