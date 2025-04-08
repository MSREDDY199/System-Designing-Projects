public class Board {

    char[][] board;
    int totalMoves;

    public Board() {
        board = new char[3][3];
        totalMoves = 0;
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean isBoardFull() {
        return totalMoves == 9;
    }

    public void move(int i, int j, char symbol) {
        if (board[i][j] != '-') {
            return;
        }
        board[i][j] = symbol;
        totalMoves++;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean hasWinner() {
        // checking horizontally
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }

        // checking verticals
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        return board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0];
    }

}
