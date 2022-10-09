package Strategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public String drive() {
        System.out.println("Driving Normally!");
        return "Driving Normally!";
    }
}
