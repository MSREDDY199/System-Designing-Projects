import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        List<String> players = Arrays.asList("Shanmukh", "Haarish", "Leah");
        gameManager.startNewGame(players);

        gameManager.startNewGame(players);
    }
}