package model;

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
        for (PlayingPiece[] playingPieces : board) {
            System.out.print("| ");
            for (PlayingPiece playingPiece : playingPieces) {
                if (playingPiece != null) System.out.print(playingPiece.pieceType.name() + " ");
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
