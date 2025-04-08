//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User player1 = new User("Shanmukh", 'X');
        User player2 = new User("Haarish", 'O');

        Board board = new Board();
        Game game = new Game(player1, player2);
        game.play();
    }
}