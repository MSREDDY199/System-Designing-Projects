//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ship shipA = new Ship(1, "Ship A", 2, 2,2);
        Ship shipB = new Ship(2, "Ship B", 5, 5,2);
        Player playerA = new Player(1, "PlayerA", shipA);
        Player playerB = new Player(2, "PlayerB", shipA);


    }
}