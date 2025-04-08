public class Road {
    private int id;
    private String roadName;
    private TrafficLight trafficLight;

    public Road(String roadName) {
        id = getRandom();
        this.roadName = roadName;
    }

    public int getRandom() {
        return (int) System.currentTimeMillis() % Integer.MAX_VALUE;
    }

    public String getRoadName() {
        return roadName;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public int getId() {
        return id;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }
}
