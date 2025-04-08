import java.util.HashMap;
import java.util.Map;

public class TrafficController {

    Map<Integer, Road> roadMap;
    private static TrafficController trafficController;

    private TrafficController() {
        roadMap = new HashMap<>();
    }

    public synchronized static TrafficController getInstance() {
        if (trafficController == null) {
            trafficController = new TrafficController();
        }
        return trafficController;
    }

    public void addRoad(Road road) {
        roadMap.put(road.getId(), road);
    }

    public void removeRoad(int id) {
        roadMap.remove(id);
    }

    public void startTrafficControl() {
        for (Road road : roadMap.values()) {
            TrafficLight trafficLight = road.getTrafficLight();
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(trafficLight.getRedDuration());
                        trafficLight.changeSignal(Signal.GREEN);
                        Thread.sleep(trafficLight.getGreenDuration());
                        trafficLight.changeSignal(Signal.YELLOW);
                        Thread.sleep(trafficLight.getYellowDuration());
                        trafficLight.changeSignal(Signal.RED);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void handleEmergency(String roadId) {
        Road road = roadMap.get(roadId);
        if (road != null) {
            TrafficLight trafficLight = road.getTrafficLight();
            trafficLight.changeSignal(Signal.GREEN);
            // Perform emergency handling logic
            // ...
        }
    }
}
