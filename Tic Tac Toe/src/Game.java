import java.util.Scanner;

public class Game {

    public User player1;
    public User player2;
    public User currentPlayer;
    public Board board;

    public Game(User player1, User player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        board = new Board();
        board.initializeBoard();
    }

    public void play() {
        while (!board.isBoardFull() && !board.hasWinner()) {

            int row = getInput();
            int col = getInput();

            board.move(row, col, currentPlayer.getSymbol());
            switchPlayer();
            board.printBoard();
            System.out.println();
        }

        if (board.hasWinner()) {
            switchPlayer();
            System.out.println(currentPlayer.getName()+" has won the game!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public int getInput() {
        System.out.print(currentPlayer.getName()+": ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
