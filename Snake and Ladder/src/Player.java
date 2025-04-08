public class Player {
    String name;
    int currentPosition;

    public Player (String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setPosition(int position) {
        this.currentPosition = position;
    }
}
