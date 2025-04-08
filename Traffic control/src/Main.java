//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TrafficController trafficController = TrafficController.getInstance();

        // Create roads
        Road road1 = new Road("R1");
        Road road2 = new Road("R2");
        Road road3 = new Road("R3");
        Road road4 = new Road("R4");

        // Create traffic lights
        TrafficLight trafficLight1 = new TrafficLight(6000, 3000, 9000);
        TrafficLight trafficLight2 = new TrafficLight(6000, 3000, 9000);
        TrafficLight trafficLight3 = new TrafficLight(6000, 3000, 9000);
        TrafficLight trafficLight4 = new TrafficLight(6000, 3000, 9000);

        // Assign traffic lights to roads
        road1.setTrafficLight(trafficLight1);
        road2.setTrafficLight(trafficLight2);
        road3.setTrafficLight(trafficLight3);
        road4.setTrafficLight(trafficLight4);

        // Add roads to the traffic controller
        trafficController.addRoad(road1);
        trafficController.addRoad(road2);
        trafficController.addRoad(road3);
        trafficController.addRoad(road4);

        // Start traffic control
        trafficController.startTrafficControl();
        System.out.println(road1.getTrafficLight().getCurrentSignal());
        Thread.sleep(10000);
        System.out.println(road1.getTrafficLight().getCurrentSignal());

        // Simulate an emergency on a specific road
        trafficController.handleEmergency("R2");
    }
}