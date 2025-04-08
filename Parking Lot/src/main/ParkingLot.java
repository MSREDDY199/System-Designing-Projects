package main;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static List<Level> levels;
    private static ParkingLot parkingLot;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Parked Vehicle Successfully");
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unParkVehicle(vehicle)) {
                System.out.println("Unparked Vehicle Successfully");
                return true;
            }
        }
        System.out.println("Could not Unpark vehicle");
        return false;
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }

    public void addLevel(Level level) {
        levels.add(level);
    }
}
