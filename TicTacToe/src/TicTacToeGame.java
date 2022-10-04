import model.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TicTacToeGame {
    private Deque<Player> players;
    private Board gameBoard;

    TicTacToeGame() {
        initialiseGame();
    }

    private void initialiseGame() {

        players = new ArrayDeque<>();

        PlayingPieceX crossPiece = new PlayingPieceX(PieceType.X);
        Player player1 = new Player("Bharath", crossPiece);

        PlayingPieceO ovalPiece = new PlayingPieceO(PieceType.O);
        Player player2 = new Player("Ananth", ovalPiece);


        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }


    public String startGame() {

        boolean noWinner = true;
        Scanner sc = new Scanner(System.in);
        while (noWinner) {
            Player currentPlayer = players.removeFirst();
            gameBoard.printBoard();
            var areThereAnyFreeCells = gameBoard.areThereAnyFreeCells();
            if (!areThereAnyFreeCells) {
                noWinner = false;
                continue;
            }

            System.out.println(currentPlayer.getName() + ", please enter Row, Column in range [0, " + (gameBoard.size - 1) + "]!!");
            int row = sc.nextInt() % gameBoard.size;
            int column = sc.nextInt() % gameBoard.size;

            boolean pieceAddedSuccessfully = gameBoard.addPiece(row, column, currentPlayer.getPlayingPiece());
            if (!pieceAddedSuccessfully) {
                System.out.println("Position already Occupied!!");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);
            boolean winnerFound = isThereAWinner(row, column, currentPlayer.getPlayingPiece());

            if (winnerFound) {
                gameBoard.printBoard();
                return currentPlayer.getName();
            }


        }

        return "TIE";
    }

    private boolean isThereAWinner(int row, int column, PlayingPiece playingPiece) {
        boolean rowMatch = true, columnMatch = true, diagonalMatch = true, antiDiagonalMatch = true;

        //CHECK THE WHOLE ROW!
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i] != playingPiece) {
                rowMatch = false;
                break;
            }
        }


        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column] != playingPiece) {
                columnMatch = false;
                break;
            }
        }


        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != playingPiece) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != playingPiece) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}