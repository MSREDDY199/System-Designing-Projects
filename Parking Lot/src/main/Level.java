package main;

import main.vehicles.Car;

import java.util.ArrayList;
import java.util.List;

public class Level {

    List<ParkingSpot> parkingSpots;
    int level;

    public Level(int level, int totalSpots) {
        this.level = level;
        parkingSpots = new ArrayList<>(totalSpots);

        int bikeSpots = (int) (totalSpots * 0.2);
        int carSpots = (int) (totalSpots * 0.6);
        int truckSpots = (int) (totalSpots * 0.2);

        for (int i=0; i<bikeSpots; i++) {
            parkingSpots.add(new ParkingSpot(i+1, VehicleType.BIKE));
        }

        for (int i=bikeSpots; i<carSpots+bikeSpots; i++) {
            parkingSpots.add(new ParkingSpot(i+1, VehicleType.CAR));
        }

        for (int i=bikeSpots+carSpots; i<truckSpots+bikeSpots+carSpots; i++) {
            parkingSpots.add(new ParkingSpot(i+1, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isSpotAvailable() && parkingSpot.getVehicleType() == vehicle.getVehicleType()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isSpotAvailable() && parkingSpot.getVehicle().equals(vehicle)) {
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + level + " Availability:");
        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isSpotAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }
}
