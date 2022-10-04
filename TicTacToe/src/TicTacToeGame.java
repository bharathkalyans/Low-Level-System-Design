import model.*;

import java.util.ArrayDeque;
import java.util.Deque;

public class TicTacToeGame {
    private Deque<Player> players;
    private Board gameBoard;

    TicTacToeGame() {
        initialiseGame();
    }

    private void initialiseGame() {

        /*
        To traverse all symbols in an ENUM!, if required!
        PieceType[] allPieces = PieceType.values();
        for (PieceType p : allPieces){

        }*/

        players = new ArrayDeque<>();

        PlayingPieceX crossPiece = new PlayingPieceX(PieceType.X);
        Player player1 = new Player("Bharath", new PlayingPiece(PieceType.X));

        PlayingPieceO ovalPiece = new PlayingPieceO(PieceType.O);
        Player player2 = new Player("Ananth", ovalPiece);


        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }


    public String startGame() {

        return "";
    }
}