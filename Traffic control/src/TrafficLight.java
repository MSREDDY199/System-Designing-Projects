public class TrafficLight {
    private int id;
    private Signal currentSignal;
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;

    public TrafficLight(int redDuration, int yellowDuration, int greenDuration) {
        id = getRandom();
        this.currentSignal = Signal.RED;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
    }

    public int getRandom() {
        return (int) System.currentTimeMillis()%Integer.MAX_VALUE;
    }

    public Signal getSignal() {
        return currentSignal;
    }

    public int getId() {
        return id;
    }

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void changeSignal(Signal signal) {
        this.currentSignal = signal;
    }
}
