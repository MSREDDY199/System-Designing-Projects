package main;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public boolean isSpotAvailable() {
        return vehicle == null;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if (isSpotAvailable() && vehicle.getVehicleType() == vehicleType) {
            this.vehicle = vehicle;
            return true;
        }
        return false;
    }

    public synchronized void unparkVehicle() {
        vehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
