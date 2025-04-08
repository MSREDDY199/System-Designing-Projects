import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager gameManager;
    private List<Game> games;

    public GameManager() {
        games = new ArrayList<>();
    }

    public static synchronized GameManager getInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public void startNewGame(List<String> players) {
        Game game = new Game(players);
        games.add(game);
        new Thread(() -> game.play()).start();
    }
}
