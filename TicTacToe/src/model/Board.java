package model;


import java.util.ArrayList;
import java.util.List;

class Pair<I extends Number, I1 extends Number> {
    Integer A, B;

    Pair(Integer A, Integer B) {
        this.A = A;
        this.B = B;
    }
}

public class Board {

    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }


    public boolean addPiece(int row, int column, PlayingPiece piece) {
        if (board[row][column] != null) return false;
        board[row][column] = piece;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) System.out.print(board[i][j].pieceType.name() + " ");
                else System.out.print("  ");
                System.out.print(" | ");
            }
            System.out.println();
            System.out.print("+----+----+----+");
            System.out.println();
        }
    }

    public boolean areThereAnyFreeCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

}
