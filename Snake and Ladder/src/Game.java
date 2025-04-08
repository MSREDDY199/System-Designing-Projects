import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    List<Player> gamePlayers;
    Board board;
    int currentPlayerIndex;

    public Game(List<String> players) {
        gamePlayers = new ArrayList<>();
        board = new Board();
        for (int i = 0; i < players.size(); i++) {
            gamePlayers.add(new Player(players.get(i)));
        }
        currentPlayerIndex = 0;
    }

    public int throwDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public void play() {
        while(!isGameOver()) {
            Player currentPlayer = gamePlayers.get(currentPlayerIndex);
            int dice = throwDice();
            int newPosition = currentPlayer.getCurrentPosition() + dice;
            if (newPosition < board.getBoardSize()) {
                currentPlayer.setPosition(newPosition);
            }

            if (newPosition == board.getBoardSize()) {
                System.out.println(currentPlayer.getName()+" Wins!");
                break;
            }
            currentPlayerIndex = (currentPlayerIndex+1) % gamePlayers.size();
        }
    }

    private boolean isGameOver() {
        for (int i = 0; i < gamePlayers.size(); i++) {
            if (gamePlayers.get(i).getCurrentPosition() == board.getBoardSize()) {
                return true;
            }
        }
        return false;
    }
}
