public class Ship {
    int id;
    String shipName;
    int shipSize;
    int x_index;
    int y_index;

    public Ship(int id, String shipName, int x_index, int y_index, int shipSize) {
        this.id = id;
        this.shipName = shipName;
        this.x_index = x_index;
        this.y_index = y_index;
        this.shipSize = shipSize;
    }
}
