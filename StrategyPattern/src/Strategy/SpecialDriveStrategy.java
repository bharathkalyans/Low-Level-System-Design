package Strategy;

public class SpecialDriveStrategy implements DriveStrategy {

    @Override
    public String drive() {
        System.out.println("Special Driving!!");
        return "Special Driving!!";
    }
}
