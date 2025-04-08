import java.util.ArrayList;
import java.util.List;

public class Board {
    private static int boardSize = 100;
    private List<Snakes> snakesList;
    private List<Ladders> laddersList;

    public Board() {
        snakesList = new ArrayList<>();
        laddersList = new ArrayList<>();
        addLadders();
        addSnakes();
    }

    public void addSnakes() {
        snakesList.add(new Snakes(40, 3));
        snakesList.add(new Snakes(43, 18));
        snakesList.add(new Snakes(99, 41));
        snakesList.add(new Snakes(95, 77));
        snakesList.add(new Snakes(89, 53));
        snakesList.add(new Snakes(54, 31));
        snakesList.add(new Snakes(27, 5));
        snakesList.add(new Snakes(66, 45));
    }

    public void addLadders() {
        laddersList.add(new Ladders(62, 81));
        laddersList.add(new Ladders(42, 63));
        laddersList.add(new Ladders(4, 25));
        laddersList.add(new Ladders(13, 46));
        laddersList.add(new Ladders(33, 49));
        laddersList.add(new Ladders(50, 69));
        laddersList.add(new Ladders(74, 92));
    }

    public int getPositionOfSnakeOrLadder (int position) {
        for (int i = 0; i < snakesList.size(); i++) {
            if (snakesList.get(i).getStart() == position) {
                return snakesList.get(i).getEnd();
            }
        }

        for (int i = 0; i < laddersList.size(); i++) {
            if (laddersList.get(i).getStart() == position) {
                return laddersList.get(i).getEnd();
            }
        }
        return position;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
