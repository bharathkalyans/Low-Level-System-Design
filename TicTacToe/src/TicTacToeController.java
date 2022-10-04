public class TicTacToeController {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        String winner = game.startGame();
        if (winner.equals("TIE")) System.out.println("It's a TIE!! 😭");
        else System.out.println("Congratulations, " + winner + " you have WON! 🥳");
    }
}
