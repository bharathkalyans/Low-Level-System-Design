import Strategy.DriveStrategy;
import Strategy.NormalDriveStrategy;
import Strategy.SpecialDriveStrategy;

public class Vehicle {
    DriveStrategy object;

    // CONSTRUCTOR INJECTION!
    public Vehicle(DriveStrategy object) {
        this.object = object;
    }

    public String drive() {
        return object.drive();
    }

}


class SportVehicle extends Vehicle {

    public SportVehicle() {
        super(new SpecialDriveStrategy());
    }
}


class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle() {
        super(new NormalDriveStrategy());
    }
}