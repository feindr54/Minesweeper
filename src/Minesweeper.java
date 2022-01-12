import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    Square[][] board; // let there be 20 x 20 board, with 90 mines
    char[][] displayedBoard; // board that is seen by the user
    boolean gameOn, gameLost;
    int turnCount, flagCount;
    String playerMode;

    public Minesweeper(int rows, int columns, int mineCount) {
        Random random = new Random();
        board = new Square[rows][columns];
        displayedBoard = new char[rows][columns];
        gameOn = true;
        gameLost = false;
        turnCount = 0;
        flagCount = 0;
        playerMode = "dig";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new Square(i, j, false);
                displayedBoard[i][j] = 'x';
            }
        }

        // sets the mines on the board
        for (int i = 0; i < mineCount; i++) {
            int x, y = 0;
            do {
                x = random.nextInt(columns);
                y = random.nextInt(rows);
            } while (board[x][y].getMine()); // check if the current position already contains a mine

            // sets a mine at the current position
            board[x][y] = new Square(x, y,true);
        }

        // sets the numMinesAround for every square
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int numOfMines = 0;

                for (int a = -1; a <= 1; a++) {
                    for (int b = -1; b <= 1; b++) {
                        if (board[i + a] != null && board[i + a][j + b].getMine()) {
                            numOfMines++;
                        }
                    }
                }

                board[i][j].setNumMinesAround(numOfMines);
            }
        }
    }

    public void setFlagMode() {
        this.playerMode = "flag";
    }

    public void displayBoard() {
        System.out.println(Arrays.deepToString(displayedBoard));
    }

    public void resetBoard() {

    }

    public void selectSquare(Square[][] b, int row, int column) {
        if (b[row][column].getClicked()) {

        }

        // check if it's a mine, if so the player loses
        else if (ms.board[row][column].getMine()) {

        } else {
            ms.board[row][column].click();
            // if the numMinesAround is 0, open other squares (that are not mines) around it
            if (currentSq.getNumMinesAround() == 0) {
                for (int rows = -1; rows <= 1; rows++) {
                    for (int columns = -1; columns <= 1; columns++) {
                        if () {

                        }
                    }
                }
            }
        }
    }

    // method that checks for winning condition
    public boolean gameWon() {
        if () {
            for () {

            }
        }
    }



    public static void main(String[] args) {
        Minesweeper ms = new Minesweeper(20, 20, 90);
        Scanner sc = new Scanner(System.in);

        while (ms.gameOn) {
            // display board
            ms.displayBoard();
            // prompts user to unflag, flag or click a square
            System.out.println("Mode: " + ms.playerMode);
            System.out.println("Type the coords you would like to act upon.");

            // collect the coords
            int row = sc.nextInt();
            int column = sc.nextInt();
            sc.nextLine();

            Square currentSq = ms.board[row][column];

            if (ms.playerMode.equals("dig")) {
                // check if the tile is already clicked

            } else {
                ms.board[row][column].flag();
                ms.displayedBoard[row][column] = 'f';
            }

            if (ms.gameWon()) {
                // sends victory message
                // prompts if user wants to play again
            } else if (ms.gameLost) {
                // show the positions of the other mines
                // sends loss message
                // asks if the player wants to play again
            }
        }
    }
}
